package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer {
    // @Value("${printer.count:200}")
    // private int count;

    // @PostConstruct
    // public void inititalize() {
    //     count = 5;
    // }

    @Override
    public void print(String message) {
        // count--;
        System.out.println("Hp printer: " + message);
        // System.out.println("剩餘使用次數" + count);
    }
}
