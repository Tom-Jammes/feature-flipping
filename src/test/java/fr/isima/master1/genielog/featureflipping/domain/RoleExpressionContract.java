package fr.isima.master1.genielog.featureflipping.domain;

  import org.junit.jupiter.api.Test;
  import static org.assertj.core.api.Assertions.*;
  public interface RoleExpressionContract {

      RoleExpression getInstance();

      String getExpectedStringification();

      @Test
      default void mustReturnCorrectStringification() {
        assertThat(getInstance().stringify()).isEqualTo(getExpectedStringification());
      }

  }
