package LLD.DesignPatterns.CompositeDesignPattern.EvaluateExpression;

public class Number implements ArithmeticExpression{
    int no;

    public Number(int no){
        this.no=no;
    }

    @Override
    public int evaluate() {
        return no;
    }
}
