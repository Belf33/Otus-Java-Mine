package com.mine.belf;


import java.util.ArrayList;
import java.util.List;

class Benchmark implements BenchmarkMBean {
    private final int loopCounter;
    private volatile int size = 0;

    public Benchmark(int loopCounter) {
        this.loopCounter = loopCounter;
    }

    void run() throws InterruptedException {
        for (int idx = 0; idx < loopCounter; idx++) {
            int local = size;

            List<Object> myList = new ArrayList<>();

            for (int i = 0; i < local; i++) {
                Object[] array = new Object[local];
                for (int y = 0; y < 1000; y++) {
                    array[y] = new String(new char[0]);
                }
                myList.add(array);

            }

            for(int i = 0; i < local/2; i++) {
                myList.remove(i);
            }


            Thread.sleep(10); //Label_1
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        System.out.println("new size:" + size);
        this.size = size;
    }

}
