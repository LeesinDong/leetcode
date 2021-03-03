class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList<Node> nodes = getNodes(node);
        Map<Node, Node> mapping = new HashMap<>();

        // copy node
        for (Node n: nodes) {
            mapping.put(n, new Node(n.val));
        }

        //copy neighbors
        for (Node orignalNode: nodes) {
            Node newNode = mapping.get(orignalNode);
            // ********************** 把原来node的邻居给了新的node的邻居
            for (Node neighbor: orignalNode.neighbors) {
                Node newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);
    }
    
    public ArrayList<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
        // 题目要求：每个节点值 Node.val 都是唯一的
        // ***************************不能有重复的边
        HashSet<Node> set = new HashSet<Node>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            // 这个是图，即不是一对多直线延伸的关系，不需要一行一行的poll，所以不需要在queue.size().for 里面poll
            //round 1: head = 1, queue is empty, set - > 1
            //round 2: head = 2, queue -> 4, set -> 1,2,4
            // round 3 head = 4 queue -> 3 , set -> 1,2,3,4
            //round 4 head = 3 queue is empty, set -> 1,2,3,4
            Node head = queue.poll();
            // round 1 neighbors = 2, 4
            // after round 1 set 1,2,4   queue 2,4
            // round 2 neighbors 1,3
            // after loop set -> 1,2,3,4 queue 4, 3
            //round 3 neighbors-> 1,3 queue 3
            // round 4 neighbots -> 2,4 , queue is 
            for (Node neighbor: head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<Node>(set);
    }
}