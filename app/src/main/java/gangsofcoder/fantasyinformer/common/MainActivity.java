package gangsofcoder.fantasyinformer.common;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import gangsofcoder.fantasyinformer.R;
import gangsofcoder.fantasyinformer.core.FantasyInformerApplication;
import gangsofcoder.fantasyinformer.ui.categories.CategoryListActivity;

public class MainActivity extends AppCompatActivity {
    @Inject Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ((FantasyInformerApplication)getApplication()).getAppComponent().inject(this);
        ButterKnife.bind(this);
    }

    //action on click on next button
    @OnClick(R.id.btnNext) void onNext(){
        Intent mIntent=new Intent(MainActivity.this, CategoryListActivity.class);
        startActivity(mIntent);
    }
}
