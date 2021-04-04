package com.afq.mon220204445;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Bfood extends AppCompatActivity {

    private ArrayList<Model> models = new ArrayList<>();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("db");

    private TextView tname,tdes,img;

    private RecyclerView mRecyclerView;
    private ClassAdapter mAdapter;


    private RecyclerView.LayoutManager mLayoutManager;

    public static final String Name = "name";
    public static final String Des = "des";
    public static final String IMG = "img";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bfood);

        showdata();
        buildRecycler();


        tname = findViewById(R.id.textnane);
        tdes = findViewById(R.id.textdes);
        img = findViewById(R.id.imageView);

    }

    public void buildRecycler() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ClassAdapter(models, Bfood.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.OnnameClickListener(new ClassAdapter.OnnameClickListener() {
            @Override
            public void onnameItemClick(int position) {
                Intent detailIntent = new Intent(Bfood.this, Dfood.class);
                Model clickedItem = models.get(position);

                detailIntent.putExtra(Des, clickedItem.getDes());
                detailIntent.putExtra(Name, clickedItem.getName());
                detailIntent.putExtra(IMG, clickedItem.getLink());

                startActivity(detailIntent);
            }

        });
    }

    public void showdata() {

        myRef.child("food").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {


                for (DataSnapshot snap : dataSnapshot.getChildren()) {

                    Model model = dataSnapshot.getValue(Model.class);
                    Log.i("AFQ", dataSnapshot.toString());

                    models.add(model);
                    mAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Bfood.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}