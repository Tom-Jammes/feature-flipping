package fr.isima.master1.genielog.featureflipping.domain;

import java.util.function.Predicate;

public class OrRoleOperator extends RoleOperator {

    public OrRoleOperator(RoleExpression left, RoleExpression right) {
    }

    @Override
    public Predicate<UserRoles> toPredicate() {
        return null;
    }

    @Override
    public String stringify() {
        return null;
    }
}
