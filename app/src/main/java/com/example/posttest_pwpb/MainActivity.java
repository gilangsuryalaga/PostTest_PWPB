package com.example.posttest_pwpb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnUserActionListener {
FloatingActionButton buttonAdd;
    DatabaseReference databaseData;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<Data> Datalist = new ArrayList<>();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        databaseData = FirebaseDatabase.getInstance().getReference("Data");
        buttonAdd = (FloatingActionButton) findViewById(R.id.add);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent move = new Intent(context,EntryDataActivity.class);
        startActivity(move);
    }

});
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Datalist.clear();

                for (DataSnapshot dataSnapShot : dataSnapshot.getChildren()){
                    Data data = dataSnapShot.getValue(Data.class);

                    Datalist.add(data);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        RecyclerAdapter adapter = new RecyclerAdapter(MainActivity.this,MainActivity.this,Datalist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
