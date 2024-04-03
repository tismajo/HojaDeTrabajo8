import java.util.ArrayList;

class VectorHeap<T extends Comparable<T>> {
    private ArrayList<T> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    public void add(T item) {
        data.add(item);
        percolateUp(data.size() - 1);
    }

    public T remove() {
        if (data.isEmpty()) {
            return null;
        }
        T minItem = data.get(0);
        T lastItem = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, lastItem);
            percolateDown(0);
        }
        return minItem;
    }

    private void percolateUp(int index) {
        T newItem = data.get(index);
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T parentItem = data.get(parentIndex);
            if (newItem.compareTo(parentItem) >= 0) {
                break;
            }
            data.set(index, parentItem);
            index = parentIndex;
        }
        data.set(index, newItem);
    }

    private void percolateDown(int index) {
        T newItem = data.get(index);
        int childIndex;
        while ((childIndex = 2 * index + 1) < data.size()) {
            if (childIndex < data.size() - 1 && data.get(childIndex).compareTo(data.get(childIndex + 1)) > 0) {
                childIndex++;
            }
            if (newItem.compareTo(data.get(childIndex)) <= 0) {
                break;
            }
            data.set(index, data.get(childIndex));
            index = childIndex;
        }
        data.set(index, newItem);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
