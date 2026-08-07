package com.box.android.capture;

import androidx.fragment.app.FragmentTransaction;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.domain.models.capture.CaptureMode;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: ICaptureActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/capture/ICaptureActivity;", "", "showCaptureHistory", "", "fragmentTransaction", "Landroidx/fragment/app/FragmentTransaction;", "openErrorFragment", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "onItemClick", "item", "Lcom/box/android/domain/models/item/FileModel;", "showBottomSheet", "type", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "closeCaptureHistory", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICaptureActivity {
    void closeCaptureHistory();

    void onItemClick(FileModel item);

    void openErrorFragment(CaptureMode captureMode);

    void showBottomSheet(FileModel item, BottomSheetAttributes.BottomSheetMenuType type, BottomSheetAttributes.LaunchContext launchContext);

    void showCaptureHistory(FragmentTransaction fragmentTransaction);

    /* JADX INFO: compiled from: ICaptureActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void showBottomSheet$default(ICaptureActivity iCaptureActivity, FileModel fileModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBottomSheet");
        }
        if ((i & 4) != 0) {
            launchContext = BottomSheetAttributes.LaunchContext.Default.INSTANCE;
        }
        iCaptureActivity.showBottomSheet(fileModel, bottomSheetMenuType, launchContext);
    }
}
