package fr.isima.master1.genielog.featureflipping.domain;

import java.util.function.Predicate;

public class RoleTerm implements RoleExpression {
    public RoleTerm(Role role) {
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
