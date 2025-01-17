import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A Controller class that handles flow between
 * different screens in the Application.
 *
 * @author Olaolu Dada, Pranav Datta
 * @version 1.0
 */


public class Controller extends Application {
    private Stage primaryStage;
    private Player player;
    private InitialConfigurationScreen config;
    private boolean saved;
    private WelcomeScreen welcome;
    private GameScreen game;
    private EndGame endGame;
    private Statistics stats;
    private WinScreen winScreen;

    /**
     * Constructor for the Controller.Controller class.
     *
     * @param primaryStage the main stage
     * @throws Exception if stage can't launch correctly
     */
    public Controller(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        welcome = new WelcomeScreen(this);
        config = new InitialConfigurationScreen();
        welcome.start(primaryStage);
        game = new GameScreen(this);
        endGame = new EndGame(this);
        stats = new Statistics();
        winScreen = new WinScreen(this);
    }

    /**
     * No-arg constructor for the Controller.Controller class
     */
    public Controller() {

    }

    /**
     * Creates a player object based on user input
     *
     * @param name  player's chosen name
     * @param level player's chosen difficulty
     */
    public void createPlayer(String name, Level level) {
        player = new Player(name, level);
    }


    /**
     * Getter for the player object.
     *
     * @return the player object.
     */
    public Player getPlayer() {
        return player;
    }


    /**
     * Transitions from Welcome Screen to Config screen
     */
    public void startInitialConfig() {
        config.initializeGame(primaryStage);
        saved = false;
    }

    /**
     * Transitions from End Game Screen to Welcome Screen
     * @throws Exception exception
     */

    public void startWelcomeScreen() throws Exception {
        welcome.start(primaryStage);
    }

    /**
     * Starts the game screen
     */
    public void startGameUI() {
        game.playGame(primaryStage);
    }

    /**
     * Getter for game screen
     *
     * @return Game Screen
     */
    public GameScreen getGame() {
        return game;
    }

    /**
     * Shows the game over screen
     */
    public void end() {
        primaryStage.close();
        endGame.start(primaryStage);
    }

    public void win() {
        primaryStage.close();
        winScreen.start(primaryStage);
    }

    public Statistics getStats() {
        return this.stats;
    }

    /**
     * Starts combat on map
     */

    ///**
    // * Saves the game
    // *
    // * @throws Exception if stage can't launch correctly
    // */
    //public void save() {
    //    saved = true;
    //    primaryStage.hide();
    //    welcome = new WelcomeScreen(this);
    //    welcome.start(primaryStage);
    //}

    ///**
    // * Getter for saved
    // *
    // * @return true if game is saved.
    // */

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
