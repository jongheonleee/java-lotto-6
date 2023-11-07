package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Cash;
import lotto.domain.WinnerLotto;
import lotto.dto.RequestCash;
import lotto.dto.RequestWinnerLotto;
import lotto.parser.Parser;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.CharacterUnits.COMMA;
import static lotto.util.CharacterUnits.ENTER;
import static lotto.view.InputViewMessage.*;

public class InputView {

    public RequestCash requestCash() throws IllegalStateException {
        try {
            System.out.println(INPUT_CASH_MESSAGE.getMessage());
            final String requestCash = getInput();
            final Integer cash = Parser.parseInt(requestCash);
            return RequestCash.of(cash);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestCash();
        } catch (IllegalStateException e) {
            throw e;
        }
    }

    public List<Integer> inputWinnerNumbers() throws IllegalArgumentException, IllegalStateException {
        try {
            System.out.println();
            System.out.println(INPUT_WINNER_NUMBER_MESSAGE.getMessage());
            final String requestWinnerNumbers = getInput();
            final List<String> numberDummy = Parser.parseNumberDummy(requestWinnerNumbers);
            InputValidator.validateInputNumbersFormat(numberDummy);
            return Parser.parseNumbers(numberDummy);
        } catch (Exception e) {
            throw e;
        }
    }
    public Integer inputBonusNumber() throws IllegalArgumentException, IllegalStateException {
        try {
            System.out.println();
            System.out.println(INPUT_BONUS_NUMBER.getMessage());
            final String requestBonusNumber = getInput();
            return Parser.parseInt(requestBonusNumber);
        } catch (Exception e) {
            throw e;
        }
    }


    public RequestWinnerLotto requestWinnerLotto() throws IllegalStateException {
        try {
            final List<Integer> winnerNumbers = requestWinnerNumbers();
            final Integer bonusNumber = requestBonusNumber();
            return RequestWinnerLotto.of(winnerNumbers, bonusNumber);
        } catch (IllegalStateException e) {
            throw e;
        }
    }

    private List<Integer> requestWinnerNumbers() throws IllegalStateException {
        try {
            System.out.println();
            System.out.println(INPUT_WINNER_NUMBER_MESSAGE.getMessage());
            final String requestWinnerNumbers = getInput();
            final List<String> numberDummy = Parser.parseNumberDummy(requestWinnerNumbers);
            InputValidator.validateInputNumbersFormat(numberDummy);
            return Parser.parseNumbers(numberDummy);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestWinnerNumbers();
        } catch (IllegalStateException e) {
            throw e;
        }
    }

    private Integer requestBonusNumber() throws IllegalStateException {
        try {
            System.out.println();
            System.out.println(INPUT_BONUS_NUMBER.getMessage());
            final String requestBonusNumber = getInput();
            return Parser.parseInt(requestBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestBonusNumber();
        } catch (IllegalStateException e) {
            throw e;
        }
    }



    private String getInput() throws IllegalStateException {
        try {
            final String input = Console.readLine();
            InputValidator.validateBlank(input);
            return input;
        } catch (IllegalStateException e) {
            throw e;
        }
    }


    public void close() {
        Console.close();
    }
}
