package com.maximus.domain;

import java.io.Serializable;
import java.util.List;

public class ListObject implements Serializable {

    private List<Integer> numList;

    public ListObject(List<Integer> numList) {
        this.numList = numList;
    }

    public List<Integer> getNumList() {
        return numList;
    }

    @Override
    public String toString() {
        return "List: " + numList;
    }

}
