package edu.austral.ingsis.clifford.command.command;

import edu.austral.ingsis.clifford.Component;
import edu.austral.ingsis.clifford.Directory;
import edu.austral.ingsis.clifford.FileSystem;

public class Cd implements Command {
  private final FileSystem fileSystem;
  private final String path;

  public Cd(FileSystem fileSystem, String path) {
    this.fileSystem = fileSystem;
    this.path = path;
  }

  @Override
  public String execute() {
    Directory current = fileSystem.getCurrent();
    if (path.charAt(0) == '/') {
      current = fileSystem.getRoot();
    }

    String[] folders = path.split("/");
    for (String folder : folders) {
      if (folder.equals("..")) {
        if (!(current.parent() == null)) {
          current = current.parent();
        }
      } else {
        boolean found = false;
        for (Component component : current.getChildren()) {
          if (component.name().equals(folder)) {
            current = (Directory) component;
            found = true;
          }
        }
        if (!found) {
          return "'" + folder + "' directory does not exist";
        }
      }
    }
    fileSystem.setCurrent(current);
    return "moved to directory '" + current.name() + "'";
  }
}
