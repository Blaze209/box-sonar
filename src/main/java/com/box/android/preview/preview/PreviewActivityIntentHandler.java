package com.box.android.preview.preview;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.box.android.base.routing.preview.PreviewNavigationTarget;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.fileactions.FileAction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewActivityIntentHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/preview/PreviewActivityIntentHandler;", "", "<init>", "()V", "handleIntent", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "activity", "Landroidx/fragment/app/FragmentActivity;", "intent", "Landroid/content/Intent;", "isInitialIntent", "", "hasFileModelChanged", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewActivityIntentHandler {
    public static final int $stable = 0;

    @Inject
    public PreviewActivityIntentHandler() {
    }

    public final void handleIntent(Store<PreviewReducer.State, PreviewReducer.Action> store, FragmentActivity activity, Intent intent, boolean isInitialIntent) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (hasFileModelChanged(intent, store)) {
            if (isInitialIntent) {
                return;
            }
            activity.finish();
            activity.startActivity(intent);
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra(PreviewActivity.NAVIGATION_TARGET, PreviewNavigationTarget.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra(PreviewActivity.NAVIGATION_TARGET);
            if (!(parcelableExtra instanceof PreviewNavigationTarget)) {
                parcelableExtra = null;
            }
            parcelable = (PreviewNavigationTarget) parcelableExtra;
        }
        PreviewNavigationTarget previewNavigationTarget = (PreviewNavigationTarget) parcelable;
        if (previewNavigationTarget != null) {
            store.send(new PreviewReducer.Action.NavigateToTarget(previewNavigationTarget));
        }
        if (intent.getBooleanExtra(PreviewActivity.IS_OPENING_CREATED_OFFICE_FILE, false)) {
            store.send(PreviewReducerHelpersKt.performAction(PreviewReducer.Action.FileActionsAction.INSTANCE, FileAction.OpenIn));
        }
    }

    private final boolean hasFileModelChanged(Intent intent, Store<PreviewReducer.State, PreviewReducer.Action> store) {
        Parcelable parcelable;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra(PreviewActivity.INITIAL_FILE_MODEL_KEY, FileModel.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra(PreviewActivity.INITIAL_FILE_MODEL_KEY);
            if (!(parcelableExtra instanceof FileModel)) {
                parcelableExtra = null;
            }
            parcelable = (FileModel) parcelableExtra;
        }
        FileModel fileModel = (FileModel) parcelable;
        if (fileModel == null) {
            return false;
        }
        return !Intrinsics.areEqual(fileModel.getItemId(), ((PreviewReducer.State) StoreKt.stateValue(store)).getFileModel().getItemId());
    }
}
