package com.example.triviaeitan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GameActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button btna1, btna2, btna3, btna4;
    private TextView tvQuestion;
    private TextView tvQuestionNumber, tvPoint, tvGameOver;
    private Collection collection;
private Question currentQuestion;
private int pointz=0;
    private LinearLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game2);

            // Get the layout
        View layout = findViewById(R.id.activity_game2); // Correct layout ID

            // Get the color from the Intent
            String color = getIntent().getStringExtra("backgroundColor");

            // Apply the background color
            if (color != null) {
                setBackGroundColor(layout, color);
            }

            // The rest of your existing code
            collection = new Collection();
            tvQuestion = findViewById(R.id.tvQuestion);
            btna1 = findViewById(R.id.btna1);
            btna2 = findViewById(R.id.btna2);
            btna3 = findViewById(R.id.btna3);
            btna4 = findViewById(R.id.btna4);
        Intent intent = getIntent();
        String bgcolor = intent.getStringExtra("colorgame");
        if (bgcolor != null)
        {
            setBackGroundColor2(bgcolor);
        }

            btna1.setOnClickListener(this);
            btna2.setOnClickListener(this);
            btna3.setOnClickListener(this);
            btna4.setOnClickListener(this);

            tvPoint = findViewById(R.id.tvPoints);
            tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
            tvGameOver = findViewById(R.id.tvGameOver);

            tvGameOver.setVisibility(View.INVISIBLE);

            collection.initQuestion();
            nextQuestion();
        }

    private void setBackGroundColor(View layout, String color) {

    }





    private void nextQuestion() {
        if (collection.isNotLastQuestion()) {
            currentQuestion = collection.getNextQuestion();
            tvQuestion.setText(currentQuestion.getQuestion());

            btna1.setText(currentQuestion.getA1());
            btna2.setText(currentQuestion.getA2());
            btna3.setText(currentQuestion.getA3());
            btna4.setText(currentQuestion.getA4());
        }
        else
        {
            tvGameOver.setVisibility(View.VISIBLE);

            CustomDialog customDialog = new CustomDialog(this);
            customDialog.show();
        }


    }

    @Override
    public void onClick(View v) {
        if (v==btna1)
        {
            if (currentQuestion.getCorrect()==1){
                pointz++;
            }
        }
        if (v==btna2)
        {
            if (currentQuestion.getCorrect()==2){
                pointz++;
            }
        }
        if (v==btna3)
        {
            if (currentQuestion.getCorrect()==3){
                pointz++;
            }
        }
        if (v==btna4)
        {
            if (currentQuestion.getCorrect()==4){
                pointz++;
            }
        }
        tvPoint.setText("points" + pointz);
        if (collection.isNotLastQuestion())
        {
            tvQuestionNumber.setText("Question number" + (collection.getIndex()+1));
        }
        nextQuestion();


    }
    public void setBackGroundColor2(String backGroundColor2) {
        switch (backGroundColor2) {
            case "Red": {
                ll.setBackgroundColor(Color.RED);
                break;
            }
            case "Blue": {
                ll.setBackgroundColor(Color.BLUE);
                break;
            }
            case "Green": {
                ll.setBackgroundColor(Color.argb(255, 0, 200, 0));
                break;
            }
            default:
                ll.setBackgroundColor(Color.WHITE);
        }
    }

    public void reset() {
        this.pointz=0;
        collection.initQuestion();
        tvPoint.setText("points: " + 0);
        tvQuestionNumber.setText("question number: " + 1);
        tvGameOver.setVisibility(View.INVISIBLE);
        this.nextQuestion();
    }
}