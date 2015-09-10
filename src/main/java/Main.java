public class Main {
    public static void main(String[] args){
        Node<String> root = new Node<String>("root");
        Node<String> child1 = new Node<String>("children1");
        Node<String> child2 = new Node<String>("children2");
        Node<String> child3 = new Node<String>("children3");
        Node<String> child21 = new Node<String>("children21");
        Node<String> child31 = new Node<String>("children31");
        Node<String> child41 = new Node<String>("children41");
        child2.addChildren(child21);
        child2.addChildren(child31);
        child31.addChildren(child41);
        root.addChildren(child1);
        root.addChildren(child2);
        root.addChildren(child3);
        Serializer serializer = new Serializer();
        String serialize = serializer.serialize(root);
        Node deserializedNode = serializer.deserialize(serialize);
        String serealizedDeserealized = serializer.serialize(deserializedNode);
        System.out.println(serialize);
        System.out.println(serealizedDeserealized);
    }
    private void serialize(Node node) {

    }
}
