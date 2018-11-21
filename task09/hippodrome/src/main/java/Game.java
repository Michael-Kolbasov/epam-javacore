import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *  Game class provides logic for the game.
 *  It sets Horses to run through the Field, Player to play and so on infinitely, until player won't lose all money or
 * type 'quit' in the end of the run.
 *  It also shows the result of the run after all horses are finished like:
 *      1. Horse-winner-name --- time of run
 *      2. Horse-that-ran-second --- time of run
 *
 *  {@code lock} is used to synchronize methods to determine the winner.
 *  {@code horses} is a list of horses running.
 */
public class Game {
    private final static Object lock = new Object();
    private volatile ExecutorService horsesExecutorService = Executors.newFixedThreadPool(5);
    private volatile List<Horse> horses;
    private Player player;
    private String winner;

    public Game() {
        horses = createFieldAndHorses();
        player = new Player(this);
    }

    /**
     * Infinite method that sets up the game.
     */
    public void launch() {
        System.out.println("Welcome to the hippodrome!");
        System.out.println("You have " + player.getMoney() + " standard money units.");
        System.out.println("Minimal bet is 200 standard units. If you win, you double the bet, else - you lose it.");
        List<Horse> horses = createFieldAndHorses();
        Horse betHorse = player.chooseAHorse();
        player.makeABet();
        startRun(horses);
        getResult(horses);
        System.out.println();
        checkBet(betHorse);
        if (!player.checkQuit()) {
            launch();
        }
    }

    public List<Horse> getHorses() {
        return horses;
    }

    private List<Horse> createFieldAndHorses() {
        Field field = new Field();
        List<Horse> horses = new ArrayList<>(5);
        horses.add(new Horse("Betta", 60, field));
        horses.add(new Horse("Gretta", 70, field));
        horses.add(new Horse("Djuzeppa", 60, field));
        horses.add(new Horse("Vendetta", 65, field));
        horses.add(new Horse("Avangardetta", 75, field));
        return horses;
    }

    /**
     *  In this method horses begin to run. It's a parallel stream of all horses, which become later a list of
     * List<Future<Horse>> to manipulate their result.
     * @param horses    horses running
     * @return horsesRunning    List<Future<Horse>> a list of horses that returned from their run (in both senses)
     */
    private List<Future<Horse>> startRun(List<Horse> horses) {
        List<Future<Horse>> horsesRunning = new ArrayList<>(5);
        System.out.println("The run has begun!");
        try {
            horsesRunning = Executors.newFixedThreadPool(5).invokeAll(horses);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            finishRun(horsesRunning);
            horsesExecutorService.shutdown();
            try {
                while (!horsesExecutorService.awaitTermination(10, TimeUnit.SECONDS)) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return horsesRunning;
    }

    /**
     * This method simply determines which horse has become the winner.
     * @param horsesRunning
     */
    private void finishRun(List<Future<Horse>> horsesRunning) {
        synchronized (lock) {
            boolean finished = false;
            while (!finished) {
                for (Future<Horse> horse : horsesRunning) {
                    try {
                        if (horse.isDone()) {
                            finished = true;
                            winner = horse.get().getName();
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("The winner is " + winner + "!");
        }
    }

    /**
     * Check if player has won or lost.
     * @param betHorse
     * @return
     */
    private boolean checkBet(Horse betHorse) {
        if (winner.equalsIgnoreCase(betHorse.getName())) {
            player.win();
            System.out.println("You have won!");
            System.out.println("Your money: " + player.getMoney());
            return true;
        } else {
            System.out.println("You have lost.");
            System.out.println("Your money: " + player.getMoney());
            return false;
        }
    }

    /**
     * This method sorts the list depending on horses' finishing position and prints their results.
     * @param horses    horses which took part in the run.
     */
    private void getResult(List<Horse> horses) {
        horses.sort((o1, o2) -> o1.getFinishPosition() - o2.getFinishPosition());
        System.out.println();
        System.out.println("Horses results:");
        for (Horse horse : horses) {
            System.out.println(horse.getFinishPosition() + ". " + horse.getName() + " --- " + horse.getRunTime() + " sec");
        }
    }
}