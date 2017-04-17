package test.bullyboo.ru.testmvp.presenters.activities;

import android.util.Log;

import java.util.List;

import ru.bullyboo.mvp.presenters.FrogPresenter;
import test.bullyboo.ru.testmvp.R;
import test.bullyboo.ru.testmvp.activities.MainActivity;
import test.bullyboo.ru.testmvp.fragments.RecyclerFragment;
import test.bullyboo.ru.testmvp.fragments.TextFragment;
import test.bullyboo.ru.testmvp.models.TestModel;

/**
 * Created by BullyBoo on 10.02.2017.
 */

public class MainPresenter extends FrogPresenter<List<TestModel>, MainActivity> {

    @Override
    protected void onUpdateView(List<TestModel> model, MainActivity view) {
        Log.d("presenterDebug", "onUpdateView");
    }

    @Override
    protected void onAttachedViewFirstTime(MainActivity view) {
        super.onAttachedViewFirstTime(view);

        view.getSupportFragmentManager().beginTransaction()
                .add(R.id.container1, RecyclerFragment.newInstance())
                .addToBackStack(null)
                .commit();

        view.getSupportFragmentManager().beginTransaction()
                .add(R.id.container2, TextFragment.newInstance())
                .addToBackStack(null)
                .commit();

        Log.d("presenterDebug", "onAttachedViewFirstTime");
    }

    @Override
    protected void onAttachedModel(List<TestModel> model) {
        super.onAttachedModel(model);
        Log.d("presenterDebug", "onAttachedModel");
    }

    @Override
    protected void onDetachModel(List<TestModel> model) {
        super.onDetachModel(model);
        Log.d("presenterDebug", "onDetachModel");
    }

    @Override
    protected void onDetachView(MainActivity view) {
        super.onDetachView(view);
        Log.d("presenterDebug", "onDetachView");
    }

    @Override
    protected void onAttachedView(MainActivity view) {
        super.onAttachedView(view);
        Log.d("presenterDebug", "onAttachedView");
    }

    @Override
    protected void onAttachedModelFirstTime(List<TestModel> model) {
        super.onAttachedModelFirstTime(model);
        Log.d("presenterDebug", "onAttachedModelFirstTime");
    }

    @Override
    protected void onCreatePresenter() {
        super.onCreatePresenter();
        Log.d("presenterDebug", "onCreatePresenter");
    }
}
