package com.box.android.contentpicker.uploadcontent;

import com.box.android.domain.services.IContentFileService;
import com.box.android.domain.services.IUploadFileProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadContentHandlerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/UploadContentEnvironment;", "", "uploadFileProvider", "Lcom/box/android/domain/services/IUploadFileProvider;", "contentFileService", "Lcom/box/android/domain/services/IContentFileService;", "<init>", "(Lcom/box/android/domain/services/IUploadFileProvider;Lcom/box/android/domain/services/IContentFileService;)V", "getUploadFileProvider", "()Lcom/box/android/domain/services/IUploadFileProvider;", "getContentFileService", "()Lcom/box/android/domain/services/IContentFileService;", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UploadContentEnvironment {
    public static final int $stable = 8;
    private final IContentFileService contentFileService;
    private final IUploadFileProvider uploadFileProvider;

    @Inject
    public UploadContentEnvironment(IUploadFileProvider uploadFileProvider, IContentFileService contentFileService) {
        Intrinsics.checkNotNullParameter(uploadFileProvider, "uploadFileProvider");
        Intrinsics.checkNotNullParameter(contentFileService, "contentFileService");
        this.uploadFileProvider = uploadFileProvider;
        this.contentFileService = contentFileService;
    }

    public final IUploadFileProvider getUploadFileProvider() {
        return this.uploadFileProvider;
    }

    public final IContentFileService getContentFileService() {
        return this.contentFileService;
    }
}
