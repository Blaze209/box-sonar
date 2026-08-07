package com.box.android.domain.usecases.preview;

import com.box.android.domain.services.IRecentNotesService;
import com.box.android.domain.services.IRecentsService;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrackRecentPreviewItemInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086B¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/usecases/preview/TrackRecentPreviewItemInteractor;", "", "recentsService", "Lcom/box/android/domain/services/IRecentsService;", "recentNotesService", "Lcom/box/android/domain/services/IRecentNotesService;", "<init>", "(Lcom/box/android/domain/services/IRecentsService;Lcom/box/android/domain/services/IRecentNotesService;)V", "invoke", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TrackRecentPreviewItemInteractor {
    private final IRecentNotesService recentNotesService;
    private final IRecentsService recentsService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrackRecentPreviewItemInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor", f = "TrackRecentPreviewItemInteractor.kt", i = {0, 0, 1, 1}, l = {17, 21}, m = "invoke", n = {"fileModel", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "fileModel", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
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
            return TrackRecentPreviewItemInteractor.this.invoke(null, null, this);
        }
    }

    @Inject
    public TrackRecentPreviewItemInteractor(IRecentsService recentsService, IRecentNotesService recentNotesService) {
        Intrinsics.checkNotNullParameter(recentsService, "recentsService");
        Intrinsics.checkNotNullParameter(recentNotesService, "recentNotesService");
        this.recentsService = recentsService;
        this.recentNotesService = recentNotesService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
    
        if (r9 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invoke(com.box.android.domain.models.item.FileModel r7, java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor$invoke$1 r0 = (com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor$invoke$1 r0 = new com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor$invoke$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.models.item.FileModel r6 = (com.box.android.domain.models.item.FileModel) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L85
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.L$0
            com.box.android.domain.models.item.FileModel r7 = (com.box.android.domain.models.item.FileModel) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L62
        L4a:
            kotlin.ResultKt.throwOnFailure(r9)
            com.box.android.domain.services.IRecentsService r9 = r6.recentsService
            com.box.android.domain.models.ItemId r2 = r7.getItemId()
            com.box.android.domain.usecases.InteractionType r5 = com.box.android.domain.usecases.InteractionType.PREVIEW
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r9.addToRecents(r2, r5, r8, r0)
            if (r9 != r1) goto L62
            goto L84
        L62:
            com.box.android.domain.utils.SupportedFileExtensions r9 = com.box.android.domain.utils.SupportedFileExtensions.INSTANCE
            java.lang.String r2 = r7.getExtension()
            boolean r9 = r9.isBoxNoteExtension(r2)
            if (r9 == 0) goto Lb0
            com.box.android.domain.services.IRecentNotesService r6 = r6.recentNotesService
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r6.saveNoteToRecents(r7, r8, r0)
            if (r9 != r1) goto L85
        L84:
            return r1
        L85:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            boolean r6 = r9 instanceof com.box.android.domain.utils.result.Result.Success
            if (r6 != 0) goto Lb0
            boolean r6 = r9 instanceof com.box.android.domain.utils.result.Result.Error
            if (r6 == 0) goto Laa
            com.box.android.domain.utils.result.Result$Error r9 = (com.box.android.domain.utils.result.Result.Error) r9
            java.lang.Object r6 = r9.getValue()
            com.box.android.domain.models.DomainError r6 = (com.box.android.domain.models.DomainError) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Failed to save box note to recent notes cache: "
            r7.<init>(r8)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r6 = r6.toString()
            com.box.androidsdk.content.utils.BoxLogUtils.e(r6)
            goto Lb0
        Laa:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        Lb0:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor.invoke(com.box.android.domain.models.item.FileModel, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
