import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Horse class defines the behavior of a Horse.
 * Since horse galloping speed is 50-60 km/h due to google, 55 km/h will be medium speed.
 *
 * {@code finishPosition} sets the finish position to horses {@code horseFinishPosition} when they finish the run.
 * {@code distanceRan} counts how far from the finish line the horses are.
 * {@code initialSpeed} sets the constant speed of a horse.
 * {@code runTime} starts when Horse began run. It is needed to count the run time later.
 * {@code hasFinished} a flag to determine when the run is over.
 */
public class Horse implements Callable<Horse> {
    private static int finishPosition = 0;
    private int distanceRan = 0;
    private Field field;
    private String name;
    private int initialSpeed;
    private long runTime;
    private boolean hasFinished;
    private int horseFinishPosition;

    public Horse(String name, int initialSpeed, Field field) {
        this.name = name;
        this.initialSpeed = initialSpeed;
        this.field = field;
    }

    /**
     * Be careful with this one: it is supposed that each horse will have a unique name.
     * @return  hashcode from the horses name.
     */
    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    /**
     * Same as hashcode: it is supposed that each horse has a unique name.
     * @return  equality of horses depending on their names.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Horse other = (Horse) obj;
        if (!getName().equalsIgnoreCase(other.getName())) {
            return false;
        }
        return true;
    }

    /**
     *  This method represents the unique stream for horses. Their speed is calculated by the formula:
     * {@code initialSpeed} + {@code defineAcceleration()}.
     * @return  Horse that finished the run.
     */
    @Override
    public Horse call() {
        boolean closeToFinish = false;
        long startedRunAt = System.currentTimeMillis();
        while (!hasFinished) {
            distanceRan = distanceRan + initialSpeed + defineAcceleration();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " is at " + distanceRan + " meters!");
            if (!closeToFinish && distanceRan >= field.getFinishing()) {
                System.out.println(getName() + " is close to the finish! It's only " + (field.getLength() - distanceRan) + " meters left!");
                closeToFinish = true;
            }
            if (distanceRan >= field.getLength()) {
                System.out.println(getName() + " has crossed the finish line!");
                long finishedRunAt = System.currentTimeMillis();
                runTime = (finishedRunAt - startedRunAt) / 1000;
                horseFinishPosition = ++Horse.finishPosition;
                hasFinished = true;
            }
        }
        return this;
    }

    private int defineAcceleration() {
        Random rand = new Random();
        return rand.nextInt(50) + 1;
    }

    public String getName() {
        return name;
    }

    public synchronized long getRunTime() {
        return runTime;
    }

    public synchronized int getFinishPosition() {
        return horseFinishPosition;
    }

    @Override
    public String toString() {
        return name + " --- Initial speed: " + initialSpeed;
    }
}