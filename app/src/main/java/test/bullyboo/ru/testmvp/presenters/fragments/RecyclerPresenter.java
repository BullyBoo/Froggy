package test.bullyboo.ru.testmvp.presenters.fragments;

import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import ru.bullyboo.mvp.presenters.FrogPresenter;
import test.bullyboo.ru.testmvp.adapter.RecyclerAdapter;
import test.bullyboo.ru.testmvp.fragments.RecyclerFragment;
import test.bullyboo.ru.testmvp.models.TestModel;

/**
 * Created by BullyBoo on 14.02.2017.
 */

public class RecyclerPresenter extends FrogPresenter<RecyclerAdapter, RecyclerFragment> {

    private LinearLayoutManager layoutManager;

    private int firstItemPosition;

    @Override
    protected void onUpdateView(RecyclerAdapter model, RecyclerFragment view) {
        view.setRecyclerAdapter(model, layoutManager);
        view.setRecyclerItemPosition(firstItemPosition);
    }

    @Override
    protected void onAttachedViewFirstTime(RecyclerFragment view) {
        super.onAttachedViewFirstTime(view);

        List<TestModel> modelList = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            modelList.add(new TestModel(i));
        }

        RecyclerAdapter adapter = new RecyclerAdapter();
        adapter.addAll(modelList);

        layoutManager = new LinearLayoutManager(view.getContext());
        setModel(adapter);
    }

    @Override
    protected void onAttachedView(RecyclerFragment view) {
        super.onAttachedView(view);
        if(layoutManager == null)
            layoutManager = new LinearLayoutManager(view.getContext());
    }

    @Override
    protected void onDetachView(RecyclerFragment view) {
        super.onDetachView(view);
        firstItemPosition = layoutManager.findFirstVisibleItemPosition();
        layoutManager = null;
    }
}
