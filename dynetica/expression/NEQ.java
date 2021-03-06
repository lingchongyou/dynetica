package dynetica.expression;

public class NEQ extends LogicalExpression {

    public NEQ(GeneralExpression a, GeneralExpression b) {
        super(a, b);
        type = ExpressionConstants.NEQ;
    }

    public void compute() {
        if (a.getValue() != b.getValue())
            value = 1.0;
        else
            value = 0.0;
    }

    public String toString() {
        return a.toString() + " != " + b.toString();
    }
} // NEQ
