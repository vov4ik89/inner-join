package org.example.operation.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.example.data.DataRow;
import org.example.data.JoinedDataRow;
import org.example.operation.JoinOperation;

public class InnerJoinOperation implements JoinOperation<
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
        Map<Integer, String> map = JoinOperation.createMap(leftCollection);
        for (DataRow<Integer, String> right : rightCollection) {
            if (map.containsKey(right.getKey())) {
                Integer key = right.getKey();
                String value1 = map.get(key);
                String value2 = right.getValue();
                result.add(new JoinedDataRow<>(key, value1, value2));
            }
        }
        return result;
    }
}
