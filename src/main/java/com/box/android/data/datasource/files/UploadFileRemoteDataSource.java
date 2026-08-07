package com.box.android.data.datasource.files;

import com.box.android.common.extensions.DateExtensionsKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.api.interceptors.UploadProgressRequestBody;
import com.box.android.data.api.models.items.ItemsDTO;
import com.box.android.data.api.models.items.mini.FolderIdDTO;
import com.box.android.data.api.models.upload.UploadAttributesDTO;
import com.box.android.data.api.requests.PreflightCheckRequest;
import com.box.android.data.api.requests.UploadFileRequest;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.errors.UploadErrorUtil;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.IUploadFileService;
import com.box.android.domain.utils.Progress;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: UploadFileRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00012B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ>\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0086@¢\u0006\u0002\u0010\u001dJH\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"JJ\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001bH\u0086@¢\u0006\u0002\u0010(J\"\u0010)\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00172\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010,H\u0002J \u0010-\u001a\u00020.2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010/\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u00100\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00172\f\u00101\u001a\b\u0012\u0004\u0012\u00020 0,H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u00063"}, d2 = {"Lcom/box/android/data/datasource/files/UploadFileRemoteDataSource;", "", "uploadFileRequest", "Lcom/box/android/data/api/requests/UploadFileRequest;", "preflightCheckRequest", "Lcom/box/android/data/api/requests/PreflightCheckRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/UploadFileRequest;Lcom/box/android/data/api/requests/PreflightCheckRequest;Lcom/squareup/moshi/Moshi;)V", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getCoroutineDispatcher$annotations", "()V", "getCoroutineDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "setCoroutineDispatcher", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "uploadFile", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/items/ItemsDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "fileToUpload", "Ljava/io/File;", BoxCommonConstants.EXTRA_FILE_NAME, "", "parentFolderId", "Lcom/box/android/domain/models/ItemId$Remote;", "accessToken", "(Ljava/io/File;Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFileWithProgress", "Lcom/box/android/domain/utils/result/ResultProgressWrapper;", "Lcom/box/android/domain/utils/Progress;", "newFileVersionUpload", "Lcom/box/android/domain/services/IUploadFileService$NewFileVersionUpload;", "performPreflightCheck", "", "fileSize", "", "fileId", "(Ljava/lang/String;JLcom/box/android/domain/models/ItemId$Remote;Ljava/lang/String;Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createMultiPartBodyFromFile", "Lokhttp3/MultipartBody$Part;", "progressCallback", "Lkotlinx/coroutines/flow/MutableStateFlow;", "createAttributesRequestBody", "Lokhttp3/RequestBody;", "createMultipartBodyFromFile", "createProgressMultipartBodyFromFile", "progressFlow", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadFileRemoteDataSource {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String FIELD_FILE = "file";
    private CoroutineDispatcher coroutineDispatcher;
    private final Moshi moshi;
    private final PreflightCheckRequest preflightCheckRequest;
    private final UploadFileRequest uploadFileRequest;

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.UploadFileRemoteDataSource$performPreflightCheck$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadFileRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.UploadFileRemoteDataSource", f = "UploadFileRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {Token.SET, Token.LET}, m = "performPreflightCheck", n = {BoxCommonConstants.EXTRA_FILE_NAME, "parentFolderId", "accessToken", "fileId", "requestBody", "bearerToken", "it", "fileSize", "$i$f$resultOf", "$i$a$-resultOf-UploadFileRemoteDataSource$performPreflightCheck$2", "$i$a$-let-UploadFileRemoteDataSource$performPreflightCheck$2$1", BoxCommonConstants.EXTRA_FILE_NAME, "parentFolderId", "accessToken", "fileId", "requestBody", "bearerToken", "fileSize", "$i$f$resultOf", "$i$a$-resultOf-UploadFileRemoteDataSource$performPreflightCheck$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileRemoteDataSource.this.performPreflightCheck(null, 0L, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.files.UploadFileRemoteDataSource$uploadFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UploadFileRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.files.UploadFileRemoteDataSource", f = "UploadFileRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {72}, m = "uploadFile", n = {"fileToUpload", BoxCommonConstants.EXTRA_FILE_NAME, "parentFolderId", "accessToken", "uploadAttributesRequestBody", "fileToUploadMultipartBody", "bearerToken", "$i$f$resultOf", "$i$a$-resultOf-UploadFileRemoteDataSource$uploadFile$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C11511 extends ContinuationImpl {
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

        C11511(Continuation<? super C11511> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UploadFileRemoteDataSource.this.uploadFile(null, null, null, null, this);
        }
    }

    public static /* synthetic */ void getCoroutineDispatcher$annotations() {
    }

    @Inject
    public UploadFileRemoteDataSource(UploadFileRequest uploadFileRequest, PreflightCheckRequest preflightCheckRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(uploadFileRequest, "uploadFileRequest");
        Intrinsics.checkNotNullParameter(preflightCheckRequest, "preflightCheckRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.uploadFileRequest = uploadFileRequest;
        this.preflightCheckRequest = preflightCheckRequest;
        this.moshi = moshi;
        this.coroutineDispatcher = Dispatchers.getIO();
    }

    /* JADX INFO: compiled from: UploadFileRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/files/UploadFileRemoteDataSource$Companion;", "", "<init>", "()V", "FIELD_FILE", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final CoroutineDispatcher getCoroutineDispatcher() {
        return this.coroutineDispatcher;
    }

    public final void setCoroutineDispatcher(CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "<set-?>");
        this.coroutineDispatcher = coroutineDispatcher;
    }

    public static /* synthetic */ Object uploadFile$default(UploadFileRemoteDataSource uploadFileRemoteDataSource, File file, String str, ItemId.Remote remote, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return uploadFileRemoteDataSource.uploadFile(file, str, remote, str2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object uploadFile(File file, String str, ItemId.Remote remote, String str2, Continuation<? super Result<ItemsDTO, ? extends RemoteError>> continuation) {
        C11511 c11511;
        Result.Error error;
        if (continuation instanceof C11511) {
            c11511 = (C11511) continuation;
            if ((c11511.label & Integer.MIN_VALUE) != 0) {
                c11511.label -= Integer.MIN_VALUE;
            } else {
                c11511 = new C11511(continuation);
            }
        } else {
            c11511 = new C11511(continuation);
        }
        C11511 c11512 = c11511;
        Object objUploadFile$default = c11512.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11512.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUploadFile$default);
                RequestBody requestBodyCreateAttributesRequestBody = createAttributesRequestBody(file, str, remote);
                MultipartBody.Part partCreateMultiPartBodyFromFile$default = createMultiPartBodyFromFile$default(this, file, null, 2, null);
                String str3 = str2 != null ? "Bearer " + str2 : null;
                UploadFileRequest uploadFileRequest = this.uploadFileRequest;
                c11512.L$0 = SpillingKt.nullOutSpilledVariable(file);
                c11512.L$1 = SpillingKt.nullOutSpilledVariable(str);
                c11512.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                c11512.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                c11512.L$4 = SpillingKt.nullOutSpilledVariable(requestBodyCreateAttributesRequestBody);
                c11512.L$5 = SpillingKt.nullOutSpilledVariable(partCreateMultiPartBodyFromFile$default);
                c11512.L$6 = SpillingKt.nullOutSpilledVariable(str3);
                c11512.I$0 = 0;
                c11512.I$1 = 0;
                c11512.label = 1;
                objUploadFile$default = UploadFileRequest.uploadFile$default(uploadFileRequest, str3, requestBodyCreateAttributesRequestBody, partCreateMultiPartBodyFromFile$default, null, c11512, 8, null);
                if (objUploadFile$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11512.I$1;
                int i3 = c11512.I$0;
                ResultKt.throwOnFailure(objUploadFile$default);
            }
            error = new Result.Success((ItemsDTO) objUploadFile$default);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(UploadErrorUtil.INSTANCE.getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    public static /* synthetic */ ResultProgressWrapper uploadFileWithProgress$default(UploadFileRemoteDataSource uploadFileRemoteDataSource, File file, String str, ItemId.Remote remote, String str2, IUploadFileService.NewFileVersionUpload newFileVersionUpload, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            newFileVersionUpload = null;
        }
        return uploadFileRemoteDataSource.uploadFileWithProgress(file, str, remote, str2, newFileVersionUpload);
    }

    public final ResultProgressWrapper<ItemsDTO, RemoteError, Progress> uploadFileWithProgress(File fileToUpload, String fileName, ItemId.Remote parentFolderId, String accessToken, IUploadFileService.NewFileVersionUpload newFileVersionUpload) {
        Intrinsics.checkNotNullParameter(fileToUpload, "fileToUpload");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(parentFolderId, "parentFolderId");
        MutableStateFlow<Progress> MutableStateFlow = StateFlowKt.MutableStateFlow(new Progress(0L, 1L));
        RequestBody requestBodyCreateAttributesRequestBody = createAttributesRequestBody(fileToUpload, fileName, parentFolderId);
        MultipartBody.Part partCreateMultiPartBodyFromFile = createMultiPartBodyFromFile(fileToUpload, MutableStateFlow);
        String str = accessToken != null ? "Bearer " + accessToken : null;
        MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        ResultProgressWrapper<ItemsDTO, RemoteError, Progress> resultProgressWrapper = new ResultProgressWrapper<>(MutableStateFlow, MutableStateFlow2);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), null, null, new UploadFileRemoteDataSource$uploadFileWithProgress$1$1(MutableStateFlow2, newFileVersionUpload, this, str, requestBodyCreateAttributesRequestBody, partCreateMultiPartBodyFromFile, null), 3, null);
        return resultProgressWrapper;
    }

    public static /* synthetic */ Object performPreflightCheck$default(UploadFileRemoteDataSource uploadFileRemoteDataSource, String str, long j, ItemId.Remote remote, String str2, ItemId.Remote remote2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            remote2 = null;
        }
        return uploadFileRemoteDataSource.performPreflightCheck(str, j, remote, str2, remote2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x012a  */
    /* JADX WARN: Code duplicated, block: B:40:0x012e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0147  */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0111, code lost:
    
        if (r3.performPreflightCheck(r2, r14, r0) == r1) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object performPreflightCheck(java.lang.String r8, long r9, com.box.android.domain.models.ItemId.Remote r11, java.lang.String r12, com.box.android.domain.models.ItemId.Remote r13, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.data.datasource.errors.RemoteError>> r14) {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.files.UploadFileRemoteDataSource.performPreflightCheck(java.lang.String, long, com.box.android.domain.models.ItemId$Remote, java.lang.String, com.box.android.domain.models.ItemId$Remote, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ MultipartBody.Part createMultiPartBodyFromFile$default(UploadFileRemoteDataSource uploadFileRemoteDataSource, File file, MutableStateFlow mutableStateFlow, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableStateFlow = null;
        }
        return uploadFileRemoteDataSource.createMultiPartBodyFromFile(file, mutableStateFlow);
    }

    private final MultipartBody.Part createMultiPartBodyFromFile(File fileToUpload, MutableStateFlow<Progress> progressCallback) {
        MultipartBody.Part partCreateProgressMultipartBodyFromFile;
        return (progressCallback == null || (partCreateProgressMultipartBodyFromFile = createProgressMultipartBodyFromFile(fileToUpload, progressCallback)) == null) ? createMultipartBodyFromFile(fileToUpload) : partCreateProgressMultipartBodyFromFile;
    }

    private final RequestBody createAttributesRequestBody(File fileToUpload, String fileName, ItemId.Remote parentFolderId) {
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(UploadAttributesDTO.class);
        String rfc3339 = DateExtensionsKt.toRfc3339(new Date(fileToUpload.lastModified()));
        UploadAttributesDTO uploadAttributesDTO = new UploadAttributesDTO(rfc3339, rfc3339, fileName, new FolderIdDTO(parentFolderId.getBoxId(), null, 2, null));
        RequestBody.Companion companion = RequestBody.INSTANCE;
        String json = jsonAdapterAdapter.toJson(uploadAttributesDTO);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return companion.create(json, MediaType.INSTANCE.get("application/json"));
    }

    private final MultipartBody.Part createMultipartBodyFromFile(File fileToUpload) {
        return MultipartBody.Part.INSTANCE.createFormData("file", fileToUpload.getName(), RequestBody.INSTANCE.create(fileToUpload, MediaType.INSTANCE.get("application/octet-stream")));
    }

    private final MultipartBody.Part createProgressMultipartBodyFromFile(File fileToUpload, MutableStateFlow<Progress> progressFlow) {
        return MultipartBody.Part.INSTANCE.createFormData("file", fileToUpload.getName(), UploadProgressRequestBody.INSTANCE.asProgressRequestBody(fileToUpload, MediaType.INSTANCE.get("application/octet-stream"), progressFlow));
    }
}
