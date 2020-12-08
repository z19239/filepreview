package cn.keking.service.database.easyexcel.impl;

import cn.keking.mapper.BaseProcessDrawingsExtMapper;
import cn.keking.model.ext.DraweNoDTO;
import com.aspose.cad.internal.aa.T;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.junrar.exception.RarException;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Service
public class TheardQueryService {

    private final Logger logger = LoggerFactory.getLogger(TheardQueryService.class);



    static class SqlHadle{
        @Autowired
        private BaseProcessDrawingsExtMapper baseProcessDrawingsExtMapper;

        public List querySql(int bindex, int num) {
            List<DraweNoDTO> draweNoDTOS=baseProcessDrawingsExtMapper.queryByDraweNo(bindex,num);
            return draweNoDTOS;
        }
        public int count() {
            int  count=baseProcessDrawingsExtMapper.queryDraweNoCount();
            return count;
        }
    }

    class ThredQuery implements Callable<List> {


        SqlHadle sqlHadle=new SqlHadle();

        //private String search;//查询条件 根据条件来定义该类的属性

        private int bindex;//当前页数

        private int num;//每页查询多少条

        //private String table;//要查询的表名，也可以写死，也可以从前面传

        private List page;//每次分页查出来的数据

        public  ThredQuery(int bindex,int num) {
            this.bindex=bindex;
            this.num=num;
            //分页查询数据库数据
            page=sqlHadle.querySql(bindex,num);
        }

        @Override
        public List call() throws Exception {
            //返回数据给Future
            return page;
        }
    }

    @PostConstruct
    @Scheduled(cron = "0 0/1 * * * ?")//每1分钟跟新一次数据理论上的数据无延时
    public void startTask() throws ExecutionException, InterruptedException {
        logger.info("线程数据初始化开始！");
        List<List> lists= getMaxResult();
        System.out.println(lists.size());
        logger.info("线程数据初始化完成！");
    }


    SqlHadle sqlHadle=new SqlHadle();

    public List<List> getMaxResult() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();//开始时间
        List<List> result = new ArrayList<>();//返回结果
        //查询数据库总数量
        int count = sqlHadle.count();
        int num = 50000;//一次查询多少条
        //需要查询的次数
        int times = count / num;
        int counts=0;
        if (count % num != 0) {
            counts = times + 1;
        }

        //Callable用于产生结果
        List<Callable<List>> tasks = new ArrayList<>();
        for (int i = 0; i < counts; i++) {
            Callable<List> qfe = new ThredQuery(i, num);
            tasks.add(qfe);
        }
        //java自己去定义线程个数
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //Future用于获取结果
        List<Future<List>> futures=executorService.invokeAll(tasks);
        //处理线程返回结果
        if(futures!=null&&futures.size()>0){
            for (Future<List> future:futures){
                result.addAll(future.get());
            }
        }
        executorService.shutdown();//关闭线程池
        long end = System.currentTimeMillis();
        System.out.println("线程查询数据用时:"+(end-start)+"ms");
        return result;
    }

}