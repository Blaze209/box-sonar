package com.box.android.utilities;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class EmailChooserHelper_Factory implements Factory<EmailChooserHelper> {
    private final Provider<Context> contextProvider;

    private EmailChooserHelper_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public EmailChooserHelper get() {
        return newInstance(this.contextProvider.get());
    }

    public static EmailChooserHelper_Factory create(Provider<Context> provider) {
        return new EmailChooserHelper_Factory(provider);
    }

    public static EmailChooserHelper newInstance(Context context) {
        return new EmailChooserHelper(context);
    }
}
