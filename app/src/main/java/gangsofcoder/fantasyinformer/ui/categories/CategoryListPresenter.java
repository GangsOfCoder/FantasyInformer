package gangsofcoder.fantasyinformer.ui.categories;

import android.content.Intent;
import android.util.Log;

import gangsofcoder.fantasyinformer.core.FantasyInformerApplication;

/**
 * Created by suraj on 06-May-18.
 */

public class CategoryListPresenter implements CategoryListContract.Action {
   private final CategoryListContract.View mView;

    CategoryListPresenter(CategoryListContract.View mView) {
        this.mView=mView;
        //FantasyInformerApplication.getInstance().getAppComponent().inject(this);
    }


    @Override
    public void onCategoryClicked(String categoryName) {
        mView.takeToEvent(categoryName);
    }
}
