package com.box.android.data.datasource.files;

import com.box.android.data.api.models.items.ItemsDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.services.IUploadFileService;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: UploadFileRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.files.UploadFileRemoteDataSource$uploadFileWithProgress$1$1", f = "UploadFileRemoteDataSource.kt", i = {0, 0, 0, 0, 1, 1, 2}, l = {110, 117, 123}, m = "invokeSuspend", n = {"it", "$i$f$resultOf", "$i$a$-resultOf-UploadFileRemoteDataSource$uploadFileWithProgress$1$1$result$1", "$i$a$-let-UploadFileRemoteDataSource$uploadFileWithProgress$1$1$result$1$1", "$i$f$resultOf", "$i$a$-resultOf-UploadFileRemoteDataSource$uploadFileWithProgress$1$1$result$1", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$4", "I$0", "I$1", "I$2", "I$0", "I$1", "L$0"}, v = 1)
final class UploadFileRemoteDataSource$uploadFileWithProgress$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bearerToken;
    final /* synthetic */ MultipartBody.Part $fileToUploadMultipartBody;
    final /* synthetic */ IUploadFileService.NewFileVersionUpload $newFileVersionUpload;
    final /* synthetic */ MutableStateFlow<Result<ItemsDTO, RemoteError>> $resultFlow;
    final /* synthetic */ RequestBody $uploadAttributesRequestBody;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ UploadFileRemoteDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UploadFileRemoteDataSource$uploadFileWithProgress$1$1(MutableStateFlow<Result<ItemsDTO, RemoteError>> mutableStateFlow, IUploadFileService.NewFileVersionUpload newFileVersionUpload, UploadFileRemoteDataSource uploadFileRemoteDataSource, String str, RequestBody requestBody, MultipartBody.Part part, Continuation<? super UploadFileRemoteDataSource$uploadFileWithProgress$1$1> continuation) {
        super(2, continuation);
        this.$resultFlow = mutableStateFlow;
        this.$newFileVersionUpload = newFileVersionUpload;
        this.this$0 = uploadFileRemoteDataSource;
        this.$bearerToken = str;
        this.$uploadAttributesRequestBody = requestBody;
        this.$fileToUploadMultipartBody = part;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadFileRemoteDataSource$uploadFileWithProgress$1$1(this.$resultFlow, this.$newFileVersionUpload, this.this$0, this.$bearerToken, this.$uploadAttributesRequestBody, this.$fileToUploadMultipartBody, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UploadFileRemoteDataSource$uploadFileWithProgress$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d5 A[Catch: Exception -> 0x004c, PHI: r0 r5
      0x00d5: PHI (r0v24 java.lang.Object) = (r0v18 java.lang.Object), (r0v28 java.lang.Object) binds: [B:36:0x00d2, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x00d5: PHI (r5v10 com.box.android.data.datasource.files.UploadFileRemoteDataSource$uploadFileWithProgress$1$1) = 
      (r5v7 com.box.android.data.datasource.files.UploadFileRemoteDataSource$uploadFileWithProgress$1$1)
      (r5v0 com.box.android.data.datasource.files.UploadFileRemoteDataSource$uploadFileWithProgress$1$1)
     binds: [B:36:0x00d2, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {Exception -> 0x004c, blocks: (B:10:0x0025, B:38:0x00d5, B:39:0x00d7, B:13:0x0044, B:35:0x00ce), top: B:59:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:55:0x012b  */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0125, code lost:
    
        if (r5.$resultFlow.emit(r1, r5) == r10) goto L52;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.files.UploadFileRemoteDataSource$uploadFileWithProgress$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
