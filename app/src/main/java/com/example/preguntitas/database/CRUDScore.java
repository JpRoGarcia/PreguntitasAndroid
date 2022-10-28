package com.example.preguntitas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.preguntitas.object.Question;
import com.example.preguntitas.object.Score;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CRUDScore {
    public Context ctx;
    DatabaseReference miDB;

    public CRUDScore(Context ctx) {this.ctx =ctx;}

    public void CreateScores(String Name, int Live, int Point){
        miDB = FirebaseDatabase.getInstance().getReference();
        String Id = miDB.push().getKey();
        Score Q = new Score(Id, Name, Live, Point);
        miDB.child("Score").child(Id).setValue(Q);
    }

    public void UpdateQuestion(String Id, String Name, int Live, int Point){
        miDB = FirebaseDatabase.getInstance().getReference();
        Score Q = new Score(Id, Name, Live, Point);
        miDB.child("Score").child(Id).setValue(Q);
    }
}
