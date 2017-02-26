package test.bullyboo.ru.testmvp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.bullyboo.mvp.fragment_v4.FrogFragment;
import test.bullyboo.ru.testmvp.R;
import test.bullyboo.ru.testmvp.adapter.RecyclerAdapter;
import test.bullyboo.ru.testmvp.presenters.fragments.RecyclerPresenter;

/**
 * Created by BullyBoo on 14.02.2017.
 */

public class RecyclerFragment extends FrogFragment<RecyclerPresenter> {

    private RecyclerView recycler;

    public static RecyclerFragment newInstance() {

        Bundle args = new Bundle();

        RecyclerFragment fragment = new RecyclerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(RecyclerPresenter.class);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_layout, null);

        recycler = (RecyclerView) v.findViewById(R.id.recycler);

        return v;
    }

    public void setRecyclerAdapter(@NonNull RecyclerAdapter adapter, @NonNull LinearLayoutManager layoutManager){
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }

    public void setRecyclerItemPosition(int position){
        recycler.scrollToPosition(position);
    }
}
