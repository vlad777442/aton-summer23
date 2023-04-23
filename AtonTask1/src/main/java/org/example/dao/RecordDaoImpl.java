package org.example.dao;

import org.example.exception.RecordAlreadyExistsException;
import org.example.exception.RecordNotFoundException;
import org.example.model.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordDaoImpl implements RecordDao<Record>  {
    private Map<Long, Record> accountsMap;
    private Map<String, List<Record>> namesMap;
    private Map<Double, List<Record>> valuesMap;

    public RecordDaoImpl() {
        accountsMap = new HashMap<>();
        namesMap = new HashMap<>();
        valuesMap = new HashMap<>();
    }

    public RecordDaoImpl(Map<Long, Record> accountsMap, Map<String, List<Record>> namesMap, Map<Double, List<Record>> valuesMap) {
        this.accountsMap = accountsMap;
        this.namesMap = namesMap;
        this.valuesMap = valuesMap;
    }

    public void addRecord(Record record) throws RecordAlreadyExistsException {
        if (accountsMap.get(record.getAccount()) != null)
            throw new RecordAlreadyExistsException("Account already exists.");
        else {
            accountsMap.put(record.getAccount(), record);

            if (!namesMap.containsKey(record.getName()))
                namesMap.put(record.getName(), new ArrayList<Record>());
            namesMap.get(record.getName()).add(record);

            if (!valuesMap.containsKey(record.getValue()))
                valuesMap.put(record.getValue(), new ArrayList<Record>());
            valuesMap.get(record.getValue()).add(record);
        }

    }

    public void updateRecord(Record record) throws RecordNotFoundException, RecordAlreadyExistsException {
        deleteRecord(record);
        addRecord(record);
    }

    public void deleteRecord(Record record) throws RecordNotFoundException {
        if (accountsMap.get(record.getAccount()) == null)
            throw new RecordNotFoundException("Account not found.");
        else {
            accountsMap.remove(record);
            namesMap.get(record.getName()).remove(record);
            valuesMap.get(record.getValue()).remove(record);
        }
    }

    public Record getRecordByAccount(long account) throws RecordNotFoundException {
        if (!accountsMap.containsKey(account))
            throw new RecordNotFoundException("Account not found.");
        else return accountsMap.get(account);
    }

    public List<Record> getRecordByName(String name) {
        List<Record> records = namesMap.get(name);
        if (records != null)
            return records;
        else return new ArrayList<>();
    }

    public List<Record> getRecordByValue(double value) {
        List<Record> records = valuesMap.get(value);
        if (records != null)
            return records;
        else return new ArrayList<>();
    }


}

