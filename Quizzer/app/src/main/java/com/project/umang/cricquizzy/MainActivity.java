package com.project.umang.cricquizzy;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final global glo = (global)getApplicationContext();
        correct = new ArrayList<>(10);
        int i ;
        for(i=0;i<10;i++)
            correct.add(i,"");
         final ArrayList<Question> measure = new ArrayList();
        measure.add(new Question("Q is as much younger than R as he is older than T. If the sum of the ages of R and T is 50 years,what is definitely the difference between R and Q's age?",new String[]{"1 year","2 years","3 year","Data inadequate"},3));
        measure.add(new Question("The sum of ages of 5 children born at the intervals of 3 years each is 50 years. What is the age of youngest child?",new String[]{"4 years","8 years","10 years","None of these"},0));
        measure.add(new Question("At present the ratio between the ages of Arun and Deepak is 4:3. After 6 years, Arun's age will be 26 years. What is the age of Deepak at present?",new String[]{"12 years","15 years", "19 and half", "21 years"},1));
        measure.add(new Question("A man is 24 years older than his son. In two years, his age will be twice the age of his son. The present age of his son is:",new String[]{"14 years","18 years","20 years","22 years"},3));
        measure.add(new Question("A is two years older than B who is twice as old as C. If the total of the ages of A, B and C be 27, how old is B ?",new String[]{"7","8","6","10"},3));
        measure.add(new Question("Six years ago,the ratio of the ages of Kunal and Sagar was 6:5. Four years hence,the ratio of their ages will be 11:10. What is the Sagar's age at present?",new String[]{"16 years","18 years","20 years","Cannot be determined"},0));
        measure.add(new Question("The present ages of three persons in proportions 4:7:9. Eight years ago, the sum of their ages was 56. Find their present ages.",new String[]{"8,10,28","16,28,36","20,35,45","None of these"},1));
        measure.add(new Question("Sachin is younger than Rahul by 7 years. If the ages if Sachin and Rahul are in the respective ratio of 7:9, how old is Sachin?",new String[]{"16 years","18 years","28 years","24.5 years"},3));
        measure.add(new Question("A father said to his son, ' I was as old as you are at the time of your birth'. If the father's age is 38 years now, the son's age five years back was" ,new String[]{"14 years","19 years","33 years","38 years"},0));
        measure.add(new Question("A person's present age is two-fifth of the age of his mother. After 8 years, he will be one-half of the age of his mother. How old is the mother at present?" ,new String[]{"32 years","36 years","40 years","48 years"},2));



        final ArrayList<Question> area = new ArrayList();
       area.add(new Question("What is the least number of squares tiles requied to pave the floor of a room 15 m 17 cm long and 9 m 2 cm broad?",new String[]{"814","820","840","844"},0));
        area.add(new Question("A towel, when bleached, was found to have lost 20% of  its length and 10% of its breadth. The percentage of decrease in area is :",new String[]{"10%","10.8%","20%","28%"},3));
       area.add(new Question("An error of 2% in excess is made while measuring the side of a square. The percentage of error in the calculated area of the sqaure is:",new String[]{"2%","2.02%","4%","4.04%"},3));
        area.add(new Question("A rectangular field is to be fenced on three sides leaving a side of 20 feet uncovered. If the area of the field is 680 sq. feet, how many feet of fencing will be required?",new String[]{"34","40","68","88"},3));
        area.add(new Question("The diagonal of the floor of a rectangular closet is 7.5 feet. The shorter side of the closet is 4.5 feet. What is the area of the closet in square feet?",new String[]{"26","25","27","37"},2));
        area.add(new Question("The length of a rectangular is halved, whle its breadth is tripled. What is the percentage change in area?",new String[]{"25%","50%","75%","80%"},1));
        area.add(new Question("The difference between the length and beadth of a rectangle is 23m. If its perimeter is 206m , then it sarea is",new String[]{"1520 m.sq.","2420 m.sq.","2480 m.sq.","2520 m.sq."},3));
        area.add(new Question("A tank is 25 m long, 12 m wide and 6 m deep. The cost of plastering its walls and bottom at 75 paise per sq. m, is :",new String[]{"Rs. 456","Rs. 458","Rs. 558","Rs. 568"},2));
        area.add(new Question("The percentage increase in the area of a rectangle, if each of its sides is increased by 20% is:",new String[]{"40%","42%","44%","46%"},2));
        area.add(new Question("A man walked diagonally across a square lot. Approximately, what was the percent saved by not walking along the edges?",new String[]{"20","24","30","33"},2));

        final ArrayList<Question> questions = new ArrayList();
        questions.add(new Question("The average of 20 numbers is zero. Of them, at the most,  how many may be greater than zero?",new String[]{"0","1","10","19"},3));
        questions.add(new Question("The average age of husband, wife and their child 3 years ago was 27 years and that of wife and the child 5 years ago was 20 years. The present age of the husband is:",new String[]{"35","40","50","None of these"},1));
        questions.add(new Question("A library has an average of 510 visitors on Sundays and 240 on other days. The average number of visitors per day in a month of 30 days beginning with a Sunday is",new String[]{"250","276","280","285"},3));
        questions.add(new Question("If the average marks of three bacthes of 55,60 and 45 students respectively is 50, 55 and 60, then the average marks of all students is:",new String[]{"53.33","54.68","55.63","67.09"},1));
        questions.add(new Question("The average weight of A, B and C is 45 kg. If the average weight of A and B be 40 kg and that of B and C be 43 kg, then the weight of B is",new String[]{"17 kg","20 kg","26 kg","31 kg" },3));
        questions.add(new Question("The average weight of 16 boys in a class is 50.25 kg and that of remaining 8 boys is 45.15 kg. Find the average weights of all the boys in class.",new String[]{"47.55 kg","48 kg","48.55 kg","49.25 kg"},2));
        questions.add(new Question("The average weight of 8 person's increases by 2.5 kg when a new person comes in place of them weighing 65 kg. What might be the weight of the new person?",new String[]{"76","80","85","90"},2));
        questions.add(new Question("In the first 10 overs of a cricket game, the run rate was only 3.2. What should be the run rate in the remaining 40 overs to reach a target of 282 runs?",new String[]{"6.25","6.5","6.75","7"},0));
        questions.add(new Question("The pupil's marks were wrongly entered as 83 instead of 63. Due to that average marks for the class got increased by half. The number of pupils in the class is :",new String[]{"10","20","40","73"},2));
        questions.add(new Question("The car owner buys petrol at Rs. 7.50, Rs. 8 and Rs. 8.50 per litre for three successive years. What approximately is the average cost per litre if he spends Rs. 4000 each year?",new String[]{"7.98","8","8.50","9"},0));

        final ArrayList<Question> clock = new ArrayList();
        clock.add(new Question("The angle between the minute hand and the hour hand of the clock when the time is 8.30,is :",new String[]{"80 degree","75 degree","60 degree","105 degree"},1));
        clock.add(new Question("The reflex angle between the hands of a clock at 10.25 is:",new String[]{"180 degree","192.5 degree","195 degree","197.5 degree"},3));
        clock.add(new Question("How many times do the hands of a clock coincide in a day ?",new String[]{"20","21","22","24",},2));
        clock.add(new Question("At what angle the hands of a clock are inclined at 15 minutes past 5?",new String[]{"58.2","64","67.5","72.5"},2));
        clock.add(new Question("A clock is started at noon. By 10 minutes past 5, the hour hand has turned through:",new String[]{"180 degree","192.5 degree","195 degree","155 degree"},3));
        clock.add(new Question("The angle between the minute hand and the hour hand of a clock when the time is 4.20, is:",new String[]{"0 degree","5 degree","10 degree","20 degree"},2));
        clock.add(new Question("How many times in a day, the hands of a clock are straight?",new String[]{"22","24","44","48"},2));
        clock.add(new Question("At 3.40, the hour hand and the minute hand of a clock form an angle of:",new String[]{"180 degree","130 degree","195 degree","155 degree"},1));
        clock.add(new Question("How many times in a day, are the hands of a clock in straight line but in opposite direction?",new String[]{"20","22","24","48"},1));
        clock.add(new Question("A watch which gains uniformly is 2 minutes low at noon on Monday and is 4 min. 48 sec fast at 2 p.m. on the  following Monday. When was it correct?",new String[]{"2 pm on Tuesday","2 pm on Wednesday","3 pm on Thursday","1 pm on Friday"},1));


        glo.global(correct,measure,area,questions,clock);
        glo.setSum(0);
        ImageView i1 = (ImageView) findViewById(R.id.imageView1);
        ImageView i2 = (ImageView) findViewById(R.id.imageView2);
        ImageView i3 = (ImageView) findViewById(R.id.imageView3);
        ImageView i4 = (ImageView) findViewById(R.id.imageView4);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,firstPage.class);
                intent.putExtra("count",0);
                intent.putExtra("decide","m");
                startActivity(intent);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,firstPage.class);
                intent.putExtra("count",0);
                intent.putExtra("decide","a");
                startActivity(intent);

            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,firstPage.class);
                intent.putExtra("count",0);
                intent.putExtra("decide","q");
                startActivity(intent);

            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,firstPage.class);
                intent.putExtra("count",0);
                intent.putExtra("decide","c");
                startActivity(intent);


            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        int i;
        for(i=0;i<10;i++)
            correct.add(i,"");
    }
}
