package com.anaa.xc.readFile;

import java.io.File;

/**
 * Created by dell on 2020/2/2.
 */
public class TestThread {

    public static void search(File file, String search) {
        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
                //当找到.java文件的时候，就启动一个线程，进行专门的查找
                new SearchFileThread(file,search).start();
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }

    public static void main(String[] args) {
        File folder =new File("d:\\project");
        search(folder,"Magic");
    }
}
