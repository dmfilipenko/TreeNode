import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by fill on 9/8/15.
 */
public class SerializerTest {
    Serializer serializer;
    @Before
    public void setUp() throws Exception {
        serializer = new Serializer();

    }

    @Test
    public void testDeserialize() throws Exception {
        String testSerializedString = "[parent[child1][child2[child.child1][child.child2]][child3]]";
        Node<String> deserealizedNode = serializer.deserialize(testSerializedString);
        assertEquals(deserealizedNode.getValue(), "parent");
        ArrayList<Node> children = deserealizedNode.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            String size = Integer.toString(i + 1);
            assertEquals(node.getValue(), "child" + size);
        }
    }
}