package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Generator;

public class RandomGenerator implements Generator {

    private static final Integer START_RANGE = 1;
    private static final Integer END_RANGE = 45;
    private static final Integer LOTTO_LENGTH = 6;

    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, LOTTO_LENGTH);
    }
}
