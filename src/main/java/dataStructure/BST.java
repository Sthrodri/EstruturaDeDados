package dataStructure;

public class BST {

    public Node root;

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(final Node root, final int value){
        if (root == null) return;
        if (value == root.value) return;
        if (value > root.value){
            if (root.right == null) root.right = new Node(value);
            else insert(root.right, value);
        } else {
            if (root.left == null) root.left = new Node(value);
            else insert(root.left, value);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(final Node node){
        if (node != null){
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }

    public boolean contains(int value){
        return contains(root, value);
    }
    private boolean contains(final Node node, final int value){
        if (node == null) return false;
        if (node.value == value) return true;
        if (node.value > value) return (contains(node.right, value));
        else return (contains(node.left, value));
    }

    public int minValue (Node currentNode){
        while (currentNode != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value){
        root = deleteNode(root, value);
    }


    private Node deleteNode (final Node node, final int value){
        if (node == null) return null;

        if (value < node.value){
            node.left = deleteNode(node.left, value);
        } else if (value > node.value){
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null && node.right == null){
                return null;
            } else if (node.left == null){
                return node.right;
            } else if (node.right == null){
                return node.left;
            } else {
                int minValue = minValue(node.right);
                node.value = minValue;
                node.right = deleteNode(node.right, minValue);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        System.out.println(tree.contains(11));
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(3));
        tree.deleteNode(3);
        tree.inOrder();
    }
}
