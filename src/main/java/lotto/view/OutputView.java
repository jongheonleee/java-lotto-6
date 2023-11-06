package lotto.view;

import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class OutputView {

    private final DecimalFormat formatter;
    public OutputView() {
        formatter = new DecimalFormat("###,###");
    }

    public void printPurchasedLottos(Lottos lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.", lottos.getCount());
        System.out.println();
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printStaticResult(Prizes prizes, Cash cash) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            if (prize == Prize.LAST_PLACE) continue;
            if (!prize.isBonusNumber()) {
                System.out.printf("%d개 일치 (%s원) - %d개",
                        prize.getCountOfMatchedNumber(),
                        formatter.format(prize.getReward()),
                        prizes.countPrize(prize));
            } else if (prize.isBonusNumber()){
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개",
                        prize.getCountOfMatchedNumber(),
                        formatter.format(prize.getReward()),
                        prizes.countPrize(prize));
            }
            System.out.println();
        }


        String prefix = String.format("총 수익률은 %.1f", prizes.calculateBenefit(cash
                .getDepositAmount()));

        System.out.println(prefix + "%입니다.");
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
        System.out.println();
    }


}
