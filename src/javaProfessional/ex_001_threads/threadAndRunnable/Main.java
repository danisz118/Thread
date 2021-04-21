package javaProfessional.ex_001_threads.threadAndRunnable;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Экземпляр класса OtherThread передается в конструктор объекта класса Thread
        Thread other = new Thread(new OtherThread());

        other.start();

        for (int i = 0; i < 5; i++) {
            // Метод sleep() усыпляет поток на кол-во миллисекунд
            Thread.sleep(2000);
            System.out.println("i = " + i);
            if (i == 2) {
                // Метод join(), останавливает поток, в котором выполняется метод join()
                // И будет заблокирован(поток main), пока не закончится поток Other
                System.out.println(Thread.currentThread().getName());
                other.join();
            }
        }
    }
}

class OtherThread implements Runnable {
    // Для того, чтобы поток выполнялся параллельно
    @Override
    public void run() {
        for (int j = 0; j < 5; j++) {
            // Метод sleep() усыпляет поток на кол-во миллисекунд
            try {
                Thread.sleep(2000);
                System.out.println("j = " + j + " " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}