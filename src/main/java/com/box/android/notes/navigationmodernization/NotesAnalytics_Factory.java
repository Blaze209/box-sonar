package com.box.android.notes.navigationmodernization;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class NotesAnalytics_Factory implements Factory<NotesAnalytics> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public NotesAnalytics get() {
        return newInstance();
    }

    public static NotesAnalytics_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NotesAnalytics newInstance() {
        return new NotesAnalytics();
    }

    private static final class InstanceHolder {
        static final NotesAnalytics_Factory INSTANCE = new NotesAnalytics_Factory();

        private InstanceHolder() {
        }
    }
}
