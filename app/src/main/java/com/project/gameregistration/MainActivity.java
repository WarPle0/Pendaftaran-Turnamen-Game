package com.project.gameregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

public class MainActivity extends AppCompatActivity {
    private TextView txtNamaLengkap; //atribut namalengkap
    private TextView txtNickname; //atribut nickname
    private TextView txtEmail; //atribut email
    private TextView txtDomisili; //atribut domisili
    private RadioGroup rgTurnamen; //atribut Radio Grup Turnamen
    private RadioButton rbMlbb; //atribut MLBB
    private RadioButton rbLolwr; //atribut LOL WR
    private RadioButton rbFf; //atribut FF
    private RadioButton rbPubgm; //atribut PUBGM
    private RadioButton rbCodm; //atribut CODM
    private RadioButton rbValorant; //atribut Valorant
    private String turnamen; //atribut turnamen
    private SeekBar seekBar; //atribut seekbar
    private TextView txtRating; //atribut text rating
    private String nilaiRating; //atribut nilai rating
    private Button btnDaftar; //atribut button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNamaLengkap = findViewById(R.id.input_namalengkap); //inisialisasi nama lengkap
        txtNickname = findViewById(R.id.input_nickname); //inisialisasi nickname
        txtEmail = findViewById(R.id.input_email); //inisialisasi email
        txtDomisili = findViewById(R.id.input_domisili); //inisialisasi domisili
        rgTurnamen = findViewById(R.id.rgturnamen); //inisialisasi Radio Group Turnamen
        rbMlbb = findViewById(R.id.mlbb); //inisialisasi Radio Button MLBB
        rbLolwr = findViewById(R.id.lolwr); //inisialisasi Radio Button LOL WR
        rbFf = findViewById(R.id.freefire); //inisialisasi Radio Button FF
        rbPubgm = findViewById(R.id.pubgm); //inisialisasi Radio Button PUBGM
        rbCodm = findViewById(R.id.codm); //inisialisasi Radio Button CODM
        rbValorant = findViewById(R.id.valo); //inisialisasi Radio Button Valorant
        seekBar = findViewById(R.id.seekbar); //inisialisasi seekbar
        txtRating = findViewById(R.id.rating); //inisialisasi rating
        btnDaftar = findViewById(R.id.daftar); //inisialisasi button daftar/submit

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //method listener untuk seekbar
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                nilaiRating = String.valueOf(i); //inisialisasi value/nilai rating
                txtRating.setText("Beri nilai tim kami : " + nilaiRating); //method set dan get
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() { //method button
            @Override
            public void onClick(View view) {
                turnamen = getTurnamenSelected();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.warning);
                builder.setTitle("Daftarkan");
                builder.setMessage(
                        "Apakah anda sudah yakin dengan data anda ?\n\n" +
                        "Nama Lengkap : \n" + txtNamaLengkap.getText().toString() + "\n\n" +
                        "Nickname : \n" + txtNickname.getText().toString() + "\n\n" +
                        "Email : \n" + txtEmail.getText().toString() + "\n\n" +
                        "Domisili : \n" + txtDomisili.getText().toString() + "\n\n" +
                        "Turnament : \n" + turnamen + "\n\n" +
                        "Rating : \n" + nilaiRating + ""
                );

                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() { //method button positive desicion
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Data anda berhasil terdaftarkan !", Toast.LENGTH_SHORT).show();

                        Intent layout2 = new Intent(MainActivity.this, MainActivity2.class);
                        layout2.putExtra("namaLengkap", txtNamaLengkap.getText().toString());
                        layout2.putExtra("nickname", txtNickname.getText().toString());
                        layout2.putExtra("email", txtEmail.getText().toString());
                        layout2.putExtra("domisili", txtDomisili.getText().toString());
                        layout2.putExtra("turnament", turnamen);
                        layout2.putExtra("rating", nilaiRating);
                        startActivity(layout2);
                        finish();
                    }
                });

                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() { //method button negative desicion
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alertDialog = builder.create(); //method get alert dan create alert
                alertDialog.show(); //to show alert
            }
        });
    }

    private String getTurnamenSelected() {
        String turnamen = "";
        int selectedId = rgTurnamen.getCheckedRadioButtonId();

        if (selectedId == rbMlbb.getId()) {
            turnamen = "Mobile Legend Bang Bang";
        } else if (selectedId == rbLolwr.getId()) {
            turnamen = "League of Legends Wild Rift";
        } else if (selectedId == rbFf.getId()) {
            turnamen = "Free Fire";
        } else if (selectedId == rbPubgm.getId()) {
            turnamen = "PUBG Mobile";
        } else if (selectedId == rbCodm.getId()) {
            turnamen = "Call of Duty Mobile";
        } else if (selectedId == rbValorant.getId()) {
            turnamen = "Valorant";
        }

        return turnamen;
    }
}