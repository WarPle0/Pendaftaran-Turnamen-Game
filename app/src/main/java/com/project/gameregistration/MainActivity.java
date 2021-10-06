package com.project.gameregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    private TextView txtNamaLengkap;
    private TextView txtNickname;
    private TextView txtEmail;
    private TextView txtDomisili;
    private SeekBar seekBar;
    private TextView txtRating;
    private String nilaiRating;
    private Button btnDaftar;
//    private RadioGroup radioGroup;
//    private RadioButton mlbb, lolwr, ff, pubgm, codm, valo;
//    private String rButtonGames = "";
//    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6;
//    private String pilihanCheckBox = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNamaLengkap = findViewById(R.id.input_namalengkap);
        txtNickname = findViewById(R.id.input_nickname);
        txtEmail = findViewById(R.id.input_email);
        txtDomisili = findViewById(R.id.input_domisili);
        seekBar = findViewById(R.id.seekbar);
        txtRating = findViewById(R.id.rating);
        btnDaftar = findViewById(R.id.daftar);
//        radioGroup = findViewById(R.id.rgturnamen);
//        mlbb = findViewById(R.id.mlbb);
//        lolwr = findViewById(R.id.lolwr);
//        ff = findViewById(R.id.freefire);
//        pubgm = findViewById(R.id.pubgm);
//        codm = findViewById(R.id.codm);
//        valo = findViewById(R.id.valo);
//        cb1 = findViewById(R.id.instagram);
//        cb2 = findViewById(R.id.discord);
//        cb3 = findViewById(R.id.twitch);
//        cb4 = findViewById(R.id.youtube);
//        cb5 = findViewById(R.id.nimotv);
//        cb6 = findViewById(R.id.lainnya);

//        if (mlbb.isChecked()) {
//            rButtonGames += "Mobile Legends";
//        } if (lolwr.isChecked()) {
//            rButtonGames += "League of Legends";
//        } if (ff.isChecked()) {
//            rButtonGames += "Free Fire";
//        } if (pubgm.isChecked()) {
//            rButtonGames += "PlayerUnknown's BattleGround Mobile";
//        } if (codm.isChecked()) {
//            rButtonGames += "Call of Duty Mobile";
//        } if (valo.isChecked()) {
//            rButtonGames += "Valorant";
//        }

//        if (cb1.isChecked())
//            pilihanCheckBox += "\n" + cb1.getText().toString();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                nilaiRating = String.valueOf(i);
                txtRating.setText("Beri nilai tim kami : " + nilaiRating);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.warning);
                builder.setTitle("Daftarkan");
                builder.setMessage(
                        "Apakah anda sudah yakin dengan data anda ?\n\n" +
                        "Nama Lengkap : \n" + txtNamaLengkap.getText() + "\n\n" +
                        "Nickname : \n" + txtNickname.getText() + "\n\n" +
                        "Email : \n" + txtEmail.getText() + "\n\n" +
                        "Domisili : \n" + txtDomisili.getText() + "\n\n" +
//                        "Turnamen Game yang diikuti : \n" + radioGroup.getCheckedRadioButtonId() + "\n\n" +
//                        "Sumber info : \n" + pilihanCheckBox + "\n\n" +
                        "Rating : \n" + nilaiRating + ""
                );

                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Data anda berhasil terdaftarkan !", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}