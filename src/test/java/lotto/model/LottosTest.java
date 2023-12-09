package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {
    LottoMachine lottoMachine;

    @BeforeEach
    void set() {
        lottoMachine = new LottoMachine(() -> List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("구매한 로또 내역 출력 기능 테스트")
    @MethodSource("toStringTestDummy")
    @ParameterizedTest
    void toStringTest(Integer count, String expected) {
        List<Lotto> lottoDummy = lottoMachine.purchaseLotto(count);
        Lottos lottos = new Lottos(lottoDummy);
        String result = lottos.toString();
        assertEquals(expected, result);
    }

    static Stream<Arguments> toStringTestDummy() {
        return Stream.of(
                Arguments.of(
                        1,
                        "[1, 2, 3, 4, 5, 6]\n"
                ),
                Arguments.of(
                        2,
                        "[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n"
                ),
                Arguments.of(
                        3,
                        "[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n"
                ),
                Arguments.of(
                        2,
                        "[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n"
                )
        );
    }

}