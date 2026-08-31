class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!st.isEmpty() &&
                   heights[i] < heights[st.peek()]) {

                int height = heights[st.pop()];

                int width;

                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        // Remaining elements
        while (!st.isEmpty()) {

            int height = heights[st.pop()];

            int width;

            if (st.isEmpty()) {
                width = heights.length;
            } else {
                width = heights.length - st.peek() - 1;
            }

            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}