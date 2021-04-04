package com.afq.mon220204445;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import static com.afq.mon220204445.Bfood.Des;
import static com.afq.mon220204445.Bfood.IMG;
import static com.afq.mon220204445.Bfood.Name;

public class Dclohths extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("clohths");
    private ImageView image;
    private TextView txtame;
    private TextView txtdes;
    View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dclohths);
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