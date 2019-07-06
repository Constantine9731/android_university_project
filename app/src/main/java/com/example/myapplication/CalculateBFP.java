package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CalculateBFP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bfp);

        configureHomeButton();
    }

    private void configureHomeButton(){
        Button home2Button = (Button) findViewById(R.id.home2Button); //ορίζει ως home2Button τη μεταβλητή και τη συνδέει μέσω ID με το αντίστοιχο Button που πρέπει από το .xml
        home2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                finish(); //τελειώνει το Activity αυτό
            }
        });

        Button calculation2Button = (Button) findViewById(R.id.calculation2Button); //ορίζει ως calculation2Button τη μεταβλητή και τη συνδέει μέσω ID με το αντίστοιχο Button που πρέπει από το .xml
        calculation2Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ //εκτελεί τον παρακάτω κώδικα όταν το button πατηθεί
                int counter = 0; //ελέγχει αν όλα τα πεδία έχουν συμπληρωθεί
                double iHeight2Number = 1; //αρχικοποίηση μεταβλητής
                double iWaistNumber = 1; //αρχικοποίηση μεταβλητής
                double iLegNumber = 1; //αρχικοποίηση μεταβλητής
                double iNeckNumber = 1; //αρχικοποίηση μεταβλητή

                EditText height2Number = (EditText) findViewById(R.id.height2Number); //ορίζει ως μεταβλητή το πεδίο εισαγωγής του ύψους
                String sHeight2Number = height2Number.getText().toString(); //μετατρέπει την εισαγωγή σε τύπο string

                if (TextUtils.isEmpty(sHeight2Number)) { //ελέγχει το αν το πεδίο είναι άδειο ή όχι
                    Toast.makeText(CalculateBFP.this, "You did not enter your height", Toast.LENGTH_SHORT).show(); //βγάζει μύνημα που ζητάει τη συμπλήρωσει του πεδίου αν είναι άδει
                }
                else{
                    iHeight2Number = Double.parseDouble(sHeight2Number); //μετατρέπει το προηγούμενο string σε double και το εισάγει μέσα στην αρχικοποιημένη μεταβλητή
                    counter = 1;
                }

                EditText waistNumber = (EditText) findViewById(R.id.waistNumber); //ορίζει ως μεταβλητή το πεδίο εισαγωγής της περιφέρειας κοιλιάς
                String sWaistNumber = waistNumber.getText().toString(); //μετατρέπει την εισαγωγή σε τύπο string

                if (TextUtils.isEmpty(sWaistNumber) && (counter == 1)) { //παρόμοια με παραπάνω
                    Toast.makeText(CalculateBFP.this, "You did not enter your waist circumference", Toast.LENGTH_SHORT).show(); //βγάζει μύνημα που ζητάει τη συμπλήρωσει του πεδίου αν είναι άδειο
                }
                else if(counter == 1){
                    iWaistNumber = Double.parseDouble(sWaistNumber); //παρόμοια με παραπάνω
                    counter = 2;
                }

                EditText neckNumber = (EditText) findViewById(R.id.neckNumber); //παρόμοια με παραπάνω
                String sNeckNumber = neckNumber.getText().toString(); //παρόμοια με παραπάνω

                if (TextUtils.isEmpty(sNeckNumber) && counter == 2) { //παρόμοια με παραπάνω
                    Toast.makeText(CalculateBFP.this, "You did not enter your neck circumference", Toast.LENGTH_SHORT).show(); //παρόμοια με παραπάν
                }
                else if (counter == 2){
                    iNeckNumber = Double.parseDouble(sNeckNumber); //παρόμοια με παραπάνω
                    counter = 3;
                }

                EditText legNumber = (EditText) findViewById(R.id.legNumber); //παρόμοια με παραπάνω
                String sLegNumber = legNumber.getText().toString(); //παρόμοια με παραπάνω

                if (TextUtils.isEmpty(sLegNumber) && counter == 3) { //παρόμοια με παραπάνω
                    Toast.makeText(CalculateBFP.this, "You did not enter your leg circumference", Toast.LENGTH_SHORT).show(); //παρόμοια με παραπάνω
                }
                else if(counter == 3){
                    iLegNumber = Double.parseDouble(sLegNumber); //παρόμοια με παραπάνω
                    counter = 4;
                }

                RadioGroup genderChoice = (RadioGroup)findViewById(R.id.genderChoice); //ορίζει ως μεταβλητή το radio group

                if (genderChoice.getCheckedRadioButtonId() == -1) //ελέγχει αν κάποιο button του group είναι τσεκαρισμένο
                {
                    Toast.makeText(CalculateBFP.this, "You did not select your gender", Toast.LENGTH_SHORT).show(); //ειδοποιεί τον χρήστη να πατήσει κάποιο button φύλλου
                }
                else if (counter == 4) //ελέγχει αν και τα υπόλοιπα πεδία έχουν συμπληρωθεί
                {
                    double result; //αρχικοποίηση μεταβλητής αποτελέσματος
                    RadioButton maleChoice = (RadioButton) findViewById(R.id.maleChoice); //ορίζει ως μεταβλητή το button ενός από τα δύο φύλλα
                    RadioButton femaleChoice = (RadioButton) findViewById(R.id.femaleChoice); //ορίζει ως μεταβλητή το button ενός από τα δύο φύλλα

                    if (maleChoice.isChecked()){ //ελέγχει αν το ένα button είναι επιλεγμένο, αυτό του άνδρα
                        result = ((86.01 * (iWaistNumber - iNeckNumber)) - (70.041 * iHeight2Number)) + 30.3; //υπολογίζει αποτέλεσμα
                        Toast.makeText(CalculateBFP.this, "Your BFP is "+result, Toast.LENGTH_SHORT).show(); //εμφανίζει αποτέλεσμα
                    }
                    else{
                        result = 163.205 * (iWaistNumber + iLegNumber - iNeckNumber) - 97.684 * iHeight2Number - 104.912; //υπολογίζει αποτέλεσμα
                        Toast.makeText(CalculateBFP.this, "Your BFP is "+result, Toast.LENGTH_SHORT).show(); //εμφανίζει αποτέλεσμα
                    }
                }
            }
        });
    }
}
