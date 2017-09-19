package com.shivamamin.numberguesser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Global Variables
    int points = 0;
    Button btnLeft;
    Button btnRight;
    TextView pointsText;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLeft = (Button) findViewById(R.id.left);
        btnRight = (Button) findViewById(R.id.right);
        pointsText = (TextView) findViewById(R.id.pointsText);
    }

    //Function fires on button tap
    public void Clicked(View view){
        //Creating a toast object so it can be cancelled using the reference sooner than allowed by default
        final Toast t = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        //Assign random numbers from 1 to 10 to each button.
        int leftText = random.nextInt(10 - 1 + 1) + 1;
        int rightText = random.nextInt(10 - 1 + 1) + 1;

        //Determine if it's a tie
        if (leftText == rightText) {
            t.setText("Tie!");//Text(this, "Tie!", Toast.LENGTH_SHORT).show();
        } else {
            //Determine if you guessed correctly
            if (leftText > rightText && view == btnLeft || leftText < rightText && view == btnRight) {
                points++;
                t.setText("Correct!");//(this, "Correct!", Toast.LENGTH_SHORT).show();

            } else {
                //Remove points unless user at 0 points
                if (points > 0) {
                    points--;
                }
                t.setText("Incorrect!");//(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            }
            pointsText.setText("Points: " + points);
        }
        btnLeft.setText(Integer.toString(leftText));
        btnRight.setText(Integer.toString(rightText));
        //Disable buttons
        btnLeft.setEnabled(false);
        btnRight.setEnabled(false);
        t.show();
        //1 second delay
        Handler handle = new Handler();
        handle.postDelayed(new Runnable(){
            //Run after 2 second delay
            @Override
            public void run() {
                if(points < 5) {
                    //Reset buttons
                    btnLeft.setEnabled(true);
                    btnRight.setEnabled(true);
                    btnLeft.setText("Left");
                    btnRight.setText("Right");
                    t.cancel();
                }else {
                    t.setText("Congratulations, You Win!");//(MainActivity.this, "Congratulations, You Win!", Toast.LENGTH_LONG).show();
                }
            }
        }, 1000);
    }
}
