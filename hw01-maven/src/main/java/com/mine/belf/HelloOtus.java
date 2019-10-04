package com.mine.belf;


import java.util.List;

import static com.google.common.collect.Lists.newLinkedList;

public class HelloOtus {

    public static void main(String[] args) {
        String test = "test";

        List<String> arrayList = newLinkedList();
        arrayList.add(test);

        for(String s : arrayList) {
            System.out.println(s);
        }
    }
}
