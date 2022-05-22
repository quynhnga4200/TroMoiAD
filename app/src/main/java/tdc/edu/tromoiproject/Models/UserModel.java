package tdc.edu.tromoiproject.Models;

import java.util.ArrayList;

public class UserModel {
    public  static ArrayList<UserModel> userModels = new ArrayList<>();
    public static UserModel user= null;
    private  int id;
    private  String email;
    private  String name;
    private  String phone;
    private  String password;
    private  String avatar;
    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    //Contructor
    public UserModel(int id, String email, String name, String phone, String password, String avatar) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.avatar = avatar;
        userModels.add(this);
    }
    //toString

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    //dang nhap
    public  static boolean Login(String username,String password){
        for (UserModel userModelItem:
                userModels
             ) {
            if (userModelItem.name==username){
                if (userModelItem.password==password)
                {
                    user = userModelItem;
                    return  true;

                }
            }

        }

    return  false;
    }
    //xoa user
    public  static  void DeleteUser(int id){}

    //dang KI
    public  static  ArrayList<UserModel>  RegisterUser(int id ,String email,String name , String Phone ,String password,String Avatar){
    ArrayList<UserModel> UserList =new ArrayList<>();

        return  UserList;
    }

    //dang xuat
    public  static  void Logout(){
        user = null;
    }

    //thong tin user
    public  static UserModel UserInfo(){
        return  user;
    }
}
