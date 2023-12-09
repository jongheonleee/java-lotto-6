package lotto.model;

import java.util.Arrays;

public enum LottoResult {
    FIRST_PLACE(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND_PLACE(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD_PLACE(5, false, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH_PLACE(4, false, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH_PLACE(3, false, 5_000, "3개 일치 (5,000원) - %d개"),
    LOSER(0, false, 0, "");

    private final Integer hitNumber;
    private final Boolean isBonus;
    private final Integer prize;
    private final String messageFormat;

    LottoResult(Integer hitNumber, Boolean isBonus, Integer prize, String messageFormat) {
        this.hitNumber = hitNumber;
        this.isBonus = isBonus;
        this.prize = prize;
        this.messageFormat = messageFormat;
    }

    public static LottoResult of(Integer hitNumber, Boolean isBonus) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> hitNumber == lottoResult.hitNumber && isBonus == lottoResult.isBonus)
                .findFirst()
                .orElse(LOSER);
    }

    public Integer getPrize() {
        return prize;
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
