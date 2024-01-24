package com.maximus.sources;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleListProviderTest {
    SimpleListProvider simpleListProvider;

    @Test
    void getListTest(){
        simpleListProvider = new SimpleListProvider();
        assertTrue(simpleListProvider.getList() instanceof ArrayList<Integer>
                   && !simpleListProvider.getList().isEmpty()
                   && simpleListProvider.getList().stream().allMatch(el->el<10));
    }
}
