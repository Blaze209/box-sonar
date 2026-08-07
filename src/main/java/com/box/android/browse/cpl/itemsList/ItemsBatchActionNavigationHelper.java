package com.box.android.browse.cpl.itemsList;

import android.content.Intent;
import android.os.Environment;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.browse.R;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.common.utilities.IntentUtils;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.mappers.ItemModelMapper;
import com.box.android.domain.models.item.ItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemsBatchActionNavigationHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J$\u0010\u0012\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u001c\u0010\u0013\u001a\u00020\u000b2\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u000b0\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemsBatchActionNavigationHelper;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "copyOrMoveHelper", "Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/box/android/browse/utilities/CopyOrMoveHelper;Lcom/box/android/coreservices/services/IntentServices;)V", "navigateToCopyMoveFlow", "", "files", "", "Lcom/box/android/domain/models/item/ItemModel;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "navigateToDeleteFlow", "navigateToExportFlow", "onExportDestinationSelected", "Lkotlin/Function1;", "", "downloadToFolderLauncher", "exportDestinationSelectedCallback", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemsBatchActionNavigationHelper {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private final CopyOrMoveHelper copyOrMoveHelper;
    private ActivityResultLauncher<Intent> downloadToFolderLauncher;
    private Function1<? super String, Unit> exportDestinationSelectedCallback;
    private final IntentServices intentServices;

    public ItemsBatchActionNavigationHelper(AppCompatActivity activity, CopyOrMoveHelper copyOrMoveHelper, IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(copyOrMoveHelper, "copyOrMoveHelper");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        this.activity = activity;
        this.copyOrMoveHelper = copyOrMoveHelper;
        this.intentServices = intentServices;
        this.downloadToFolderLauncher = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.box.android.browse.cpl.itemsList.ItemsBatchActionNavigationHelper$downloadToFolderLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(ActivityResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intent data = result.getData();
                String stringExtra = data != null ? data.getStringExtra(IntentConstants.LocalFolderChooser.EXTRA_SELECTED_DIR) : null;
                Function1 function1 = this.this$0.exportDestinationSelectedCallback;
                if (function1 != null) {
                    function1.invoke(stringExtra);
                }
                this.this$0.exportDestinationSelectedCallback = null;
            }
        });
    }

    public final void navigateToCopyMoveFlow(List<? extends ItemModel> files, ActivityResultLauncher<Intent> launcher) {
        Intrinsics.checkNotNullParameter(files, "files");
        if (launcher != null) {
            this.copyOrMoveHelper.startCopyOrMoveFlow(this.activity, launcher, files);
        } else {
            this.copyOrMoveHelper.startCopyOrMoveFlow(this.activity, files);
        }
    }

    public final void navigateToDeleteFlow(List<? extends ItemModel> files, ActivityResultLauncher<Intent> launcher) {
        Intrinsics.checkNotNullParameter(files, "files");
        IntentServices intentServices = this.intentServices;
        AppCompatActivity appCompatActivity = this.activity;
        List<? extends ItemModel> list = files;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(ItemModelMapper.toBoxItem$default(ItemModelMapper.INSTANCE, (ItemModel) it.next(), false, 1, null));
        }
        IntentUtils.INSTANCE.launchWithLauncherIfExistOrWithActivity(intentServices.newDeleteTaskIntent(appCompatActivity, arrayList), this.activity, launcher);
    }

    public final void navigateToExportFlow(final Function1<? super String, Unit> onExportDestinationSelected) {
        Intrinsics.checkNotNullParameter(onExportDestinationSelected, "onExportDestinationSelected");
        if (this.exportDestinationSelectedCallback != null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.downloadToFolderLauncher;
        IntentServices intentServices = this.intentServices;
        AppCompatActivity appCompatActivity = this.activity;
        String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        activityResultLauncher.launch(intentServices.localFolderChooserIntent(appCompatActivity, absolutePath, this.activity.getString(R.string.pick_destination)));
        this.exportDestinationSelectedCallback = new Function1() { // from class: com.box.android.browse.cpl.itemsList.ItemsBatchActionNavigationHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ItemsBatchActionNavigationHelper.navigateToExportFlow$lambda$0(onExportDestinationSelected, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigateToExportFlow$lambda$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }
}
