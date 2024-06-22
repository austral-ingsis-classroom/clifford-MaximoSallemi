package edu.austral.ingsis.clifford.command.command;

import edu.austral.ingsis.clifford.Component;
import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.File;

public class Touch implements Command {
  private final String name;
  private final Directory current;

  public Touch(String name, Directory current) {
    this.name = name;
    this.current = current;
  }

  @Override
  public String execute() {
    if (name.contains("/") || name.contains(" ")) {
      return "touch: invalid file name";
    }
    for (Component child : current.getChildren()) {
      if (child.name().equals(name)) {
        current.remove(child.name());
        break;
      }
    }
    current.add(new File(name, current));
    return "'" + name + "' file created";
  }
}
