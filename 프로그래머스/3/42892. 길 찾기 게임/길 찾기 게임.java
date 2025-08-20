import java.util.*;

class Node implements Comparable<Node> {
    int id, x, y;
    Node right, left;
    
    Node(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Node n) {
        if (this.y == n.y) {
            return this.x - n.x;
        } else {
            return n.y - this.y;
        }
    }
    
    @Override
    public String toString() {
        return id + ": " + x + "," + y;
    }
}

class Solution {
    
    static int index = 0;
    
    void connect(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else connect(parent.left, child);
        } else { 
            if (parent.right == null) parent.right = child;
            else connect(parent.right, child);
        }
    }
    
    void preorder(Node curr, int[][] answer) {
        answer[0][index++] = curr.id;
        
        if (curr.left != null) {
            preorder(curr.left, answer);
        }
        
        if (curr.right != null) {
            preorder(curr.right, answer);
        }        
    }
    
    void postorder(Node curr, int[][] answer) {
        
        if (curr.left != null) {
            postorder(curr.left, answer);
        }
        if (curr.right != null) {
            postorder(curr.right, answer);
        }
        
        answer[1][index++] = curr.id;        
    }
    
    
    public int[][] solution(int[][] nodeinfo) {
        
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        list.sort(Comparator
                  .comparingInt((Node n) -> n.y).reversed()
                  .thenComparingInt(n -> n.x));

        list.forEach(System.out::println);
        
        Node root = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            connect(root, list.get(i));
        }
        
        int[][] answer = new int[2][list.size()];
        
        preorder(root, answer);
        index = 0;
        postorder(root, answer);
        
        return answer;
    }
}