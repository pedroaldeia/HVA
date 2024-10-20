package hva.tree;

import hva.season.Season;

public class DeciduousTree extends Tree{ //WIP

    /**
     * This is the constructor of the DeciduousTree class.
     * 
     * @param id the unique identifier of the tree
     * @param name the name of the tree
     * @param age the age of the tree
     * @param cleaningDifficulty the difficulty of cleaning the tree
     */
    public DeciduousTree(String id, String name, int age, int cleaningDifficulty, Season season){
        super(id, name, age, cleaningDifficulty, "CADUCA", season, "GERARFOLHAS");
    }

    /**
     * This method returns the details of the DeciduousTree.
     * 
     * @return a string with the details of the tree
     */
    @Override
    public String toString() {
        return super.toString(); // FIXME idk if this works, its auto generated
    }

    @Override
    public int getEffort(Season season) {
        return season.getDeciduousEffort(this);
    }

    @Override
    public String getCycle(Season season) {
        return season.getDeciduousBioCycle(this);
    }
}
