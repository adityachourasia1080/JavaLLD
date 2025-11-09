package LLD.DocumentEditorLLD.Elements;

public class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}