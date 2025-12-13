package LLD.DesignPatterns.CompositeDesignPattern.SolutionWithCompositeDP;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent{

    String directoryName;
    List<FileSystemComponent> childComponents;
    public Directory(String name) {
        this.directoryName = name;
        childComponents = new ArrayList<>();
    }

    @Override
    public void printContents() {
        System.out.println("Directory name: " + directoryName);
        for (FileSystemComponent child : childComponents) {
            child.printContents();
        }

    }

    public void add(FileSystemComponent receipt) {
        childComponents.add(receipt);
    }
}
