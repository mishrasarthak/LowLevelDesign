import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;

    Game(){
        initializeGame();
    }

    public void initializeGame(){
        board = new Board(10,2,4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    public void addPlayers() {
        Player player1 = new Player("P1");
        Player player2 = new Player("P2");
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while(winner == null){
            //Get the current player turn
            Player currentPlayer = findPlayerTurn();
            System.out.println("Player "+currentPlayer.playerId+" turn");

            //roll the dice
            int diceNumber = dice.rollDice();

            //get the new position of current player
            int newPosition = currentPlayer.currentPosition + diceNumber;


        }
    }

    private Player findPlayerTurn(){
        Player currentPlayer = players.removeFirst();
        players.addLast(currentPlayer);
        return currentPlayer;
    }

    private int jumpCheck(int newPosition){

    }
}
