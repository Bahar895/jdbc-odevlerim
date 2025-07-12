package org.bebka.jdbc.dao;

import org.bebka.jdbc.user.User;

public interface UserDAO {
        void createTable();
        void saveUser(User user);
    }

