package com.box.cirrus.providers;

import com.box.android.common.utilities.ResourcesProvider;
import com.box.android.coreservices.R;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.JobInfoProvidersKt;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.services.IUploadFileProvider;
import com.box.android.domain.services.IUploadFileService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.margelo.nitro.boxcontext.ItemIdentifier;
import com.margelo.nitro.boxcontext.PendingItemError;
import com.margelo.nitro.boxcontext.PendingItemUpdate;
import com.margelo.nitro.boxcontext.providers.ContentUploadService;
import io.opentelemetry.exporter.internal.grpc.GrpcStatusUtil;
import java.io.File;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: BoxContentUploadService.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016J\u001e\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/cirrus/providers/BoxContentUploadService;", "Lcom/margelo/nitro/boxcontext/providers/ContentUploadService;", "uploadFileService", "Lcom/box/android/domain/services/IUploadFileService;", "uploadFileProvider", "Lcom/box/android/domain/services/IUploadFileProvider;", "resourcesProvider", "Lcom/box/android/common/utilities/ResourcesProvider;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/services/IUploadFileService;Lcom/box/android/domain/services/IUploadFileProvider;Lcom/box/android/common/utilities/ResourcesProvider;Lkotlinx/coroutines/CoroutineDispatcher;)V", "startUpload", "Lkotlin/Function0;", "", "itemId", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "itemName", "", "uploadFolderId", "onUpdate", "Lkotlin/Function1;", "Lcom/margelo/nitro/boxcontext/PendingItemUpdate;", "mapResultToUploadResult", "Lcom/box/cirrus/providers/BoxContentUploadService$UploadResultWrapper;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/DomainError;", "UploadResultWrapper", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxContentUploadService implements ContentUploadService {
    private final CoroutineDispatcher coroutineDispatcher;
    private final ResourcesProvider resourcesProvider;
    private final IUploadFileProvider uploadFileProvider;
    private final IUploadFileService uploadFileService;

    @Inject
    public BoxContentUploadService(IUploadFileService uploadFileService, IUploadFileProvider uploadFileProvider, ResourcesProvider resourcesProvider, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(uploadFileService, "uploadFileService");
        Intrinsics.checkNotNullParameter(uploadFileProvider, "uploadFileProvider");
        Intrinsics.checkNotNullParameter(resourcesProvider, "resourcesProvider");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.uploadFileService = uploadFileService;
        this.uploadFileProvider = uploadFileProvider;
        this.resourcesProvider = resourcesProvider;
        this.coroutineDispatcher = coroutineDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: BoxContentUploadService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/cirrus/providers/BoxContentUploadService$UploadResultWrapper;", "", "<init>", "()V", "Success", "Error", "Lcom/box/cirrus/providers/BoxContentUploadService$UploadResultWrapper$Error;", "Lcom/box/cirrus/providers/BoxContentUploadService$UploadResultWrapper$Success;", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static abstract class UploadResultWrapper {
        public /* synthetic */ UploadResultWrapper(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxContentUploadService.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/cirrus/providers/BoxContentUploadService$UploadResultWrapper$Success;", "Lcom/box/cirrus/providers/BoxContentUploadService$UploadResultWrapper;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Success extends UploadResultWrapper {
            private final FileModel fileModel;

            public static /* synthetic */ Success copy$default(Success success, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = success.fileModel;
                }
                return success.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final Success copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new Success(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && Intrinsics.areEqual(this.fileModel, ((Success) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "Success(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        private UploadResultWrapper() {
        }

        /* JADX INFO: compiled from: BoxContentUploadService.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/cirrus/providers/BoxContentUploadService$UploadResultWrapper$Error;", "Lcom/box/cirrus/providers/BoxContentUploadService$UploadResultWrapper;", "pendingItemError", "Lcom/margelo/nitro/boxcontext/PendingItemError;", "<init>", "(Lcom/margelo/nitro/boxcontext/PendingItemError;)V", "getPendingItemError", "()Lcom/margelo/nitro/boxcontext/PendingItemError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends UploadResultWrapper {
            private final PendingItemError pendingItemError;

            public static /* synthetic */ Error copy$default(Error error, PendingItemError pendingItemError, int i, Object obj) {
                if ((i & 1) != 0) {
                    pendingItemError = error.pendingItemError;
                }
                return error.copy(pendingItemError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PendingItemError getPendingItemError() {
                return this.pendingItemError;
            }

            public final Error copy(PendingItemError pendingItemError) {
                Intrinsics.checkNotNullParameter(pendingItemError, "pendingItemError");
                return new Error(pendingItemError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.pendingItemError, ((Error) other).pendingItemError);
            }

            public int hashCode() {
                return this.pendingItemError.hashCode();
            }

            public String toString() {
                return "Error(pendingItemError=" + this.pendingItemError + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(PendingItemError pendingItemError) {
                super(null);
                Intrinsics.checkNotNullParameter(pendingItemError, "pendingItemError");
                this.pendingItemError = pendingItemError;
            }

            public final PendingItemError getPendingItemError() {
                return this.pendingItemError;
            }
        }
    }

    @Override // com.margelo.nitro.boxcontext.providers.ContentUploadService
    public Function0<Unit> startUpload(ItemIdentifier itemId, String itemName, String uploadFolderId, Function1<? super PendingItemUpdate, Unit> onUpdate) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        Intrinsics.checkNotNullParameter(uploadFolderId, "uploadFolderId");
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        final File temporaryUploadFile = this.uploadFileProvider.getTemporaryUploadFile(itemId.getId());
        final Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), null, null, new BoxContentUploadService$startUpload$job$1(uploadFolderId, this, temporaryUploadFile, itemName, new ItemId.Remote(uploadFolderId, ItemType.FOLDER), onUpdate, itemId, null), 3, null);
        jobLaunch$default.invokeOnCompletion(new Function1() { // from class: com.box.cirrus.providers.BoxContentUploadService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxContentUploadService.startUpload$lambda$0(temporaryUploadFile, (Throwable) obj);
            }
        });
        return new Function0() { // from class: com.box.cirrus.providers.BoxContentUploadService$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BoxContentUploadService.startUpload$lambda$1(jobLaunch$default);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startUpload$lambda$0(File file, Throwable th) {
        if (!file.delete()) {
            BoxLogUtils.e("Failed to delete file after uploading file to AX");
        } else {
            BoxLogUtils.v("File is deleted after uploading file to AX");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startUpload$lambda$1(Job job) {
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x004a  */
    public final UploadResultWrapper mapResultToUploadResult(Result<FileModel, ? extends DomainError> result) {
        String string;
        if (result instanceof Result.Success) {
            return new UploadResultWrapper.Success((FileModel) ((Result.Success) result).getValue());
        }
        if (!(result instanceof Result.Error)) {
            if (result != null) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e("Upload did not complete unexpectedly");
            return new UploadResultWrapper.Error(new PendingItemError("2", this.resourcesProvider.getString(R.string.job_item_error_type_timed_out), false, false));
        }
        DomainError domainError = (DomainError) ((Result.Error) result).getValue();
        BoxLogUtils.e("Upload failed with an error " + DomainErrorKt.loggingMessage(domainError));
        Integer fileUploadErrorStringRes = JobInfoProvidersKt.getFileUploadErrorStringRes(domainError);
        if (fileUploadErrorStringRes != null) {
            string = this.resourcesProvider.getString(fileUploadErrorStringRes.intValue());
            if (string == null) {
                string = this.resourcesProvider.getString(R.string.job_item_error_type_generic_exception);
            }
        } else {
            string = this.resourcesProvider.getString(R.string.job_item_error_type_generic_exception);
        }
        return new UploadResultWrapper.Error(new PendingItemError(GrpcStatusUtil.GRPC_STATUS_DEADLINE_EXCEEDED, string, true, true));
    }
}
