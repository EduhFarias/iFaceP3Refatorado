package MainMenu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ActionMainMenuDisplayRequestCommand implements CommandMain {
    ActionMainMenu actionMainMenu;

    public ActionMainMenuDisplayRequestCommand(ActionMainMenu actionMainMenu) {
        this.actionMainMenu = actionMainMenu;
    }

    public void execute(Person logged, ArrayList<Person> users, ArrayList<Community> communities){
        actionMainMenu.displayRequest(logged);
    }
}
