package LLD.DocumentEditorLLD;

import LLD.DocumentEditorLLD.Elements.DocumentElement;

import java.util.ArrayList;
import java.util.List;

class Document {
    private List<DocumentElement> documentElements;

    public Document(){
        documentElements = new ArrayList<>();
    }

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    public void removed(int startRow,int endRow){
        //you can remove thing from document Element
    }

    public void clearDoc(){
        documentElements.clear();
    }


    // Renders the document by concatenating the render output of all elements.
    public String render() {
        StringBuilder result = new StringBuilder();
        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }
        return result.toString();
    }
}