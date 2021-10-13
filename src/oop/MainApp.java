// ArrayList exercise solutions

package oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        MainApp app = new MainApp();
        app.start();
    }

    public void start() {
        p6_28();
    }

    public void p6_28() {
            /* Write a method
            public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a,
            ArrayList<Integer> b)
            that merges two sorted array lists, producing a new sorted array list. Keep an index
            into each array list, indicating how much of it has been processed already. Each time,
            append the smallest unprocessed element from either array list, then advance the
            index. For example, if a is
            1  4  9  16
            and b is
            4  7  9  9  11
            then mergeSorted returns the array list
            1  4  4  7  9  9  9  11  16

         */
        Scanner input = new Scanner(System.in);

        ArrayList<Integer> firstArrayList = new ArrayList<>( Arrays.asList(4, 7, 9, 9, 11) );

        ArrayList<Integer> secondArrayList = new ArrayList<>( Arrays.asList(1, 4, 4, 7, 9, 9, 9, 11, 16) );

        ArrayList<Integer> mergedArrayList = mergeSorted(firstArrayList, secondArrayList);

        for (Integer x : mergedArrayList) {
            System.out.print(x + ",");
        }
    }

    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> newArrayList = new ArrayList<>();

        while (a.size() > 0 || b.size() > 0) {
            if (a.size() > 0 && b.size() > 0) {
                if (a.get(0) < b.get(0)) {
                    newArrayList.add(a.get(0));
                    a.remove(a.get(0));
                } else if (b.get(0) < a.get(0)) {
                    newArrayList.add(b.get(0));
                    b.remove(b.get(0));
                } else {
                    newArrayList.add(a.get(0));
                    a.remove(a.get(0));
                    newArrayList.add(b.get(0));
                    b.remove(b.get(0));
                }
            } else if (a.size() == 0) {
                newArrayList.add(b.get(0));
                b.remove(b.get(0));
            } else if (b.size() == 0) {
                newArrayList.add(a.get(0));
                a.remove(a.get(0));
            }
        }

        return newArrayList;
    }
}

