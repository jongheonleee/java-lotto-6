package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final Integer INIT_SIZE = 0;

    private static final String ENTER = "\n";
    private final List<Lotto> lottos;
    private final StringBuilder lottosBuilder;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.lottosBuilder = new StringBuilder();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public String toString() {
        initBuilder();
        for (Lotto lotto : lottos) {
            lottosBuilder.append(lotto.toString());
            lottosBuilder.append(ENTER);
        }
        return lottosBuilder.toString();
    }

    private void initBuilder() {
        lottosBuilder.setLength(INIT_SIZE);
    }
}
