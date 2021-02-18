class LRUCache {
    private class CacheNode {
        CacheNode prev;
        CacheNode next;
        int key;
        int value;
        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            // *************
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, CacheNode> valNodeMap = new HashMap();
    private CacheNode head = new CacheNode(-1, -1);
    private CacheNode tail = new CacheNode(-1, -1);

    // capacity 有几个
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // ***********
        tail.prev = head;
        head.next = tail;
    }

    // get、put每次都是 1.操作map 2.操作链表
    public int get(int key) {
        if (!valNodeMap.containsKey(key)) {
            return -1;
        }
        CacheNode current = valNodeMap.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        return valNodeMap.get(key).value;
    }
    
    public void put(int key, int value) {
        // *************************get(key)
        if (get(key) != -1) {
            valNodeMap.get(key).value = value;
            // **************************return别忘
            return;
        }

        // 移除最前面的
        if (valNodeMap.size() == capacity) {
            valNodeMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        // 添加新的
        CacheNode insert = new CacheNode(key, value);
        valNodeMap.put(key, insert);
        moveToTail(insert);
    }
    
    private void moveToTail(CacheNode current) {
        // 先pre
        current.prev = tail.prev;
        tail.prev = current;
        // **************************** current.prev
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