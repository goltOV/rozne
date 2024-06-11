package org.example;

import java.util.HashMap;

public class MyArrayUtils {
    int[] tab = new int[1000];



    MyArrayUtils(){
        for (int i = 0; i < tab.length; i++) {
            tab[i] = (int) Math.floor(Math.random()*201-100);
        }

//        przykład wyświetlenia dannych z countDuplicate() -
//
//        HashMap<Integer,Integer> map = countDuplicate();
//        for (int key: map.keySet()){
//            System.out.println(key+" | "+map.get(key));
//        }
//
//        lub poprostu -
//        System.out.println(map);

    }

    /**
     * wyszukiwanie największej liczby
     * @return int - max number
     */
    public int findMax(){
        int max = -100;
        for (int i = 0; i < tab.length; i++) {
            int num = tab[i];
            if(num>max) max = num;
        }
        return max;
    }

    /**
     * wyszukiwanie indeksu dannej liczby
     * @return int - index
     */
    public int findIndex(int num){
        for (int i = 0; i < tab.length; i++) {
            if(num == tab[i]) return i;
        }
        return -1;
    }

    /**
     * wyszukuje ilość podobnych liczb
     * @return HashMap<liczba, ilość wystąpień danej liczby>
     */
    public HashMap<Integer, Integer> countDuplicate(){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tab.length; i++) {
            int num = tab[i];
            if(map.containsKey(num)) {
                map.compute(num, (k, count) -> count + 1);
            }else map.put(num, 1);
        }
        return map;
    }
}
