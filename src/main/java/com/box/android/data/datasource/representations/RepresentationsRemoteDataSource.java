package com.box.android.data.datasource.representations;

import com.amplitude.api.Constants;
import com.box.android.data.api.models.RepresentationDTO;
import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.api.models.fileversions.FileVersionRepresentationsDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.requests.FileRepresentationsRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.Moshi;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
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
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: RepresentationsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fJ*\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fJ*\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001bJ*\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019H\u0007J\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010'\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/box/android/data/datasource/representations/RepresentationsRemoteDataSource;", "", "fileRepresentationsRequest", "Lcom/box/android/data/api/requests/FileRepresentationsRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/FileRepresentationsRequest;Lcom/squareup/moshi/Moshi;)V", "getFileRepresentations", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/RepresentationsDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "fileId", "", BoxAnalyticsParams.CTA_LOCATION_HEADER, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileWithRepresentations", "Lcom/box/android/data/api/models/items/FileDTO;", "representationsHeader", "getVersionInfoWithRepresentations", "Lcom/box/android/data/api/models/fileversions/FileVersionRepresentationsDTO;", Constants.AMP_PLAN_VERSION_ID, "downloadRepresentation", "", "url", "Ljava/net/URL;", FirebaseAnalytics.Param.DESTINATION, "(Ljava/net/URL;Ljava/net/URL;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadRepresentationToOutputStream", "outputStream", "Ljava/io/OutputStream;", "(Ljava/net/URL;Ljava/io/OutputStream;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeResponseBodyToDisk", "", "body", "Lokhttp3/ResponseBody;", "destinationURL", "fetchRepresentationInfo", "Lcom/box/android/data/api/models/RepresentationDTO;", "infoUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RepresentationsRemoteDataSource {
    public static final String OFFLINE_REPRESENTATION_HINT_HEADER = "[mp4,mp3,jpg?dimensions=1024x1024&paged=false][pdf]";
    public static final String REPRESENTATION_HINT_HEADER = "[dash,mp4,mp3,jpg?dimensions=1024x1024&paged=false][pdf]";
    private final FileRepresentationsRequest fileRepresentationsRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsRemoteDataSource$downloadRepresentation$1, reason: invalid class name */
    /* JADX INFO: compiled from: RepresentationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsRemoteDataSource", f = "RepresentationsRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {63}, m = "downloadRepresentation", n = {"url", FirebaseAnalytics.Param.DESTINATION, "$i$f$resultOf", "$i$a$-resultOf-RepresentationsRemoteDataSource$downloadRepresentation$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsRemoteDataSource.this.downloadRepresentation(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsRemoteDataSource$downloadRepresentationToOutputStream$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsRemoteDataSource", f = "RepresentationsRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {77}, m = "downloadRepresentationToOutputStream", n = {"url", "outputStream", "$i$f$resultOf", "$i$a$-resultOf-RepresentationsRemoteDataSource$downloadRepresentationToOutputStream$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C12161 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12161(Continuation<? super C12161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsRemoteDataSource.this.downloadRepresentationToOutputStream(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsRemoteDataSource$fetchRepresentationInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsRemoteDataSource", f = "RepresentationsRemoteDataSource.kt", i = {0, 0, 0}, l = {128}, m = "fetchRepresentationInfo", n = {"infoUrl", "$i$f$resultOf", "$i$a$-resultOf-RepresentationsRemoteDataSource$fetchRepresentationInfo$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C12171 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12171(Continuation<? super C12171> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsRemoteDataSource.this.fetchRepresentationInfo(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsRemoteDataSource$getFileRepresentations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsRemoteDataSource", f = "RepresentationsRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {32}, m = "getFileRepresentations", n = {"fileId", BoxAnalyticsParams.CTA_LOCATION_HEADER, "$i$f$resultOf", "$i$a$-resultOf-RepresentationsRemoteDataSource$getFileRepresentations$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C12181 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12181(Continuation<? super C12181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsRemoteDataSource.this.getFileRepresentations(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsRemoteDataSource$getFileWithRepresentations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsRemoteDataSource", f = "RepresentationsRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {42}, m = "getFileWithRepresentations", n = {"fileId", "representationsHeader", "$i$f$resultOf", "$i$a$-resultOf-RepresentationsRemoteDataSource$getFileWithRepresentations$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C12191 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12191(Continuation<? super C12191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsRemoteDataSource.this.getFileWithRepresentations(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.representations.RepresentationsRemoteDataSource$getVersionInfoWithRepresentations$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RepresentationsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.representations.RepresentationsRemoteDataSource", f = "RepresentationsRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {52}, m = "getVersionInfoWithRepresentations", n = {"fileId", Constants.AMP_PLAN_VERSION_ID, "$i$f$resultOf", "$i$a$-resultOf-RepresentationsRemoteDataSource$getVersionInfoWithRepresentations$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C12201 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12201(Continuation<? super C12201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RepresentationsRemoteDataSource.this.getVersionInfoWithRepresentations(null, null, this);
        }
    }

    @Inject
    public RepresentationsRemoteDataSource(FileRepresentationsRequest fileRepresentationsRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(fileRepresentationsRequest, "fileRepresentationsRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.fileRepresentationsRequest = fileRepresentationsRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFileRepresentations(String str, String str2, Continuation<? super Result<RepresentationsDTO, ? extends RemoteError>> continuation) {
        C12181 c12181;
        Result.Error error;
        if (continuation instanceof C12181) {
            c12181 = (C12181) continuation;
            if ((c12181.label & Integer.MIN_VALUE) != 0) {
                c12181.label -= Integer.MIN_VALUE;
            } else {
                c12181 = new C12181(continuation);
            }
        } else {
            c12181 = new C12181(continuation);
        }
        Object fileRepresentations = c12181.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12181.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(fileRepresentations);
                FileRepresentationsRequest fileRepresentationsRequest = this.fileRepresentationsRequest;
                c12181.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c12181.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c12181.I$0 = 0;
                c12181.I$1 = 0;
                c12181.label = 1;
                fileRepresentations = fileRepresentationsRequest.getFileRepresentations(str, str2, c12181);
                if (fileRepresentations == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12181.I$1;
                int i3 = c12181.I$0;
                ResultKt.throwOnFailure(fileRepresentations);
            }
            error = new Result.Success(((FileDTO) fileRepresentations).getRepresentations());
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFileWithRepresentations(String str, String str2, Continuation<? super Result<FileDTO, ? extends RemoteError>> continuation) {
        C12191 c12191;
        Result.Error error;
        if (continuation instanceof C12191) {
            c12191 = (C12191) continuation;
            if ((c12191.label & Integer.MIN_VALUE) != 0) {
                c12191.label -= Integer.MIN_VALUE;
            } else {
                c12191 = new C12191(continuation);
            }
        } else {
            c12191 = new C12191(continuation);
        }
        C12191 c12192 = c12191;
        Object fileWithRepresentations$default = c12192.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12192.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(fileWithRepresentations$default);
                FileRepresentationsRequest fileRepresentationsRequest = this.fileRepresentationsRequest;
                c12192.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c12192.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c12192.I$0 = 0;
                c12192.I$1 = 0;
                c12192.label = 1;
                fileWithRepresentations$default = FileRepresentationsRequest.getFileWithRepresentations$default(fileRepresentationsRequest, str, str2, null, c12192, 4, null);
                if (fileWithRepresentations$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12192.I$1;
                int i3 = c12192.I$0;
                ResultKt.throwOnFailure(fileWithRepresentations$default);
            }
            error = new Result.Success((FileDTO) fileWithRepresentations$default);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getVersionInfoWithRepresentations(String str, String str2, Continuation<? super Result<FileVersionRepresentationsDTO, ? extends RemoteError>> continuation) {
        C12201 c12201;
        Result.Error error;
        if (continuation instanceof C12201) {
            c12201 = (C12201) continuation;
            if ((c12201.label & Integer.MIN_VALUE) != 0) {
                c12201.label -= Integer.MIN_VALUE;
            } else {
                c12201 = new C12201(continuation);
            }
        } else {
            c12201 = new C12201(continuation);
        }
        Object fileVersionRepresentations = c12201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12201.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(fileVersionRepresentations);
                FileRepresentationsRequest fileRepresentationsRequest = this.fileRepresentationsRequest;
                c12201.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c12201.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c12201.I$0 = 0;
                c12201.I$1 = 0;
                c12201.label = 1;
                fileVersionRepresentations = fileRepresentationsRequest.getFileVersionRepresentations(str, str2, REPRESENTATION_HINT_HEADER, c12201);
                if (fileVersionRepresentations == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12201.I$1;
                int i3 = c12201.I$0;
                ResultKt.throwOnFailure(fileVersionRepresentations);
            }
            error = new Result.Success((FileVersionRepresentationsDTO) fileVersionRepresentations);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadRepresentation(URL url, URL url2, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objDownloadRepresentation$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objDownloadRepresentation$default);
                FileRepresentationsRequest fileRepresentationsRequest = this.fileRepresentationsRequest;
                String string = url.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(url);
                anonymousClass2.L$1 = url2;
                anonymousClass2.I$0 = 0;
                anonymousClass2.I$1 = 0;
                anonymousClass2.label = 1;
                objDownloadRepresentation$default = FileRepresentationsRequest.downloadRepresentation$default(fileRepresentationsRequest, string, null, anonymousClass2, 2, null);
                if (objDownloadRepresentation$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass2.I$1;
                int i3 = anonymousClass2.I$0;
                url2 = (URL) anonymousClass2.L$1;
                ResultKt.throwOnFailure(objDownloadRepresentation$default);
            }
            error = new Result.Success((ResponseBody) objDownloadRepresentation$default);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            writeResponseBodyToDisk((ResponseBody) ((Result.Success) error).getValue(), url2);
            error = new Result.Success(Unit.INSTANCE);
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Exception while downloading representation", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object downloadRepresentationToOutputStream(URL url, OutputStream outputStream, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) throws IOException {
        C12161 c12161;
        Result.Error error;
        if (continuation instanceof C12161) {
            c12161 = (C12161) continuation;
            if ((c12161.label & Integer.MIN_VALUE) != 0) {
                c12161.label -= Integer.MIN_VALUE;
            } else {
                c12161 = new C12161(continuation);
            }
        } else {
            c12161 = new C12161(continuation);
        }
        C12161 c12162 = c12161;
        Object objDownloadRepresentation$default = c12162.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12162.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objDownloadRepresentation$default);
                FileRepresentationsRequest fileRepresentationsRequest = this.fileRepresentationsRequest;
                String string = url.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                c12162.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c12162.L$1 = outputStream;
                c12162.I$0 = 0;
                c12162.I$1 = 0;
                c12162.label = 1;
                objDownloadRepresentation$default = FileRepresentationsRequest.downloadRepresentation$default(fileRepresentationsRequest, string, null, c12162, 2, null);
                if (objDownloadRepresentation$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12162.I$1;
                int i3 = c12162.I$0;
                outputStream = (OutputStream) c12162.L$1;
                ResultKt.throwOnFailure(objDownloadRepresentation$default);
            }
            error = new Result.Success((ResponseBody) objDownloadRepresentation$default);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            InputStream inputStreamByteStream = ((ResponseBody) ((Result.Success) error).getValue()).byteStream();
            try {
                OutputStream outputStream2 = outputStream;
                try {
                    ByteStreamsKt.copyTo$default(inputStreamByteStream, outputStream2, 0, 2, null);
                    CloseableKt.closeFinally(outputStream2, null);
                    CloseableKt.closeFinally(inputStreamByteStream, null);
                    outputStream.flush();
                    outputStream.close();
                    error = new Result.Success(Unit.INSTANCE);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(outputStream2, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamByteStream, th3);
                    throw th4;
                }
            }
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Exception while downloading representation", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0068 A[Catch: IOException -> 0x0071, TryCatch #4 {IOException -> 0x0071, blocks: (B:3:0x000d, B:11:0x0030, B:12:0x0033, B:37:0x0068, B:39:0x006d, B:40:0x0070, B:32:0x005c, B:34:0x0061), top: B:46:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:39:0x006d A[Catch: IOException -> 0x0071, TryCatch #4 {IOException -> 0x0071, blocks: (B:3:0x000d, B:11:0x0030, B:12:0x0033, B:37:0x0068, B:39:0x006d, B:40:0x0070, B:32:0x005c, B:34:0x0061), top: B:46:0x000d }] */
    public final boolean writeResponseBodyToDisk(ResponseBody body, URL destinationURL) throws Throwable {
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(destinationURL, "destinationURL");
        try {
            String file = destinationURL.getFile();
            InputStream inputStream = null;
            try {
                byte[] bArr = new byte[4096];
                InputStream inputStreamByteStream = body.byteStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int i = inputStreamByteStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        } catch (IOException e) {
                            e = e;
                            inputStream = inputStreamByteStream;
                            try {
                                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Exception while saving representation to disk", e);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream == null) {
                                    return false;
                                }
                                fileOutputStream.close();
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = inputStreamByteStream;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    }
                    fileOutputStream.flush();
                    if (inputStreamByteStream != null) {
                        inputStreamByteStream.close();
                    }
                    fileOutputStream.close();
                    return true;
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } catch (IOException e4) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Exception while saving representation to disk", e4);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchRepresentationInfo(String str, Continuation<? super Result<RepresentationDTO, ? extends RemoteError>> continuation) {
        C12171 c12171;
        Result.Error error;
        if (continuation instanceof C12171) {
            c12171 = (C12171) continuation;
            if ((c12171.label & Integer.MIN_VALUE) != 0) {
                c12171.label -= Integer.MIN_VALUE;
            } else {
                c12171 = new C12171(continuation);
            }
        } else {
            c12171 = new C12171(continuation);
        }
        Object representationInfo = c12171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12171.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(representationInfo);
                FileRepresentationsRequest fileRepresentationsRequest = this.fileRepresentationsRequest;
                c12171.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c12171.I$0 = 0;
                c12171.I$1 = 0;
                c12171.label = 1;
                representationInfo = fileRepresentationsRequest.getRepresentationInfo(str, c12171);
                if (representationInfo == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12171.I$1;
                int i3 = c12171.I$0;
                ResultKt.throwOnFailure(representationInfo);
            }
            error = new Result.Success((RepresentationDTO) representationInfo);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }
}
