package lotto.model;

import static org.junit.jupiter.api.Assertions.*;


import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CashTest {
    @DisplayName("생성 실패 테스트 : 1. 1,000원으로 나누어 떨어지지 않는 경우,  2. 1,000원보다 작은 값을 입력한 경")
    @MethodSource("createCashExceptionTestDummy")
    @ParameterizedTest
    void createCashExceptionTest(Integer wrongAmount) {
        assertThrows(IllegalArgumentException.class,
                () -> new Cash(wrongAmount));
    }

    @DisplayName("생성 성공 테스트")
    @MethodSource("createCashTestDummy")
    @ParameterizedTest
    void createCashTest(Integer rightAmount) {
        assertDoesNotThrow(
                () -> new Cash(rightAmount));
    }

    @DisplayName("로또 구매 개수 계산 기능 테스트")
    @MethodSource("countNumberOfPurchaseLottoTestDummy")
    @ParameterizedTest
    void countNumberOfPurchaseLottoTest(Integer amount, Integer expected) {
        Cash cash = new Cash(amount);
        Integer result = cash.countNumberOfPurchaseLotto();
        assertEquals(expected, result);
    }

    static Stream<Arguments> createCashExceptionTestDummy() {
        return Stream.of(
                Arguments.arguments(-1000),
                Arguments.arguments(0),
                Arguments.arguments(10001),
                Arguments.arguments(2005)
        );
    }

    static Stream<Arguments> createCashTestDummy() {
        return Stream.of(
                Arguments.arguments(1000),
                Arguments.arguments(2000),
                Arguments.arguments(10000),
                Arguments.arguments(20000)
        );
    }

    static Stream<Arguments> countNumberOfPurchaseLottoTestDummy() {
        return Stream.of(
                Arguments.arguments(1000, 1),
                Arguments.arguments(2000, 2),
                Arguments.arguments(10000, 10),
                Arguments.arguments(20000, 20)
        );
    }

}