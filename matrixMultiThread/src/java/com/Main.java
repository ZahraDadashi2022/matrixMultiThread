package java.com;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new Matrix());
            thread.start();
            System.out.println("main thread:\t" + Thread.currentThread().getName() + " " + i);
            for (int j = 0; j < 4; j++) {
                try {
                    thread.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
