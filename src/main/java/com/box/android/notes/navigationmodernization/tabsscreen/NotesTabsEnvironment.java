package com.box.android.notes.navigationmodernization.tabsscreen;

import com.box.android.notes.navigationmodernization.NotesAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesTabsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsEnvironment;", "", "analytics", "Lcom/box/android/notes/navigationmodernization/NotesAnalytics;", "<init>", "(Lcom/box/android/notes/navigationmodernization/NotesAnalytics;)V", "getAnalytics", "()Lcom/box/android/notes/navigationmodernization/NotesAnalytics;", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesTabsEnvironment {
    public static final int $stable = 0;
    private final NotesAnalytics analytics;

    @Inject
    public NotesTabsEnvironment(NotesAnalytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.analytics = analytics;
    }

    public final NotesAnalytics getAnalytics() {
        return this.analytics;
    }
}
