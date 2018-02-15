package com.laolang.notespring.aopone;

public class WaiterImpl implements IWaiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + " ...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving to " + name + " ...");
    }
}
