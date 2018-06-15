package gangsofcoder.fantasyinformer.ui.events;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gangsofcoder.fantasyinformer.R;
import gangsofcoder.fantasyinformer.model.Event;
import gangsofcoder.fantasyinformer.ui.eventdetails.EventDetailsActivity;

public class EventListActivity extends AppCompatActivity implements EventListContract.View {

    @BindView(R.id.rv_event_list) RecyclerView mRecyclerView;
    //@BindView(R.id.el_progressbar) ProgressBar mProgressBar;
    //@BindView(R.id.shimmer_view_container) ShimmerFrameLayout mShimmerLayout;

    private EventListAdapter mEventListAdapter;
    private List<Event> mEventList=new ArrayList<>();
    private String mCategoryName;
    private EventListPresenter mEventListPresenter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        ButterKnife.bind(this);

        mEventListPresenter=new EventListPresenter(this);
        mCategoryName=getIntent().getStringExtra("CATEGORY_NAME");
        setLayoutManager();
        mEventListPresenter.getListOfEvents(mCategoryName);

    }

    private void setLayoutManager() {
        mLayoutManager=new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * This method is used as static data
     */
    private void prepareCategoryData() {
        /*Event event=new Event("1","CSK","RCB","Indian T20 League","18 May 2018","8pm");
        mEventList.add(event);event=new Event("1","CSK","RCB","Indian T20 League","18 May 2018","8pm");
        mEventList.add(event);
        event=new Event("1","KXI","SH","Indian T20 League","14 May 2018","8pm");
        mEventList.add(event);
        event=new Event("1","CSK","RCB","Indian T20 League","18 May 2018","8pm");
        mEventList.add(event);
        event=new Event("1","MAC","ADTDX","Indian T20 League","18 May 2018","8pm");
        mEventList.add(event);
        event=new Event("1","AFAD","GADX","Indian T20 League","18 May 2018","8pm");
        mEventList.add(event);
        event=new Event("1","CCDE","TDT","Indian T20 League","18 May 2018","8pm");
        mEventList.add(event);
        event=new Event("1","CSK","RCB","Indian T20 League","18 May 2018","8pm");
        mEventList.add(event);*/

    }
    @Override
    public void showLoader() {
        //mProgressBar.setVisibility(View.VISIBLE);
        //mShimmerLayout.startShimmerAnimation();
    }

    @Override
    public void hideLoader() {
        //mProgressBar.setVisibility(View.GONE);
        //mShimmerLayout.stopShimmerAnimation();
        //mShimmerLayout.setVisibility(View.GONE);

    }

    @Override
    public void showEvents() {
    }

    @Override
    public void goToEventDetails() {
        Intent intent=new Intent(this, EventDetailsActivity.class);
        startActivity(intent);
    }


    @Override
    public void setDataToAdapter(final List<Event.EventData> eventList) {
        for(Event.EventData eventData:eventList){
            eventData.setShowShimmer(true);
        }
        mEventListAdapter=new EventListAdapter(eventList,getApplicationContext());
        mRecyclerView.setAdapter(mEventListAdapter);
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(Event.EventData eventData:eventList){
                    eventData.setShowShimmer(false);
                }
                mEventListAdapter.notifyDataSetChanged();
            }
            },1000);
    }
}
