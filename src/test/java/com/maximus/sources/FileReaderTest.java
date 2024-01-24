package com.maximus.sources;

import com.maximus.domain.ListObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    private List<Integer> list;
    private ListObject listObject;
    private FileReader fileReader;

    @BeforeEach
    void init(){
        list = List.of(4,5,6,3);
        listObject = new ListObject(list);

    }


    @Test
    void serializeObjNullListObjectThrowsException(){
        fileReader = new FileReader("somefile.txt");

        RuntimeException runExc= assertThrows(RuntimeException.class, ()->fileReader.serializeObj(null));
        assertEquals("Передан пустой объект для сериализации", runExc.getMessage());

    }

    @Test
    void serializeObjNullFileThrowsException(){
        fileReader = new FileReader("");

        RuntimeException runExc= assertThrows(RuntimeException.class, ()->fileReader.serializeObj(listObject));
        assertEquals("Не удалось сериализовать объект", runExc.getMessage());

    }

    @Test
    void deSerializeObjNullFileThrowsException(){
        fileReader = new FileReader("");

        RuntimeException runExc=assertThrows(RuntimeException.class, ()->fileReader.deSerialObj());
        assertEquals("Ошибка вывода данных", runExc.getMessage());

    }

    @Test
    void deSerializeObjWrongClassThrowsException(){
        new File("file_for_test.txt");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file_for_test.txt"))) {
            byte[] byteArray = "some random string".getBytes();
            oos.writeObject(byteArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileReader fileReader1 = new FileReader("file_for_test.txt");

        RuntimeException thrown = assertThrows(RuntimeException.class, fileReader1::deSerialObj);
        assertEquals("Ошибка десериализации класса объекта ",thrown.getMessage());
    }

    @Test
    void getListFileReader(){
        fileReader = new FileReader("filelist.txt");

        assertEquals(List.of(4,3,2,4,5), fileReader.getList());
    }
}
