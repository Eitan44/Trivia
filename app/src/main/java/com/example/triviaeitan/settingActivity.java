package com.example.triviaeitan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class settingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private Spinner spinner;
    private String[] arrcolor={"Red","Blue","pink","Yellow"};
    private Button btnChooseColor;
    private String chooseColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        btnChooseColor = findViewById(R.id.btnChooseColor);
        btnChooseColor.setOnClickListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arrcolor);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chooseColor = arrcolor[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.putExtra("color",chooseColor);
        setResult(RESULT_OK,i);
        finish(); //close the activity

    }
}