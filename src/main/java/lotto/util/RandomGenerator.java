package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomGenerator {

    private static final Integer START_RANGE = 1;
    private static final Integer END_RANGE = 45;
    private static final Integer LOTTO_LENGTH = 6;

    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, LOTTO_LENGTH);
    }
}
