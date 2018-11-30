package com.shang.test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * add by shanghuaichao
 *
 * @date 2018/11/30 下午5:12
 */
public class TestMap {

    @Test
    public void testHashMap() {
        long start = System.currentTimeMillis();
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < 100000000; i++) {
            hashSet.add(i);
        }
        Assert.assertTrue(hashSet.contains(2));
        Assert.assertTrue(hashSet.contains(99));
        Assert.assertTrue(hashSet.contains(4));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start));
    }

    @Test
    public void bloomFilterTest() {
        long star = System.currentTimeMillis();
        BloomFilters bloomFilters = new BloomFilters(10000000);
        for (int i = 0; i < 100000000; i++) {
            bloomFilters.add(i + "");
        }
        Assert.assertTrue(bloomFilters.check(1 + ""));
        Assert.assertTrue(bloomFilters.check(2 + ""));
        Assert.assertTrue(bloomFilters.check(3 + ""));
        Assert.assertTrue(bloomFilters.check(999999 + ""));
        //Assert.assertFalse(bloomFilters.check(400230340 + ""));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }

    @Test
    public void guavaTest() {
        long star = System.currentTimeMillis();
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(),
                10000000, 0.01);
        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }
        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(2));
        Assert.assertTrue(filter.mightContain(3));
        Assert.assertFalse(filter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - star));
    }

}
