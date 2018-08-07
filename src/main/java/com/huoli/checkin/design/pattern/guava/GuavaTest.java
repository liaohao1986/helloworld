package com.huoli.checkin.design.pattern.guava;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Charsets;

public class GuavaTest {
    /**
    *
    * @param args
    * @throws IOException 
    */
    public static void main(String[] args) throws IOException {
        File from = new File("D:\\from.txt");
        File to = new File("D:\\to.txt");
        //一行代码读取内容存入list中  
        //        List<String> list = Files.readLines(from, Charsets.UTF_8);
        List<String> list = FileUtils.readLines(from, Charsets.UTF_8);
        FileUtils.writeLines(to, Charsets.UTF_8.name(), list);
        for (String string : list) {
            System.out.println(string);
        }

    }
}
