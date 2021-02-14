class LRUCache {

    private class CacheNode{
        private CacheNode prev;
        private CacheNode next;
        private Integer key;
        private Integer value;

        public CacheNode(Integer key, Integer value) {
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }

    private CacheNode head = new CacheNode(-1, -1);
    private CacheNode tail = new CacheNode(-1, -1);
    private Map<Integer, CacheNode> map = new HashMap<>();
    private Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        CacheNode current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        return current.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        CacheNode current = new CacheNode(key, value);
        map.put(key, current);
        moveToTail(current);
    }

    public void moveToTail(CacheNode current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
