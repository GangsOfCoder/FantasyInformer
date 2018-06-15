package gangsofcoder.fantasyinformer.ui.eventdetails;

/**
 * Created by suraj on 12-May-18.
 */

public class EventDetailsContract {

    public interface View{
        void showLoader();
        void hideLoader();
        void showEventDetails();
    }

    public interface Action{
        void goBack();
    }

    public interface Repository{

    }
}
