package util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;



public class FileUtils {

	public static int BUFFER_SIZE =500*1024*1024;
	
	/**
	 * 功能：Java读取txt文件的内容 ,逐行放到List中
	 * 
	 * 
	 * @param filePath
	 */
	public static List<String> readTxtFile(String filePath) {
		List<String> listFile = new ArrayList<String>();
		try {
			String encoding = "UTF-8";

			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				// BufferedWriter bufWriter = new BufferedWriter(new
				// FileWriter(outPath), 81920);
				while ((lineTxt = bufferedReader.readLine()) != null) {
					listFile.add(lineTxt);
				}

				read.close();
				// bufWriter.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return listFile;
	}

	

	/**
	 * 获得目录下所有文件列表（目录除外）
	 * 
	 * @param fileName
	 * @return
	 */
	public static List<File> getFileList(String fileName) {
		File file = new File(fileName);
		File[] arrFiles = file.listFiles();

		List<File> lstFiles = new ArrayList<File>();
		for (int i = 0; i < arrFiles.length; i++) {
			File fileTemp = arrFiles[i];
			if (!fileTemp.isDirectory()) {
				lstFiles.add(fileTemp);
			}

		}

		return lstFiles;

	}

	// 把数据输出到文件中
	public static void writeToFileCreate(List<String> lstContent, String outPath) {

		writeToFile(lstContent, outPath, false);
	}

	// 把数据输出到文件中(追加)
	public static void writeToFileAppend(List<String> lstContent, String outPath) {

		writeToFile(lstContent, outPath, true);
	}

	private static void writeToFile(List<String> lstContent, String outPath, boolean isAppend) {

		try {
			File fileOutput = new File(outPath);
			fileOutput.getParentFile().mkdirs();

			OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(fileOutput, isAppend),
					"UTF-8");
			BufferedWriter bufWriter = new BufferedWriter(writerStream, BUFFER_SIZE);

			for (String strText : lstContent) {
				bufWriter.write(strText);
				bufWriter.newLine();

			}
			bufWriter.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 从文本文件中读取源文件的路径，复制到目标目录中
	 * 
	 * @param txtFilePath 文本文件的路径
	 * @param destFileDir 目标目录名
	 * @param overlay  如果目标文件存在，是否覆盖
	 */
	public static void copyFileFromText(String txtFilePath,String destFileDir){
		List<String> lstFile=readTxtFile(txtFilePath);
		for(String txtFile:lstFile){
			File file= new File(txtFile);
			String fileNameAbsolute=file.getAbsolutePath();
			String destFileName=destFileDir+File.separator+file.getName();
			copyFile(fileNameAbsolute,destFileName,true);
		}
	}
	/**
	 * 复制单个文件
	 * 
	 * @param srcFileName
	 *            待复制的文件名
	 * @param descFileName
	 *            目标文件名
	 * @param overlay
	 *            如果目标文件存在，是否覆盖
	 * @return 如果复制成功返回true，否则返回false
	 */
	public static boolean copyFile(String srcFileName, String destFileName, boolean overlay) {
		File srcFile = new File(srcFileName);

		// 判断源文件是否存在
		if (!srcFile.exists()) {
			System.out.println("源文件：" + srcFileName + "不存在！");

			return false;
		} else if (!srcFile.isFile()) {

			System.out.println("复制文件失败，源文件：" + srcFileName + "不是一个文件！");
			return false;
		}

		// 判断目标文件是否存在
		File destFile = new File(destFileName);
		if (destFile.exists()) {
			// 如果目标文件存在并允许覆盖
			if (overlay) {
				// 删除已经存在的目标文件，无论目标文件是目录还是单个文件
				new File(destFileName).delete();
			}
		} else {
			// 如果目标文件所在目录不存在，则创建目录
			if (!destFile.getParentFile().exists()) {
				// 目标文件所在目录不存在
				if (!destFile.getParentFile().mkdirs()) {
					// 复制文件失败：创建目标文件所在目录失败
					return false;
				}
			}
		}

		// 复制文件
		int byteread = 0; // 读取的字节数
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];

			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			return true;
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (out != null) {
					out.close();
				}

				if (in != null) {
					in.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

