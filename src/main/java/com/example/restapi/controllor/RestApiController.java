package com.example.restapi.controllor;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController             // @Controller는 주로 View를 반환하는 데 사용되는 컨트롤러에 적합하고,
                            // @RestController는 데이터를 반환하는 데 사용되는 컨트롤러에 적합
@RequestMapping("/api")  // 공통적인 주소를 묶어주는 역활
public class RestApiController {

    @GetMapping(path = "/hello")    // 실직적인 주소는 "/api/hello"
    public String hello() {
        var html = "<html> <body> <h1>Hello Spring Boot</h1> </body</html>";

        return html;
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}") // html 주소는 대문자를 사용하지 않는다.
    public  String echo(
            @PathVariable(name = "message") String msg, // 카멜케이스를 적용하기위해 @PathVariable에 변수명을 맞춰준다.
            @PathVariable(name = "age") int age,
            @PathVariable(name = "isMan") boolean isMan
    ) {
        System.out.println("echo message : " + msg);
        System.out.println("echo age : " + age);
        System.out.println("echo isMan : " + isMan);

        return msg.toUpperCase();
    }
    // http://localhost:8086/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "book") // queryParam를 사용하는 2가지 방식 중 하나 4개 이하정도면 사용 고려
                                  // ?변수명=변수값&변수명=변수값
    public void queryParam(
            @RequestParam String category,
            @RequestParam int issuedYear,
            @RequestParam(name = "issued-month") int issuedMonth,
            @RequestParam(name = "issued_day") int issuedDay
            ) {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }
    // http://localhost:8086/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    @GetMapping("/book2")   // DTO 객체를 받아서 사용하는 방식 많은 양을 한번에 받아올수 있다.
    public void queryParamDto(
        BookQueryParam bookQueryParam
    ) {
        System.out.println(bookQueryParam);
    }
    // TODO Parameter  int 형태로 받아서 두 수의 덧셈, 곱셈
    // localhost:8086/api/calculate?a=1&b=2
    @GetMapping("/calculate")
    public void cal(
            @RequestParam int a,
            @RequestParam int b
    ) {
        System.out.println(a + b);
        System.out.println(a * b);
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
            @PathVariable String userName
    ) {
        log.info("user-name : {}", userName);
    }
}
/*
*  정리하자면 @PathVariable 을 사용할때는
*  @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
*  @PathVariable(name = "message") String msg, 카멜케이스를 적용하기위해 @PathVariable에 변수명을 맞춰준다.
*
*  @RequestParam 을 사용할때는
*  http://localhost:8086/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
*  @GetMapping(path = "book") /
*  @RequestParam(name = "issued-month") int issuedMonth,
*
* */