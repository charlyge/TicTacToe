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

import java.util.Random;

import static com.example.android.tic_tac_toe.VsComputerActivity.sComputerLetter;
import static com.example.android.tic_tac_toe.VsComputerActivity.sPlayerLetter;
import static com.example.android.tic_tac_toe.VsComputerActivity.sPlayerName;


public class Board5_Vs_comp extends AppCompatActivity implements View.OnClickListener {
    private Button[] b;
    private String npl = sPlayerLetter;
    private String ncl = sComputerLetter;
    private int count;
    private String NewPlayerName = sPlayerName;
    private int PlayerScore;
    private int r;
    private int ComputerScore;
    private boolean computer_Turn = true;
    private boolean PlayersTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board5);
        TextView textView = findViewById(R.id.player1tv);
        textView.setText(NewPlayerName);
        main_menu();

        b = new Button[25];
        for (int i = 0; i < 25; i++) {
            String ButtonId = "bt" + i;
            int ResId = getResources().getIdentifier(ButtonId, "id", getPackageName());
            b[i] = findViewById(ResId);
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

        if (view.isEnabled()) {
            Random random = new Random();
            r = random.nextInt(20);

            ((Button) view).setText(npl);
            view.setEnabled(false);
            ((Button) view).setTextColor(getResources().getColor(R.color.TextColor));
            count++;
            checkWinner();

            // Method checks if move is still available on board before proceeding to computers turn
            // returns draw if all buttons are disable and both computer and users turn is still true
            if (count == 25 && computer_Turn && PlayersTurn) {
                final Dialog dialog = new Dialog(Board5_Vs_comp.this);
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

            }


        }
        if (computer_Turn) {
            comp_Move();
            checkWinner();
        }

    }

    private void comp_Move() {
        if (About_2_win() == 1 && (b[0].isEnabled() || b[1].isEnabled() || b[2].isEnabled() || b[3].isEnabled() || b[4].isEnabled())) {
            for (int i = 0; i < 5; i++) {
                if (b[i].isEnabled()) {
                    b[i].setText(ncl);
                    b[i].setEnabled(false);
                    break;
                }

            }


        } else if (About_2_win() == 2 && (b[5].isEnabled() || b[6].isEnabled() || b[7].isEnabled() || b[8].isEnabled() || b[9].isEnabled())) {
            for (int i = 5; i < 10; i++) {
                if (b[i].isEnabled()) {
                    b[i].setText(ncl);
                    b[i].setEnabled(false);
                    break;
                }

            }


        } else if (About_2_win() == 3 && (b[10].isEnabled() || b[11].isEnabled() || b[12].isEnabled() || b[13].isEnabled() || b[14].isEnabled())) {
            for (int i = 10; i < 15; i++) {
                if (b[i].isEnabled()) {
                    b[i].setText(ncl);
                    b[i].setEnabled(false);
                    break;
                }

            }


        } else if (About_2_win() == 4 && (b[15].isEnabled() || b[16].isEnabled() || b[17].isEnabled() || b[18].isEnabled() || b[19].isEnabled())) {
            for (int i = 15; i < 20; i++) {
                if (b[i].isEnabled()) {
                    b[i].setText(ncl);
                    b[i].setEnabled(false);
                    break;
                }

            }


        } else if (About_2_win() == 5 && (b[20].isEnabled() || b[21].isEnabled() || b[22].isEnabled() || b[23].isEnabled() || b[24].isEnabled())) {
            for (int i = 20; i < 25; i++) {
                if (b[i].isEnabled()) {
                    b[i].setText(ncl);
                    b[i].setEnabled(false);
                    break;
                }

            }


        } else if (About_2_win() == 6 && (b[0].isEnabled() || b[5].isEnabled() || b[10].isEnabled() || b[15].isEnabled() || b[20].isEnabled())) {
            for (int i = 0; i < 21; i += 5) {
                if (b[i].isEnabled()) {
                    b[i].setText(ncl);
                    b[i].setEnabled(false);
                    break;
                }

            }


        }
        else if (b[19].getText() == npl && b[18].getText() == npl && b[17].getText() == npl && b[16].isEnabled()) {
            b[16].setText(ncl);
            b[16].setEnabled(false);

        }
        else if (b[14].getText() == npl && b[13].getText() == npl && b[12].getText() == npl && b[11].isEnabled()) {
            b[11].setText(ncl);
            b[11].setEnabled(false);

        }
        else if (b[9].getText() == npl && b[8].getText() == npl && b[7].getText() == npl && b[6].isEnabled()) {
            b[6].setText(ncl);
            b[6].setEnabled(false);

        }
        else if (b[24].getText() == npl && b[23].getText() == npl && b[22].getText() == npl && b[21].isEnabled()) {
            b[21].setText(ncl);
            b[21].setEnabled(false);

        }
        else if (b[22].getText() == npl && b[17].getText() == npl && b[12].getText() == npl && b[7].isEnabled()) {
            b[7].setText(ncl);
            b[7].setEnabled(false);

        }
        else if (b[0].getText() == npl && b[6].getText() == npl && b[12].getText() == npl && b[18].isEnabled()) {
            b[18].setText(ncl);
            b[18].setEnabled(false);

        }
        else if (b[3].getText() == npl && b[7].getText() == npl && b[11].getText() == npl && b[15].isEnabled()) {
            b[15].setText(ncl);
            b[15].setEnabled(false);

        }
        else if (b[15].getText() == npl && b[7].getText() == npl && b[11].getText() == npl && b[3].isEnabled()) {
            b[3].setText(ncl);
            b[3].setEnabled(false);

        }
        else if (b[6].getText() == npl && b[12].getText() == npl && b[18].getText() == npl && b[24].isEnabled()) {
            b[24].setText(ncl);
            b[24].setEnabled(false);

        }
        else if (b[20].getText() == npl && b[15].getText() == npl && b[10].getText() == npl && b[5].isEnabled()) {
            b[5].setText(ncl);
            b[5].setEnabled(false);

        }
        else if (b[21].getText() == npl && b[16].getText() == npl && b[11].getText() == npl && b[6].isEnabled()) {
            b[6].setText(ncl);
            b[6].setEnabled(false);

        }

        else if (b[22].getText() == npl && b[17].getText() == npl && b[12].getText() == npl && b[7].isEnabled()) {
            b[7].setText(ncl);
            b[7].setEnabled(false);

        }
        else if (b[23].getText() == npl && b[18].getText() == npl && b[13].getText() == npl && b[8].isEnabled()) {
            b[8].setText(ncl);
            b[8].setEnabled(false);

        }

       else if (b[23].getText() == npl && b[18].getText() == npl && b[13].getText() == npl && b[8].isEnabled()) {
            b[8].setText(ncl);
            b[8].setEnabled(false);

        }
        else  if (b[8].getText() == npl && b[18].getText() == npl && b[13].getText() == npl && b[23].isEnabled()) {
            b[23].setText(ncl);
            b[23].setEnabled(false);

        }
        else if (b[20].getText() == npl && b[16].getText() == npl && b[12].getText() == npl && b[8].isEnabled()) {
            b[8].setText(ncl);
            b[8].setEnabled(false);

        }
        else if (b[24].getText() == npl && b[19].getText() == npl && b[14].getText() == npl && b[9].isEnabled()) {
            b[9].setText(ncl);
            b[9].setEnabled(false);

        }

        else if (b[24].getText() == npl && b[18].getText() == npl && b[12].getText() == npl && b[6].isEnabled()) {
            b[6].setText(ncl);
            b[6].setEnabled(false);

        }
        else if (b[6].getText() == npl && b[18].getText() == npl && b[12].getText() == npl && b[24].isEnabled()) {
            b[24].setText(ncl);
            b[24].setEnabled(false);

        }
        else if (b[4].getText() == npl && b[8].getText() == npl && b[12].getText() == npl && b[16].isEnabled()) {
            b[16].setText(ncl);
            b[16].setEnabled(false);

        }
        else if (b[7].getText() == npl && b[12].getText() == npl && b[17].getText() == npl && b[22].isEnabled()) {
            b[22].setText(ncl);
            b[22].setEnabled(false);

        }
        else if (b[6].getText() == npl && b[11].getText() == npl && b[16].getText() == npl && b[21].isEnabled()) {
            b[21].setText(ncl);
            b[21].setEnabled(false);

        }
        else if (b[5].getText() == npl && b[15].getText() == npl && b[10].getText() == npl && b[20].isEnabled()) {
            b[20].setText(ncl);
            b[20].setEnabled(false);

        }
        else if (b[9].getText() == npl && b[14].getText() == npl && b[19].getText() == npl && b[24].isEnabled()) {
            b[24].setText(ncl);
            b[24].setEnabled(false);

        }
        else if (b[20].getText() == npl && b[16].getText() == npl && b[12].getText() == npl && b[8].isEnabled()) {
            b[8].setText(ncl);
            b[8].setEnabled(false);

        }

        else if (b[3].getText() == npl && b[8].getText() == npl && b[13].getText() == npl && b[18].isEnabled()) {
            b[18].setText(ncl);
            b[18].setEnabled(false);

        }
        else if (b[2].getText() == npl && b[7].getText() == npl && b[12].getText() == npl && b[17].isEnabled()) {
            b[17].setText(ncl);
            b[17].setEnabled(false);

        }

        else if (b[1].getText() == npl && b[6].getText() == npl && b[11].getText() == npl && b[16].isEnabled()) {
            b[16].setText(ncl);
            b[16].setEnabled(false);

        }
        else if (b[0].getText() == npl && b[5].getText() == npl && b[10].getText() == npl && b[15].isEnabled()) {
            b[15].setText(ncl);
            b[15].setEnabled(false);

        }

        else if (b[15].getText() == npl && b[16].getText() == npl && b[17].getText() == npl && b[18].isEnabled()) {
            b[18].setText(ncl);
            b[18].setEnabled(false);

        }
        else if (b[19].getText() == npl && b[18].getText() == npl && b[17].getText() == npl && b[16].isEnabled()) {
            b[16].setText(ncl);
            b[16].setEnabled(false);

        }

        else if (b[14].getText() == npl && b[13].getText() == npl && b[12].getText() == npl && b[11].isEnabled()) {
            b[11].setText(ncl);
            b[11].setEnabled(false);

        }
        else if (b[4].getText() == npl && b[9].getText() == npl && b[14].getText() == npl && b[19].isEnabled()) {
            b[19].setText(ncl);
            b[19].setEnabled(false);

        }

        else if (b[24].getText() == npl && b[19].getText() == npl && b[14].getText() == npl && b[9].isEnabled()) {
            b[9].setText(ncl);
            b[9].setEnabled(false);

        }
        else if (b[r].isEnabled()) {
            b[r].setText(sComputerLetter);
            b[r].setEnabled(false);
        }
        else {

            for (int i = 0; i < 25; i++) {
                if (b[i].isEnabled()) {
                    b[i].setText(ncl);
                    b[i].setEnabled(false);
                    break;
                }
            }
        }
        count++;
    }


    private int About_2_win() {
        int position = 0;
        if (b[0].getText() == npl && b[1].getText() == npl || b[3].getText() == npl && b[4].getText() == npl) {

            return 1;
        }
        if (b[5].getText() == npl && b[6].getText() == npl || b[8].getText() == npl && b[9].getText() == npl) {

            return 2;
        }

        if (b[10].getText() == npl && b[11].getText() == npl || b[13].getText() == npl && b[14].getText() == npl) {

            return 3;
        }
        if (b[15].getText() == npl && b[16].getText() == npl || b[18].getText() == npl && b[19].getText() == npl) {

            return 4;
        }
        if (b[20].getText() == npl && b[21].getText() == npl || b[23].getText() == npl && b[24].getText() == npl) {

            return 5;
        }
        if (b[0].getText() == npl && b[5].getText() == npl || b[15].getText() == npl && b[20].getText() == npl) {

            return 6;
        }
        return position;
    }

    private void checkWinner() {

        // Checking diagonal wins
        if (b[1].getText() == b[7].getText() && b[1].getText() == b[13].getText() && b[1].getText() == b[19].getText() && !b[1].isEnabled()) {
            b[1].setBackgroundResource(R.drawable.button_red);
            b[7].setBackgroundResource(R.drawable.button_red);
            b[13].setBackgroundResource(R.drawable.button_red);
            b[19].setBackgroundResource(R.drawable.button_red);

            checkWhoWon();

        }

        else if (b[3].getText() == b[7].getText() && b[3].getText() == b[11].getText() && b[3].getText() == b[15].getText() && !b[3].isEnabled()) {
            b[3].setBackgroundResource(R.drawable.button_red);
            b[7].setBackgroundResource(R.drawable.button_red);
            b[11].setBackgroundResource(R.drawable.button_red);
            b[15].setBackgroundResource(R.drawable.button_red);
            checkWhoWon();


        }

        else if (b[23].getText() == b[17].getText() && b[23].getText() == b[11].getText() && b[23].getText() == b[5].getText() && !b[23].isEnabled()) {
            b[23].setBackgroundResource(R.drawable.button_red);
            b[17].setBackgroundResource(R.drawable.button_red);
            b[11].setBackgroundResource(R.drawable.button_red);
            b[5].setBackgroundResource(R.drawable.button_red);
            checkWhoWon();


        }

        else if (b[21].getText() == b[17].getText() && b[21].getText() == b[13].getText() && b[21].getText() == b[9].getText() && !b[21].isEnabled()) {
            b[21].setBackgroundResource(R.drawable.button_red);
            b[17].setBackgroundResource(R.drawable.button_red);
            b[9].setBackgroundResource(R.drawable.button_red);
            b[13].setBackgroundResource(R.drawable.button_red);
            checkWhoWon();


        }

        else if (b[0].getText() == b[6].getText() && b[0].getText() == b[12].getText() && b[0].getText() == b[18].getText() && !b[0].isEnabled()) {
            b[0].setBackgroundResource(R.drawable.button_red);
            b[6].setBackgroundResource(R.drawable.button_red);
            b[12].setBackgroundResource(R.drawable.button_red);
            b[18].setBackgroundResource(R.drawable.button_red);
            checkWhoWon();


        }

        else if (b[24].getText() == b[18].getText() && b[24].getText() == b[12].getText() && b[24].getText() == b[6].getText() && !b[24].isEnabled()) {
            b[24].setBackgroundResource(R.drawable.button_red);
            b[18].setBackgroundResource(R.drawable.button_red);
            b[12].setBackgroundResource(R.drawable.button_red);
            b[6].setBackgroundResource(R.drawable.button_red);
            checkWhoWon();


        }

        else  if (b[4].getText() == b[8].getText() && b[4].getText() == b[12].getText() && b[4].getText() == b[16].getText() && !b[4].isEnabled()) {
            b[4].setBackgroundResource(R.drawable.button_red);
            b[8].setBackgroundResource(R.drawable.button_red);
            b[12].setBackgroundResource(R.drawable.button_red);
            b[16].setBackgroundResource(R.drawable.button_red);
            checkWhoWon();

        }

        else if (b[20].getText() == b[16].getText() && b[20].getText() == b[12].getText() && b[20].getText() == b[8].getText() && !b[20].isEnabled()) {
            b[20].setBackgroundResource(R.drawable.button_red);
            b[16].setBackgroundResource(R.drawable.button_red);
            b[12].setBackgroundResource(R.drawable.button_red);
            b[8].setBackgroundResource(R.drawable.button_red);
            checkWhoWon();


        }
//checking win from left to right
        for (int i = 0; i < 21; i += 5) {
            if (b[i].getText() ==npl && b[i + 1].getText()==npl && b[i + 2].getText()==npl &&  b[i + 3].getText()==npl) {
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+1].setBackgroundResource(R.drawable.button_red);
                b[i+2].setBackgroundResource(R.drawable.button_red);
                b[i+3].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }


        }

//checking win from right to left
        for (int i = 1; i < 22; i += 5) {

            if (b[i].getText() ==npl && b[i + 1].getText()==npl && b[i + 2].getText()==npl && b[i + 3].getText()==npl) {
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+1].setBackgroundResource(R.drawable.button_red);
                b[i+2].setBackgroundResource(R.drawable.button_red);
                b[i+3].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }

        }
        //checking win from down to up
        for (int i = 0; i < 5; i++) {
            if (b[i + 5].getText() ==npl && b[i + 10].getText()==npl && b[i + 15].getText()==npl && b[i + 20].getText()==npl) {
                b[i+5].setBackgroundResource(R.drawable.button_red);
                b[i+10].setBackgroundResource(R.drawable.button_red);
                b[i+15].setBackgroundResource(R.drawable.button_red);
                b[i+20].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;


            }

        }
        //checking win from up to down
        for (int i = 0; i < 5; i++) {
            if (b[i].getText() ==npl && b[i + 5].getText()==npl && b[i + 10].getText()==npl && b[i + 15].getText()==npl) {
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+5].setBackgroundResource(R.drawable.button_red);
                b[i+10].setBackgroundResource(R.drawable.button_red);
                b[i+15].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }
        }


        //checking win from left to right for computer
        for (int i = 0; i < 21; i += 5) {
            if (b[i].getText() ==ncl && b[i + 1].getText()==ncl && b[i + 2].getText()==ncl &&  b[i + 3].getText()==ncl) {
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+1].setBackgroundResource(R.drawable.button_red);
                b[i+2].setBackgroundResource(R.drawable.button_red);
                b[i+3].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }


        }

//checking win from right to left for computer
        for (int i = 1; i < 22; i += 5) {

            if (b[i].getText() ==ncl && b[i + 1].getText()==ncl && b[i + 2].getText()==ncl && b[i + 3].getText()==ncl) {
                checkWhoWon();
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+1].setBackgroundResource(R.drawable.button_red);
                b[i+2].setBackgroundResource(R.drawable.button_red);
                b[i+3].setBackgroundResource(R.drawable.button_red);
                break;

            }

        }
        //checking win from down to up for computer
        for (int i = 0; i < 5; i++) {
            if (b[i + 5].getText() ==ncl && b[i + 10].getText()==ncl && b[i + 15].getText()==ncl && b[i + 20].getText()==ncl) {
                b[i+5].setBackgroundResource(R.drawable.button_red);
                b[i+10].setBackgroundResource(R.drawable.button_red);
                b[i+15].setBackgroundResource(R.drawable.button_red);
                b[i+20].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;


            }

        }
        //checking win from up to down for computer
        for (int i = 0; i < 5; i++) {
            if (b[i].getText() ==ncl && b[i + 5].getText()==ncl && b[i + 10].getText()==ncl && b[i + 15].getText()==ncl) {
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+5].setBackgroundResource(R.drawable.button_red);
                b[i+10].setBackgroundResource(R.drawable.button_red);
                b[i+15].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }
        }
    }




    private void checkWhoWon() {
        if (count == 7 || count == 9 || count == 11 || count == 13 || count == 15 || count == 17 || count == 19 || count == 21 || count == 23 || count == 25) {
            final Dialog dialog = new Dialog(Board5_Vs_comp.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            String playerWins = NewPlayerName + " WINS !!!!!";
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

            Toast.makeText(Board5_Vs_comp.this, NewPlayerName + " won", Toast.LENGTH_LONG).show();
            PlayerScore++;
            TextView textView1 = findViewById(R.id.player1_score);
            textView1.setText(String.valueOf(PlayerScore));
            computer_Turn = false;
            disAbleButton();
        } else {
            final Dialog dialog = new Dialog(Board5_Vs_comp.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            textView.setText(R.string.computerWins);
            textView.setTextColor(getResources().getColor(R.color.colorAccent));
            LinearLayout linearLayout = dialog.findViewById(R.id.dialogue);
            ImageView imageView =dialog.findViewById(R.id.img_View);
            imageView.setImageResource(R.drawable.loss);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            Button button =dialog.findViewById(R.id.ok);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();

                }

            });
            dialog.show();

            Toast.makeText(Board5_Vs_comp.this, " Computer won", Toast.LENGTH_LONG).show();
            ComputerScore++;
            TextView textView1 = findViewById(R.id.player2_computer_score);
            textView1.setText(String.valueOf(ComputerScore));
            PlayersTurn = false;
            disAbleButton();
        }

    }

    private void resetBoard() {
        for (int i = 0; i < 25; i++) {
            b[i].setText("");
            b[i].setEnabled(true);
            b[i].setTextColor(Color.BLACK);
            b[i].setBackgroundResource(R.drawable.button);

        }
        count = 0;
        computer_Turn = true;
        PlayersTurn = true;

    }


    private void disAbleButton() {
        for (int i = 0; i < 25; i++) {
            if (b[i].isEnabled()) {
                b[i].setEnabled(false);

            }

        }

    }
    private void main_menu(){
        Button button =findViewById(R.id.main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Board5_Vs_comp.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
