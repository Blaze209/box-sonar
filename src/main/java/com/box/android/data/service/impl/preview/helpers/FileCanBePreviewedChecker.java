package com.box.android.data.service.impl.preview.helpers;

import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.domain.models.ThrowableDomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.preview.IFileCanBePreviewedChecker;
import com.box.android.domain.utils.SupportedFileExtensions;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileCanBePreviewedChecker.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\f\u0010\r\u001a\u00020\u000e*\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/service/impl/preview/helpers/FileCanBePreviewedChecker;", "Lcom/box/android/domain/preview/IFileCanBePreviewedChecker;", "<init>", "()V", "checkFetchedFile", "", "fetchResult", "Lcom/box/android/data/service/impl/preview/helpers/PreviewFileWithRepresentationsResult;", "checkFile", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "fallbackPolicy", "Lcom/box/android/domain/preview/IFileCanBePreviewedChecker$FallbackPolicy;", "shouldPass", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileCanBePreviewedChecker implements IFileCanBePreviewedChecker {

    /* JADX INFO: compiled from: FileCanBePreviewedChecker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IFileCanBePreviewedChecker.FallbackPolicy.values().length];
            try {
                iArr[IFileCanBePreviewedChecker.FallbackPolicy.ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IFileCanBePreviewedChecker.FallbackPolicy.FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public FileCanBePreviewedChecker() {
    }

    public final void checkFetchedFile(PreviewFileWithRepresentationsResult fetchResult) throws ThrowableDomainError {
        Intrinsics.checkNotNullParameter(fetchResult, "fetchResult");
        if (fetchResult instanceof PreviewFileWithRepresentationsResult.Error) {
            PreviewFileWithRepresentationsResult.Error error = (PreviewFileWithRepresentationsResult.Error) fetchResult;
            if (error.isProhibitedForPreviewByServer()) {
                throw new ThrowableDomainError(error.getError());
            }
        }
        if (fetchResult instanceof PreviewFileWithRepresentationsResult.Success) {
            checkFile(((PreviewFileWithRepresentationsResult.Success) fetchResult).getFileModel(), IFileCanBePreviewedChecker.FallbackPolicy.FAIL);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.domain.preview.IFileCanBePreviewedChecker
    public void checkFile(FileModel fileModel, IFileCanBePreviewedChecker.FallbackPolicy fallbackPolicy) throws ThrowableDomainError {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(fallbackPolicy, "fallbackPolicy");
        PermissionsModel permissions = fileModel.getPermissions();
        boolean canPreview = permissions != null ? permissions.getCanPreview() : shouldPass(fallbackPolicy);
        int i = 1;
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (!canPreview) {
            throw new ThrowableDomainError(new FilePreviewDomainError.NoPreviewPermissionsError(objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0));
        }
        if (fileModel.getSize().longValue() == 0 && !SupportedFileExtensions.INSTANCE.isBoxNoteExtension(fileModel.getExtension())) {
            throw new ThrowableDomainError(new FilePreviewDomainError.CannotOpenEmptyFile(str, i, objArr3 == true ? 1 : 0));
        }
    }

    private final boolean shouldPass(IFileCanBePreviewedChecker.FallbackPolicy fallbackPolicy) {
        int i = WhenMappings.$EnumSwitchMapping$0[fallbackPolicy.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}
