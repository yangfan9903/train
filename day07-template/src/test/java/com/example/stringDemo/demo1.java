package com.example.stringDemo;

public class demo1 {
    public static void main(String[] args) {
        int a = myAtoi("312dasda1231");
        System.out.println(a);
    }
        public static int myAtoi(String s) {
            String k = "";
            boolean i = true;
            boolean j = true;
            boolean x = true;
            Long num;
            Integer trueNum;
            if(!s.isEmpty()){
                for(int m=0;m<s.length();m++){
                    Character s1 = s.charAt(m);
                    if(Character.isWhitespace(s1)&&j&&x){
                        if(m==s.length()-1){
                            k = k.concat("0");
                            break;
                        }}else if(Character.toString(s1).equals("-")&&j&&x){
                        i = false;
                        x = false;
                        if(m==s.length()-1){
                            k = k.concat("0");
                            break;
                        }
                    }else if(Character.toString(s1).equals("+")&&j&&x){
                        i = true;
                        x = false;
                        if(m==s.length()-1){
                            k = k.concat("0");
                            break;
                        }
                    }
                    else if(Character.isDigit(s1)){
                        k=k.concat(String.valueOf(s1));
                        j=false;
                    }
                    else if(j){
                        k = k.concat("0");
                        break;
                    }else{
                        break;
                    }
                }
            }else{
                k = k.concat("0");
            }
            System.out.println(k);
            if(k.equals("0")){
                return 0;
            }
            int f = k.length();
            for(int n=0;n<f;n++){
                if(k.startsWith("0")){
                    k = k.substring(1);
                }
                if(k.length()==0){
                    return 0;
                }
            }
            System.out.println(k);
            if(k.length()>10){
                if(i){
                    return (int) (Math.pow(2,31)-1);
                }else{
                    return (int) -Math.pow(2,31);
                }

            }
            if(i){
                num = Long.parseLong(k);
            }else{
                num = -Long.parseLong(k);
            }
            System.out.println(num);
            if(num>=Math.pow(2,31)-1){
                trueNum =  (int) (Math.pow(2,31)-1);
            }else if(num<=-Math.pow(2,31)){
                trueNum = (int) -Math.pow(2,31);
            }else if(i){
                trueNum = Integer.parseInt(k);
            }else{
                trueNum = -Integer.parseInt(k);
            }
            return trueNum;
        }
    }
