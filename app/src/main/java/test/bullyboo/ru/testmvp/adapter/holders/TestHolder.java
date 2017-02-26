package test.bullyboo.ru.testmvp.adapter.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import ru.bullyboo.mvp.adapters.viewholders.FrogRecyclerHolder;
import test.bullyboo.ru.testmvp.R;
import test.bullyboo.ru.testmvp.presenters.holders.HolderPresenter;

/**
 * Created by BullyBoo on 14.02.2017.
 */

public class TestHolder extends FrogRecyclerHolder<HolderPresenter> implements View.OnClickListener{

    private TextView itemPosition, presenterHash, holderHash;


    public TestHolder(View view) {
        super(view);
        itemPosition = (TextView) view.findViewById(R.id.itemPosition);
        presenterHash = (TextView) view.findViewById(R.id.presenterHash);
        holderHash = (TextView) view.findViewById(R.id.holderHash);

        view.setOnClickListener(this);
    }

    public void setItemPositionText(@NonNull String text){
        itemPosition.setText(text);
    }

    public void setPresenterHashText(@NonNull String text) {
        presenterHash.setText(text);
    }

    public void setHolderHashText(@NonNull String text) {
        holderHash.setText(text);
    }

    @Override
    public void onClick(View v) {
        getPresenter().onClick(v);
    }
}
