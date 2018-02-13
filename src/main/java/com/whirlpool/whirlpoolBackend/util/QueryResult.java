package com.whirlpool.whirlpoolBackend.util;

import java.util.List;

public class QueryResult {

    private Integer totalRecord;
    private List<Object> result;

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<Object> getResult() {
        return result;
    }

    public void setResult(List<Object> result) {
        this.result = result;
    }
}
