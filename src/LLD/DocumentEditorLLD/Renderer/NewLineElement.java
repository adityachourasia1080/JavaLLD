package LLD.DocumentEditorLLD.Renderer;

public class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}