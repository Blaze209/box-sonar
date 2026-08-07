package com.box.android.domain.usecases.notes;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.NoteCreationError;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.services.IDefaultNoteFolderService;
import com.box.android.domain.utils.result.Result;
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

/* JADX INFO: compiled from: SetDefaultNoteFolderInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0096B¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/usecases/notes/SetDefaultNoteFolderInteractor;", "Lcom/box/android/domain/usecases/notes/SetDefaultNoteFolderUseCase;", "defaultNoteFolderService", "Lcom/box/android/domain/services/IDefaultNoteFolderService;", "noteNameGenerator", "Lcom/box/android/domain/usecases/notes/NoteNameGenerator;", "<init>", "(Lcom/box/android/domain/services/IDefaultNoteFolderService;Lcom/box/android/domain/usecases/notes/NoteNameGenerator;)V", "invoke", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/usecases/notes/NewNoteData;", "Lcom/box/android/domain/models/NoteCreationError;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "(Lcom/box/android/domain/models/item/FolderModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SetDefaultNoteFolderInteractor implements SetDefaultNoteFolderUseCase {
    private final IDefaultNoteFolderService defaultNoteFolderService;
    private final NoteNameGenerator noteNameGenerator;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.notes.SetDefaultNoteFolderInteractor$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SetDefaultNoteFolderInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.notes.SetDefaultNoteFolderInteractor", f = "SetDefaultNoteFolderInteractor.kt", i = {0, 0}, l = {22}, m = "invoke", n = {"folder", "folderId"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return SetDefaultNoteFolderInteractor.this.invoke(null, this);
        }
    }

    @Inject
    public SetDefaultNoteFolderInteractor(IDefaultNoteFolderService defaultNoteFolderService, NoteNameGenerator noteNameGenerator) {
        Intrinsics.checkNotNullParameter(defaultNoteFolderService, "defaultNoteFolderService");
        Intrinsics.checkNotNullParameter(noteNameGenerator, "noteNameGenerator");
        this.defaultNoteFolderService = defaultNoteFolderService;
        this.noteNameGenerator = noteNameGenerator;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.usecases.notes.SetDefaultNoteFolderUseCase
    public Object invoke(FolderModel folderModel, Continuation<? super Result<NewNoteData, ? extends NoteCreationError>> continuation) {
        AnonymousClass1 anonymousClass1;
        String str;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!NoteFolderPermissionsKt.canCreateNotes(folderModel)) {
                return new Result.Error(new NoteCreationError.PermissionDenied(null, 1, null));
            }
            String boxId = ItemModelKt.toItemIdRemoteId(folderModel).getBoxId();
            IDefaultNoteFolderService iDefaultNoteFolderService = this.defaultNoteFolderService;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(folderModel);
            anonymousClass1.L$1 = boxId;
            anonymousClass1.label = 1;
            Object defaultNoteFolder = iDefaultNoteFolderService.setDefaultNoteFolder(boxId, anonymousClass1);
            if (defaultNoteFolder == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = defaultNoteFolder;
            str = boxId;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) anonymousClass1.L$1;
            ResultKt.throwOnFailure(obj);
        }
        Result.Success success = (Result) obj;
        if (success instanceof Result.Success) {
            success = new Result.Success(new NewNoteData(str, this.noteNameGenerator.generate()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(new NoteCreationError.Failed((DomainError) ((Result.Error) success).getValue()));
    }
}
