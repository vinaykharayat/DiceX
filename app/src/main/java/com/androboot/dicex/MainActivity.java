package com.androboot.dicex;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Contains number images(unselected)
    final int[] buttonID = {
            R.id.number1,
            R.id.number2,
            R.id.number3,
            R.id.number4,
            R.id.number5,
            R.id.number6,
            R.id.number7,
            R.id.number8,
            R.id.number9
    };
    //contains selected images
    final int[] selectedImageID = {
            R.drawable.selected_image_one,
            R.drawable.selected_image_two,
            R.drawable.selected_image_three,
            R.drawable.selected_image_four,
            R.drawable.selected_image_five,
            R.drawable.selected_image_six,
            R.drawable.selected_image_seven,
            R.drawable.selected_image_eight,
            R.drawable.selected_image_nine
    };
    //Contains dice images
    final int[] diceArray = {
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
    };
    public int sum;
    int myScore = 45;
    int valueLeftDice;
    int valueRightDice;
    boolean check1=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rollButton = findViewById(R.id.rollButton);
        final TextView mScore = (TextView) findViewById(R.id.myScore);
        ImageView helpButton= (ImageView) findViewById(R.id.helpButton);
        final MediaPlayer mp= MediaPlayer.create(this, R.raw.dicerolling);
        ImageButton restartButton= (ImageButton) findViewById(R.id.restartButton);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("rollButton", "I'm working!!");
                mp.start();
                rollButton();
                mScore.setText("Score: " + myScore);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_help);
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void rollButton(){
        final ImageView leftDice = (ImageView) findViewById(R.id.leftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.rightDice);
        Random randomNumberGenerator = new Random();
        valueLeftDice = randomNumberGenerator.nextInt(6);
        Log.d("debug","Random=" +valueLeftDice);
        randomNumberGenerator = new Random();
        valueRightDice = randomNumberGenerator.nextInt(6);
        Log.d("debug","Random=" +valueRightDice);
        leftDice.setImageResource(diceArray[valueLeftDice]);
        rightDice.setImageResource(diceArray[valueRightDice]);
        sum=valueLeftDice+valueRightDice+2;
        numberButtons();
    }

    //Finds the number selected by user
    private void numberButtons(){
        View.OnClickListener numberButtonListener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i;
                //determine selected number
                for (i = 0; i < 9; i++) {
                    if (view.getId() == buttonID[i]) {
                        Log.d("debug", "You clicked " + ++i);
                        getSelectedNumber(i, view);
                    }
                }
            }
        };

        //set the same listener for every button
        for (int i = 0; i < 9; i++) {
            (findViewById(buttonID[i])).setOnClickListener(numberButtonListener);
        }
    }

    //Finds the selected number by user, check selection and update score.
    private void getSelectedNumber(int selectedNumber, View view){
        check1=checkSelection(selectedNumber);
        if(check1){
            ((ImageButton) view).setImageResource(selectedImageID[--selectedNumber]);
            check1=false;
        }
    }

    private boolean checkSelection(int selection) {
        if(selection==sum)
        {
            updateScore(selection);
            return true;
        }else if(selection<sum) {
            sum-=selection;
            numberButtons();
            updateScore(selection);
            return true;
        }else{
            Toast.makeText(getApplicationContext(),"Please select correct number!",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void updateScore(int score){
        myScore-=score;
    }

}