package vadimkonyuh.testscand.Model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;
import java.util.UUID;

/**
 * Created by homepc on 09.02.2018.
 */

public class Order {

    @DatabaseField(generatedId = true)
    private UUID mId;

    @DatabaseField(columnName = "info")
    private String mInfo;

    @DatabaseField(columnName = "date")
    private Date mDate;

    @DatabaseField
    private UUID mProductId;

    @DatabaseField
    private UUID mUserId;

    @DatabaseField(foreign = true)
    private Product mProduct;

    public Product getProduct() {
        return mProduct;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getInfo() {
        return mInfo;
    }

    public void setInfo(String info) {
        mInfo = info;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public UUID getProductId() {
        return mProductId;
    }

    public void setProductId(UUID productId) {
        mProductId = productId;
    }

    public UUID getUserId() {
        return mUserId;
    }

    public void setUserId(UUID userId) {
        mUserId = userId;
    }

    public void setProduct(Product product) {
        mProduct = product;
    }
}
