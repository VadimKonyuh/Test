package vadimkonyuh.testscand.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import vadimkonyuh.testscand.database.DBHelper;

/**
 * Created by homepc on 09.02.2018.
 */

public class ProductLab {
    private static ProductLab sProductLab;

    private List<Product> mProducts;

    public static ProductLab get(Context context){
        if(sProductLab == null){
            sProductLab = new ProductLab(context);
        }
        return sProductLab;
    }


    private ProductLab(Context context) {
        mProducts = new ArrayList<>();
        for(int i = 0; i < 51; i++ ){
            Product product = new Product();
            product.setPrice(i + " $");
//            product.setImageView()
            mProducts.add(product);
        }
    }

    public List<Product> getProducts(){
        return mProducts;
    }

    public Product getProduct(UUID id){
        for(Product product: mProducts){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }
}
