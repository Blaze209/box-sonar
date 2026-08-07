package com.box.android.preview.previousversion;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.fileactivity.presentation.FileActivitiesLauncher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: PreviousVersionRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/preview/previousversion/PreviousVersionRouter;", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$State;", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$Action;", "activity", "Landroidx/fragment/app/FragmentActivity;", "fileActivitiesLauncher", "Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;", "<init>", "(Lcom/box/android/cpl/Store;Landroidx/fragment/app/FragmentActivity;Lcom/box/android/fileactivity/presentation/FileActivitiesLauncher;)V", "initRouting", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionRouter {
    public static final int $stable = 8;
    private final FragmentActivity activity;
    private final FileActivitiesLauncher fileActivitiesLauncher;
    private final Store<PreviousVersionReducer.State, PreviousVersionReducer.Action> store;

    public PreviousVersionRouter(Store<PreviousVersionReducer.State, PreviousVersionReducer.Action> store, FragmentActivity activity, FileActivitiesLauncher fileActivitiesLauncher) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(fileActivitiesLauncher, "fileActivitiesLauncher");
        this.store = store;
        this.activity = activity;
        this.fileActivitiesLauncher = fileActivitiesLauncher;
    }

    public final void initRouting() {
        StoreKt.observe(this.store, new PropertyReference1Impl() { // from class: com.box.android.preview.previousversion.PreviousVersionRouter.initRouting.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((PreviousVersionReducer.State) obj).getNavigationRoute();
            }
        }, LifecycleOwnerKt.getLifecycleScope(this.activity), new Function1() { // from class: com.box.android.preview.previousversion.PreviousVersionRouter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PreviousVersionRouter.initRouting$lambda$0(this.f$0, (PreviousVersionReducer.PreviousVersionRoute) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initRouting$lambda$0(PreviousVersionRouter previousVersionRouter, PreviousVersionReducer.PreviousVersionRoute navigationRoute) {
        Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
        if (navigationRoute instanceof PreviousVersionReducer.PreviousVersionRoute.FileActivities) {
            previousVersionRouter.fileActivitiesLauncher.openFileActivities(previousVersionRouter.activity, ((PreviousVersionReducer.State) StoreKt.stateValue(previousVersionRouter.store)).getItemState().getFileModel(), ((PreviousVersionReducer.PreviousVersionRoute.FileActivities) navigationRoute).getActivityId(), null);
        } else if (navigationRoute instanceof PreviousVersionReducer.PreviousVersionRoute.Close) {
            previousVersionRouter.activity.finish();
        } else {
            if (navigationRoute instanceof PreviousVersionReducer.PreviousVersionRoute.None) {
                return Unit.INSTANCE;
            }
            throw new NoWhenBranchMatchedException();
        }
        previousVersionRouter.store.send(new PreviousVersionReducer.Action.Navigate(PreviousVersionReducer.PreviousVersionRoute.None.INSTANCE));
        return Unit.INSTANCE;
    }
}
