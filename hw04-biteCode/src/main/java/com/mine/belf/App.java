package com.mine.belf;

public class App {

    public static void main(String[] args) {
        Log myLog = IoC.createMyClass();
        myLog.calculation(6);

    }
}
