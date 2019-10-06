package com.mine.belf;

import static java.util.Comparator.naturalOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class ListTests
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void isNewArrayHasDefaultSize() {
        DIYarrayList<Integer> list = new DIYarrayList<>();
        assertEquals(list.size(), 0);
    }

    @Test
    public void isNewArrayListEmpty() {
        DIYarrayList<Integer> list = new DIYarrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void isAddMethodWorks() {
        DIYarrayList<Integer> list = new DIYarrayList<>();
        list.add(1);

        for(int i = 0; i < 20; i++) {
            list.add(i);
        }

        assertEquals(list.size(), 21);
    }

    @Test
    public void isAddAllWorks() {
        ArrayList<Integer> sourceList = new ArrayList<>();
        DIYarrayList<Integer> destList = new DIYarrayList<>();

        for(int i = 0; i < 20; i++) {
            sourceList.add(i);
        }

        destList.addAll(sourceList);

        for (int i = 0; i < destList.size(); i++) {
            System.out.println(destList.get(i));
        }

    }

    @Test
    public void isCollectionsCopyAllWorks() {
        ArrayList<Integer> destList = new ArrayList<>();
        DIYarrayList<Integer> sourceList = new DIYarrayList<>();

        destList.add(1);
        sourceList.add(2);

        Collections.copy(destList, sourceList);

        Assert.assertEquals(destList.get(0), (Integer) 2);
    }

    @Test
    public void isCollectionsAddAllWorks() {
        ArrayList<Object> destList = new ArrayList<>();
        DIYarrayList<Integer> sourceList = new DIYarrayList<>();

        destList.add(1);
        sourceList.add(2);

        Collections.addAll(destList, sourceList.toArray());

        Assert.assertTrue(destList.size() == 2);
        Assert.assertTrue(destList.contains(sourceList.get(0)));
    }
}
