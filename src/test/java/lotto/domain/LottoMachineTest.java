package lotto.domain;

import lotto.util.NumberGenerator;
import lotto.util.UniqueRandomNumbersGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 생성기")
class LottoMachineTest {
    LottoMachine lottoMachine;
    NumberGenerator numberGenerator;
    Cash cash;

    @BeforeEach
    void setUp() {
        numberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        cash = Cash.create(1000, 0);
        lottoMachine = new LottoMachine(numberGenerator, cash);
    }

    @DisplayName("로또 구매 기능 성공 테스트")
    @Test
    void purchaseLottosSuccessTest() {
        Lotto expected = Lotto.create(List.of(1, 2, 3, 4, 5, 6));

        Lottos lottos = lottoMachine.purchaseLottos();
        Lotto result = lottos.getLottos()
                        .get(0);

        assertThat(result
                .equals(expected))
                .isTrue();
    }


}