package edu.austral.ingsis.clifford.command.builder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.command.command.Cd;
import edu.austral.ingsis.clifford.command.command.Command;

public class CdBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public CdBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    String path = commandLine.split(" ")[1];
    return new Cd(fileSystem, path);
  }
}
