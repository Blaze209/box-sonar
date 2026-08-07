package com.box.android.domain.models.capture;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: CaptureMode.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/box/android/domain/models/capture/CaptureMode;", "", "requiredPermissions", "", "", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getRequiredPermissions", "()Ljava/util/List;", "VIDEO", "PHOTO", "SCAN", "AUDIO", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum CaptureMode {
    VIDEO(CollectionsKt.listOf((Object[]) new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"})),
    PHOTO(CollectionsKt.listOf("android.permission.CAMERA")),
    SCAN(CollectionsKt.listOf("android.permission.CAMERA")),
    AUDIO(CollectionsKt.listOf("android.permission.RECORD_AUDIO"));

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final List<String> requiredPermissions;

    public static EnumEntries<CaptureMode> getEntries() {
        return $ENTRIES;
    }

    CaptureMode(List list) {
        this.requiredPermissions = list;
    }

    public final List<String> getRequiredPermissions() {
        return this.requiredPermissions;
    }
}
