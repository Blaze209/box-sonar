package com.box.android.browse.utilities;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CreateFolderHelper_Factory implements Factory<CreateFolderHelper> {
    private final Provider<Context> applicationContextProvider;

    private CreateFolderHelper_Factory(Provider<Context> provider) {
        this.applicationContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateFolderHelper get() {
        return newInstance(this.applicationContextProvider.get());
    }

    public static CreateFolderHelper_Factory create(Provider<Context> provider) {
        return new CreateFolderHelper_Factory(provider);
    }

    public static CreateFolderHelper newInstance(Context context) {
        return new CreateFolderHelper(context);
    }
}
