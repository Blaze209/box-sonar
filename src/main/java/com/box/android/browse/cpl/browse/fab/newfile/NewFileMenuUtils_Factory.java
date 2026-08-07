package com.box.android.browse.cpl.browse.fab.newfile;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class NewFileMenuUtils_Factory implements Factory<NewFileMenuUtils> {
    private final Provider<Context> contextProvider;

    private NewFileMenuUtils_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NewFileMenuUtils get() {
        return newInstance(this.contextProvider.get());
    }

    public static NewFileMenuUtils_Factory create(Provider<Context> provider) {
        return new NewFileMenuUtils_Factory(provider);
    }

    public static NewFileMenuUtils newInstance(Context context) {
        return new NewFileMenuUtils(context);
    }
}
