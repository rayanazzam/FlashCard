package com.example.rajaz.flashcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        if(requestCode==100) {
            String question=data.getExtras().getString("stringQuestion");
            String answer=data.getExtras().getString("stringAnswer");
            ((TextView)findViewById(R.id.flashcard_question)).setText(question);
            ((TextView)findViewById(R.id.flashcard_answer)).setText(answer);
            findViewById(R.id.option_one).setVisibility(View.INVISIBLE);
            findViewById(R.id.option_two).setVisibility(View.INVISIBLE);
            findViewById(R.id.option_three).setVisibility(View.INVISIBLE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.addIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent,100);

            }
        });
        findViewById(R.id.editIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            //passing two strings as I am creating Intent
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,AddCardActivity.class);
                String Question=((TextView)findViewById(R.id.flashcard_question)).getText().toString();
                String Answer=((TextView)findViewById(R.id.flashcard_answer)).getText().toString();
                intent.putExtra("oldQuestion",Question);
                intent.putExtra("oldAnswer",Answer);
                MainActivity.this.startActivityForResult(intent,100);
            }
        });
        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);

            }
        });
        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);

            }
        });
        findViewById(R.id.option_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.option_one).setBackgroundColor(getResources().getColor(R.color.darkBlue));
                findViewById(R.id.option_two).setBackgroundColor(getResources().getColor(R.color.white));
                findViewById(R.id.option_three).setBackgroundColor(getResources().getColor(R.color.white));

            }

        });
        findViewById(R.id.show_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((ImageView) findViewById(R.id.hide_icon)).setImageResource(R.drawable.ic_iconmonstr_eye_5);
                findViewById(R.id.option_one).setVisibility(View.INVISIBLE);
                findViewById(R.id.option_two).setVisibility(View.INVISIBLE);
                findViewById(R.id.option_three).setVisibility(View.INVISIBLE);
                findViewById(R.id.hide_icon).setVisibility(View.VISIBLE);
                findViewById(R.id.show_icon).setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.hide_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.show_icon).setVisibility(View.VISIBLE);
                findViewById(R.id.hide_icon).setVisibility(View.INVISIBLE);
                findViewById(R.id.option_one).setVisibility(View.VISIBLE);
                findViewById(R.id.option_two).setVisibility(View.VISIBLE);
                findViewById(R.id.option_three).setVisibility(View.VISIBLE);

            }
        });
        findViewById(R.id.option_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.option_two).setBackgroundColor(getResources().getColor(R.color.darkBlue));
                findViewById(R.id.option_one).setBackgroundColor(getResources().getColor(R.color.white));
                findViewById(R.id.option_three).setBackgroundColor(getResources().getColor(R.color.white));
            }

        });
        findViewById(R.id.option_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.option_three).setBackgroundColor(getResources().getColor(R.color.darkBlue));
                findViewById(R.id.option_two).setBackgroundColor(getResources().getColor(R.color.white));
                findViewById(R.id.option_one).setBackgroundColor(getResources().getColor(R.color.white));
            }

        });


    }
}
