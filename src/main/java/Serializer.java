import java.util.ArrayList;

/**
 * Created by fill on 9/8/15.
 */
public class Serializer {
    public String serialize(Node<?> root){
        ArrayList<Node> children = root.getChildren();
        String value = root.getValue();
        String result = "[" + value;
        for (Node gettedChilder : children) {
            result += serialize(gettedChilder);
        }
        result += "]";
        return result;
    }

    public Node deserialize(String text){
        char[] serializedText = text.trim().toCharArray();
        String value = "";
        Node parentNode = null;
        Node<String> currentNode = null;
        for (char aSerializedText : serializedText) {
            if (aSerializedText == '[' ) {
                value = "";
                currentNode = new Node<String>(value);
                if (parentNode != null) parentNode.addChildren(currentNode);
                parentNode = currentNode;
            } else if (aSerializedText == ']') {
                if (parentNode != null && parentNode.hasParent()) {
                    parentNode = parentNode.getParent();
                }
            } else {
                value+= aSerializedText;
                if (currentNode != null) {
                    currentNode.setValue(value);
                }
            }
        }
        return parentNode;
    }
}
