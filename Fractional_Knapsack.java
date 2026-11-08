import java.util.*;

class Fractional_Knapsack {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));
        for (int i = 0; i < n; i++) {
            double ratio = (double) val[i] / wt[i];
            maxHeap.add(new double[]{val[i], wt[i], ratio});
        }
        double profit = 0;
        while (!maxHeap.isEmpty() && capacity > 0) {
            double[] item = maxHeap.poll();
            double value = item[0];
            double weight = item[1];
            if (weight <= capacity) {

                profit += value;
                capacity -= (int) weight;
            } else {

                profit += (value / weight) * capacity;
                capacity = 0;
            }
        }

        return profit;
    }
}