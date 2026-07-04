class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
List<List<String>> result = new ArrayList<>();
HashMap<String, List<String>> map = new HashMap<>();
for (String word : strs){
char[] ch = word.toCharArray();
 Arrays.sort(ch);
  String sorted = new String(ch);
 if (map.containsKey(sorted)) {
map.get(sorted).add(word);
} else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sorted, list);
            }
        }
        result.addAll(map.values());

        return result;
    }
}




