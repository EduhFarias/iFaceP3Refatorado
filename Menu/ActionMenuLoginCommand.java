package Menu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ActionMenuLoginCommand implements CommandMenu {
    ActionMenu actionMenu;

    public ActionMenuLoginCommand(ActionMenu actionMenu) {
        this.actionMenu = actionMenu;
    }

    public void execute(ArrayList<Person> users, ArrayList<Community> communities){
        actionMenu.login(users, communities);
    }
}
