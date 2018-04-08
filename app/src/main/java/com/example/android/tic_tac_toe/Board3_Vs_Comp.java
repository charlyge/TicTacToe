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

import static com.example.android.tic_tac_toe.R.color.TextColor;
import static com.example.android.tic_tac_toe.VsComputerActivity.sComputerLetter;
import static com.example.android.tic_tac_toe.VsComputerActivity.sPlayerLetter;
import static com.example.android.tic_tac_toe.VsComputerActivity.sPlayerName;


public class Board3_Vs_Comp extends AppCompatActivity implements View.OnClickListener {
    private int count = 0;
    private Button[] b;
    private boolean computer_Turn = true;
    private boolean PlayersTurn = true;
    private int player1_Score = 0;
    private int player2_computer_Score = 0;
    private int r;
    private final String nPl = sPlayerLetter;
    private final String NewComputerLetter = sComputerLetter;
    private final String NewPlayerName = sPlayerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board3);
main_menu();
        TextView textView = findViewById(R.id.player1tv);
        textView.setText(NewPlayerName);
        b = new Button[9];
        for (int i = 0; i < 9; i++) {
            String ButtonId = "bt" + i;
            int resId = getResources().getIdentifier(ButtonId, "id", getPackageName());
            b[i] = findViewById(resId);
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
        //Generates random number each time user clicks on b
        Random random = new Random();
        r = random.nextInt(8);
        if (view.isEnabled()) {
            ((Button) view).setText(nPl);
            ((Button) view).setTextColor(getResources().getColor(TextColor));

            view.setEnabled(false);
            // count increases each time user clicks
            count++;

            // check if a win exist

            checkWinner();

            // Method checks if move is still available on board before proceeding to computers turn
            // returns draw if all buttons are disable and both computer and users turn is still true
            if (count == 9 && computer_Turn && PlayersTurn) {
                final Dialog dialog = new Dialog(Board3_Vs_Comp.this);
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
                Toast.makeText(Board3_Vs_Comp.this, " its a draw ", Toast.LENGTH_LONG).show();

            }
        }

        if (computer_Turn) {

            computer_Move();

            checkWinner();
        }
    }




    // this method controls computers play and moves
    private void computer_Move() {

        if (b[6].getText() == NewComputerLetter && b[4].getText() == NewComputerLetter && b[2].isEnabled()) {
            b[2].setText(NewComputerLetter);
            b[2].setEnabled(false);

        } else if (b[0].getText() == NewComputerLetter && b[1].getText() == NewComputerLetter && b[2].isEnabled()) {
            b[2].setText(NewComputerLetter);
            b[2].setEnabled(false);

        } else if (b[1].getText() == NewComputerLetter && b[4].getText() == NewComputerLetter && b[7].isEnabled()) {
            b[7].setText(NewComputerLetter);
            b[7].setEnabled(false);

        }
        else if (b[1].getText() == NewComputerLetter && b[7].getText() == NewComputerLetter && b[4].isEnabled()) {
            b[4].setText(NewComputerLetter);
            b[4].setEnabled(false);

        }
        else if (b[0].getText() == NewComputerLetter && b[3].getText() == NewComputerLetter && b[6].isEnabled()) {
            b[6].setText(NewComputerLetter);
            b[6].setEnabled(false);

        } else if (b[2].getText() == NewComputerLetter && b[5].getText() == NewComputerLetter && b[8].isEnabled()) {
            b[8].setText(NewComputerLetter);
            b[8].setEnabled(false);

        } else if (b[3].getText() == NewComputerLetter && b[4].getText() == NewComputerLetter && b[5].isEnabled()) {
            b[5].setText(NewComputerLetter);
            b[5].setEnabled(false);

        } else if (b[8].getText() == NewComputerLetter && b[7].getText() == NewComputerLetter && b[6].isEnabled()) {
            b[6].setText(NewComputerLetter);
            b[6].setEnabled(false);

        } else if (b[2].getText() == NewComputerLetter && b[4].getText() == NewComputerLetter && b[6].isEnabled()) {
            b[6].setText(NewComputerLetter);
            b[6].setEnabled(false);

        } else if (b[5].getText() == NewComputerLetter && b[8].getText() == NewComputerLetter && b[2].isEnabled()) {
            b[2].setText(NewComputerLetter);
            b[2].setEnabled(false);

        } else if (b[2].getText() == NewComputerLetter && b[8].getText() == NewComputerLetter && b[5].isEnabled()) {
            b[5].setText(NewComputerLetter);
            b[5].setEnabled(false);

        }
        else if (b[7].getText() == NewComputerLetter && b[4].getText() == NewComputerLetter && b[1].isEnabled()) {
            b[1].setText(NewComputerLetter);
            b[1].setEnabled(false);

        }

        else if (About_2_Win() == 1) {

            b[0].setText(NewComputerLetter);
            b[0].setEnabled(false);
        } else if (About_2_Win() == 2) {

            b[2].setText(NewComputerLetter);
            b[2].setEnabled(false);

        } else if (About_2_Win() == 3) {

            b[1].setText(NewComputerLetter);
            b[1].setEnabled(false);

        } else if (About_2_Win() == 4) {

            b[5].setText(NewComputerLetter);
            b[5].setEnabled(false);

        } else if (About_2_Win() == 5) {

            b[4].setText(NewComputerLetter);
            b[4].setEnabled(false);

        } else if (About_2_Win() == 6) {

            b[3].setText(NewComputerLetter);
            b[3].setEnabled(false);

        } else if (About_2_Win() == 7) {

            b[7].setText(NewComputerLetter);
            b[7].setEnabled(false);

        } else if (About_2_Win() == 8) {

            b[4].setText(NewComputerLetter);
            b[4].setEnabled(false);

        } else if (About_2_Win() == 10) {

            b[8].setText(NewComputerLetter);
            b[8].setEnabled(false);

        } else if (About_2_Win() == 9) {

            b[1].setText(NewComputerLetter);
            b[1].setEnabled(false);

        } else if (About_2_Win() == 11) {

            b[4].setText(NewComputerLetter);
            b[4].setEnabled(false);

        } else if (About_2_Win() == 12) {

            b[0].setText(NewComputerLetter);
            b[0].setEnabled(false);

        } else if (About_2_Win() == 13) {

            b[6].setText(NewComputerLetter);
            b[6].setEnabled(false);

        } else if (About_2_Win() == 14) {

            b[2].setText(NewComputerLetter);
            b[2].setEnabled(false);

        } else if (About_2_Win() == 15) {

            b[4].setText(NewComputerLetter);
            b[4].setEnabled(false);

        } else if (About_2_Win() == 16) {

            b[8].setText(NewComputerLetter);
            b[8].setEnabled(false);

        } else if (About_2_Win() == 17) {

            b[5].setText(NewComputerLetter);
            b[5].setEnabled(false);

        } else if (About_2_Win() == 18) {

            b[2].setText(NewComputerLetter);
            b[2].setEnabled(false);

        } else if (About_2_Win() == 19) {

            b[6].setText(NewComputerLetter);
            b[6].setEnabled(false);

        } else if (About_2_Win() == 20) {

            b[3].setText(NewComputerLetter);
            b[3].setEnabled(false);

        } else if (About_2_Win() == 21) {

            b[0].setText(NewComputerLetter);
            b[0].setEnabled(false);

        } else if (About_2_Win() == 22) {

            b[8].setText(NewComputerLetter);
            b[8].setEnabled(false);

        } else if (About_2_Win() == 23) {

            b[7].setText(NewComputerLetter);
            b[7].setEnabled(false);

        } else if (About_2_Win() == 24) {

            b[6].setText(NewComputerLetter);
            b[6].setEnabled(false);

        } else if (b[r].isEnabled()) {
            b[r].setText(sComputerLetter);
            b[r].setEnabled(false);
        }
        else if (b[0].getText() == b[6].getText() && b[3].isEnabled()) {
            b[3].setText(NewComputerLetter);
            b[3].setEnabled(false);

        }
        else if (b[2].getText() == b[8].getText() && b[5].isEnabled()) {
            b[5].setText(NewComputerLetter);
            b[5].setEnabled(false);

        }
        else {
            for (int i = 0; i < 9; i++) {
                if (b[i].isEnabled()) {
                    b[i].setText(NewComputerLetter);
                    b[i].setEnabled(false);
                    break;
                }

            }

        }
        count++;
    }


    // Method check winner
    private void checkWinner() {
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

        //Checking for Horizontal wins
        for (int i = 0; i <= 6; i += 3) {
            if (b[i].getText() == b[i + 1].getText() && b[i].getText() == b[i + 2].getText() && !b[i].isEnabled()) {

                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+1].setBackgroundResource(R.drawable.button_red);
                b[i+2].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }
        }
        // checking for vertical wins
        for (int j = 0; j <= 2; j++) {
            if (b[j].getText() == b[j + 3].getText() && b[j].getText() == b[j + 6].getText() && !b[j].isEnabled()) {
                b[j].setBackgroundResource(R.drawable.button_red);
                b[j+3].setBackgroundResource(R.drawable.button_red);
                b[j+6].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;
            }

        }


    }

    /* method checks if a user is about to win and returns a number
     * to use to block the users move in @computer_move method
    */
    private int About_2_Win() {
        int position = 0;

        if (b[1].getText() == nPl && b[2].getText() == nPl && b[0].isEnabled()) {

            position = 1;
        } else if (b[0].getText() == nPl && b[1].getText() == nPl && b[2].isEnabled()) {
            return 2;
        } else if (b[0].getText() == nPl && b[2].getText() == nPl && b[1].isEnabled()) {
            return 3;
        } else if (b[3].getText() == nPl && b[4].getText() == nPl && b[5].isEnabled()) {
            return 4;
        } else if (b[3].getText() == nPl && b[5].getText() == nPl && b[4].isEnabled()) {
            return 5;
        } else if (b[4].getText() == nPl && b[5].getText() == nPl && b[3].isEnabled()) {
            return 6;
        } else if (b[1].getText() == nPl && b[4].getText() == nPl && b[7].isEnabled()) {
            return 7;
        } else if (b[1].getText() == nPl && b[7].getText() == nPl && b[4].isEnabled()) {
            return 8;
        } else if (b[7].getText() == nPl && b[4].getText() == nPl && b[1].isEnabled()) {
            return 9;
        } else if (b[0].getText() == nPl && b[4].getText() == nPl && b[8].isEnabled()) {
            return 10;
        } else if (b[8].getText() == nPl && b[0].getText() == nPl && b[4].isEnabled()) {
            return 11;
        } else if (b[8].getText() == nPl && b[4].getText() == nPl && b[0].isEnabled()) {
            return 12;
        } else if (b[2].getText() == nPl && b[4].getText() == nPl && b[6].isEnabled()) {
            return 13;
        } else if (b[6].getText() == nPl && b[4].getText() == nPl && b[2].isEnabled()) {
            return 14;
        } else if (b[6].getText() == nPl && b[2].getText() == nPl && b[4].isEnabled()) {
            return 15;
        } else if (b[2].getText() == nPl && b[5].getText() == nPl && b[8].isEnabled()) {
            return 16;
        } else if (b[2].getText() == nPl && b[8].getText() == nPl && b[5].isEnabled()) {
            return 17;
        } else if (b[5].getText() == nPl && b[8].getText() == nPl && b[2].isEnabled()) {
            return 18;
        } else if (b[0].getText() == nPl && b[3].getText() == nPl && b[6].isEnabled()) {
            return 19;
        } else if (b[0].getText() == nPl && b[6].getText() == nPl && b[3].isEnabled()) {
            return 20;
        } else if (b[6].getText() == nPl && b[3].getText() == nPl && b[0].isEnabled()) {
            return 21;
        } else if (b[6].getText() == nPl && b[7].getText() == nPl && b[8].isEnabled()) {
            return 22;
        } else if (b[6].getText() == nPl && b[8].getText() == nPl && b[7].isEnabled()) {
            return 23;
        } else if (b[7].getText() == nPl && b[8].getText() == nPl && b[6].isEnabled()) {
            return 24;
        }
        return position;

    }

    private void disAbleButton() {
        for (int i = 0; i < 9; i++) {
            if (b[i].isEnabled()) {
                b[i].setEnabled(false);

            }

        }

    }

    /*
     * method checks if its computer or player that won and sets losers turn to false
     * and disable all buttons to prevent further move
     */

    private void checkWhoWon() {

        if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9) {
            final Dialog dialog = new Dialog(Board3_Vs_Comp.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            String player=NewPlayerName + " WINS !!!!!";
            textView.setText(player);
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

            Toast.makeText(Board3_Vs_Comp.this, NewPlayerName + " wins ", Toast.LENGTH_LONG).show();
            player1_Score++;
            TextView player1_Score_textView = findViewById(R.id.player1_score);

            player1_Score_textView.setText(String.valueOf(player1_Score));
            disAbleButton();
            computer_Turn = false;
        } else {
            final Dialog dialog = new Dialog(Board3_Vs_Comp.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            textView.setText(  R.string.ComputerWon);
            ImageView imageView =dialog.findViewById(R.id.img_View);
            imageView.setImageResource(R.drawable.loss);
            LinearLayout linearLayout = dialog.findViewById(R.id.dialogue);
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            textView.setTextColor(getResources().getColor(R.color.white));
            Button button =dialog.findViewById(R.id.ok);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }

            });
            dialog.show();

            Toast.makeText(Board3_Vs_Comp.this, " Computer wins ", Toast.LENGTH_LONG).show();

            player2_computer_Score++;
            TextView player2_computer_Score_textView = findViewById(R.id.player2_computer_score);
            player2_computer_Score_textView.setText(String.valueOf(player2_computer_Score));

            disAbleButton();
            PlayersTurn = false;
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
        computer_Turn = true;
        PlayersTurn = true;
    }

    private void main_menu(){
        Button button =findViewById(R.id.main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Board3_Vs_Comp.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
