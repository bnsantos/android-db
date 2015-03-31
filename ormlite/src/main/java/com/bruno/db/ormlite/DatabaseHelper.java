package com.bruno.db.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.bruno.db.ormlite.model.Project;
import com.bruno.db.ormlite.model.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by bruno on 31/03/15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getName();
    private static final String DATABASE_NAME = "com.bruno.db.ormlite";
    private static final int DATABASE_VERSION = 1;

    private Dao mProjectDAO = null;
    private Dao mUserDAO = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        dropTables();
        createTables();
    }

    private void createTables() {
        try {
            Log.i(TAG, "createTables");
            TableUtils.createTable(connectionSource, Project.class);
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            Log.e(TAG, "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    private void dropTables() {
        try {
            Log.i(TAG, "dropTables");
            TableUtils.dropTable(connectionSource, Project.class, false);
            TableUtils.dropTable(connectionSource, User.class, false);
        } catch (SQLException e) {
            Log.e(TAG, "Can't drop tables", e);
            throw new RuntimeException(e);
        }
    }

    public Dao getProjectDAO() throws SQLException {
        if (mProjectDAO == null) {
            mProjectDAO = getDao(Project.class);
        }
        return mProjectDAO;
    }

    public Dao getUserDAO() throws SQLException {
        if (mUserDAO == null) {
            mUserDAO = getDao(User.class);
        }
        return mUserDAO;
    }

    @Override
    public void close() {
        super.close();
        mProjectDAO = null;
        mUserDAO = null;
    }
}
