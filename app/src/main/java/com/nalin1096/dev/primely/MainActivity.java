package com.nalin1096.dev.primely;

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
    private TextView primeText;
    Random random_gen = new Random();
    Integer random_num;

    private static final String TAG = "Primely";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning variables to the elements of the app
        nextButton = (Button) findViewById(R.id.nextButton);
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);

        primeText = (TextView) findViewById(R.id.textView5);

        if (savedInstanceState != null)
        {
            random_num = savedInstanceState.getInt ("random_num", random_gen.nextInt(1000));
            primeText.setText(random_num.toString());
        }
        else {
            random_num = random_gen.nextInt(1000);
            primeText.setText(random_num.toString());

        }
        //Set inital random number to Prime Number text field
//        random_num = random_gen.nextInt(1000);
//        primeText.setText(random_num.toString());


        //Listener for Next Button
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                random_num = random_gen.nextInt(1000);
                primeText.setText(random_num.toString());
            }
        });

        //Listener for Yes Button
        yesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int flag = 0;
                random_num = random_gen.nextInt(1000);
                for (int i=2;i<Math.sqrt(random_num);i++) {
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
                int flag = 0;
                random_num = random_gen.nextInt(1000);
                for (int i=2;i<Math.sqrt(random_num);i++) {
                    if (random_num%i==0) {
                        flag++;
                        break;
                    }
                }
                if (flag != 1) {
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


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
        savedInstanceState.putInt("random_num", random_num);

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
