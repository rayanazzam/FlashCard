package com.example.rajaz.flashcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        String questionLabel=getIntent().getStringExtra("oldQuestion");
        String answerLabel=getIntent().getStringExtra("oldAnswer");
        ((EditText)findViewById(R.id.question)).setText(questionLabel);
        ((EditText)findViewById(R.id.answer)).setText(answerLabel);
        findViewById(R.id.saveIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question=((EditText)findViewById(R.id.question)).getText().toString();
                String answer=((EditText)findViewById(R.id.answer)).getText().toString();
                Intent data=new Intent();
                data.putExtra("stringQuestion",question);
                data.putExtra("stringAnswer",answer);
                setResult(RESULT_OK,data);
                finish();
            }
        });
        findViewById(R.id.cancelIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(AddCardActivity.this,MainActivity.class);
                AddCardActivity.this.startActivity(intent);
            }
        });

    }
}
