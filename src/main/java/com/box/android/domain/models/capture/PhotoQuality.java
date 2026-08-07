package com.box.android.domain.models.capture;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: PhotoQuality.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/domain/models/capture/PhotoQuality;", "", "compression", "", "<init>", "(Ljava/lang/String;II)V", "getCompression", "()I", "ORIGINAL", "LARGE", "MEDIUM", "SMALL", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum PhotoQuality {
    ORIGINAL(100),
    LARGE(90),
    MEDIUM(70),
    SMALL(50);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int compression;

    public static EnumEntries<PhotoQuality> getEntries() {
        return $ENTRIES;
    }

    PhotoQuality(int i) {
        this.compression = i;
    }

    public final int getCompression() {
        return this.compression;
    }
}
