package com.maximus.sources;

import com.maximus.ListGetter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleListProvider implements ListGetter {
    private Random rand = new Random();
    private List<Integer> list;

    public SimpleListProvider() {
        this.list = listGenerator();
    }

    private List<Integer> listGenerator(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(rand.nextInt(10));
        }
        return list;
    }

    @Override
    public List<Integer> getList() {
        return list;
    }
}
