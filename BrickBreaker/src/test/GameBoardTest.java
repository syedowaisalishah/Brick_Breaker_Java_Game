import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class GameBoardTest {

    @Test
    public void testGameBoardConstructor() {
        try {
            BrickBreaker mainApp = new BrickBreaker();
            GameBoard gameBoard = new GameBoard(mainApp);
            assertNotNull("GameBoard object is not null", gameBoard);
            // assertNotNull("Ball object is not null", gameBoard.ball);
            assertNotNull("Racket object is not null", gameBoard.racket);
            assertNotNull("Bricks array is not null", gameBoard.bricks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
