package vadimkonyuh.testscand.controller;

import android.support.v4.app.Fragment;

/**
 * Created by homepc on 09.02.2018.
 */

public class ProductListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ProductListFragment();
    }
}
