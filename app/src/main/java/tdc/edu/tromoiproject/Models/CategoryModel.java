package tdc.edu.tromoiproject.Models;

import java.util.ArrayList;

public class CategoryModel {
    public static ArrayList<CategoryModel> categoryModels = new ArrayList<>();
    //khai bao
    private int category_id;
    private String category_name;
    private ArrayList<ProductModel> productModels = new ArrayList<>();


    //Getter and Setter

    public ArrayList<ProductModel> getProductModels() {
        return productModels;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    //contructor
    public CategoryModel(int category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
        // khi goi thang contructor nay thi them luon vao mang array list
        categoryModels.add(this);
    }

//to String

    @Override
    public String toString() {
        return "CategoryModel{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }

    public  static  CategoryModel GetCategoryById(int id){
        for (CategoryModel item:
                CategoryModel.categoryModels) {
            if (item.getCategory_id() == id){
                return item;
            }
        }
        return  null;
    }
    //lay danh muc
    public  static  ArrayList<CategoryModel> GetCategory(){

        return  categoryModels;
    }
    // lay san pham theo danh muc
    public  static  ArrayList<ProductModel> GetProductByCategoryId(int id){
        CategoryModel categoryModel = GetCategoryById(id);
        return  categoryModel == null ? null: categoryModel.productModels;
    }

    public  static  ArrayList<CategoryModel> Save(){
        ArrayList<CategoryModel> CategoryList = new ArrayList<>();
        return  CategoryList;
    }
}