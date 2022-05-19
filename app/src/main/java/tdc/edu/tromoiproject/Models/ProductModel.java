package vn.edu.tdc.projectandroid.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;

public class ProductModel {
    public  static String[] Entilities = {"a","b","c","d","e","f","g","b"};

    public  static ArrayList<ProductModel> productModels = new ArrayList<>();
    private int product_id;
    private  String product_title;
    private  String product_actor;
    private  String phone_number;
    private  String arena;
    private  ArrayList<String> Product_image;
    private  String Create_time;
    private  String Description;
    private  String address;
    private  CategoryModel categoryModel;
    private  ArrayList<String> entilities = new ArrayList<>();

    public ArrayList<String> getEntilities() {
        return entilities;
    }

    public void setEntilities(ArrayList<String> entilities) {
        this.entilities = entilities;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }


    //contructor
    public ProductModel(int product_id,
                        String product_title,
                        String product_actor,
                        String phone_number,
                        String arena,
                        String address,
                        ArrayList<String> product_image,
                        String create_time,
                        String description,
                        int idcategory,
                        ArrayList<String> entilities) {
        CategoryModel categoryModel = CategoryModel.GetCategoryById(idcategory);
        if (categoryModel == null){
            return;
        }
        this.product_id = product_id;
        this.product_title = product_title;
        this.product_actor = product_actor;
        this.phone_number = phone_number;
        this.address = address;
        this.arena = arena;
        this.entilities = entilities;
        Product_image = product_image;
        Create_time = create_time;
        Description = description;
        //luu category vao product

        this.categoryModel = categoryModel;

        this.categoryModel.getProductModels().add(this);
        productModels.add(this);
    }

    //Getter and Setter
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_actor() {
        return product_actor;
    }

    public void setProduct_actor(String product_actor) {
        this.product_actor = product_actor;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public ArrayList<String> getProduct_image() {
        return Product_image;
    }

    public void setProduct_image(ArrayList<String> product_image) {
        Product_image = product_image;
    }

    public String getCreate_time() {
        return Create_time;
    }

    public void setCreate_time(String create_time) {
        Create_time = create_time;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
//to String


    @Override
    public String toString() {
        return "ProductModel{" +
                "product_id=" + product_id +
                ", product_title='" + product_title + '\'' +
                ", product_actor='" + product_actor + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", arena='" + arena + '\'' +
                ", Product_image=" + Product_image +
                ", Create_time='" + Create_time + '\'' +
                ", Description='" + Description + '\'' +
                ", entilities=" + entilities +
                ", address='" + address + '\'' +
                ", categoryModel=" + categoryModel +
                '}';
    }

    //lấy danh sách product
    public static  ArrayList<ProductModel> GetAll(){
        return  productModels;
    }
    //Tao moi san pham
    public  static void  CreateProduct(){

    }
    //xoa san pham
    public  static  void DeleteProduct(){

    }
    //edit san pham
    public  static  void UpdateProduct(){

    }
    //tim kiem san pham
    public  static ArrayList<ProductModel> SearchProduct(String key){
        //tao bien mang danh sach
    ArrayList<ProductModel> productList = new ArrayList<>();
    //duyet vong forech tim kiem san pham
        for (ProductModel productItem:
             productModels) {
            if (productItem.address.contains(key)){
                productList.add(productItem);
            }
        }
    return productList;
    }
    public  static  ArrayList<ProductModel> Save(){
        ArrayList<ProductModel> productList = new ArrayList<>();
        return  productList;
    }

}

