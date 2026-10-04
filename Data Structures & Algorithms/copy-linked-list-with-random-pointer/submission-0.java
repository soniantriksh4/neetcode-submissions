class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        // Step 1: Create a copy of every node
        Node current = head;

        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Step 2: Connect next and random pointers
        current = head;

        while (current != null) {

            map.get(current).next = map.get(current.next);

            map.get(current).random = map.get(current.random);

            current = current.next;
        }

        // Step 3: Return copied head
        return map.get(head);
    }
}