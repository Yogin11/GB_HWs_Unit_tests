package com.maximus.sources;

import com.maximus.ListGetter;
import com.maximus.domain.ListObject;

import java.io.*;
import java.util.List;

import static javax.script.ScriptEngine.FILENAME;

public class FileReader implements ListGetter {

    private final String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }


    public ListObject deSerialObj() {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ListObject) objectInputStream.readObject();
        } catch (ClassCastException | ClassNotFoundException e) {
            throw new RuntimeException("Ошибка десериализации класса объекта ");
        } catch (IOException e){
            throw new RuntimeException("Ошибка вывода данных");
        }
    }


    public void serializeObj(ListObject listObject) {
        if (listObject==null){
            throw new RuntimeException("Передан пустой объект для сериализации");
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new
                     ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(listObject);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось сериализовать объект");
        }
    }


    @Override
    public List<Integer> getList() {
        return deSerialObj().getNumList();
    }
}
