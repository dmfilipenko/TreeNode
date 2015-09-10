import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by fill on 9/8/15.
 */
public class NodeTest {
    Node<String> node;
    Node<String> parentNode;
    Node<String> childNode;
    @Before
    public void initObjects() {
        node = new Node<String>("Node value");
        parentNode = new Node<String>("Parent node value");
        childNode = new Node<String>("Child node");
    }
    @Test
    public void testGetValue() throws Exception {
        byte[] expected = "test".getBytes();
        byte[] actual = "test".getBytes();
        String value = node.getValue();
        assertArrayEquals(value, expected, actual);
    }

    @Test
    public void testSetValue() throws Exception {
        node.setValue("test2");
        byte[] expected = "test2".getBytes();
        byte[] actual = "test2".getBytes();
        String value = node.getValue();
        assertArrayEquals(value, expected, actual);
    }

    @Test
    public void testGetParent() throws Exception {
        parentNode.addChildren(childNode);
        String className = childNode.getClass().getSimpleName();
        assertEquals(className, "Node");
    }

    @Test
    public void testSetParent() throws Exception {
        childNode.setParent(parentNode);
        parentNode.setParent(childNode);
        assertEquals(parentNode.getParent().getValue(), childNode.getValue());
    }

    @Test
    public void testAddChildren() throws Exception {
        parentNode.addChildren(childNode);
        String valueChild = parentNode.getChildren().get(0).getValue();
        assertEquals(valueChild, childNode.getValue());
    }
}