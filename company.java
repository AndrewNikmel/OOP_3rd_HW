import java.util.Iterator;
import java.lang.Iterable;

public class company implements Iterable{

    private soldier head;
    private soldier tail;
    private int count = 0;

    @Override
    public Iterator iterator() {
        return new Iterator<Object>() {
            soldier soldier0 = new soldier("0");
            {
                soldier0.setNext(head);
            }
            soldier currentSoldier = soldier0;

            @Override
            public boolean hasNext() {
                return currentSoldier.getNext() != null;
            }

            @Override
            public Object next() {
                currentSoldier = currentSoldier.getNext();
                return currentSoldier.getData();
            }
        };
    }

    public int size() {
        return count;
    }

    private soldier getSoldier(int index){
        if (index >= count){
            throw new IndexOutOfBoundsException();
        }

        soldier result = head;
        for (int i = 1; i <= index; i++){
            result = result.getNext();
        }
        return result;
    }

    public Object get(int index){

        soldier soldier = getSoldier(index);

        return soldier.getData();
    }

    public void remove(int index){

        soldier currentSoldier = getSoldier(index);
        soldier nextSoldier = currentSoldier.getNext();
        soldier previousSoldier = currentSoldier.getPrevious();

        if (index == 0){
            head = nextSoldier;
            if (tail == currentSoldier){
                tail = null;
            }
        }

        if (index == count - 1){
            tail = previousSoldier;
            if (head == currentSoldier){
                head = null;
            }
        }

        count--;

        if (nextSoldier != null){
            nextSoldier.setPrevious(previousSoldier);
        }

        if (previousSoldier != null){
            previousSoldier.setNext(nextSoldier);
        }

    }

    public void add(int index, Object data){
        if (count == index){
            add(data);
            return;
        }
        count++;

        soldier currentsSoldier = new soldier(data);

        if (index == 0){
            head = currentsSoldier;
        }

        soldier nextsSoldier = getSoldier(index);
        soldier previousSoldier = nextsSoldier.getPrevious();

        currentsSoldier.setNext(nextsSoldier);
        currentsSoldier.setPrevious(previousSoldier);

        if (previousSoldier != null) {
            previousSoldier.setNext(currentsSoldier);
        }

    }

    public void add(Object data){
        count++;
        soldier soldier = new soldier(data);
        if (head == null){
            head = soldier;
            tail = soldier;
            return;
        } else if (tail == null) {
            tail = soldier;
            return;
        }

        tail.setNext(soldier);
        soldier.setPrevious(tail);
        tail = soldier;
    }

}