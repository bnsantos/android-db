package com.bruno.db.test;

import com.bruno.db.sugar.model.Book;
import com.bruno.db.test.utils.Generator;
import com.orm.SugarDb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.shadows.ShadowLog;

import java.util.Calendar;

/**
 * Created by bruno on 31/03/15.
 */
@RunWith(TestRunner.class)
public class SugarTest {
    @Before
    public void init(){
        Mockito.mock(SugarDb.class)
        ShadowLog.stream = System.out;
    }

    @Test
    public void test1(){
        Book book = new Book();
        book.setName(Generator.nameGenerator.next());
        book.setCreatedAt(Calendar.getInstance().getTime());
        book.save();

        Book find = Book.findById(Book.class, book.getId());
        Assert.assertNotNull(find);
    }
}
