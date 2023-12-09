package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("생성 실패 테스트 - 1. 잘못된 숫자 범위, 2. 잘못된 숫자 개수, 3. 중복")
    @MethodSource("createLottoExceptionTestDummy")
    @ParameterizedTest
    void createLottoExceptionTest(List<Integer> wrongNumbers) {
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(wrongNumbers));
    }

    @DisplayName("생성 성공 테스트")
    @MethodSource("createLottoTestDummy")
    @ParameterizedTest
    void createLottoTest(List<Integer> rightNumbers) {
        assertDoesNotThrow(
                () -> new Lotto(rightNumbers));
    }


    @DisplayName("로또 세부 내역 출력 기능 테스트")
    @MethodSource("toStringTestDummy")
    @ParameterizedTest
    void toStringTest(List<Integer> numbers, String expected) {
        Lotto lotto = new Lotto(numbers);
        String result = lotto.toString();
        assertEquals(expected, result);
    }

    static Stream<Arguments> createLottoExceptionTestDummy() {
        return Stream.of(
                // 1. 잘못된 숫자 범위
                Arguments.of(List.of(1, 2, 3, 4, 5, 100)),
                Arguments.of(List.of(0, -1, 9, 4, 45, 21)),
                // 2. 잘못된 숫자 개수
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3)),
                // 3. 중복
                Arguments.of(List.of(1, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5))
        );
    }

    static Stream<Arguments> createLottoTestDummy() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8)),
                Arguments.of(List.of(1, 45, 2, 3, 4, 10)),
                Arguments.of(List.of(1, 22, 3, 4, 5, 35))
        );
    }

    static Stream<Arguments> toStringTestDummy() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        "[1, 2, 3, 4, 5, 6]"
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 8),
                        "[1, 2, 3, 4, 5, 8]"
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 10, 45),
                        "[1, 2, 3, 4, 10, 45]"
                ),
                Arguments.of(
                        List.of(1, 3, 4, 5, 22, 35),
                        "[1, 3, 4, 5, 22, 35]"
                )
        );
    }
}