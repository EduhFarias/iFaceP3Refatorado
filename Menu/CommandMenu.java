package Menu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public interface CommandMenu {
    public void execute(ArrayList<Person> users, ArrayList<Community> communities);
}
