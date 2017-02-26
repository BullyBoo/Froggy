package test.bullyboo.ru.testmvp.presenters.activities;

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
    }
}
