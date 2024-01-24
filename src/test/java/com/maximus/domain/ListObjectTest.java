package com.maximus.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//
class ListObjectTest {

    private List<Integer> list;
    private ListObject listObject;

    @BeforeEach
    public void initializeList() {
        list = List.of(4, 5, 3, 2);
        listObject = new ListObject(list);
    }

    @Test
    void listObjectPromptlyCreated() {
        assertTrue(listObject.getNumList().size()==list.size()&&
                    !listObject.getNumList().isEmpty());
    }

    @Test
    void listObjectHasRightMembers() {
        assertEquals(list,listObject.getNumList().stream().toList());
    }

    @Test
    void toStringTest(){
        assertEquals("List: [4, 5, 3, 2]",listObject.toString());
    }

}
