package hva.tree;

public class DeciduousTree extends Tree{ //WIP
    private String _type = "CADUCA";
    private String _biologicCycle = "GERARFOLHAS";

    /**
     * This is the constructor of the DeciduousTree class.
     * 
     * @param id the unique identifier of the animal
     * @param name the name of the animal 
     * @param age the age of the tree
     * @param cleaningDifficulty the difficulty of cleaning the tree
     * @return void
     */
    public DeciduousTree(String id, String name, int age, int cleaningDifficulty){
        super(id, name, age, cleaningDifficulty);
    }

    /**
     * This method returns the difficulty of cleaning the tree.
     * 
     * @return _cleaningDifficulty the difficulty of cleaning the tree
     */
    public String getDifficulty() {
        return "" + _cleaningDifficulty;
    }

    /**
     * This method returns the age of the tree.
     * 
     * @return _age the age of the tree
     */
    public String getAge() {
        return "" + _age;
    }

    /**
     * This method returns the biologic cycle state of the tree.
     * 
     * @return _biologicCycle the biologic cycle state of the tree
     */
    public String getCycle() {
        return _biologicCycle;
    }

    /**
     * This method returns the type of the tree.
     * 
     * @return _type the type of the tree (CADUCA)
     */
    public String getType() {
        return _type;
    }

    /**
     * This method returns the details of the DeciduousTree.
     * 
     * @return a string with the details of the tree
     */
    @Override
    public String toString() {
        return "ÁRVORE|" + this.getId() + "|" + this.getName() + "|" + this.getAge() + "|"
            + this.getDifficulty() + "|" + this.getType() + "|" + this.getCycle();
    }
}
