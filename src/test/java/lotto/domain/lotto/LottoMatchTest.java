package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoMatch(7, false));
  }
}