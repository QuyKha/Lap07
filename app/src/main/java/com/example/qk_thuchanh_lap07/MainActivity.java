package com.example.qk_thuchanh_lap07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SqlLiteHandler db = new SqlLiteHandler(this);

//        db.add(new Personal("Ravi"));
//        db.add(new Personal("Srinivas"));
//        db.add(new Personal("Tommy"));
//        db.add(new Personal("Karthik"));

        List<Personal> personals = db.getAll();
        List<String> names = new ArrayList<>();

        for(Personal personal : personals) {
            names.add(personal.getName());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);

        ListView listView = findViewById(R.id.listView);
        EditText editText = findViewById(R.id.editTextName);
        Button btnAdd = findViewById(R.id.buttonAdd);
        Button btnRm = findViewById((R.id.buttonRemove));
        Button btnCancel = findViewById(R.id.buttonCancel);
        listView.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                db.add(new Personal(name));
                arrayAdapter.add(name);
                listView.setAdapter(arrayAdapter);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editText.setText(arrayAdapter.getItem(i).toString());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

        btnRm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                db.deleteByName(name);
                arrayAdapter.remove(name);
                listView.setAdapter(arrayAdapter);
            }
        });

    }
}