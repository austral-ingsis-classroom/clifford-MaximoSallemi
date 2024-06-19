package edu.austral.ingsis.clifford.command.builder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.command.command.Command;
import edu.austral.ingsis.clifford.command.command.Mkdir;

public class MkdirBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public MkdirBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    return new Mkdir(fileSystem.getCurrent(), commandLine.split(" ")[1]);
  }
}
