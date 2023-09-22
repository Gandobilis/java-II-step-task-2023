import java.util.*;

public class Main {
    int singleNumber(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet())
            if (entry.getValue() == 1)
                return entry.getKey();

        return -1;
    }

    int minSplit(int amount) {
        int[] denominations = {50, 20, 10, 5, 1};
        int minCoins = 0;

        for (int coin : denominations) {
            minCoins += amount / coin;
            amount %= coin;
        }

        return minCoins;
    }

    int notContains(int[] array) {
        quickSort(array);

        for (int curr = 0; curr < array.length - 1; curr++)
            if (array[curr + 1] != array[curr] + 1)
                return array[curr] + 1;

        return -1;
    }

    String binarySum(String a, String b) {
        int maxLength = a.length() >= b.length() ? a.length() : b.length();
        StringBuilder result = new StringBuilder();

        StringBuilder aBuilder = new StringBuilder(a);
        while (aBuilder.length() < maxLength) {
            aBuilder.insert(0, "0");
        }
        a = aBuilder.toString();

        StringBuilder bBuilder = new StringBuilder(b);
        while (bBuilder.length() < maxLength) {
            bBuilder.insert(0, "0");
        }
        b = bBuilder.toString();

        int carry = 0;

        int rightMostA = a.length() - 1, rightMostB = b.length() - 1;

        while (rightMostA >= 0 || rightMostB >= 0) {
            int bitA = a.charAt(rightMostA--) - 48, bitB = b.charAt(rightMostB--) - 48;

            int sum = bitA + bitB + carry;
            carry = sum / 2;
            result.append(sum % 2);
        }

        if (carry == 1)
            result.append(carry);

        return result.reverse().toString();
    }

    int countVariants(int stearsCount) {
        int variants = 0;
        int maxTwoStep = stearsCount / 2;

        for (int i = 0; i <= maxTwoStep; i++) {
            variants += C(stearsCount - i, i);
        }

        return variants;
    }

    private int C(int m, int n) {
        int num = 1;
        int den = 1;

        for (int i = 0; i < m - n; i++) {
            num *= (m - i);
            den *= (i + 1);
        }

        return num / den;
    }

    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
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

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class O1DeletionDataStructure<K, V> {
    private final Map<K, Node<V>> keyToNodeMap;
    private final DoublyLinkedList<V> list;

    public O1DeletionDataStructure() {
        keyToNodeMap = new HashMap<>();
        list = new DoublyLinkedList<>();
    }

    public void insert(K key, V value) {
        if (!keyToNodeMap.containsKey(key)) {
            Node<V> newNode = list.add(value);
            keyToNodeMap.put(key, newNode);
        }
    }

    public void delete(K key) {
        if (keyToNodeMap.containsKey(key)) {
            Node<V> nodeToDelete = keyToNodeMap.get(key);
            list.remove(nodeToDelete);
            keyToNodeMap.remove(key);
        }
    }

    public V getRandom() {
        return list.getRandom();
    }

    private static class Node<V> {
        V value;
        Node<V> prev;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    private static class DoublyLinkedList<V> {
        Node<V> head;
        Node<V> tail;

        public Node<V> add(V value) {
            Node<V> newNode = new Node<>(value);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            return newNode;
        }

        public void remove(Node<V> node) {
            if (node == null) {
                return;
            }
            if (node == head) {
                head = head.next;
            }
            if (node == tail) {
                tail = tail.prev;
            }
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }

        public V getRandom() {
            if (head == null) {
                return null;
            }
            return head.value;
        }
    }
}