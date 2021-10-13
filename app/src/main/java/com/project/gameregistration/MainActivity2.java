package com.project.gameregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtNamaLengkap;
    private TextView txtNickname;
    private TextView txtEmail;
    private TextView txtDomisili;
    private TextView txtTurnamen;
    private TextView txtRating;
    private String namaLengkap;
    private String nickname;
    private String email;
    private String domisili;
    private String turnamen;
    private String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        namaLengkap = getIntent().getExtras().getString("namaLengkap");
        nickname = getIntent().getExtras().getString("nickname");
        email = getIntent().getExtras().getString("email");
        domisili = getIntent().getExtras().getString("domisili");
        turnamen = getIntent().getExtras().getString("turnament");
        rating = getIntent().getExtras().getString("rating");

        txtNamaLengkap = findViewById(R.id.isi_namalengkap);
        txtNickname = findViewById(R.id.isi_nickname);
        txtEmail = findViewById(R.id.isi_email);
        txtDomisili = findViewById(R.id.isi_domisili);
        txtTurnamen = findViewById(R.id.isi_turnamen);
//        txtRating = findViewById(R.id.isi_namalengkap);

        txtNamaLengkap.setText(namaLengkap);
        txtNickname.setText(nickname);
        txtEmail.setText(email);
        txtDomisili.setText(domisili);
        txtTurnamen.setText(turnamen);
    }
}