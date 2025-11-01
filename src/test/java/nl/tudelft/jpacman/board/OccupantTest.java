package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Remove the following placeholder:
        // assertThat(unit).isNotNull();
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // Remove the following placeholder:
        // assertThat(unit).isNotNull();
        Square target = new BasicSquare();

        unit.occupy(target);

        // Unit must reference target square
        assertThat(unit.hasSquare()).isTrue();
        assertThat(unit.getSquare()).isEqualTo(target);

        // Square must list this unit as occupant
        assertThat(target.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // Remove the following placeholder:
        // assertThat(unit).isNotNull();
        Square first = new BasicSquare();
        Square second = new BasicSquare();

        unit.occupy(first);
        unit.occupy(second);

        // Unit must now reference the second square
        assertThat(unit.getSquare()).isEqualTo(second);
        assertThat(unit.getSquare()).isNotEqualTo(first);

        // second square has unit
        assertThat(second.getOccupants()).contains(unit);

        // first square no longer has unit
        assertThat(first.getOccupants()).doesNotContain(unit);
    }
}
