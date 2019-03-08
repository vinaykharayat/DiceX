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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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
        final int[] diceArray= {
                R.drawable.dice_1,
                R.drawable.dice_2,
                R.drawable.dice_3,
                R.drawable.dice_4,
                R.drawable.dice_5,
                R.drawable.dice_6
        };

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

            }
        });
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
