package com.box.android.data.service.impl;

import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.api.models.items.ItemsDTO;
import com.box.android.data.api.models.upload.UploadFileChunkDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource;
import com.box.android.data.datasource.files.UploadFileRemoteDataSource;
import com.box.android.data.jobs.ChunkUploadJob;
import com.box.android.domain.configuration.UserSessionInfo;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.IUploadFileService;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: UploadFileService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 92\u00020\u0001:\u00019B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJB\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096@¢\u0006\u0002\u0010\u0019J>\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f0\u001b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J>\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000f0\u001b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010 J@\u0010'\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J8\u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u000f0\u001b2\u0006\u00101\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00142\f\u00102\u001a\b\u0012\u0004\u0012\u00020(03H\u0086@¢\u0006\u0002\u00104J<\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r2\u0006\u00106\u001a\u00020\u00122\u0018\u00107\u001a\u0014\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00100\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/box/android/data/service/impl/UploadFileService;", "Lcom/box/android/domain/services/IUploadFileService;", "uploadFileRemoteDataSource", "Lcom/box/android/data/datasource/files/UploadFileRemoteDataSource;", "chunkedFileUploadRemoteDataSource", "Lcom/box/android/data/datasource/files/ChunkedFileUploadRemoteDataSource;", "userSessionInfo", "Lcom/box/android/domain/configuration/UserSessionInfo;", "commonServiceUtils", "Lcom/box/android/data/service/impl/CommonServiceUtils;", "<init>", "(Lcom/box/android/data/datasource/files/UploadFileRemoteDataSource;Lcom/box/android/data/datasource/files/ChunkedFileUploadRemoteDataSource;Lcom/box/android/domain/configuration/UserSessionInfo;Lcom/box/android/data/service/impl/CommonServiceUtils;)V", "uploadFile", "Lcom/box/android/domain/utils/result/ResultProgressWrapper;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", "Lcom/box/android/domain/utils/Progress;", "fileToUpload", "Ljava/io/File;", BoxCommonConstants.EXTRA_FILE_NAME, "", "parentFolderId", "Lcom/box/android/domain/models/ItemId$Remote;", "newFileVersionUpload", "Lcom/box/android/domain/services/IUploadFileService$NewFileVersionUpload;", "(Ljava/io/File;Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/services/IUploadFileService$NewFileVersionUpload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performPreflightChecks", "Lcom/box/android/domain/utils/result/Result;", "", "size", "", "fileId", "(Ljava/lang/String;JLcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUploadRisky", "", "createUploadSession", "Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "fileSize", "fileIdToOverwrite", "uploadChunk", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTO;", ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, "contentRange", "digest", "chunk", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commitUploadSession", "Lcom/box/android/data/api/models/items/ItemsDTO;", "commitSessionEndpoint", "parts", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUploadSuccess", "file", "progressWrapper", "Lcom/box/android/data/datasource/errors/RemoteError;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadFileService implements IUploadFileService {
    public static final int MINIMUM_BYTES_FOR_PREFLIGHT_CHECK = 200000;
    private final ChunkedFileUploadRemoteDataSource chunkedFileUploadRemoteDataSource;
    private final CommonServiceUtils commonServiceUtils;
    private final UploadFileRemoteDataSource uploadFileRemoteDataSource;
    private final UserSessionInfo userSessionInfo;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileService$commitUploadSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileService", f = "UploadFileService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {Token.SETCONSTVAR, Token.DEBUGGER}, m = "commitUploadSession", n = {"commitSessionEndpoint", "digest", "parts", "commitSessionEndpoint", "digest", "parts", "$this$onSuccess$iv", "it", "$this$forEach$iv", "element$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-UploadFileService$commitUploadSession$3", "$i$f$forEach", "$i$a$-forEach-UploadFileService$commitUploadSession$3$1"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileService.this.commitUploadSession(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileService$createUploadSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileService", f = "UploadFileService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {119, 125}, m = "createUploadSession", n = {BoxCommonConstants.EXTRA_FILE_NAME, "parentFolderId", "fileIdToOverwrite", "fileSize", BoxCommonConstants.EXTRA_FILE_NAME, "parentFolderId", "fileIdToOverwrite", "fileSize"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"}, v = 1)
    static final class C15311 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15311(Continuation<? super C15311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileService.this.createUploadSession(null, 0L, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileService$performPreflightChecks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileService", f = "UploadFileService.kt", i = {0, 0, 0, 0}, l = {82}, m = "performPreflightChecks", n = {BoxCommonConstants.EXTRA_FILE_NAME, "parentFolderId", "fileId", "size"}, s = {"L$0", "L$1", "L$2", "J$0"}, v = 1)
    static final class C15321 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15321(Continuation<? super C15321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileService.this.performPreflightChecks(null, 0L, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileService$uploadChunk$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileService", f = "UploadFileService.kt", i = {0, 0, 0, 0}, l = {139}, m = "uploadChunk", n = {ChunkUploadJob.CHUNK_UPLOAD_ENDPOINT_PARAM, "contentRange", "digest", "chunk"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C15331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C15331(Continuation<? super C15331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileService.this.uploadChunk(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileService$uploadFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileService", f = "UploadFileService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {41, 67}, m = "uploadFile", n = {"fileToUpload", BoxCommonConstants.EXTRA_FILE_NAME, "parentFolderId", "newFileVersionUpload", "fileToUpload", BoxCommonConstants.EXTRA_FILE_NAME, "parentFolderId", "newFileVersionUpload", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flatMapError$iv", "it", "$i$f$flatMapError", "$i$a$-flatMapError-UploadFileService$uploadFile$mappedResult$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C15341 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C15341(Continuation<? super C15341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileService.this.uploadFile(null, null, null, null, this);
        }
    }

    @Inject
    public UploadFileService(UploadFileRemoteDataSource uploadFileRemoteDataSource, ChunkedFileUploadRemoteDataSource chunkedFileUploadRemoteDataSource, UserSessionInfo userSessionInfo, CommonServiceUtils commonServiceUtils) {
        Intrinsics.checkNotNullParameter(uploadFileRemoteDataSource, "uploadFileRemoteDataSource");
        Intrinsics.checkNotNullParameter(chunkedFileUploadRemoteDataSource, "chunkedFileUploadRemoteDataSource");
        Intrinsics.checkNotNullParameter(userSessionInfo, "userSessionInfo");
        Intrinsics.checkNotNullParameter(commonServiceUtils, "commonServiceUtils");
        this.uploadFileRemoteDataSource = uploadFileRemoteDataSource;
        this.chunkedFileUploadRemoteDataSource = chunkedFileUploadRemoteDataSource;
        this.userSessionInfo = userSessionInfo;
        this.commonServiceUtils = commonServiceUtils;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:43:0x013c  */
    /* JADX WARN: Code duplicated, block: B:45:0x0142  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011c, code lost:
    
        if (r1 == r9) goto L39;
     */
    @Override // com.box.android.domain.services.IUploadFileService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object uploadFile(java.io.File r18, java.lang.String r19, com.box.android.domain.models.ItemId.Remote r20, com.box.android.domain.services.IUploadFileService.NewFileVersionUpload r21, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.ResultProgressWrapper<com.box.android.domain.models.item.FileModel, com.box.android.domain.models.DomainError, com.box.android.domain.utils.Progress>> r22) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.UploadFileService.uploadFile(java.io.File, java.lang.String, com.box.android.domain.models.ItemId$Remote, com.box.android.domain.services.IUploadFileService$NewFileVersionUpload, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object performPreflightChecks$default(UploadFileService uploadFileService, String str, long j, ItemId.Remote remote, ItemId.Remote remote2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            remote2 = null;
        }
        return uploadFileService.performPreflightChecks(str, j, remote, remote2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object performPreflightChecks(String str, long j, ItemId.Remote remote, ItemId.Remote remote2, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C15321 c15321;
        ItemId.Remote remote3;
        if (continuation instanceof C15321) {
            c15321 = (C15321) continuation;
            if ((c15321.label & Integer.MIN_VALUE) != 0) {
                c15321.label -= Integer.MIN_VALUE;
            } else {
                c15321 = new C15321(continuation);
            }
        } else {
            c15321 = new C15321(continuation);
        }
        C15321 c15322 = c15321;
        Object objPerformPreflightCheck = c15322.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15322.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objPerformPreflightCheck);
            UploadFileRemoteDataSource uploadFileRemoteDataSource = this.uploadFileRemoteDataSource;
            c15322.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c15322.L$1 = remote;
            c15322.L$2 = SpillingKt.nullOutSpilledVariable(remote2);
            c15322.J$0 = j;
            c15322.label = 1;
            objPerformPreflightCheck = uploadFileRemoteDataSource.performPreflightCheck(str, j, remote, null, remote2, c15322);
            if (objPerformPreflightCheck == coroutine_suspended) {
                return coroutine_suspended;
            }
            remote3 = remote;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = c15322.J$0;
            remote3 = (ItemId.Remote) c15322.L$1;
            ResultKt.throwOnFailure(objPerformPreflightCheck);
        }
        Result result = (Result) objPerformPreflightCheck;
        boolean z = result instanceof Result.Success;
        if (z) {
            this.userSessionInfo.updatePreflightFolderSuccess(remote3);
        } else if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) result).getValue(), null, 2, null));
    }

    public final boolean isUploadRisky(File fileToUpload, ItemId.Remote parentFolderId) {
        Intrinsics.checkNotNullParameter(fileToUpload, "fileToUpload");
        Intrinsics.checkNotNullParameter(parentFolderId, "parentFolderId");
        if (fileToUpload.length() < 200000 && this.userSessionInfo.isFolderSuccessfulPreviously(parentFolderId)) {
            String name = fileToUpload.getName();
            Intrinsics.checkNotNull(name);
            String str = name;
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "\\", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "/", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ Object createUploadSession$default(UploadFileService uploadFileService, String str, long j, ItemId.Remote remote, ItemId.Remote remote2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            remote2 = null;
        }
        return uploadFileService.createUploadSession(str, j, remote, remote2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        if (r11 == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009b, code lost:
    
        if (r11 == r1) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createUploadSession(java.lang.String r6, long r7, com.box.android.domain.models.ItemId.Remote r9, com.box.android.domain.models.ItemId.Remote r10, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.data.api.models.upload.UploadSessionDTO, ? extends com.box.android.domain.models.DomainError>> r11) {
        /*
            r5 = this;
            boolean r0 = r11 instanceof com.box.android.data.service.impl.UploadFileService.C15311
            if (r0 == 0) goto L14
            r0 = r11
            com.box.android.data.service.impl.UploadFileService$createUploadSession$1 r0 = (com.box.android.data.service.impl.UploadFileService.C15311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.box.android.data.service.impl.UploadFileService$createUploadSession$1 r0 = new com.box.android.data.service.impl.UploadFileService$createUploadSession$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L55
            if (r2 == r3) goto L43
            if (r2 != r4) goto L3b
            long r5 = r0.J$0
            java.lang.Object r5 = r0.L$2
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L9e
        L3b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L43:
            long r5 = r0.J$0
            java.lang.Object r5 = r0.L$2
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7b
        L55:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r10 == 0) goto L7e
            com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource r5 = r5.chunkedFileUploadRemoteDataSource
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r11
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$2 = r9
            r0.J$0 = r7
            r0.label = r3
            r9 = r10
            r10 = r0
            java.lang.Object r11 = r5.createUploadSessionForExistingBoxFile(r6, r7, r9, r10)
            if (r11 != r1) goto L7b
            goto L9d
        L7b:
            com.box.android.domain.utils.result.Result r11 = (com.box.android.domain.utils.result.Result) r11
            goto La0
        L7e:
            com.box.android.data.datasource.files.ChunkedFileUploadRemoteDataSource r5 = r5.chunkedFileUploadRemoteDataSource
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r11
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$2 = r10
            r0.J$0 = r7
            r0.label = r4
            r10 = r0
            java.lang.Object r11 = r5.createUploadSession(r6, r7, r9, r10)
            if (r11 != r1) goto L9e
        L9d:
            return r1
        L9e:
            com.box.android.domain.utils.result.Result r11 = (com.box.android.domain.utils.result.Result) r11
        La0:
            boolean r5 = r11 instanceof com.box.android.domain.utils.result.Result.Success
            if (r5 == 0) goto La5
            return r11
        La5:
            boolean r5 = r11 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto Lc2
            com.box.android.domain.utils.result.Result$Error r11 = (com.box.android.domain.utils.result.Result.Error) r11
            java.lang.Object r5 = r11.getValue()
            com.box.android.data.datasource.errors.RemoteError r5 = (com.box.android.data.datasource.errors.RemoteError) r5
            com.box.android.data.service.impl.DomainErrorMapper r6 = com.box.android.data.service.impl.DomainErrorMapper.INSTANCE
            com.box.android.domain.models.IGenericError r5 = (com.box.android.domain.models.IGenericError) r5
            r7 = 0
            com.box.android.domain.models.DomainError r5 = com.box.android.data.service.impl.DomainErrorMapper.toDomainError$default(r6, r5, r7, r4, r7)
            com.box.android.domain.utils.result.Result$Error r6 = new com.box.android.domain.utils.result.Result$Error
            r6.<init>(r5)
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            return r6
        Lc2:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.UploadFileService.createUploadSession(java.lang.String, long, com.box.android.domain.models.ItemId$Remote, com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object uploadChunk(String str, String str2, String str3, byte[] bArr, Continuation<? super ResultProgressWrapper<UploadFileChunkDTO, DomainError, Progress>> continuation) {
        C15331 c15331;
        if (continuation instanceof C15331) {
            c15331 = (C15331) continuation;
            if ((c15331.label & Integer.MIN_VALUE) != 0) {
                c15331.label -= Integer.MIN_VALUE;
            } else {
                c15331 = new C15331(continuation);
            }
        } else {
            c15331 = new C15331(continuation);
        }
        C15331 c15332 = c15331;
        Object objUploadChunk = c15332.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15332.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUploadChunk);
            ChunkedFileUploadRemoteDataSource chunkedFileUploadRemoteDataSource = this.chunkedFileUploadRemoteDataSource;
            c15332.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c15332.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c15332.L$2 = SpillingKt.nullOutSpilledVariable(str3);
            c15332.L$3 = SpillingKt.nullOutSpilledVariable(bArr);
            c15332.label = 1;
            objUploadChunk = chunkedFileUploadRemoteDataSource.uploadChunk(str, str2, str3, bArr, c15332);
            if (objUploadChunk == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUploadChunk);
        }
        ResultProgressWrapper resultProgressWrapper = (ResultProgressWrapper) objUploadChunk;
        final Flow result = resultProgressWrapper.getResult();
        return new ResultProgressWrapper(resultProgressWrapper.getProgress(), new Flow<Result<? extends UploadFileChunkDTO, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.UploadFileService$uploadChunk$$inlined$mapNotNull$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends UploadFileChunkDTO, ? extends DomainError>> flowCollector, Continuation continuation2) {
                Object objCollect = result.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileService$uploadChunk$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileService$uploadChunk$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileService$uploadChunk$$inlined$mapNotNull$1$2", f = "UploadFileService.kt", i = {0, 0, 0, 0, 0, 0}, l = {58}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        Result.Error error = (Result) obj;
                        Result result = null;
                        if (error != null) {
                            if (!(error instanceof Result.Success)) {
                                if (!(error instanceof Result.Error)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
                            }
                            result = error;
                        }
                        if (result != null) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(result);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(result, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:34:0x014b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009e, code lost:
    
        if (r1 == r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0144, code lost:
    
        if (r6.getFileInfoAndSaveInBoxCache(r7, r2) == r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0146, code lost:
    
        return r3;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0144 -> B:33:0x0147). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object commitUploadSession(java.lang.String r19, java.lang.String r20, java.util.List<com.box.android.data.api.models.upload.UploadFileChunkDTO> r21, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.data.api.models.items.ItemsDTO, ? extends com.box.android.domain.models.DomainError>> r22) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.UploadFileService.commitUploadSession(java.lang.String, java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ResultProgressWrapper<FileModel, DomainError, Progress> handleUploadSuccess(final File file, ResultProgressWrapper<ItemsDTO, RemoteError, Progress> progressWrapper) {
        Flow<Progress> progress = progressWrapper.getProgress();
        final Flow<Result<ItemsDTO, RemoteError>> result = progressWrapper.getResult();
        return new ResultProgressWrapper<>(progress, FlowKt.m16356catch(new Flow<Result<? extends FileModel, ? extends DomainError>>() { // from class: com.box.android.data.service.impl.UploadFileService$handleUploadSuccess$$inlined$mapNotNull$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Result<? extends FileModel, ? extends DomainError>> flowCollector, Continuation continuation) {
                Object objCollect = result.collect(new AnonymousClass2(flowCollector, this, file), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileService$handleUploadSuccess$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ File $file$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ UploadFileService this$0;

                /* JADX INFO: renamed from: com.box.android.data.service.impl.UploadFileService$handleUploadSuccess$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.service.impl.UploadFileService$handleUploadSuccess$$inlined$mapNotNull$1$2", f = "UploadFileService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {56, 80, 83}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "$completion", "uploadResult", "$this$onSuccess$iv", "it", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1", "$i$a$-mapNotNull-UploadFileService$handleUploadSuccess$mappedResultFlow$1", "$i$f$onSuccess", "$i$a$-onSuccess-UploadFileService$handleUploadSuccess$mappedResultFlow$1$2", "value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "$completion", "uploadResult", "$this$flatMapError$iv", "it", "sha1", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1", "$i$a$-mapNotNull-UploadFileService$handleUploadSuccess$mappedResultFlow$1", "$i$f$flatMapError", "$i$a$-flatMapError-UploadFileService$handleUploadSuccess$mappedResultFlow$1$4", "value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    int I$1;
                    int I$2;
                    int I$3;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, UploadFileService uploadFileService, File file) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = uploadFileService;
                    this.$file$inlined = file;
                }

                /* JADX WARN: Code duplicated, block: B:38:0x014f  */
                /* JADX WARN: Code duplicated, block: B:41:0x0154  */
                /* JADX WARN: Code duplicated, block: B:43:0x0158  */
                /* JADX WARN: Code duplicated, block: B:47:0x0176  */
                /* JADX WARN: Code duplicated, block: B:49:0x017a  */
                /* JADX WARN: Code duplicated, block: B:52:0x01d4  */
                /* JADX WARN: Code duplicated, block: B:54:0x01e0  */
                /* JADX WARN: Code duplicated, block: B:56:0x01e6  */
                /* JADX WARN: Code duplicated, block: B:58:0x01ec  */
                /* JADX WARN: Code duplicated, block: B:65:0x0202 A[DONT_INVERT, PHI: r4 r5 r6 r10 r14 r15
                  0x0202: PHI (r4v10 kotlinx.coroutines.flow.FlowCollector) = 
                  (r4v7 kotlinx.coroutines.flow.FlowCollector)
                  (r4v8 kotlinx.coroutines.flow.FlowCollector)
                  (r4v11 kotlinx.coroutines.flow.FlowCollector)
                 binds: [B:64:0x01ff, B:45:0x0172, B:53:0x01d8] A[DONT_GENERATE, DONT_INLINE]
                  0x0202: PHI (r5v9 java.lang.Object) = (r5v6 java.lang.Object), (r5v7 java.lang.Object), (r5v10 java.lang.Object) binds: [B:64:0x01ff, B:45:0x0172, B:53:0x01d8] A[DONT_GENERATE, DONT_INLINE]
                  0x0202: PHI (r6v7 int) = (r6v3 int), (r6v4 int), (r6v9 int) binds: [B:64:0x01ff, B:45:0x0172, B:53:0x01d8] A[DONT_GENERATE, DONT_INLINE]
                  0x0202: PHI (r10v14 com.box.android.domain.utils.result.Result) = 
                  (r10v3 com.box.android.domain.utils.result.Result)
                  (r10v5 com.box.android.domain.utils.result.Result)
                  (r10v16 com.box.android.domain.utils.result.Result)
                 binds: [B:64:0x01ff, B:45:0x0172, B:53:0x01d8] A[DONT_GENERATE, DONT_INLINE]
                  0x0202: PHI (r14v11 java.lang.Object) = (r14v8 java.lang.Object), (r14v9 java.lang.Object), (r14v12 java.lang.Object) binds: [B:64:0x01ff, B:45:0x0172, B:53:0x01d8] A[DONT_GENERATE, DONT_INLINE]
                  0x0202: PHI (r15v6 com.box.android.data.service.impl.UploadFileService$handleUploadSuccess$$inlined$mapNotNull$1$2$1) = 
                  (r15v3 com.box.android.data.service.impl.UploadFileService$handleUploadSuccess$$inlined$mapNotNull$1$2$1)
                  (r15v4 com.box.android.data.service.impl.UploadFileService$handleUploadSuccess$$inlined$mapNotNull$1$2$1)
                  (r15v7 com.box.android.data.service.impl.UploadFileService$handleUploadSuccess$$inlined$mapNotNull$1$2$1)
                 binds: [B:64:0x01ff, B:45:0x0172, B:53:0x01d8] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Code duplicated, block: B:66:0x0204  */
                /* JADX WARN: Code duplicated, block: B:7:0x0018  */
                /* JADX WARN: Code restructure failed: missing block: B:67:0x0234, code lost:
                
                    if (r4.emit(r10, r2) == r3) goto L68;
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r17, kotlin.coroutines.Continuation r18) {
                    /*
                        Method dump skipped, instruction units count: 570
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.UploadFileService$handleUploadSuccess$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, new UploadFileService$handleUploadSuccess$mappedResultFlow$2(null)));
    }
}
