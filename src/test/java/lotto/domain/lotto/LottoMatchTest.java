package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InvalidMatchCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatchTest {

  @Test
  @DisplayName("생성 테스트")
  void create() {
    // given
    int matchCount = 3;

    // when
    // then
    assertThat(new LottoMatch(matchCount, false)).isEqualTo(new LottoMatch(matchCount, false));
  }

  @Test
  @DisplayName("생성 실패 테스트")
  void createFailure() {
    assertThatThrownBy(() -> new LottoMatch(7, false))
        .isInstanceOf(InvalidMatchCountException.class)
        .hasMessage(InvalidMatchCountException.INVALID_MATCH_COUNT);
  }

  @Test
  @DisplayName("보너스 번호 일치가 필요 없는 경우 생성 실패 테스트")
  void createFailureNoBonus() {
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoMatch(4, true))
        .withMessage(LottoMatch.INVALID_BONUS_CONDITION);
  }
}
