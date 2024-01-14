package seminars.fourth.card;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PaymentFormTest {

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */

CreditCard card = mock(CreditCard.class);


    @Test
    void cardNumberValid(){
        when(card.getCardNumber()).thenReturn("Test card number");
//        System.out.println(card.getCardNumber());
        assertThat(card.getCardNumber()).isEqualTo("Test card number");
    }

    @Test
    void cardHolderValid(){
        when(card.getCardHolder()).thenReturn("Card holder");
        assertThat(card.getCardHolder()).isEqualTo("Card holder");
    }

    @Test
    void cardExpiryDateValid(){
        when(card.getExpiryDate()).thenReturn("Expiry date");
        assertThat(card.getExpiryDate()).isEqualTo("Expiry date");
    }

    @Test
    void cardCvvValid(){
        when(card.getCvv()).thenReturn("CVV card number");
        assertThat(card.getCvv()).isEqualTo("CVV card number");
    }
    @Test
    void cardChargeValid(){
        PaymentForm paymentForm = new PaymentForm(card);
        paymentForm.pay(100);
        verify(card).charge(100);
    }

}
