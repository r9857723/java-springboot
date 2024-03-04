package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class EpsonPrinter implements Printer {

    @Override
    public void print(String message) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }

}
