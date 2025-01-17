import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;


import static org.testfx.api.FxAssert.verifyThat;

public class M6UnitTests extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        WelcomeScreen welcome = new WelcomeScreen();
        welcome.start(stage);
    }

    @Test
    public void testUpgradeLightTower() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Pranav");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("UPGRADE LIGHT TOWER");
        clickOn("CONFIRM");
        verifyThat("Medium Towers Count: 1", NodeMatchers.isNotNull());
    }

    @Test
    public void testEndGameStatistics() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Pranav");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("End the Game");
        verifyThat("Enemies Killed: 0", NodeMatchers.isNotNull());
    }

    @Test
    public void testUpgradeMediumTower() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY MEDIUM TOWER");
        clickOn("CONFIRM");
        clickOn("Access Tower Store");
        clickOn("UPGRADE MEDIUM TOWER");
        clickOn("CONFIRM");
        verifyThat("Heavy Towers Count: 1", NodeMatchers.isNotNull());
    }

    @Test
    public void testUpgradeIndividual() {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Access Tower Store");
        clickOn("BUY LIGHT TOWER");
        clickOn("CONFIRM");
        clickOn("Access Tower Store");
        clickOn("UPGRADE LIGHT TOWER");
        clickOn("CONFIRM");
        verifyThat("Medium Towers Count: 1", NodeMatchers.isNotNull());
    }

    @Test
    public void testFinalBossLose() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        Thread.sleep(90000);
        verifyThat("Start New Game", NodeMatchers.isNotNull());
    }

    @Test
    public void testFinalBossWin() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(1000);
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(1000);
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(60000);
        verifyThat("YOU WON THE GAME", NodeMatchers.isNotNull());
    }

    @Test
    public void testFinalBossStatistics() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(1000);
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(1000);
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(1000);
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(60000);
        verifyThat("Enemies Killed: 6", NodeMatchers.isNotNull());
    }

    @Test
    public void startNewGameWin() throws InterruptedException {
        clickOn("Click to Start");
        clickOn("Input player name");
        write("Spencer");
        clickOn("Easy");
        clickOn("CONFIRM");
        clickOn("OK");
        clickOn("Start Combat");
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(1000);
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(1000);
        clickOn("Access Tower Store");
        clickOn("BUY HEAVY TOWER");
        clickOn("CONFIRM");
        Thread.sleep(1000);
        clickOn("Access Tower Store");
        clickOn("BUY LIGHT TOWER");
        clickOn("CONFIRM");
        Thread.sleep(60000);
        clickOn("Start New Game");
        verifyThat("Welcome to Tower Defense!", NodeMatchers.isNotNull());
    }

}
