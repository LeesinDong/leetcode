 public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<Node, Node>();

        // 第一遍设置映射
        Node newHead = head;
        while (newHead != null) {
            if (!map.containsKey(newHead)) {
                Node node = new Node(newHead.val);
                map.put(newHead, node);
            }
            if (newHead.random != null) {
                Node random = newHead.random;
                if (!map.containsKey(random)) {
                    // 为什么一定要map.containKey? 两个指向一个random，后面的直接覆盖的话，前面的random所指的对象在map中没有了
                    Node copyRandom = new Node(random.val);
                    map.put(random, copyRandom);
                }
                map.get(newHead).random = map.get(random);
            }
            newHead = newHead.next;
        }

        // 第二遍设置next，这里不用newHead也行
        newHead = head;
        while (newHead != null) {
            Node next = newHead.next;
            map.get(newHead).next = map.get(next);
            newHead = newHead.next;
        }

         // *******************
        return map.get(head);
}