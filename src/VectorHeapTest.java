import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VectorHeapTest {
    @Test
    public void testInsert() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(3);
        heap.add(1);
        heap.add(2);
        assertEquals(1, heap.remove());
    }

    @Test
    public void testRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(3);
        heap.add(1);
        heap.add(2);
        assertEquals(1, heap.remove());
        assertEquals(2, heap.remove());
    }
}
