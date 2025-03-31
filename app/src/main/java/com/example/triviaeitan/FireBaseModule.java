package com.example.triviaeitan;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FireBaseModule {
    private Context context;

    //קשור לצבע רקע
    public FireBaseModule(Context context) {
        this.context = context;//הפנייה ל-main activity

        FirebaseDatabase database = FirebaseDatabase.getInstance(); // יוצרת אובייקט FirebaseDatabase שמייצג את חיבור למסד הנתונים של Firebase
        DatabaseReference reference = database.getReference("color");//וצרת אובייקט מסוג DatabaseReference שמייצג את הפנייה למסלול בתוך מסד הנתונים של Firebase. המסלול במקרה הזה הוא "color"

        reference.addValueEventListener( //מנגנון שמיעה
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String str= snapshot.getValue(String.class);
                        if (str!=null)
                        {
                            ((MainActivity)context).setNewColorFromfb(str);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    public void writeBackgroundColorToFb(String color){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("color"); //בצעת הפנייה (reference) למפתח בשם "color" במסד הנתונים של Firebase.
        reference.setValue(color);
    }
}
