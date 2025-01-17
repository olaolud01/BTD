import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;

public class UnitTests extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        WelcomeScreen welcome = new WelcomeScreen();
        welcome.start(stage);
    }

    @Test
    public void testInitialScreen() {
        clickOn("Click to Start");
        verifyThat("Configuration Screen", NodeMatchers.isNotNull());
    }

    @Test
    public void testPlayerTwoArgConstructor() {
        Player player1 = new Player("Eric", Level.HARD);
        assertNotNull(player1);
        assertEquals(player1.getName(), "Eric");
        assertEquals(player1.getLevel(), Level.HARD);
        assertEquals(player1.getMoney(), 150, 0);
    }

    @Test
    public void testPlayerOneArgConstructor() {
        Player player2 = new Player("Spencer");
        assertNotNull(player2);
        assertEquals(player2.getName(), "Spencer");
        assertEquals(player2.getMoney(), 500, 0);
        assertEquals(player2.getLevel(), Level.EASY);
    }

    @Test
    public void testPlayerAndController() {
        Player play = new Player("Laolu Dada", Level.EASY);
        assertNotNull(play);
        assertEquals("Laolu Dada", play.getName());
        assertEquals(500, play.getMoney(), 0);
        assertEquals(Level.EASY, play.getLevel());

        Controller c = new Controller();
        c.createPlayer("Laolu Dada", Level.INTERMEDIATE);
        assertNotNull(c.getPlayer());
        assertEquals("Laolu Dada", c.getPlayer().getName());
        assertEquals(250, c.getPlayer().getMoney(), 0);
        assertEquals(Level.INTERMEDIATE, c.getPlayer().getLevel());
    }

    //M3 Tests

    @Test
    public void testTowerMenuButton() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Pranav");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        verifyThat("Purchase a tower here!", NodeMatchers.isNotNull());
    }

    @Test
    public void testLightTowerButton() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Pranav");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY LIGHT TOWER");
        clickOn("CONFIRM");
        verifyThat("Tower Defense!", NodeMatchers.isNotNull());
    }

    @Test
    public void testEndGameButton() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        verifyThat("End the Game", NodeMatchers.isNotNull());
    }

    @Test
    public void testMediumTowerButton() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY MEDIUM TOWER");
        clickOn("CONFIRM");
        verifyThat("Tower Defense!", NodeMatchers.isNotNull());
    }

    @Test
    public void testHeavyTowerButton() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Eric");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        verifyThat("Tower Defense!", NodeMatchers.isNotNull());
    }

    @Test
    public void testBuyLightTower() {
        Player player1 = new Player("Eric", Level.HARD);
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Eric");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY LIGHT TOWER");
        clickOn("CONFIRM");
        verifyThat("Total money: $475.0", NodeMatchers.isNotNull());
    }

    @Test
    public void testBuyMediumTower() {
        Player player1 = new Player("Laolu", Level.HARD);
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Laolu");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY MEDIUM TOWER");
        clickOn("CONFIRM");
        verifyThat("Total money: $450.0", NodeMatchers.isNotNull());
    }

    @Test
    public void testBuyHeavyTower() {
        Player player1 = new Player("Laolu", Level.HARD);
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Laolu");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        verifyThat("Total money: $425.0", NodeMatchers.isNotNull());
    }

    //M4 Tests

    @Test
    public void testBackToWelcome() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Pranav");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("End the Game");
        clickOn("Start New Game");
        verifyThat("Welcome to Tower Defense!", NodeMatchers.isNotNull());
    }

    @Test
    public void testGameOverScreen() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Pranav");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("End the Game");
        verifyThat("Start New Game", NodeMatchers.isNotNull());
        verifyThat("End Game", NodeMatchers.isNotNull());
    }

    @Test
    public void testMonumentDamage() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Eric");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        Thread.sleep(60000);
        verifyThat("Monument health: 300", NodeMatchers.isNotNull());
    }

    @Test
    public void testEndGameCloseGame() {
        Controller c = new Controller();
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Eric");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("End the Game");
        clickOn("End Game");
        assertNull(c.getPlayer());
        assertNull(c.getGame());
    }

    @Test
    public void testStartCombatButton() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Laolu");
        clickOn("Hard");
        clickOn("CONFIRM");
        clickOn("OK");
        verifyThat("Start Combat", NodeMatchers.isNotNull());
    }

    @Test
    public void testEndGameRestartValidGame() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Laolu");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("End the Game");
        clickOn("Start New Game");
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Dada");
        clickOn("Intermediate");
        clickOn("CONFIRM");
        clickOn("OK");
        verifyThat("End the Game", NodeMatchers.isNotNull());
        verifyThat("Start Combat", NodeMatchers.isNotNull());
        verifyThat("Access Tower Store", NodeMatchers.isNotNull());
    }

    @Test
    public void testGameEndAutomatically() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Hard");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        Thread.sleep(60000);
        verifyThat("Start New Game", NodeMatchers.isNotNull());
    }

    @Test
    public void testBuyTowerWhileGameActive() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Hard");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        verifyThat("You now have $0.0", NodeMatchers.isNotNull());
    }
}

