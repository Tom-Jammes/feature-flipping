package fr.isima.master1.genielog.featureflipping.domain;

import java.util.function.Predicate;

public interface RoleExpression {
    Predicate<UserRoles> toPredicate();

    String stringify();
}
