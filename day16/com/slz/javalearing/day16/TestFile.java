package com.slz.javalearing.day16;

import java.io.File;
import java.io.IOException;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/22
 */
public class TestFile {
    public static void main(String[] args) throws InterruptedException {
        // 目录构造方法
        File dir = new File("javabase/resource");
        System.out.println(dir);
        // 文件构造方法
        File file = new File("javabase/resource/data.txt"); // 完整路径/相对路径
        File file1 = new File("javabase/resource", "data.txt"); // 目录 + 文件名
        File file2 = new File(dir, "data.txt"); // 目录对象 + 文件名
        System.out.println(file);
        System.out.println(file1);
        System.out.println(file2);

        // 创建文件 如果不存在，就创建并返回true，不存在则返回false
        File file3 = new File("javabase/resource/test.txt");
        try {
            boolean b = file3.createNewFile();
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建目录 如果不存在，就创建并返回true，不存在则返回false
        File dir1 = new File("javabase/resource/test");
        File dir2 = new File("javabase/resource/test1/test");
        boolean mkdir = dir1.mkdir(); // mkdir 如果上级目录不存在，就返回false，创建失败
        boolean mkdir1 = dir2.mkdirs(); // mkdirs 如果上级目录不存在，同时创建
        System.out.println(mkdir);
        System.out.println(mkdir1);
        // 文件删除 如果删除成功就返回true, 否则就返回false，文件不存在也返回false
        File file4 = new File("javabase/resource/test.txt");
        boolean delete = file4.delete();
//        file4.deleteOnExit(); // 虚拟机退出时删除文件，没有返回值，一般用于临时文件
//        Thread.sleep(5000); // 程序休眠
        System.out.println(delete);
        // 创建临时文件
        try {
            File tempFile = File.createTempFile("tmp_", ".txt"); // 存在系统空间一般是【Temp】
            tempFile.deleteOnExit(); // JVM退出时删除
            System.out.println(tempFile.getAbsolutePath()); // C:\Users\SunLZ\AppData\Local\Temp\...
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 目录循环删除
        File ff = new File("javabase/resource/test1/test/test.txt");
        try {
            ff.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File dir3 = new File("javabase/resource/test1/test");
        boolean delete1 = dir3.delete(); // 删除目录时，如果目录下有文件或目录，则删除失败
        System.out.println(delete1);
        // 获取目录下的所有文件
//        File[] files = dir3.listFiles();
//        if (files != null) {
//            for (File f : files) {
//                System.out.println(f);
//                f.delete(); // 先删除目录下存在的文件
//            }
//        }
//        boolean delete2 = dir3.delete(); // 再删除目录
//        System.out.println(delete2);
         // 目录递归删除，合理的做法
        delDir(dir3);

    }
    public static void delDir(File dir){ // 递归删除目录
        if(dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                // 判断当前循环到的是文件还是目录，如果是目录则递归删除
                if (file.isDirectory()) {
                    delDir(file);
                } else {
                    boolean delete = file.delete();
                    if (!delete) System.out.println("删除失败！");
                }
            }
        }
        boolean delete = dir.delete();
        if(!delete) System.out.println("删除失败！");
    }
}
