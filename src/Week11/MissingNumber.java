package Week11;

import java.util.*;

public class MissingNumber {
    public static List<Integer> missingNumbersHashTable(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        Hashtable<Integer, Integer> tableB = new Hashtable<>();
        Hashtable<Integer, Integer> tableA = new Hashtable<>();
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < brr.size(); i++) {
            if (tableB.containsKey(brr.get(i))) {
                tableB.put(brr.get(i), tableB.get(brr.get(i)) + 1);
            } else {
                tableB.put(brr.get(i), 0);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (tableA.containsKey(arr.get(i))) {
                tableA.put(arr.get(i), tableA.get(arr.get(i)) + 1);
            } else {
                tableA.put(arr.get(i), 0);
            }
        }
        Set<Integer> set = tableB.keySet();
        for (Integer key : set) {
            if (tableB.get(key).equals(tableA.get(key))) {
                continue;
            } else {
                missingNumbers.add(key);
            }
        }
        Collections.sort(missingNumbers);
        return missingNumbers;
    }

    public static List<Integer> missingNumbersSort(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> missingNumbers = new ArrayList<>();
        Collections.sort(arr);
        Collections.sort(brr);
        int i = 0;
        int j = 0;
        while (i < arr.size() && j < brr.size()) {
            if (arr.get(i).equals(brr.get(j))) {
                i++;
                j++;
            } else {
                if (!missingNumbers.contains(brr.get(j))) {
                    missingNumbers.add(brr.get(j));
                }
                j++;
            }
        }
        if (j < brr.size()) {
            missingNumbers.addAll(brr.subList(j, brr.size()));
        }
        return missingNumbers;
    }

    public static List<Integer> missingNumbersCounting(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        List<Integer> missingNumbers = new ArrayList<>();
        int size = Collections.max(brr);
        int []a = new int [size + 1];
        int []b = new int [size + 1];
        for (int i = 0; i < arr.size(); i ++) {
            int n = arr.get(i);
            a[n]++;
        }
        for (int i = 0; i < brr.size(); i ++) {
            int n = brr.get(i);
            b[n]++;
        }
        for (int i = 0; i < size; i++) {
            if (a[i] != b[i]) {
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }
}
