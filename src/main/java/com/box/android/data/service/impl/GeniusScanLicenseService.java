package com.box.android.data.service.impl;

import android.content.SharedPreferences;
import com.box.android.data.api.models.ClientSettingsDTO;
import com.box.android.data.datasource.clientsettings.ClientSettingsRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.ClientSettingsDTODomainMapper;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IGeniusScanLicenseService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: GeniusScanLicenseService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0096@¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0082@¢\u0006\u0002\u0010\fJ\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\tH\u0082@¢\u0006\u0002\u0010\fJ\n\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\f\u0010\u0019\u001a\u00020\u000b*\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/service/impl/GeniusScanLicenseService;", "Lcom/box/android/domain/services/IGeniusScanLicenseService;", "localGeniusLicensePrefs", "Landroid/content/SharedPreferences;", "clientSettingsRemoteDataSource", "Lcom/box/android/data/datasource/clientsettings/ClientSettingsRemoteDataSource;", "<init>", "(Landroid/content/SharedPreferences;Lcom/box/android/data/datasource/clientsettings/ClientSettingsRemoteDataSource;)V", "getLicenseKey", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldRefreshLicenseKey", "", "getFreshLicenseKey", "getCachedLicenseKey", "fetchLicenseKey", "Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError;", "readLicenseKeyFromCache", "writeLicenseKeyToCache", "", "licenseKey", "getLastFetchedAt", "Ljava/time/Instant;", "toDomain", "Companion", "ServiceLocalError", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeniusScanLicenseService implements IGeniusScanLicenseService {
    public static final String DATE_FETCHED = "date_fetched_license_key";
    public static final String LICENSE_KEY_KEY = "license_key";
    private final ClientSettingsRemoteDataSource clientSettingsRemoteDataSource;
    private final SharedPreferences localGeniusLicensePrefs;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.GeniusScanLicenseService$fetchLicenseKey$1, reason: invalid class name */
    /* JADX INFO: compiled from: GeniusScanLicenseService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.GeniusScanLicenseService", f = "GeniusScanLicenseService.kt", i = {}, l = {84}, m = "fetchLicenseKey", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GeniusScanLicenseService.this.fetchLicenseKey(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.GeniusScanLicenseService$getFreshLicenseKey$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GeniusScanLicenseService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.GeniusScanLicenseService", f = "GeniusScanLicenseService.kt", i = {}, l = {59}, m = "getFreshLicenseKey", n = {}, s = {}, v = 1)
    static final class C14331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C14331(Continuation<? super C14331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GeniusScanLicenseService.this.getFreshLicenseKey(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.GeniusScanLicenseService$getLicenseKey$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GeniusScanLicenseService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.GeniusScanLicenseService", f = "GeniusScanLicenseService.kt", i = {}, l = {39}, m = "getLicenseKey", n = {}, s = {}, v = 1)
    static final class C14341 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C14341(Continuation<? super C14341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GeniusScanLicenseService.this.getLicenseKey(this);
        }
    }

    @Inject
    public GeniusScanLicenseService(@Named("genius_scan_license_shared_preferences") SharedPreferences localGeniusLicensePrefs, ClientSettingsRemoteDataSource clientSettingsRemoteDataSource) {
        Intrinsics.checkNotNullParameter(localGeniusLicensePrefs, "localGeniusLicensePrefs");
        Intrinsics.checkNotNullParameter(clientSettingsRemoteDataSource, "clientSettingsRemoteDataSource");
        this.localGeniusLicensePrefs = localGeniusLicensePrefs;
        this.clientSettingsRemoteDataSource = clientSettingsRemoteDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IGeniusScanLicenseService
    public Object getLicenseKey(Continuation<? super Result<String, ? extends DomainError>> continuation) {
        C14341 c14341;
        if (continuation instanceof C14341) {
            c14341 = (C14341) continuation;
            if ((c14341.label & Integer.MIN_VALUE) != 0) {
                c14341.label -= Integer.MIN_VALUE;
            } else {
                c14341 = new C14341(continuation);
            }
        } else {
            c14341 = new C14341(continuation);
        }
        Object freshLicenseKey = c14341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14341.label;
        if (i == 0) {
            ResultKt.throwOnFailure(freshLicenseKey);
            if (shouldRefreshLicenseKey()) {
                c14341.label = 1;
                freshLicenseKey = getFreshLicenseKey(c14341);
                if (freshLicenseKey == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                return getCachedLicenseKey();
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(freshLicenseKey);
        }
        Result result = (Result) freshLicenseKey;
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            DomainError domainError = (DomainError) ((Result.Error) result).getValue();
            BoxLogUtils.e("Failed to refresh stale GeniusScan license, trying cached");
            Result<String, DomainError> cachedLicenseKey = getCachedLicenseKey();
            if (cachedLicenseKey instanceof Result.Success) {
                return cachedLicenseKey;
            }
            if (!(cachedLicenseKey instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(domainError);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean shouldRefreshLicenseKey() {
        Instant lastFetchedAt;
        return readLicenseKeyFromCache() == null || (lastFetchedAt = getLastFetchedAt()) == null || Duration.between(lastFetchedAt, Instant.now()).compareTo(Duration.ofDays(1L)) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getFreshLicenseKey(Continuation<? super Result<String, ? extends DomainError>> continuation) {
        C14331 c14331;
        if (continuation instanceof C14331) {
            c14331 = (C14331) continuation;
            if ((c14331.label & Integer.MIN_VALUE) != 0) {
                c14331.label -= Integer.MIN_VALUE;
            } else {
                c14331 = new C14331(continuation);
            }
        } else {
            c14331 = new C14331(continuation);
        }
        Object objFetchLicenseKey = c14331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14331.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchLicenseKey);
            BoxLogUtils.i("Refreshing GeniusScan license key");
            c14331.label = 1;
            objFetchLicenseKey = fetchLicenseKey(c14331);
            if (objFetchLicenseKey == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFetchLicenseKey);
        }
        Result.Error success = (Result) objFetchLicenseKey;
        if (success instanceof Result.Success) {
            writeLicenseKeyToCache((String) ((Result.Success) success).getValue());
            success = new Result.Success(readLicenseKeyFromCache());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            String str = (String) ((Result.Success) success).getValue();
            if (str == null) {
                success = new Result.Error(ServiceLocalError.CacheError.INSTANCE);
            } else {
                success = new Result.Success(str);
            }
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(toDomain((ServiceLocalError) ((Result.Error) success).getValue()));
    }

    private final Result<String, DomainError> getCachedLicenseKey() {
        String licenseKeyFromCache = readLicenseKeyFromCache();
        if (licenseKeyFromCache == null) {
            BoxLogUtils.e("No cached GeniusScan license");
            Result.Error error = new Result.Error(ServiceLocalError.CacheError.INSTANCE);
            return error instanceof Result.Success ? error : new Result.Error(toDomain((ServiceLocalError.CacheError) error.getValue()));
        }
        return new Result.Success(licenseKeyFromCache);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.GeniusScanLicenseService$fetchLicenseKey$2, reason: invalid class name */
    /* JADX INFO: compiled from: GeniusScanLicenseService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/ClientSettingsDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.GeniusScanLicenseService$fetchLicenseKey$2", f = "GeniusScanLicenseService.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ClientSettingsDTO, ? extends RemoteError>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GeniusScanLicenseService.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ClientSettingsDTO, ? extends RemoteError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<ClientSettingsDTO, ? extends RemoteError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<ClientSettingsDTO, ? extends RemoteError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object clientSettings$default = ClientSettingsRemoteDataSource.getClientSettings$default(GeniusScanLicenseService.this.clientSettingsRemoteDataSource, null, this, 1, null);
            return clientSettings$default == coroutine_suspended ? coroutine_suspended : clientSettings$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchLicenseKey(Continuation<? super Result<String, ? extends ServiceLocalError>> continuation) {
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, anonymousClass2, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        Result.Success success = (Result) objWithContext;
        if (!(success instanceof Result.Success)) {
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            success = new Result.Error(new ServiceLocalError.RemoteErrorWrapped((RemoteError) ((Result.Error) success).getValue()));
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(ClientSettingsDTODomainMapper.INSTANCE.toDomain((ClientSettingsDTO) ((Result.Success) success).getValue()).getGeniusScanLicense());
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(success instanceof Result.Success)) {
            if (success instanceof Result.Error) {
                return success;
            }
            throw new NoWhenBranchMatchedException();
        }
        String str = (String) ((Result.Success) success).getValue();
        if (str == null) {
            return new Result.Error(ServiceLocalError.NoLicenseKeyRemote.INSTANCE);
        }
        return new Result.Success(str);
    }

    private final String readLicenseKeyFromCache() {
        return this.localGeniusLicensePrefs.getString(LICENSE_KEY_KEY, null);
    }

    @Override // com.box.android.domain.services.IGeniusScanLicenseService
    public void writeLicenseKeyToCache(String licenseKey) {
        Intrinsics.checkNotNullParameter(licenseKey, "licenseKey");
        SharedPreferences.Editor editorEdit = this.localGeniusLicensePrefs.edit();
        editorEdit.putString(LICENSE_KEY_KEY, licenseKey);
        editorEdit.putString(DATE_FETCHED, Instant.now().toString());
        editorEdit.commit();
    }

    private final Instant getLastFetchedAt() {
        String string = this.localGeniusLicensePrefs.getString(DATE_FETCHED, null);
        if (string == null) {
            return null;
        }
        try {
            return Instant.parse(string);
        } catch (DateTimeParseException unused) {
            BoxLogUtils.w("Error parsing GeniusScan license update date");
            return null;
        }
    }

    private final DomainError toDomain(ServiceLocalError serviceLocalError) {
        String str;
        if (serviceLocalError instanceof ServiceLocalError.RemoteErrorWrapped) {
            str = "Remote error: " + ((ServiceLocalError.RemoteErrorWrapped) serviceLocalError).getError();
        } else if (Intrinsics.areEqual(serviceLocalError, ServiceLocalError.CacheError.INSTANCE)) {
            str = "Cache error";
        } else {
            if (!Intrinsics.areEqual(serviceLocalError, ServiceLocalError.NoLicenseKeyRemote.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            str = "License key missing in response.";
        }
        return new DomainError.GeniusScanLicenseUnavailable(str);
    }

    /* JADX INFO: compiled from: GeniusScanLicenseService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError;", "", "<init>", "()V", "NoLicenseKeyRemote", "CacheError", "RemoteErrorWrapped", "Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError$CacheError;", "Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError$NoLicenseKeyRemote;", "Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError$RemoteErrorWrapped;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static abstract class ServiceLocalError {
        public /* synthetic */ ServiceLocalError(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: GeniusScanLicenseService.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError$NoLicenseKeyRemote;", "Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class NoLicenseKeyRemote extends ServiceLocalError {
            public static final NoLicenseKeyRemote INSTANCE = new NoLicenseKeyRemote();

            private NoLicenseKeyRemote() {
                super(null);
            }
        }

        private ServiceLocalError() {
        }

        /* JADX INFO: compiled from: GeniusScanLicenseService.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError$CacheError;", "Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CacheError extends ServiceLocalError {
            public static final CacheError INSTANCE = new CacheError();

            private CacheError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GeniusScanLicenseService.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError$RemoteErrorWrapped;", "Lcom/box/android/data/service/impl/GeniusScanLicenseService$ServiceLocalError;", "error", "Lcom/box/android/data/datasource/errors/RemoteError;", "<init>", "(Lcom/box/android/data/datasource/errors/RemoteError;)V", "getError", "()Lcom/box/android/data/datasource/errors/RemoteError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RemoteErrorWrapped extends ServiceLocalError {
            private final RemoteError error;

            public static /* synthetic */ RemoteErrorWrapped copy$default(RemoteErrorWrapped remoteErrorWrapped, RemoteError remoteError, int i, Object obj) {
                if ((i & 1) != 0) {
                    remoteError = remoteErrorWrapped.error;
                }
                return remoteErrorWrapped.copy(remoteError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final RemoteError getError() {
                return this.error;
            }

            public final RemoteErrorWrapped copy(RemoteError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new RemoteErrorWrapped(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RemoteErrorWrapped) && Intrinsics.areEqual(this.error, ((RemoteErrorWrapped) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "RemoteErrorWrapped(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RemoteErrorWrapped(RemoteError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final RemoteError getError() {
                return this.error;
            }
        }
    }
}
