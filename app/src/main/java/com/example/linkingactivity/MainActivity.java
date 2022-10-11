package com.example.linkingactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener{


    EditText editText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
        editText = (EditText) findViewById(R.id.editText);
        mReplyHeadTextView = findViewById(R.id.textView);
        mReplyTextView = findViewById(R.id.textView1);
        
    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SecondActivity.class);
        String message = editText.getText().toString();
        intent.putExtra("EXTRA_MESSAGE", message);
        startActivity(intent);
       // startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if (requestCode == TEXT_REQUEST) {
         //   if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra("EXTRA_REPLY");
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
         //   }
       // }
    }
}