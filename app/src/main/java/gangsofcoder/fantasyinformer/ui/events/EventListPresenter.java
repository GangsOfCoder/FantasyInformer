package gangsofcoder.fantasyinformer.ui.events;

import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import gangsofcoder.fantasyinformer.core.FantasyInformerApplication;
import gangsofcoder.fantasyinformer.model.Event;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by suraj on 07-May-18.
 */

public class EventListPresenter implements EventListContract.Action{

    private final EventListContract.View mView;
    @Inject Retrofit retrofit;
    EventListPresenter(EventListContract.View mView) {
        this.mView = mView;
        FantasyInformerApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void onEventClicked() {

    }


    void getListOfEvents(String categoryName){
        mView.showLoader();
        //{"action":"ListOfMatches","Category":"Basketball"}
        JSONObject paramObject=new JSONObject();
        try {
            paramObject.put("action","ListOfMatches");
            paramObject.put("Category",categoryName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EventListContract.Service service= retrofit.create(EventListContract.Service.class);
        Call<Event> call=service.getEvents(paramObject.toString());
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(@NonNull Call<Event> call, @NonNull Response<Event> response) {
                mView.hideLoader();
                if(response.isSuccessful()){
                    Log.d("TESTING=",response.body().getData().get(0).getTeamA());
                    mView.setDataToAdapter(response.body().getData());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Event> call, @NonNull Throwable t) {
                Log.d("TEST","onFailure");
                mView.hideLoader();
            }
        });
    }
}
