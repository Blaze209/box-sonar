package com.box.android.preview.preview;

import com.box.android.cpl.Effect;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.observability.PreviewPM23Event;
import com.box.android.preview.item.ItemPreviewReducer;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewObservabilityReducing.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003¨\u0006\u0007"}, d2 = {"reduceObservability", "Lcom/box/android/cpl/ReducerResult;", "Lcom/box/android/preview/item/ItemPreviewReducer$State;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/preview/item/ItemPreviewReducer;", "state", Analytics.Data.ACTION, "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewObservabilityReducingKt {
    public static final ReducerResult<ItemPreviewReducer.State, ItemPreviewReducer.Action> reduceObservability(ItemPreviewReducer itemPreviewReducer, ItemPreviewReducer.State state, ItemPreviewReducer.Action action) {
        Intrinsics.checkNotNullParameter(itemPreviewReducer, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(action, itemPreviewReducer, state, null)));
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewObservabilityReducingKt$reduceObservability$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewObservabilityReducing.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewObservabilityReducingKt$reduceObservability$1", f = "PreviewObservabilityReducing.kt", i = {1}, l = {48, 53, 59, 69, 75, 81, 87, 93, 99, 102, 111}, m = "invokeSuspend", n = {"updatedFile"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemPreviewReducer.Action $action;
        final /* synthetic */ ItemPreviewReducer.State $state;
        final /* synthetic */ ItemPreviewReducer $this_reduceObservability;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemPreviewReducer.Action action, ItemPreviewReducer itemPreviewReducer, ItemPreviewReducer.State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$action = action;
            this.$this_reduceObservability = itemPreviewReducer;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, this.$this_reduceObservability, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:79:0x024e  */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00bf, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviewObservability.sendPreviewError$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), ((com.box.android.preview.item.ItemPreviewReducer.Action.Error) r8.$action).getError(), null, r8, 4, null) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00f9, code lost:
        
            if (r8.$this_reduceObservability.getEnvironment().getObservability().updatePreviewMetric(r8.$this_reduceObservability.getObservabilityId(), new com.box.android.preview.preview.PreviewObservabilityReducingKt$reduceObservability$1$$ExternalSyntheticLambda0(r9), r8) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0122, code lost:
        
            if (r9.updatePreviewMetric(r1, new com.box.android.preview.preview.PreviewObservabilityReducingKt$reduceObservability$1$$ExternalSyntheticLambda1(r2), r8) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0151, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviewObservability.sendPreviewSuccess$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), null, r8, 2, null) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0180, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviewObservability.sendPreviewSuccess$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), null, r8, 2, null) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x01af, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviewObservability.sendPreviewSuccess$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), null, r8, 2, null) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x01de, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviewObservability.sendPreviewSuccess$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), null, r8, 2, null) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x020e, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviewObservability.sendPreviewSuccess$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), null, r8, 2, null) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x027a, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviewObservability.sendPreviewError$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), ((com.box.android.preview.previewtype.audio.AudioPreviewReducer.Action.Error) ((com.box.android.preview.item.ItemPreviewReducer.Action.AudioPreview) r8.$action).getAction()).getError(), null, r8, 4, null) == r0) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:91:0x02b9, code lost:
        
            if (com.box.android.domain.metrics.preview.PreviewObservability.sendPreviewSuccess$default(r8.$this_reduceObservability.getEnvironment().getObservability(), r8.$this_reduceObservability.getObservabilityId(), null, r8, 2, null) == r0) goto L92;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 732
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.preview.PreviewObservabilityReducingKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PreviewPM23Event invokeSuspend$lambda$0(FileModel fileModel, PreviewPM23Event previewPM23Event) {
            return previewPM23Event.copy((30551 & 1) != 0 ? previewPM23Event.fileId : fileModel.getItemId().toString(), (30551 & 2) != 0 ? previewPM23Event.previewerType : null, (30551 & 4) != 0 ? previewPM23Event.extension : null, (30551 & 8) != 0 ? previewPM23Event.failed : false, (30551 & 16) != 0 ? previewPM23Event.previewSource : null, (30551 & 32) != 0 ? previewPM23Event.failReason : null, (30551 & 64) != 0 ? previewPM23Event.errorCode : null, (30551 & 128) != 0 ? previewPM23Event.errorMessage : null, (30551 & 256) != 0 ? previewPM23Event.sizeKB : null, (30551 & 512) != 0 ? previewPM23Event.sizeBucket : null, (30551 & 1024) != 0 ? previewPM23Event.loadedFromCache : null, (30551 & 2048) != 0 ? previewPM23Event.ttiMs : null, (30551 & 4096) != 0 ? previewPM23Event.itemState : null, (30551 & 8192) != 0 ? previewPM23Event.device : null, (30551 & 16384) != 0 ? previewPM23Event.user : null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PreviewPM23Event invokeSuspend$lambda$1(ItemPreviewReducer.Action action, PreviewPM23Event previewPM23Event) {
            ItemPreviewReducer.Action.Ready ready = (ItemPreviewReducer.Action.Ready) action;
            return previewPM23Event.copy((30551 & 1) != 0 ? previewPM23Event.fileId : null, (30551 & 2) != 0 ? previewPM23Event.previewerType : ready.getPreviewData().getPreviewerType(), (30551 & 4) != 0 ? previewPM23Event.extension : null, (30551 & 8) != 0 ? previewPM23Event.failed : false, (30551 & 16) != 0 ? previewPM23Event.previewSource : null, (30551 & 32) != 0 ? previewPM23Event.failReason : null, (30551 & 64) != 0 ? previewPM23Event.errorCode : null, (30551 & 128) != 0 ? previewPM23Event.errorMessage : null, (30551 & 256) != 0 ? previewPM23Event.sizeKB : null, (30551 & 512) != 0 ? previewPM23Event.sizeBucket : null, (30551 & 1024) != 0 ? previewPM23Event.loadedFromCache : Boolean.valueOf(ready.getPreviewData().getLoadedFromCache()), (30551 & 2048) != 0 ? previewPM23Event.ttiMs : null, (30551 & 4096) != 0 ? previewPM23Event.itemState : null, (30551 & 8192) != 0 ? previewPM23Event.device : null, (30551 & 16384) != 0 ? previewPM23Event.user : null);
        }
    }
}
