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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VsHuman();
        VsComputer();
    }


    private void VsHuman(){
        Button button= findViewById(R.id.human);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VsHumanActivity.class);
                startActivity(intent);
            }
        });

    }


    private void VsComputer(){
        Button button= findViewById(R.id.vsComputer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,VsComputerActivity.class);
                startActivity(intent);
            }
        });

    }
}
