import java.util.Iterator;

public class mainApp {
    public static void main(String[] args) {

        company list = new company();
        list.add("private Ivanov");
        list.add("private 1st class Smirnov");
        list.add("sergeant Semenov");
        list.add("sergeant 1st class Mirov");
        list.add("liuetenant Gerasimov");
        list.add(1, "private Ivanov");
        list.add(2, "private 1st class Smirnov");
        list.add(3, "sergeant Semenov");
        list.add(4, "sergeant 1st class Mirov");
        list.add(5, "liuetenant Gerasimov");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String soldier = iterator.next();
            System.out.println(soldier);
        }
    }

}