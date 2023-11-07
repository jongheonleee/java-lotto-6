package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;
import lotto.domain.WinnerLotto;
import lotto.parser.Parser;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.CharacterUnits.COMMA;
import static lotto.util.CharacterUnits.ENTER;
import static lotto.view.InputViewMessage.*;

public class InputView {

    // requestCash
    public Cash inputCash() {
        System.out.println(INPUT_CASH_MESSAGE.getMessage());
        final String input = getInput();
        final Integer cash = Parser.parseInt(input);
        return new Cash(cash);
    }


    // 밑에 두 메서드 하나로 묶어서 requestWinnerLotto
    public List<Integer> inputWinnerNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNER_NUMBER_MESSAGE.getMessage());
        final String input = getInput();
        final List<String> numberDummy = Parser.parseNumberDummy(input);
        InputValidator.validateInputNumbersFormat(numberDummy);
        return Parser.parseNumbers(numberDummy);
    }

    public Integer inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        final String input = getInput();
        return Parser.parseInt(input);
    }


    private String getInput() {
        final String input = Console.readLine();
        InputValidator.validateBlank(input);
        return input;
    }


    public void close() {
        Console.close();
    }
}
