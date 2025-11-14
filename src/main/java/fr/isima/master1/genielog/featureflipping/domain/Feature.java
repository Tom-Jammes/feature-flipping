package fr.isima.master1.genielog.featureflipping.domain;

public class Feature {
    public final String name = null;
    public RoleExpression expression;

    public Feature(String name) {
    }

    public Feature(String name, RoleExpression expression) {
    }

    public boolean isEnabled(UserRoles userRoles) {
        return false;
    }
}
