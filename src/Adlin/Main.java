package Adlin;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();

    }

    public static void task1() {
        SocialNetworkGraph network = new SocialNetworkGraph();

        // Add users
        network.addUser("A");
        network.addUser("B");
        network.addUser("C");
        network.addUser("D");
        network.addUser("E");
        network.addUser("F");
        network.addUser("G");
        network.addUser("H");
        network.addUser("I");

        // Add friendships
        network.addFriendship("A", "B");
        network.addFriendship("A", "C");
        network.addFriendship("B", "D");
        network.addFriendship("B", "E");
        network.addFriendship("C", "F");
        network.addFriendship("D", "G");
        network.addFriendship("E", "H");
        network.addFriendship("F", "I");

        // Perform BFS and DFS starting from user A
        network.bfs("A");
        network.dfs("A");
        System.out.println();
    }

    public static void task2() {
        EmployeeTree hierarchy = new EmployeeTree();
        hierarchy.add("CEO");
        hierarchy.setLeftChild("CEO","Manager1");
        hierarchy.setRightChild("CEO","Manager2");
        hierarchy.setLeftChild("Manager1","Employee1");
        hierarchy.setRightChild("Manager1","Employee2");
        hierarchy.setLeftChild("Manager2","Employee3");
        hierarchy.setRightChild("Manager1","Employee4");

        // Task 1: Find Maximum Depth
        System.out.println("Maximum Depth: " + hierarchy.findMaxDepth("CEO"));

        // Task 2: List Employees by Level
        System.out.println("Employees by Level:");
        hierarchy.listEmployeesByLevel();

        // Task 3: Find a Specific Employee
        String searchName = "Employee3";
        System.out.println("Is " + searchName + " in the hierarchy? " + hierarchy.findEmployee("CEO", searchName));
        System.out.println();
    }

     public static void task3() {
         ProjectTree tree = new ProjectTree();
         tree.addMainProject("MainProject");
         tree.setLeftSubProject("MainProject","SubProject1");
         tree.setRightSubProject("MainProject","SubProject2");
         tree.setLeftSubProject("SubProject1","SubSubProject1");
         tree.setRightSubProject("SubProject1","SubSubProject2");
         tree.setLeftSubProject("SubProject2","SubSubProject3");
         System.out.println("Total: " + tree.countTotalProjects("MainProject"));

         List<String> path = new ArrayList<>();
         List<String> longestPath= new ArrayList<>();
         tree.findLongestPath("MainProject", path, longestPath);
         System.out.println("Longest path: " + longestPath);

         List<String> leafProject = new ArrayList<>();
         tree.findAllLeafProjects("MainProject", leafProject);
         System.out.println("Leaf projects: " + leafProject);

         ProjectTree tree2 = new ProjectTree();
         tree2.addMainProject("MainProject");
         tree2.setLeftSubProject("MainProject","SubProject1");
         tree2.setRightSubProject("MainProject","SubProject2");
         tree2.setLeftSubProject("SubProject1","SubSubProject1");
         tree2.setLeftSubProject("SubSubProject1","SubSubSubProject1");
         tree2.setLeftSubProject("SubProject2","SubSubProject3");
         tree2.setRightSubProject("SubProject2","SubSubProject4");
         System.out.println("Total: " + tree2.countTotalProjects("MainProject"));

         List<String> path2 = new ArrayList<>();
         List<String> longestPath2 = new ArrayList<>();
         tree2.findLongestPath("MainProject", path2, longestPath2);
         System.out.println("Longest path: " + longestPath2);

         List<String> leafProject2 = new ArrayList<>();
         tree2.findAllLeafProjects("MainProject", leafProject2);
         System.out.println("Leaf projects: " + leafProject2);

     }
}
