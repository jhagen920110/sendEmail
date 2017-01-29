package com.example.jonathan.sendemail;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button sendEmail;
    EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendEmail = (Button) findViewById(R.id.sendBtn);
        sendEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                msg = (EditText) findViewById(R.id.msgTxt);
                String message = msg.getText().toString();
                sendEmail(message);
            }
        });
    }

    private void sendEmail(String message) {

        String[] to = new String[]{"jhagen920110@gmail.com"};
        String subject = ("A message from your app!");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }
}
