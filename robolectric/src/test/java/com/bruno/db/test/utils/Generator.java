package com.bruno.db.test.utils;

import com.bruno.db.ormlite.model.Project;
import com.bruno.db.ormlite.model.User;

import org.kohsuke.randname.RandomNameGenerator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by bruno on 31/03/15.
 */
public class Generator {
    public static RandomNameGenerator nameGenerator = new RandomNameGenerator((int) Calendar.getInstance().getTimeInMillis());

    public static class _Project {
        public static Project generate() {
            Project p = new Project();
            p.setName(nameGenerator.next());
            p.setCreatedAt(Calendar.getInstance().getTime());
            return p;
        }
    }

    public static class _User {
        public static User generate() {
            User u = new User();
            u.setName(nameGenerator.next());
            u.setCreatedAt(Calendar.getInstance().getTime());
            return u;
        }

        public static List<User> generate(int count) {
            List<User> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(generate());
            }
            return list;
        }
    }
}
