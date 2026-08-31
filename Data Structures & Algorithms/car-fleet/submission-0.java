class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // position -> speed
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Position ke according ascending order
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<Double> st = new Stack<>();

        // Right -> Left
        for (int i = n - 1; i >= 0; i--) {

            double time = (double)(target - cars[i][0]) / cars[i][1];

            // New fleet
            if (st.isEmpty() || time > st.peek()) {
                st.push(time);
            }

            // time <= st.peek()
            // Same fleet, kuch push nahi karna
        }

        return st.size();
    }
}