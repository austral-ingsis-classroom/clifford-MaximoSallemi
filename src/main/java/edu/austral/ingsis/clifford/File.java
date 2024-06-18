package edu.austral.ingsis.clifford;

public record File(String name, Directory parent) implements Component {

  @Override
  public boolean isComposite() {
    return false;
  }
}
