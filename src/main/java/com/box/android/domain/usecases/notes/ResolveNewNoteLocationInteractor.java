package com.box.android.domain.usecases.notes;

import com.box.android.domain.models.DefaultNoteFolderResult;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.NoteCreationError;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.services.IDefaultNoteFolderService;
import com.box.android.domain.utils.result.Result;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResolveNewNoteLocationInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0096B¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0082@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationInteractor;", "Lcom/box/android/domain/usecases/notes/ResolveNewNoteLocationUseCase;", "defaultNoteFolderService", "Lcom/box/android/domain/services/IDefaultNoteFolderService;", "noteNameGenerator", "Lcom/box/android/domain/usecases/notes/NoteNameGenerator;", "<init>", "(Lcom/box/android/domain/services/IDefaultNoteFolderService;Lcom/box/android/domain/usecases/notes/NoteNameGenerator;)V", "invoke", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "Lcom/box/android/domain/models/NoteCreationError;", FirebaseAnalytics.Param.LOCATION, "Lcom/box/android/domain/models/NewNoteLocation;", "(Lcom/box/android/domain/models/NewNoteLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveFolder", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "resolveDefaultNoteFolder", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ResolveNewNoteLocationInteractor implements ResolveNewNoteLocationUseCase {
    private final IDefaultNoteFolderService defaultNoteFolderService;
    private final NoteNameGenerator noteNameGenerator;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.notes.ResolveNewNoteLocationInteractor$resolveDefaultNoteFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: ResolveNewNoteLocationInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.notes.ResolveNewNoteLocationInteractor", f = "ResolveNewNoteLocationInteractor.kt", i = {}, l = {29}, m = "resolveDefaultNoteFolder", n = {}, s = {}, v = 1)
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
            return ResolveNewNoteLocationInteractor.this.resolveDefaultNoteFolder(this);
        }
    }

    @Inject
    public ResolveNewNoteLocationInteractor(IDefaultNoteFolderService defaultNoteFolderService, NoteNameGenerator noteNameGenerator) {
        Intrinsics.checkNotNullParameter(defaultNoteFolderService, "defaultNoteFolderService");
        Intrinsics.checkNotNullParameter(noteNameGenerator, "noteNameGenerator");
        this.defaultNoteFolderService = defaultNoteFolderService;
        this.noteNameGenerator = noteNameGenerator;
    }

    @Override // com.box.android.domain.usecases.notes.ResolveNewNoteLocationUseCase
    public Object invoke(NewNoteLocation newNoteLocation, Continuation<? super Result<NewNoteData, ? extends NoteCreationError>> continuation) {
        if (newNoteLocation instanceof NewNoteLocation.Folder) {
            return resolveFolder(((NewNoteLocation.Folder) newNoteLocation).getFolder());
        }
        if (Intrinsics.areEqual(newNoteLocation, NewNoteLocation.DefaultNotesFolder.INSTANCE)) {
            return resolveDefaultNoteFolder(continuation);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<NewNoteData, NoteCreationError> resolveFolder(FolderModel folder) {
        if (NoteFolderPermissionsKt.canCreateNotes(folder)) {
            return new Result.Success(new NewNoteData(ItemModelKt.toItemIdRemoteId(folder).getBoxId(), this.noteNameGenerator.generate()));
        }
        return new Result.Error(new NoteCreationError.PermissionDenied(null, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object resolveDefaultNoteFolder(Continuation<? super Result<NewNoteData, ? extends NoteCreationError>> continuation) {
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
        Object orCreateDefaultNoteFolder = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(orCreateDefaultNoteFolder);
            IDefaultNoteFolderService iDefaultNoteFolderService = this.defaultNoteFolderService;
            anonymousClass1.label = 1;
            orCreateDefaultNoteFolder = iDefaultNoteFolderService.getOrCreateDefaultNoteFolder(anonymousClass1);
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
            DefaultNoteFolderResult defaultNoteFolderResult = (DefaultNoteFolderResult) ((Result.Success) result).getValue();
            if (defaultNoteFolderResult instanceof DefaultNoteFolderResult.Resolved) {
                return new Result.Success(new NewNoteData(((DefaultNoteFolderResult.Resolved) defaultNoteFolderResult).getFolderId(), this.noteNameGenerator.generate()));
            }
            if (!Intrinsics.areEqual(defaultNoteFolderResult, DefaultNoteFolderResult.NotAccessible.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(new NoteCreationError.DefaultNoteFolderNotAccessible(null, 1, null));
        }
        if (result instanceof Result.Error) {
            return new Result.Error(new NoteCreationError.Failed((DomainError) ((Result.Error) result).getValue()));
        }
        throw new NoWhenBranchMatchedException();
    }
}
