package com.nalin1096.dev.primely;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Initializing all the elements on the home screen*
    private Button yesButton;
    private Button noButton;
    private Button nextButton;
    private Button hintButton;
    private Button cheatButton;
    private TextView primeText;
    private TextView infoText;
    Random random_gen = new Random();
    Integer random_num;
    String info_text;

    private static final String TAG = "Primely";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning variables to the elements of the app
        nextButton = (Button) findViewById(R.id.nextButton);
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);
        hintButton = (Button) findViewById(R.id.hintButton);
        cheatButton = (Button) findViewById(R.id.cheatButton);

        primeText = (TextView) findViewById(R.id.textView5);
        infoText = (TextView) findViewById(R.id.infoText);

        info_text = "";
        infoText.setText(info_text);

        if (savedInstanceState != null)
        {
            random_num = savedInstanceState.getInt ("random_num", random_gen.nextInt(1000));
            info_text = savedInstanceState.getString ("info_str", "");
            primeText.setText(random_num.toString());
            infoText.setText(info_text);
        }
        else {
            random_num = random_gen.nextInt(1000);
            primeText.setText(random_num.toString());
            infoText.setText(info_text);

        }
        //Set inital random number to Prime Number text field
//        random_num = random_gen.nextInt(1000);
//        primeText.setText(random_num.toString());


        //Listener for Next Button
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                infoText.setText("");
                random_num = random_gen.nextInt(1000);
                primeText.setText(random_num.toString());
            }
        });

        //Listener for Yes Button
        yesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                infoText.setText("");
                int flag = 0;
                for (int i=2;i<random_num/2;i++) {
                    if (random_num%i==0) {
                        flag++;
                        break;
                    }
                }
                if (flag != 0) {
                    Toast.makeText(MainActivity.this, "Wrong Answer!",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Correct Answer!",
                            Toast.LENGTH_SHORT).show();
                }
                random_num = random_gen.nextInt(1000);
                primeText.setText(random_num.toString());
            }
        });

        //Listener for No Button
        noButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                infoText.setText("");
                int flag = 0;
                for (int i=2;i<random_num/2;i++) {
                    if (random_num%i==0) {
                        flag++;
                        break;
                    }
                }
                if (flag == 0) {
                    Toast.makeText(MainActivity.this, "Wrong Answer!",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Correct Answer!",
                            Toast.LENGTH_SHORT).show();
                }
                random_num = random_gen.nextInt(1000);
                primeText.setText(random_num.toString());
            }
        });

        //Listener for Hint Button
        hintButton = (Button) findViewById(R.id.hintButton);
        hintButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showHint(view);
            }
        });

        //Listener for Cheat Button
        cheatButton = (Button) findViewById(R.id.cheatButton);
        cheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showCheat(view);
            }
        });


    }

    public void showHint(View view)
    {
        info_text = "Hint Used";
        infoText.setText(info_text);
        Intent intent = new Intent(this, hint.class);
        intent.putExtra("hint", random_num);
        startActivity(intent);
    }

    public void showCheat(View view)
    {
        info_text = "Cheat Used";
        infoText.setText(info_text);
        Intent intent = new Intent(this, cheat.class);
        intent.putExtra("cheat", random_num);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
        savedInstanceState.putInt("random_num", random_num);
        savedInstanceState.putString("info_str", info_text);

    }


    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
}
