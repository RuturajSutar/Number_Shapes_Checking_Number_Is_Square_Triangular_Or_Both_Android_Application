package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{
        int number;
        public boolean isSquare(){
            double squareRoot=Math.sqrt(number);
            if(squareRoot==Math.floor(squareRoot)){
                return true;
            }
      else{
                return false;
            }

        }
        public boolean isTriangular(){
            int x=1;
            int triangularNumber=1;
            while(triangularNumber<number){
                x++;
                triangularNumber=triangularNumber+x;
            }
            if(triangularNumber==number){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void testNumber(View view) {

        Log.i("Info", "Button Pressed");
        EditText editText = (EditText) findViewById(R.id.editText);
        String massage;
        if (editText.getText().toString().isEmpty()) {
            massage = "Please Enter a Number";
        } else {
            int i = Integer.parseInt(editText.getText().toString());
            Number myNumber = new Number();
            myNumber.number = i;


            if (myNumber.isSquare() && myNumber.isTriangular()) {
                massage = editText.getText().toString() + " is square and triangular";
            } else if (myNumber.isSquare()) {
                massage = editText.getText().toString() + " is square but not triangular";
            } else if (myNumber.isTriangular()) {
                massage = editText.getText().toString() + " is triangular but not square";
            } else {
                massage = editText.getText().toString() + " is nither triangular nor square";
            }
        }
            Toast.makeText(this, massage, Toast.LENGTH_LONG).show();
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
