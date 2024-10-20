package hva.employee;

import java.util.Map;
import hva.habitat.Habitat;
import hva.animal.Species;
import hva.tree.Tree;

public class BasicSatisfactionCalculator implements SatisfactionCalculator {
    @Override
    public int visitCaretaker(Caretaker c) {
        int totalWork = 0;
        Map<String, Habitat> responsibilities = c.getResponsibilityMap();
        for (Habitat h : responsibilities.values()){
            int habitatWork = 0;
            habitatWork = h.getArea() + 3*h.getTreesNum();
            for (Tree t: h.getTreesMap().values()){
                habitatWork += t.calculateCleaningDifficulty();
            }
            totalWork += habitatWork / h.getCaretakersNum(); 
        }
        return Math.round(300 - totalWork);
    }
    @Override
    public int visitVet(Vet v) {
        int work = 0;
        Map<String, Species> responsiblities = v.getResponsibilityMap();
        for (Species s : responsiblities.values()){
            work += s.getAnimalsNum()/s.getVetsNum();  
        }
        return Math.round(20 - work);
    }
}
