

public class Main {
    int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums)
            result ^= num;

        return result;
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

    int notContains(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; i++)
            if (array[i] <= 0 || array[i] > n)
                array[i] = n + 1;


        for (int i = 0; i < n; i++) {
            int num = Math.abs(array[i]);
            if (num <= n)
                array[num - 1] = -Math.abs(array[num - 1]);

        }

        for (int i = 0; i < n; i++)
            if (array[i] > 0)
                return i + 1;


        return n + 1;
    }

    String binarySum(String a, String b) {
        return "";
    }

    int countVariants(int stearsCount) {
        return 0;
    }
}