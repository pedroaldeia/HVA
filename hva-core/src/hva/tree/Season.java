package hva.tree;
import java.io.Serializable;

public abstract class Season implements Serializable{
    protected Tree tree;

    /**
     * This is the constructor of the Season class. WIP
     * 
     * @param tree
     */
    public Season(Tree tree){
        this.tree = tree;
    }
}
