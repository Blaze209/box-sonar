package com.box.android.domain.preview;

import com.box.android.domain.models.ThrowableDomainError;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: IFileCanBePreviewedChecker.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/preview/IFileCanBePreviewedChecker;", "", "checkFile", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "fallbackPolicy", "Lcom/box/android/domain/preview/IFileCanBePreviewedChecker$FallbackPolicy;", "FallbackPolicy", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IFileCanBePreviewedChecker {

    /* JADX INFO: compiled from: IFileCanBePreviewedChecker.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/domain/preview/IFileCanBePreviewedChecker$FallbackPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOW", "FAIL", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum FallbackPolicy {
        ALLOW,
        FAIL;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<FallbackPolicy> getEntries() {
            return $ENTRIES;
        }
    }

    void checkFile(FileModel fileModel, FallbackPolicy fallbackPolicy) throws ThrowableDomainError;
}
