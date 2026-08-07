package com.box.android.domain.services;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IUploadFileService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010JD\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH¦@¢\u0006\u0002\u0010\u000f¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IUploadFileService;", "", "uploadFile", "Lcom/box/android/domain/utils/result/ResultProgressWrapper;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", "Lcom/box/android/domain/utils/Progress;", "fileToUpload", "Ljava/io/File;", BoxCommonConstants.EXTRA_FILE_NAME, "", "parentFolderId", "Lcom/box/android/domain/models/ItemId$Remote;", "newFileVersionUpload", "Lcom/box/android/domain/services/IUploadFileService$NewFileVersionUpload;", "(Ljava/io/File;Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/services/IUploadFileService$NewFileVersionUpload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NewFileVersionUpload", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IUploadFileService {
    Object uploadFile(File file, String str, ItemId.Remote remote, NewFileVersionUpload newFileVersionUpload, Continuation<? super ResultProgressWrapper<FileModel, DomainError, Progress>> continuation);

    /* JADX INFO: compiled from: IUploadFileService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object uploadFile$default(IUploadFileService iUploadFileService, File file, String str, ItemId.Remote remote, NewFileVersionUpload newFileVersionUpload, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
        }
        if ((i & 8) != 0) {
            newFileVersionUpload = null;
        }
        return iUploadFileService.uploadFile(file, str, remote, newFileVersionUpload, continuation);
    }

    /* JADX INFO: compiled from: IUploadFileService.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/services/IUploadFileService$NewFileVersionUpload;", "", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "ifMatchEtag", "", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getIfMatchEtag", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NewFileVersionUpload {
        private final String ifMatchEtag;
        private final ItemId.Remote itemId;

        public static /* synthetic */ NewFileVersionUpload copy$default(NewFileVersionUpload newFileVersionUpload, ItemId.Remote remote, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                remote = newFileVersionUpload.itemId;
            }
            if ((i & 2) != 0) {
                str = newFileVersionUpload.ifMatchEtag;
            }
            return newFileVersionUpload.copy(remote, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemId.Remote getItemId() {
            return this.itemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIfMatchEtag() {
            return this.ifMatchEtag;
        }

        public final NewFileVersionUpload copy(ItemId.Remote itemId, String ifMatchEtag) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            return new NewFileVersionUpload(itemId, ifMatchEtag);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NewFileVersionUpload)) {
                return false;
            }
            NewFileVersionUpload newFileVersionUpload = (NewFileVersionUpload) other;
            return Intrinsics.areEqual(this.itemId, newFileVersionUpload.itemId) && Intrinsics.areEqual(this.ifMatchEtag, newFileVersionUpload.ifMatchEtag);
        }

        public int hashCode() {
            int iHashCode = this.itemId.hashCode() * 31;
            String str = this.ifMatchEtag;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "NewFileVersionUpload(itemId=" + this.itemId + ", ifMatchEtag=" + this.ifMatchEtag + ")";
        }

        public NewFileVersionUpload(ItemId.Remote itemId, String str) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            this.itemId = itemId;
            this.ifMatchEtag = str;
        }

        public /* synthetic */ NewFileVersionUpload(ItemId.Remote remote, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(remote, (i & 2) != 0 ? null : str);
        }

        public final String getIfMatchEtag() {
            return this.ifMatchEtag;
        }

        public final ItemId.Remote getItemId() {
            return this.itemId;
        }
    }
}
