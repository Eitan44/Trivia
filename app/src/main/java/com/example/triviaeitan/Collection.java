package com.example.triviaeitan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Collection {
    private ArrayList<Question> arr;
    private int index;
    public Collection(){
        arr = new ArrayList<>();
        Question q1 =new Question("1+10", "7", "11", "6", "9",2);
        Question q2 =new Question("1+4", "9", "5", "122", "33",2);
        Question q3 =new Question("3+3", "8", "6", "222", "13",2);
        Question q4 =new Question("4+6", "8", "10", "11", "190",2);
        Question q5 =new Question("7+2", "99", "9", "5", "4",2);

        arr.add((q1));
        arr.add((q2));
        arr.add((q3));
        arr.add((q4));
        arr.add((q5));
    }
    public void initQuestion()
    {
        index=0;
    }
    public Question getNextQuestion(){

        Question q =arr.get(index);
        index++;
        return q;
    }
    public boolean isNotLastQuestion(){
        return (index< arr.size());
    }
    public int getIndex(){
        return index;
    }



}
