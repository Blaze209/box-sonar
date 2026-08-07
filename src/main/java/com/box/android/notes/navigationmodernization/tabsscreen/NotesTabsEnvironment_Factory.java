package com.box.android.notes.navigationmodernization.tabsscreen;

import com.box.android.notes.navigationmodernization.NotesAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class NotesTabsEnvironment_Factory implements Factory<NotesTabsEnvironment> {
    private final Provider<NotesAnalytics> analyticsProvider;

    private NotesTabsEnvironment_Factory(Provider<NotesAnalytics> provider) {
        this.analyticsProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotesTabsEnvironment get() {
        return newInstance(this.analyticsProvider.get());
    }

    public static NotesTabsEnvironment_Factory create(Provider<NotesAnalytics> provider) {
        return new NotesTabsEnvironment_Factory(provider);
    }

    public static NotesTabsEnvironment newInstance(NotesAnalytics notesAnalytics) {
        return new NotesTabsEnvironment(notesAnalytics);
    }
}
