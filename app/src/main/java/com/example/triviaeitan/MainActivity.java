package com.example.triviaeitan;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
private ActivityResultLauncher<Intent> launcher;
    private  FireBaseModule fbModule;
    private String backColor="";
    private ConstraintLayout ll;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll =findViewById(R.id.main);

        fbModule = new FireBaseModule(this);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if (o.getResultCode() == RESULT_OK)
                        {
                            Intent data = o.getData();
                            String str = data.getStringExtra("color");
                          //  Toast.makeText(MainActivity.this, "" + str, Toast.LENGTH_SHORT).show();
                            fbModule.writeBackgroundColorToFb(str);


                        }

                    }
                }
        );
    }



    public void onStartGame(View view) {
        Intent intent = new Intent(this, GameActivity2.class);
        intent.putExtra("backgroundColor", backColor); // Pass the background color
        startActivity(intent);
    }

    public void onclicksetting(View view) {
        Intent i =new Intent(this, settingActivity.class);
        launcher.launch(i);
    }
    public void onclickinstruction(View view) {
    }

    public void setNewColorFromfb(String str) {
        this.backColor = str;
       // Toast.makeText(this, ""+ str, Toast.LENGTH_SHORT).show();
        setBackGroundColor(str);

    }
    public void setBackGroundColor(String color)
    {
        switch (color)
        {
            case "Red":
                {
                    ll.setBackgroundColor(Color.RED);
                    break;
                }
            case "Blue":
            {
                ll.setBackgroundColor(Color.BLUE);
                break;
            }
            case "pink":
            {
                ll.setBackgroundColor(Color.argb(255, 255, 182, 193));
                break;
            }
            case "Yellow":
            {
                ll.setBackgroundColor(Color.YELLOW);
                break;
            }
            default:
                ll.setBackgroundColor(Color.WHITE);
        }
    }
}