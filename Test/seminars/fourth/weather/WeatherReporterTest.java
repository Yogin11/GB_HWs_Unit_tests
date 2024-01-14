package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Задание №3
 * Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
 * обращающийся к внешнему API для получения информации о текущей температуре.
 * Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
 * Создайте мок-объект для WeatherService с использованием Mockito.
 */

class WeatherReporterTest {

@Test
    void generateReportTest(){

        WeatherService weatherService = mock(WeatherService.class);
        when(weatherService.getCurrentTemperature()).thenReturn(25);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);
        String result = weatherReporter.generateReport();
        assertThat(result).isEqualTo("Текущая температура: " + 25 + " градусов.");
//        verify(weatherService).getCurrentTemperature();
    }



}