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
    private CheckBox cbInstagram; //atribut Instagram
    private CheckBox cbDiscord; //atribut Discord
    private CheckBox cbTwitch; //atribut Twitch
    private CheckBox cbYoutube; //atribut Youtube
    private CheckBox cbNimoTV; //atribut NimoTV
    private CheckBox cbLainnya; //atribut Lainnya
    private String sumber; //atribut sumber
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
        cbInstagram = findViewById(R.id.instagram); //inisialisasi Checkbox Instagram
        cbDiscord = findViewById(R.id.discord); //inisialisasi Checkbox Discord
        cbTwitch = findViewById(R.id.twitch); //inisialisasi Checkbox Twitch
        cbYoutube = findViewById(R.id.youtube); //inisialisasi Checkbox Youtube
        cbNimoTV = findViewById(R.id.nimotv); //inisialisasi Checkbox NimoTV
        cbLainnya = findViewById(R.id.lainnya); //inisialisasi Checkbox Lainnya
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
                // Mengisi nilai dari hasil return sebuah method
                turnamen = getTurnamenSelected();
                sumber = getSumberSelected();

                // Inisialisasi Alert Dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.warning); // Mengeset Icon
                builder.setTitle("Daftarkan"); // Mengeset Title

                // Mengeset Message
                builder.setMessage(
                        "Apakah anda sudah yakin dengan data anda ?\n\n" +
                        "Nama Lengkap : \n" + txtNamaLengkap.getText().toString() + "\n\n" +
                        "Nickname : \n" + txtNickname.getText().toString() + "\n\n" +
                        "Email : \n" + txtEmail.getText().toString() + "\n\n" +
                        "Domisili : \n" + txtDomisili.getText().toString() + "\n\n" +
                        "Turnament : \n" + turnamen + "\n\n" +
                        "Sumber : \n" + sumber + "\n\n" +
                        "Rating : \n" + nilaiRating + ""
                );

                //method button positive desicion
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Memunculkan Toast
                        Toast.makeText(getApplicationContext(), "Data anda berhasil terdaftarkan !", Toast.LENGTH_SHORT).show();

                        // Inisialisasi Intent untuk berpindah activity
                        Intent layout2 = new Intent(MainActivity.this, MainActivity2.class);

                        // Mengeset data yang akan dikirim ke layout tujuan pada Intent
                        // Memakai putExtra
                        layout2.putExtra("namaLengkap", txtNamaLengkap.getText().toString());
                        layout2.putExtra("nickname", txtNickname.getText().toString());
                        layout2.putExtra("email", txtEmail.getText().toString());
                        layout2.putExtra("domisili", txtDomisili.getText().toString());
                        layout2.putExtra("turnament", turnamen);
                        layout2.putExtra("sumber", sumber);
                        layout2.putExtra("rating", nilaiRating);

                        // Memulai Activity tujuan
                        startActivity(layout2);

                        // Mengakhiri Activity ini
                        finish();
                    }
                });

                //method button negative desicion
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alertDialog = builder.create(); //method get alert dan create alert
                alertDialog.show(); //to show alert
            }
        });
    }

    // Method atau fungsi untuk mengambil data dari Checkbox yang tercheck
    // Method atau fungsi ini akan mengembalikan data berupa String
    private String getSumberSelected() {
        String sumber = "";

        // Jika Checkbox Instagram tercheck
        if (cbInstagram.isChecked()) {
            // Maka variabel sumber akan ditambah sama dengan datanya dengan - Instagram
            // \n disini adalah enter
            // += berarti atau sama dengan penulisan :
            // sumber = sumber + "- Instagram\n"
            sumber += "- Instagram\n";
        }
        if (cbDiscord.isChecked()) {
            sumber += "- Discord\n";
        }
        if (cbTwitch.isChecked()) {
            sumber += "- Twitch\n";
        }
        if (cbYoutube.isChecked()) {
            sumber += "- Youtube\n";
        }
        if (cbNimoTV.isChecked()) {
            sumber += "- NimoTV\n";
        }
        if (cbLainnya.isChecked()) {
            sumber += "- Lainnya\n";
        }

        return sumber;
    }

    // Method atau fungsi untuk mengambil data dari Radio Button yang tercheck
    // Method atau fungsi ini akan mengembalikan data berupa String
    private String getTurnamenSelected() {
        String turnamen = "";

        // Mengambil ID dari Radio Button yang ter check pada Radio Group
        int selectedId = rgTurnamen.getCheckedRadioButtonId();

        // Jika ID yang ter check sama dengan ID Radio button MLBB
        if (selectedId == rbMlbb.getId()) {
            // Maka Variabel turnamen berisi Mobile Legend Bang Bang
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