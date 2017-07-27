package com.project.umang.cricquizzy;


public class Question {
    private String ques;
    private String [] options =  new String[4];
    private int occured;


     Question(String ques, String[] options,int occured)
    {
        this.ques = ques;
        this.occured = occured;
        this.options = options;

    }

    public String getQues()
    {
        return ques;
    }
    public String[] getOptions()
    {
        return options;
    }
    public int  getOccured(){return occured;}
}
