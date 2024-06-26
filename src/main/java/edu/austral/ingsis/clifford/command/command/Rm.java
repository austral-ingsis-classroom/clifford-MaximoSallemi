package edu.austral.ingsis.clifford.command.command;

import edu.austral.ingsis.clifford.Component;
import edu.austral.ingsis.clifford.Directory;

public class Rm implements Command {
  private final Directory current;
  private final String name;
  private final boolean recursive;

  public Rm(Directory current, String name, boolean recursive) {
    this.current = current;
    this.recursive = recursive;
    if (name.isEmpty()) {
      this.name = current.getChildren().get(0).name();
    } else {
      this.name = name;
    }
  }

  @Override
  public String execute() {
    for (Component component : current.getChildren()) {
      if (component.name().equals(name)) {
        if (component.isComposite() && recursive) {
          current.remove(name);
          return "'" + name + "' removed";
        } else if (!component.isComposite()) {
          current.remove(name);
          return "'" + name + "' removed";
        } else {
          return "cannot remove '" + component.name() + "', is a directory";
        }
      }
    }
    return "cannot remove '" + name + "', there is no such file or directory";
  }
}
