package fr.isima.master1.genielog.featureflipping.domain;

import org.junit.jupiter.api.Nested;

class OrRoleOperatorTest implements BinaryRoleOperatorTest<OrRoleOperator> {

    @Override
    public OrRoleOperator getInstance(RoleExpression left, RoleExpression right) {
        return new OrRoleOperator(left, right);
    }

    @Override
    public char getSymbol() {
        return '|';
    }

    @Override
    public boolean getTruthTableWhenBothOperandsAreTruthy() {
        return true;
    }

    @Override
    public boolean getTruthTableWhenOnlyLeftOperantIsTruthy() {
        return true;
    }

    @Override
    public boolean getTruthTableWhenOnlyRightOperandIsTruthy() {
        return true;
    }

    @Override
    public boolean getTruthTableWhenNoOperandIsTruthy() {
        return false;
    }



}