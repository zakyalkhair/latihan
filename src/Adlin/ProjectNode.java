package Adlin;

class ProjectNode {
    private String name;
    private String leftSubProjectName;
    private String rightSubProjectName;

    public ProjectNode(String name){
        this.name = name;

    }
    public String getName() {
        return name;
    }
    public String getLeftSubProjectName() {
        return leftSubProjectName;
    }
    public String getRightSubProjectName() {
        return rightSubProjectName;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLeftSubProjectName(String leftSubProjectName) {
        this.leftSubProjectName = leftSubProjectName;
    }

    public void setRightSubProjectName(String rightSubProjectName) {
        this.rightSubProjectName = rightSubProjectName;
    }

}