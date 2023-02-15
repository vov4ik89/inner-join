package org.example.operation.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.example.data.DataRow;
import org.example.data.JoinedDataRow;
import org.example.operation.JoinOperation;

public class LeftJoinOperation implements JoinOperation<
        DataRow<Integer, String>,
        DataRow<Integer, String>,
        JoinedDataRow<Integer, String, String>
        > {
    @Override
    public Collection<JoinedDataRow<Integer, String, String>> join(
            Collection<DataRow<Integer, String>> leftCollection,
            Collection<DataRow<Integer, String>> rightCollection
    ) {
        Collection<JoinedDataRow<Integer, String, String>> result = new ArrayList<>();
        Map<Integer, String> map = JoinOperation.createMap(rightCollection);
        for (DataRow<Integer, String> left : leftCollection) {
            Integer key = left.getKey();
            String value1 = left.getValue();
            String value2 = map.get(key);
            result.add(new JoinedDataRow<>(key, value1, value2));
        }
        return result;
    }
}
