/*
 * Copyright (C) 2017 BullyBoo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.bullyboo.mvp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

import ru.bullyboo.mvp.adapters.viewholders.FrogRecyclerHolder;
import ru.bullyboo.mvp.presenters.FrogPresenter;


abstract class RecyclerAdapter<M, V extends FrogRecyclerHolder, P extends FrogPresenter>
        extends RecyclerView.Adapter<V> {

    protected final Map<Object, P> presenters;

    protected RecyclerAdapter() {
        presenters = new HashMap<>();
    }

    @Override
    public void onBindViewHolder(V holder, int position) {

        holder.attachPresenter(getPresenter(getItem(position)));
    }

    @Override
    public void onViewRecycled(V holder) {
        super.onViewRecycled(holder);

        holder.detachPresenter();
    }

    @Override
    public boolean onFailedToRecycleView(V holder) {
        holder.detachPresenter();
        return super.onFailedToRecycleView(holder);
    }

    @NonNull
    protected abstract P createPresenter(@NonNull M model);

    @NonNull
    protected abstract Object getModelId(@NonNull M item);

    @NonNull
    protected abstract M getItem(int position);

    @NonNull
    protected P getPresenter(M model){
        return presenters.get(getModelId(model));
    }
}
