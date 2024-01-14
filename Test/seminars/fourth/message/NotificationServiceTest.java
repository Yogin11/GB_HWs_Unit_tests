package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Задание №5
 * Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
 * Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
 * recipient), который отправляет сообщение получателю.
 * Вам необходимо проверить правильность работы класса NotiﬁcationService, который использует
 * MessageService для отправки уведомлений.
 */

class NotificationServiceTest {

    @Test
    void setNotificationServiceTest() {
        MessageService mockMessageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(mockMessageService);
        notificationService.sendNotification("str1","recip1");
        verify(mockMessageService,times(1)).sendMessage("str1","recip1");
    }


}