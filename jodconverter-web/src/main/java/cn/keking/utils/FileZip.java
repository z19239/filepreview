package cn.keking.utils;

import cn.keking.web.controller.FileController;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**java压缩成zip
 */
public class FileZip {

    private static  final Logger logger = LoggerFactory.getLogger(FileZip.class);
	/**
	 * @param inputFileName 你要压缩的文件夹(整个完整路径)
	 * @param zipFileName 压缩后的文件(整个完整路径)
	 * @throws Exception
	 */
	public static Boolean zip(String inputFileName, String zipFileName) throws Exception {
		zip(zipFileName, new File(inputFileName));
		return true;
	}

	private static void zip(String zipFileName, File inputFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out, inputFile, "");
		out.flush();
		out.close();
	}

	private static void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			//System.out.println(base);
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}

   /**
    * @param srcFiles  需要压缩的文件组
    * @param zipFile   压缩文件存放路径
    */
   public static void zipFiles(List<File> srcFiles, File zipFile) {
         // 判断压缩后的文件存在不，不存在则创建
	   if(!zipFile.getParentFile().exists()) {
		   zipFile.getParentFile().mkdirs();
		}
        /*if (!zipFile.exists()) {
             try {
                 zipFile.createNewFile();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }*/
         // 创建 FileOutputStream 对象
         FileOutputStream fileOutputStream = null;
         // 创建 ZipOutputStream
         ZipOutputStream zipOutputStream = null;
         // 创建 FileInputStream 对象
         FileInputStream fileInputStream = null;
 
         try {
             // 实例化 FileOutputStream 对象
             fileOutputStream = new FileOutputStream(zipFile);
             // 实例化 ZipOutputStream 对象
             zipOutputStream = new ZipOutputStream(fileOutputStream);
             // 创建 ZipEntry 对象
             ZipEntry zipEntry = null;
             // 遍历源文件数组
             for (int i = 0; i < srcFiles.size(); i++) {
                 // 将源文件数组中的当前文件读入 FileInputStream 流中
                 fileInputStream = new FileInputStream(srcFiles.get(i));
                 String time=System.currentTimeMillis()+"";
                 // 实例化 ZipEntry 对象，源文件数组中的当前文件
                 String name=srcFiles.get(i).getName();
                 zipEntry = new ZipEntry(name.substring(0,name.lastIndexOf("."))+time.substring(8)+name.substring(name.lastIndexOf("."),name.length()));
                 zipOutputStream.putNextEntry(zipEntry);
                 // 该变量记录每次真正读的字节个数
                 int len;
                 // 定义每次读取的字节数组
                 byte[] buffer = new byte[1024];
                 while ((len = fileInputStream.read(buffer)) > 0) {
                     zipOutputStream.write(buffer, 0, len);
                 }
             }
             zipOutputStream.closeEntry();
             zipOutputStream.close();
             fileInputStream.close();
             fileOutputStream.close();
         } catch (IOException e) {
             e.printStackTrace();
         }finally {
        	 //if(zipFile!=null) zipFile.delete();//删除服务器本地产生的临时压缩文件
		}
 
     }
   
   /**
    * 批量下载文件压缩ZIP
    * @param request
    * @param response
    * @param files 需要压缩的文件数组
    * @param path 压缩文件想要放置的路径
    * @param base_name zip文件名
    * @throws IOException
    */
   public static void feedBackDirectMultiDownload(HttpServletRequest request,HttpServletResponse response,File [] files,String path,String base_name) throws IOException{
       //压缩文件初始设置
       String fileZip = base_name + ".zip"; // 拼接zip文件
       String filePath = path+"\\" + fileZip;//之后用来生成zip文件

       //filePathArr为根据前台传过来的信息，通过数据库查询所得出的文件路径集合（具体到后缀），此处省略
      /* File files = new File[fileNameArr.size()];//
       for(int i=0;i<fileNameArr.size();i++){
           files[i]=new File(fileNameArr.get(i).get("filePath"));//获取所有需要下载的
       }*/
       // 创建临时压缩文件
       try {
           BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
           ZipOutputStream zos = new ZipOutputStream(bos);
           ZipEntry ze = null;
           for (int i = 0; i < files.length; i++) {//将所有需要下载的文件都写入临时zip文件
               BufferedInputStream bis = new BufferedInputStream(new FileInputStream(files[i]));
               ze = new ZipEntry(files[i].getName());
               zos.putNextEntry(ze);
               int s = -1;
               while ((s = bis.read()) != -1) {
                   zos.write(s);
               }
               bis.close();
           }
           zos.flush();
           zos.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
       //以上，临时压缩文件创建完成
       //进行浏览器下载
       //获得浏览器代理信息
       final String userAgent = request.getHeader("USER-AGENT");
       //判断浏览器代理并分别设置响应给浏览器的编码格式
       String finalFileName = null;
       if(StringUtils.contains(userAgent, "MSIE")||StringUtils.contains(userAgent,"Trident")){//IE浏览器
           finalFileName = URLEncoder.encode(fileZip,"UTF8");
           System.out.println("IE浏览器");
       }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
           finalFileName = new String(fileZip.getBytes(), "ISO8859-1");
       }else{
           finalFileName = URLEncoder.encode(fileZip,"UTF8");//其他浏览器
       }
       response.setContentType("application/x-download");//告知浏览器下载文件，而不是直接打开，浏览器默认为打开
       response.setHeader("Content-Disposition" ,"attachment;filename=\"" +finalFileName+ "\"");//下载文件的名称

       ServletOutputStream servletOutputStream=response.getOutputStream();
       DataOutputStream temps = new DataOutputStream(
                       servletOutputStream);

       DataInputStream in = new DataInputStream(
                               new FileInputStream(filePath));//浏览器下载文件的路径
       byte[] b = new byte[2048];
       File reportZip=new File(filePath);//之后用来删除临时压缩文件
       try {
           while ((in.read(b)) != -1) {
           temps.write(b);
       }
           temps.flush();
       } catch (Exception e) {
           e.printStackTrace();
       }finally{
           if(temps!=null) temps.close();
           if(in!=null) in.close();
           if(reportZip!=null) reportZip.delete();//删除服务器本地产生的临时压缩文件
           servletOutputStream.close();
       }      
  }

    /**
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下
     * @param sourceFilePath :待压缩的文件路径
     * @param zipFilePath :压缩后存放路径
     * @param fileName :压缩后文件的名称
     * @return filepath 文件路径
     */
    public static String fileToZip(String sourceFilePath,String zipFilePath,String fileName){
        String filePath = null;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if(sourceFile.exists() == false){
            logger.info("待压缩的文件目录："+sourceFilePath+"不存在.");
            sourceFile.mkdir(); // 新建目录
        }
        try {
            File zipFile = new File(zipFilePath + File.separator + fileName +".zip");
            if(zipFile.exists()){
                logger.info(zipFilePath + "目录下存在名字为:" + fileName +".zip" +"打包文件.");
            }else{
                File[] sourceFiles = sourceFile.listFiles();
                if(null == sourceFiles || sourceFiles.length<1){
                    logger.info("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                }else{
                    fos = new FileOutputStream(zipFile);
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));
                    byte[] bufs = new byte[1024*10];
                    for(int i=0;i<sourceFiles.length;i++){
                        //创建ZIP实体，并添加进压缩包
                        ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                        zos.putNextEntry(zipEntry);
                        //读取待压缩的文件并写进压缩包里
                        fis = new FileInputStream(sourceFiles[i]);
                        bis = new BufferedInputStream(fis, 1024*10);
                        int read = 0;
                        while((read=bis.read(bufs, 0, 1024*10)) != -1){
                            zos.write(bufs,0,read);
                        }
                    }
                    filePath = sourceFilePath+File.separator+fileName;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally{
            //关闭流
            try {
                if(null != bis) bis.close();
                if(null != zos) zos.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return filePath;
    }

    static final int BUFFER = 8192;

    private File zipFile;

    public FileZip(String pathName) {
        zipFile = new File(pathName);
    }
    public  void compress(String... pathName) {
        ZipOutputStream out = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,
                    new CRC32());
            out = new ZipOutputStream(cos);
            String basedir = "";
            for (int i=0;i<pathName.length;i++){
                compress(new File(pathName[i]), out, basedir);
            }
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private  void compress(String srcPathName) {
        File file = new File(srcPathName);
        if (!file.exists())
            throw new RuntimeException(srcPathName + "不存在！");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream,
                    new CRC32());
            ZipOutputStream out = new ZipOutputStream(cos);
            String basedir = "";
            compress(file, out, basedir);
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void compress(File file, ZipOutputStream out, String basedir) {
        /* 判断是目录还是文件 */
        if (file.isDirectory()) {
            logger.info("压缩：" + basedir + file.getName());
            compressDirectory(file, out, basedir);
        } else {
            logger.info("压缩：" + basedir + file.getName());
            compressFile(file, out, basedir);
        }
    }

    /** 压缩一个目录 */
    private static void compressDirectory(File dir, ZipOutputStream out, String basedir) {
        if (!dir.exists())
            return;

        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            /* 递归 */
            compress(files[i], out, basedir + dir.getName() + "/");
        }
    }

    /** 压缩一个文件 */
    private static void compressFile(File file, ZipOutputStream out, String basedir) {
        if (!file.exists()) {
            return;
        }
        try {
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(file));
            ZipEntry entry = new ZipEntry(basedir + file.getName());
            out.putNextEntry(entry);
            int count;
            byte data[] = new byte[BUFFER];
            while ((count = bis.read(data, 0, BUFFER)) != -1) {
                out.write(data, 0, count);
            }
            bis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
