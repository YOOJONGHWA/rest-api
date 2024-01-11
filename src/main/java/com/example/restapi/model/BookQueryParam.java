package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                       // @Data 를 통해 get/set 메소드를 자동으로 생성해줌
@NoArgsConstructor          // 기본생성자 생성
@AllArgsConstructor         // 모든 인수를 받는 생성자 생성
public class BookQueryParam {

    private String category;
    private int issuedYear;
    private int issuedMonth;
    private int issuedDay;

}
