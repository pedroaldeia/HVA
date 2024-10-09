package hva.tree;

import java.io.Serializable;

public class EvergreenTree extends Tree implements Serializable{
    private String _type = "PERENE";
    private String _biologicCycle = "GERARFOLHAS";

    public EvergreenTree(String id, String name, int age, int cleaningDifficulty){
        super(id, name, age, cleaningDifficulty);
    }

    public String getDifficulty() {
        return "" + _cleaningDifficulty;
    }

    public String getAge() {
        return "" + _age;
    }

    public String getCycle() {
        return _biologicCycle;
    }

    public String getType() {
        return _type;
    }

    @Override
    public String toString() {
        return "ÁRVORE|" + this.getId() + "|" + this.getName() + "|" + this.getAge() + "|" 
            + this.getDifficulty() + "|" + this.getType() + "|" + this.getCycle();
    }
}