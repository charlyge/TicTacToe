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
import android.widget.Toast;

public class VsHumanActivity extends AppCompatActivity {
    public static String playerX;
    public static String playerO;
    private EditText editText;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vs_human);
        editText=findViewById(R.id.playerx);
         editText1=findViewById(R.id.playerO);

        onSelectBoard3();
        onSelectBoard5();
    }


    private void onSelectBoard3(){
            Button button = findViewById(R.id.board_3);
            button.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    if (String.valueOf(editText.getText()).isEmpty() || String.valueOf(editText1.getText()).isEmpty()) {

                        Toast.makeText(VsHumanActivity.this, "Enter players Name", Toast.LENGTH_SHORT).show();
                    } else {

                        playerO= String.valueOf(editText1.getText());
                        playerX= String.valueOf(editText.getText());
                        Intent intent = new Intent(VsHumanActivity.this,Board3_Vs_Human.class);
                        startActivity(intent);
                    }
                }
            });

        }


    private void onSelectBoard5(){

            Button button = findViewById(R.id.board_5);



        button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    if (String.valueOf(editText.getText()).isEmpty() || String.valueOf(editText1.getText()).isEmpty()) {

                        Toast.makeText(VsHumanActivity.this, "Enter players Name", Toast.LENGTH_SHORT).show();
                    } else {

                        playerO= String.valueOf(editText1.getText());
                        playerX= String.valueOf(editText.getText());
                        Intent intent = new Intent(VsHumanActivity.this, Board5_vs_human.class);
                        startActivity(intent);

                    }
                }
            });

        }

    }

