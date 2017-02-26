package test.bullyboo.ru.testmvp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.bullyboo.mvp.fragment_v4.FrogFragment;
import test.bullyboo.ru.testmvp.R;
import test.bullyboo.ru.testmvp.presenters.fragments.TextPresenter;

/**
 * Created by BullyBoo on 14.02.2017.
 */

public class TextFragment extends FrogFragment<TextPresenter> {

    private TextView info;

    public static TextFragment newInstance() {

        Bundle args = new Bundle();

        TextFragment fragment = new TextFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(TextPresenter.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout, null);

        info = (TextView) v.findViewById(R.id.info);

        return v;
    }

    public void setInfoText(@NonNull String text){
        info.setText(text);
    }
}
