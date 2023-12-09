package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoMachine {

    private final Generator generator;

    public LottoMachine(Generator generator) {
        this.generator = generator;
    }

    public List<Lotto> purchaseLotto(Integer count) {
        List<Lotto> lottoDummy = new ArrayList<>();
        for (int i=0; i<count; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottoDummy.add(convertLotto(numbers));
        }
        return lottoDummy;
    }

    private List<Integer> generateLottoNumbers() {
        return generator.generateNumbers();
    }

    private Lotto convertLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
