package util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

/**
 * 说明：压缩成zip
 *
 * @author kuangzuoqiang
 * @version 2013-6-18
 */
public class ZipUtil {

    //临时路径
    public static final String TMP_DIR = System.getProperty("java.io.tmpdir");

    public static final int BUFFER_SIZE = 1024;

    public static final String ENCODING = "GBK";

    /**
     * 多文件压缩
     *
     * @param files     文件列表
     * @param fileNames 文件名列表，每个zip项的名称
     * @return 返回文件
     * @throws IOException
     */
    public static final File doZip(File[] files, String[] fileNames) throws IOException {
        if (files.length != fileNames.length) {
            throw new IllegalArgumentException("参数异常，文件个数与文件名个数不相等");
        }

        File zipFile = new File(TMP_DIR + File.separator + UUID.randomUUID().toString() + ".zip");

        ZipArchiveOutputStream zipOutputStream;
        zipOutputStream = new ZipArchiveOutputStream(new FileOutputStream(zipFile));
        //设置文件名与评论编码
        zipOutputStream.setEncoding(ENCODING);

        //缓存区
        byte[] buffer = new byte[BUFFER_SIZE];
        //输入流
        InputStream inputStream = null;

        try {

            for (int i = 0; i < files.length; i++) {
                //zip项
                ZipArchiveEntry zipEntry = new ZipArchiveEntry(fileNames[i]);
                //将zip项放入zip文件中
                zipOutputStream.putArchiveEntry(zipEntry);

                //构建输入流，并将其内容输入至zip项中
                inputStream = new FileInputStream(files[i]);
                while (inputStream.read(buffer) > 0) {
                    zipOutputStream.write(buffer);
                }

                inputStream.close();
                //关闭当前zip项
                zipOutputStream.closeArchiveEntry();
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
        }

        return zipFile;
    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = new String[]{
                "撒地方.txt",
                "是.txt",
                "撒地方2.txt"
        };

        File[] files = new File[3];

        files[0] = new File("D:\\1.txt");
        files[1] = new File("D:\\2.txt");
        files[2] = new File("D:\\3.txt");

        File zipFile = doZip(files, fileNames);
        System.out.println(zipFile.getCanonicalPath());
    }
}
