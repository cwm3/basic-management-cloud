package com.cwm3.file.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.cwm3.common.core.utils.SpringUtils;
import lombok.SneakyThrows;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;


public class HdfsUtils {
    public static String HDFS_IP ;

    public final static String HDFS_PORT = "8020";

    private  static String HDFS_DEFAULT_PREFIX;

    static {
        Environment environment = SpringUtils.getApplicationContext().getEnvironment();
        HDFS_IP = environment.getProperty("hdfs.ip");
        HDFS_DEFAULT_PREFIX = "hdfs://" + HDFS_IP + ":" + HDFS_PORT ;
    }

    /**
     * @描述: 读取文件, 用当前系统的配置
     * @入参: remoteFilePath : HDFS路径
     * @出参:
     * @作者: 余家鑫
     * @日期: 2021/1/14 上午11:07
     */
    public static String catBigFile(String remoteFilePath) {
        Configuration conf = new Configuration();
        conf.set("fs.default.name", HDFS_DEFAULT_PREFIX);
        String ret ="";
        try {
            System.out.println("读取文件: " + remoteFilePath);
            ret = cat(conf, remoteFilePath);
            System.out.println("读取完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 读取文件内容
     */
    public static String cat(Configuration conf, String remoteFilePath) throws IOException {
        FileSystem fs = FileSystem.get(conf);
        Path remotePath = new Path(remoteFilePath);
        FSDataInputStream in = fs.open(remotePath);
        StringBuffer buffer = new StringBuffer();
        JSONArray json = new JSONArray();
        BufferedReader d = new BufferedReader(new InputStreamReader(in,"utf-8"));
        String line = null;
        while ((line = d.readLine()) != null) {
           /* String[] strarray = line.split(" ");
            for (int i = 0; i < strarray.length; i++) {
                System.out.print(strarray[i]);
                System.out.print(" ");


            }*/
            buffer.append(line);
//            json.add(JSONObject.parseObject(line));
//            System.out.println(" ");
            // System.out.println(line);

            // System.out.print(strarray[0]);
        }
        d.close();
        in.close();
        fs.close();
        return buffer.toString();
    }

    /**
     * 主函数
     */
    public static String getFileLen(String args) {
        Configuration conf = new Configuration();
        JSONObject js =  JSONObject.parseObject(args);
        conf.set("fs.default.name", js.get("hdfs").toString());
        String remoteFilePath = js.get("file").toString(); // HDFS路径
        String ret ="";
        try {
            System.out.println("读取文件: " + remoteFilePath);
            ret = cat(conf, remoteFilePath);
            System.out.println("读取完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static void getFileLen1(String dsf) {
        try {
//             dsf = "hdfs://hadoop1:9000/tmp/wordcount/kkk.txt";
            Configuration conf = new Configuration();

            FileSystem fs = FileSystem.get(URI.create(dsf), conf);
            FSDataInputStream hdfsInStream = fs.open(new Path(dsf));

            byte[] ioBuffer = new byte[1024];
            int readLen = hdfsInStream.read(ioBuffer);
            while (readLen != -1) {
                System.out.write(ioBuffer, 0, readLen);
                readLen = hdfsInStream.read(ioBuffer);
            }
            hdfsInStream.close();
            fs.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        return readLen;
    }

    /**
     * @description:
     * @Param: localFilePath 上传文件路径
     * @Param: remoteFilePath : hdfs的路径
     * @return:
     * @author: chengweiming
     * @time: 2021/1/19 10:28
     */

    @SneakyThrows
    public static void uploadFile (String localFilePath, String remoteFilePath) {
        //1 创建连接
        Configuration conf = new Configuration();
        //2 连接端口
        conf.set("fs.defaultFS", HDFS_DEFAULT_PREFIX);
        //3 获取连接对象
        FileSystem fs = FileSystem.get(conf);
        //deleteFile(fs,"/spark/省内重点区域人口联系度.csv");
        fs.copyFromLocalFile(new Path(localFilePath), new Path(remoteFilePath));
        fs.close();
    }

    /**
     * 删除文件
     */
    public static boolean deleteFile() {
        //1 创建连接
        Configuration conf = new Configuration();
        //2 连接端口
        conf.set("fs.defaultFS", HDFS_DEFAULT_PREFIX);
        String file = "/tmp/spark/";
        try {
            //3 获取连接对象
            FileSystem fs = FileSystem.get(conf);
            boolean result = fs.delete(new Path(file), true);
            return result;
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e);
        }
        return false;
    }
    /**
     * 创建文件夹
     */
    public static boolean HdfsMkdirs() {
        try {
        //1 创建连接
        Configuration conf = new Configuration();
        //2 连接端口
        conf.set("fs.defaultFS", HDFS_DEFAULT_PREFIX);
        String file = "/tmp/spark/";
            //3 获取连接对象
            FileSystem fs = FileSystem.get(conf);
            System.out.println(fs);
            Path dirPath = new Path(file);
            if (!fs.exists(dirPath)) {
                boolean mkdirs = fs.mkdirs(dirPath);
                System.out.println("创建文件："+dirPath.getName()+":"+mkdirs);
            } else {
                System.out.println("文件已存在");
            }
            System.out.println("OK");
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e);
        }
        return false;

    }

    public static void main(String[] args) {

        deleteFile();
        HdfsMkdirs();
    }


}
