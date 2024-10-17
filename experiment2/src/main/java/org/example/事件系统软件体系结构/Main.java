package org.example.事件系统软件体系结构;

public class Main {
    public static void main(String[] args) {
        //创建主题
        KWICSubject kwicSubject = new KWICSubject();
        //创建观察者
        Input input = new Input("E:\\study\\大三上\\软件体系结构\\实验2\\experiment2\\src\\main\\java\\org\\example\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "E:\\study\\大三上\\软件体系结构\\实验2\\experiment2\\src\\main\\java\\org\\example\\output.txt");

        // 将观察者加入主题
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        // 逐步调用各个观察者
        kwicSubject.startKWIC();
    }
}
