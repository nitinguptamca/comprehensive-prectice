package com.comprehensive.practice.custom.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
public class Request {

    @NotNull
    @NumberConstraint
    @ContactNumberConstraint
    private List<String> numbers;

    // Constructor, getters, setters, etc.

}

 class Controller {

    public void processRequest(@Valid Request request) {
         @NotNull List<String> sdfsdfs = request.getNumbers();
    }

     public static void main(String[] args) {
        Request request=new Request();
        List<String> str = Arrays.asList(new String[]{"","sdfsdf","12%%$#@"});
        request.setNumbers(str);

         Controller controller =new Controller();
         controller.processRequest(request);
     }

}