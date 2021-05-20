package com.vastinc.daggerquotesapp.di.main;

import com.vastinc.daggerquotesapp.di.scope.ActivityScope;
import com.vastinc.daggerquotesapp.ui.MainActivity;
import com.vastinc.daggerquotesapp.ui.author.quotes.QuotesFragment;
import com.vastinc.daggerquotesapp.ui.author.search.SearchFragment;
import com.vastinc.daggerquotesapp.ui.home.HomeFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {MainViewModelsModule.class, MainModule.class})
public interface MainComponent {
    @Subcomponent.Factory
    interface Factory {
        MainComponent create();
    }
    void inject(MainActivity mainActivity);

    void inject(HomeFragment homeFragment);
    void inject(SearchFragment searchFragment);
    void inject(QuotesFragment quotesFragment);
}
