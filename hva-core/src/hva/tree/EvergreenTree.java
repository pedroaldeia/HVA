package hva.tree;

import hva.TreeState.EvergreenAutumn;
import hva.TreeState.EvergreenSpring;
import hva.TreeState.EvergreenSummer;
import hva.TreeState.EvergreenWinter;
import hva.season.Season;

public class EvergreenTree extends Tree{

    /**
     * This is the constructor of the EvergreenTree class.
     * 
     * @param id the unique identifier of the tree
     * @param name the name of the tree
     * @param age the age of the tree
     * @param cleaningDifficulty the difficulty of cleaning the tree
     * @return void
     */
    public EvergreenTree(String id, String name, int age, int cleaningDifficulty, Season currentSeason){
        super(id, name, age, cleaningDifficulty, "PERENE");
        this.setStateBasedOnSeason(currentSeason);
    }

    private void setStateBasedOnSeason(Season season) {
        switch (season) {
            case WINTER:
                setState(new EvergreenWinter(this)); 
                break;
            case SPRING:
                setState(new EvergreenSpring(this)); 
                break;
            case SUMMER:
                setState(new EvergreenSummer(this));
                break;
            case FALL:
                setState(new EvergreenAutumn(this));
                break;
            default:
                throw new IllegalStateException("Unexpected season: " + season);
        }
    }

    /**
     * This method returns the details of the EvergreenTree.
     * 
     * @return a string with the details of the tree
     */
    @Override
    public String toString() {
        return super.toString(); 
    }
}