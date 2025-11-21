package fr.isima.master1.genielog.featureflipping.service;

import fr.isima.master1.genielog.featureflipping.domain.RoleExpression;

public interface RoleExpressionParser {

    RoleExpression parse(String expression);
}
