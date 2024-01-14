package seminars.fourth.hotel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import seminars.fourth.hotel.BookingService;
import seminars.fourth.hotel.HotelService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 Вам необходимо написать тест с использованием моков для сервиса бронирования отелей.
 Условие: У вас есть класс HotelService с методом public boolean isRoomAvailable(int roomId),
 который обычно проверяет, доступен ли номер в отеле.
 Вам необходимо проверить правильность работы класса BookingService, который
 использует HotelService для бронирования номера, если он доступен.
 */

class BookingServiceTest {

    //   @Test
    @ParameterizedTest
    @CsvSource({
            "3,false",
            "4,true"})
    void bookRoomTest(int roomNumber, boolean isAvailable) {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(roomNumber)).thenReturn(isAvailable);
        boolean result = bookingService.bookRoom(roomNumber);
        assertThat(result).isEqualTo(isAvailable);
    }
    //Вариант препода!!
    @Test
    void test(){
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(anyInt())) //Т.е. можем ввести любое число с клавиатуры
                .thenAnswer(inv->{
                    int roomNumber= inv.getArgument(0);
                    return roomNumber%2==0;
                });

        assertTrue(bookingService.bookRoom(2));
        assertFalse(bookingService.bookRoom(1));
    }

}


//class BookingServiceTest {
//    HotelService hotelService;
//    BookingService bookingService;
//
//    @BeforeEach
//    void init() {
//        hotelService = mock(HotelService.class);
//        bookingService = new BookingService(hotelService);
//    }
//
//    @Test
//    void correctBookingEven() {
//        when(hotelService.isRoomAvailable(2)).thenReturn(true);
//        assertTrue(bookingService.bookRoom(2));
//    }
//
//    @Test
//    void noBookingOdd() {
//        when(hotelService.isRoomAvailable(5)).thenReturn(false);
//        assertFalse(bookingService.bookRoom(5));
//    }
//
//
//
//}