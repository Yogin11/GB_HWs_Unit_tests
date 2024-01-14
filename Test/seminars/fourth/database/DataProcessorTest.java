package seminars.fourth.database;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Задание №6
 * Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
 * Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQL-
 * запрос и возвращает результат.
 * Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
 * выполнения запроса и обработки результатов.
 */

class DataProcessorTest {

    @Test
    void dbquery(){
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);
        ArrayList<String> list = new ArrayList<>();
        list.add("testdata1");
        when(database.query("test")).thenReturn(list);
        assertThat(dataProcessor.processData("test").get(0)).isEqualTo("testdata1");

    }

}