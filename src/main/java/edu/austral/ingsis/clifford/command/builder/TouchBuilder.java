package edu.austral.ingsis.clifford.command.builder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.command.command.Command;
import edu.austral.ingsis.clifford.command.command.Touch;

public class TouchBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public TouchBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    String name = commandLine.split(" ")[1];
    return new Touch(name, fileSystem.getCurrent());
  }
}
