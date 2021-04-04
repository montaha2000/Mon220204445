package com.afq.mon220204445;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.afq.mon220204445.Bfood.Des;
import static com.afq.mon220204445.Bfood.IMG;
import static com.afq.mon220204445.Bfood.Name;

public class Dfood extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("food");
    private ImageView image;
    private TextView txtame;
    private TextView txtdes;
    View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfood);


        parentLayout = findViewById(android.R.id.content);

        Intent intent = getIntent();
        String texnmae = intent.getStringExtra(Name);
        String texdese = intent.getStringExtra(Des);
        final String img = intent.getStringExtra(IMG);

        image = findViewById(R.id.imageView);
        Picasso.get().load(img).into(image);

        txtdes = findViewById(R.id.textdes);
        txtdes.setText(texdese);

        txtame = findViewById(R.id.textnane);
        txtame.setText(texnmae);


    }

}