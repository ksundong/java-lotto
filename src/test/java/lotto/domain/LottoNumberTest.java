package lotto.domain;

import static lotto.domain.LottoNumber.ILLEGAL_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @ParameterizedTest
  @DisplayName("로또 번호 생성 테스트")
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void create(int value) {
    assertThat(LottoNumber.valueOf(value)).isEqualTo(LottoNumber.valueOf(value));
  }

  @ParameterizedTest
  @DisplayName("로또 번호 생성 실패 테스트")
  @ValueSource(ints = {0, 46})
  void createFail(int value) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> LottoNumber.valueOf(value))
        .withMessage(ILLEGAL_LOTTO_NUMBER);
  }

  @Test
  @DisplayName("로또 번호 비교 테스트")
  void compare() {
    // given
    LottoNumber smaller = LottoNumber.valueOf(1);
    LottoNumber bigger = LottoNumber.valueOf(6);

    // when
    // then
    assertAll(
        () -> assertThat(smaller.compareTo(bigger)).isNegative(),
        () -> assertThat(bigger.compareTo(smaller)).isPositive(),
        () -> assertThat(bigger.compareTo(bigger)).isZero()
    );
  }
}
