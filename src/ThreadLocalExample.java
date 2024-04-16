public class ThreadLocalExample {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Hello, ThreadLocal!");

        Runnable task = () -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", local value: " + local.get());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
