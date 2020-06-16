package step2.model;

public class LottoWinning {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private LottoWinning(Lotto lotto, LottoNumber bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinning of(Lotto winningNumber, LottoNumber bonusNumber) {
        return new LottoWinning(winningNumber, bonusNumber);
    }

    public LottoRank getRankOfLotto(Lotto lotto) {
        long same = winningLotto.checkWinningCount(lotto);
        boolean matchBonus = lotto.has(bonusNumber);
        return LottoRank.valueOf(same, matchBonus);
    }
}
