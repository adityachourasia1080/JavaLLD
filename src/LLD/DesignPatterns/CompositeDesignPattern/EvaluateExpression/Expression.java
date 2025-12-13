package LLD.DesignPatterns.CompositeDesignPattern.EvaluateExpression;

public class Expression implements ArithmeticExpression{

    ArithmeticExpression left;
    ArithmeticExpression right;;
    OperationType op;

    public Expression(ArithmeticExpression left, ArithmeticExpression right, OperationType op){
      this.left=left;
      this.right=right;
      this.op=op;
    }

    @Override
    public int evaluate() {
        switch(op){
            case ADD:
                return left.evaluate()+ right.evaluate();
            case SUBTRACT:
                return left.evaluate()- right.evaluate();
            case MULTIPLY:
                return left.evaluate()* right.evaluate();
            case DIVIDE:
                return left.evaluate()/ right.evaluate();
            default:
                return 0;
        }
    }
}
