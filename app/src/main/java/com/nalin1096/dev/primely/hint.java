package com.nalin1096.dev.primely;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class hint extends AppCompatActivity {

    private TextView hintText;
    private TextView factorsText;
    ArrayList<Integer> ListOfFactors = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        hintText = (TextView) findViewById(R.id.hintText);
        factorsText = (TextView) findViewById(R.id.factorsText);
        int random_num = getIntent().getIntExtra("hint", 0);
        hintText.setText("Factors for " + Integer.toString(random_num) + " are:");

        for(int i = 1;i<=Math.sqrt(random_num);i++)
        {
            if(random_num%i==0)
            {
                ListOfFactors.add(i);
                if(i!=random_num/i)
                {
                    ListOfFactors.add(random_num/i);
                }
            }
        }
        Collections.sort(ListOfFactors);

        String factorString = "";

        for(int i=0;i<ListOfFactors.size();i++)
        {
            String num = Integer.toString(ListOfFactors.get(i));
            if(i==0)
                factorString += num.toString();
            else
                factorString += ", " + num.toString();
        }

        System.out.println(factorString);
        factorsText.setText(factorString);

    }
}
