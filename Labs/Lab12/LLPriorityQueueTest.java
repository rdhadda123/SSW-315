import static org.junit.Assert.*;

import org.junit.Test;

public class LLPriorityQueueTest {

        @Test
	void testEnqueueNegative() {
                LLPriorityQueue list = new LLPriorityQueue<>(null, null);
                Node node1 = new Node<>(-1, -1);
                Node node2 = new Node<>(-2, 2);
                Node node3 = new Node<>(-3, 3);
                Node node4 = new Node<>(-4, -4);
                
                list.enqueue(node1);
                list.enqueue(node2);
                list.enqueue(node3);
                list.enqueue(node4);
                
                assertEquals(list.getHead(), node3);
	}

        @Test
	void testEnqueuePositive() {
                LLPriorityQueue list = new LLPriorityQueue<>(null, null);
                Node node1 = new Node<>(1, 1);
                Node node2 = new Node<>(2, 2);
                Node node3 = new Node<>(3, 3);
                Node node4 = new Node<>(4, 4);
                
                list.enqueue(node1);
                list.enqueue(node2);
                list.enqueue(node3);
                list.enqueue(node4);
                
                assertEquals(list.getHead(), node4);
	}

        @Test
	void testDequeueNegative() {
                LLPriorityQueue list = new LLPriorityQueue<>(null, null);
                Node node1 = new Node<>(-1, -1);
                Node node2 = new Node<>(-2, 2);
                Node node3 = new Node<>(-3, 3);
                Node node4 = new Node<>(-4, -4);
                
                list.dequeue();
                
                assertEquals(list.getHead(), node2);
	}

        @Test
	void testDequeuePositive() {
                LLPriorityQueue list = new LLPriorityQueue<>(null, null);
                Node node1 = new Node<>(1, 1);
                Node node2 = new Node<>(2, 2);
                Node node3 = new Node<>(3, 3);
                Node node4 = new Node<>(4, 4);
                
                list.dequeue();
                
                assertEquals(list.getHead(), node3);
	}

        @Test
	void testGetSize() {
                LLPriorityQueue list = new LLPriorityQueue<>(null, null);
                Node node1 = new Node<>(-1, -1);
                Node node2 = new Node<>(-2, 2);
                Node node3 = new Node<>(-3, 3);
                Node node4 = new Node<>(-4, -4);
                
                list.enqueue(node1);
                list.enqueue(node2);
                list.enqueue(node3);
                list.enqueue(node4);
                list.dequeue();
                
                assertEquals(list.getSize(), 3);
	}

        @Test
	void testGetSize2() {
                LLPriorityQueue list = new LLPriorityQueue<>(null, null);
                Node node1 = new Node<>(1, 1);
                
                list.enqueue(node1);
                list.dequeue();
                
                assertEquals(list.getSize(), 0);
	}
}
