
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Fruit> implements Iterable<T> {

    private List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        if (fruits.isEmpty()) {
            fruits.add(fruit);
        } else {
            T firstFruit = fruits.get(0);
            if (firstFruit.getClass() == fruit.getClass()) {
                fruits.add(fruit);
            } else {
                throw new IllegalArgumentException("Cannot add " + fruit.getClass().getSimpleName() + " to box of " + firstFruit.getClass().getSimpleName());
            }
        }
    }

    public int getWeight() {
        int totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public void moveTo(Box<? super T> target) {
        if (fruits.isEmpty()) {
            return;
        }
        if (target.fruits.isEmpty()) {
            target.fruits.addAll(fruits);
            fruits.clear();
        } else {
            T firstFruit = fruits.get(0);
            if (firstFruit.getClass() == target.fruits.get(0).getClass()) {
                target.fruits.addAll(fruits);
                fruits.clear();
            } else {
                throw new IllegalArgumentException("Cannot move " + firstFruit.getClass().getSimpleName() + " to box of " + target.fruits.get(0).getClass().getSimpleName());
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return fruits.iterator();
    }
}

