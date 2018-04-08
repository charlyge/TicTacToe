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

public class Board5_vs_human extends AppCompatActivity implements View.OnClickListener {
    private int count;
    private int player1_Score;
    private int player2Score;
    private Button[] b;
private boolean players = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board5);


main_menu();
    TextView textView = findViewById(R.id.player1tv);
        textView.setText(playerO);

    TextView textView1 = findViewById(R.id.player2tv);
        textView1.setText(playerX);
        Toast.makeText(Board5_vs_human.this,playerO + " starts first ", Toast.LENGTH_LONG).show();
    b= new Button[25];
        for(int i =0;i<25;i++){

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
        if(count==1||count==3||count==5||count==7||count==9 || count==11 || count==13
                ||count==15||count==17||count==19 || count==21 || count==23 || count==25){
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
           // checkDraw();
        }
    }

    private void checkWinner(){

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
            b[13].setBackgroundResource(R.drawable.button_red);
            b[9].setBackgroundResource(R.drawable.button_red);
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
            if (b[i].getText() =="X" && b[i + 1].getText()=="X" && b[i + 2].getText()=="X" &&  b[i + 3].getText()=="X") {
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

            if (b[i].getText() =="X" && b[i + 1].getText()=="X" && b[i + 2].getText()=="X" && b[i + 3].getText()=="X") {
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
            if (b[i + 5].getText() =="X" && b[i + 10].getText()=="X" && b[i + 15].getText()=="X" && b[i + 20].getText()=="X") {
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
            if (b[i].getText() =="X" && b[i + 5].getText()=="X" && b[i + 10].getText()=="X" && b[i + 15].getText()=="X") {
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+5].setBackgroundResource(R.drawable.button_red);
                b[i+10].setBackgroundResource(R.drawable.button_red);
                b[i+15].setBackgroundResource(R.drawable.button_red);

                checkWhoWon();
                break;

            }
        }

        //checking win from left to right for O
        for (int i = 0; i < 21; i += 5) {
            if (b[i].getText() =="O" && b[i + 1].getText()=="O" && b[i + 2].getText()=="O" &&  b[i + 3].getText()=="O") {
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+1].setBackgroundResource(R.drawable.button_red);
                b[i+2].setBackgroundResource(R.drawable.button_red);
                b[i+3].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }


        }

//checking win from right to left for O
        for (int i = 1; i < 22; i += 5) {

            if (b[i].getText() =="O" && b[i + 1].getText()=="O" && b[i + 2].getText()=="O" && b[i + 3].getText()=="O") {
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+1].setBackgroundResource(R.drawable.button_red);
                b[i+2].setBackgroundResource(R.drawable.button_red);
                b[i+3].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }

        }
        //checking win from down to up for O
        for (int i = 0; i < 5; i++) {
            if (b[i + 5].getText() =="O" && b[i + 10].getText()=="O" && b[i + 15].getText()=="O" && b[i + 20].getText()=="O") {
                b[i+5].setBackgroundResource(R.drawable.button_red);
                b[i+10].setBackgroundResource(R.drawable.button_red);
                b[i+15].setBackgroundResource(R.drawable.button_red);
                b[i+20].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;


            }

        }
        //checking win from up to down for O
        for (int i = 0; i < 5; i++) {
            if (b[i].getText() =="O" && b[i + 5].getText()=="O" && b[i + 10].getText()=="O" && b[i + 15].getText()=="O") {
                b[i].setBackgroundResource(R.drawable.button_red);
                b[i+5].setBackgroundResource(R.drawable.button_red);
                b[i+10].setBackgroundResource(R.drawable.button_red);
                b[i+15].setBackgroundResource(R.drawable.button_red);
                checkWhoWon();
                break;

            }
        }


    }
    private void checkWhoWon(){
        if(count==1||count==3||count==5||count==7||count==9 || count==11 || count==13
                ||count==15||count==17||count==19 || count==21 || count==23 || count==25) {

            final Dialog dialog = new Dialog(Board5_vs_human.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            textView.setText(playerO + " WINS !!!!!");
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

            Toast.makeText(Board5_vs_human.this, playerO + " wins ", Toast.LENGTH_LONG).show();

            player1_Score++;
            TextView player1_Score_textView = findViewById(R.id.player1_score);

            player1_Score_textView.setText(String.valueOf(player1_Score));
            disAbleButton();
            players=false;
        } else {
            final Dialog dialog = new Dialog(Board5_vs_human.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            textView.setText(playerX + " WINS !!!!!");
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


            Toast.makeText(Board5_vs_human.this, playerX, Toast.LENGTH_LONG).show();


            player2Score++;
            TextView player2_computer_Score_textView = findViewById(R.id.player2_computer_score);
            player2_computer_Score_textView.setText(String.valueOf(player2Score));

            disAbleButton();
            players =false;
        }

    }
    private void disAbleButton(){
        for (int i=0;i<25;i++){
            b[i].setEnabled(false);

        }

    }

    private void checkDraw(){
        if(count==25 && players){
            final Dialog dialog = new Dialog(Board5_vs_human.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.win_loss_view);
            TextView textView = dialog.findViewById(R.id.win_loose_View);
            textView.setText(" Its a Draw !!!!!");
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
            Toast.makeText(Board5_vs_human.this, "its a Draw", Toast.LENGTH_LONG).show();
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
   players =true;

    }
    private void main_menu(){
        Button button =findViewById(R.id.main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Board5_vs_human.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
