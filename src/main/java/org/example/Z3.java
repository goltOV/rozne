package org.example;

import java.util.HashMap;

public class Z3 {

    Z3(){
        System.out.println(find("ad1ę_rchobć"));
    }

    HashMap<String,Integer> find(String str){
        str = str.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("samogłoski",0);
        map.put("spółgłoski",0);
        map.put("liczby",0);
        map.put("znaki",0);
        String[] sam = {"a", "ą", "e", "ę", "i", "o", "u", "ó", "y"};
        String[] spl = {"b", "g", "ć", "m", "k"};  //ch - przy wystąpieniu c sprawdza czy następny element to h za pomocą isNextH
        String[] all =  "A Ą B C Ć D E Ę F G H I J K L Ł M N Ń O Ó P R S Ś T U W Y Z Ź Ż Q V X 0 1 2 3 4 5 6 7 8 9".toLowerCase().split(" ");

        boolean isNextH = false;
        for (String letter: str.split("")){
            boolean isZnak = true;
            breakAll:
            for (String element: all){
                if (element.equals(letter)){
                    isZnak = false;
                    break breakAll;
                }
            }
            if(isZnak){
                map.compute("znaki", (k, count) -> count + 1);
            }
            breakSam:
            for (String element: sam){
                if (element.equals(letter)){
                    map.compute("samogłoski", (k, count) -> count + 1);
                    break breakSam;
                }
            }
            breakSpl:
            for (String element: spl){
                if(isNextH){
                    map.compute("spółgłoski", (k, count) -> count + 1);
                    break breakSpl;
                }else if(letter.equals("c")){
                    isNextH = true;
                    break breakSpl;
                }else if (element.equals(letter)){
                    map.compute("spółgłoski", (k, count) -> count + 1);
                    break breakSpl;
                }
            }
            breakNum:
            for (int i = 0; i < 10; i++) {
                if (String.valueOf(i).equals(letter)){
                    map.compute("liczby", (k, count) -> count + 1);
                    break breakNum;
                }
            }
        }



        return map;
    }
}
