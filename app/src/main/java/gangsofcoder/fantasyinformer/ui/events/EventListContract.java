package gangsofcoder.fantasyinformer.ui.events;

import java.util.List;

import gangsofcoder.fantasyinformer.model.Event;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by suraj on 07-May-18.
 */

public class EventListContract {
    public interface View{
        void showLoader();
        void hideLoader();
        void showEvents();
        void goToEventDetails();
        void setDataToAdapter(List<Event.EventData> eventList);
    }

    public interface Action{
        void onEventClicked();
    }


    public interface Service{
        @Headers("Content-Type: application/json")
        @POST("api.php")
        Call<Event> getEvents(@Body String body);
//        @Headers("Content-Type: application/json")
//        @POST("api.php")
//        Observable<Event> getEvents(@Body String body);
    }
}
