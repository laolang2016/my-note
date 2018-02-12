package com.laolang.notespring.aopone;

/**
 * 记录性能监视信息
 */
public class MethodPerformance {

    private long begin;

    private long end;

    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod + " 花费 " + elapse + " 毫秒");
    }
}