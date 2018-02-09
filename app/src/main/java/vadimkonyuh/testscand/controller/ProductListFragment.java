package vadimkonyuh.testscand.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vadimkonyuh.testscand.Model.Product;
import vadimkonyuh.testscand.Model.ProductLab;
import vadimkonyuh.testscand.R;

/**
 * Created by homepc on 08.02.2018.
 */

public class ProductListFragment extends Fragment {

    private RecyclerView mProductRecyclerView;
    private ProductAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        mProductRecyclerView = view.findViewById(R.id.product_recycler_view);
        mProductRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();


        return view;
    }

    private void updateUI(){
        ProductLab crimeLab = ProductLab.get(getActivity());
        List<Product> products = crimeLab.getProducts();
        mAdapter = new ProductAdapter(products);
        mProductRecyclerView.setAdapter(mAdapter);
    }

    private class ProductHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mPriceTextView;
        private ImageView mImageView;

        private Product mProduct;

        public void bind(Product product) {
            mProduct = product;
            mPriceTextView.setText(mProduct.getPrice());
        }
        public ProductHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_product, parent, false));
            itemView.setOnClickListener(this);
            mPriceTextView = itemView.findViewById(R.id.product_price);
            mImageView = itemView.findViewById(R.id.product_image);
        }

        @Override
        public void onClick(View v) {
            Intent intent = ProductActivity.newIntent(getActivity(), mProduct.getId());
            startActivity(intent);
        }
    }

    private class ProductAdapter extends RecyclerView.Adapter<ProductHolder> {
        private List<Product> mProducts;
        public ProductAdapter(List<Product> crimes) {
            mProducts = crimes;
        }
        @Override
        public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ProductHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(ProductHolder holder, int position) {
            Product product = mProducts.get(position);
            holder.bind(product);
        }
        @Override
        public int getItemCount() {
            return mProducts.size();
        }
    }
}
