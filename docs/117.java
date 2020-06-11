public Node connect(Node root) {
    if (root == null) return root;
    List<List<Node>> result = new ArrayList<>();
    List<Node> cur_level = new ArrayList<>();
    cur_level.add(root);
    while (cur_level.size() > 0) {
        List<Node> next_level = new ArrayList<>();
        for (Node node : cur_level) {
            if (node.left != null) 
                next_level.add(node.left);
            if (node.right != null) 
                next_level.add(node.right);
        }
        result.add(next_level);
        cur_level = next_level;
    }
    for (List<Node> this_level : result) {
        for (int i = 0; i < this_level.size() - 1; i++) 
            this_level.get(i).next = this_level.get(i + 1);
    }
    return root;
}