package com.shivamamin.mymobapp.mymobapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    TextView tView;
    int clicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        tView = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(MainActivity.this);
    }

    public void onClick(View v){
        this.clicked++;
        this.tView.setText("Button clicked " + this.clicked + " time(s).");
    }
}
