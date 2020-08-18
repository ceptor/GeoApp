package com.gransoft.geoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText message, messageBody, freeUse;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        message = findViewById(R.id.message);
        messageBody = findViewById(R.id.messageBody);
        freeUse = findViewById(R.id.freeUse);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper db = new MyDatabaseHelper(AddActivity.this);
                db.addBook(message.getText().toString().trim(),
                        messageBody.getText().toString().trim(),
                        Integer.parseInt(freeUse.getText().toString().trim()));
            }
        });
    }
}