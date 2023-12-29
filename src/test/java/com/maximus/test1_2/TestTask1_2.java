package com.maximus.test1_2;

import com.maximus.task1_2.General;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask1_2 {


    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 10, 556})
    void isEvenNumber(int a) {
        assertTrue(General.evenOddNumber(a));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 9, 13, 271})
    void isOddNumber(int a) {
        assertFalse(General.evenOddNumber(a));
    }

    @ParameterizedTest
    @ValueSource(ints = {26,99})
    void numInIntervalIsOk(int i){
        assertTrue(General.numberInInterval(i));
    }

    @Test
    void numInIntervalIsLess(){
        assertFalse(General.numberInInterval(25));
    }

    @Test
    void numInIntervalIsGreater(){
        assertFalse(General.numberInInterval(100));
    }




}
