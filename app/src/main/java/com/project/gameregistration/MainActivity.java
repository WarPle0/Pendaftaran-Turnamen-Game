package com.project.gameregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    static RecyclerView recyclerView;
    private RecyclerviewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setupRecyclerView();

        try {
            Intent intent = getIntent();
            String status = intent.getExtras().getString("status");

            if (status.equals("add")) {
                Toast.makeText(this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            } else if (status.equals("edit")) {
                Toast.makeText(this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            if (userList.isEmpty()) {
                Toast.makeText(this, "Klik fab untuk menambah User", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Klik User untuk opsi lain", Toast.LENGTH_SHORT).show();
            }
        }

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
    }

    static void setupRecyclerView(Context context, List<User> userList, RecyclerView recyclerView) {
        DatabaseHelper db = new DatabaseHelper(context);
        userList = db.selectUserData();

        RecyclerviewAdapter adapter = new RecyclerviewAdapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        DatabaseHelper db = new DatabaseHelper(this);
        userList = db.selectUserData();

        adapter = new RecyclerviewAdapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}