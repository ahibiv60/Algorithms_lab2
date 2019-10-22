import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Algorithm {
    void search(int[] array, int cows) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        System.out.println(list + " - free places");
        list.sort(Integer::compareTo);
        int step = (list.get(list.size() - 1)) / cows;
        System.out.println(list + " - sorted places");
        if (cows == 2) {
            int maxStep = list.get(list.size() - 1) - list.get(0);
            System.out.println(maxStep);
        } else {
            division(list, step, cows);
        }
    }

    private void division(List<Integer> list, int step, int cows) {
        List<Integer> myList = new ArrayList<>();
        myList.add(list.get(0));
        for (int i = 1; i <= list.size() - 1; i++) {
            if ((myList.get(myList.size() - 1) + step) < list.get(i)) {
                myList.add(list.get(i));
            }
        }
        if (myList.size() != cows) {
            division(list, step - 1, cows);
        } else {
            System.out.println(myList + " - the outermost places");
            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < myList.size() - 1; i++) {
                resultList.add(myList.get(i + 1) - myList.get(i));
            }
            System.out.println(resultList + " - the distance between the outermost places");
            System.out.println(Collections.min(resultList));
        }
    }
}