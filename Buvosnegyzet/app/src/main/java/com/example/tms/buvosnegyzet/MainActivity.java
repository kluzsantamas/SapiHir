import java.lang.Integer;
package com.example.tms.buvosnegyzet;


        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int N = 3;
    private Button[] buttons = new Button[N * N];
    private int buttonid[] = {R.id.keypad_1, R.id.keypad_2, R.id.keypad_3,
            R.id.keypad_4, R.id.keypad_5, R.id.keypad_6,
            R.id.keypad_7, R.id.keypad_8, R.id.keypad_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<N*N; ++i ){
            buttons[i] = (Button) findViewById(buttonid[ i ]);
        }
        MyOnClickListener listener = new MyOnClickListener();
        for (int i = 0; i < N * N; ++i) {
            buttons[i].setOnClickListener(listener);
        }
    }
    class MyOnClickListener implements View.OnClickListener{
        public void onClick( View v ){
            Button source = (Button)v;
            source.getText();
            source.setText(integer.source.getText() + 1);
            Toast toast =  Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}


