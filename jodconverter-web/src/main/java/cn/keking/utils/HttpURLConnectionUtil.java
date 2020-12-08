package cn.keking.utils;

import cn.keking.config.ConfigRefreshComponent;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class HttpURLConnectionUtil {
   
	// 数据缓冲大小
	private static final int FILE_BUFFER_SIZE = 8192;
		
	public static  void httpURLConnectionUtil(URL url,String realPath) throws IOException {
    	//realPath="E:\\Workspaces\\MyEclipse\\ehs-parent\\jiuxu-main\\src\\main\\webapp\\file\\demo\\518987patch01.zip";
    	try {
    	      //String urlPath = "http://localhost:8084/jxehs/file/demo/518987patch01.zip";
    	      //URL url = new URL(urlPath);
    	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    	      connection.setRequestMethod("GET");//get请求也是 -1 
    	      connection.setConnectTimeout(5000);
    	      connection.setRequestProperty("Connection", "Keep-Alive");
    	      connection.setRequestProperty("Accept-Encoding", "identity");
    	      connection.setRequestProperty("User-Agent", " Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36");
    	      connection.setAllowUserInteraction(true);//Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:68.0) Gecko/20100101 Firefox/68.0
    	      connection.connect();
    	      int responseCode = connection.getResponseCode();
    	      if(responseCode == HttpURLConnection.HTTP_OK){
    	          InputStream in = connection.getInputStream();
    	          /* File dir = new File(realPath);
				 * if (!dir.exists()){ dir.mkdirs(); }
				 */
    	         // File file = new File(dir, realPath);//根据目录和文件名得到file对象
				/*
				 * FileOutputStream fos = new FileOutputStream(realPath); byte[] buf = new
				 * byte[1024*8]; int len = -1; while ((len = inputStream.read(buf)) != -1){
				 * fos.write(buf, 0, len); } fos.flush();
				 */ 
					OutputStream out = null;
					try {
						// 设置上传保存路径
						File target = new File(realPath);
						out = new FileOutputStream(target);
						int bytesRead = 0;
						byte[] buffer = new byte[FILE_BUFFER_SIZE];
						while ((bytesRead = in.read(buffer, 0, FILE_BUFFER_SIZE)) != -1) {
							out.write(buffer, 0, bytesRead);
						}
						// 刷新缓冲区，将缓冲的数据全部输出
						out.flush();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (null != in) {
								in.close();
							}
							if (null != out) {
								out.close();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
    	      }

    	  } catch (Exception e) {
    	      e.printStackTrace();
    	  }
    }

	
	public static final byte[] input2byte(InputStream inStream) throws IOException {
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		byte[] buff = new byte[100];
		int rc = 0;
		while ((rc = inStream.read(buff, 0, 100)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		byte[] in2b = swapStream.toByteArray();
		return in2b;
	}

	public static File writeBytesToFile(byte[] b, String outputFile) {
		File file = null;
		FileOutputStream os = null;

		try {
			file = new File(outputFile);
			os = new FileOutputStream(file);
			os.write(b);
		} catch (Exception var13) {
			var13.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException var12) {
				var12.printStackTrace();
			}

		}

		return file;
	}
	 
	
	/*@Value("${httpApi}")
	private static String http; // api协议
	*/
	public static String backUrl(HttpServletRequest request) throws UnknownHostException {
		String strBackUrl = ConfigRefreshComponent.HTTP+ request.getServerName() //服务器地址
        + ":" 
        + request.getServerPort()           //端口号
        + request.getContextPath();     //项目名称
        //+ request.getServletPath()      //请求页面或其他地址
        //+ "?" + (request.getQueryString()); //参数
		//InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址
		//String hostAddress = address.getHostAddress();



		request.getSession().getServletContext().getRealPath("/");//获取项目所在服务器的全路径，如：D:\Program Files\apache-tomcat-7.0.25\webapps\TestSytem\
		request.getServletPath();    //获取客户端请求的路径名，如：/object/delObject
		request.getServerName() ;    //获取服务器地址，如：localhost
		request.getServerPort();     //获取服务器端口，如8080
		request.getContextPath();    //获取项目名称，如：TestSytem
		request.getLocalAddr();      //获取本地地址，如：127.0.0.1
		request.getLocalName();      //获取本地IP映射名，如：localhost
		request.getLocalPort();      //获取本地端口，如：8090
		request.getRealPath("/");    //获取项目所在服务器的全路径，如：D:\Program Files\apache-tomcat-7.0.25\webapps\TestSytem\
		request.getRemoteAddr();     //获取远程主机地址，如：127.0.0.1
		request.getRemoteHost();     //获取远程主机，如：127.0.0.1
		request.getRemotePort();     //获取远程客户端端口，如：3623
		request.getRequestedSessionId();      //获取会话session的ID，如：823A6BACAC64FB114235CBFE85A46CAA
		request.getRequestURI();     //获取包含项目名称的请求路径，如：/TestSytem/object/delObject
		request.getRequestURL().toString();   //获取请求的全路径，如：http://localhost:8090/TestSytem/object/delObject
		return strBackUrl;
	}
	
   public static void main(String[] args) throws IOException {
	   String urlPath = "http://localhost:8084/jxehs/file/demo/518987patch01.zip";
	   URL url = new URL(urlPath);
	   String realPath="E:\\Workspaces\\MyEclipse\\ehs-parent\\jiuxu-main\\src\\main\\webapp\\file\\518987patch01.zip";
	   httpURLConnectionUtil(url, realPath);
}
}
