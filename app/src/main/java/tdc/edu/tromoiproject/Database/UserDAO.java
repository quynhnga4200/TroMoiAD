package tdc.edu.tromoiproject.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import tdc.edu.tromoiproject.Entity.User;

@Dao
public interface UserDAO {
@Insert
    void InsertUser(User user);

@Query("SELECT * FROM  user")
    List<User> getListUser();
}
