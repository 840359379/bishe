package com.chuanmei.bishe.configure;

import org.springframework.web.multipart.MultipartFile;
import java.io.*;


public class SaveFile {

    public static boolean saveFile(final String savePath,final String fileFullName,final MultipartFile file) throws Exception {
        byte[] data = readInputStream(file.getInputStream());
        File uploadFile = new File(fileFullName);
        File fileDirectory = new File(savePath);
        synchronized (fileDirectory){
            if(!fileDirectory.exists()){
                if(!fileDirectory.mkdir()){
                    throw new Exception("保存文件的父文件夹创建失败！路径为：" + savePath);
                }
            }
            if (!fileDirectory.exists()) {
                if (!fileDirectory.mkdir()) {
                    throw new Exception("文件夹创建失败！路径为：" + savePath);
                }
            }
        }
        try (FileOutputStream outStream = new FileOutputStream(uploadFile)) {//写入数据
            outStream.write(data);
            outStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return uploadFile.exists();
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len;
        //使用一个输入流从buffer里把数据读取出来
        while ((len = inStream.read(buffer)) != -1) {
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }
}
