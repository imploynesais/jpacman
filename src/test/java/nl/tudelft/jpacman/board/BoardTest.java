package nl.tudelft.jpacman.board;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests the creation and behavior of a Board.
 */
class BoardTest {

    /**
     * Tests that squareAt returns a valid BasicSquare
     * when the board contains a non-null square.
     */
    @Test
    void testSquareAtOnValidBoard() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        Board board = new Board(grid);

        Square square = board.squareAt(0, 0);
        assertNotNull(square, "Square should not be null");
        assertTrue(square instanceof BasicSquare, "Square should be a BasicSquare");
    }

    /**
     * Tests that a board can be created even if a square is null.
     */
    @Test
    void testSquareAtWithNullSquare() {
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        Board board = new Board(grid);
        assertNotNull(board, "Board should be created even if a square is null");
    }
}


