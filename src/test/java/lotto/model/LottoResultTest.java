package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @DisplayName("로또 결과 생성 테스트")
    @MethodSource("createLottoResultDummy")
    @ParameterizedTest
    void createLottoResult(Integer hitNumber, Boolean isBonus, LottoResult expected) {
        LottoResult result = LottoResult.of(hitNumber, isBonus);
        assertEquals(expected, result);
    }

    static Stream<Arguments> createLottoResultDummy() {
        return Stream.of(
                Arguments.of(6, false, LottoResult.FIRST_PLACE),
                Arguments.of(5, true, LottoResult.SECOND_PLACE),
                Arguments.of(3, false, LottoResult.FIFTH_PLACE),
                Arguments.of(2, true, LottoResult.LOSER)
        );
    }
}