package com.example.linkingactivity;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;
import static com.example.linkingactivity.R.id.button;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    TextView editText;
    EditText editText2Real;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");
        editText = findViewById(R.id.textView);
        editText.setText(message);
        editText2Real = findViewById(R.id.txtUsername);
        button = findViewById(R.id.button2);
        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Log.d("Yoma", "Button clicked!");
        String reply = editText2Real.getText().toString();
        Intent replyIntent = new Intent(this, MainActivity.class);
        replyIntent.putExtra("EXTRA_REPLY", reply);
        setResult(RESULT_OK, replyIntent);
       startActivity(replyIntent);

    }
}