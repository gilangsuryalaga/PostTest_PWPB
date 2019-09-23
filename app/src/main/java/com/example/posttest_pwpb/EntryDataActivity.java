package com.example.posttest_pwpb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EntryDataActivity extends AppCompatActivity {
    Button buttonAdd;
    EditText editJudul;
    EditText editIsi;
    Context context;
    DatabaseReference databaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data);
        context = this;
        buttonAdd = (Button) findViewById(R.id.add_data);
        editJudul = (EditText) findViewById(R.id.editjudul);
        editIsi = (EditText) findViewById(R.id.editisi);

        databaseData = FirebaseDatabase.getInstance().getReference("Data");

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });
    }

    private void addData() {
        databaseData = FirebaseDatabase.getInstance().getReference("Data");
        String judul = editJudul.getText().toString().trim();
        String isi = editIsi.getText().toString().trim();
        if (!TextUtils.isEmpty(judul)) {

            String id = databaseData.push().getKey();

            Data data = new Data(id,judul,isi);

            databaseData.child(id).setValue(data);

            Toast.makeText(this, "Data added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You should enter a name", Toast.LENGTH_LONG).show();
        }
    }

}
