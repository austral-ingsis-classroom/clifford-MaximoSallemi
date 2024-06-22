package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.command.builder.*;
import edu.austral.ingsis.clifford.command.builder.CommandBuilder;
import edu.austral.ingsis.clifford.command.command.Command;
import java.util.HashMap;
import java.util.Map;

public class FileSystemClass implements FileSystem {
  private final Directory root;
  private Directory current;
  private final Map<String, CommandBuilder> commands;

  public FileSystemClass() {
    this.root = new Directory("/", null);
    this.current = root;
    this.commands = makeCommands();
  }

  private Map<String, CommandBuilder> makeCommands() {
    Map<String, CommandBuilder> map = new HashMap<>();
    map.put("cd", new CdBuilder(this));
    map.put("ls", new LsBuilder(this));
    map.put("mkdir", new MkdirBuilder(this));
    map.put("pwd", new PwdBuilder(this));
    map.put("rm", new RmBuilder(this));
    map.put("touch", new TouchBuilder(this));
    return map;
  }

  @Override
  public void setCurrent(Directory newCurrent) {
    this.current = newCurrent;
  }

  @Override
  public Directory getCurrent() {
    return current;
  }

  @Override
  public Directory getRoot() {
    return root;
  }

  @Override
  public String executeCommand(String command) {
    String name = command.split(" ")[0];
    Command toExecute = commands.get(name).build(command);
    return toExecute.execute();
  }
}
