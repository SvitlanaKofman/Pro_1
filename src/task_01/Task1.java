package task_01;

public class Task1 {
    public static void main(String[] args)  {

        /*
        Два способа создание потока
        1. Наследование от класса Thread
        2. Реализация интерфейса Runnable
         */

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        // Это не порождает новые потоки.
        // Мы получаем просто выполнение кода метода в текущем потоке
//        myThread1.run();
//        myThread2.run();

        // При создании наследованием - вызываем метод start()
        // Метод start создает новый поток, в котором будет выполнен набор инструкций,
        // прописанных в методе run()
        myThread1.start();

        /*
        При имплементации
        1. Нужно создать объект класса Thread
         При создании объекта к конструктор мы можем передать имплементацию интерфейса Runnable
         Мы передадим объект нашего класса, имплементирующего Runnable
         У созданного объекта Thread вызываем метод start()
         */
        Thread thread = new Thread(myThread2);
        // Для того чтобы сделать поток демон-потоком
        thread.setDaemon(true); // перед стартом потока
        thread.start();

        // Реализация функционального интерфейса лямбда выражением
        // Для реализации функ.нтерфейса не обязательно писать отдельный класс.
//        Thread thread1 = new Thread(() -> {
//            for (int i = 1_000_000; i < 1_000_010; i++) {
//                System.out.println(Thread.currentThread().getName() + " - " + i);
//
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//        thread1.start();


        // Программа заканчивает свою работу, когда заканчивают работу
        // все НЕ-демон потоки

        // Main-поток
        for (int i = 0; i < 10; i++) {
            // Получить текущий поток и получить имя у этого потока
            System.out.println(Thread.currentThread().getName() + " - " + i);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
