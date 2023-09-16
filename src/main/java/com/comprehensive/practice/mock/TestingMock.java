package com.comprehensive.practice.mock;

//How to mock the method in same class

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Temp{

    public boolean methodB(String param){
        return true;
    }
    public boolean methodA(String param) {
        try {
            if(methodB(param))
                return true;

            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
public class TestingMock {

    @Test
    public void testMethodA() {

        Temp temp = new Temp();
        Temp spyTemp = Mockito.spy(temp);

        Mockito.doReturn(true).when(spyTemp).methodB(Mockito.any());
        boolean status = temp.methodA("XYZ");
        
    }
}
