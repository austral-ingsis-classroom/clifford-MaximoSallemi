package edu.austral.ingsis;

import java.util.ArrayList;
import java.util.List;

public class MyFileSystemRunner implements FileSystemRunner {
  private final edu.austral.ingsis.clifford.FileSystem fileSystem;

  public MyFileSystemRunner(edu.austral.ingsis.clifford.FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> result = new ArrayList<>();
    for (String command : commands) {
      String r = fileSystem.execute(command);
      result.add(r);
    }
    return result;
  }
}
