import java.util.*;

class Node {
    int id, x, y;
    Node left, right;
    
    Node(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return id + ": " + x + "," + y;
    }
}

class Solution {
    static int index = 0;
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        nodes.sort(Comparator
                   .comparingInt((Node node) -> node.y).reversed()            
        );

        nodes.stream()
            .skip(1)
            .forEach(curr -> connectNode(nodes.get(0), curr));
        
        int[][] answer = new int[2][nodes.size()];
        
        index = 0;
        preorder(nodes, answer, nodes.get(0));
        Arrays.stream(answer[0]).forEach(e -> System.out.print(e + " "));
        
        index = 0;
        postorder(nodes, answer, nodes.get(0));
        Arrays.stream(answer[1]).forEach(e -> System.out.print(e + " "));
        
        return answer;
    }
    
    void connectNode(Node parent, Node child) {
        if (parent.x < child.x) {
            if (parent.right == null) {
                parent.right = child;
            } else {
                connectNode(parent.right, child);
            }
        } else {
            if (parent.left == null) {
                parent.left = child;
            } else {
                connectNode(parent.left, child);
            }
        }    
    }
    
    void preorder(List<Node> nodes, int[][] answer, Node curr) {
        if (curr == null) return;
        
        answer[0][index++] = curr.id;
        preorder(nodes, answer, curr.left);
        preorder(nodes, answer, curr.right);            
    }
    
    void postorder(List<Node> nodes, int[][] answer, Node curr) {
        if (curr == null) return;
        
        postorder(nodes, answer, curr.left);
        postorder(nodes, answer, curr.right);            
        answer[1][index++] = curr.id;
    }
}