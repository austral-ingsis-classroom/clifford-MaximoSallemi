package edu.austral.ingsis.clifford.command.builder;

import edu.austral.ingsis.clifford.command.command.Command;

public interface CommandBuilder {
  Command build(String commandLine);
}
