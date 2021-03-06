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

  //Actual stuff I'm gonna write________________________________________________

  public String toString() {
    if (isValue())
      return "" + getValue();

    return "(" + getLeft().toString() + " " + getOp() + " " + getRight().toString() + ")";
  }

  public String toStringPostfix() {
    if (isValue())
      return "" + getValue();

    return getLeft().toStringPostfix() + " " + getRight().toStringPostfix() + " " + getOp();
  }

  public String toStringPrefix() {
    if (isValue())
      return "" + getValue();

    return getOp() + " " + getLeft().toStringPrefix() + " " + getRight().toStringPrefix();
  }

  public double evaluate() {
    if (isValue())
      return getValue();

    return apply(getOp(), getLeft().evaluate(), getRight().evaluate());
  }

  private double apply(char op, double a, double b) {
    double result = 0;
    if (op == '+')
      result = a + b;

    else if (op == '-')
        result = a - b;

    else if (op == '*')
      result = a * b;

    else if (op == '/')
      result = a / b;

    return result;
  }
}
