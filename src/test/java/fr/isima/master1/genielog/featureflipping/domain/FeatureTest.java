package fr.isima.master1.genielog.featureflipping.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FeatureTest implements EqualityTests<Feature> {

    @Test
    void cannotCreateFeatureWithoutName() {
        assertThrows(IllegalArgumentException.class, () -> new Feature(null));
        assertThrows(IllegalArgumentException.class, () -> new Feature(""));
        assertThrows(IllegalArgumentException.class, () -> new Feature("  "));
        assertThrows(IllegalArgumentException.class, () -> new Feature(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Feature("", null));
        assertThrows(IllegalArgumentException.class, () -> new Feature("   ", null));
    }

    @Test
    void mustCreateFeatureWithOnlyName() {
        var feature = new Feature("test", null);
        assertThat(feature.name).isEqualTo("test");
        assertThat(feature.expression).isNull();
    }

    @Test
    void mustCreateFeatureWithNameAndExpresion() {
        var feature = new Feature("test", newRoleTerm("dev"));
        assertThat(feature.name).isEqualTo("test");
        assertThat(feature.expression).isNotNull();
        assertThat(feature.expression.stringify()).isEqualTo("dev");
    }

    @Test
    void mustBeEnabledWhenExpressionIsNullEvenIfUserHasNoRoles() {
        var feature = new Feature("test", null);
        var userRoles = UserRoles.of("");
        assertThat(feature.isEnabled(userRoles)).isTrue();
    }

    @Test
    void mustBeEnabledWhenExpressionIsTruthyForUserRoles() {
        var feature = new Feature("test", newRoleTerm("dev"));
        var userRoles = UserRoles.of("dev");
        assertThat(feature.isEnabled(userRoles)).isTrue();
    }

    @Test
    void mustBeNotEnabledWhenExpressionIsFalsyForUserRoles() {
        var feature = new Feature("test", newRoleTerm("admin"));
        var userRoles = UserRoles.of("dev");
        assertThat(feature.isEnabled(userRoles)).isFalse();
    }

    @Override
    public Feature getInstance() {
        return new Feature("feature", new RoleTerm(new Role("dev")));
    }

    @Override
    public Feature getEqualInstance() {
        return new Feature("feature", null);
    }

    @Override
    public Feature getDifferentInstance() {
        return new Feature("test", null);
    }

    private RoleTerm newRoleTerm(String roleName) {
        return new RoleTerm(new Role(roleName));
    }


}