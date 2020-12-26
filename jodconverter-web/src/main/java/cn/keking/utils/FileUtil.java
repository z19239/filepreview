package cn.keking.utils;

import cn.keking.model.FileMsg;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;

/**
 * @author Sandeepin
 * 2018/2/11 0011
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static final SimpleDateFormat FORMATTER_NORMAL_DATE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获得分片文件临时保存路径
     *
     * @param tempPath
     * @param userName
     * @param fileName
     * @return
     */
    public static String getTempDir(String tempPath, String userName, String fileName) {
        StringBuilder dir = new StringBuilder(tempPath);
        dir.append("/").append(userName);
        dir.append("/").append(DateUtil.getNowDate());
        dir.append("/").append(fileName);
        return dir.toString();
    }

    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param fileName 要删除的文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            logger.warn("删除文件失败:" + fileName + "不存在！");
            return false;
        } else {
            if (file.isFile()) {
                return deleteFile(fileName);
            } else {
                return deleteDirectory(fileName);
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                logger.warn("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                logger.warn("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            logger.warn("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param dir 要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            logger.warn("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = FileUtil.deleteFile(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = FileUtil.deleteDirectory(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
        }
        if (!flag) {
            logger.warn("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            logger.warn("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 文件移动
     *
     * @param oldName 要移动的文件
     * @param newName 新的路径
     */
    public static boolean renameFile(String oldName, String newName) {
        // 路径
        if (!oldName.equals(newName)) {
            File oldfile = new File(oldName);
            File newfile = new File(newName);
            // 重命名文件不存在
            if (!oldfile.exists()) {
                return false;
            }
            // 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
            if (newfile.exists()) {
                logger.warn(newName + "已经存在！");
                return false;
            } else {
                return oldfile.renameTo(newfile);
            }
        } else {
            logger.warn("移动路径没有变化相同...");
            return false;
        }
    }

    public static String fileSizeToString(long size) {
        String sizeStr;
        if (size >= 1073741824) {
            sizeStr = size / 1073741824 + "GB";
        } else if (size >= 1048576) {
            sizeStr = size / 1048576 + "MB";
        } else if (size >= 1024) {
            sizeStr = size / 1024 + "KB";
        } else if (size >= 1) {
            sizeStr = size + "Byte";
        } else {
            sizeStr = "0";
        }
        return sizeStr;
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean
     */
    public static boolean deleteDir(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            String[] children = dir.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        boolean b = true;
        if (dir.exists()) {
            b = dir.delete();
        }
        return b;
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dirName 文件夹字符串
     * @return boolean
     */
    public static boolean deleteDir(String dirName) {
        File dir = new File(dirName);
        return deleteDir(dir);
    }

    public static boolean isVideo(String fileName) {
        String suffix = FilenameUtils.getExtension(fileName);
        return "mkv".equalsIgnoreCase(suffix) || "rmvb".equalsIgnoreCase(suffix) || "avi".equalsIgnoreCase(suffix)
                || "wmv".equalsIgnoreCase(suffix) || "3gp".equalsIgnoreCase(suffix) || "rm".equalsIgnoreCase(suffix);
    }

    public static boolean isMp4(String fileName) {
        return "mp4".equalsIgnoreCase(FilenameUtils.getExtension(fileName));
    }

    /**
     * 替换磁盘目录为下载目录
     *
     * @param filePath 待处理的文件路径
     * @param rootPath 磁盘上存储文件的跟目录
     * @param downPath url映射的下载目录
     * @return 下载目录
     */
    public static String rootPathTodownPath(String filePath, String rootPath, String downPath) {
        String link = filePath.replace("\\", "/");
        return link.replace(rootPath, downPath);
    }

    /**
     * 读取文件信息并转为Json对象体
     *
     * @param file 文件对象
     * @param userName 用户名
     * @param rootPath 磁盘上存储文件的跟目录
     * @param downPath url映射的下载目录
     * @return FileMsg
     */
    public static FileMsg fileToFileMsg(File file, String userName, String rootPath, String downPath) {
        FileMsg fileMsg = new FileMsg();
        if (file.isFile()) {
            fileMsg.setName(file.getName());
            fileMsg.setSize(FileUtils.byteCountToDisplaySize(FileUtils.sizeOf(file)));
            fileMsg.setTime(FORMATTER_NORMAL_DATE.format(file.lastModified()));
            // 文件返回下载地址 （D:/user/1.txt 处理为 /data/user/1.txt）
            fileMsg.setLink(rootPathTodownPath(file.getPath(), rootPath, downPath));
            if (isMp4(file.getName())) {
                fileMsg.setType("mp4");
            } else if (isVideo(file.getName())) {
                fileMsg.setType("video");
            } else {
                fileMsg.setType("file");
            }
        } else {
            fileMsg.setName(file.getName());
            fileMsg.setSize("Directory");
            fileMsg.setType("dir");
            // 目录返回用户相对path （D:/user/dir1/dir2 处理为 /dir1/dir2）
            fileMsg.setLink(rootPathTodownPath(file.getPath(), rootPath + userName, ""));
            fileMsg.setTime(FORMATTER_NORMAL_DATE.format(file.lastModified()));
        }
        return fileMsg;
    }

    /**
     * 输入流保存为文件
     *
     * @param inputStream 输入流
     * @param f 文件
     * @return boolean
     */
    public static boolean writeInputStreamToFile(InputStream inputStream, File f) {
        boolean ret = false;
        try (OutputStream outputStream = new FileOutputStream(f)) {
            int read;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            ret = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("writeInputStreamToFile() IOException!");
                }
            }
        }
        return ret;
    }

    /**
     * 从content-disposition头部获取提取文件名
     * @param header header
     * @return String
     */
    public static String getFileNameByContentDisposition(String header) {
        String[] tempArr1 = header.split(";");
        String[] tempArr2 = tempArr1[2].split("=");
        // 获取文件名，兼容各种浏览器的写法
        return tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
    }

    /**获取文件大小 返回 KB 保留3位小数  没有文件时返回0
     * @param filepath 文件完整路径，包括文件名
     * @return
     */
    public static Double getFilesize(String filepath){
        File backupath = new File(filepath);
        return Double.valueOf(backupath.length())/1000.000;
    }

    /**
     * 创建目录
     * @param destDirName  目标目录名
     * @return
     */
    public static Boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if(!dir.getParentFile().exists()){				//判断有没有父路径，就是判断文件整个路径是否存在
            return dir.getParentFile().mkdirs();		//不存在就全部创建
        }
        return false;
    }

    /**
     * 删除文件
     * @param filePathAndName
     *            String 文件路径及名称 如c:/fqf.txt
     * @return boolean
     */
    public static void delFile(String filePathAndName) {
        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            java.io.File myDelFile = new java.io.File(filePath);
            myDelFile.delete();
        } catch (Exception e) {
            System.out.println("删除文件操作出错");
            e.printStackTrace();
        }
    }

    /**
     * 读取到字节数组0
     * @param filePath //路径
     * @throws IOException
     */
    public static byte[] getContent(String filePath) throws IOException {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        fi.close();
        return buffer;
    }

    /**
     * 读取到字节数组1
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(String filePath) throws IOException {

        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException(filePath);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(f));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bos.close();
        }
    }

    /**
     * 读取到字节数组2
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray2(String filePath) throws IOException {
        File f = new File(filePath);
        if (!f.exists()) {
            throw new FileNotFoundException(filePath);
        }
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
                // do nothing
                // System.out.println("reading");
            }
            return byteBuffer.array();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Mapped File way MappedByteBuffer 可以在处理大文件时，提升性能
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray3(String filePath) throws IOException {

        FileChannel fc = null;
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(filePath, "r");
            fc = rf.getChannel();
            MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0,
                    fc.size()).load();
            //System.out.println(byteBuffer.isLoaded());
            byte[] result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {
                // System.out.println("remain");
                byteBuffer.get(result, 0, byteBuffer.remaining());
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                rf.close();
                fc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 　 * 私有构造方法，防止类的实例化，因为工具类不需要实例化。 　
     */
    private FileUtil() {
    }

    /**
     * 读取文件内容
     * @param inputStream
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String readFileToString(InputStream inputStream) throws UnsupportedEncodingException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        StringBuffer fileString  = new StringBuffer();
        try {
            String readLine = null;
            while((readLine = bufferedReader.readLine())!=null){
                fileString.append(readLine);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                bufferedReader.close();
                inputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return fileString.toString();
    }

    /**
     *修改文件的最后访问时间。 　 * 如果文件不存在则创建该文件。 　 *
     * 目前这个方法的行为方式还不稳定，主要是方法有些信息输出，这些信息输出是否保留还在考 　 * @param file 需要修改最后访问时间的文件。
     * @since　0.1 　
     */
    public static void touch(File file) {
        long currentTime = System.currentTimeMillis();
        if (!file.exists()) {
            System.err.println("file not found:" + file.getName());
            System.err.println("Create a new file:" + file.getName());
            try {
                if (file.createNewFile()) {
                    // System.out.println("Succeeded!");
                } else {
                    // System.err.println("Create file failed!");
                }
            } catch (IOException e) {
                // System.err.println("Create file failed!");
                e.printStackTrace();
            }
        }
        boolean result = file.setLastModified(currentTime);
        if (!result) {
            // System.err.println("touch failed: " + file.getName());
        }
    }

    /**
     * 修改文件的最后访问时间。 如果文件不存在则创建该文件。 目前这个方法的行为方式还不稳定，主要是方法有些信息输出，这些信息输出是否保留还在考
     *
     * @param fileName
     *            需要修改最后访问时间的文件的文件名。
     * @since0.1
     */
    public static void touch(String fileName) {
        File file = new File(fileName);
        touch(file);
    }

    /**
     * 修改文件的最后访问时间。 如果文件不存在则创建该文件。 目前这个方法的行为方式还不稳定，主要是方法有些信息输出，这些信息输出是否保留还在考
     *
     * @param files
     *            需要修改最后访问时间的文件数组。
     * @since0.1
     */
    public static void touch(File[] files) {
        for (int i = 0; i < files.length; i++) {
            touch(files);
        }
    }

    /**
     * 判断指定的文件是否存在。
     *
     * @param fileName
     *            要判断的文件的文件名
     * @return 存在时返回true，否则返回false。
     * @since0.1
     */
    public static boolean isFileExist(String fileName) {
        return new File(fileName).isFile();
    }

    /**
     * 创建指定的目录。 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。 注意：可能会在返回false的时候创建部分父目录。
     *
     * @param file
     *            要创建的目录
     * @return 完全创建成功时返回true，否则返回false。
     * @since0.1
     */
    public static boolean makeDirectory(File file) {
        File parent = file.getParentFile();
        if (parent != null) {
            return parent.mkdirs();
        }
        return false;
    }

    /**
     * 创建指定的目录。 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。 注意：可能会在返回false的时候创建部分父目录。
     *
     * @param fileName
     *            要创建的目录的目录名
     * @return 完全创建成功时返回true，否则返回false。
     * @since0.1
     */
    public static boolean makeDirectory(String fileName) {
        File file = new File(fileName);
        return makeDirectory(file);
    }

    /**
     * 返回文件的URL地址。
     *
     * @param file
     *            文件
     * @return 文件对应的的URL地址
     * @throws MalformedURLException
     * @since0.4
     * @deprecated 在实现的时候没有注意到File类本身带一个toURL方法将文件路径转换为URL。 请使用File.toURL方法。
     */
    public static URL getURL(File file) throws MalformedURLException {
        String fileURL = "file:/" + file.getAbsolutePath();
        URL url = new URL(fileURL);
        return url;
    }

    /**
     * 从文件路径得到文件名。
     *
     * @param filePath
     *            文件的路径，可以是相对路径也可以是绝对路径
     * @return 对应的文件名
     * @since0.4
     */
    public static String getFileName(String filePath) {
        File file = new File(filePath);
        return file.getName();
    }

    /**
     * 从文件名得到文件绝对路径。
     *
     * @param fileName
     *            文件名
     * @return 对应的文件路径
     * @since0.4
     */
    public static String getFilePath(String fileName) {
        File file = new File(fileName);
        return file.getAbsolutePath();
    }

    /**
     * 将DOS/Windows格式的路径转换为UNIX/Linux格式的路径。
     * 其实就是将路径中的""全部换为"/"，因为在某些情况下我们转换为这种方式比较方便，
     * 某中程度上说"/"比""更适合作为路径分隔符，而且DOS/Windows也将它当作路径分隔符。
     *
     * @param filePath
     *            转换前的路径
     * @return 转换后的路径
     * @since0.4
     */
    public static String toUNIXpath(String filePath) {
        return filePath.replace("", "/");
    }

    /**
     * 从文件名得到UNIX风格的文件绝对路径。
     *
     * @param fileName
     *            文件名
     * @return 对应的UNIX风格的文件路径
     * @since0.4
     * @see #toUNIXpath(String filePath) toUNIXpath
     */
    public static String getUNIXfilePath(String fileName) {
        File file = new File(fileName);
        return toUNIXpath(file.getAbsolutePath());
    }

    /**
     * 得到文件的类型。 实际上就是得到文件名中最后一个“.”后面的部分。
     *
     * @param fileName
     *            文件名
     * @return 文件名中的类型部分
     * @since0.5
     */
    public static String getTypePart(String fileName) {
        int point = fileName.lastIndexOf('.');
        int length = fileName.length();
        if (point == -1 || point == length - 1) {
            return "";
        } else {
            return fileName.substring(point + 1, length);
        }
    }

    /**
     * 得到文件的类型。 实际上就是得到文件名中最后一个“.”后面的部分。
     *
     * @param file
     *            文件
     * @return 文件名中的类型部分
     * @since0.5
     */
    public static String getFileType(File file) {
        return getTypePart(file.getName());
    }

    /**
     * 得到文件的名字部分。 实际上就是路径中的最后一个路径分隔符后的部分。
     *
     * @param fileName
     *            文件名
     * @return 文件名中的名字部分
     * @since0.5
     */
    public static String getNamePart(String fileName) {
        int point = getPathLsatIndex(fileName);
        int length = fileName.length();
        if (point == -1) {
            return fileName;
        } else if (point == length - 1) {
            int secondPoint = getPathLsatIndex(fileName, point - 1);
            if (secondPoint == -1) {
                if (length == 1) {
                    return fileName;
                } else {
                    return fileName.substring(0, point);
                }
            } else {
                return fileName.substring(secondPoint + 1, point);
            }
        } else {
            return fileName.substring(point + 1);
        }
    }

    /**
     * 得到文件名中的父路径部分。 对两种路径分隔符都有效。 不存在时返回""。
     * 如果文件名是以路径分隔符结尾的则不考虑该分隔符，例如"/path/"返回""。
     *
     * @param fileName
     *            文件名
     * @return 父路径，不存在或者已经是父目录时返回""
     * @since0.5
     */
    public static String getPathPart(String fileName) {
        int point = getPathLsatIndex(fileName);
        int length = fileName.length();
        if (point == -1) {
            return "";
        } else if (point == length - 1) {
            int secondPoint = getPathLsatIndex(fileName, point - 1);
            if (secondPoint == -1) {
                return "";
            } else {
                return fileName.substring(0, secondPoint);
            }
        } else {
            return fileName.substring(0, point);
        }
    }

    /**
     * 得到路径分隔符在文件路径中首次出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     *            文件路径
     * @return 路径分隔符在路径中首次出现的位置，没有出现时返回-1。
     * @since0.5
     */
    public static int getPathIndex(String fileName) {
        int point = fileName.indexOf("/");
        if (point == -1) {
            point = fileName.indexOf("");
        }
        return point;
    }

    /**
     * 得到路径分隔符在文件路径中指定位置后首次出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     *            文件路径
     * @param fromIndex
     *            开始查找的位置
     * @return 路径分隔符在路径中指定位置后首次出现的位置，没有出现时返回-1。
     * @since0.5
     */
    public static int getPathIndex(String fileName, int fromIndex) {
        int point = fileName.indexOf("/", fromIndex);
        if (point == -1) {
            point = fileName.indexOf("", fromIndex);
        }
        return point;
    }

    /**
     * 得到路径分隔符在文件路径中最后出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     *            文件路径
     * @return 路径分隔符在路径中最后出现的位置，没有出现时返回-1。
     * @since0.5
     */
    public static int getPathLsatIndex(String fileName) {
        int point = fileName.lastIndexOf("/");
        if (point == -1) {
            point = fileName.lastIndexOf("");
        }
        return point;
    }

    /**
     * 得到路径分隔符在文件路径中指定位置前最后出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
     *
     * @param fileName
     *            文件路径
     * @param fromIndex
     *            开始查找的位置
     * @return 路径分隔符在路径中指定位置前最后出现的位置，没有出现时返回-1。
     * @since0.5
     */
    public static int getPathLsatIndex(String fileName, int fromIndex) {
        int point = fileName.lastIndexOf("/", fromIndex);
        if (point == -1) {
            point = fileName.lastIndexOf("", fromIndex);
        }
        return point;
    }

    /**
     * 将文件名中的类型部分去掉。
     *
     * @param filename
     *            文件名
     * @return 去掉类型部分的结果
     * @since0.5
     */
    public static String trimType(String filename) {
        int index = filename.lastIndexOf(".");
        if (index != -1) {
            return filename.substring(0, index);
        } else {
            return filename;
        }
    }

    /**
     * 得到相对路径。 文件名不是目录名的子节点时返回文件名。
     *
     * @param pathName
     *            目录名
     * @param fileName
     *            文件名
     * @return 得到文件名相对于目录名的相对路径，目录下不存在该文件时返回文件名
     * @since0.5
     */
    public static String getSubpath(String pathName, String fileName) {
        int index = fileName.indexOf(pathName);
        if (index != -1) {
            return fileName.substring(index + pathName.length() + 1);
        } else {
            return fileName;
        }
    }

    /**
     * 删除一个文件。
     *
     * @param filename
     * @throws IOException
     */
    /*public static void deleteFile(String filename) throws IOException {
        File file = new File(filename);
        if (file.isDirectory()) {
            throw new IOException(
                    "IOException -> BadInputException: not a file.");
        }
        if (file.exists() == false) {
            throw new IOException(
                    "IOException -> BadInputException: file is not exist.");
        }
        if (file.delete() == false) {
            throw new IOException("Cannot delete file. filename = " + filename);
        }
    }*/

    /**
     * 删除文件夹及其下面的子文件夹
     *
     * @param dir
     * @throws IOException
     */
    /*public static void deleteDir(File dir) throws IOException {
        if (dir.isFile())
            throw new IOException(
                    "IOException -> BadInputException: not a directory.");
        File[] files = dir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isFile()) {
                    // System.out.println("清理文件=="+file.toString());
                    file.delete();
                } else {
                    deleteDir(file);
                }
            }
        }// if
        dir.delete();
    }*/

    /**
     *
     * @函数介绍：复制文件
     * @参数：src 源文件；dst 目标文件
     * @返回值：
     */
    public static void copy(File src, File dst) throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),
                    BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }

    /**
     *
     * @函数介绍：复制文件，支持把源文件内容追加到目标文件末尾
     * @参数：src 源文件；dst 目标文件,append true:追加到末尾；false清空目标文件
     * @返回值：
     */
    public static void copy(File src, File dst, boolean append)
            throws Exception {
        int BUFFER_SIZE = 4096;
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst, append),
                    BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                out = null;
            }
        }
    }

}
