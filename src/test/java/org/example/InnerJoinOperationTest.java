package org.example;

import java.util.ArrayList;
import java.util.Collection;
import org.example.data.DataRow;
import org.example.data.JoinedDataRow;
import org.example.operation.JoinOperation;
import org.example.operation.impl.InnerJoinOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InnerJoinOperationTest {
    private static Collection<DataRow<Integer, String>> leftCollection;
    private static Collection<DataRow<Integer, String>> rightCollection;
    private static Collection<JoinedDataRow<Integer, String, String>> result;

    private static JoinOperation<
            DataRow<Integer, String>,
            DataRow<Integer, String>,
            JoinedDataRow<Integer, String, String>> operation;

    @Before
    public void setUp() {
        leftCollection = new ArrayList<>();
        rightCollection = new ArrayList<>();
        result = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "Germany"));
        leftCollection.add(new DataRow<>(2, "France"));
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));
    }

    @Test
    public void join_correctData_Ok() {
        operation = new InnerJoinOperation();
        Collection<JoinedDataRow<Integer, String, String>> actual = operation.join(leftCollection, rightCollection);
        result.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        result.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
        Assert.assertEquals(result.toString(), actual.toString());
    }

    @After
    public void afterEach() {
        result.clear();
    }
}
