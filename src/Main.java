import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public static int singleNumber(int[] nums) {
        quickSort(nums);
        int first = 0;
        int last = nums.length - 1;

        if (nums[first] != nums[first + 1]) return nums[first];
        else if (nums[last] != nums[last - 1]) return nums[last];
        else
            for (int curr = 1; curr < nums.length - 1; curr++)
                if (nums[curr] != nums[curr - 1] && nums[curr] != nums[curr + 1])
                    return nums[curr];

        return -1;
    }

    int minSplit(int amount) {
        int[] denominations = {50, 20, 10, 5, 1};
        int minCoins = 0;

        for (int coin : denominations) {
            if (amount >= coin) {
                int numCoins = amount / coin;
                amount -= numCoins * coin;
                minCoins += numCoins;
            }
        }

        return minCoins;
    }

//    int notContains(int[] array) {
//
//    }

    String binarySum(String a, String b) {
        return "";
    }

    int countVariants(int stearsCount) {
        return 0;
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}