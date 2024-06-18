package edu.austral.ingsis.clifford.command.builder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.command.command.Command;
import edu.austral.ingsis.clifford.command.command.Rm;

public class RmBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public RmBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    String[] command = commandLine.split(" ");
    if (command.length == 2) {
      return new Rm(fileSystem.getCurrent(), command[1], false);
    } else if (command.length == 3 && command[1].equals("--recursive")) {
      return new Rm(fileSystem.getCurrent(), command[2], true);
    }
    return new Rm(fileSystem.getCurrent(), "", false);
  }
}
