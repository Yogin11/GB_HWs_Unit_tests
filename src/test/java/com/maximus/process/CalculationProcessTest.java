package com.maximus.process;

import com.maximus.sources.FileReader;
import com.maximus.sources.SimpleListProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalculationProcessTest {
    List<Integer> list1, list2;
    CalculationProcess calcProc;
    FileReader fileReader;
    SimpleListProvider simpleListProvider;

    @BeforeEach
    void init() {
        fileReader = mock(FileReader.class);
        simpleListProvider = mock(SimpleListProvider.class);
        calcProc = new CalculationProcess(fileReader, simpleListProvider);
    }


    @Test
    void averageNumberCalculationCorrect() {
        list1 = List.of(4, 5, 3, 2);

        assertEquals(3.5, calcProc.averageNumber(list1));

    }

    @Test
    void nullListExceptionThrow() {
        assertThrows(NullPointerException.class,()->calcProc.averageNumber(list2));
    }

    @Test
    void compareNumsTestAGreaterB() {
        assertEquals("Первый список имеет большее среднее значение", calcProc.compareNums(5.0, 3.0));
    }

    @Test
    void compareNumsTestALowerB() {
        assertEquals("Второй список имеет большее среднее значение",calcProc.compareNums(2.1, 3.0));
    }

    @Test
    void compareNumsTestAEqualsB() {
        assertEquals("Средние значения равны", calcProc.compareNums(4.0, 4.0));
    }

    @Test
    void processControllerTest(){

        when(fileReader.getList()).thenReturn(List.of(2,2));
        when(simpleListProvider.getList()).thenReturn(List.of(3,3));
        String result = calcProc.processController();

        assertEquals("Второй список имеет большее среднее значение", result);
    }
}
