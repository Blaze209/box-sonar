package com.box.android.preview.preview;

import com.box.android.cpl.Effect;
import com.box.android.cpl.ReducerResult;
import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.previewtype.code.CodePreviewReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.gif.GifPreviewReducer;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.video.FrameAnnotationReducer;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
import com.box.android.preview.routing.PreviewRoute;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducerReducingItem.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002\u001a(\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002\u001a(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002\u001a(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002\u001a(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002\u001a(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0002H\u0002\u001a$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0005\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0002H\u0002\u001a$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\u0016"}, d2 = {"reduceItems", "Lcom/box/android/cpl/ReducerResult;", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "Lcom/box/android/preview/preview/PreviewReducer;", Analytics.Data.ACTION, "Lcom/box/android/preview/preview/PreviewReducer$Action$Items;", "state", "reduceImage", "Lcom/box/android/preview/previewtype/image/ImagePreviewReducer$Action;", "reduceDocument", "Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;", "reduceGif", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", "reduceVideo", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "reduceCode", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "reduceCreateAnnotation", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;", "reduceAnnotation", "Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewReducerReducingItemKt {
    public static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reduceItems(PreviewReducer previewReducer, PreviewReducer.Action.Items action, PreviewReducer.State state) {
        Intrinsics.checkNotNullParameter(previewReducer, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!Intrinsics.areEqual(state.getSelectedItemId(), action.getId())) {
            return new ReducerResult<>(state, null, 2, null);
        }
        ItemPreviewReducer.Action action2 = action.getAction();
        if ((action2 instanceof ItemPreviewReducer.Action.UpdateItem) || (action2 instanceof ItemPreviewReducer.Action.Ready)) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.evaluateFileActions(PreviewReducer.Action.FileActionsAction.INSTANCE, state.getPreviewItem().getItemState())));
        }
        if (action2 instanceof ItemPreviewReducer.Action.UpdateAiAvailability) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.update(PreviewReducer.Action.BottomBarAction.INSTANCE, state)));
        }
        if (action2 instanceof ItemPreviewReducer.Action.DocumentPreview) {
            return reduceDocument(previewReducer, ((ItemPreviewReducer.Action.DocumentPreview) action2).getAction(), state);
        }
        if (action2 instanceof ItemPreviewReducer.Action.ImagePreview) {
            return reduceImage(previewReducer, ((ItemPreviewReducer.Action.ImagePreview) action2).getAction(), state);
        }
        if (action2 instanceof ItemPreviewReducer.Action.GifPreview) {
            return reduceGif(previewReducer, ((ItemPreviewReducer.Action.GifPreview) action2).getAction(), state);
        }
        if (action2 instanceof ItemPreviewReducer.Action.VideoPreview) {
            return reduceVideo(previewReducer, ((ItemPreviewReducer.Action.VideoPreview) action2).getAction(), state);
        }
        if (action2 instanceof ItemPreviewReducer.Action.CodePreview) {
            return reduceCode(previewReducer, ((ItemPreviewReducer.Action.CodePreview) action2).getAction(), state);
        }
        if (action2 instanceof ItemPreviewReducer.Action.Error) {
            return new ReducerResult<>(state, Effect.INSTANCE.merge(PreviewReducerHelpersKt.evaluateFileActions(PreviewReducer.Action.FileActionsAction.INSTANCE, state.getPreviewItem().getItemState()), PreviewReducerHelpersKt.update(PreviewReducer.Action.TopBarAction.INSTANCE, state)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reduceImage(PreviewReducer previewReducer, ImagePreviewReducer.Action action, PreviewReducer.State state) {
        if (Intrinsics.areEqual(action, ImagePreviewReducer.Action.ImageClicked.INSTANCE)) {
            return new ReducerResult<>(state, new Effect(PreviewReducer.Action.ToggleImmersiveMode.INSTANCE));
        }
        if (action instanceof ImagePreviewReducer.Action.CreateAnnotation) {
            return reduceCreateAnnotation(((ImagePreviewReducer.Action.CreateAnnotation) action).getAction(), state);
        }
        if (action instanceof ImagePreviewReducer.Action.Annotations) {
            return reduceAnnotation(((ImagePreviewReducer.Action.Annotations) action).getAction(), state);
        }
        if (action instanceof ImagePreviewReducer.Action.EnterAnnotationCreation) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass1(state, null)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewReducerReducingItemKt$reduceImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewReducerReducingItem.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/preview/PreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewReducerReducingItemKt$reduceImage$1", f = "PreviewReducerReducingItem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super PreviewReducer.Action>, Object> {
        final /* synthetic */ PreviewReducer.State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PreviewReducer.State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super PreviewReducer.Action> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return PreviewReducerHelpersKt.update(PreviewReducer.Action.TopBarAction.INSTANCE, this.$state);
        }
    }

    private static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reduceDocument(PreviewReducer previewReducer, DocumentPreviewReducer.Action action, PreviewReducer.State state) {
        if (Intrinsics.areEqual(action, DocumentPreviewReducer.Action.PageClicked.INSTANCE)) {
            return new ReducerResult<>(state, new Effect(PreviewReducer.Action.ToggleImmersiveMode.INSTANCE));
        }
        if (action instanceof DocumentPreviewReducer.Action.CreateAnnotation) {
            return reduceCreateAnnotation(((DocumentPreviewReducer.Action.CreateAnnotation) action).getAction(), state);
        }
        if (action instanceof DocumentPreviewReducer.Action.Annotations) {
            return reduceAnnotation(((DocumentPreviewReducer.Action.Annotations) action).getAction(), state);
        }
        if (action instanceof DocumentPreviewReducer.Action.EnterAnnotationCreation) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.update(PreviewReducer.Action.TopBarAction.INSTANCE, state)));
        }
        if (action instanceof DocumentPreviewReducer.Action.SwitchDisplayMode) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.evaluateFileActions(PreviewReducer.Action.FileActionsAction.INSTANCE, state.getPreviewItem().getItemState())));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reduceGif(PreviewReducer previewReducer, GifPreviewReducer.Action action, PreviewReducer.State state) {
        if (Intrinsics.areEqual(action, GifPreviewReducer.Action.GifClicked.INSTANCE)) {
            return new ReducerResult<>(state, new Effect(PreviewReducer.Action.ToggleImmersiveMode.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reduceVideo(PreviewReducer previewReducer, VideoPreviewReducer.Action action, PreviewReducer.State state) {
        if (action instanceof VideoPreviewReducer.Action.FrameAnnotation) {
            FrameAnnotationReducer.Action action2 = ((VideoPreviewReducer.Action.FrameAnnotation) action).getAction();
            if (action2 instanceof FrameAnnotationReducer.Action.CreateAnnotation) {
                return reduceCreateAnnotation(((FrameAnnotationReducer.Action.CreateAnnotation) action2).getAction(), state);
            }
            if (action2 instanceof FrameAnnotationReducer.Action.EnterAnnotationCreation) {
                return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.update(PreviewReducer.Action.TopBarAction.INSTANCE, state)));
            }
            if (action2 instanceof FrameAnnotationReducer.Action.Annotations) {
                return reduceAnnotation(((FrameAnnotationReducer.Action.Annotations) action2).getAction(), state);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (Intrinsics.areEqual(action, VideoPreviewReducer.Action.VideoLoaded.INSTANCE)) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.evaluateFileActions(PreviewReducer.Action.FileActionsAction.INSTANCE, state.getPreviewItem().getItemState())));
        }
        if (Intrinsics.areEqual(action, VideoPreviewReducer.Action.VideoClicked.INSTANCE)) {
            return new ReducerResult<>(state, new Effect(PreviewReducer.Action.ToggleImmersiveMode.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reduceCode(PreviewReducer previewReducer, CodePreviewReducer.Action action, PreviewReducer.State state) {
        Effect effectNone;
        if (action instanceof CodePreviewReducer.Action.OnPreviewPressed) {
            return new ReducerResult<>(state, new Effect(PreviewReducer.Action.ToggleImmersiveMode.INSTANCE));
        }
        if (action instanceof CodePreviewReducer.Action.OnPreviewScrolled) {
            if (!state.isImmersiveMode()) {
                effectNone = new Effect(PreviewReducer.Action.ToggleImmersiveMode.INSTANCE);
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reduceCreateAnnotation(CreateAnnotationReducer.Action action, PreviewReducer.State state) {
        if (Intrinsics.areEqual(action, CreateAnnotationReducer.Action.Exit.INSTANCE)) {
            return new ReducerResult<>(state, new Effect(PreviewReducerHelpersKt.update(PreviewReducer.Action.TopBarAction.INSTANCE, state)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reduceAnnotation(AnnotationsReducer.Action action, PreviewReducer.State state) {
        if (action instanceof AnnotationsReducer.Action.ViewComments) {
            return new ReducerResult<>(PreviewReducer.State.copy$default(state, null, null, null, false, null, null, null, null, false, new PreviewRoute.FileActivities(((AnnotationsReducer.Action.ViewComments) action).getAnnotationId(), null, 2, null), false, false, 3583, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
