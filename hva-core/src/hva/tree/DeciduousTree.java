package hva.tree;

import hva.TreeState.DeciduousAutumn;
import hva.TreeState.DeciduousSpring;
import hva.TreeState.DeciduousSummer;
import hva.TreeState.DeciduousWinter;
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
    public DeciduousTree(String id, String name, int age, int cleaningDifficulty, Season currentSeason){
        super(id, name, age, cleaningDifficulty, "CADUCA");
        setStateBasedOnSeason(currentSeason);
    }

    private void setStateBasedOnSeason(Season season) {
        switch (season) {
            case WINTER:
                _state = new DeciduousWinter(this); 
                break;
            case SPRING:
                _state = new DeciduousSpring(this); 
                break;
            case SUMMER:
                _state = new DeciduousSummer(this); 
                break;
            case FALL:
                _state = new DeciduousAutumn(this); 
                break;
            default:
                throw new IllegalStateException("Unexpected season: " + season);
        }
    }

    /**
     * This method returns the details of the DeciduousTree.
     * 
     * @return a string with the details of the tree
     */
    @Override
    public String toString() {
        return super.toString(); 
    }
}
