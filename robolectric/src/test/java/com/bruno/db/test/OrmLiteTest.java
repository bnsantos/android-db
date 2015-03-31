package com.bruno.db.test;

import com.bruno.db.ormlite.model.Project;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by bruno on 31/03/15.
 */
@RunWith(TestRunner.class)
public class OrmLiteTest {
    @Test
    public void test1(){
        Project p = new Project();
        p.setName("bla");
        Assert.assertNotNull(p);
    }
}
