import java.util.Iterator;

public class mainApp {
    public static void main(String[] args) {

        company list = new company();
        list.add("data1");
        list.add("data2");

        list.add(1, "data2_1");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String soldier = iterator.next();
            System.out.println(soldier);
        }
    }

}