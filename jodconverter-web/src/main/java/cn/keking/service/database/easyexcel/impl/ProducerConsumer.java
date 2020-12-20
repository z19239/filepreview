package cn.keking.service.database.easyexcel.impl;


import cn.keking.config.ConfigConstants;
import cn.keking.mapper.BaseProcessDrawingsExtMapper;
import cn.keking.model.database.dto.BaseProcessDrawingsDTO;
import cn.keking.model.database.dto.BaseProcessDrawingsExcelUploadDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class ProducerConsumer {
    private static Logger logger = LoggerFactory.getLogger(EasyExcelServiceDrawingsImpl.class);

    private static String keymap=ConfigConstants.getkeyDRAWE();

    //消费者
    public class Consumer implements Runnable {

        private BaseProcessDrawingsExtMapper baseProcessDrawingsExtMapper;
        private Storage s = null;

        public Consumer(BaseProcessDrawingsExtMapper processDrawingsExtMapper, BaseProcessDrawingsExtMapper baseProcessDrawingsExtMapper, Storage s) {
            super();
            this.baseProcessDrawingsExtMapper = baseProcessDrawingsExtMapper;
            this.s = s;
            this.baseProcessDrawingsExtMapper=processDrawingsExtMapper;
        }

        public void run() {
            try {
                while (true) {
                    List<BaseProcessDrawingsDTO> objs=new ArrayList<BaseProcessDrawingsDTO>();
                    Object o = s.pop();
                    //业务处理
                    BaseProcessDrawingsExcelUploadDTO baseProcessDrawingsExcelUploadDTO=(BaseProcessDrawingsExcelUploadDTO) o;
                    BaseProcessDrawingsDTO baseProcessDrawingsDTO=new BaseProcessDrawingsDTO();
                    baseProcessDrawingsDTO.setDrawingPath(baseProcessDrawingsExcelUploadDTO.getDrawingPath());
                    baseProcessDrawingsDTO.setDraweNo(baseProcessDrawingsExcelUploadDTO.getExcelDraweNo());
                    baseProcessDrawingsDTO.setDraweNoSuffix(baseProcessDrawingsDTO.getDraweNoSuffix());
                    baseProcessDrawingsDTO.setPdId(baseProcessDrawingsExcelUploadDTO.getId());
                    objs.add(baseProcessDrawingsDTO);
                    if(objs.size()>0){
                        int limit=2000;
                        if (objs.size()>limit){
                            //需要分几次完成
                            int count=objs.size()/limit;
                            for (int i = 0; i < count; i++) {
                                List<BaseProcessDrawingsDTO> listDTO = objs.subList(0, limit);
                                //2000条
                                baseProcessDrawingsExtMapper.addDrawingsDetailsBatch(listDTO);
                                //剔除已经插入的数据
                                objs.subList(0,limit).clear();
                            }
                            if (!objs.isEmpty()){
                                //插入2000条
                                baseProcessDrawingsExtMapper.addDrawingsDetailsBatch(objs);
                            }
                        }else if(objs.size()>0){
                            //数据量不大，直接一次
                            baseProcessDrawingsExtMapper.addDrawingsDetailsBatch(objs);
                        }
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    //生产者
    public class Producer implements Runnable {
        private Storage s ;
        private List list ;
        private BaseProcessDrawingsExtMapper baseProcessDrawingsExtMapper;

        public Producer(BaseProcessDrawingsExtMapper baseProcessDrawingsExtMapper, Storage s, List list) {
            this.s = s;
            this.list=list;
            this.baseProcessDrawingsExtMapper=baseProcessDrawingsExtMapper;
        }
        public void run() {
            try {
                baseProcessDrawingsExtMapper.insterBaseProcessDrawingsBatch(list);
                s.push(list);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //数据仓库
    public class Storage {

        BlockingQueue<Object> queues = new LinkedBlockingQueue<Object>(200);
        /**
         * 生产
         *
         * @param list 产品
         * @throws InterruptedException
         */
        public void push(List list) throws InterruptedException {
            for (Object p : list) {
                queues.put(p);
            }
        }

        /**
         * 消费
         *
         * @return 产品
         * @throws InterruptedException
         */
        public Object pop() throws InterruptedException {
            return queues.take();
        }

    }

}
