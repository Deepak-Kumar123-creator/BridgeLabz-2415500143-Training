// File Name: DirectorySizeCalculator.java

import java.util.*;

class FileNode {
    String name;
    int size; // size in KB (only for files)
    boolean isFile;
    List<FileNode> children;

    // Constructor for file
    FileNode(String name, int size) {
        this.name = name;
        this.size = size;
        this.isFile = true;
        this.children = null;
    }

    // Constructor for directory
    FileNode(String name) {
        this.name = name;
        this.isFile = false;
        this.children = new ArrayList<>();
    }

    void addChild(FileNode node) {
        if (!isFile) {
            children.add(node);
        }
    }
}

public class DirectorySizeCalculator {

    // Recursive Function
    public static int calculateSize(FileNode node) {

        // Base Case: If it is a file
        if (node.isFile) {
            return node.size;
        }

        // Recursive Case: Directory
        int totalSize = 0;
        for (FileNode child : node.children) {
            totalSize += calculateSize(child);
        }

        return totalSize;
    }

    public static void main(String[] args) {

        // Creating directory structure
        FileNode project = new FileNode("project");

        FileNode src = new FileNode("src");
        src.addChild(new FileNode("main.java", 100));
        src.addChild(new FileNode("utils.java", 50));

        FileNode docs = new FileNode("docs");
        docs.addChild(new FileNode("readme.txt", 10));

        FileNode guides = new FileNode("guides");
        guides.addChild(new FileNode("setup.pdf", 200));
        docs.addChild(guides);

        project.addChild(src);
        project.addChild(docs);
        project.addChild(new FileNode("config.xml", 20));

        int total = calculateSize(project);

        System.out.println("Total Directory Size = " + total + " KB");
    }
}
