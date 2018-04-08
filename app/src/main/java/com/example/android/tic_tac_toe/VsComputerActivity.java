/*
  This Game was developed by Charles Uhiara During the ALC 2.0 program
  Email: Charlyge2@gmail.com
  phone: +2347066241263
  Twitter: @charlyge2

 */
package com.example.android.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class VsComputerActivity extends AppCompatActivity {
    public static String sPlayerLetter;
    public static String sComputerLetter;
    public static String sPlayerName;
    private RadioButton RbuttonO;
    private RadioButton RbuttonX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs_computer);

        onSelectO();
        onSelectX();
        onSelectBoard3();
        onSelectBoard5();
    }

    //Method listens for event on Button X and Assigns it to
    // player through nPl variable;

    private void onSelectX() {
        RbuttonX = findViewById(R.id.x);
        RbuttonX.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sPlayerLetter = (String) RbuttonX.getText();
                sComputerLetter = (String) RbuttonO.getText();
            }
        });

    }

    //Method listens for event on Button O and Assigns it to
    // player through nPl variable;

    private void onSelectO() {

        RbuttonO = findViewById(R.id.o);
        RbuttonO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sPlayerLetter = (String) RbuttonO.getText();
                sComputerLetter = (String) RbuttonX.getText();

            }
        });
    }


    private void onSelectBoard3() {
        Button button = findViewById(R.id.board_3);
        final EditText editText = findViewById(R.id.playerName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (String.valueOf(editText.getText()).isEmpty()) {
                    Toast.makeText(VsComputerActivity.this, "Enter Player Name ", Toast.LENGTH_LONG).show();

                } else if (RbuttonO.isChecked() || RbuttonX.isChecked() && !String.valueOf(editText.getText()).isEmpty()) {
                    sPlayerName = String.valueOf(editText.getText());
                    Intent intent = new Intent(VsComputerActivity.this, Board3_Vs_Comp.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(VsComputerActivity.this, "Select X or O", Toast.LENGTH_LONG).show();

                }
            }
        });


    }


    private void onSelectBoard5() {

        Button button = findViewById(R.id.board_5);
        final EditText editText = findViewById(R.id.playerName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (String.valueOf(editText.getText()).isEmpty()) {
                    Toast.makeText(VsComputerActivity.this, "Enter Player Name ", Toast.LENGTH_LONG).show();

                } else if (RbuttonO.isChecked() || RbuttonX.isChecked() && !String.valueOf(editText.getText()).isEmpty()) {
                    sPlayerName = String.valueOf(editText.getText());
                    Intent intent = new Intent(VsComputerActivity.this, Board5_Vs_comp.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(VsComputerActivity.this, "Select X or O", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

}
