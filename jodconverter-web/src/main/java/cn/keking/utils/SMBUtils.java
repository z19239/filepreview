package cn.keking.utils;

import cn.keking.config.ConfigConstants;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * 共享目录
 *
 */
public class SMBUtils {

    private static final Logger logger = LoggerFactory.getLogger(SMBUtils.class);

    private static final String fileDir = ConfigConstants.getFileDir();

    private static final String demoDir = "temp";

    private static final String demoPath = demoDir + File.separator;

    public static void main(String[] args) {
        SMBUtils smbHelper = new SMBUtils();
        //smbHelper.SmbGet("10.0.10.115","t1","t1@123","Drawings","Impress系列/Drawing1.pdf","C:/ZZZZZZZZ0");

        GetAllFile("192.168.1.51","file","z@123","奇亚");

        //		smbHelper.FileUploadAuth("192.168.3.220","administrator", "x@123++","ShareTest","C:\\1234.pdf", "", "AAS/ASD/001");
    }
    /**
     * 文件上传
     * @param ip 域名或者IP
     * @param userId 用户名
     * @param userPwd 密码
     * @param sharePath 共享目录名称，实例 gdzjjg
     * @param fileName 上传的文件全路径名称，实例C:\\1234.pdf
     * @param newFileName 上传后的文件名，实例  0000.pdf
     * @param filePath 上传的远程目录 实例  AAAAA/BBBBBBB/CCCCCCC
     * @return
     */
    public static void FileUploadAuth(String ip,String userId,String userPwd,String sharePath,String fileName, String newFileName, String filePath)
    {
        InputStream in = null;
        OutputStream out = null;
        SmbFileOutputStream file_out = null;
        try{
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(ip, userId, userPwd);  //先登录验证
            if (filePath.startsWith("/")) {
                filePath = filePath.substring(1, filePath.length());
            }
            String smbPath = "smb://"+ip+"/"+sharePath+"/"+filePath;

            //获取文件名
            fileName = fileName.replace("\\", "/");
            if (!StringUtils.hasText(newFileName)) {
                if (fileName.indexOf("/") > -1)
                    newFileName = fileName.substring(fileName.lastIndexOf("/") + 1);
                else {
                    newFileName = fileName;
                }
            }

            SmbFile smbFilePath = new SmbFile(smbPath,auth);
            if (!smbFilePath.isDirectory()) {
                smbFilePath.mkdirs();
            }

            String smburl = smbPath+"/"+newFileName;
            SmbFile smbFile = new SmbFile(smburl,auth);


            if ((newFileName != null) && (!(newFileName.equals("")))){
                file_out = new SmbFileOutputStream(smbFile);
            }else {
                file_out = new SmbFileOutputStream(smbFile);
            }

            File file_in = new File(fileName);

            in = new BufferedInputStream(new FileInputStream(file_in));
            out = new BufferedOutputStream(file_out);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }

            // 刷新此缓冲的输出流
            out.flush();
            out.flush();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out !=null) {
                    out.close();
                }
                if (in !=null) {
                    in.close();
                }
                if (file_out !=null) {
                    file_out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取文件夹下的文件
     * @param ip
     * @param userId
     * @param userPwd
     * @param sharePath 共享目录
     * @return
     */
    public static SmbFile[] GetAllFile(String ip,String userId,String userPwd,String sharePath) {
        try {
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(ip, userId, userPwd);  //登录验证
            /*String remoteurl = "smb://"+ip+"/"+sharePath+"/";
            //String remoteurl="smb://"+ip+"/";
            String baseUrl="//"+ip+"/"+sharePath+"/";
            //String baseUrl="//"+ip+"/";
            SmbFile file = new SmbFile(baseUrl,auth);
            if(file.exists()){
                SmbFile[] files = file.listFiles();
                for(SmbFile f : files){
                    System.out.println(baseUrl+f.getName());

                }
                return  files;
            }*/
            String url = "smb://"+ip+"/"+sharePath+"/";
            SmbFile file = new SmbFile(url,auth);
            file.connect();
            if(file.exists()){
                SmbFile[] files = file.listFiles();
                for(SmbFile f : files){
                    System.out.println(f.getName());
                }
                return  files;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String truncateHeadString(String origin, int count) {
        if (origin == null || origin.length() < count) {
            return null;
        }
        char[] arr = origin.toCharArray();
        char[] ret = new char[arr.length - count];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = arr[i + count];
        }
        return String.copyValueOf(ret);
    }
    //使用String的split 方法
    public static String[] convertStrToArray(String str){
        String[] strArray = null;
        strArray = str.split("\\\\"); //拆分字符为"," ,然后把结果交给数组strArray
        return strArray;
    }
    /**
         *
         * @param ip ip获取域名
         * @param userId 登录的用户名
         * @param userPwd 登录密码
         * @param sharePath 共享目录的文件夹名称，例如  gdzjjg
         * @param remoteFileName 共享目录的文件全路径包含文件名， 实例  AAAA/BBBBBBB/123.pdf
         * @param localDir 下载的文件夹，磁盘路径 ，实例 C:\\AAAA
         * @return
         */
    public static String SmbGet(String ip,String userId,String userPwd,String sharePath,String remoteFileName, String localDir) {
        InputStream in = null;
        OutputStream out = null;
        BufferedWriter bw = null;
        String url=null;
        SmbFile remoteFile=null;
        try {
            if (remoteFileName.startsWith("/")) {
                remoteFileName = remoteFileName.substring(1, remoteFileName.length());
            }
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(ip, userId, userPwd);  //先登录验证
            String[] strArray=convertStrToArray(truncateHeadString(sharePath,2));
            String s="";
            for (String str:strArray) {
                 s+=str+"/";
            }
            s = s.substring(0,s.length() - 1);
            String smbUrl = "smb://"+s;
            remoteFile = new SmbFile(smbUrl,auth);
            remoteFile.connect();
            if (!remoteFile.isFile()) {
                logger.info("文件不存在");
                return url;
            }
            String fileName = remoteFile.getName();

            File localFile = new File(localDir + File.separator);
            if(!localFile.exists()){//如果文件夹不存在
                //创建文件夹
                localFile.mkdirs();
            }
            fileName=java.net.URLDecoder.decode(fileName,"UTF-8");

            // 判断是否存在同名文件
            if (existsFile(fileName)) {
                File file = new File(fileDir + demoPath + fileName);
                logger.info("删除文件：{}", file.getAbsolutePath());
                if (file.exists()) {
                    file.delete();
                }
            }
            /*File outFile = new File(fileDir + demoPath);
            if (!outFile.exists()) {
                outFile.mkdirs();
            }
            logger.info("上传文件：{}", fileDir + demoPath + fileName);*/
            //创建文件
            /*bw=new BufferedWriter(new FileWriter(localDir + File.separator + fileName));
            bw.close();*/
            File localFiles =  new File(localDir + File.separator + fileName);
            in = new BufferedInputStream(new SmbFileInputStream(remoteFile));
            out = new BufferedOutputStream(new FileOutputStream(localFiles));
            /*byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1) {
                out.write(buffer);
                buffer = new byte[1024];
            }*/
            StreamUtils.copy(in, out);
            logger.info("下载成功");
            return  demoDir+"/"+fileName;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Smb下载异常",e);
            return url;
        } finally {
            try {
                if (out !=null) {
                    out.close();
                }
                if (in !=null) {
                    in.close();
                }
                if (bw !=null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("Smb流关闭异常",e);
                return url;
            }
        }
    }


    /**
     *
     * @param ip ip获取域名
     * @param userId 登录的用户名
     * @param userPwd 登录密码
     * @remoteFileName 共享目录的文件全路径包含文件名， 实例  AAAA/BBBBBBB/123.pdf
     * @return
     */
    public static String SmbGetNoFilePath(String ip,String userId,String userPwd,String remoteFileName,String localDir) {
        InputStream in = null;
        OutputStream out = null;
        BufferedWriter bw = null;
        String url=null;
        SmbFile remoteFile=null;
        try {
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(ip, userId, userPwd);  //先登录验证
            String smbUrl = "smb:"+remoteFileName;
            remoteFile = new SmbFile(smbUrl,auth);
            if (!remoteFile.isFile()) {
                logger.info("文件不存在");
                return url;
            }
            String fileName = remoteFile.getName();

            File localFile = new File(localDir + File.separator);
            if(!localFile.exists()){//如果文件夹不存在
                //创建文件夹
                localFile.mkdirs();
            }
            fileName=java.net.URLDecoder.decode(fileName,"UTF-8");

            // 判断是否存在同名文件
            if (existsFile(fileName)) {
                File file = new File(fileDir + demoPath + fileName);
                logger.info("删除文件：{}", file.getAbsolutePath());
                if (file.exists()) {
                    file.delete();
                }
            }
            File outFile = new File(fileDir + demoPath);
            if (!outFile.exists()) {
                outFile.mkdirs();
            }
            logger.info("上传文件：{}", fileDir + demoPath + fileName);
            //创建文件
            File localFiles =  new File(localDir + File.separator + fileName);
            in = new BufferedInputStream(new SmbFileInputStream(remoteFile));
            out = new BufferedOutputStream(new FileOutputStream(localFiles));
            StreamUtils.copy(in, out);
            logger.info("下载成功");
            return  demoDir+"/"+fileName;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Smb下载异常",e);
            return url;
        } finally {
            try {
                if (out !=null) {
                    out.close();
                }
                if (in !=null) {
                    in.close();
                }
                if (bw !=null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("Smb流关闭异常",e);
                return url;
            }
        }
    }


    private static boolean existsFile(String fileName) {
        File file = new File(fileDir + demoPath + fileName);
        return file.exists();
    }
}

