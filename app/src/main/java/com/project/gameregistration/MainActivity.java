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
    private TextView txtNamaLengkap; //atribut namalengkap
    private TextView txtNickname; //atribut nickname
    private TextView txtEmail; //atribut email
    private TextView txtDomisili; //atribut domisili
    private SeekBar seekBar; //atribut seekbar
    private TextView txtRating; //atribut text rating
    private String nilaiRating; //atribut nilai rating
    private Button btnDaftar; //atribut button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNamaLengkap = findViewById(R.id.input_namalengkap); //inisiasi nama lengkap
        txtNickname = findViewById(R.id.input_nickname); //inisiasi nickname
        txtEmail = findViewById(R.id.input_email); //inisiasi email
        txtDomisili = findViewById(R.id.input_domisili); //inisiasi domisili
        seekBar = findViewById(R.id.seekbar); //inisiasi seekbar
        txtRating = findViewById(R.id.rating); //inisiasi rating
        btnDaftar = findViewById(R.id.daftar); //inisiasi button daftar/submit

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //method listener untuk seekbar
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                nilaiRating = String.valueOf(i); //inisiasi value/nilai rating
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
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.warning);
                builder.setTitle("Daftarkan");
                builder.setMessage(
                        "Apakah anda sudah yakin dengan data anda ?\n\n" +
                        "Nama Lengkap : \n" + txtNamaLengkap.getText() + "\n\n" + //method get
                        "Nickname : \n" + txtNickname.getText() + "\n\n" + //method get
                        "Email : \n" + txtEmail.getText() + "\n\n" + //method get
                        "Domisili : \n" + txtDomisili.getText() + "\n\n" + //method get
                        "Rating : \n" + nilaiRating + ""
                );

                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() { //method button positive desicion
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Data anda berhasil terdaftarkan !", Toast.LENGTH_SHORT).show();
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
}