public class ArrayOps {
    public static void main(String[] args) {
    }

    public static int findMissingInt(int[] array) {
        int arraySum = 0;
        int expectedSum = 0;
        for (int i = 0; i < array.length + 1; i++) {
            expectedSum += i;
        }
        for (int i = 0; i < array.length; i++) {
            arraySum += array[i];
        }
        return expectedSum - arraySum;
    }

    public static int secondMaxValue(int[] array) {
        int max = array[0];
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        int secondMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > secondMax && i != maxIndex) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }

    public static boolean containsTheSameElements(int[] array1, int[] array2) {
        int[] set1 = set(array1);
        int[] set2 = set(array2);
        return (set1.length == set2.length);
    }

    public static int[] set(int[] arr) {
        int[] res = new int[countUnique(arr)];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!contains(arr, arr[i], i)) {
                res[index++] = arr[i];
            }
        }
        return res;
    }

    public static int countUnique(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = contains(arr, arr[i], i) ? count : count + 1;
        }
        return count;
    }

    public static boolean contains(int[] arr, int value, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSorted(int[] array) {
        int[] set1 = set(array);
        boolean sorted = false;
        if (set1[1] > set1[0]) {
            for (int i = 1; i < set1.length; i++) {
                sorted = (set1[i] > set1[i - 1]);
            }
        } else {
            for (int i = 1; i < set1.length; i++) {
                sorted = (set1[i] < set1[i - 1]);
            }
        }
        return sorted;
    }
}
