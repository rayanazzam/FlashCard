package com.example.rajaz.flashcard;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        String questionLabel=getIntent().getStringExtra("oldQuestion");
        String answerLabel=getIntent().getStringExtra("oldAnswer");
        String option_one=getIntent().getStringExtra("option1");
        String option_two=getIntent().getStringExtra("option2");

        ((EditText)findViewById(R.id.wanswer1)).setText(option_one);
        ((EditText)findViewById(R.id.wanswer2)).setText(option_two);


        ((EditText)findViewById(R.id.question)).setText(questionLabel);
        ((EditText)findViewById(R.id.answer)).setText(answerLabel);
        findViewById(R.id.saveIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = ((EditText) findViewById(R.id.question)).getText().toString();
                String answer = ((EditText) findViewById(R.id.answer)).getText().toString();
                String option1 = ((EditText) findViewById(R.id.wanswer1)).getText().toString();
                String option2 = ((EditText) findViewById(R.id.wanswer2)).getText().toString();
                Toast toast = Toast.makeText(getApplicationContext(), "cannot leave answer and question blank", Toast.LENGTH_SHORT);
                //toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                Intent data = new Intent();
                data.putExtra("stringQuestion", question);
                data.putExtra("stringAnswer", answer);
                data.putExtra("wrongAnswer1", option1);
                data.putExtra("wrongAnswer2", option2);
                if (answer.equals("") || question.equals("")) {
                    toast.show();
                } else {

                    setResult(RESULT_OK, data);
                    finish();
                }
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
