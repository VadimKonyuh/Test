package vadimkonyuh.testscand.Model;

import android.widget.ImageView;

import com.j256.ormlite.field.DatabaseField;

import java.sql.Blob;
import java.util.UUID;

/**
 * Created by homepc on 08.02.2018.
 */

public class Product {
    @DatabaseField(generatedId = true)
    private UUID mId;
    @DatabaseField
    private String mName;

    private ImageView mImageView;

    public ImageView getImageView() {
        return mImageView;
    }

    public void setImageView(ImageView imageView) {
        mImageView = imageView;
    }

    @DatabaseField
    private Blob mBlob;
    @DatabaseField
    private String mDescription;
    @DatabaseField
    private String mPrice;

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Blob getBlob() {
        return mBlob;
    }

    public void setBlob(Blob blob) {
        mBlob = blob;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String title) {
        mDescription = title;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public Product(){
        mId = UUID.randomUUID();
    }


}
