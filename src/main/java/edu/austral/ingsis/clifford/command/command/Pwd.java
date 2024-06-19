package edu.austral.ingsis.clifford.command.command;

import edu.austral.ingsis.clifford.Component;

public class Pwd implements Command {
  private final Component current;

  public Pwd(Component current) {
    this.current = current;
  }

  @Override
  public String execute() {
    return getPath(current);
  }

  private String getPath(Component component) {
    if (component.parent() == null) {
      return "";
    }
    return getPath(component.parent()) + "/" + component.name();
  }
}
