package com.maximus;

import com.maximus.domain.ListObject;
import com.maximus.process.CalculationProcess;
import com.maximus.sources.FileReader;
import com.maximus.sources.SimpleListProvider;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        FileReader fileReader = new FileReader("filelist.txt");
        fileReader.serializeObj(new ListObject(List.of(4,3,2,4,5)));
        CalculationProcess calcProc = new CalculationProcess(fileReader, new SimpleListProvider());
        System.out.println(calcProc.processController());
    }
}