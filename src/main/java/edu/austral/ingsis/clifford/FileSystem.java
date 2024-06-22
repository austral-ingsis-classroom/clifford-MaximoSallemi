package edu.austral.ingsis.clifford;

public interface FileSystem {
  void setCurrent(Directory current);

  Directory getCurrent();

  Directory getRoot();

  String executeCommand(String command);
}
