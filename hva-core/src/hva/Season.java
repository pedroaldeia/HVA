package hva;
import java.io.Serializable;

public abstract class Season implements Serializable{
    protected Tree tree;

    public Season(Tree tree){
        this.tree = tree;
    }
}
