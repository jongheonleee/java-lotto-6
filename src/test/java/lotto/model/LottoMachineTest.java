package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void set() {
        // 로또 발행 번호가 항상 1, 2, 3, 4, 5, 6
        lottoMachine = new LottoMachine(() -> List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("입력된 개수만큼 로또 발행하는지 테스트")
    @MethodSource("purchaseLottoTestDummy")
    @ParameterizedTest
    void purchaseLottoTest(Integer count, Integer expected) {
        List<Lotto> numberOfPurchasedLotto = lottoMachine.purchaseLotto(count);
        assertEquals(expected, numberOfPurchasedLotto.size());
    }

    static Stream<Arguments> purchaseLottoTestDummy() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 4),
                Arguments.of(5, 5)
        );
    }
}