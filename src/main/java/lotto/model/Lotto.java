package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final Integer START_RANGE = 1;
    private static final Integer END_RANGE = 45;
    private static final Integer LENGTH = 6;
    private static final Integer INIT_SIZE = 0;

    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";

    private static final String COMMA = ",";

    private static final String SPACE = " ";
    private final List<Integer> numbers;
    private final StringBuilder lottoBuilder;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.lottoBuilder = new StringBuilder();
    }

    private void validate(List<Integer> numbers) {
        if (!isAllowedNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 허용범위는 1~45");
        }

        if (!isAllowedNumbersLength(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 6개 입니다.");
        }

        if (isDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }


    }

    private Boolean isAllowedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> isAllowedNumber(number));
    }

    private Boolean isAllowedNumber(Integer number) {
        return START_RANGE <= number && number <= END_RANGE;
    }

    private Boolean isAllowedNumbersLength(List<Integer> numbers) {
        return numbers.size() == LENGTH;
    }

    private Boolean isDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.toSet())
                .size() != LENGTH;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public String toString() {
        initBuilder();
        lottoBuilder.append(LEFT_BRACKET);

        for (int i=0; i<LENGTH; i++) {
            lottoBuilder.append(numbers.get(i))
                    .append(COMMA)
                    .append(SPACE);
        }

        lottoBuilder.replace(lottoBuilder.length()-2,
                lottoBuilder.length(),
                RIGHT_BRACKET);

        return lottoBuilder.toString();
    }

    private void initBuilder() {
        lottoBuilder.setLength(INIT_SIZE);
    }

}
