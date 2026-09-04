package com.crodi;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: crodi.zhang
 * @Date: 2026/8/4 11:33
 * @Description: TODO
 **/


public class CycleCheckServiceTest {


    @Test
    public void checkRouteCycle() {

        Map<Integer,Integer> map = Maps.newHashMap();
        map.put(4,2);
        map.put(2,1);
        map.put(1,5);
        map.put(5,4);
        checkService(map);
    }


    private void checkService(Map<Integer, Integer> routes) {


        List<List<Integer>> list = Lists.newArrayList();

        for (int i = 0; i < routes.size(); i++) {
            Integer start = routes.get(i);
            Integer end = routes.get(i);

            List<Integer> cycle = Lists.newArrayList();
            for (int j = i + 1; j < routes.size(); j++) {
                Integer nextStart = routes.get(j);
                Integer nextEnd = routes.get(j);
                if (Objects.equals(start, nextEnd) && Objects.equals(end, nextStart)) {
                    cycle.add(start);
                    cycle.add(end);
                    list.add(cycle);
                }
            }

        }


    }


    public static void main(String[] args) {

        int i = 1;
        int j = 2;


    }


    public void dynamicProgramming(int n) {

        int[] choices = {1, 2};


        int count = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < choices.length; j++) {
                int step = i + choices[j];
                if (step >= n) {
                    break;
                }
                count++;
            }

        }


    }


    public void singleStep() {

    }




}
