package com.silent.fiveghost.tourist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void test(){
        int []a = {2,31,7,27,9,-3};

        for(int i =0;i < 2;i++)
        {
            for(int j = 0;j <  a.length - 1-i;j++)
            {
                if(a[j] < a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println(a[1]);
    }
}