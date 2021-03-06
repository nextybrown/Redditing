package com.push.redditing.di;

import android.app.Application;
import com.push.redditing.RedditingApplication;
import com.push.redditing.datalayer.DataLayerModule;
import com.push.redditing.ui.widget.WidgetModule;
import com.push.redditing.utils.UtilsModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        DataLayerModule.class,
        UtilsModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        WidgetModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<RedditingApplication> {
   // TasksRepository getTasksRepository();

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application) ;
        AppComponent build();
    }
}
