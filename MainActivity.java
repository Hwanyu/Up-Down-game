package com.example.last_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText num;
    private int max = 100;
    private int min = 1;
    private int rand_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Up and Down");

        Button start = (Button) findViewById(R.id.st);
        Button restart = (Button) findViewById(R.id.re);
        num = (EditText) findViewById(R.id.num);
        result = (TextView) findViewById(R.id.result);

        Random random = new Random();
        rand_num = random.nextInt(max - min + 1)+ min;

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int ss = Integer.parseInt(num.getText().toString());
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("rand", rand_num);
                intent.putExtra("Num", ss);
                startActivityForResult(intent, 0);
            }
        });
        restart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                num.setText("");
                result.setText("");
                resetRandNum();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String val = data.getStringExtra("val");
            if (val != null) {
                if (val.equals("U")) {
                    result.setText("Up");
                    num.setText("");
                } else if (val.equals("D")) {
                    result.setText("Down");
                    num.setText("");
                } else if (val.equals("E")) {
                    result.setText("Error");
                    num.setText("");
                } else if (val.equals("R")) {
                    result.setText("Right!!");
                    num.setText("");
                }
            }
        }
    }

    private void resetRandNum() {
        Random random = new Random();
        rand_num = random.nextInt(max - min + 1) + min;
    }
}
