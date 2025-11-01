package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

/**
 * Tests the creation of a valid Board.
 */
class BoardTest {

    @Test
    void testSquareAtOnValidBoard() {
        // Create a 1x1 board with a BasicSquare
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();
        Board board = new Board(grid);

        // Test squareAt method
        Square square = board.squareAt(0, 0);
        assertNotNull(square, "Square should not be null");
        assertTrue(square instanceof BasicSquare, "Square should be a BasicSquare");
    }

    @Test
    void testSquareAtWithNullSquare() {
        // Create a 1x1 board with a null square
        Square[][] grid = new Square[1][1];
        grid[0][0] = null;

        Board board = new Board(grid);

    }
}
