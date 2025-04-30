import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell [][] cells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders){
        initializeCells(boardSize);
        addSnakesAndLadders(numberOfSnakes,numberOfLadders);
    }


    /**
     * Initialize the every cell of the board with new cell object
     * @param boardSize
     */
    public void initializeCells(int boardSize){
        cells = new Cell[boardSize][boardSize];

        for(int i=0; i<boardSize; i++){
            for(int j=0; j<boardSize; j++){
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }


    /**
     * Add randomly snakes and ladders in the board
     * @param numberOfSnakes
     * @param numberOfLadders
     */
    public void addSnakesAndLadders(int numberOfSnakes, int numberOfLadders) {

        //Adding snakes
        while(numberOfSnakes > 0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,snakeHead);

            if(snakeTail>=snakeHead){
                continue;
            }
            Jump snake = new Jump(snakeHead,snakeTail);

            //calculating row and column position
            Cell cell = cells[snakeHead/cells.length][snakeHead%cells.length];
            cell.setJumpObj(snake);
            numberOfSnakes--;
        }

        //Adding Ladders
        while(numberOfLadders > 0){
            int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(ladderStart,cells.length*cells.length-1);

            if(ladderStart>=ladderEnd){
                continue;
            }
            Jump ladder = new Jump(ladderStart,ladderEnd);

            //calculating row and column position
            Cell cell = cells[ladderStart/cells.length][ladderStart%cells.length];
            cell.setJumpObj(ladder);
            numberOfLadders--;
        }
    }

}
