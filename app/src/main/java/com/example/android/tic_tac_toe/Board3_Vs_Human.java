/*
  This Game was developed by Charles Uhiara During the ALC 2.0 program
  Email: Charlyge2@gmail.com
  phone: +2347066241263
  Twitter: @charlyge2

 */
package com.example.android.tic_tac_toe;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.tic_tac_toe.R.color.TextColor;
import static com.example.android.tic_tac_toe.VsHumanActivity.playerO;
import static com.example.android.tic_tac_toe.VsHumanActivity.playerX;

public class Board3_Vs_Human extends AppCompatActivity implements View.OnClickListener {
private Button[] b;
private int count=0;
private int player1_Score=0;
    private int player2Score;
    private boolean players=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board3);
        main_menu();

        TextView textView = findViewById(R.id.player1tv);
        textView.setText(playerO);

        TextView textView1 = findViewById(R.id.player2tv);
        textView1.setText(playerX);
        Toast.makeText(Board3_Vs_Human.this,playerO + " starts first ", Toast.LENGTH_LONG).show();
        b= new Button[9];
        for(int i =0;i<9;i++){

            String ButtonId= "bt" + i;
            int ResdId = getResources().getIdentifier(ButtonId,"id",getPackageName());
            b[i]=findViewById(ResdId);
            b[i].setOnClickListener(this);

        }
        Button resetButton = findViewById(R.id.ok);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBoard();
            }
        });

    }

    @Override
    public void onClick(View view) {
        count++;
        if(count==1||count==3||count==5||count==7||count==9){
            ((Button)view).setText("O");
            ((Button) view).setTextColor(getResources().getColor(TextColor));
            view.setEnabled(false);
            checkWinner();
            checkDraw();

        }
        else{
            ((Button)view).setText("X");
            view.setEnabled(false);
            checkWinner();
        checkDraw();
        }
    }

    private void checkWinner(){

        if (b[0].getText() == b[4].getText() && b[0].getText() == b[8].getText() && !b[0].isEnabled()) {
            b[0].setBackgroundResource(R.drawable.button_red);
            b[4].setBackgroundResource(R.drawable.button_red);
            b[8].setBackgroundResource(R.drawable.button_red);
            checkWhoWon();

        }
        if (b[2].getText() == b[4].getText() && b[2].getText() == b[6].getText() && !b[2].isEnabled()) {
            b[2].setBackgroundResource(R.drawable.button_red);
            b[4].setBackgroundResource(R.drawable.button_red);
            b[6].setBackgroundResource(R.drawable.button_red);
            checkWhoWon();

        }
        //checking for horizontal win
        for(int i =0;i<=3;i+=3){
            if(b[i].getText()==b[i+1].getText() && b[i].getText()==b[i+2].getText() && !b[i].isEnabled()){
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+1].setBackgroundResource(R.drawable.button_red);
                b[i+2].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }
        }
        //checking for vertical wins
        for (int i=0;i<=2;i++){
            if(b[i].getText()==b[i+3].getText() && b[i].getText()==b[i+6].getText() && !b[i].isEnabled()){
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+3].setBackgroundResource(R.drawable.button_red);
                b[i+6].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }

        }


    }
    private void checkWhoWon(){
        if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9) {
            final Dialog dialog = new Dialog(Board3_Vs_Human.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            String playerWins = playerO + " WINS !!!!!";
            textView.setText(playerWins);
            textView.setTextColor(getResources().getColor(R.color.colorAccent));
            LinearLayout linearLayout = dialog.findViewById(R.id.dialogue);
            ImageView imageView =dialog.findViewById(R.id.img_View);
            imageView.setImageResource(R.drawable.win);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.background_win));
            Button button =dialog.findViewById(R.id.ok);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }

            });
            dialog.show();

            Toast.makeText(Board3_Vs_Human.this, playerO + " wins ", Toast.LENGTH_LONG).show();

            player1_Score++;
            TextView player1_Score_textView = findViewById(R.id.player1_score);

            player1_Score_textView.setText(String.valueOf(player1_Score));
            disAbleButton();
            players=false;
        } else {
            final Dialog dialog = new Dialog(Board3_Vs_Human.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            String playerWins = playerX + " WINS !!!!!";
            textView.setText(playerWins);
            textView.setTextColor(getResources().getColor(R.color.colorAccent));
            LinearLayout linearLayout = dialog.findViewById(R.id.dialogue);
            ImageView imageView =dialog.findViewById(R.id.img_View);
            imageView.setImageResource(R.drawable.win);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            Button button =dialog.findViewById(R.id.ok);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }

            });
            dialog.show();

            Toast.makeText(Board3_Vs_Human.this, playerX, Toast.LENGTH_LONG).show();


            player2Score++;
            TextView player2_computer_Score_textView = findViewById(R.id.player2_computer_score);
            player2_computer_Score_textView.setText(String.valueOf(player2Score));

            disAbleButton();
            players =false;
        }

    }
    private void disAbleButton(){
        for (int i=0;i<9;i++){
            b[i].setEnabled(false);

        }

    }

    private void checkDraw(){
        if(count==9 && players){
            final Dialog dialog = new Dialog(Board3_Vs_Human.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            textView.setText(R.string.itsADraw);
            textView.setTextColor(getResources().getColor(R.color.colorAccent));
            LinearLayout linearLayout = dialog.findViewById(R.id.dialogue);
            ImageView imageView =dialog.findViewById(R.id.img_View);
            imageView.setImageResource(R.drawable.draw);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            Button button =dialog.findViewById(R.id.ok);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }

            });
            dialog.show();
            Toast.makeText(Board3_Vs_Human.this, "its a Draw", Toast.LENGTH_LONG).show();
        }

    }

    private void resetBoard() {
        for (int i = 0; i < 9; i++) {
            b[i].setEnabled(true);
            b[i].setText("");
            b[i].setTextColor(Color.BLACK);
            b[i].setBackgroundResource(R.drawable.button);
        }
        count = 0;
       players=true;

    }
    private void main_menu(){
        Button button =findViewById(R.id.main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Board3_Vs_Human.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    }

