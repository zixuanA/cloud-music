package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class JsonReader {
    //private static ArrayList<String> letters = new ArrayList <> (30);
    private static ArrayList<TreeMap>list =new ArrayList<>();
    public JsonReader() {
        super();
    }
        public ArrayList toMap(ArrayList<String> letters ) {
            for(int n=0,num=-1,flag=0;n<letters.size();n++) {
//           if(letters.get(n).)

                String stringa = null, stringb = null;
                for (int i = 0; i < letters.get(n).length(); i++) {
                    if(letters.get(n).charAt(i)=='{')
                        list.add(new TreeMap<String,String>());
                        //System.out.println(letters.get(n).charAt(i));
                        if (letters.get(n).charAt(i)==':') {
                            flag=1;
                        }

                        // System.out.println(flag);
                        if ((int)letters.get(n).charAt(i)>=48 &(int)letters.get(n).charAt(i)<=57|((int)letters.get(n).charAt(i)>=65 & (int)letters.get(n).charAt(i)<=122) |((int)letters.get(n).charAt(i)>=19967 & (int)letters.get(n).charAt(i)<=40869) ) {
                            if(flag==0){
                                if(stringa==null)
                                    stringa= String.valueOf(letters.get(n).charAt(i));
                                else
                                    stringa =stringa+letters.get(n).charAt(i);
                            }
                            if(flag==1){
                                if(stringb==null)
                                    stringb= String.valueOf(letters.get(n).charAt(i));
                                else
                                    stringb=stringb+letters.get(n).charAt(i);
                            }

                        }
                        if(stringa != null && stringb != null && flag == 1 ){
                            //System.out.println(stringa+"  "+stringb);
                            list.get(num).put(stringa, stringb);
                        }
                        if(letters.get(n).charAt(i)=='{')
                            num++;
                    }

                    if(flag==1){
                        flag=0;
                    }


                }

                return list;
            }

        }



