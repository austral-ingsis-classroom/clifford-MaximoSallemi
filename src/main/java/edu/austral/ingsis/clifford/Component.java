package edu.austral.ingsis.clifford;

public interface Component {
  String name();

  Component parent();

  boolean isComposite();
}
