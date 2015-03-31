package com.bruno.db.test;

import com.bruno.db.ormlite.DatabaseHelper;
import com.bruno.db.ormlite.model.Project;
import com.bruno.db.ormlite.model.User;
import com.bruno.db.test.utils.Generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowLog;

import java.sql.SQLException;

/**
 * Created by bruno on 31/03/15.
 */
@RunWith(TestRunner.class)
public class OrmLiteTest {
    private DatabaseHelper mDbHelper;

    @Before
    public void init() {
        ShadowLog.stream = System.out;
        mDbHelper = new DatabaseHelper(Robolectric.application);
    }

    @Test
    public void testAddProject() {
        Project p = Generator._Project.generate();
        Assert.assertNotNull(p);

        try {
            mDbHelper.getProjectDAO().create(p);
            Project r = (Project) mDbHelper.getProjectDAO().queryForId(p.getId());
            Assert.assertNotNull(r);
            Assert.assertTrue(r.equals(p));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddUser() {
        User u = Generator._User.generate();
        Assert.assertNotNull(u);

        try {
            mDbHelper.getUsertDAO().create(u);
            User r = (User) mDbHelper.getUsertDAO().queryForId(u.getId());
            Assert.assertNotNull(r);
            Assert.assertTrue(r.equals(u));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
