package com.example.tms.labor31;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    private static final int N = 3;
    int letezik[]={0,0,0,0,0,0,0,0,0,0};
    private Button[] buttons = new Button[N * N];
    private int buttonid[] = {R.id.keypad_1, R.id.keypad_2, R.id.keypad_3, R.id.keypad_4, R.id.keypad_5, R.id.keypad_6,
            R.id.keypad_7, R.id.keypad_8, R.id.keypad_9};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<N*N; ++i ){
            buttons[i] = (Button) findViewById(buttonid[ i ]);
        }
        MyOnClickListener listener = new MyOnClickListener();
        for (int i = 0; i < N * N; ++i) {
            //MyOnClickListener listener = new MyOnClickListener();
            buttons[i].setOnClickListener(listener);
        }
    }


    class MyOnClickListener implements View.OnClickListener {

        public int minimum(int i)
        {int j,ok=0;
            for(j=i;j<10;j++)
                if(ok<2) {
                    if (letezik[j] == 0) {
                        return j;
                    }
                    if (j + 1 > 10) {
                        j = 1;
                        ok++;
                    }
                }
        return 0;}
        public void onClick(View v) {
            Button source = (Button) v;
            CharSequence numc = source.getText();
            int number = Integer.parseInt(numc.toString());
            if(letezik[number+1]==0){
                letezik[number]=0;
                number = number + 1;
                letezik[number]=1;}
            else{
                letezik[number]=0;
                number=minimum(number+1);
                letezik[number]=1;
            }
            if (number > 9) {
                number = 1;
            }

            String szoveg = "" + number;
            source.setText(szoveg);

        }
    }}