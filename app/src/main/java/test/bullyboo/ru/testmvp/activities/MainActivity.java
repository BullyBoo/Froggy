package test.bullyboo.ru.testmvp.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import ru.bullyboo.mvp.activity.FrogAppCompatActivity;
import test.bullyboo.ru.testmvp.presenters.activities.MainPresenter;
import test.bullyboo.ru.testmvp.R;
import test.bullyboo.ru.testmvp.fragments.TextFragment;

public class MainActivity extends FrogAppCompatActivity<MainPresenter> {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setPresenter(MainPresenter.class);
        }

    public void updateText(@NonNull String text){
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container2);
        if(fragment instanceof TextFragment){
            ((TextFragment) fragment).getPresenter().setModel(text);
        }
    }
}
