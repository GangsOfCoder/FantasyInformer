package gangsofcoder.fantasyinformer.ui.eventdetails;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gangsofcoder.fantasyinformer.R;

public class EventDetailsActivity extends AppCompatActivity {

    @BindView(R.id.simpleWebView) WebView mWebView;
    private InterstitialAd mInterstial;
    private RewardedVideoAd mRewardedVideoAd;
    private String content="<div style=\"background-color:black;\" >\n" +
            "<h1 style=\"color:white;\">Delhi Team News:</h1>\n" +
            "<ul>\n" +
            "  <li style=\"color:white;\">Coffee</li>\n" +
            "  <li style=\"color:white;\">Tea</li>\n" +
            "  <li style=\"color:white;\">Milk</li>\n" +
            "  <li style=\"color:white;\">Coffee</li>\n" +
            "  <li style=\"color:white;\"><b>Tea</b></li>\n" +
            "  <li style=\"color:white;\">Milk</li>\n" +
            "</ul>  \n" +
            "\n" +
            "<h1 style=\"color:white;\">RCB Team News:</h1>\n" +
            "<ul >\n" +
            "  <li style=\"color:white;\">Coffee</li>\n" +
            "  <li style=\"color:white;\">Tea</li>\n" +
            "  <li style=\"color:white;\">Milk</li>\n" +
            "  <li style=\"color:white;\">Coffee</li>\n" +
            "  <li style=\"color:white;\"><b>Tea</b></li>\n" +
            "  <li style=\"color:white;\">Milk</li>\n" +
            "</ul> \n" +
            "\n" +
            "<h1 style=\"color:white;\">Fantasy Tips</h1>\n" +
            "<ul>\n" +
            "  <li style=\"color:white;\">Coffee</li>\n" +
            "  <li style=\"color:white;\">Tea</li>\n" +
            "  <li style=\"color:white;\">Milk</li>\n" +
            "  <li style=\"color:white;\">Coffee</li>\n" +
            "  <li style=\"color:white;\"><b>Tea</b></li>\n" +
            "  <li style=\"color:white;\">Milk</li>\n" +
            "</ul> \n" +
            "</div>";
    private String matchDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        ButterKnife.bind(this);
        matchDescription=getIntent().getStringExtra("DETAILS");
        Log.d("TEST=",matchDescription);
        //mWebView.setBackgroundColor(ContextCompat.getColor(this,R.color.colorLightBlack));
        mWebView.loadDataWithBaseURL(null, matchDescription, "text/html", "utf-8", null);

        mInterstial=new InterstitialAd(this);
        mInterstial.setAdUnitId(getResources().getString(R.string.interstial_test_id));
        mInterstial.loadAd(new AdRequest.Builder().build());

    }


    @Override
    protected void onResume() {
        super.onResume();
    }
    @OnClick(R.id.btnShowAdd)
    public void showAdd(View view){

        if(mInterstial.isLoaded()){
            mInterstial.show();
        }
    }

}
