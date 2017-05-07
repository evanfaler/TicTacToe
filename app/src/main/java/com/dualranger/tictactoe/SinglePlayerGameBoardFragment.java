package com.dualranger.tictactoe;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class SinglePlayerGameBoardFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private static SpaceView space1;
    private static SpaceView space2;
    private static SpaceView space3;
    private static SpaceView space4;
    private static SpaceView space5;
    private static SpaceView space6;
    private static SpaceView space7;
    private static SpaceView space8;
    private static SpaceView space9;
    private List<SpaceView> gameSpaces;
    private int winner;
    private int xScore = 0;
    private int oScore = 0;
    private int[][] mGameBoard;
    private boolean compTurn;
    private int currentScore;
    private int difficulty = 3; //1 - easy, 3 - medium, 5 - impossible

    private int alternateShape = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_board, container, false);

        space1 = (SpaceView) v.findViewById(R.id.space_1);
        space1.setOnClickListener(this);

        space2 = (SpaceView) v.findViewById(R.id.space_2);
        space2.setOnClickListener(this);

        space3 = (SpaceView) v.findViewById(R.id.space_3);
        space3.setOnClickListener(this);

        space4 = (SpaceView) v.findViewById(R.id.space_4);
        space4.setOnClickListener(this);

        space5 = (SpaceView) v.findViewById(R.id.space_5);
        space5.setOnClickListener(this);

        space6 = (SpaceView) v.findViewById(R.id.space_6);
        space6.setOnClickListener(this);

        space7 = (SpaceView) v.findViewById(R.id.space_7);
        space7.setOnClickListener(this);

        space8 = (SpaceView) v.findViewById(R.id.space_8);
        space8.setOnClickListener(this);

        space9 = (SpaceView) v.findViewById(R.id.space_9);
        space9.setOnClickListener(this);

        gameSpaces = Arrays.asList(space1, space2, space3, space4, space5, space6, space7, space8, space9);

        //1: Player positions
        //0: Computer positions
        //2: Empty positions
        mGameBoard = new int[][]{
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };

        compTurn = false;

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.space_1:
                if (space1.isPlayable()) {
                    space1.setPlayer(1);
                    space1.setPlayable(false);
                    mGameBoard[0][0] = 1;
                    space1.invalidate();
                    compTurn = true;
                    isWin();
                } else {
                    Toast.makeText(v.getContext(), "Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_2:
                if (space2.isPlayable()) {
                    space2.setPlayer(1);
                    space2.setPlayable(false);
                    mGameBoard[0][1] = 1;
                    space2.invalidate();
                    compTurn = true;
                    isWin();
                } else {
                    Toast.makeText(v.getContext(), "Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_3:
                if (space3.isPlayable()) {
                    space3.setPlayer(1);
                    space3.setPlayable(false);
                    mGameBoard[0][2] = 1;
                    space3.invalidate();
                    compTurn = true;
                    isWin();
                } else {
                    Toast.makeText(v.getContext(), "Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_4:
                if (space4.isPlayable()) {
                    space4.setPlayer(1);
                    space4.setPlayable(false);
                    mGameBoard[1][0] = 1;
                    space4.invalidate();
                    compTurn = true;
                    isWin();
                    System.gc();
                } else {
                    Toast.makeText(v.getContext(), "Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_5:
                if (space5.isPlayable()) {
                    space5.setPlayer(1);
                    space5.setPlayable(false);
                    mGameBoard[1][1] = 1;
                    space5.invalidate();
                    compTurn = true;
                    isWin();
                } else {
                    Toast.makeText(v.getContext(), "Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_6:
                if (space6.isPlayable()) {
                    space6.setPlayer(1);
                    space6.setPlayable(false);
                    mGameBoard[1][2] = 1;
                    space6.invalidate();
                    compTurn = true;
                    isWin();
                } else {
                    Toast.makeText(v.getContext(), "Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_7:
                if (space7.isPlayable()) {
                    space7.setPlayer(1);
                    space7.setPlayable(false);
                    mGameBoard[2][0] = 1;
                    space7.invalidate();
                    compTurn = true;
                    isWin();
                } else {
                    Toast.makeText(v.getContext(), "Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_8:
                if (space8.isPlayable()) {
                    space8.setPlayer(1);
                    space8.setPlayable(false);
                    mGameBoard[2][1] = 1;
                    space8.invalidate();
                    compTurn = true;
                    isWin();
                } else {
                    Toast.makeText(v.getContext(), "Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.space_9:
                if (space9.isPlayable()) {
                    space9.setPlayer(1);
                    space9.setPlayable(false);
                    mGameBoard[2][2] = 1;
                    space9.invalidate();
                    compTurn = true;
                    isWin();
                } else {
                    Toast.makeText(v.getContext(), "Invalid Location", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void computerPlay() {

        //TODO add computer logic here. implement selection in handler.
        //Difficulty is based on depth that algorithm is allowed to look.
        //1: Easy. Computer is only allowed to look at next move.
        //2: Medium. Computer is only allowed to look at the next two moves.
        //3: Hard. Computer is only allowed to look at the next three moves.


        //Add code for computer to choose best option here.
        int[] bestMove = pickBestMove(mGameBoard);
        mGameBoard[bestMove[0]][bestMove[1]] = 0;   //change space in mGameBoard array.
//        Log.d("Information Logs", "Computer Selects Row: " + Integer.toString(bestMove[0]) + " Col: " + Integer.toString(bestMove[1]));

        final SpaceView compPickSpace = getMoveSpaceView(bestMove);

        //Play selection after .5 seconds to simulate computer thinking.
        final android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                compPickSpace.setPlayer(0);
                compPickSpace.setPlayable(false);
                compPickSpace.invalidate();
                compTurn = false;
                isWin();
                enableSpaces();
            }
        }, 500);
    }

    private int[] pickBestMove(int[][] board) {
        int bestValue = -100;
        int[] bestMove = {-1, -1};

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 2) {
                    board[row][col] = 0;
                    int moveValue = minimax(board, 0, false, difficulty);
                    board[row][col] = 2;

                    //Logging information to the console.
                    Log.d("Debug Log", "Position: " + Integer.toString(row) + "," + Integer.toString(col) + " Value: " + Integer.toString(moveValue));

                    if (moveValue > bestValue) {
                        bestMove[0] = row;
                        bestMove[1] = col;
                        bestValue = moveValue;
                    }
                }
            }
        }
        Log.d("Information Logs", "Best Row: " + Integer.toString(bestMove[0]) + " Col: " + Integer.toString(bestMove[1]));
        return bestMove;
    }

    private int minimax(int[][] board, int depth, boolean isMaxPlayer, int difficulty) {

        int score = evaluate(board);

        if (depth == difficulty) {
            return score - depth;
        } else if (score == 10) {
            return score - depth;
        } else if (score == -10) {
            return score - depth;
        } else if (!isMovesLeft(board)) {
            return 0;
        }

        if (isMaxPlayer) {     //if next move is the computers turn
            int bestValue = -100;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board[row][col] == 2) {
                        board[row][col] = 0;
                        bestValue = Math.max(bestValue, minimax(board, depth + 1, false, difficulty));


                        board[row][col] = 2;
                    }

                }

            }
            return bestValue;
        } else {      //if the next move is the players turn
            int bestValue = 100;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board[row][col] == 2) {
                        board[row][col] = 1;
                        bestValue = Math.min(bestValue, minimax(board, depth + 1, true, difficulty));
                        board[row][col] = 2;
                    }

                }

            }
            return bestValue;
        }
    }

    //Function evaluates the state of the passed in game board
    //Returns 10 if computer wins
    //Returns -10 if player wins
    private int evaluate(int[][] board) {
        //Check rows for x or o victory
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] &&
                    board[row][1] == board[row][2]) {
                if (board[row][0] == 0)
                    return 10;
                else if (board[row][0] == 1)
                    return -10;
            }
        }

        //Check cols for x or o victory
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] &&
                    board[1][col] == board[2][col]) {
                if (board[0][col] == 0)
                    return +10;

                else if (board[0][col] == 1)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 0)
                return +10;
            else if (board[0][0] == 1)
                return -10;
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 0)
                return +10;
            else if (board[0][2] == 1)
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }

    //Function checks to see if there are any moves left
    //Returns true if there are moves left
    //Returns false if the board is full.
    boolean isMovesLeft(int[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == 2)
                    return true;
        return false;
    }

    private SpaceView getMoveSpaceView(int[] move) {
        if (move[0] == 0) {
            if (move[1] == 0) {
                return gameSpaces.get(0);
            } else if (move[1] == 1) {
                return gameSpaces.get(1);
            } else if (move[1] == 2) {
                return gameSpaces.get(2);
            }
        } else if (move[0] == 1) {
            if (move[1] == 0) {
                return gameSpaces.get(3);
            } else if (move[1] == 1) {
                return gameSpaces.get(4);
            } else if (move[1] == 2) {
                return gameSpaces.get(5);
            }
        } else if (move[0] == 2) {
            if (move[1] == 0) {
                return gameSpaces.get(6);
            } else if (move[1] == 1) {
                return gameSpaces.get(7);
            } else if (move[1] == 2) {
                return gameSpaces.get(8);
            }
        }

        Log.d("Error Logs", "Computer Selected move out of Space View Bounds");
        return gameSpaces.get(0);

    }

    private void isWin() {

        if (mGameBoard[0][0] == mGameBoard[0][1] && mGameBoard[0][1] == mGameBoard[0][2] && mGameBoard[0][0] != 2) {          //Check Row 1
            winner = mGameBoard[0][0];
        } else if (mGameBoard[1][0] == mGameBoard[1][1] && mGameBoard[1][1] == mGameBoard[1][2] && mGameBoard[1][0] != 2) {    //Check Row 2
            winner = mGameBoard[1][0];
        } else if (mGameBoard[2][0] == mGameBoard[2][1] && mGameBoard[2][1] == mGameBoard[2][2] && mGameBoard[2][0] != 2) {    //Check Row 3
            winner = mGameBoard[1][0];
        } else if (mGameBoard[0][0] == mGameBoard[1][0] && mGameBoard[1][0] == mGameBoard[2][0] && mGameBoard[0][0] != 2) {    //Check Col 1
            winner = mGameBoard[0][0];
        } else if (mGameBoard[0][1] == mGameBoard[1][1] && mGameBoard[1][1] == mGameBoard[2][1] && mGameBoard[0][1] != 2) {    //Check Col 2
            winner = mGameBoard[0][1];
        } else if (mGameBoard[0][2] == mGameBoard[1][2] && mGameBoard[1][2] == mGameBoard[2][2] && mGameBoard[0][2] != 2) {    //Check Col 3
            winner = mGameBoard[0][2];
        } else if (mGameBoard[0][0] == mGameBoard[1][1] && mGameBoard[1][1] == mGameBoard[2][2] && mGameBoard[0][0] != 2) {    //Check Diag \
            winner = mGameBoard[0][0];
        } else if (mGameBoard[2][0] == mGameBoard[1][1] && mGameBoard[1][1] == mGameBoard[0][2] && mGameBoard[2][0] != 2) {    //Check Diag /
            winner = mGameBoard[2][0];
        } else {
            winner = 2;
        }

        if (winner == 1) {
            xScore++;
            ((SinglePlayerActivity) getActivity()).updateScoreboard(xScore, oScore);
            disableSpaces(); //disable all clicks until reset button is pressed.
            //Change player via changing color of X or O
            alternateShape = 2;
        } else if (winner == 0) {
            oScore++;
            ((SinglePlayerActivity) getActivity()).updateScoreboard(xScore, oScore);
            disableSpaces(); //disable all clicks until reset button is pressed.
            alternateShape = 1;
            //Change player via changing color of X or O
        } else {
            if (isMovesLeft(mGameBoard) && compTurn) {
                disableSpaces();
                computerPlay();
            } else {
                ((SinglePlayerActivity) getActivity()).updateScoreboard(xScore, oScore);
                disableSpaces(); //disable all clicks until reset button is pressed.
            }
        }

    }

    public void resetGame() {
        for (SpaceView space : gameSpaces) {
            space.setPlayer(2);
            space.setPlayable(true);
            space.setBackgroundColor(0x000000);
            space.invalidate();
        }
        resetGameArray();
    }

    private void resetGameArray() {
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                mGameBoard[col][row] = 2;
            }
        }
    }

    public void enableSpaces() {
        space1.setEnabled(true);
        space2.setEnabled(true);
        space3.setEnabled(true);
        space4.setEnabled(true);
        space5.setEnabled(true);
        space6.setEnabled(true);
        space7.setEnabled(true);
        space8.setEnabled(true);
        space9.setEnabled(true);
    }

    private void disableSpaces() {
        space1.setEnabled(false);
        space2.setEnabled(false);
        space3.setEnabled(false);
        space4.setEnabled(false);
        space5.setEnabled(false);
        space6.setEnabled(false);
        space7.setEnabled(false);
        space8.setEnabled(false);
        space9.setEnabled(false);
    }


}
