package com.example.gpa_10801160_calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    //Creating variables to point to point to views
    private EditText P_E_T_grade1, P_E_T_grade2, P_E_T_grade3, P_E_T_grade4, P_E_T_grade5;
    private EditText P_E_T_credit1, P_E_T_credit2, P_E_T_credit3, P_E_T_credit4, P_E_T_credit5;
    private Button P_B_doMath;
    private TextView P_T_V_gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ini variables
        P_E_T_grade1 =findViewById(R.id.E_T_grade1);
        P_E_T_grade2 =findViewById(R.id.E_T_grade2);
        P_E_T_grade3 =findViewById(R.id.E_T_grade3);
        P_E_T_grade4 =findViewById(R.id.E_T_grade4);
        P_E_T_grade5 =findViewById(R.id.E_T_grade5);

        P_E_T_credit1 =findViewById(R.id.E_T_credit1);
        P_E_T_credit2 =findViewById(R.id.E_T_credit2);
        P_E_T_credit3 =findViewById(R.id.E_T_credit3);
        P_E_T_credit4 =findViewById(R.id.E_T_credit4);
        P_E_T_credit5 =findViewById(R.id.E_T_credit5);

        P_B_doMath = findViewById(R.id.doMathBut);

        P_T_V_gpa = findViewById(R.id.T_V_gpaValue);


        P_B_doMath.setTag(1);
        P_B_doMath.setText(R.string.doMath);
        //When button is pressed do:
        P_B_doMath.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int name = (Integer) v.getTag();

                if (name==1){
                    doGpaMath();
                    P_B_doMath.setText(R.string.clear);
                    v.setTag(0);
                }else if(name==0){
                    P_B_doMath.setText(R.string.doMath);
                    v.setTag(1);
                    changeBg(Float.MAX_VALUE);
                }
            }
        });
    }

    //Method will calculate GPA
    private void doGpaMath() {

        //Create vars to store values
        float g1, g2, g3, g4, g5;
        int c1, c2, c3, c4, c5, total_c6;
        float r1, r2, r3, r4 ,r5, total_r6, gpa;

        //Resetting Errors
        P_E_T_grade1.setError(null);
        P_E_T_grade2.setError(null);
        P_E_T_grade3.setError(null);
        P_E_T_grade4.setError(null);
        P_E_T_grade5.setError(null);

        P_E_T_credit1.setError(null);
        P_E_T_credit1.setError(null);
        P_E_T_credit1.setError(null);
        P_E_T_credit1.setError(null);
        P_E_T_credit1.setError(null);

        //Set up exit var
        boolean cancel = false;

        //if field is empty then set cancel to true
        if(TextUtils.isEmpty(P_E_T_grade1.getText().toString())){
            P_E_T_grade1.setError("This field is required");
            cancel=true;
        }
        if(TextUtils.isEmpty(P_E_T_grade2.getText().toString())){
            P_E_T_grade2.setError("This field is required");
            cancel=true;
        }
        if(TextUtils.isEmpty(P_E_T_grade3.getText().toString())){
            P_E_T_grade3.setError("This field is required");
            cancel=true;
        }
        if(TextUtils.isEmpty(P_E_T_grade4.getText().toString())){
            P_E_T_grade4.setError("This field is required");
            cancel=true;
        }
        if(TextUtils.isEmpty(P_E_T_grade5.getText().toString())){
            P_E_T_grade5.setError("This field is required");
            cancel=true;
        }


        if(TextUtils.isEmpty(P_E_T_credit1.getText().toString())){
            P_E_T_credit1.setError("This field is required");
            cancel=true;
        }
        if(TextUtils.isEmpty(P_E_T_credit2.getText().toString())){
            P_E_T_credit2.setError("This field is required");
            cancel=true;
        }
        if(TextUtils.isEmpty(P_E_T_credit3.getText().toString())){
            P_E_T_credit3.setError("This field is required");
            cancel=true;
        }
        if(TextUtils.isEmpty(P_E_T_credit4.getText().toString())){
            P_E_T_credit4.setError("This field is required");
            cancel=true;
        }
        if(TextUtils.isEmpty(P_E_T_credit5.getText().toString())){
            P_E_T_credit5.setError("This field is required");
            cancel=true;
        }

        //If a field is empty exit method and show error
        if (cancel){
            return;
        }

        //ini variables, grab values
        g1 = Float.valueOf(P_E_T_grade1.getText().toString());
        g2 = Float.valueOf(P_E_T_grade2.getText().toString());
        g3 = Float.valueOf(P_E_T_grade3.getText().toString());
        g4 = Float.valueOf(P_E_T_grade4.getText().toString());
        g5 = Float.valueOf(P_E_T_grade5.getText().toString());

        c1 = Integer.parseInt(P_E_T_credit1.getText().toString());
        c2 = Integer.parseInt(P_E_T_credit2.getText().toString());
        c3 = Integer.parseInt(P_E_T_credit3.getText().toString());
        c4 = Integer.parseInt(P_E_T_credit4.getText().toString());
        c5 = Integer.parseInt(P_E_T_credit5.getText().toString());

        //Calculating results
        r1 = g1 * c1;
        r2 = g2 * c2;
        r3 = g3 * c3;
        r4 = g4 * c4;
        r5 = g5 * c5;

        //Adding results and credits up
        total_r6 = r1+r2+r3+r4+r5;
        total_c6 = c1+c2+c3+c4+c5;

        //Setting decimal rounding
        DecimalFormat d3 = new DecimalFormat("#.###");
        d3.setRoundingMode(RoundingMode.CEILING);

        //Calculating GPA
        gpa = total_r6/total_c6;

        //printing out answer in TextView
        P_T_V_gpa.setText(String.valueOf(d3.format(gpa)));

        //change color
        changeBg(gpa);
    }

    public void changeBg (float value){
        View view = this.getWindow().getDecorView();
        if (value < 1.7){
            view.setBackgroundColor(Color.RED);
        }
        if (value >= 1.7 && value<2.7 ){
            view.setBackgroundColor(Color.YELLOW);
        }
        if (value >= 2.7){
            view.setBackgroundColor(Color.GREEN);
        }
        if (value == Float.MAX_VALUE){
            view.setBackgroundColor(Color.WHITE);
        }
    }

}


