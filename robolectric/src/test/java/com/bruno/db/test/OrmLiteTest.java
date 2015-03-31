package com.bruno.db.test;

import com.bruno.db.ormlite.DatabaseHelper;
import com.bruno.db.ormlite.model.Project;
import com.bruno.db.ormlite.model.User;
import com.bruno.db.test.utils.Generator;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.ForeignCollection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowLog;

import java.sql.SQLException;
import java.util.List;

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
            mDbHelper.getUserDAO().create(u);
            User r = (User) mDbHelper.getUserDAO().queryForId(u.getId());
            Assert.assertNotNull(r);
            Assert.assertTrue(r.equals(u));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testForeignCollectionField() throws SQLException {
        Project p = Generator._Project.generate();
        mDbHelper.getProjectDAO().create(p);

        List<User> users = Generator._User.generate(10);
        for (User u : users) {
            u.setProject(p);
            mDbHelper.getUserDAO().create(u);
        }
        Project r = (Project) mDbHelper.getProjectDAO().queryForId(p.getId());
        Assert.assertTrue(p.equals(r));

        CloseableIterator<User> iterator = r.getUsers().closeableIterator();
        int index = 0;
        while (iterator.hasNext()) {
            User u = iterator.next();
            Assert.assertEquals(users.get(index++), u);
        }
        iterator.close();

        Assert.assertEquals(index, r.getUsers().size());
    }

    @Test
    public void testForeignCollectionField2() throws SQLException {
        Project p = Generator._Project.generate();
        mDbHelper.getProjectDAO().create(p);

        List<User> users = Generator._User.generate(10);
        ForeignCollection foreignCollection = mDbHelper.getProjectDAO().getEmptyForeignCollection("users");
        for (User u : users) {
            u.setProject(p);
            foreignCollection.add(u);
        }

        Project r = (Project) mDbHelper.getProjectDAO().queryForId(p.getId());
        Assert.assertTrue(p.equals(r));

        CloseableIterator<User> iterator = r.getUsers().closeableIterator();
        int index = 0;
        while (iterator.hasNext()) {
            User u = iterator.next();
            Assert.assertEquals(users.get(index++), u);
        }
        iterator.close();

        Assert.assertEquals(index, r.getUsers().size());
    }
}
