package fr.isima.master1.genielog.featureflipping.domain;

public abstract class RoleOperator implements RoleExpression {

    protected final RoleExpression[] operands = null;

    protected RoleOperator(RoleExpression ... operands) {
    }
}
