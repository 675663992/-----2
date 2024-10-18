package com.yhw.controller;

import cn.dev33.satoken.util.SaResult;
import com.yhw.algorithm.Algorithm;
import com.yhw.dto.ArchitecturesDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ProcessController {
    String title = null;
    String description = null;
    String url = null;
    ArchitecturesDto architectuesDto = new ArchitecturesDto(title,description,url);
    Algorithm algorithm = new Algorithm();
    @GetMapping("/process")
    public SaResult selectFunction(@RequestParam String architecture) throws IOException {
        System.out.println(architecture);
        if(architecture.equals("主程序-子程序")){
            title = "主程序-子程序";
            description = "在这种风格中，主程序通常负责程序的整体流程控制，包括调用子程序、管理数据和控制程序的执行顺序。子程序则是执行特定任务的独立模块，它们可以被主程序多次调用。这种风格的优点是结构清晰，易于理解和维护，尤其适合那些逻辑简单、功能明确的小型程序。缺点是随着程序规模的扩大，主程序可能会变得臃肿，子程序之间的耦合度也可能增加，这会降低程序的可维护性和可扩展性。";
            url = "https://github.com/675663992/SAexperiment2yanghaowen/blob/master/experiment2/src/main/java/org/example/%E4%B8%BB%E7%A8%8B%E5%BA%8F%E5%AD%90%E7%A8%8B%E5%BA%8F%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84/demo1.java";
            architectuesDto = new ArchitecturesDto(title,description,url);
            algorithm.cal(1);
        }else if(architecture.equals("面向对象")){
            title = "面向对象";
            description = "面向对象编程（OOP）是一种以对象为基本单位的编程范式，它通过类（Class）来定义对象的属性和方法。面向对象风格强调数据抽象、封装、继承和多态性。数据抽象允许开发者隐藏对象的内部实现细节，只暴露必要的接口。封装性保证了对象的内部状态不会被外部直接访问和修改，继承性使得新类可以复用现有类的代码，而多态性则允许不同类的对象对同一消息做出响应。这种风格适用于构建复杂系统，因为它提高了代码的可重用性和可维护性，同时也支持系统的扩展和演化。";
            url = "https://github.com/675663992/SAexperiment2yanghaowen/blob/master/experiment2/src/main/java/org/example/Main.java";
            architectuesDto = new ArchitecturesDto(title,description,url);
            algorithm.cal(2);
        }else if(architecture.equals("事件系统")){
            title = "事件系统";
            description = "事件驱动体系结构是一种以事件为中心的编程模型，程序的执行流程由事件的发生和处理来驱动。在这种风格中，组件（如事件监听器和事件处理器）对事件做出响应，并通过回调函数、消息队列或其他机制进行交互。这种风格特别适合于需要处理大量用户交互、网络通信或异步任务的系统。它的优点是组件之间的耦合度低，系统可以灵活地响应外部事件，但缺点是程序的执行流程可能变得难以跟踪和调试。";
            url = "https://github.com/675663992/SAexperiment2yanghaowen/blob/master/experiment2/src/main/java/org/example/%E4%BA%8B%E4%BB%B6%E7%B3%BB%E7%BB%9F%E8%BD%AF%E4%BB%B6%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84/Main.java";
            architectuesDto = new ArchitecturesDto(title,description,url);
            algorithm.cal(3);
        }else if(architecture.equals("管道-过滤器")){
            title = "管道-过滤器";
            description = "管道-过滤体系结构是一种数据流驱动的设计模式，其中数据通过管道从一个过滤器流向另一个过滤器。每个过滤器负责执行特定的数据处理任务，如数据转换、筛选或聚合。这种风格的优点是过滤器的独立性和可组合性，使得系统可以灵活地添加、移除或重新配置过滤器来处理不同的数据流。这种风格非常适合于需要处理大量数据流的系统，如文本处理、图像处理或数据挖掘应用。缺点是系统的性能可能会受到管道传输效率的影响，且在设计时需要仔细考虑数据流的同步和缓冲问题。";
            url = "https://github.com/675663992/SAexperiment2yanghaowen/blob/master/experiment2/src/main/java/org/example/%E7%AE%A1%E9%81%93%E8%BF%87%E6%BB%A4%E8%BD%AF%E4%BB%B6%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84/Main.java";
            architectuesDto = new ArchitecturesDto(title,description,url);
            algorithm.cal(4);
        }else{
            System.out.println("错误！！！");
            algorithm.cal(5);
        }
        return SaResult.get(200, "查询成功！", architectuesDto);
    }
}
