package org.example;

import org.example.主程序子程序体系结构.demo1;
import org.example.事件系统软件体系结构.KWICSubject;
import org.example.管道过滤软件体系结构.Pipe;
import org.example.面向对象软件体系结构.Alphabetizer;
import org.example.面向对象软件体系结构.Input;
import org.example.面向对象软件体系结构.Output;
import org.example.面向对象软件体系结构.Shift;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int x = 4;
        String inputFileName = "src\\main\\java\\org\\example\\input.txt";
        String outputFileName = "src\\main\\java\\org\\example\\output.txt";
        if(x == 1) {
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
        }else if(x == 2){
            // 管道过滤软件体系结构
            System.out.println("当前是管道过滤软件体系结构！");
            File inFile = new File(inputFileName);
            File outFile = new File(outputFileName);
            Pipe pipe1 = new Pipe();
            Pipe pipe2 = new Pipe();
            Pipe pipe3 = new Pipe();
            org.example.管道过滤软件体系结构.Input input = new org.example.管道过滤软件体系结构.Input(inFile, pipe1);
            org.example.管道过滤软件体系结构.Shift shift = new org.example.管道过滤软件体系结构.Shift(pipe1, pipe2);
            org.example.管道过滤软件体系结构.Alphabetizer alphabetizer  = new org.example.管道过滤软件体系结构.Alphabetizer(pipe2, pipe3);
            org.example.管道过滤软件体系结构.Output output = new org.example.管道过滤软件体系结构.Output(outFile,pipe3);
            input.transform();
            shift.transform();
            alphabetizer.transform();
            output.transform();
        }else if(x == 3){
            // 事件系统软件体系结构
            System.out.println("当前是事件系统软件体系结构！");
            //创建主题
            KWICSubject kwicSubject = new KWICSubject();
            //创建观察者
            org.example.事件系统软件体系结构.Input input = new org.example.事件系统软件体系结构.Input(inputFileName);
            org.example.事件系统软件体系结构.Shift shift = new org.example.事件系统软件体系结构.Shift(input.getLineTxt());
            org.example.事件系统软件体系结构.Alphabetizer alphabetizer = new org.example.事件系统软件体系结构.Alphabetizer(shift.getKwicList());
            org.example.事件系统软件体系结构.Output output = new org.example.事件系统软件体系结构.Output(alphabetizer.getKwicList(), outputFileName);
            // 将观察者加入主题
            kwicSubject.addObserver(input);
            kwicSubject.addObserver(shift);
            kwicSubject.addObserver(alphabetizer);
            kwicSubject.addObserver(output);
            // 逐步调用各个观察者
            kwicSubject.startKWIC();
        }else if(x == 4){
            // 主程序子程序软件体系结构
            System.out.println("当前是主程序子程序体系结构！");
            demo1 kwic = new demo1();
            kwic.input(inputFileName);
            kwic.shift();
            kwic.alphabetizer();
            kwic.output(outputFileName);
        }else{
            System.out.println("选择不合理！");
        }

    }
}
