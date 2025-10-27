package LLD.DocumentEditorLLD;

import LLD.DocumentEditorLLD.Renderer.ImageElement;
import LLD.DocumentEditorLLD.Renderer.NewLineElement;
import LLD.DocumentEditorLLD.Renderer.TabSpaceElement;
import LLD.DocumentEditorLLD.Renderer.TextElement;
import LLD.DocumentEditorLLD.Storage.Persistence;

class DocumentEditor {
    private Document document;
    private Persistence storage;
    private String renderedDocument = "";

    public DocumentEditor(Document document, Persistence storage) {
        this.document = document;
        this.storage = storage;
    }

    public void addText(String text) {
        document.addElement(new TextElement(text));
    }

    public void addImage(String imagePath) {
        document.addElement(new ImageElement(imagePath));
    }

    // Adds a new line to the document.
    public void addNewLine() {
        document.addElement(new NewLineElement());
    }

    // Adds a tab space to the document.
    public void addTabSpace() {
        document.addElement(new TabSpaceElement());
    }

    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            renderedDocument = document.render();
        }
        return renderedDocument;
    }

    public void saveDocument() {
        storage.save(renderDocument());
    }
}
