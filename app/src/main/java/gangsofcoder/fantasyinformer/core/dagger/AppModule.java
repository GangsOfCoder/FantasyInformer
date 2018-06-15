package gangsofcoder.fantasyinformer.core.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import gangsofcoder.fantasyinformer.core.FantasyInformerApplication;
import gangsofcoder.fantasyinformer.util.Constant;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by suraj on 05-May-18.
 */
@Module
public class AppModule {

    private final FantasyInformerApplication app;

    public AppModule(FantasyInformerApplication app) {
        this.app = app;
    }

    @Provides @Singleton
    FantasyInformerApplication provideApp(){
        return app;
    }

    @Provides @Singleton
    Context provideContext(){
        return app;
    }

    @Provides @Singleton
    Retrofit provideRetrofit(){
        String URL_BASE = "http://fi.getlogicx.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
