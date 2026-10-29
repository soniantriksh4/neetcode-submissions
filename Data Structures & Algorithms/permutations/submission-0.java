class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        backtrack(nums, path, used, result);

        return result;
    }

    private void backtrack(
        int[] nums,
        List<Integer> path,
        boolean[] used,
        List<List<Integer>> result
    ) {
        // Base case
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Try every element
        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            // Choose
            path.add(nums[i]);
            used[i] = true;

            // Explore
            backtrack(nums, path, used, result);

            // Undo the choice
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}