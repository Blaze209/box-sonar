package com.box.android.fileactivity.presentation;

import com.box.android.cpl.Store;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivitiesScreen.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/box/android/fileactivity/presentation/FileActivity;", "", "itemState", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;", "parentItemState", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/fileactivity/presentation/FileActivityReducer$Action;", "<init>", "(Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;Lcom/box/android/cpl/Store;)V", "getItemState", "()Lcom/box/android/fileactivity/presentation/FileActivityReducer$State;", "getParentItemState", "getStore", "()Lcom/box/android/cpl/Store;", "isParentFileActivity", "", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileActivity {
    public static final int $stable = 8;
    private final boolean isParentFileActivity;
    private final FileActivityReducer.State itemState;
    private final FileActivityReducer.State parentItemState;
    private final Store<FileActivityReducer.State, FileActivityReducer.Action> store;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileActivity copy$default(FileActivity fileActivity, FileActivityReducer.State state, FileActivityReducer.State state2, Store store, int i, Object obj) {
        if ((i & 1) != 0) {
            state = fileActivity.itemState;
        }
        if ((i & 2) != 0) {
            state2 = fileActivity.parentItemState;
        }
        if ((i & 4) != 0) {
            store = fileActivity.store;
        }
        return fileActivity.copy(state, state2, store);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FileActivityReducer.State getItemState() {
        return this.itemState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FileActivityReducer.State getParentItemState() {
        return this.parentItemState;
    }

    public final Store<FileActivityReducer.State, FileActivityReducer.Action> component3() {
        return this.store;
    }

    public final FileActivity copy(FileActivityReducer.State itemState, FileActivityReducer.State parentItemState, Store<FileActivityReducer.State, FileActivityReducer.Action> store) {
        Intrinsics.checkNotNullParameter(itemState, "itemState");
        Intrinsics.checkNotNullParameter(parentItemState, "parentItemState");
        Intrinsics.checkNotNullParameter(store, "store");
        return new FileActivity(itemState, parentItemState, store);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileActivity)) {
            return false;
        }
        FileActivity fileActivity = (FileActivity) other;
        return Intrinsics.areEqual(this.itemState, fileActivity.itemState) && Intrinsics.areEqual(this.parentItemState, fileActivity.parentItemState) && Intrinsics.areEqual(this.store, fileActivity.store);
    }

    public int hashCode() {
        return (((this.itemState.hashCode() * 31) + this.parentItemState.hashCode()) * 31) + this.store.hashCode();
    }

    public String toString() {
        return "FileActivity(itemState=" + this.itemState + ", parentItemState=" + this.parentItemState + ", store=" + this.store + ")";
    }

    public FileActivity(FileActivityReducer.State itemState, FileActivityReducer.State parentItemState, Store<FileActivityReducer.State, FileActivityReducer.Action> store) {
        Intrinsics.checkNotNullParameter(itemState, "itemState");
        Intrinsics.checkNotNullParameter(parentItemState, "parentItemState");
        Intrinsics.checkNotNullParameter(store, "store");
        this.itemState = itemState;
        this.parentItemState = parentItemState;
        this.store = store;
        this.isParentFileActivity = Intrinsics.areEqual(itemState.getId(), parentItemState.getId());
    }

    public final FileActivityReducer.State getItemState() {
        return this.itemState;
    }

    public final FileActivityReducer.State getParentItemState() {
        return this.parentItemState;
    }

    public final Store<FileActivityReducer.State, FileActivityReducer.Action> getStore() {
        return this.store;
    }

    /* JADX INFO: renamed from: isParentFileActivity, reason: from getter */
    public final boolean getIsParentFileActivity() {
        return this.isParentFileActivity;
    }
}
