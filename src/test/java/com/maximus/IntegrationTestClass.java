package com.maximus;

import com.maximus.domain.ListObject;
import com.maximus.process.CalculationProcess;
import com.maximus.sources.FileReader;
import com.maximus.sources.SimpleListProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class IntegrationTestClass {
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
    void calcProcessCalculatesFileReaderListAverage() {
        fileReader = new FileReader("filelist.txt");
        List<Integer> list = fileReader.getList();
        calcProc = new CalculationProcess(fileReader, new SimpleListProvider());

        double result = calcProc.averageNumber(list);
        Integer sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        double calculation = (double) sum / list.size();

        assertEquals(calculation, result);
    }

    @Test
    void calcProcessCalculatesSimpleListProviderAverage() {
        List<Integer> list = simpleListProvider.getList();
        calcProc = new CalculationProcess(new FileReader("filelist.txt"), new SimpleListProvider());

        double result = calcProc.averageNumber(list);
        Integer sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        double calculation = (double) sum / list.size();

        assertEquals(calculation, result);
    }

    @Test
    void calcProcessInvokesFileReaderMethods() {
        calcProc.processController();

        verify(fileReader).getList();
    }

    @Test
    void calcProcessInvokesSimpleListProviderMethods() {
        calcProc.processController();

        verify(simpleListProvider).getList();
    }

    @Test //E2E test
    void getAndCompareAverageNumbersFromBothLists() {

        fileReader = new FileReader("testfile.txt");
        fileReader.serializeObj(new ListObject(List.of(3,3,10,9)));
        simpleListProvider = new SimpleListProvider();
        calcProc = new CalculationProcess(fileReader, simpleListProvider);

        double num1 = fileReader.getList().stream().mapToInt((a) -> a).summaryStatistics().getAverage();
        double num2 = simpleListProvider.getList().stream().mapToInt((a) -> a).summaryStatistics().getAverage();
        String statement = "Первый список имеет большее среднее значение";
        if (num1 < num2) {
            statement = "Второй список имеет большее среднее значение";
        } else if (num1 == num2) {
            statement = "Средние значения равны";
        }

        assertEquals(statement, calcProc.processController());
    }


}
