package com.project.umang.cricquizzy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.View.GONE;


public class firstPage extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView t1;
    global glo;
    int i;
    Question newo;
    String decide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        t1= (TextView)findViewById(R.id.textView2);
        radioGroup= (RadioGroup)findViewById(R.id.radio);
        glo = (global)getApplicationContext();
        i = getIntent().getIntExtra("count",0);
        ArrayList<Question> list = null;
        decide = getIntent().getStringExtra("decide");

        if(decide.equalsIgnoreCase("m"))
        {
            list = glo.getMeasure();
        }
        else if(decide.equalsIgnoreCase("a"))
        {
            list = glo.getArea();
        }
         else if(decide.equalsIgnoreCase("q"))
        {
            list = glo.getQuestions();
        }
        else
        {
            list = glo.getClock();
        }

        newo = list.get(i);

                t1.setText(newo.getQues());
                ((RadioButton)radioGroup.getChildAt(0)).setText(newo.getOptions()[0]);
                ((RadioButton)radioGroup.getChildAt(1)).setText(newo.getOptions()[1]);
                ((RadioButton)radioGroup.getChildAt(2)).setText(newo.getOptions()[2]);
                ((RadioButton)radioGroup.getChildAt(3)).setText(newo.getOptions()[3]);
        final Button button = (Button) findViewById(R.id.buttonp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(button.getRootView(),"Correct Answer is "+newo.getOptions()[newo.getOccured()], Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

   public void lock (View v ){
        int id = radioGroup.getCheckedRadioButtonId();
        View rb = radioGroup.findViewById(id);
        int index = radioGroup.indexOfChild(rb);
        if(index==newo.getOccured()){
            ImageView i_ = (ImageView)findViewById(R.id.imageView2);
            Toast.makeText(this, "CORRECT : +4", Toast.LENGTH_SHORT).show();glo.setSum(4);
            ArrayList<String> correct = glo.getCorrect();
            correct.add(i,"True");
            glo.setCorrect(correct);
        }
        else if (index==-1)
        {

        }
        else{

            Toast.makeText(this, "WRONG : -1", Toast.LENGTH_SHORT).show();glo.setSum(-1);
            ArrayList<String> correct = glo.getCorrect();
            correct.add(i,"False");
            glo.setCorrect(correct);
            Snackbar.make(v,"Correct Answer is "+newo.getOptions()[newo.getOccured()], Snackbar.LENGTH_SHORT)
                    .setAction("Action", null).show();}
       Button b1 = (Button)findViewById(R.id.button);
       b1.setVisibility(GONE);


        if(i<9){
            Intent l =new Intent(this,firstPage.class);
            l.putExtra("count",i+1);
            l.putExtra("decide",decide);
            startActivity(l);
            finish();
    }
        else
        {
            Intent l =new Intent(this,ResultActivity.class);
            startActivity(l);
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Do you want to exit the game ?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        startActivity(new Intent(firstPage.this,ResultActivity.class));
                        finish();

                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //Puting the value false for loggedin
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
