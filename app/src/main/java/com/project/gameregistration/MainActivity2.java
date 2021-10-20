package com.project.gameregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    // Pendeklarasian Variabel
    private TextView txtNamaLengkap;
    private TextView txtNickname;
    private TextView txtEmail;
    private TextView txtDomisili;
    private TextView txtTurnamen;
    private TextView txtSumber;
    private TextView txtRating;
    private String namaLengkap;
    private String nickname;
    private String email;
    private String domisili;
    private String turnamen;
    private String sumber;
    private String rating;

    private DatabaseHelper db;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Penginisialisasian variabel db
        // Juga userList yang isinya berupa data dari database
        db = new DatabaseHelper(this);
        userList = db.selectUserData();

        txtNamaLengkap = findViewById(R.id.isi_namalengkap);
        txtNickname = findViewById(R.id.isi_nickname);
        txtEmail = findViewById(R.id.isi_email);
        txtDomisili = findViewById(R.id.isi_domisili);
        txtTurnamen = findViewById(R.id.isi_turnamen);
        txtSumber = findViewById(R.id.isi_sumber);
        txtRating = findViewById(R.id.isi_rating);

        // Meng-set variabel yang datanya dari database
        // Karena ini hanya mencoba untuk read data
        // Maka hanya menampilkan data user terakhir yang dimasukan datanya
        // userList.get(userList.size()-1) ini artinya memanggil data terakhir di List
        namaLengkap = userList.get(userList.size()-1).getNamaLengkap();
        nickname = userList.get(userList.size()-1).getNickname();
        email = userList.get(userList.size()-1).getEmail();
        domisili = userList.get(userList.size()-1).getDomisili();
        turnamen = userList.get(userList.size()-1).getTurnament();
        sumber = userList.get(userList.size()-1).getSumber();
        rating = userList.get(userList.size()-1).getRating();

        // Masing-masing TextView di set Text atau isinya sesuai dengan data dari database
        txtNamaLengkap.setText(namaLengkap);
        txtNickname.setText(nickname);
        txtEmail.setText(email);
        txtDomisili.setText(domisili);
        txtTurnamen.setText(turnamen);
        txtSumber.setText(sumber);
        txtRating.setText(rating);
    }
}