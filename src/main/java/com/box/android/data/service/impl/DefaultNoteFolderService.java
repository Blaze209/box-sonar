package com.box.android.data.service.impl;

import com.box.android.common.utilities.Clock;
import com.box.android.data.api.models.notes.DefaultNoteFolderDTO;
import com.box.android.data.api.models.notes.UserSettingsDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.notes.DefaultNoteFolderRemoteDataSource;
import com.box.android.domain.models.DefaultNoteFolderResult;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.services.IDefaultNoteFolderService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultNoteFolderService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0096@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0013\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\u001f\u0010\u0018\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u001aJ\u0016\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002J\f\u0010\u001e\u001a\u00020\u0017*\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/data/service/impl/DefaultNoteFolderService;", "Lcom/box/android/domain/services/IDefaultNoteFolderService;", "remoteDataSource", "Lcom/box/android/data/datasource/notes/DefaultNoteFolderRemoteDataSource;", "clock", "Lcom/box/android/common/utilities/Clock;", "<init>", "(Lcom/box/android/data/datasource/notes/DefaultNoteFolderRemoteDataSource;Lcom/box/android/common/utilities/Clock;)V", "cachedFolderId", "", "cachedAtMillis", "", "getOrCreateDefaultNoteFolder", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DefaultNoteFolderResult;", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultNoteFolder", "", "folderId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "shouldRefresh", "", "setCacheForTesting", "fetchedAtMillis", "setCacheForTesting$data_generalProdRelease", "readCachedFolder", "cacheFolder", "defaultNoteFolderNotAccessible", "isConnectivityError", "Lcom/box/android/data/datasource/errors/RemoteError;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultNoteFolderService implements IDefaultNoteFolderService {
    private static final String TAG = "DefaultNoteFolderService";
    private long cachedAtMillis;
    private String cachedFolderId;
    private final Clock clock;
    private final DefaultNoteFolderRemoteDataSource remoteDataSource;
    private static final long CACHE_TTL_MILLIS = TimeUnit.DAYS.toMillis(1);

    /* JADX INFO: renamed from: com.box.android.data.service.impl.DefaultNoteFolderService$getOrCreateDefaultNoteFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultNoteFolderService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.DefaultNoteFolderService", f = "DefaultNoteFolderService.kt", i = {}, l = {30}, m = "getOrCreateDefaultNoteFolder", n = {}, s = {}, v = 1)
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
            return DefaultNoteFolderService.this.getOrCreateDefaultNoteFolder(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.DefaultNoteFolderService$setDefaultNoteFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultNoteFolderService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.DefaultNoteFolderService", f = "DefaultNoteFolderService.kt", i = {0}, l = {61}, m = "setDefaultNoteFolder", n = {"folderId"}, s = {"L$0"}, v = 1)
    static final class C14191 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14191(Continuation<? super C14191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultNoteFolderService.this.setDefaultNoteFolder(null, this);
        }
    }

    @Inject
    public DefaultNoteFolderService(DefaultNoteFolderRemoteDataSource remoteDataSource, Clock clock) {
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.remoteDataSource = remoteDataSource;
        this.clock = clock;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDefaultNoteFolderService
    public Object getOrCreateDefaultNoteFolder(Continuation<? super Result<? extends DefaultNoteFolderResult, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result<DefaultNoteFolderResult, DomainError> cachedFolder;
        DefaultNoteFolderResult defaultNoteFolderResult;
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
        Object orCreateDefaultNoteFolder = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orCreateDefaultNoteFolder);
            if (!shouldRefresh() && (cachedFolder = readCachedFolder()) != null) {
                return cachedFolder;
            }
            DefaultNoteFolderRemoteDataSource defaultNoteFolderRemoteDataSource = this.remoteDataSource;
            anonymousClass1.label = 1;
            orCreateDefaultNoteFolder = defaultNoteFolderRemoteDataSource.getOrCreateDefaultNoteFolder(anonymousClass1);
            if (orCreateDefaultNoteFolder == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(orCreateDefaultNoteFolder);
        }
        Result result = (Result) orCreateDefaultNoteFolder;
        if (result instanceof Result.Success) {
            String folderId = ((DefaultNoteFolderDTO) ((Result.Success) result).getValue()).getFolderId();
            if (folderId == null) {
                return defaultNoteFolderNotAccessible();
            }
            cacheFolder(folderId);
            return new Result.Success(new DefaultNoteFolderResult.Resolved(folderId));
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Error error = (Result.Error) result;
        if (!isConnectivityError((RemoteError) error.getValue())) {
            return defaultNoteFolderNotAccessible();
        }
        Result<DefaultNoteFolderResult, DomainError> cachedFolder2 = readCachedFolder();
        String folderId2 = null;
        if (cachedFolder2 != null) {
            Result.Success success = cachedFolder2 instanceof Result.Success ? (Result.Success) cachedFolder2 : null;
            if (success != null && (defaultNoteFolderResult = (DefaultNoteFolderResult) success.getValue()) != null) {
                DefaultNoteFolderResult.Resolved resolved = defaultNoteFolderResult instanceof DefaultNoteFolderResult.Resolved ? (DefaultNoteFolderResult.Resolved) defaultNoteFolderResult : null;
                if (resolved != null) {
                    folderId2 = resolved.getFolderId();
                }
            }
            if (folderId2 != null) {
                BoxLogUtils.w(TAG, "Failed to fetch default note folder (" + error.getValue() + "); falling back to cached folder " + folderId2);
            }
            return cachedFolder2;
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) error.getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IDefaultNoteFolderService
    public Object setDefaultNoteFolder(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14191 c14191;
        if (continuation instanceof C14191) {
            c14191 = (C14191) continuation;
            if ((c14191.label & Integer.MIN_VALUE) != 0) {
                c14191.label -= Integer.MIN_VALUE;
            } else {
                c14191 = new C14191(continuation);
            }
        } else {
            c14191 = new C14191(continuation);
        }
        Object defaultNoteFolder = c14191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14191.label;
        if (i == 0) {
            ResultKt.throwOnFailure(defaultNoteFolder);
            DefaultNoteFolderRemoteDataSource defaultNoteFolderRemoteDataSource = this.remoteDataSource;
            c14191.L$0 = str;
            c14191.label = 1;
            defaultNoteFolder = defaultNoteFolderRemoteDataSource.setDefaultNoteFolder(str, c14191);
            if (defaultNoteFolder == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c14191.L$0;
            ResultKt.throwOnFailure(defaultNoteFolder);
        }
        Result result = (Result) defaultNoteFolder;
        if (result instanceof Result.Success) {
            String myBoxNotesFolderId = ((UserSettingsDTO) ((Result.Success) result).getValue()).getMyBoxNotesFolderId();
            if (myBoxNotesFolderId != null) {
                str = myBoxNotesFolderId;
            }
            cacheFolder(str);
            return new Result.Success(Unit.INSTANCE);
        }
        if (result instanceof Result.Error) {
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) result).getValue(), null, 2, null));
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.domain.services.IDefaultNoteFolderService
    public void clearCache() {
        this.cachedFolderId = null;
        this.cachedAtMillis = 0L;
    }

    public final boolean shouldRefresh() {
        return this.cachedFolderId == null || this.cachedAtMillis == 0 || this.clock.currentTimeMillis() - this.cachedAtMillis > CACHE_TTL_MILLIS;
    }

    public final void setCacheForTesting$data_generalProdRelease(String folderId, long fetchedAtMillis) {
        this.cachedFolderId = folderId;
        this.cachedAtMillis = fetchedAtMillis;
    }

    private final Result<DefaultNoteFolderResult, DomainError> readCachedFolder() {
        String str = this.cachedFolderId;
        if (str == null) {
            return null;
        }
        return new Result.Success(new DefaultNoteFolderResult.Resolved(str));
    }

    private final void cacheFolder(String folderId) {
        this.cachedFolderId = folderId;
        this.cachedAtMillis = this.clock.currentTimeMillis();
    }

    private final Result<DefaultNoteFolderResult, DomainError> defaultNoteFolderNotAccessible() {
        clearCache();
        return new Result.Success(DefaultNoteFolderResult.NotAccessible.INSTANCE);
    }

    private final boolean isConnectivityError(RemoteError remoteError) {
        return (remoteError instanceof RemoteError.NetworkError) || (remoteError instanceof RemoteError.UnknownHostError);
    }
}
