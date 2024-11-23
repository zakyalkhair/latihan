package Adlin;
import java.util.*;
class ProjectTree {
    private Map<String, ProjectNode> nodeMap;
    private String rootName;

    ProjectTree(){
        nodeMap = new HashMap<>();
        rootName = null;
    }
    public void addMainProject(String name) {
        ProjectNode headNode = new ProjectNode(name);
        headNode.setName(name);
        nodeMap.put(name, new ProjectNode(name));
        if (rootName == null){
            rootName = name;
        }
    }

    public void setLeftSubProject(String parentName, String subProjectName) {
        ProjectNode parentNode = nodeMap.get(parentName);
        parentNode.setLeftSubProjectName(subProjectName);
        nodeMap.put(subProjectName, new ProjectNode(subProjectName));
    }

    public void setRightSubProject(String parentName, String subProjectName) {
        ProjectNode parentNode = nodeMap.get(parentName);
        parentNode.setRightSubProjectName(subProjectName);
        nodeMap.put(subProjectName, new ProjectNode(subProjectName));
    }

    public int countTotalProjects(String nodeName) {
        if (nodeName == null || !nodeMap.containsKey(nodeName)) return 0;
        ProjectNode headNode = nodeMap.get(nodeName);
        int leftTotal= countTotalProjects(headNode.getLeftSubProjectName());
        int rightTotal= countTotalProjects(headNode.getRightSubProjectName());
        return 1 + leftTotal + rightTotal;
    }
    public void findLongestPath(String nodeName, List<String> path, List<String> longestPath) {
        if (nodeName == null || !nodeMap.containsKey(nodeName)) return;
        path.add(nodeName);
        ProjectNode headNode = nodeMap.get(nodeName);
        if (headNode.getLeftSubProjectName() == null && headNode.getRightSubProjectName() == null) {
            if (path.size() > longestPath.size()) {
                longestPath.clear();
                longestPath.addAll(path);
            }
        } else {
            findLongestPath(headNode.getLeftSubProjectName(), path, longestPath);
            findLongestPath(headNode.getRightSubProjectName(), path, longestPath);
        }
        path.remove(path.size() - 1);
    }
    public void findAllLeafProjects(String nodeName, List<String> leafProjects){
        if (nodeName == null || !nodeMap.containsKey(nodeName)) return;
        ProjectNode headNode = nodeMap.get(nodeName);
        if (headNode.getLeftSubProjectName() == null && headNode.getRightSubProjectName() == null) {
            leafProjects.add(nodeName);
        } else {
            findAllLeafProjects(headNode.getLeftSubProjectName(), leafProjects);
            findAllLeafProjects(headNode.getRightSubProjectName(),leafProjects);
        }

    }

}
