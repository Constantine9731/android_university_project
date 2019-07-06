package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureBMIButton(); //καλεί το function με το οποίο πραγματοποιείται η αλλαγή μεταξύ των activity
        configureBFPButton();
    }

    private void configureBMIButton(){
        Button BMIButton = (Button) findViewById(R.id.BMIButton); //ορίζει ως Button τη μεταβλητή και τη συνδέει μέσω ID με το αντίστοιχο Button που πρέπει από το .xml
        BMIButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, CalculateBMI.class)); //Αρχίζει καινουγιο activity, χρησιμοποιούμαι Intent για να συνδέσουμε τα Activity. Το ένα argument, το πρώτο, είναι το που βρισκόμαστε, και το δεύτερο το που θέλουμε να πάμε
            }
        });
    }

    private void configureBFPButton(){
        Button BFPButton = (Button) findViewById(R.id.BFPButton); //ορίζει ως Button τη μεταβλητή και τη συνδέει μέσω ID με το αντίστοιχο Button που πρέπει από το .xml
        BFPButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, CalculateBFP.class)); //Αρχίζει καινουγιο activity, χρησιμοποιούμαι Intent για να συνδέσουμε τα Activity. Το ένα argument, το πρώτο, είναι το που βρισκόμαστε, και το δεύτερο το που θέλουμε να πάμε
            }
        });
    }
}
