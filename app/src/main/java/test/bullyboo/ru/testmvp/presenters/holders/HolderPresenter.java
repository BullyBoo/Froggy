package test.bullyboo.ru.testmvp.presenters.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

import ru.bullyboo.mvp.presenters.FrogPresenter;
import test.bullyboo.ru.testmvp.activities.MainActivity;
import test.bullyboo.ru.testmvp.adapter.holders.TestHolder;
import test.bullyboo.ru.testmvp.models.TestModel;

/**
 * Created by BullyBoo on 14.02.2017.
 */

public class HolderPresenter extends FrogPresenter<TestModel, TestHolder> {

    @Override
    protected void onUpdateView(TestModel model, TestHolder view) {
        view.setItemPositionText("Position: " + model.getPosition());
        view.setPresenterHashText("Presenter hash code: " + this.hashCode());
        view.setHolderHashText("ViewHolder hash code: " + view.hashCode());
    }

    public void onClick(View v){
        ViewParent parent = v.getParent();
        if (parent instanceof RecyclerView){
            Context context = ((RecyclerView) parent).getContext();

            String text = "onClick: " + model().getPosition() + " position\n" +
                    "Position: " + model().getPosition() + "\n" +
                    "Presenter hash code: " + this.hashCode() + "\n" +
                    "ViewHolder hash code: " + view().hashCode();
            if(context instanceof MainActivity){
                ((MainActivity) context).updateText(text);
            }

        }

    }
}
