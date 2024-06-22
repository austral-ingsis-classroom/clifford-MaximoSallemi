package edu.austral.ingsis.clifford.command.builder;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.command.command.Command;
import edu.austral.ingsis.clifford.command.command.Ls;

public class LsBuilder implements CommandBuilder {
  private final FileSystem fileSystem;

  public LsBuilder(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public Command build(String commandLine) {
    String[] parts = commandLine.split(" ");
    if (parts.length == 2) {
      return new Ls(fileSystem.getCurrent(), parts[1].split("=")[1]);
    } else {
      return new Ls(fileSystem.getCurrent());
    }
  }
}
