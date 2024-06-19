package edu.austral.ingsis.clifford.command.command;

import edu.austral.ingsis.clifford.Directory;

public class Mkdir implements Command {
  private final Directory current;
  private final String name;

  public Mkdir(Directory current, String name) {
    this.name = name;
    this.current = current;
  }

  @Override
  public String execute() {
    if (name.contains("/") || name.contains(" ")) {
      return "mkdir: invalid file name";
    }
    current
        .getChildren()
        .forEach(
            component -> {
              if (component.name().equals(name)) {
                current.remove(component.name());
              }
            });
    current.add(new Directory(name, current));
    return "'" + name + "' directory created";
  }
}
