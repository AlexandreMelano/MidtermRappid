package com.example.midterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //text
    EditText editTextFirstName;
    EditText editTextLastName;
    TextView textViewAndroidChoices;
    //buttons
    Button buttonPlay;
    Button buttonReset;
    //Spinner/others
    Spinner  spinnerChoice;

    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate
         editTextFirstName = findViewById(R.id.editTextFirstName);
         editTextLastName = findViewById(R.id.editTextLastName);
         textViewAndroidChoices = findViewById(R.id.textViewAndroidChoices);

         buttonPlay = findViewById(R.id.buttonPlay);
         buttonReset = findViewById(R.id.buttonReset);

         spinnerChoice = findViewById(R.id.spinnerChoice);



        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        db = FirebaseDatabase.getInstance().getReference("games");

        //myRef.setValue("Hello, World!");
       // myRef.setValue("Joan is fat");

    }

    public void PlayButton(View view) {

        String firstName = editTextFirstName.getText().toString().trim();
        String lastName = editTextLastName.getText().toString().trim();

        String choice = spinnerChoice.getSelectedItem().toString();
        textViewAndroidChoices.setText(choice);
        Boolean winner = false;

        final Random rand = new Random();
        int randInt = rand.nextInt(100)+1;

        if (randInt < 34){
            spinnerChoice.equals("Rock");
            winner.equals(false);
        }
        if (randInt > 33 & randInt < 67){
            spinnerChoice.equals("Paper");
            winner.equals(true);
        }
        if (randInt > 66){
            spinnerChoice.equals("Scissors");
            winner.equals(true);
        }

        //if to determine winner>
        //if (spinnerChoice.getSelectedItem().toString().equals(""))

        if (!TextUtils.isEmpty(firstName)) {
            // create & populate object, generating an id FIRST and then including it
            String gameID = db.push().getKey();

            Game game = new Game(gameID, firstName, lastName, choice, winner );

            // save to db
            db.child(gameID).setValue(game);

            // clear the editText
            editTextFirstName.setText("");
            Toast.makeText(this, "Game Added", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }

    public void clear(View view) {
        editTextFirstName.setText("");
        editTextLastName.setText("");
        textViewAndroidChoices.setText("");

    }
    //display choice in textview not working




    }
    //private static final Random rand = new Random();

    //{
       // int randInt = rand.nextInt(100) + 1;
    //}


