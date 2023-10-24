package com.example.experimentforconstructure;

import com.example.experimentforconstructure.test1.demo1;
import com.example.experimentforconstructure.test4.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class ExperimentForConstructureApplication {

    public static void main(String[] args) throws IOException {
        Interface();
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice){
            case "1":
                main1();
                break;
            case "2":
                main2();
                break;
            case "3":
                main3();
                break;
            case "4":
                main4();
                break;
            default:
                System.out.println("请输入正确数字");
                break;
        }

    }
public static void main1()throws IOException{
    demo1 kwic = new demo1();
    kwic.input("D:\\JavaPro\\ExperimentForConstructure\\src\\main\\java\\com\\example\\experimentforconstructure\\input.txt");
    kwic.shift();
    kwic.alphabetizer();
    kwic.output("D:\\JavaPro\\ExperimentForConstructure\\src\\main\\java\\com\\example\\experimentforconstructure\\output.txt");
    System.out.println("主程序-子程序风格是一种最基本的软件体系结构风格， \n 它将软件系统划分为一个主程序和若干个子程序，主程序负责控制子程序的调用顺序和传递参数，\n 子程序负责实现具体的功能。主程序-子程序风格的优点是简单易懂，易于实现和测试； \n 缺点是耦合度高，可复用性低，可扩展性差。");
    }
    public static void main2()throws IOException{
        com.example.experimentforconstructure.test2.Input input = new com.example.experimentforconstructure.test2.Input();
        input.input("D:\\JavaPro\\ExperimentForConstructure\\src\\main\\java\\com\\example\\experimentforconstructure\\input.txt");
        com.example.experimentforconstructure.test2.Shift shift = new com.example.experimentforconstructure.test2.Shift(input.getLineTxt());
        shift.shift();
        com.example.experimentforconstructure.test2.Alphabetizer alphabetizer = new com.example.experimentforconstructure.test2.Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        com.example.experimentforconstructure.test2.Output output = new com.example.experimentforconstructure.test2.Output(alphabetizer.getKwicList());
        output.output("D:\\JavaPro\\ExperimentForConstructure\\src\\main\\java\\com\\example\\experimentforconstructure\\output.txt");
        System.out.println("面向对象风格是一种最流行的软件体系结构风格，它将软件系统划分为若干个对象，\n每个对象都有自己的属性和方法，对象之间通过消息传递进行交互。面向对象风格的优点是高内聚低耦合，\n易于复用和扩展，符合人类思维习惯；缺点是设计复杂度高，运行效率低，\n不适合处理并发和分布式问题。");
    }
    public static void main3()throws IOException{
        File inFile = new File("D:\\JavaPro\\ExperimentForConstructure\\src\\main\\java\\com\\example\\experimentforconstructure\\input.txt");
        File outFile = new File("D:\\JavaPro\\ExperimentForConstructure\\src\\main\\java\\com\\example\\experimentforconstructure\\output.txt");
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
        System.out.println("事件系统风格是一种基于事件驱动的软件体系结构风格，\n它将软件系统划分为若干个事件源和事件处理器，事件源负责产生事件并通知事件处理器\n，事件处理器负责响应事件并执行相应的操作。事件系统风格的优点是解耦度高，响应速度快，\n适合处理异步和实时问题；缺点是控制流不明确，调试困难，可靠性低。");
    }
    public static void main4()throws IOException{
        File inFile = new File("D:\\JavaPro\\ExperimentForConstructure\\src\\main\\java\\com\\example\\experimentforconstructure\\input.txt");
        File outFile = new File("D:\\JavaPro\\ExperimentForConstructure\\src\\main\\java\\com\\example\\experimentforconstructure\\output.txt");
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
        System.out.println("管道-过滤器风格是一种基于数据流的软件体系结构风格，它将软件系统划分为若干个过滤器和管道，\n过滤器负责对输入数据进行某种转换或处理，并输出结果数据，管道负责连接过滤器并传递数据。管道-过滤器风格的\n" +
                "管道-过滤器风格的优点是可并行性高，可复用性高，适合处理批量和流式数据；\n缺点是通信开销大，数据格式不统一，不适合处理交互和状态问题。");
    }
    public static void Interface(){
        System.out.println("请选择一种风格来处理输出文件：");
        System.out.println("1.主程序-子程序");
        System.out.println("2.面向对象");
        System.out.println("3.事件系统");
        System.out.println("4.管道-过滤器");
        System.out.println("请输入想要功能的对应数字: ");
    }
}
