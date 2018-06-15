package gangsofcoder.fantasyinformer.ui.eventdetails;

import gangsofcoder.fantasyinformer.core.FantasyInformerApplication;

/**
 * Created by suraj on 12-May-18.
 */

public class EventDetailsPresenter implements EventDetailsContract.Action {
    private final EventDetailsContract.View mView;

    public EventDetailsPresenter(EventDetailsContract.View mView) {
        this.mView = mView;
        FantasyInformerApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void goBack() {

    }
}
