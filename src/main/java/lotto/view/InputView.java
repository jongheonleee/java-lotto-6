package lotto.view;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

import lotto.dto.RequestCash;
import lotto.dto.RequestWinnerLotto;

import lotto.parser.Parser;

import lotto.validator.InputValidator;


import static lotto.view.InputViewMessage.INPUT_CASH_MESSAGE;
import static lotto.view.InputViewMessage.INPUT_WINNER_NUMBER_MESSAGE;
import static lotto.view.InputViewMessage.INPUT_BONUS_NUMBER;


public class InputView {

    public RequestCash requestCash() throws IllegalArgumentException, IllegalStateException {
        try {
            System.out.println(INPUT_CASH_MESSAGE.getMessage());
            final String requestCash = getInput();
            InputValidator.validateCashFormat(requestCash);
            final Integer amount = Parser.parseInt(requestCash);
            return RequestCash.of(amount);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Integer> requestWinnerNumbers() throws IllegalArgumentException, IllegalStateException  {
        try {
            System.out.println();
            System.out.println(INPUT_WINNER_NUMBER_MESSAGE.getMessage());
            final String requestWinnerNumbers = getInput();
            InputValidator.validateWinnerNumberFormat(requestWinnerNumbers);
            return Parser.parseNumbers(requestWinnerNumbers);
        } catch (Exception e) {
            throw e;
        }
    }

    public Integer requestBonusNumber() throws IllegalArgumentException, IllegalStateException {
        try {
            System.out.println();
            System.out.println(INPUT_BONUS_NUMBER.getMessage());
            final String requestBonusNumber = getInput();
            InputValidator.validateBonusNumberFormat(requestBonusNumber);
            return Parser.parseInt(requestBonusNumber);
        } catch (Exception e) {
            throw e;
        }
    }


    private String getInput() throws IllegalArgumentException, IllegalStateException {
        try {
            final String input = Console.readLine();
            InputValidator.validateInputFormat(input);
            return input;
        } catch (Exception e) {
            throw e;
        }
    }


    public void close() {
        Console.close();
    }
}
