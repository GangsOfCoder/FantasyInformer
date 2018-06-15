package gangsofcoder.fantasyinformer.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by suraj on 12-May-18.
 */

public class FantasyTextView extends android.support.v7.widget.AppCompatTextView {

    public FantasyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FantasyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FantasyTextView(Context context) {
        super(context);
        init();
    }

    private void init() {

        //Font name should not contain "/".
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "Arkhip_font.ttf");
        setTypeface(tf);
    }

}
