package game.board;

class InputValidator {

    private int boardSize;

    public InputValidator(int boardSize) {
        this.boardSize = boardSize;
    }

    boolean isInBoardRange(int row, int column) {
        return row <= boardSize && row >= 1 && column <= boardSize && column >= 1;
    }
}
