package seminars.fourth.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest{
    BookRepository mockBookRepository;
    BookService bookService;
    Book book1;
    Book book2;
    List<Book> list;

    @BeforeEach
    void init(){
        mockBookRepository =mock(BookRepository.class);
        bookService = new BookService(mockBookRepository);
        list = new ArrayList<>();
        book1 = new Book("1","Книга1","Автор1");
        book2 = new Book("2","Книга2","Автор2");
        list.add(book1);
        list.add(book2);

    }

    @Test
    void findBookByIdTest(){
        when(mockBookRepository.findById("1")).thenReturn(book1);
        Book book = bookService.findBookById("1");
        assertThat(book.getTitle()).isEqualTo("Книга1");
    }
    @Test
    void findAllBooksTest(){
        when(mockBookRepository.findAll()).thenReturn(list);
        assertThat(bookService.findAllBooks()).isEqualTo(list);
    }
}