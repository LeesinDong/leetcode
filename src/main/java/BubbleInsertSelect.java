public class BubbleInsertSelect {
    public static void main(String[] args) {
        int[] array = new int[100];
        // bubble Sort 
        long start1 = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < array.length; j++) {
                array[j] =(int)(Math.random() * 10000);
            }
            bubbleSort(array);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("Bubble Sort->");
        System.out.println(end1 - start1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        //insert Sort
        long start2 = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < array.length; j++) {
                array[j] =(int)(Math.random() * 10000);
            }
            insertSort(array);
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Insert Sort->");
        System.out.println(end2 - start2);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        //select sort
        long start3 = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            for (int j = 0; j < array.length; j++) {
                array[j] =(int)(Math.random() * 10000);
            }
            selectSort(array);
        }
        long end3 = System.currentTimeMillis();
        System.out.println("Select Sort->");
        System.out.println(end3 - start3);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] > arr[j -1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int insertNode = arr[i];
            while (j >= 0 && arr[j] > insertNode) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertNode;
        }
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[pos] > arr[j]) {
                    pos = j;
                }
            }
            if (pos != i) {
                int temp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
