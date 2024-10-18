package com.yhw.algorithm.管道过滤软件体系结构;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File inFile = new File("E:\\study\\大三上\\软件体系结构\\实验2\\experiment2\\src\\main\\java\\org\\example\\input.txt");
        File outFile = new File("E:\\study\\大三上\\软件体系结构\\实验2\\experiment2\\src\\main\\java\\org\\example\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();
    }
}
