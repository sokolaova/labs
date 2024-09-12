public class Main {
        public static int findMinAndMultipleOf21(int[] arr) {
            int MinAndMultipleOf21 = Integer.MAX_VALUE; //константа равна максимальному значению типа integer
            boolean found = false;

            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int tested = arr[i] * arr[j];
                    if (tested % 21 == 0 && tested < MinAndMultipleOf21 && CheckAvailability(arr, tested)) { //тестируемое значение должно быть минимальным кратным 21, а также находится среди зачений элементов в массиве
                        MinAndMultipleOf21 = tested; //если соответствует, меняем на него предыдущее значение MinAndMultipleOf21
                        found = true;
                    }
                }
            }
            if (found){
                return MinAndMultipleOf21;
            }
            else{
                return -1;
            }
        }

        //проверка на наличие элемента тестируемого значения в массиве
        public static boolean CheckAvailability(int[] arr, int tested){
            boolean isChecked = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == tested){
                    isChecked = true;
                }
            }
            return isChecked;
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
