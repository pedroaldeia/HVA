package hva.employee;

import java.util.Map;
import hva.habitat.Habitat;
import hva.animal.Species;
import hva.tree.Tree;

public class BasicSatisfactionCalculator implements SatisfactionCalculator {
    @Override
    public double visitCaretaker(Caretaker c) {
        double totalWork = 0;
        Map<String, Habitat> responsibilities = c.getResponsibilityMap();
        for (Habitat h : responsibilities.values()){
            double habitatWork = 0;
            habitatWork = h.getArea() + 3*h.getTreesNum();
            for (Tree t: h.getTreesMap().values()){
                habitatWork += t.calculateCleaningDifficulty();
            }
            totalWork += habitatWork / h.getCaretakersNum(); 
        }
        return 300 - totalWork;
    }
    @Override
    public double visitVet(Vet v) {
        int work = 0;
        Map<String, Species> responsiblities = v.getResponsibilityMap();
        for (Species s : responsiblities.values()){
            work += s.getAnimalsNum()/s.getVetsNum();  
            System.out.println(s.getAnimalsNum());
            System.out.println(s.getVetsNum());
        }
        return 20 - work;
    }
}
