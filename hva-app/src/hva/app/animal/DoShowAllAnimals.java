package hva.app.animal;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
//FIXME import other classes if needed

class DoShowAllAnimals extends Command<Hotel> {

    DoShowAllAnimals(Hotel receiver) {
        super(Label.SHOW_ALL_ANIMALS, receiver);
    }

    @Override
    protected final void execute() {
        //FIXME implement command
        String allAnimals = (String)_receiver.showAllAnimals();
        System.out.println(allAnimals); //verificar se isto funciona...
    }

}
