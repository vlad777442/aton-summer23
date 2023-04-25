package org.example;

import org.example.dao.RecordDaoImpl;
import org.example.exception.RecordAlreadyExistsException;
import org.example.exception.RecordNotFoundException;
import org.example.model.Record;

/**
 *
 * Для реализации функциональности по добавлению, удалению, обновлению и поиску записей
 * можно использовать структуру данных HashMap, которая обеспечивает
 * доступ к элементам по ключу. В качестве ключа может использоваться номер счета.
 *
 * Для поиска записей по имени и значению можно использовать дополнительные HashMap,
 * которые связывают имя и значение с соответствующим списком записей. Это позволяет
 * эффективно находить все записи с заданным именем.
 * Такую же структуру можно использовать для значений.
 *
 * Временная сложность доступа и вставки элемента в HashMap составляет O(1).
 *
 * Также можно использовать оптимизированные алгоритмы для поиска записей по имени
 * и значению, например, алгоритмы хеширования и сортировки.
 *
 */
public class App 
{
    public static void main( String[] args ) throws RecordAlreadyExistsException, RecordNotFoundException {
        RecordDaoImpl recordDao = new RecordDaoImpl();
        Record record1 = new Record(1, "User1", 2035.34);
        Record record2 = new Record(2, "User2", 3035.34);
        Record record3 = new Record(3, "Смирнов Иван Иванович", 2035.34);
        Record record4 = new Record(4, "Ковальчук Иван Иванович", 5035.34);
        Record record5 = new Record(5, "Иванов Иван Иванович", 2035.34);

        recordDao.addRecord(record1);
        recordDao.addRecord(record2);
        recordDao.addRecord(record3);
        recordDao.addRecord(record4);
        recordDao.addRecord(record5);

//        Получение записи по номеру аккаунта
        System.out.println(recordDao.getRecordByAccount(1));
        System.out.println(recordDao.getRecordByAccount(2));
        System.out.println(recordDao.getRecordByAccount(3));

//        Получение записи по имени
        System.out.println(recordDao.getRecordByName("User1"));

//        Получение записи по значению
        System.out.println(recordDao.getRecordByValue(2035.34));

        Record new_record = new Record(1, "New name", 1234);
        recordDao.updateRecord(new_record);
        recordDao.deleteRecord(record2);
    }
}
