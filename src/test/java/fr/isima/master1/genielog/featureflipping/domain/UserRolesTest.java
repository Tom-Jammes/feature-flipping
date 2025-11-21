package fr.isima.master1.genielog.featureflipping.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserRolesTest {

    @Nested
    class Creation {
        @Test
        void cannotCreateWithNullStringArray() {
            assertThrows(IllegalArgumentException.class,
                    () -> UserRoles.of((String[]) null)
            );
        }

        @Test
        void shouldIgnoreNullOrBlanksInStringArray() {
            UserRoles.of((String) null);
            UserRoles.of("");
            UserRoles.of("   ");
        }

        @Test
        void cannotCreateWithNullRoleArray() {
            assertThrows(IllegalArgumentException.class,
                    () -> UserRoles.of((Role[]) null)
            );
        }


        @Test
        void shouldIgnoreNullInRoleArray() {
            UserRoles.of((Role) null);
        }

    }

    @Test
    void mustContainAnyProvidedRole() {
        var roles = UserRoles.of("dev", "admin");
        assertThat(roles.contains(new Role("dev"))).isTrue();
        assertThat(roles.contains(new Role("Admin"))).isTrue();
    }

    @Test
    void mustNotContainNonProvidedRole() {
        var roles = UserRoles.of("dev", "admin");
        assertThat(roles.contains(new Role("senior"))).isFalse();
    }
}