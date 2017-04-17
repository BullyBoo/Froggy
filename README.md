# Froggy
Simple Mvp Implementation

## Download
Gragle:
```groovy 
compile 'ru.bullyboo.mvp:froggy:1.0.2'
```

Maven:
```xml
<dependency> 
  <groupId>ru.bullyboo.mvp</groupId> 
  <artifactId>froggy</artifactId> 
  <version>1.0.2</version> 
  <type>pom</type> 
</dependency>
```

## Samples
Apk of [Demo version](https://github.com/BullyBoo/Froggy/releases/download/1.0.2/app-release-unsigned.apk)

## Usage

To create presenter, you need to inherit from class FrogPresenter and parametrized its with Model and View.

``` java
public class ExamplePresenter extends FrogPresenter<ExampleModel, ExampleActivity> {
  //...
}
```

Each presenter has a life cycle. It contains next methods:

``` java
/**
* Calling when view and model was set
*/
@Override
protected void onUpdateView(ExampleModel model, ExampleView view) {
    
}

/**
* Calling when new presenter was create
*/
@Override
protected void onCreatePresenter(){

}

/**
* Calling when view attached
*/
@Override
protected void onAttachedViewFirstTime(ExampleView view){

}

/**
* Calling when view attached
*/
@Override
protected void onAttachedModelFirstTime(ExampleModel model){

}

/**
* Calling when view attached
*/
@Override
protected void onAttachedView(ExampleView view){

}

/**
* Calling when model attached
*/
@Override
protected void onAttachedModel(ExampleModel model){

}

/**
* Calling when view detach
*/
@Override
protected void onDetachView(ExampleView view){

}

/**
* Calling when model detach
*/
@Override
protected void onDetachModel(ExampleModel model){

}
```

To attach presenter to your Activity, you need to inherit from class FrogActivity or FrogAppCompatActivity.
``` java
public class MainActivity extends FrogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(ExamplePresenter.class);
        //...
    }
    //...
}
```

To get the object of the presenter and access to its methods, you need to use next method in your View: 
``` java
//...
(ExamplePresenter) getPresenter();
//...
```

But, if you don't want to use converting, you can parametrize inheritable class with your presenter:
``` java
public class MainActivity extends FrogActivity<ExamplePresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPresenter(ExamplePresenter.class);
        //...
    }
    //...
}
```

In this case getting object of presenter will look like:
``` java
//...
getPresenter();
//...
```

It's absolutely the same with fragments:
``` java 
public class TextFragment extends FrogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(ExamplePresenter.class);
        //...
    }
}
```

Getting object of the presenter:
``` java
//...
(ExamplePresenter) getPresenter();
//...
```

Parametrized class:
``` java 
public class TextFragment extends FrogFragment<ExamplePresenter> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPresenter(ExamplePresenter.class);
        //...
    }
}
```

Getting object of the presenter:
``` java
//...
getPresenter();
//...
```

Calling of method `setPresenter` can be done in other places, but you need to do it after calling `super.onCreate(savedInstanceState);` and before calling `onResume();`.

## Usage with RecyclerAdapter

First at all you need to create adapter, which will inherit from FrogRecyclerAdapter parametrized with Model, View and Presenter.
``` java 
public class RecyclerAdapter extends FrogRecyclerAdapter<ExampleModel, ExampleViewHolder, ExamplePresenter> {
  //...
}
```
In the adapter you need to override three methods. The method of presenter creation. The method of ViewHolder creation. The method to getting model's id.

Also you need to create your own ViewHolder, which will inherit from FrogRecyclerHolder paramtrized with Presenter. 
``` java 
public class ExampleHolder extends FrogRecyclerHolder<ExamplePresenter>{
  //...
}
```

Your adapter is ready. To create and fill it with your data, use:
``` java 
ExampleAdapter adapter = new ExampleAdapter();
adapter.addAll(modelList);
```

## Thanks to
[android-arch-sample](https://github.com/remind101/android-arch-sample)

## License
```
  Copyright (C) 2017 BullyBoo

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
```
