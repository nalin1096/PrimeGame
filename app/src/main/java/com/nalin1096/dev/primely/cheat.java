package com.nalin1096.dev.primely;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class cheat extends AppCompatActivity {

    private TextView cheatText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        int random_num = getIntent().getIntExtra("cheat", 0);
        cheatText = (TextView)findViewById(R.id.cheatText);

        int flag = 0;
        for(int i = 2;i<random_num/2;i++)
        {
            if(random_num%i==0)
            {
                flag++;
                break;
            }
        }
        if(flag==0)
        {
            cheatText.setText("YES");
        }
        else
        {
            cheatText.setText("NO");
        }


    }
}
