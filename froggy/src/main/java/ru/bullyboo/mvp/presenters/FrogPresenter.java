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
package ru.bullyboo.mvp.presenters;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;


public abstract class FrogPresenter<M, V>{

    private M model;

    private WeakReference<V> view;

    private boolean detachViewWasCalling;
    private boolean detachModelWasCalling;

    public FrogPresenter(){
        onCreatePresenter();
    }

    public void setModel(@NonNull M model) {
        this.model = model;

        if(!detachModelWasCalling){
            onAttachedModelFirstTime(model);
        }

        onAttachedModel(model);

        if(setupDone())
            onUpdateView(model, view());
    }

    public void resetModel() {
        onDetachModel(model);

        this.model = null;
        detachModelWasCalling = true;
    }

    public void attachView(@NonNull V view){
        this.view = new WeakReference<>(view);

        if(!detachViewWasCalling){
            onAttachedViewFirstTime(view);
        }
        onAttachedView(view);

        if(setupDone())
            onUpdateView(model, view);
    }

    public void detachView(){
        onDetachView(view.get());

        this.view = null;
        detachViewWasCalling = true;
    }

    public V view(){

        if(view != null){
            return view.get();
        } else {
            return null;
        }
    }

    protected M model(){

        if(model != null){
            return model;
        } else {
            return null;
        }
    }

    /**
     * Calling when view and model was set
     */
    protected abstract void onUpdateView(M model, V view);

    /**
     * Calling when new presenter was create
     */
    protected void onCreatePresenter(){

    }

    /**
     * Calling when view attached
     */
    protected void onAttachedViewFirstTime(V view){

    }

    /**
     * Calling when view attached
     */
    protected void onAttachedModelFirstTime(M model){

    }

    /**
     * Calling when view attached
     */
    protected void onAttachedView(V view){

    }

    /**
     * Calling when model attached
     */
    protected void onAttachedModel(M model){

    }

    /**
     * Calling when view detach
     */
    protected void onDetachView(V view){

    }

    /**
     * Calling when model detach
     */
    protected void onDetachModel(M model){

    }

    private final boolean setupDone(){
        return view != null && model != null;
    }
}
