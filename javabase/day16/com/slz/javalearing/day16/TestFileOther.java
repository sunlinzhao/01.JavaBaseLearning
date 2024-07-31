package com.slz.javalearing.day16;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestFileOther {
    public static void main(String[] args) {
        File file = new File("./javabase/resource/hello.txt");
        // 获取文件名
        System.out.println(file.getName());
        // 获取目录名
        System.out.println(file.getParent());
        // 获取所在目录
        File parentFile = file.getParentFile();
        System.out.println(parentFile.getName());
        // 获取文件大小 单位： 字节
        System.out.println(file.length()); // 单位： 字节
//        // 设置应用程序对文件是否可执行
//        file.setExecutable(true);
//        // 设置应用程序对文件是否可读
//        file.setReadable(true);
//        // 设置应用程序对文件是否可写
//        file.setWritable(true);
        // 测试应用程序对文件是否可执行
        boolean b = file.canExecute();
        System.out.println(b);
        // 测试应用程序对文件是否可读
        boolean b1 = file.canRead();
        System.out.println(b1);
        // 测试应用程序对文件是否可写
        boolean b2 = file.canWrite();
        System.out.println(b2);
        // 获取文件路径
        System.out.println(file.getPath());  // 1. 这里获取的与File file = new File("...")构建时传入的参数一致
        System.out.println(file.getAbsolutePath()); // 2. 获取绝对路径
        try {
            System.out.println(file.getCanonicalPath());  // 3. 精准获取绝对路径方式，可去除在构造时给的相对路径的 ./../.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 获取文件最后修改时间
        // file.lastModified() 返回long时间戳
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault())));
        // 获取磁盘空间的操作
        // 获取文件按所在磁盘总容量 字节
        System.out.println(file.getTotalSpace());
        // 获取文件按所在磁盘剩余容量 字节
        System.out.println(file.getFreeSpace());
        // 获取JVM可用空间大小
        System.out.println(file.getUsableSpace());
        // 获取所有磁盘分区, 返回分区根路径的File对象组成的File数组
        File[] disks = File.listRoots();
        Arrays.stream(disks).forEach(System.out::println);
        // 对文件的重命名 可以将文件命名到其他目录(已存在)或盘符下
        // 可以实现文件剪切工作
        boolean b3 = file.renameTo(new File("./javabase/resource/hello.txt"));
        System.out.println(b3);
        // 判断文件是否是隐藏文件
        boolean b4 = file.isHidden();
        System.out.println(b4);
    }
}
