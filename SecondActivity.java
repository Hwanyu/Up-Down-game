package com.example.last_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView now;
    int max = 100;
    int min = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Button back = (Button) findViewById(R.id.back);
        now = (TextView) findViewById(R.id.now);

        Intent intent = getIntent();
        Integer sss = intent.getIntExtra("Num", 0);
        Integer rand = intent.getIntExtra("rand",0);

        now.setText(String.valueOf(sss));


        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                int rannum = rand;
                Intent out = new Intent(getApplicationContext(),
                        MainActivity.class);

                if (sss > 100 || sss < 1) {
                    out.putExtra("val", "E");
                } else if (sss < rannum) {
                    max = sss;
                    out.putExtra("val", "U");
                } else if (sss > rannum) {
                    min = sss;
                    out.putExtra("val", "D");
                } else if (sss == rannum) {
                    out.putExtra("val", "R");
                }

                setResult(RESULT_OK, out);
                finish();
            }
        });
    }
    public void reset() {
        min = 1;
        max = 100;
        Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
        outIntent.putExtra("reset", "");
        startActivity(outIntent);
    }
}
