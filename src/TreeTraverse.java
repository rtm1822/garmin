import java.util.ArrayList;
import java.util.List;

public class TreeTraverse {
    public static void main(String[] args) {

        //Obtain the starting node from the setup
        Node root = setup();

        //Find our target node by traversing the tree via DFS
        Node result = traverse(root, "FindMe");
    }

    /**
     * Traverse a tree searching for a target name
     * When the target name is found, stop searching
     * @param node - current node to be searched
     * @param target - target name
     * @return - The node with our target name
     */
    public static Node traverse(Node node, String target){
        //Print the current node name
        System.out.println(node.getName());

        //If we encounter the node with the target name, stop and return the node
        if (node.getName().equals(target)) {
            return node;

        //Else if the node has no children return null (marking that our node is not found)
        } else if (node.getChildren() == null || node.getChildren().size() == 0) {
            return null;
        }

        //For each child node, we want to traverse it recursively
        for (Node n: node.getChildren()) {
            //Traverse the subtree to search for our target node
            Node subTreeHasTargetNode = traverse(n, target);

            //If our subtree traversal was successful in finding the target node, we can stop and return the node
            //Otherwise we want to keep iterating over all the child nodes
            if(subTreeHasTargetNode != null){
                return subTreeHasTargetNode;
            }
        }
        //If all the children failed to find our node, return null (i.e. subtree does not contain our desired node)
        return null;
    }

    /**
     * Setup for the coding exercise
     * @return start node
     */
    public static Node setup(){
        Node findMe = new Node("FindMe", null);
        Node c1 = new Node("c1", null);
        Node b1 = new Node("b1", new ArrayList<>() {{add(findMe);}});
        Node b2 = new Node("b2", new ArrayList<>(){{add(c1);}});

        Node a2 = new Node("a2", new ArrayList<>(){{add(b1); add(b2);}});

        Node e1 = new Node("e1", null);
        Node d1 = new Node("d1", new ArrayList<>(){{add(e1);}});
        Node a1 = new Node("a1", new ArrayList<>(){{add(d1);}});

        Node root = new Node("Start", new ArrayList<>(){{add(a1); add(a2);}});

        return root;
    }
}

/**
 * Node object structure
 */
class Node {

    //A node has a name and a list of children
    public String name;
    public List<Node> children;

    public Node(String name, List<Node> children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
