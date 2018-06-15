package gangsofcoder.fantasyinformer.core.dagger;

import javax.inject.Singleton;

import dagger.Component;
import gangsofcoder.fantasyinformer.common.MainActivity;
import gangsofcoder.fantasyinformer.ui.categories.CategoryListPresenter;
import gangsofcoder.fantasyinformer.ui.eventdetails.EventDetailsActivity;
import gangsofcoder.fantasyinformer.ui.eventdetails.EventDetailsPresenter;
import gangsofcoder.fantasyinformer.ui.events.EventListPresenter;

/**
 * Created by suraj on 05-May-18.
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                BusModule.class
        }
)
public interface AppComponent {
       void inject(MainActivity mainActivity);
       void inject(CategoryListPresenter categoryListPresenter);
       void inject(EventListPresenter eventListPresenter);
       void inject(EventDetailsPresenter eventDetailsPresenter);
}
