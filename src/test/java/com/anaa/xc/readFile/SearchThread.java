package com.anaa.xc.readFile;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dell on 2020/2/2.
 */
public class SearchThread extends Thread{



    @Test
    public void testSearch(){
        System.out.println("testSearch");
    }

    private File file;
    private String search;

    public SearchThread() {
    }

    public SearchThread(File file, String search) {
        this.file = file;
        this.search = search;
    }

    @Override
    public void run() {
        String fileContent = readFileConent(file);
        if(fileContent.contains(search)){
            System.out.printf("找到子目标字符串%s,在文件:%s%n",search,file);
        }
    }

    private String readFileConent(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            char[] length = new char[(int) file.length()];
            fileReader.read(length);
            System.out.println(length);
            return length.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
