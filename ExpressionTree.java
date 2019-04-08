public class ExpressionTree {
  private char op;
  private double value;
  private ExpressionTree left, right;

  public ExpressionTree(double value) {
    this.value = value;
    op = '~';
  }

  public ExpressionTree(char op, ExpressionTree l, ExpressionTree r) {
    this.op = op;
    left = l;
    right = r;
  }

  public char getOp() {
    return op;
  }

  private double getValue() {
    return value;
  }

  private ExpressionTree getLeft() {
    return left;
  }

  private ExpressionTree getRight() {
    return right;
  }

  private boolean isOp() {
    return hasChildren();
  }

  private boolean isValue() {
    return !hasChildren();
  }

  private boolean hasChildren() {
    return left != null & right != null;
  }

  public String toString() {
    String output = "";

    return output;
  }
}