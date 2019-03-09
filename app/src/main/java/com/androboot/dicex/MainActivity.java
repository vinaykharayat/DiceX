package com.androboot.dicex;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static boolean check1=false;
    public static boolean check2=false;
    public int firstNumber;
    public int secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView appversion= (TextView) findViewById(R.id.appVersion);
        TextView developer= (TextView) findViewById(R.id.developer);
        MenuItem about=(MenuItem)findViewById(R.id.about);
        Button rollButton= (Button) findViewById(R.id.rollButton);
        final ImageView leftDice= (ImageView) findViewById(R.id.leftDice);
        final ImageView rightDice= (ImageView) findViewById(R.id.rightDice);

        //Sum of the two numbers clicked
        final int sum;

        //Contains dice images
        final int[] diceArray= {
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6
        };

        //randomize dice images
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("rollButton","I'm working!!");
                Random randomNumberGenertor= new Random();
                int randomNumber= randomNumberGenertor.nextInt(6);
                Log.d("randomNumber","The random number is"+ randomNumber);
                leftDice.setImageResource(diceArray[randomNumber]);
                randomNumber=randomNumberGenertor.nextInt(6);
                rightDice.setImageResource(diceArray[randomNumber]);
                numberButtons();
                check1=false;
                check2=false;

            }
        });

        //on clicking numbers on screen


    }

    public void numberButtons()
    {
        final ImageButton number1= findViewById(R.id.number1);
        final ImageButton number2= findViewById(R.id.number2);
        final ImageButton number3= findViewById(R.id.number3);
        final ImageButton number4= findViewById(R.id.number4);
        final ImageButton number5= findViewById(R.id.number5);
        final ImageButton number6= findViewById(R.id.number6);
        final ImageButton number7= findViewById(R.id.number7);
        final ImageButton number8= findViewById(R.id.number8);
        final ImageButton number9= findViewById(R.id.number9);


        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("number1","I'm working!");

                if(check1==false)
                {

                    firstNumber= returnValue(1);
                    check1=true;
                    number1.setEnabled(false);
                    number1.setImageResource(R.drawable.selected_image_one);
                }else if(check2==false){
                    secondNumber= returnValue(1);
                    check2=true;
                    number1.setEnabled(false);
                    number1.setImageResource(R.drawable.selected_image_one);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"You have already selected two numbers",Toast.LENGTH_LONG).show();
                }


            }
        });

        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("number2","I'm working!");
                if(check1==false)
                {

                    firstNumber= returnValue(2);
                    check1=true;
                    number2.setEnabled(false);
                    number2.setImageResource(R.drawable.selected_image_two);
                }else if(check2==false){
                    secondNumber= returnValue(2);
                    check2=true;
                    number2.setEnabled(false);
                    number2.setImageResource(R.drawable.selected_image_two);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"You have already selected two numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("number3","I'm working!");
                if(check1==false)
                {

                    firstNumber= returnValue(3);
                    check1=true;
                    number3.setEnabled(false);
                    number3.setImageResource(R.drawable.selected_image_three);
                }else if(check2==false){
                    secondNumber= returnValue(3);
                    check2=true;
                    number3.setEnabled(false);
                    number3.setImageResource(R.drawable.selected_image_three);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"You have already selected two numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("number4","I'm working!");
                if(check1==false)
                {

                    firstNumber= returnValue(4);
                    check1=true;
                    number4.setEnabled(false);
                    number4.setImageResource(R.drawable.selected_image_four);
                }else if(check2==false){
                    secondNumber= returnValue(4);
                    check2=true;
                    number4.setEnabled(false);
                    number4.setImageResource(R.drawable.selected_image_four);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"You have already selected two numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("number5","I'm working!");
                if(check1==false)
                {

                    firstNumber= returnValue(5);
                    check1=true;
                    number5.setEnabled(false);
                    number5.setImageResource(R.drawable.selected_image_five);
                }else if(check2==false){
                    secondNumber= returnValue(5);
                    check2=true;
                    number5.setEnabled(false);
                    number5.setImageResource(R.drawable.selected_image_five);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"You have already selected two numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("number6","I'm working!");
                if(check1==false)
                {

                    firstNumber= returnValue(6);
                    check1=true;
                    number6.setEnabled(false);
                    number6.setImageResource(R.drawable.selected_image_six);
                }else if(check2==false){
                    secondNumber= returnValue(6);
                    check2=true;
                    number6.setEnabled(false);
                    number6.setImageResource(R.drawable.selected_image_six);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"You have already selected two numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("number7","I'm working!");
                if(check1==false)
                {

                    firstNumber= returnValue(7);
                    check1=true;
                    number7.setEnabled(false);
                    number7.setImageResource(R.drawable.selected_image_seven);
                }else if(check2==false){
                    secondNumber= returnValue(7);
                    check2=true;
                    number7.setEnabled(false);
                    number7.setImageResource(R.drawable.selected_image_seven);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"You have already selected two numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("number8","I'm working!");
                if(check1==false)
                {

                    firstNumber= returnValue(8);
                    check1=true;
                    number8.setEnabled(false);
                    number8.setImageResource(R.drawable.selected_image_eight);
                }else if(check2==false){
                    secondNumber= returnValue(8);
                    check2=true;
                    number8.setEnabled(false);
                    number8.setImageResource(R.drawable.selected_image_eight);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"You have already selected two numbers",Toast.LENGTH_LONG).show();
                }
            }
        });

        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("number9","I'm working!");
                if(check1==false)
                {

                    firstNumber= returnValue(9);
                    check1=true;
                    number9.setEnabled(false);
                    number9.setImageResource(R.drawable.selected_image_nine);
                }else if(check2==false){
                    secondNumber= returnValue(9);
                    check2=true;
                    number9.setEnabled(false);
                    number9.setImageResource(R.drawable.selected_image_nine);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"You have already selected two numbers",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    //function to return value of onClickListener

    public static int returnValue(int a) {
        int b=a;
        return b;
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    /*@Override
    public boolean onOptionsItemSelected(MenuItem about) {
        int id = about.getItemId();

        if (id == R.id.about) {
            // about app page
            onButtonShowPopupWindowClick();
        }
        return super.onOptionsItemSelected(about);
    }
*/
    public void onButtonShowPopupWindowClick(View view) {
        //inflate layout of popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // creating the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
}
