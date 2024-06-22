package edu.austral.ingsis.clifford;

public interface Component {
  Component parent();

  boolean isComposite();

  String name();
}
