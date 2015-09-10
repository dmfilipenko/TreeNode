import java.util.ArrayList;

public class Node<T> {
    private T value;
    private ArrayList<Node> children = new ArrayList<Node>();
    private Node parent;

    public Node(T value) {
        this.setValue(value);
    }

    public String getValue() {
        return value.toString();
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addChildren(Node childrens) {
        childrens.setParent(this);
        children.add(childrens);
    }

    public boolean hasChildren() {
        return children.size() > 0;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
}