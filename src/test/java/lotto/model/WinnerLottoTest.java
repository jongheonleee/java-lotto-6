package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinnerLottoTest {

    @DisplayName("생성 실패 테스트 - 1. 당첨 번호 잘못 입력한 경우(범위, 중복, 길이), 2. 보너스 번호 잘못 입력한 경우(범위), 3. 당첨 번호와 보너스 번호가 중복된 경우")
    @MethodSource("createWinnerLottoExceptionTestDummy")
    @ParameterizedTest
    void createWinnerLottoExceptionTest(List<Integer> winnerNumbers, Integer bonusNumber) {
        assertThrows(IllegalArgumentException.class,
                () -> new WinnerLotto(winnerNumbers, bonusNumber));
    }

    @DisplayName("생성 성공 테스트")
    @MethodSource("createWinnerLottoTestDummy")
    @ParameterizedTest
    void createWinnerLottoTest(List<Integer> winnerNumbers, Integer bonusNumber) {
        assertDoesNotThrow(
                () -> new WinnerLotto(winnerNumbers, bonusNumber));
    }

    @DisplayName("로또 결과 계산 테스트")
    @MethodSource("calculateLottoResultTestDummy")
    @ParameterizedTest
    void calculateLottoResultTest(List<Integer> winnerNumbers, Integer bonusNumber, List<Integer> lotto, LottoResult expected) {
        WinnerLotto winnerLotto = new WinnerLotto(winnerNumbers, bonusNumber);
        LottoResult result = winnerLotto.calculateLottoResult(lotto);
        assertEquals(expected, result);
    }

    static Stream<Arguments> createWinnerLottoExceptionTestDummy() {
        return Stream.of(
                // 1. 당첨 번호 잘못 입력한 경우
                Arguments.of(
                        List.of(0, 2, 3, 4, 5, 6),
                        10
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 5),
                        10
                ),
                Arguments.of(
                        List.of(1, 2, 3),
                        10
                ),
                // 2. 보너스 번호 잘못 입력한 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        0
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        46
                ),
                // 3. 당첨 번호와 보너스 번호가 중복된 경우
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        1
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        2
                )
        );
    }

    static Stream<Arguments> createWinnerLottoTestDummy() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        10
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        20
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        15
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        25
                )
        );
    }

    static Stream<Arguments> calculateLottoResultTestDummy() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        10,
                        List.of(1, 2, 3, 4, 5, 6),
                        LottoResult.FIRST_PLACE
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        20,
                        List.of(1, 2, 3, 4, 5, 20),
                        LottoResult.SECOND_PLACE
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        15,
                        List.of(1, 2, 3, 4, 5, 45),
                        LottoResult.THIRD_PLACE
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        25,
                        List.of(1, 2, 40, 41, 42, 43),
                        LottoResult.LOSER
                )
        );
    }
}