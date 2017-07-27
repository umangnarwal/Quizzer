package com.project.umang.cricquizzy;

import android.app.Application;
import java.util.ArrayList;

public class global extends Application {
   private int sum;
    private String name;
    private ArrayList<String> correct ;
    private ArrayList<Question> measure;
    private ArrayList<Question> area;
    private ArrayList<Question> questions;
    private ArrayList<Question> clock;

   public int getSum(){return sum;}

    public ArrayList<String> getCorrect() {
        return correct;
    }

    public void setCorrect(ArrayList<String> correct)
    {
        this.correct=correct;
    }
    public void setSum(int i){sum+=i;}
    public void add(int i){sum = i;}
    public void setName(String name)
    {
        this.name =name;
    }
    public String getName()
    {
        return name;
    }
    public ArrayList<Question> getMeasure()
    {
        return measure;
    }
    public ArrayList<Question> getArea()
    {
        return area;
    }
    public ArrayList<Question> getQuestions()
    {
        return questions;
    }
    public ArrayList<Question> getClock()
    {
        return clock;
    }

    public void global (ArrayList<String> correct,ArrayList<Question> measure,ArrayList<Question> area,ArrayList<Question> questions,ArrayList<Question> clock)
    {        this.correct = correct;
        this.area = area;
        this.measure = measure;
        this.clock=clock;
        this.questions=questions;
    }
}
