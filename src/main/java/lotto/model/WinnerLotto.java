package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerLotto {
    private static final Integer START_RANGE = 1;
    private static final Integer END_RANGE = 45;
    private static final Integer LENGTH = 6;
    private final List<Integer> winnerNumbers;
    private final Integer bonusNumber;

    public WinnerLotto(List<Integer> winnerNumbers, Integer bonusNumber) {
        validate(winnerNumbers, bonusNumber);
        this.winnerNumbers = new ArrayList<>(winnerNumbers);
        Collections.sort(this.winnerNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, Integer bonusNumber) {
        if (!isAllowedNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 허용범위는 1~45");
        }

        if (!isAllowedNumbersLength(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 6개 입니다.");
        }

        if (isDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }

        if (!isAllowedNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 허용범위는 1~45");
        }

        if (isDuplicatedBetweenWinnerNumbersAndBonusNumber(numbers, bonusNumber)) {
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


    private Boolean isDuplicatedBetweenWinnerNumbersAndBonusNumber(List<Integer> winnerNumbers, Integer bonusNumber) {
        return winnerNumbers.contains(bonusNumber);
    }

    private Integer countHitNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> winnerNumbers.contains(number))
                .collect(Collectors.toList())
                .size();
    }

    private Boolean isBonusNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }

    public LottoResult calculateLottoResult(List<Integer> numbers) {
        Integer hitNumber = countHitNumber(numbers);
        Boolean isBonus = isBonusNumber(numbers);
        return LottoResult.of(hitNumber, isBonus);
    }
}
