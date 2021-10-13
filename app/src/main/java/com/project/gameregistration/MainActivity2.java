package com.project.gameregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Ini merupakan cara untuk mengambil data yang dibawa oleh activity sebelumnya
        namaLengkap = getIntent().getExtras().getString("namaLengkap");
        nickname = getIntent().getExtras().getString("nickname");
        email = getIntent().getExtras().getString("email");
        domisili = getIntent().getExtras().getString("domisili");
        turnamen = getIntent().getExtras().getString("turnament");
        sumber = getIntent().getExtras().getString("sumber");
        rating = getIntent().getExtras().getString("rating");

        txtNamaLengkap = findViewById(R.id.isi_namalengkap);
        txtNickname = findViewById(R.id.isi_nickname);
        txtEmail = findViewById(R.id.isi_email);
        txtDomisili = findViewById(R.id.isi_domisili);
        txtTurnamen = findViewById(R.id.isi_turnamen);
        txtSumber = findViewById(R.id.isi_sumber);
        txtRating = findViewById(R.id.isi_rating);

        // Masing-masing TextView di set Text atau isinya sesuai dengan data yang dikirim oleh Activity sebelumnya
        txtNamaLengkap.setText(namaLengkap);
        txtNickname.setText(nickname);
        txtEmail.setText(email);
        txtDomisili.setText(domisili);
        txtTurnamen.setText(turnamen);
        txtSumber.setText(sumber);
        txtRating.setText(rating);
    }

    // Sebuah Fungsi yang dipanggil atau akan tereksekusi saat Activity tampil ke pengguna
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Menampilkan Activity", Toast.LENGTH_SHORT).show();
    }

    // Sebuah Fungsi yang dipanggil atau akan tereksekusi saat Activity di hentikan sementara
    // Bisa di cek ketika anda mengetuk home di HP
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Menjeda Activity", Toast.LENGTH_SHORT).show();
    }

    // Sebuah Fungsi yang dipanggil atau akan tereksekusi saat Activity Dimulai kembali ( setelah Pause )
    // Setelah mengklik home anda bisa membuka aplikasi ini lagi untuk mengecek fungsi ini
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Memulai Activity Kembali", Toast.LENGTH_SHORT).show();
    }

    // Sebuah Fungsi yang dipanggil atau akan tereksekusi saat Activity dihancurkan
    // Atau aplikasi di close atau exit, klik saja tombol kembali atau back pada Hp
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Menghancurkan Activity", Toast.LENGTH_SHORT).show();
    }
}