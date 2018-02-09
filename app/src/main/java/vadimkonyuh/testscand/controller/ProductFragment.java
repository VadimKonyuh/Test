package vadimkonyuh.testscand.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.UUID;

import vadimkonyuh.testscand.Model.Product;
import vadimkonyuh.testscand.Model.ProductLab;
import vadimkonyuh.testscand.R;

/**
 * Created by homepc on 09.02.2018.
 */

public class ProductFragment extends Fragment implements View.OnClickListener {

    private Product mProduct;
    private TextView mName;
    private ImageView mImage;
    private TextView mDescription;
    private TextView mPrice;
    private Button mButtonBuy, mButtonRefactor, mButtonDelete;

    private int role = 0; // 1 admin, 0 user

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = new Product();

        UUID productId = (UUID) getActivity().getIntent().getSerializableExtra(ProductActivity.EXTRA_PRODUCT_ID);
        mProduct = ProductLab.get(getActivity()).getProduct(productId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product, container, false);
        mName = v.findViewById(R.id.name);
    //        mName.setText(mProduct.getName());
        mImage = v.findViewById(R.id.image);

        mDescription = v.findViewById(R.id.description);
    //      mDescription.setText(mProduct.getName());
        mPrice = v.findViewById(R.id.price);
        mPrice.setText(mProduct.getPrice());

        mButtonBuy = v.findViewById(R.id.buy);
        mButtonBuy.setOnClickListener(this);

        mButtonRefactor = v.findViewById(R.id.refactor);
        mButtonDelete = v.findViewById(R.id.delete);
        if (role == 1) {
            mButtonRefactor.setVisibility(View.VISIBLE);
            mButtonDelete.setVisibility(View.VISIBLE);
        }

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buy:
                String address = "manager@mail.ru";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",address, null  ));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Store");
                intent.putExtra(Intent.EXTRA_TEXT, "Product name: " + mProduct.getName() +"\n" + "Price: " + mProduct.getPrice()
                        + " ");
                startActivity(Intent.createChooser(intent, "Send email..."));
        }
    }
}
