package org.example;

import java.util.ArrayList;

public class Z1 {
    ArrayList<Integer> tab = new ArrayList<>();
    int tabLenght = 100; //dlugość tablicy

    Z1(){
        if (!(generate(tabLenght)==1)) tab = new ArrayList<>();
    }

    private int generate(int i) {
        if(i==tabLenght){
            for (int j = 0; j < i; j++) {
                tab.add(generate(20));
            }
            return 1;
        }else{
            return (int) Math.floor(Math.random()*i+1);
        }
    }
}
