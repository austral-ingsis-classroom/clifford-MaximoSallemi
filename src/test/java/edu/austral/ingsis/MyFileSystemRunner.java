package edu.austral.ingsis;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.ArrayList;
import java.util.List;

public class MyFileSystemRunner implements FileSystemRunner {
  private final edu.austral.ingsis.clifford.FileSystem fileSystem;

  public MyFileSystemRunner(FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> result = new ArrayList<>();
    for (String command : commands) {
      String r = fileSystem.executeCommand(command);
      result.add(r);
    }
    return result;
  }
}
