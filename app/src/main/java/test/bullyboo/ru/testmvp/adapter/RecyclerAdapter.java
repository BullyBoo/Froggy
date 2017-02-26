package test.bullyboo.ru.testmvp.adapter;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.bullyboo.mvp.adapters.FrogRecyclerAdapter;
import test.bullyboo.ru.testmvp.R;
import test.bullyboo.ru.testmvp.adapter.holders.TestHolder;
import test.bullyboo.ru.testmvp.models.TestModel;
import test.bullyboo.ru.testmvp.presenters.holders.HolderPresenter;

/**
 * Created by BullyBoo on 14.02.2017.
 */

public class RecyclerAdapter extends FrogRecyclerAdapter<TestModel, TestHolder, HolderPresenter> {

    @NonNull
    @Override
    protected HolderPresenter createPresenter(@NonNull TestModel model) {
        HolderPresenter presenter = new HolderPresenter();
        presenter.setModel(model);
        return presenter;
    }

    @NonNull
    @Override
    protected Object getModelId(@NonNull TestModel item) {
        return item.getPosition();
    }

    @Override
    public TestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
        return new TestHolder(v);
    }
}
