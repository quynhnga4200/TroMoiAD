package tdc.edu.tromoiproject.Entity;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class TempConnectFireBase {
    public  static  void GetData(Context context){
        String jsonString = "";
        try {
            InputStream is = context.getAssets().open("ts.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
            JSONArray jsonCatgoryArray = new JSONArray(jsonString);

            // duyet mang lon ben ngoai cung theo cấp danh mục >sản phẩm>hình ảnh and tiện ích
            for (int i = 0; i < jsonCatgoryArray.length(); i++) {

                JSONObject jsonCategory = jsonCatgoryArray.getJSONObject(i);
                int categoryId = Integer.parseInt(jsonCategory.get("categry_id").toString());
                CategoryModel categoryModel =new CategoryModel(categoryId,jsonCategory.get("category_name").toString());
                // khai bao mang array danh sach product
                JSONArray productList = jsonCategory.getJSONArray("product_list");

                //duyet mang Array danh sách  sản phẩm
                for (int j = 0; j < productList.length(); j++) {
                    JSONObject jsonProduct = productList.getJSONObject(j);

                    int productId= Integer.parseInt(jsonProduct.get("product_id").toString());
                    //mảng các phần tử hình ảnh
                    ArrayList<String> productImages = new ArrayList<>();

                    //vòng lặp các phần tử trong mảng hình  ảnh
                    for (int k=0;k<jsonProduct.getJSONArray("product-image").length();k++){
                        productImages.add(jsonProduct.getJSONArray("product-image").getString(k));
                    }
                    //mảng tiện ích
                    ArrayList<String> entilities = new ArrayList<>();
                    //vòng lặp tiện ích
                    for (int k = 0;k <jsonProduct.getJSONArray("Entilities").length();k++){
                        int key = jsonProduct.getJSONArray("Entilities").getInt(k);
                        entilities.add(Product.Entilities[key]);
                    }
                    // khởi tạo danh sách  sản phẩm
                    Product productModel =new Product(productId,
                            jsonProduct.get("product_title").toString(),
                            jsonProduct.get("product_actor").toString(),
                            jsonProduct.get("phone_number").toString(),
                            jsonProduct.get("product_arena").toString(),
                            jsonProduct.get("product_address").toString(),
                            productImages,
                            jsonProduct.get("product_create_time").toString(),
                            jsonProduct.get("product_description").toString(),
                            categoryId,
                            entilities);
                }
            }
        } catch (Exception e) {
            Log.i("IOException", e.getMessage());

        }

    }
    // Lấy ra dữ liệu của user
    public  static  void GetDataUser(Context context){
        String jsonString = "";
        try {
            InputStream is = context.getAssets().open("user.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");

            JSONArray jsonUserArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonUserArray.length(); i++) {
                JSONObject jsonUser = jsonUserArray.getJSONObject(i);
                int userId = Integer.parseInt(jsonUser.get("user_id").toString());
                User userModel = new User(userId,
                        jsonUser.get("user_email").toString(),
                        jsonUser.get("user_name").toString(),
                        jsonUser.get("user_phone").toString(),
                        jsonUser.get("user_password").toString(),
                        jsonUser.get("user_avatar").toString());



            }
            } catch (Exception e) {
            Log.i("IOException", e.getMessage());

        }

    }
}
