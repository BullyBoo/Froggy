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
package ru.bullyboo.mvp.managers;

import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import ru.bullyboo.mvp.presenters.FrogPresenter;


public class PresenterManager {

    private static final String PRESENTER_ID = "PRESENTER_ID";
    private AtomicLong currentId;

    private Map<Long, FrogPresenter> presenters;

    private static PresenterManager ourInstance;

    public static PresenterManager getInstance() {
        if(ourInstance == null){
            ourInstance = new PresenterManager();
        }
        return ourInstance;
    }

    private PresenterManager() {
        currentId = new AtomicLong();
        presenters = new HashMap<>();
    }

    public void savePresenter(@NonNull FrogPresenter presenter, Bundle outState){
        long presenterId = currentId.incrementAndGet();
        outState.putLong(PRESENTER_ID, presenterId);
        presenters.put(presenterId, presenter);

    }

    public <P extends FrogPresenter> P restorePresenter(@NonNull Bundle savedInstanceState){
        Long presenterId = savedInstanceState.getLong(PRESENTER_ID);
        P presenter = (P) presenters.get(presenterId);
        presenters.remove(presenterId);
        return presenter;
    }
}
