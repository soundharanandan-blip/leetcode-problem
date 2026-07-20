import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    // 5 locks representing the 5 forks
    private final ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {
        
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Determine fork pick ordering based on IDs to prevent deadlock
        int firstFork = Math.min(leftFork, rightFork);
        int secondFork = Math.max(leftFork, rightFork);

        // Pick up forks in order
        forks[firstFork].lock();
        forks[secondFork].lock();

        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            // Release forks
            forks[secondFork].unlock();
            forks[firstFork].unlock();
        }
    }
}
