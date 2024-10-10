package hva.tree;

public class EvergreenTree extends Tree{
    private String _type = "PERENE";
    private String _biologicCycle = "GERARFOLHAS";

    /**
     * This is the constructor of the EvergreenTree class.
     * 
     * @param id the unique identifier of the tree
     * @param name the name of the tree
     * @param age the age of the tree
     * @param cleaningDifficulty the difficulty of cleaning the tree
     * @return void
     */
    public EvergreenTree(String id, String name, int age, int cleaningDifficulty){
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
     * @return _type the type of the tree (PERENE)
     */
    public String getType() {
        return _type;
    }

    /**
     * This method returns the details of the EvergreenTree.
     * 
     * @return a string with the details of the tree
     */
    @Override
    public String toString() {
        return "ÁRVORE|" + this.getId() + "|" + this.getName() + "|" + this.getAge() + 
          "|" + this.getDifficulty() + "|" + this.getType() + "|" + this.getCycle();
    }
}