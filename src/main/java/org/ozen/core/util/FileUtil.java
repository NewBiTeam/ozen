package org.ozen.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.ozen.core.util.Constants.uploadType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具类
 * 
 * @author Administrator
 *
 */
public class FileUtil {

	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	private static String[] imgType = { ".jpg", ".jpeg", ".gif", ".png" };

	/**
	 * 判断图片格式
	 * 
	 * @param fileItem
	 * @return
	 */
	public static boolean isImgType(String fileName) {
		for (int i = 0; i < imgType.length; i++) {
			if (fileName.substring(fileName.lastIndexOf(".")).equalsIgnoreCase(imgType[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean isVideoType(String fileName) {
		if (fileName.substring(fileName.lastIndexOf(".")).equalsIgnoreCase(".mp4")) {
			return true;
		}

		return false;
	}

	/**
	 * * 写文件到本地 * @param in * @param fileName * @throws IOException
	 */
	public static String uploadFiles(MultipartFile file, String filePath) throws IOException {
		File f = new File(filePath);
		// 如果这个目录不存在，就创建一个
		if (!f.exists()) {
			f.mkdirs();
		}
		String fileName = newFileName(file.getOriginalFilename());
		if (f.isDirectory()) {
			// System.out.println("文件夹");
			File[] filelist = f.listFiles();
			for (int i = 0; i < filelist.length; i++) {
				if (fileName.equals(filelist[i].getName())) {
					File a = new File(filelist[i].getAbsolutePath());
					a.delete();
				}
			}
		}
		FileOutputStream fs = new FileOutputStream(filePath + "/" + fileName);
		InputStream in = file.getInputStream();
		byte[] buffer = new byte[1024 * 1024];
		Integer bytesum = 0;
		Integer byteread = 0;
		while ((byteread = in.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		in.close();
		return fileName;
	}

	/**
	 * 上传文件并返回文件路径
	 * 
	 * @param in
	 *            文件流
	 * @param poster
	 *            上传文件类型枚举
	 * @return
	 */
	public static String uploadFile(MultipartFile file, uploadType poster) {
		String fileName = "";
		String filePath = ConfigProperties.getProperty("filePath") + "/" + poster;
		String path = "";
		try {
			fileName = uploadFiles(file, filePath);
			path = "/" + ConfigProperties.getProperty("path") + "/" + poster + "/" + fileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * 上传文件并返回文件物理路径
	 * 
	 * @param file
	 * @param poster
	 * @return
	 */
	public static String uploadFileReturnPhysicalPath(MultipartFile file, uploadType poster) {
		String fileName = "";
		String filePath = ConfigProperties.getProperty("filePath") + "/" + poster;
		String path = "";
		try {
			fileName = uploadFiles(file, filePath);
			path = filePath + "/" + fileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * 生成新的文件名(GUID+文件后缀)
	 * 
	 * @param fileName
	 *            以前的文件名
	 * @return (GUID+文件后缀)
	 */
	public static String newFileName(String fileName) {
		Assert.notNull(fileName);
		// String name = UUID.randomUUID().toString();
		String name = DateUtil.getCurrTime();
		// UUID name = UUID.randomUUID();
		if (fileName.indexOf(".") == -1) {
			return name;
		} else {
			return name + fileName.substring(fileName.indexOf("."), fileName.length());
		}
	}

	/**
	 * 读取文本文件所有内容
	 * 
	 * @param filePath
	 */
	public static String readTxtFile(String fileName) {
		StringBuffer strBuf = new StringBuffer();
		try {
			String path = "";
			File fDir = new File(FileUtil.class.getResource("/").getPath());
			String p = fDir.getAbsolutePath();
			path = p.replace("\\", "/") + "/" + path + "video/" + fileName + ".txt";
			String encoding = "UTF-8";
			File file = new File(path);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					strBuf.append(lineTxt + "\n");
				}
				read.close();
			} else {
				logger.error("找不到指定的文件");
			}
		} catch (Exception e) {
			logger.error("读取文件内容出错");
			e.printStackTrace();
		}
		return strBuf.toString();
	}

	/**
	 * 读取文本文件所有内容返回list
	 * 
	 * @param filePath
	 */
	public static List<String> readTxtFileList(String filePath) {
		List<String> list = new ArrayList<String>();
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (StringUtil.isNotEmpty(lineTxt)) {
						if (!lineTxt.contains("http://")) {
							lineTxt = "http://" + RandomGenerator.getRandomStrByLength() + "." + lineTxt;
						}
						list.add(lineTxt);
					}
				}
				read.close();
			} else {
				logger.error("找不到指定的文件");
			}
		} catch (Exception e) {
			logger.error("读取文件内容出错");
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		List<String> list = readTxtFileList("mf");
		int index = (int) (Math.random() * list.size());
		System.out.println(list.get(index));
	}

}
