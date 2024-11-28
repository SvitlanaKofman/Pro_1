package homework;

public class Homework {
    
        public static int countNumbers(int start, int end) {
            int count = 0;
            for (int num = start; num <= end; num++) {
                if (num % 21 == 0 && String.valueOf(num).contains("3")) {
                    count++;
                }
            }
            return count;
        }

        // Решение в один поток
        public static int solutionSingleThread() {
            return countNumbers(1, 2_000_000);
        }

        // Решение с использованием двух потоков
        public static int solutionMultiThread() throws InterruptedException {

            int mid = 1_000_000;
            final int[] result = new int[2];


            Thread thread1 = new Thread(() -> {
                result[0] = countNumbers(1, mid);
            });

            Thread thread2 = new Thread(() -> {
                result[1] = countNumbers(mid + 1, 2_000_000);
            });

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            return result[0] + result[1];
        }

        public static void main(String[] args) throws InterruptedException {
            boolean useMultiThread = true;// Выбираем false, чтобы использовать один поток

            // В зависимости от флага вызываем одно из решений
            int result;
            if (useMultiThread) {
                result = solutionMultiThread();  // Решение с использованием двух потоков
            } else {
                result = solutionSingleThread();  // Решение в один поток
            }

            System.out.println("Результат: " + result);
        }
    }

