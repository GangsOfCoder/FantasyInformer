package gangsofcoder.fantasyinformer.ui.categories;

import gangsofcoder.fantasyinformer.model.Event;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by suraj on 06-May-18.
 */

public class CategoryListContract {

    public interface View{
        void showLoader();
        void hideLoader();
        void showCategory();
        void showToast(String message);
        void takeToEvent(String categoryId);
    }

    public interface Action{
        void onCategoryClicked( String id);
    }

    public interface Repository{
 }
}
