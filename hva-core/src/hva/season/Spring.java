package hva.season;

import hva.tree.Tree;

public class Spring extends Season{

    private int deciduousEffort = 1;
    private int EvergreenEffort = 1;

    public Spring(Tree tree){
        super(tree);
    }
    //esforço_limpeza(a) = dificuldade_limpeza(a) * esforço_sazonal(a) * log(idade(a) + 1)
    //VISITOR???
    @Override
    public int calculateEffort(){
        return _tree.getDifficulty() * 2;
    }
    @Override
    public void advanceSeason(){
        _tree.setSeason(new Summer(_tree));
    }
}
