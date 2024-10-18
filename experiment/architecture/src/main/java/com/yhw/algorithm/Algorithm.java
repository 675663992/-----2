package com.yhw.algorithm;

import com.yhw.algorithm.主程序子程序体系结构.demo1;
import com.yhw.algorithm.事件系统软件体系结构.KWICSubject;
import com.yhw.algorithm.管道过滤软件体系结构.Pipe;
import com.yhw.algorithm.面向对象软件体系结构.Alphabetizer;
import com.yhw.algorithm.面向对象软件体系结构.Input;
import com.yhw.algorithm.面向对象软件体系结构.Output;
import com.yhw.algorithm.面向对象软件体系结构.Shift;

import java.io.File;
import java.io.IOException;

public class Algorithm {
    public void cal(int x) throws IOException {
        String inputFileName = "src\\main\\java\\com\\yhw\\algorithm\\input.txt";
        String outputFileName = "src\\main\\java\\com\\yhw\\algorithm\\output.txt";
        if(x == 1){
            // 主程序子程序软件体系结构
            System.out.println("当前是主程序子程序体系结构！");
            demo1 kwic = new demo1();
            kwic.input(inputFileName);
            kwic.shift();
            kwic.alphabetizer();
            kwic.output(outputFileName);
        }else if(x == 2) {
            // 面向对象体系结构
            System.out.println("当前是面向对象体系结构！");
            Input input = new Input();
            input.input(inputFileName);
            Shift shift = new Shift(input.getLineTxt());
            shift.shift();
            Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
            alphabetizer.sort();
            Output output = new Output(alphabetizer.getKwicList());
            output.output(outputFileName);
        }else if(x == 3){
            // 事件系统软件体系结构
            System.out.println("当前是事件系统软件体系结构！");
            //创建主题
            KWICSubject kwicSubject = new KWICSubject();
            //创建观察者
            com.yhw.algorithm.事件系统软件体系结构.Input input = new com.yhw.algorithm.事件系统软件体系结构.Input(inputFileName);
            com.yhw.algorithm.事件系统软件体系结构.Shift shift = new com.yhw.algorithm.事件系统软件体系结构.Shift(input.getLineTxt());
            com.yhw.algorithm.事件系统软件体系结构.Alphabetizer alphabetizer = new com.yhw.algorithm.事件系统软件体系结构.Alphabetizer(shift.getKwicList());
            com.yhw.algorithm.事件系统软件体系结构.Output output = new com.yhw.algorithm.事件系统软件体系结构.Output(alphabetizer.getKwicList(), outputFileName);
            // 将观察者加入主题
            kwicSubject.addObserver(input);
            kwicSubject.addObserver(shift);
            kwicSubject.addObserver(alphabetizer);
            kwicSubject.addObserver(output);
            // 逐步调用各个观察者
            kwicSubject.startKWIC();
        }else if(x == 4){
            // 管道过滤软件体系结构
            System.out.println("当前是管道过滤软件体系结构！");
            File inFile = new File(inputFileName);
            File outFile = new File(outputFileName);
            Pipe pipe1 = new Pipe();
            Pipe pipe2 = new Pipe();
            Pipe pipe3 = new Pipe();
            com.yhw.algorithm.管道过滤软件体系结构.Input input = new com.yhw.algorithm.管道过滤软件体系结构.Input(inFile, pipe1);
            com.yhw.algorithm.管道过滤软件体系结构.Shift shift = new com.yhw.algorithm.管道过滤软件体系结构.Shift(pipe1, pipe2);
            com.yhw.algorithm.管道过滤软件体系结构.Alphabetizer alphabetizer  = new com.yhw.algorithm.管道过滤软件体系结构.Alphabetizer(pipe2, pipe3);
            com.yhw.algorithm.管道过滤软件体系结构.Output output = new com.yhw.algorithm.管道过滤软件体系结构.Output(outFile,pipe3);
            input.transform();
            shift.transform();
            alphabetizer.transform();
            output.transform();
        }else{
            System.out.println("选择不合理！");
        }

    }
}
