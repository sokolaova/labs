public class Main {
        public static int findMinAndMultipleOf21(int[] arr) {
            int Min = Integer.MAX_VALUE; //константа равна максимальному значению типа integer
            int min_21 = 10001;
            int min_7 = 10001;
            int min_3 = 10001;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 21 == 0 && arr[i] < min_21) { //миниммальное, кратное 21
                    min_21 = arr[i];
                } else if (arr[i] % 7 == 0 && arr[i] < min_7) { //миниммальное, кратное 7
                    min_7 = arr[i];
                } else if (arr[i] % 3 == 0 && arr[i] < min_3) { //миниммальное, кратное 3
                    min_3 = arr[i];
                } else if (arr[i] != 0 && arr[i] < Min) { //миниммальное
                    Min = arr[i];
                }
            }

            var minAndMultiple21_1 = 0;  // Случай 1: минимальное число массива * минимальное кратное 21
            var minAndMultiple21_2 = 0; // Случай 2: минимальное кратное 3 * минимальное кратное 7

            if (Min != Integer.MAX_VALUE && min_21 != 10001)
                minAndMultiple21_1 = Min * min_21;
            if (min_3 != 10001 && min_7 != 10001)
                minAndMultiple21_2 = min_3 * min_7;

            var minPossible = Math.min(minAndMultiple21_1, minAndMultiple21_2);
            var R = minPossible != 0
                    ? minPossible
                    : -1;   // Случай 3: -1, если не найдено R
            return R;

        }

        public static void main(String[] args) {
            int[] arr = new int[1000]; //инициализируем массив из 1000 элементов
            for (int i = 0; i < 1000; i++) {
                arr[i] = (int)(Math.random() * 10000); // заполняем массив неотрицательными целыми числами, не больше 10000
            }

            int result = findMinAndMultipleOf21(arr); //вызываем метод
            System.out.println("Минимальное число, кратное 21, а также является произведением двух различных элементов последовательности (-1, если такового нет): " + result);

        }

}
