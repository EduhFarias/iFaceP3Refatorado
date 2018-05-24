package MainMenu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ControllerMain {
    private CommandMain choice;

    public ControllerMain(){}

    public void setChoice(CommandMain choice) {
        this.choice = choice;
    }

    public void choiceWasSelected(Person logged, ArrayList<Person> users, ArrayList<Community> communities){
        choice.execute(logged, users, communities);
    }
}
