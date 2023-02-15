package org.example.operation;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import org.example.data.DataRow;

public interface JoinOperation<D1, D2, R> {
    Collection<R> join(Collection<D1> leftCollection, Collection<D2> rightCollection);

    static Map<Integer, String> createMap(Collection<DataRow<Integer, String>> collection) {
        return collection.stream().collect(Collectors.toMap(DataRow::getKey, DataRow::getValue));
    }
}
