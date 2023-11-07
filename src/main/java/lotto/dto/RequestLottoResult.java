package lotto.dto;

import java.util.List;

import lotto.domain.Prize;


public record RequestLottoResult(
        List<Prize> results
) {
   public static RequestLottoResult of(List<Prize> results) {
       return new RequestLottoResult(results);
   }



}