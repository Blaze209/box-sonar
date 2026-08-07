package com.box.android.preview.filesandfolders;

import com.box.android.preview.R;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: PagingMode.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/preview/filesandfolders/PagingMode;", "", "stringRes", "", "<init>", "(Ljava/lang/String;II)V", "getStringRes", "()I", "HORIZONTAL", "VERTICAL", "VERTICAL_CONTINUOUS", AuthenticationConstants.IntuneContentProviderCall.APP_DATA_CLEAR_UNSUPPORTED, "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum PagingMode {
    HORIZONTAL(R.string.paging_mode_horizontal),
    VERTICAL(R.string.paging_mode_vertical),
    VERTICAL_CONTINUOUS(R.string.paging_mode_vertical_continuous),
    UNSUPPORTED(R.string.paging_mode_unsupported);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int stringRes;

    public static EnumEntries<PagingMode> getEntries() {
        return $ENTRIES;
    }

    PagingMode(int i) {
        this.stringRes = i;
    }

    public final int getStringRes() {
        return this.stringRes;
    }
}
