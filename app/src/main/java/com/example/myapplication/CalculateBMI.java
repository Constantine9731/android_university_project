package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateBMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);

        configureHomeButton(); //καλεί το function με το οποίο θα κλείσουμε το activity και θα επιστρέψουμε.
    }

    private void configureHomeButton(){
        Button homeButton = (Button) findViewById(R.id.homeButton); //ορίζει ως Button τη μεταβλητή και τη συνδέει μέσω ID με το αντίστοιχο Button που πρέπει από το .xml
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                finish(); //τελειώνει το Activity αυτό
            }
        });

        Button calculationButton = (Button) findViewById(R.id.calculationButton); //ορίζει ως calculation2Button τη μεταβλητή και τη συνδέει μέσω ID με το αντίστοιχο Button που πρέπει από το .xml
        calculationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double iWeightNumber = 1; //αρχικοποίηση βάρους
                double iHeightNumber = 1; //αρχικοποίηση ύψους
                int flag = 0; //ελέγχει αν οι επιλογές έχουν συμπληρωθεί

                EditText weightNumber = (EditText) findViewById(R.id.weightNumber);
                String sWeightNumber = weightNumber.getText().toString();

                if(TextUtils.isEmpty(sWeightNumber)){ //ελέγχει αν το πεδίο είναι άδειο
                    Toast.makeText(CalculateBMI.this, "Please fill in your weight", Toast.LENGTH_SHORT).show(); //δίνει εντολή να γεμιστεί το πεδίο
                    flag = 1;
                }
                else{
                    iWeightNumber = Double.parseDouble(sWeightNumber); //μετατρέπει τα δεδομένα του πεδίου σε double και τα βάζει στην αντίστοιχη αρχικοποιημένη μεταβλητή
                }

                EditText heightNumber = (EditText) findViewById(R.id.heightNumber); //αντιστοίχως με παραπάνω
                String sHeightNumber = heightNumber.getText().toString();//αντιστοίχως με παραπάνω
                //int iHeightNumber = new Integer(sHeightNumber).intValue();
                if(TextUtils.isEmpty(sHeightNumber) && (flag == 0)){ //αντιστοίχως με παραπάνω
                    Toast.makeText(CalculateBMI.this, "Please fill in your height", Toast.LENGTH_SHORT).show(); //αντιστοίχως με παραπάνω
                    flag = 1;
                }
                else if(flag == 0){
                    iHeightNumber = Double.parseDouble(sHeightNumber);//αντιστοίχως με παραπάνω
                    flag = 2;
                }

                if(flag == 2){
                    double square = Math.pow(iHeightNumber, 2); //τετραγωνίζει το ύψος
                    double result;
                    result = iWeightNumber / square; //υπολογίζει το αποτέλεσμα
                    Toast.makeText(CalculateBMI.this, "The result is "+result, Toast.LENGTH_SHORT).show(); //εμφανίζει το αποτέλεσμα
                }

            }
        });
    }
}

