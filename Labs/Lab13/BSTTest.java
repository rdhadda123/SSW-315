import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class BSTTest{

    @Test
    public void testInsert(){
        BST<Integer> tree = new BST<Integer>();
        tree.insert(45);
        tree.insert(54);
        tree.insert(67);
        tree.insert(56);
        tree.insert(50);
        tree.insert(45);
        tree.insert(23);
        tree.insert(59);
        tree.insert(23);
        tree.insert(67);

        assertEquals(9, tree.getSize());
    }

    @Test
    public void testDelete(){
        BST<Integer> tree = new BST<Integer>();
        tree.insert(45);
        tree.insert(54);
        tree.insert(67);
        tree.insert(56);
        tree.insert(50);
        tree.insert(45);
        tree.insert(23);
        tree.insert(59);
        tree.insert(23);
        tree.insert(67);

        tree.delete(45);
        assertEquals(8, tree.getSize());
    }

    @Test
    public void testGetNode(){
        BST<Integer> tree = new BST<Integer>();
        tree.insert(45);
        tree.insert(54);
        tree.insert(67);
        tree.insert(56);
        tree.insert(50);
        tree.insert(45);
        tree.insert(23);
        tree.insert(59);
        tree.insert(23);
        tree.insert(67);

        assertEquals(null, tree.getNode(0));
    }

    @Test
    public void testIsLeaf(){
        BST<Integer> tree = new BST<Integer>();
        tree.insert(45);
        tree.insert(54);
        tree.insert(67);
        tree.insert(56);
        tree.insert(50);
        tree.insert(45);
        tree.insert(23);
        tree.insert(59);
        tree.insert(23);
        tree.insert(67);

        assertEquals(false, tree.isLeaf(45));
    }
}
    