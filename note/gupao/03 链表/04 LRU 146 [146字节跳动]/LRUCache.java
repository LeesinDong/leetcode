class LRUCache {

    // 本质：map list
    private class CacheNode {
        int key;
        int value;

        CacheNode prev;
        CacheNode next;
        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;

            this.prev = null;
            this.next = null;
        }
    }

    private int size;
    private Map<Integer, CacheNode> valNodeMap;
    private CacheNode head;
    private CacheNode tail;

    // capacity 有几个
    public LRUCache(int size) {
        this.size = size;

        valNodeMap = new HashMap();

        head = new CacheNode(-1, -1);
        tail = new CacheNode(-1, -1);
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!valNodeMap.containsKey(key)) {
            return -1;
        }

        // 1 更新 链表 最近用的
        // 删掉这个节点
        CacheNode current = valNodeMap.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        // 插入队尾
        moveToTail(current);

        // 2 返回 map 结果
        return valNodeMap.get(key).value;
    }

    public void put(int key, int value) {
        // 1 如果已经有了，更新数据即可。
        // 因为get已经放入了队尾，所以可以直接return，不需要在moveToTail
        if (get(key) != -1) {
            valNodeMap.get(key).value = value;
            return;
        }

        // 2 满了 删掉头结点  map list
        if (valNodeMap.size() == size) {
            valNodeMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        // 3 添加到最后面-新的 map list
        CacheNode insert = new CacheNode(key, value);
        valNodeMap.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(CacheNode current) {
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