package org.example.dao;

import org.example.exception.RecordAlreadyExistsException;
import org.example.exception.RecordNotFoundException;
import org.example.model.Record;
import java.util.List;


public interface RecordDao<T> {
    void addRecord(Record record) throws RecordAlreadyExistsException;

    void updateRecord(Record record) throws RecordNotFoundException, RecordAlreadyExistsException;

    void deleteRecord(Record record) throws RecordNotFoundException;

    Record getRecordByAccount(long account) throws RecordNotFoundException;

    List<Record> getRecordByName(String name);

    List<Record> getRecordByValue(double value);

}
