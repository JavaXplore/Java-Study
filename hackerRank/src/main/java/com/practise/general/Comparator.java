package com.practise.general;

public class Comparator {

    public boolean compare(int a, int b){
        return a==b;
    }


    public boolean compare(String a , String b){
        return a.trim().equals(b.trim());
    }


    public boolean compare(int[] a, int[] b){

        if (a.length == b.length) {
            for (int i =0; i<a.length;i++){
                if(a[i] != b[i]){
                    return false;
                }
            }
            return true;
        }
        return false;

    }
}
