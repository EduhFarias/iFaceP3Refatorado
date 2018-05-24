package Menu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ActionMenuCommunitiesCommand implements CommandMenu {
    ActionMenu actionMenu;

    public ActionMenuCommunitiesCommand(ActionMenu actionMenu) {
        this.actionMenu = actionMenu;
    }

    public void execute(ArrayList<Person> users, ArrayList<Community> communities){
        actionMenu.viewCommunities(users, communities);
    }
}
