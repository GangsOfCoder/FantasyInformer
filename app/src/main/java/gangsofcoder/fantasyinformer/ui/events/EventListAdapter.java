package gangsofcoder.fantasyinformer.ui.events;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import gangsofcoder.fantasyinformer.R;
import gangsofcoder.fantasyinformer.model.Event;
import gangsofcoder.fantasyinformer.ui.eventdetails.EventDetailsActivity;

/**
 * Created by suraj on 12-May-18.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder>{
    private List<Event.EventData> mEvent;
    private Context mContext;

    EventListAdapter(List<Event.EventData> mEvent, Context mContext) {
        this.mEvent = mEvent;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_event_list,parent,false);
        return new ViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         Event.EventData event=mEvent.get(position);
        if(event.isShowShimmer()){
            holder.mShimmerFrameLayout.startShimmerAnimation();
        }else {
                holder.mShimmerFrameLayout.stopShimmerAnimation();
                holder.mEventTeamA.setText(event.getTeamA());
                holder.mEventTeamB.setText(event.getTeamB());
                holder.mEventTitle.setText(event.getMatchType());
                holder.mEventDate.setText(event.getDate());
            }


    }
    @Override
    public int getItemCount() {
        return mEvent.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        @BindView(R.id.tv_event_team_a) TextView mEventTeamA;
        @BindView(R.id.tv_event_team_b) TextView mEventTeamB;
        @BindView(R.id.tv_event_title) TextView mEventTitle;
        @BindView(R.id.tv_event_date) TextView mEventDate;
        @BindView(R.id.cl_event_list) ConstraintLayout mConstraintLayout;
        @BindView(R.id.fl_shimmer) ShimmerFrameLayout mShimmerFrameLayout;
        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            AnimationDrawable animationDrawable1 = (AnimationDrawable) mConstraintLayout.getBackground();
            animationDrawable1.setEnterFadeDuration(2000);
            animationDrawable1.setExitFadeDuration(4000);
            animationDrawable1.start();

            mConstraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int pos=getAdapterPosition(); //get clicked position on adapter
                    //check if item still exits
                    if(pos != RecyclerView.NO_POSITION){
                        Event.EventData event=mEvent.get(pos);
                        Intent intent =new Intent(mContext,EventDetailsActivity.class);
                        intent.putExtra("DETAILS",event.getDiscription());
                        view.getContext().startActivity(intent);
                    }

                }
            });
        }


    }
}
