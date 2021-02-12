package com.example.sending_email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mTextTo;
    EditText mTextSubject;
    EditText mTextMessage;
    Button btn;
    //Dddw
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com/questions/3004515/sending-an-intent-to-browser-to-open-specific-url"));
        //startActivity(web);

        mTextTo = findViewById(R.id.edit_text_to);
        mTextSubject = findViewById(R.id.edit_text_subject);
        mTextMessage = findViewById(R.id.edit_text_message);
        btn = findViewById(R.id.button_send);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });

    }

    private void sendMail()
    {
        String recipientList = mTextTo.getText().toString();

        String[] recipients = recipientList.split(",");
        //Example->  asf@gmail.com , faawf@gmail.com

        String subject = mTextSubject.getText().toString();
        String message = mTextMessage.getText().toString();

        Intent in = new Intent(Intent.ACTION_SEND);
        in.putExtra(Intent.EXTRA_EMAIL, recipients);
        in.putExtra(Intent.EXTRA_SUBJECT, subject);
        in.putExtra(Intent.EXTRA_TEXT, message);

        in.setType("message/rfc822");

        startActivity(Intent.createChooser(in, "Choose an email client"));
    }

}