package lotto.model;

public class Cash {
    private static final Integer UNIT = 1_000;
    private final Integer amount;

    public Cash(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer amount) {
        if (!isMoreThanUnit(amount)) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상의 금액을 입력하세요");
        }

        if (!isDivisibleByUnit(amount)) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지는 금액을 입력하세요");
        }
    }


    private Boolean isMoreThanUnit(Integer amount) {
        return amount >= UNIT;
    }

    private Boolean isDivisibleByUnit(Integer amount) {
        return amount % UNIT == 0;
    }

    public Integer countNumberOfPurchaseLotto() {
        return amount / UNIT;
    }


//    이 부분 추후에 업데이트
//    public Double calculateBenefit(Integer prizeAmount) {
//
//    }
}
