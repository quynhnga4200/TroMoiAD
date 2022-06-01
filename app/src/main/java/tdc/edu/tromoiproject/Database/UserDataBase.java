package tdc.edu.tromoiproject.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import tdc.edu.tromoiproject.Entity.User;
@Database(entities = {User.class}, version = 1)
    public abstract class UserDataBase extends RoomDatabase {

    private  static  final  String DATABASE_NAME = "user.db";
    private  static    UserDataBase instance;
    private  static  synchronized  UserDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),UserDataBase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();

        }
        return  instance;

    }
    public  abstract  UserDAO userDAO();

    }

