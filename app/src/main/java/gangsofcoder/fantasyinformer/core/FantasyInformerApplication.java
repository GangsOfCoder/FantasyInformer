package gangsofcoder.fantasyinformer.core;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

import gangsofcoder.fantasyinformer.R;
import gangsofcoder.fantasyinformer.core.dagger.AppComponent;
import gangsofcoder.fantasyinformer.core.dagger.AppModule;
import gangsofcoder.fantasyinformer.core.dagger.DaggerAppComponent;

/**
 * Created by suraj on 05-May-18.
 */

public class FantasyInformerApplication extends Application {
    private static AppComponent appComponent;
    private static FantasyInformerApplication instance=new FantasyInformerApplication();

    public static FantasyInformerApplication getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        // initialize the AdMob app
        MobileAds.initialize(this, getString(R.string.admob_app_test_id));
        getAppComponent();
    }
    public  AppComponent getAppComponent(){
        if(appComponent==null){
            appComponent= DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }
}

