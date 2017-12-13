package com.example.adamchilds.tictactoefinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0; // 0 is for Player "O", 1 is for player "x"
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningLocations = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    boolean gameOver = false;
    int counter = 0;

    public void gameLogic(View view) {

        ImageView tappedView = (ImageView) view;

        int tappedLocation = Integer.parseInt(view.getTag().toString());
        if (gameState[tappedLocation] == 2 && !gameOver) {
            gameState[tappedLocation] = activePlayer;
            if (activePlayer == 0) {
                tappedView.setImageResource(R.drawable.o);
                activePlayer = 1;
                counter +=1;
            } else {
                tappedView.setImageResource(R.drawable.x);
                activePlayer = 0;
                counter+=1;
            }
        }

        String msg = "";

        for (int[] winningPosition : winningLocations){
            if (gameState[winningPosition[0]] == gameState [winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]]
                    && gameState[winningPosition[0]] != 2){
                if(activePlayer == 0)
                {
                    msg = "X is the winner!";
                }
                if(activePlayer == 1)
                {
                    msg = "O is the winner!";
                }

                LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
                winnerLayout.setVisibility(View.VISIBLE);
                TextView winnerMsg = (TextView) findViewById(R.id.textView);
                winnerMsg.setText(msg);
                gameOver = true;
            }
            if (counter == 9){
                LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
                winnerLayout.setVisibility(View.VISIBLE);
                TextView winnerMsg = (TextView) findViewById(R.id.textView);
                msg = "No winner!";
                winnerMsg.setText(msg);
            }
        }
    }

    public void playAgain(View view){

        LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);

        gameOver = false;
        activePlayer = 0;
        counter = 0;
        for ( int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i =0; i < gridLayout.getChildCount(); i++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout winnerLayout = (LinearLayout) findViewById(R.id.winnerLayout);
        winnerLayout.setVisibility(View.INVISIBLE);
    }
}
