package com.maximus;

import com.maximus.domain.ListObject;
import com.maximus.sources.FileReader;
import com.maximus.sources.SimpleListProvider;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ListGetterTesting {

    private Collection<Object[]> data() {
        SimpleListProvider simpleListProvider = mock(SimpleListProvider.class);
        when(simpleListProvider.getList()).thenReturn(List.of(1,2,3));
        return Arrays.asList(new Object[][]{
                {new FileReader("filelist.txt"), List.of(4,3,2,4,5)},
              {simpleListProvider, List.of(1, 2, 3)}
        });
    }

    @ParameterizedTest
    @MethodSource("data")
    void getListTrue(ListGetter listGetter, List<Integer> list) {

        assertEquals(list, listGetter.getList());
    }
}
