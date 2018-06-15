package gangsofcoder.fantasyinformer.ui.categories;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gangsofcoder.fantasyinformer.R;
import gangsofcoder.fantasyinformer.model.Category;
import gangsofcoder.fantasyinformer.ui.events.EventListActivity;
import gangsofcoder.fantasyinformer.util.Constant;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class CategoryListActivity extends AppCompatActivity implements CategoryListContract.View {

    private CategoryListContract.Action mCategoryPresenter;
    private CategoryListAdapter mCategoryListAdapter;

    private List<Category> mCategoryList=new ArrayList<>();
    /*@BindView(R.id.rv_category_list)
    RecyclerView mRecyclerView;*/
    @BindView(R.id.btn_category_basketball) Button mBtnBasketBall;
    @BindView(R.id.btn_category_cricket) Button mBtnCricket;
    @BindView(R.id.btn_category_football) Button mBtnFootBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_category_list);
        ButterKnife.bind(this);
        mCategoryPresenter=new CategoryListPresenter(this);
        /*mCategoryListAdapter=new CategoryListAdapter(mCategoryList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mCategoryListAdapter);
        prepareCategoryData();*/

        AdView adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);

        AnimationDrawable animationDrawable1 = (AnimationDrawable) mBtnCricket.getBackground();
        animationDrawable1.setEnterFadeDuration(2000);
        animationDrawable1.setExitFadeDuration(4000);
        animationDrawable1.start();

        AnimationDrawable animationDrawable2 = (AnimationDrawable) mBtnFootBall.getBackground();
        animationDrawable2.setEnterFadeDuration(2000);
        animationDrawable2.setExitFadeDuration(4000);
        animationDrawable2.start();

        AnimationDrawable animationDrawable3 = (AnimationDrawable) mBtnBasketBall.getBackground();
        animationDrawable3.setEnterFadeDuration(2000);
        animationDrawable3.setExitFadeDuration(4000);
        animationDrawable3.start();
    }

    /**
     * Not used
     */
    private void prepareCategoryData() {
        Category category=new Category(1,"CRICKET");
        mCategoryList.add(category);

        category=new Category(1,"FOOTBALL");
        mCategoryList.add(category);

        category=new Category(1,"BASKETBALL");
        mCategoryList.add(category);
    }

    @OnClick(R.id.btn_category_cricket)
    public void onCategoryCrickedClicked(View  view){
        mCategoryPresenter.onCategoryClicked(Constant.CATEGORY_CRICKET);
    }

    @OnClick(R.id.btn_category_football)
    public void onCategoryFootballClicked(View view){
        mCategoryPresenter.onCategoryClicked(Constant.CATEGORY_FOOTBALL);
    }

    @OnClick(R.id.btn_category_basketball)
    public void onCategoryBasketballClicked(View view){
        mCategoryPresenter.onCategoryClicked(Constant.CATEGORY_BASKETBALL);
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public void showCategory() {

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void takeToEvent(String categoryName) {
        Intent intent=new Intent(this, EventListActivity.class);
        intent.putExtra("CATEGORY_NAME",categoryName);
        startActivity(intent);
    }

}
