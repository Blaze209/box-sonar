package com.box.android.data.service.impl;

import android.net.Uri;
import com.box.android.data.api.models.JWTAuthInfo;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.ItemsDTO;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.auth.AuthenticationRemoteDataSource;
import com.box.android.data.datasource.clientsettings.ClientSettingsRemoteDataSource;
import com.box.android.data.datasource.errors.ItemsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.files.UploadFileRemoteDataSource;
import com.box.android.data.datasource.observability.LogsCacheDataSource;
import com.box.android.domain.models.AuthenticationInfoModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.ItemIdKt;
import com.box.android.domain.services.IAuthenticationCredentialsProvider;
import com.box.android.domain.services.IAuthenticationService;
import com.box.android.domain.services.IObservabilityService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ObservabilityService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0080@¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001b0\u0013H\u0096@¢\u0006\u0002\u0010\u001cJ.\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001b0\u00132\b\b\u0001\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u0004\u0018\u00010%H\u0096@¢\u0006\u0002\u0010\u001cJ\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020%H\u0096@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020 H\u0016J<\u0010+\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001b0\u00132\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096@¢\u0006\u0002\u0010/J\b\u00100\u001a\u000201H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/box/android/data/service/impl/ObservabilityService;", "Lcom/box/android/domain/services/IObservabilityService;", "authenticationService", "Lcom/box/android/domain/services/IAuthenticationService;", "authenticationRemoteDataSource", "Lcom/box/android/data/datasource/auth/AuthenticationRemoteDataSource;", "clientSettingsRemoteDataSource", "Lcom/box/android/data/datasource/clientsettings/ClientSettingsRemoteDataSource;", "uploadFileRemoteDataSource", "Lcom/box/android/data/datasource/files/UploadFileRemoteDataSource;", "authenticationCredentialsProvider", "Lcom/box/android/domain/services/IAuthenticationCredentialsProvider;", "logsCacheDataSource", "Lcom/box/android/data/datasource/observability/LogsCacheDataSource;", "sessionManager", "Lcom/box/android/data/service/impl/SessionManager;", "<init>", "(Lcom/box/android/domain/services/IAuthenticationService;Lcom/box/android/data/datasource/auth/AuthenticationRemoteDataSource;Lcom/box/android/data/datasource/clientsettings/ClientSettingsRemoteDataSource;Lcom/box/android/data/datasource/files/UploadFileRemoteDataSource;Lcom/box/android/domain/services/IAuthenticationCredentialsProvider;Lcom/box/android/data/datasource/observability/LogsCacheDataSource;Lcom/box/android/data/service/impl/SessionManager;)V", "getJwtAuthInfo", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/JWTAuthInfo;", "Lcom/box/android/data/datasource/errors/RemoteError;", "authInfoModel", "Lcom/box/android/domain/models/AuthenticationInfoModel;", "getJwtAuthInfo$data_generalProdRelease", "(Lcom/box/android/domain/models/AuthenticationInfoModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticate", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLogArchiveFile", "Landroid/net/Uri;", "fileProviderAuthorityId", "", "logTag", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogArchiveFileToUpload", "Ljava/io/File;", "deleteLogArchiveFile", "", "logArchiveFileToDelete", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLogArchiveFileCount", "uploadLogArchiveFile", "logArchiveFileToUpload", "destinationFolderRemoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "(Ljava/io/File;Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/models/AuthenticationInfoModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "Lcom/box/android/data/api/models/UserMiniDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ObservabilityService implements IObservabilityService {
    private final IAuthenticationCredentialsProvider authenticationCredentialsProvider;
    private final AuthenticationRemoteDataSource authenticationRemoteDataSource;
    private final IAuthenticationService authenticationService;
    private final ClientSettingsRemoteDataSource clientSettingsRemoteDataSource;
    private final LogsCacheDataSource logsCacheDataSource;
    private final SessionManager sessionManager;
    private final UploadFileRemoteDataSource uploadFileRemoteDataSource;

    @Inject
    public ObservabilityService(IAuthenticationService authenticationService, AuthenticationRemoteDataSource authenticationRemoteDataSource, ClientSettingsRemoteDataSource clientSettingsRemoteDataSource, UploadFileRemoteDataSource uploadFileRemoteDataSource, IAuthenticationCredentialsProvider authenticationCredentialsProvider, LogsCacheDataSource logsCacheDataSource, SessionManager sessionManager) {
        Intrinsics.checkNotNullParameter(authenticationService, "authenticationService");
        Intrinsics.checkNotNullParameter(authenticationRemoteDataSource, "authenticationRemoteDataSource");
        Intrinsics.checkNotNullParameter(clientSettingsRemoteDataSource, "clientSettingsRemoteDataSource");
        Intrinsics.checkNotNullParameter(uploadFileRemoteDataSource, "uploadFileRemoteDataSource");
        Intrinsics.checkNotNullParameter(authenticationCredentialsProvider, "authenticationCredentialsProvider");
        Intrinsics.checkNotNullParameter(logsCacheDataSource, "logsCacheDataSource");
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        this.authenticationService = authenticationService;
        this.authenticationRemoteDataSource = authenticationRemoteDataSource;
        this.clientSettingsRemoteDataSource = clientSettingsRemoteDataSource;
        this.uploadFileRemoteDataSource = uploadFileRemoteDataSource;
        this.authenticationCredentialsProvider = authenticationCredentialsProvider;
        this.logsCacheDataSource = logsCacheDataSource;
        this.sessionManager = sessionManager;
    }

    public final Object getJwtAuthInfo$data_generalProdRelease(AuthenticationInfoModel authenticationInfoModel, Continuation<? super Result<JWTAuthInfo, ? extends RemoteError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ObservabilityService$getJwtAuthInfo$2(this, authenticationInfoModel, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ObservabilityService$authenticate$2, reason: invalid class name */
    /* JADX INFO: compiled from: ObservabilityService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/AuthenticationInfoModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ObservabilityService$authenticate$2", f = "ObservabilityService.kt", i = {1, 1, 1, 1, 2, 2, 2, 2}, l = {47, 48, 59}, m = "invokeSuspend", n = {"$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-ObservabilityService$authenticate$2$1", "$this$flatMap$iv", "jwtAssertion", "$i$f$flatMap", "$i$a$-flatMap-ObservabilityService$authenticate$2$3"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends AuthenticationInfoModel, ? extends DomainError>>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ObservabilityService.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends AuthenticationInfoModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<AuthenticationInfoModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<AuthenticationInfoModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x0084  */
        /* JADX WARN: Code duplicated, block: B:27:0x008e  */
        /* JADX WARN: Code duplicated, block: B:28:0x0097  */
        /* JADX WARN: Code duplicated, block: B:29:0x00a6  */
        /* JADX WARN: Code duplicated, block: B:33:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:37:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:41:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:42:0x0109  */
        /* JADX WARN: Code duplicated, block: B:46:0x0111 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:47:0x0112  */
        /* JADX WARN: Code duplicated, block: B:49:0x0116  */
        /* JADX WARN: Code duplicated, block: B:51:0x0122  */
        /* JADX WARN: Code duplicated, block: B:52:0x0129  */
        /* JADX WARN: Code duplicated, block: B:55:0x0133  */
        /* JADX WARN: Code duplicated, block: B:57:0x0139  */
        /* JADX WARN: Code duplicated, block: B:59:0x013f  */
        /* JADX WARN: Code duplicated, block: B:61:0x0145  */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
        
            if (r7 == r0) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00d7, code lost:
        
            if (r7 == r0) goto L35;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instruction units count: 337
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.ObservabilityService.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.services.IObservabilityService
    public Object authenticate(Continuation<? super Result<AuthenticationInfoModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ObservabilityService$createLogArchiveFile$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObservabilityService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Landroid/net/Uri;", "Lcom/box/android/domain/models/DomainError$InputValidationError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ObservabilityService$createLogArchiveFile$2", f = "ObservabilityService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C14712 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Uri, ? extends DomainError.InputValidationError>>, Object> {
        final /* synthetic */ int $fileProviderAuthorityId;
        final /* synthetic */ String $logTag;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14712(int i, String str, Continuation<? super C14712> continuation) {
            super(2, continuation);
            this.$fileProviderAuthorityId = i;
            this.$logTag = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C14712 c14712 = ObservabilityService.this.new C14712(this.$fileProviderAuthorityId, this.$logTag, continuation);
            c14712.L$0 = obj;
            return c14712;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Uri, ? extends DomainError.InputValidationError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<? extends Uri, DomainError.InputValidationError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<? extends Uri, DomainError.InputValidationError>> continuation) {
            return ((C14712) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Result<Uri, CacheError> resultCreateLogArchiveFile = ObservabilityService.this.logsCacheDataSource.createLogArchiveFile(this.$fileProviderAuthorityId, this.$logTag);
                if (resultCreateLogArchiveFile instanceof Result.Success) {
                    return resultCreateLogArchiveFile;
                }
                if (resultCreateLogArchiveFile instanceof Result.Error) {
                    BoxLogUtils.w(ExtensionsKt.getTAG(coroutineScope), "No log files found to create zip archive");
                    return new Result.Error(new DomainError.InputValidationError("No log files found"));
                }
                throw new NoWhenBranchMatchedException();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.box.android.domain.services.IObservabilityService
    public Object createLogArchiveFile(int i, String str, Continuation<? super Result<? extends Uri, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C14712(i, str, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ObservabilityService$getLogArchiveFileToUpload$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObservabilityService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ObservabilityService$getLogArchiveFileToUpload$2", f = "ObservabilityService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C14732 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
        int label;

        C14732(Continuation<? super C14732> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ObservabilityService.this.new C14732(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
            return ((C14732) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return ObservabilityService.this.logsCacheDataSource.getLogArchiveFileToUpload();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.box.android.domain.services.IObservabilityService
    public Object getLogArchiveFileToUpload(Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C14732(null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ObservabilityService$deleteLogArchiveFile$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObservabilityService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ObservabilityService$deleteLogArchiveFile$2", f = "ObservabilityService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C14722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $logArchiveFileToDelete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14722(File file, Continuation<? super C14722> continuation) {
            super(2, continuation);
            this.$logArchiveFileToDelete = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ObservabilityService.this.new C14722(this.$logArchiveFileToDelete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C14722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ObservabilityService.this.logsCacheDataSource.deleteLogArchiveAndMetadataFile(this.$logArchiveFileToDelete);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.box.android.domain.services.IObservabilityService
    public Object deleteLogArchiveFile(File file, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C14722(file, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.box.android.domain.services.IObservabilityService
    public int getLogArchiveFileCount() {
        return this.logsCacheDataSource.getLogArchiveFileCount();
    }

    @Override // com.box.android.domain.services.IObservabilityService
    public Object uploadLogArchiveFile(File file, ItemId.Remote remote, AuthenticationInfoModel authenticationInfoModel, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        if (ItemIdKt.isNotFolder(remote)) {
            BoxLogUtils.i(ExtensionsKt.getTAG(this), "Destination of log file upload must be a Folder");
            return new Result.Error(new DomainError.InputValidationError("Required ItemId.RemoteId of Folder type"));
        }
        return BuildersKt.withContext(Dispatchers.getIO(), new C14742(file, remote, authenticationInfoModel, str, null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ObservabilityService$uploadLogArchiveFile$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObservabilityService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ObservabilityService$uploadLogArchiveFile$2", f = "ObservabilityService.kt", i = {0, 1, 1, 1, 1, 1}, l = {119, Token.DOTDOT}, m = "invokeSuspend", n = {"tag", "tag", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-ObservabilityService$uploadLogArchiveFile$2$4"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C14742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>>, Object> {
        final /* synthetic */ AuthenticationInfoModel $authInfoModel;
        final /* synthetic */ ItemId.Remote $destinationFolderRemoteId;
        final /* synthetic */ File $logArchiveFileToUpload;
        final /* synthetic */ String $logTag;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14742(File file, ItemId.Remote remote, AuthenticationInfoModel authenticationInfoModel, String str, Continuation<? super C14742> continuation) {
            super(2, continuation);
            this.$logArchiveFileToUpload = file;
            this.$destinationFolderRemoteId = remote;
            this.$authInfoModel = authenticationInfoModel;
            this.$logTag = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ObservabilityService.this.new C14742(this.$logArchiveFileToUpload, this.$destinationFolderRemoteId, this.$authInfoModel, this.$logTag, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
            return ((C14742) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:45:0x0149  */
        /* JADX WARN: Code duplicated, block: B:47:0x014d  */
        /* JADX WARN: Code duplicated, block: B:49:0x0159  */
        /* JADX WARN: Code duplicated, block: B:50:0x0164  */
        /* JADX WARN: Code duplicated, block: B:53:0x0170  */
        /* JADX WARN: Code duplicated, block: B:54:0x0180  */
        /* JADX WARN: Code duplicated, block: B:59:0x0189  */
        /* JADX WARN: Code duplicated, block: B:61:0x018d  */
        /* JADX WARN: Code duplicated, block: B:64:0x01a8  */
        /* JADX WARN: Code duplicated, block: B:65:0x01b7  */
        /* JADX WARN: Code duplicated, block: B:68:0x01bd A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:69:0x01be  */
        /* JADX WARN: Code duplicated, block: B:71:0x01c2  */
        /* JADX WARN: Code duplicated, block: B:73:0x01d1  */
        /* JADX WARN: Code duplicated, block: B:75:0x01d7  */
        /* JADX WARN: Code duplicated, block: B:77:0x01dd  */
        /* JADX WARN: Code duplicated, block: B:79:0x01e3  */
        /* JADX WARN: Code duplicated, block: B:81:0x01e9  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String tag;
            Object objUploadFile;
            Result.Success successCreateMetadataFile;
            String str;
            Result.Error error;
            boolean z;
            IGenericError iGenericError;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    String str2 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objUploadFile = obj;
                    tag = str2;
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                successCreateMetadataFile = (Result) obj;
                tag = str;
                if (!(successCreateMetadataFile instanceof Result.Success)) {
                    if (successCreateMetadataFile instanceof Result.Error) {
                        iGenericError = (IGenericError) ((Result.Error) successCreateMetadataFile).getValue();
                        if (iGenericError instanceof ItemsRemoteError.NameConflict) {
                            successCreateMetadataFile = new Result.Success(Unit.INSTANCE);
                        } else {
                            successCreateMetadataFile = new Result.Error(iGenericError);
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if (successCreateMetadataFile instanceof Result.Success) {
                    ((Result.Success) successCreateMetadataFile).getValue();
                    successCreateMetadataFile = new Result.Success(Unit.INSTANCE);
                } else if (!(successCreateMetadataFile instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(successCreateMetadataFile instanceof Result.Success)) {
                    if (successCreateMetadataFile instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    successCreateMetadataFile = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) successCreateMetadataFile).getValue(), null, 2, null));
                }
                z = successCreateMetadataFile instanceof Result.Success;
                if (z) {
                    BoxLogUtils.i(tag, "Successfully uploaded log archive");
                } else if (!(successCreateMetadataFile instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (z) {
                    return successCreateMetadataFile;
                }
                if (successCreateMetadataFile instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                BoxLogUtils.e(tag, "Failed to upload log archive");
                return successCreateMetadataFile;
            }
            ResultKt.throwOnFailure(obj);
            tag = ExtensionsKt.getTAG(ObservabilityService.this);
            BoxLogUtils.i(tag, "Starting upload of Log Archive: " + this.$logArchiveFileToUpload.getName());
            UploadFileRemoteDataSource uploadFileRemoteDataSource = ObservabilityService.this.uploadFileRemoteDataSource;
            File file = this.$logArchiveFileToUpload;
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            this.L$0 = tag;
            this.label = 1;
            objUploadFile = uploadFileRemoteDataSource.uploadFile(file, name, this.$destinationFolderRemoteId, this.$authInfoModel.getAccessToken(), this);
            if (objUploadFile != coroutine_suspended) {
            }
            return coroutine_suspended;
            successCreateMetadataFile = (Result) objUploadFile;
            if (successCreateMetadataFile instanceof Result.Success) {
                successCreateMetadataFile = new Result.Success((IItemDTO) CollectionsKt.first((List) ((ItemsDTO) ((Result.Success) successCreateMetadataFile).getValue()).getEntries()));
            } else if (!(successCreateMetadataFile instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(successCreateMetadataFile instanceof Result.Success)) {
                if (successCreateMetadataFile instanceof Result.Error) {
                    RemoteError remoteError = (RemoteError) ((Result.Error) successCreateMetadataFile).getValue();
                    if (remoteError instanceof ItemsRemoteError.NameConflict) {
                        error = new Result.Success(CollectionsKt.first((List) ((ItemsRemoteError.NameConflict) remoteError).getItemDTOs()));
                    } else {
                        error = new Result.Error(remoteError);
                    }
                    successCreateMetadataFile = error;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            ObservabilityService observabilityService = ObservabilityService.this;
            String str3 = this.$logTag;
            if (successCreateMetadataFile instanceof Result.Success) {
                IItemDTO iItemDTO = (IItemDTO) ((Result.Success) successCreateMetadataFile).getValue();
                LogsCacheDataSource logsCacheDataSource = observabilityService.logsCacheDataSource;
                UserMiniDTO user = observabilityService.getUser();
                Intrinsics.checkNotNull(iItemDTO, "null cannot be cast to non-null type com.box.android.data.api.models.items.FileDTO");
                successCreateMetadataFile = logsCacheDataSource.createMetadataFile(user, (FileDTO) iItemDTO, str3);
            } else if (!(successCreateMetadataFile instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            ObservabilityService observabilityService2 = ObservabilityService.this;
            ItemId.Remote remote = this.$destinationFolderRemoteId;
            AuthenticationInfoModel authenticationInfoModel = this.$authInfoModel;
            if (successCreateMetadataFile instanceof Result.Success) {
                File file2 = (File) ((Result.Success) successCreateMetadataFile).getValue();
                UploadFileRemoteDataSource uploadFileRemoteDataSource2 = observabilityService2.uploadFileRemoteDataSource;
                String name2 = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                String accessToken = authenticationInfoModel.getAccessToken();
                this.L$0 = tag;
                this.L$1 = SpillingKt.nullOutSpilledVariable(successCreateMetadataFile);
                this.L$2 = SpillingKt.nullOutSpilledVariable(file2);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 2;
                Object objUploadFile2 = uploadFileRemoteDataSource2.uploadFile(file2, name2, remote, accessToken, this);
                if (objUploadFile2 != coroutine_suspended) {
                    String str4 = tag;
                    obj = objUploadFile2;
                    str = str4;
                    successCreateMetadataFile = (Result) obj;
                    tag = str;
                }
                return coroutine_suspended;
            }
            if (!(successCreateMetadataFile instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(successCreateMetadataFile instanceof Result.Success)) {
                if (successCreateMetadataFile instanceof Result.Error) {
                    iGenericError = (IGenericError) ((Result.Error) successCreateMetadataFile).getValue();
                    if (iGenericError instanceof ItemsRemoteError.NameConflict) {
                        successCreateMetadataFile = new Result.Success(Unit.INSTANCE);
                    } else {
                        successCreateMetadataFile = new Result.Error(iGenericError);
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            if (successCreateMetadataFile instanceof Result.Success) {
                ((Result.Success) successCreateMetadataFile).getValue();
                successCreateMetadataFile = new Result.Success(Unit.INSTANCE);
            } else if (!(successCreateMetadataFile instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(successCreateMetadataFile instanceof Result.Success)) {
                if (successCreateMetadataFile instanceof Result.Error) {
                    throw new NoWhenBranchMatchedException();
                }
                successCreateMetadataFile = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) successCreateMetadataFile).getValue(), null, 2, null));
            }
            z = successCreateMetadataFile instanceof Result.Success;
            if (z) {
                BoxLogUtils.i(tag, "Successfully uploaded log archive");
            } else if (!(successCreateMetadataFile instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (z) {
                return successCreateMetadataFile;
            }
            if (successCreateMetadataFile instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(tag, "Failed to upload log archive");
            return successCreateMetadataFile;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserMiniDTO getUser() {
        BoxUser boxUser = this.sessionManager.getBoxUser();
        if (boxUser != null) {
            String id = boxUser.getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            return new UserMiniDTO(id, "user", boxUser.getLogin(), boxUser.getUserName());
        }
        return new UserMiniDTO("None", "user", "None", "None");
    }
}
