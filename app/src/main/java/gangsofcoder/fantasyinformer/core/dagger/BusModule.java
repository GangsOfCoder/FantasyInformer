package gangsofcoder.fantasyinformer.core.dagger;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by suraj on 06-May-18.
 */
@Module
public class BusModule {
    @Provides @Singleton
    public Bus provideBus(){
        return new Bus();
    }
}
