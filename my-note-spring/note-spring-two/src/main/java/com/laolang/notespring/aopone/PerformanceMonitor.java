package com.laolang.notespring.aopone;

/**
 * 性能监视实现类
 */
public class PerformanceMonitor {

    // 通过一个ThreadLocal保存与调用线程相关的性能监视信息
    private static ThreadLocal<MethodPerformance> performanceThreadLocal = new ThreadLocal<MethodPerformance>();

    // 自动对某一目标方法的性能监视
    public static void begin(String method ){
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceThreadLocal.set(mp);
    }

    public static void end(){
        System.out.println("end monitor...");
        MethodPerformance mp = performanceThreadLocal.get();
        mp.printPerformance();
    }
}
