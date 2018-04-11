package org.donald.duck.algorithms.chapter1;

import org.donald.duck.util.In;
import org.donald.duck.util.StdIn;
import org.donald.duck.util.StdOut;

public class Whitelist {

    // Do not instantiate.
    private Whitelist() { }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] white = in.readAllInts();
        StaticSETofInts set = new StaticSETofInts(white);

        // Read key, print if not in whitelist.
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (!set.contains(key))
                StdOut.println(key);
        }
    }
}