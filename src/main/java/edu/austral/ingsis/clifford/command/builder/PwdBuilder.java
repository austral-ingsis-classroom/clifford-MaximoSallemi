package edu.austral.ingsis.clifford.command.builder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.command.command.Command;
import edu.austral.ingsis.clifford.command.command.Pwd;

public class PwdBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public PwdBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    return new Pwd(fileSystem.getCurrent());
  }
}
