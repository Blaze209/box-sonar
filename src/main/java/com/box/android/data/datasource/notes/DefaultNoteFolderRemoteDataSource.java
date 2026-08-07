package com.box.android.data.datasource.notes;

import com.box.android.data.api.models.notes.DefaultNoteFolderDTO;
import com.box.android.data.api.models.notes.SetDefaultNoteFolderRequestDTO;
import com.box.android.data.api.models.notes.UserSettingsDTO;
import com.box.android.data.api.requests.DefaultNoteFolderRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultNoteFolderRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0086@¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/datasource/notes/DefaultNoteFolderRemoteDataSource;", "", "defaultNoteFolderRequest", "Lcom/box/android/data/api/requests/DefaultNoteFolderRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/DefaultNoteFolderRequest;Lcom/squareup/moshi/Moshi;)V", "getOrCreateDefaultNoteFolder", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/notes/DefaultNoteFolderDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultNoteFolder", "Lcom/box/android/data/api/models/notes/UserSettingsDTO;", "folderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DefaultNoteFolderRemoteDataSource {
    private final DefaultNoteFolderRequest defaultNoteFolderRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.notes.DefaultNoteFolderRemoteDataSource$getOrCreateDefaultNoteFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultNoteFolderRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.notes.DefaultNoteFolderRemoteDataSource", f = "DefaultNoteFolderRemoteDataSource.kt", i = {0, 0}, l = {22}, m = "getOrCreateDefaultNoteFolder", n = {"$i$f$resultOf", "$i$a$-resultOf-DefaultNoteFolderRemoteDataSource$getOrCreateDefaultNoteFolder$2"}, s = {"I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultNoteFolderRemoteDataSource.this.getOrCreateDefaultNoteFolder(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.notes.DefaultNoteFolderRemoteDataSource$setDefaultNoteFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultNoteFolderRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.notes.DefaultNoteFolderRemoteDataSource", f = "DefaultNoteFolderRemoteDataSource.kt", i = {0, 0, 0}, l = {26}, m = "setDefaultNoteFolder", n = {"folderId", "$i$f$resultOf", "$i$a$-resultOf-DefaultNoteFolderRemoteDataSource$setDefaultNoteFolder$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C12111 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12111(Continuation<? super C12111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultNoteFolderRemoteDataSource.this.setDefaultNoteFolder(null, this);
        }
    }

    @Inject
    public DefaultNoteFolderRemoteDataSource(DefaultNoteFolderRequest defaultNoteFolderRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(defaultNoteFolderRequest, "defaultNoteFolderRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.defaultNoteFolderRequest = defaultNoteFolderRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getOrCreateDefaultNoteFolder(Continuation<? super Result<DefaultNoteFolderDTO, ? extends RemoteError>> continuation) {
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
        Object orCreateDefaultNoteFolder = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(orCreateDefaultNoteFolder);
                DefaultNoteFolderRequest defaultNoteFolderRequest = this.defaultNoteFolderRequest;
                String languageTag = Locale.getDefault().toLanguageTag();
                Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                orCreateDefaultNoteFolder = defaultNoteFolderRequest.getOrCreateDefaultNoteFolder(languageTag, anonymousClass1);
                if (orCreateDefaultNoteFolder == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(orCreateDefaultNoteFolder);
            }
            error = new Result.Success((DefaultNoteFolderDTO) orCreateDefaultNoteFolder);
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
    public final Object setDefaultNoteFolder(String str, Continuation<? super Result<UserSettingsDTO, ? extends RemoteError>> continuation) {
        C12111 c12111;
        Result.Error error;
        if (continuation instanceof C12111) {
            c12111 = (C12111) continuation;
            if ((c12111.label & Integer.MIN_VALUE) != 0) {
                c12111.label -= Integer.MIN_VALUE;
            } else {
                c12111 = new C12111(continuation);
            }
        } else {
            c12111 = new C12111(continuation);
        }
        Object defaultNoteFolder = c12111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12111.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(defaultNoteFolder);
                DefaultNoteFolderRequest defaultNoteFolderRequest = this.defaultNoteFolderRequest;
                SetDefaultNoteFolderRequestDTO setDefaultNoteFolderRequestDTO = new SetDefaultNoteFolderRequestDTO(str);
                c12111.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c12111.I$0 = 0;
                c12111.I$1 = 0;
                c12111.label = 1;
                defaultNoteFolder = defaultNoteFolderRequest.setDefaultNoteFolder(setDefaultNoteFolderRequestDTO, c12111);
                if (defaultNoteFolder == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12111.I$1;
                int i3 = c12111.I$0;
                ResultKt.throwOnFailure(defaultNoteFolder);
            }
            error = new Result.Success((UserSettingsDTO) defaultNoteFolder);
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
