package com.project.umang.cricquizzy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    int cor;
    int incor;
    int skip;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final global glo = (global)getApplicationContext();
        cor=0;
        incor=0;
        skip=0;
        TextView tfive = (TextView)findViewById(R.id.textView5);
        tfive.setText("SCORE : "+ Integer.toString(glo.getSum()));
        glo.add(0);
        ArrayList<String> correct = glo.getCorrect();
        for(i=0;i<10
                ;i++){
            if(correct.get(i).equalsIgnoreCase("True"))
            {
                cor++;
            }
            else if(correct.get(i).equalsIgnoreCase("False"))
            {
                incor++;
            }
            else
            {
                skip++;
            }
        }
        TextView t1 = (TextView)findViewById(R.id.t1);
        TextView t2 = (TextView)findViewById(R.id.t2);
        TextView t3 = (TextView)findViewById(R.id.t3);

        t1.setText("Correct : "+String.valueOf(cor));
        t2.setText("Incorrect : "+String.valueOf(incor));
        t3.setText("Not attempted: "+String.valueOf(skip));


    }


    }

