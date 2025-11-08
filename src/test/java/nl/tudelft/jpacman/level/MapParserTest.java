package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.npc.ghost.Blinky;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;




/**
 * This is a test class for MapParser.
 */
@ExtendWith(MockitoExtension.class)
public class MapParserTest {

    @Mock
    private BoardFactory boardFactory;

    @Mock
    private LevelFactory levelFactory;

    @Mock
    private Blinky blinky;

    /**
     * Test parseMap method with mocked factories and ghost.
     */
    @Test
    public void testParseMapGood() {
        // No need for initMocks
        assertNotNull(boardFactory);
        assertNotNull(levelFactory);
        Mockito.when(levelFactory.createGhost()).thenReturn(blinky);

        MapParser mapParser = new MapParser(levelFactory, boardFactory);
        ArrayList<String> map = new ArrayList<>();
        map.add("############");
        map.add("#P        G#");
        map.add("############");

        mapParser.parseMap(map);

        Mockito.verify(levelFactory, Mockito.times(1)).createGhost();
        Mockito.verify(boardFactory, Mockito.atLeastOnce()).createWall();
        Mockito.verify(boardFactory, Mockito.atLeastOnce()).createGround();
    }

    /**
     * Test parseMap method with a malformed map.
     * Should throw PacmanConfigurationException.
     */
    @Test
    public void testParseMapWrong() {
        MapParser mapParser = new MapParser(levelFactory, boardFactory);

        ArrayList<String> badMap = new ArrayList<>();
        badMap.add("###########");
        badMap.add("#P  X     G#");
        badMap.add("############");

        Exception thrown = assertThrows(
            IllegalArgumentException.class,
            () -> mapParser.parseMap(badMap)
        );

        assertTrue(thrown.getMessage().contains("Invalid character"));
    }

}




