import java.util.*;

class ThroneInheritance {
    // A nested class representing each person in the tree
    private static class Person {
        String name;
        List<Person> children;
        boolean isAlive;

        Person(String name) {
            this.name = name;
            this.children = new ArrayList<>();
            this.isAlive = true;
        }
    }

    private final Person king;
    // Map to find any person in O(1) time
    private final Map<String, Person> familyMap;

    public ThroneInheritance(String kingName) {
        this.king = new Person(kingName);
        this.familyMap = new HashMap<>();
        this.familyMap.put(kingName, king);
    }
    
    public void birth(String parentName, String childName) {
        Person parent = familyMap.get(parentName);
        Person child = new Person(childName);
        parent.children.add(child);
        familyMap.put(childName, child);
    }
    
    public void death(String name) {
        if (familyMap.containsKey(name)) {
            familyMap.get(name).isAlive = false;
        }
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        preOrder(king, order);
        return order;
    }

    // Helper method to perform Pre-order DFS traversal
    private void preOrder(Person current, List<String> order) {
        if (current.isAlive) {
            order.add(current.name);
        }
        for (Person child : current.children) {
            preOrder(child, order);
        }
    }
}
