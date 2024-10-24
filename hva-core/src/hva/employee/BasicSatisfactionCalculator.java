package hva.employee;

import java.util.Map;
import hva.habitat.Habitat;
import hva.animal.Species;

public class BasicSatisfactionCalculator implements SatisfactionCalculator {
    @Override
    public double visitCaretaker(Caretaker c) {
        double totalWork = 0;
        Map<String, Habitat> responsibilities = c.getResponsibilityMap();
        for (Habitat h : responsibilities.values()){
            double habitatWork = 0;
            habitatWork = h.getArea() + 3*h.getPopulation() + h.getTotalCleaningDifficulty();
            totalWork += habitatWork / h.getCaretakersNum(); 
        }
        return 300 - totalWork;
    }
    @Override
    public double visitVet(Vet v) {
        double work = 0;
        Map<String, Species> responsiblities = v.getResponsibilityMap();
        for (Species s : responsiblities.values()){
            work += s.getAnimalsNum()/s.getVetsNum();  
        }
        return 20 - work;
    }
}
