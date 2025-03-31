package com.example.triviaeitan;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    Button btnYes, btnNo;
    Context context;

    public CustomDialog(@NonNull Context context) { // context- מתקשר עם האקטיביטיז (אינטרקציה)
        super(context); //Context מועבר לדיאלוג

        setContentView(R.layout.custom_dialog);
        this.context = context;

        this.btnYes = findViewById(R.id.btnYes);
        this.btnNo = findViewById(R.id.btnNo);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
        setCancelable(false);
    }


    @Override
    public void onClick(View view) {
        if(btnYes == view)
        {
            dismiss(); // eliminate the dialog
            ((GameActivity2)context).reset();   // קריאה לפונקציה reset() של הפעילות GameActivity2
        }

        if(btnNo == view)
        {
            ((GameActivity2)context).finish(); // סיום הפעילות
        }
    }
}
