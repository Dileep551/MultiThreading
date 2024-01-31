class Task1 extends Thread {


    public void run() { //Exact signature

        System.out.print("\n Task1 Start ");

        for (int i = 101; i < 199; i++) {
            System.out.print(i + " ");
        }

        System.out.print("\n Task1 Done ");

    }


}

class Task2 implements Runnable {

    @Override
    public void run() {

        System.out.print("\n Task2 Started ");

        //Task2

        for (int i = 201; i < 299; i++) {
            System.out.print(i + " ");
        }

        System.out.print("\n Task2 Done ");


    }
}


public class ThreadBasicRunner {

    public static void main(String[] args) throws InterruptedException {


        //New
        //RUNNABLE
        //RUNNING;
        //BLOCKED/WAITING
        //TERMINATED/DEAD


        //Task1


        System.out.print("\nTask1 Kicked off");
        Task1 task1 = new Task1();
        task1.setPriority(1);
        task1.start();

        //Task2


        System.out.print("\nTask2 Kicked off");

        Task2 task2 = new Task2();
        Thread task2Thread = new Thread(task2);
        task2Thread.setPriority(10);
        task2Thread.start();

        //wait for task1 to complete
        task1.join();
        task2Thread.join();

        Thread.sleep(1000); // When you want to wait time

        Thread.yield(); //Getting lot of CPU, Okay to going to waiting state, Hint to give up, current scheduler
        //The scheduler is free to ignore this hint


        //Executor service : This helps how to run Threads , Handle all complexity of running threads


        System.out.print("\n Task3 Kicked off ");
        //Task3

        for (int i = 301; i < 399; i++) {
            System.out.print(i + " ");
        }

        System.out.print("\n Task3 Done ");
        System.out.print("\n Main method is done ");


    }
}
