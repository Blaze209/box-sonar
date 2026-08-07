package com.box.android.base.presentation.utilities;

import com.box.android.base.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: SupportedFileExtensionIcons.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/box/android/base/presentation/utilities/FolderTypeIcon;", "", "drawable", "", "contentDescription", "<init>", "(Ljava/lang/String;III)V", "getDrawable", "()I", "getContentDescription", "PERSONAL", "EXTERNAL", "COLLABORATED", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum FolderTypeIcon {
    PERSONAL(R.drawable.ic_folder_personal, R.string.personal_folder_icon_label),
    EXTERNAL(R.drawable.ic_folder_external, R.string.external_folder_icon_label),
    COLLABORATED(R.drawable.ic_folder_shared, R.string.collaborated_folder_icon_label);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int contentDescription;
    private final int drawable;

    public static EnumEntries<FolderTypeIcon> getEntries() {
        return $ENTRIES;
    }

    FolderTypeIcon(int i, int i2) {
        this.drawable = i;
        this.contentDescription = i2;
    }

    public final int getContentDescription() {
        return this.contentDescription;
    }

    public final int getDrawable() {
        return this.drawable;
    }
}
