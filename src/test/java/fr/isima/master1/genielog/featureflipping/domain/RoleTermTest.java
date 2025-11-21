package fr.isima.master1.genielog.featureflipping.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoleTermTest  {
    @Test
    void cannotCreateRoleTermWithNullRole() {
        assertThrows(IllegalArgumentException.class, () -> new RoleTerm(null));
    }

    @Test
    void mustCreateRoleTermWithRole() {
        new RoleTerm(new Role("test"));
    }

    @Test
    void mustHaveCorrectSringification() {

        assertThat(newRoleTerm("Dev").stringify()).isEqualTo("Dev");
    }

    @Test
    void mustReturnTruthyPredicateWhenUserHasRole() {
        var predicate = newRoleTerm("dev").toPredicate();
        var roles = UserRoles.of("dev", "senior");
        assertThat(predicate.test(roles)).isTrue();
    }

    @Test
    void mustReturnFalsyPredicateWhenUserHasNotRole() {
        var predicate = newRoleTerm("admin").toPredicate();
        var roles = UserRoles.of("dev", "senior");
        assertThat(predicate.test(roles)).isFalse();
    }

    private RoleTerm newRoleTerm(String roleName) {
        return new RoleTerm(new Role(roleName));
    }

}