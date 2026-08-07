package com.box.android.data.service.impl;

import com.amplitude.api.Constants;
import com.box.android.data.datasource.fileversions.FileVersionsRemoteDataSource;
import com.box.android.domain.services.IFileVersionService;
import com.box.android.domain.services.IdMappingService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/service/impl/FileVersionService;", "Lcom/box/android/domain/services/IFileVersionService;", "fileVersionsRemoteDataSource", "Lcom/box/android/data/datasource/fileversions/FileVersionsRemoteDataSource;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/datasource/fileversions/FileVersionsRemoteDataSource;Lcom/box/android/domain/services/IdMappingService;)V", "getFileVersion", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/fileversions/FileVersionModel;", "Lcom/box/android/domain/models/DomainError;", "fileId", "Lcom/box/android/domain/models/ItemId;", Constants.AMP_PLAN_VERSION_ID, "", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileVersionService implements IFileVersionService {
    private final FileVersionsRemoteDataSource fileVersionsRemoteDataSource;
    private final IdMappingService idMappingService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.FileVersionService$getFileVersion$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileVersionService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.FileVersionService", f = "FileVersionService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {22, 24}, m = "getFileVersion", n = {"fileId", Constants.AMP_PLAN_VERSION_ID, "fileId", Constants.AMP_PLAN_VERSION_ID, "$this$flatMap$iv", "remoteId", "$i$f$flatMap", "$i$a$-flatMap-FileVersionService$getFileVersion$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileVersionService.this.getFileVersion(null, null, this);
        }
    }

    @Inject
    public FileVersionService(FileVersionsRemoteDataSource fileVersionsRemoteDataSource, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(fileVersionsRemoteDataSource, "fileVersionsRemoteDataSource");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.fileVersionsRemoteDataSource = fileVersionsRemoteDataSource;
        this.idMappingService = idMappingService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a0, code lost:
    
        if (r8 == r1) goto L23;
     */
    @Override // com.box.android.domain.services.IFileVersionService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getFileVersion(com.box.android.domain.models.ItemId r6, java.lang.String r7, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.fileversions.FileVersionModel, ? extends com.box.android.domain.models.DomainError>> r8) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.FileVersionService.getFileVersion(com.box.android.domain.models.ItemId, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
