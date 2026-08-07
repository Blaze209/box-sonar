package com.box.android.data.datasource.hubs;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.data.api.requests.HubAssetDownloadRequest;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.hubs.HubAssetModel;
import com.box.android.domain.models.hubs.HubAssetType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: HubAssetRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/datasource/hubs/HubAssetRemoteDataSource;", "", "hubAssetDownloadRequest", "Lcom/box/android/data/api/requests/HubAssetDownloadRequest;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/data/api/requests/HubAssetDownloadRequest;Lkotlinx/coroutines/CoroutineDispatcher;)V", "downloadHubAsset", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "hubAssetModel", "Lcom/box/android/domain/models/hubs/HubAssetModel;", "targetFile", "Ljava/io/File;", "(Lcom/box/android/domain/models/hubs/HubAssetModel;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyToTargetFile", "", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "scaledImageSize", "", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubAssetRemoteDataSource {
    public static final int HUB_BANNER_SCALED_SIZE = 800;
    public static final int HUB_ICON_SCALED_SIZE = 160;
    private final HubAssetDownloadRequest hubAssetDownloadRequest;
    private final CoroutineDispatcher ioDispatcher;

    /* JADX INFO: compiled from: HubAssetRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HubAssetType.values().length];
            try {
                iArr[HubAssetType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HubAssetType.ICON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public HubAssetRemoteDataSource(HubAssetDownloadRequest hubAssetDownloadRequest, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(hubAssetDownloadRequest, "hubAssetDownloadRequest");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.hubAssetDownloadRequest = hubAssetDownloadRequest;
        this.ioDispatcher = ioDispatcher;
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.hubs.HubAssetRemoteDataSource$downloadHubAsset$2, reason: invalid class name */
    /* JADX INFO: compiled from: HubAssetRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError$CustomError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.hubs.HubAssetRemoteDataSource$downloadHubAsset$2", f = "HubAssetRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "invokeSuspend", n = {"$this$withContext", "it", "$i$f$resultOf", "$i$a$-resultOf-HubAssetRemoteDataSource$downloadHubAsset$2$1", "$i$a$-let-HubAssetRemoteDataSource$downloadHubAsset$2$1$responseBody$1"}, s = {"L$0", "L$4", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError.CustomError>>, Object> {
        final /* synthetic */ HubAssetModel $hubAssetModel;
        final /* synthetic */ File $targetFile;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ HubAssetRemoteDataSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(HubAssetModel hubAssetModel, HubAssetRemoteDataSource hubAssetRemoteDataSource, File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$hubAssetModel = hubAssetModel;
            this.this$0 = hubAssetRemoteDataSource;
            this.$targetFile = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$hubAssetModel, this.this$0, this.$targetFile, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends DomainError.CustomError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, DomainError.CustomError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, DomainError.CustomError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Result.Error error;
            HubAssetRemoteDataSource hubAssetRemoteDataSource;
            HubAssetModel hubAssetModel;
            File file;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HubAssetModel hubAssetModel2 = this.$hubAssetModel;
                    hubAssetRemoteDataSource = this.this$0;
                    File file2 = this.$targetFile;
                    String signedUrl = hubAssetModel2.getSignedUrl();
                    if (signedUrl != null) {
                        HubAssetDownloadRequest hubAssetDownloadRequest = hubAssetRemoteDataSource.hubAssetDownloadRequest;
                        this.L$0 = coroutineScope;
                        this.L$1 = hubAssetModel2;
                        this.L$2 = hubAssetRemoteDataSource;
                        this.L$3 = file2;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(signedUrl);
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.I$2 = 0;
                        this.label = 1;
                        Object objDownloadHubAsset = hubAssetDownloadRequest.downloadHubAsset(signedUrl, this);
                        if (objDownloadHubAsset == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objDownloadHubAsset;
                        hubAssetModel = hubAssetModel2;
                        file = file2;
                    }
                    throw new BoxException("No signed URL found for hub asset");
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                file = (File) this.L$3;
                hubAssetRemoteDataSource = (HubAssetRemoteDataSource) this.L$2;
                hubAssetModel = (HubAssetModel) this.L$1;
                ResultKt.throwOnFailure(obj);
                ResponseBody responseBody = (ResponseBody) obj;
                if (responseBody != null) {
                    if (!hubAssetRemoteDataSource.copyToTargetFile(hubAssetModel, responseBody.byteStream(), new FileOutputStream(file))) {
                        throw new BoxException("Unable to copy downloaded hub asset to file");
                    }
                    error = new Result.Success(Unit.INSTANCE);
                    if (error instanceof Result.Success) {
                        return error;
                    }
                    if (error instanceof Result.Error) {
                        Exception exc = (Exception) ((Result.Error) error).getValue();
                        BoxLogUtils.e(ExtensionsKt.getTAG(coroutineScope), "Unable to download hub asset", exc);
                        String message = exc.getMessage();
                        if (message == null) {
                            message = MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR;
                        }
                        return new Result.Error(new DomainError.CustomError(message));
                    }
                    throw new NoWhenBranchMatchedException();
                }
                throw new BoxException("No signed URL found for hub asset");
            } catch (Exception e) {
                error = new Result.Error(e);
            }
        }
    }

    public final Object downloadHubAsset(HubAssetModel hubAssetModel, File file, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new AnonymousClass2(hubAssetModel, this, file, null), continuation);
    }

    public final boolean copyToTargetFile(HubAssetModel hubAssetModel, InputStream inputStream, OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(hubAssetModel, "hubAssetModel");
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        try {
            return CommonBoxUtil.scaleAndSaveImage(inputStream, outputStream, scaledImageSize(hubAssetModel));
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Unable to copy downloaded hub asset to file", e);
            return false;
        } finally {
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        }
    }

    public final int scaledImageSize(HubAssetModel hubAssetModel) {
        Intrinsics.checkNotNullParameter(hubAssetModel, "hubAssetModel");
        int i = WhenMappings.$EnumSwitchMapping$0[hubAssetModel.getType().ordinal()];
        if (i == 1) {
            return HUB_BANNER_SCALED_SIZE;
        }
        if (i == 2) {
            return 160;
        }
        throw new NoWhenBranchMatchedException();
    }
}
