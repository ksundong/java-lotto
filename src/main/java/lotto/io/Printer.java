package lotto.io;

import static lotto.domain.Rank.NONE;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public final class Printer {

  public static final int CRITERION = 1;

  private Printer() {}

  public static void printLottoCount(Lottos userLottos) {
    System.out.println(userLottos.count() + "개를 구매했습니다.");
  }

  public static void printLottos(Lottos userLottos) {
    for (Lotto lotto : userLottos.getLottos()) {
      printLottoNumbers(lotto.getLottoNumbers());
    }
    System.out.println();
  }

  private static void printLottoNumbers(LottoNumbers lottoNumbers) {
    System.out.println(lottoNumbers.getLottoNumbers().stream()
        .map(LottoNumber::toStringValue)
        .collect(Collectors.joining(", ", "[", "]")));
  }

  public static void printRank(WinningStatistics winningStatistics) {
    System.out.println("당첨 통계");
    System.out.println("----------");

    for (Rank rank : Rank.values()) {
      printMessageAndCountOfRank(winningStatistics, rank);
    }
  }

  public static void printResult(WinningStatistics winningStatistics, Money userMoney) {
    long winnings = winningStatistics.totalMoney().toInteger();
    double yield = (double) winnings / userMoney.toInteger();

    System.out.println("당첨금: " + winnings + "원");
    System.out.printf("총 수익률은 %.2f입니다.", yield);
    if (yield < CRITERION) {
      System.out.print("(기준이 " + CRITERION + "이기 때문에 결과적으로 손해라는 의미임)");
    }
    System.out.println();
  }

  private static void printMessageAndCountOfRank(WinningStatistics winningStatistics, Rank rank) {
    if (!NONE.equals(rank)) {
      printRankMessage(winningStatistics, rank);
    }
  }

  private static void printRankMessage(WinningStatistics winningStatistics, Rank rank) {
    StringBuilder rankMessageBuilder = new StringBuilder().append(rank.getMatchCount()).append("개 일치");
    if (rank.isBonusNumberMatch()) {
      rankMessageBuilder.append(", 보너스 볼 일치");
    }
    rankMessageBuilder.append("(").append(rank.getMoney().toInteger()).append("원) - ")
        .append(winningStatistics.countOf(rank)).append("개");
    System.out.println(rankMessageBuilder.toString());
  }
}
