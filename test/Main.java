import java.util.Set;
import java.util.TreeSet;


public class Main {

    public static Set<Integer> simmetricalDifference(Set<Integer> lhs, Set<Integer> rhs) {

        Set<Integer> result = new TreeSet<>(rhs);
        
        result.addAll(lhs);
        lhs.retainAll(rhs);

        result.removeAll(lhs);

        return result;
    }

    public static void main(String[] args) {
        
        Set<Integer> lhs = new TreeSet<>();
        lhs.add(1); lhs.add(2); lhs.add(3);

        Set<Integer> rhs = new TreeSet<>();
        rhs.add(0); rhs.add(1); rhs.add(2);

        Set<Integer> set = simmetricalDifference(lhs, rhs);

        for (int s : set) 
            System.out.print(s + " ");
    }
}
