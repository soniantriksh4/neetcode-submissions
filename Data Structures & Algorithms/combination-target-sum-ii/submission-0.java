class Solution {
    public List<List<Integer>> combinationSum2(
        int[] candidates, int target
    ) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, path, result);

        return result;
    }

    private void backtrack(
        int[] candidates,
        int remaining,
        int start,
        List<Integer> path,
        List<List<Integer>> result
    ) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Stop because the array is sorted
            if (candidates[i] > remaining) {
                break;
            }

            // Choose
            path.add(candidates[i]);

            // Explore: each element can be used only once
            backtrack(
                candidates,
                remaining - candidates[i],
                i + 1,
                path,
                result
            );

            // Undo the choice
            path.remove(path.size() - 1);
        }
    }
}