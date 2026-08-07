package com.box.android.domain.usecases.observability;

import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.constants.AppConstants;
import com.box.android.domain.models.AuthenticationInfoModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.IObservabilityService;
import com.box.android.domain.utils.result.Result;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadLogsInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J4\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/usecases/observability/UploadLogsInteractor;", "Lcom/box/android/domain/usecases/observability/UploadLogsUseCase;", "observabilityService", "Lcom/box/android/domain/services/IObservabilityService;", "authenticationInteractor", "Lcom/box/android/domain/usecases/observability/AuthenticationInteractor;", "<init>", "(Lcom/box/android/domain/services/IObservabilityService;Lcom/box/android/domain/usecases/observability/AuthenticationInteractor;)V", BoxAnalyticsParams.ACTION_UPLOAD_LOGS, "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "logTag", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "areAllLogsNotUploaded", "", "uploadLogArchive", "authenticationInfoModel", "Lcom/box/android/domain/models/AuthenticationInfoModel;", "logArchiveFile", "Ljava/io/File;", "(Lcom/box/android/domain/models/AuthenticationInfoModel;Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadLogsInteractor implements UploadLogsUseCase {
    private final AuthenticationInteractor authenticationInteractor;
    private final IObservabilityService observabilityService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.observability.UploadLogsInteractor$uploadLogs$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadLogsInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.observability.UploadLogsInteractor", f = "UploadLogsInteractor.kt", i = {0, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {24, 27, 28, 29}, m = BoxAnalyticsParams.ACTION_UPLOAD_LOGS, n = {"logTag", "logTag", "logArchiveFile", "logTag", "logArchiveFile", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-UploadLogsInteractor$uploadLogs$2", "logTag", "logArchiveFile", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-UploadLogsInteractor$uploadLogs$3"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
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
            return UploadLogsInteractor.this.uploadLogs(null, this);
        }
    }

    @Inject
    public UploadLogsInteractor(IObservabilityService observabilityService, AuthenticationInteractor authenticationInteractor) {
        Intrinsics.checkNotNullParameter(observabilityService, "observabilityService");
        Intrinsics.checkNotNullParameter(authenticationInteractor, "authenticationInteractor");
        this.observabilityService = observabilityService;
        this.authenticationInteractor = authenticationInteractor;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:45:0x0114  */
    /* JADX WARN: Code duplicated, block: B:48:0x0119  */
    /* JADX WARN: Code duplicated, block: B:50:0x011f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00da, code lost:
    
        if (r11 == r1) goto L44;
     */
    @Override // com.box.android.domain.usecases.observability.UploadLogsUseCase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object uploadLogs(java.lang.String r10, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r11) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.observability.UploadLogsInteractor.uploadLogs(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.box.android.domain.usecases.observability.UploadLogsUseCase
    public boolean areAllLogsNotUploaded() {
        return this.observabilityService.getLogArchiveFileCount() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object uploadLogArchive(AuthenticationInfoModel authenticationInfoModel, File file, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return this.observabilityService.uploadLogArchiveFile(file, new ItemId.Remote(AppConstants.MOBILE_LOG_UPLOADER_FOLDER_ID, ItemType.FOLDER), authenticationInfoModel, str, continuation);
    }
}
