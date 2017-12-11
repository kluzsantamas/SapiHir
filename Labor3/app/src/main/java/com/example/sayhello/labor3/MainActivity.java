package com.example.tms.labor3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.icu.text.DisplayContext.LENGTH_SHORT;
import static com.example.sayhello.labor3.R.id.keypad_1;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    private static final int N = 3;
    private Button[] buttons = new Button[N * N];
    private int buttonid[] = {keypad_1, R.id.keypad_2, R.id.keypad_3, R.id.keypad_4, R.id.keypad_5, R.id.keypad_6,
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


    class MyOnClickListener implements View.OnClickListener{

        public void onClick( View v ){
            Button source = (Button)v;
            String text = (String) source.getText();
            int valami = parseInt(text);
            valami++;
            if (valami > 9) {
                valami = 1;
            }
            String valami_text= Integer.toString(valami);
            source.setText(valami_text);

            if ((parseInt(buttons[0].getText().toString()) + parseInt(buttons[1].getText().toString()) + parseInt(buttons[3].getText().toString())) == 15)
            {
                if ((parseInt(buttons[3].getText().toString()) + parseInt(buttons[4].getText().toString()) + parseInt(buttons[5].getText().toString())) == 15)
                {
                    if ((parseInt(buttons[6].getText().toString()) + parseInt(buttons[7].getText().toString()) + parseInt(buttons[8].getText().toString())) == 15)
                    {
                        if ((parseInt(buttons[0].getText().toString()) + parseInt(buttons[3].getText().toString()) + parseInt(buttons[6].getText().toString())) == 15)
                        {
                            if ((parseInt(buttons[1].getText().toString()) + parseInt(buttons[4].getText().toString()) + parseInt(buttons[7].getText().toString())) == 15)
                            {
                                if ((parseInt(buttons[2].getText().toString()) + parseInt(buttons[5].getText().toString()) + parseInt(buttons[8].getText().toString())) == 15)
                                {
                                    if ((parseInt(buttons[0].getText().toString()) + parseInt(buttons[4].getText().toString()) + parseInt(buttons[8].getText().toString())) == 15)
                                    {
                                        if ((parseInt(buttons[2].getText().toString()) + parseInt(buttons[4].getText().toString()) + parseInt(buttons[6].getText().toString())) == 15)
                                        {
                                            Toast toast = Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_SHORT);
                                            toast.show();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }




        }
    }

}
