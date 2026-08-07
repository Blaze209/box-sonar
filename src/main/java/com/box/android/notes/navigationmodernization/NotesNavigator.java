package com.box.android.notes.navigationmodernization;

import android.app.Activity;
import com.box.android.browse.cpl.browse.fab.FabManager;
import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.preview.PreviewSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesNavigator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/notes/navigationmodernization/NotesNavigator;", "", "activity", "Landroid/app/Activity;", "fabManager", "Lcom/box/android/browse/cpl/browse/fab/FabManager;", "<init>", "(Landroid/app/Activity;Lcom/box/android/browse/cpl/browse/fab/FabManager;)V", "navigateTo", "", FirebaseAnalytics.Param.DESTINATION, "Lcom/box/android/notes/navigationmodernization/NotesDestination$OuterDestination;", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesNavigator {
    public static final int $stable = 8;
    private final Activity activity;
    private final FabManager fabManager;

    public NotesNavigator(Activity activity, FabManager fabManager) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fabManager, "fabManager");
        this.activity = activity;
        this.fabManager = fabManager;
    }

    public final void navigateTo(NotesDestination.OuterDestination destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (!(destination instanceof NotesDestination.OuterDestination.NewNote)) {
            throw new NoWhenBranchMatchedException();
        }
        this.fabManager.handleNewBoxNoteClick(NewNoteLocation.DefaultNotesFolder.INSTANCE, PreviewSource.Notes.INSTANCE, this.activity);
    }
}
