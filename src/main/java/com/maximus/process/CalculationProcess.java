package com.maximus.process;


import com.maximus.sources.FileReader;
import com.maximus.sources.SimpleListProvider;

import java.util.List;

public class CalculationProcess {

    FileReader fileReader;
    SimpleListProvider simpleListProvider;

    public CalculationProcess(FileReader fileReader, SimpleListProvider simpleListProvider) {
        this.fileReader = fileReader;
        this.simpleListProvider = simpleListProvider;

    }

    public String processController(){
        double avg1 = averageNumber(fileReader.getList());
        double avg2 = averageNumber(simpleListProvider.getList());
        return compareNums(avg1,avg2);
    }

    public double averageNumber(List<Integer> list){
        if (list!=null) {
            return (double) list.stream()
                    .mapToInt(Integer::intValue)
                    .sum() / list.size();
        }
        throw new NullPointerException();

    }

    public String compareNums(double num1, double num2){
            if (num1>num2)
                return "Первый список имеет большее среднее значение";
            else if (num1<num2)
                return "Второй список имеет большее среднее значение";
            else
                return "Средние значения равны";
    }

}
