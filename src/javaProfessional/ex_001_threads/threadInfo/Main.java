package javaProfessional.ex_001_threads.threadInfo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Статический метод currentThread() инкапсулирует текущий поток в этот объект
        Thread myThread = Thread.currentThread();
        // Узнаем имя потока
        System.out.println("Name of Thread: " + myThread.getName());
        // Изменяем имя потока
        myThread.setName("MyThread");
        System.out.println("Thread name: " + myThread.getName());
        // Узнаем приоритет потока, по умолчанию 5 у main
        System.out.println("Priority: " + myThread.getPriority());
        // Изменяем приоритет потока от 1...10
        myThread.setPriority(10);
        System.out.println("Priority: " + myThread.getPriority());
        // Проверяем, жив ли поток
        System.out.println("Is Thread Alive?: " + myThread.isAlive());

        // Какой поток выполнится первым - не известно
        new OtherThread().start();

        for (int i = 0; i < 10; i++) {
            // Метод sleep() усыпляет поток на кол-во миллисекунд
            Thread.sleep(2000);
            System.out.println("i = " + i);
        }
    }
}

class OtherThread extends Thread {
    // Для того, чтобы поток выполнялся параллельно
    public void run() {
        for (int j = 0; j < 10; j++) {
            // Метод sleep() усыпляет поток на кол-во миллисекунд
            try {
                Thread.sleep(2000);
                System.out.println("j = " + j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}