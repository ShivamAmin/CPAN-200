package com.shivamamin.cpan200.addnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Initialize Global Variables
    EditText fNumberText;
    EditText lNumberText;
    TextView sumView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fNumberText = (EditText) findViewById(R.id.editText);
        lNumberText = (EditText) findViewById(R.id.editText2);
        sumView = (TextView) findViewById(R.id.textView6);
    }

    //Method called when Add button tapped
    public void Tapped(View view){
        //If EditText1 is empty, focus it
        if(TextUtils.isEmpty(fNumberText.getText())){
            fNumberText.requestFocus();
        //If EditText2 is empty, focus it
        } else if(TextUtils.isEmpty(lNumberText.getText())) {
            lNumberText.requestFocus();
        } else {
            //Get first and second numbers, add them, and display in sumView
            int fNumber = Integer.parseInt(fNumberText.getText().toString());
            int lNumber = Integer.parseInt(lNumberText.getText().toString());
            int sum = fNumber + lNumber;
            sumView.setText(Integer.toString(sum));
        }
    }
}
