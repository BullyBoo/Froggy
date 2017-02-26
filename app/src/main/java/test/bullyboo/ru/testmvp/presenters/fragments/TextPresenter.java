package test.bullyboo.ru.testmvp.presenters.fragments;

import ru.bullyboo.mvp.presenters.FrogPresenter;
import test.bullyboo.ru.testmvp.fragments.TextFragment;

/**
 * Created by BullyBoo on 14.02.2017.
 */

public class TextPresenter extends FrogPresenter<String, TextFragment> {

    @Override
    protected void onUpdateView(String model, TextFragment view) {
        view.setInfoText(model);
    }
}
