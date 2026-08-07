package com.box.android.preview.preview;

import com.box.android.cpl.Effect;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.models.preview.PreviewSourceKt;
import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.item.ItemState;
import com.box.android.preview.preview.previewbar.topbar.TopBarReducer;
import com.box.android.preview.previewtype.audio.AudioPreviewReducer;
import com.box.android.preview.previewtype.code.CodePreviewReducer;
import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import com.box.android.preview.previewtype.gif.GifPreviewReducer;
import com.box.android.preview.previewtype.image.ImagePreviewReducer;
import com.box.android.preview.previewtype.video.VideoPreviewReducer;
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

/* JADX INFO: compiled from: PreviewAnalyticsHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003\u001a&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\n2\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\t¨\u0006\u000b"}, d2 = {"reduceItemPreviewAnalytics", "Lcom/box/android/cpl/ReducerResult;", "Lcom/box/android/preview/item/ItemPreviewReducer$State;", "Lcom/box/android/preview/item/ItemPreviewReducer$Action;", "Lcom/box/android/preview/item/ItemPreviewReducer;", "state", Analytics.Data.ACTION, "reducePreviewAnalytics", "Lcom/box/android/preview/preview/PreviewReducer$State;", "Lcom/box/android/preview/preview/PreviewReducer$Action;", "Lcom/box/android/preview/preview/PreviewReducer;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewAnalyticsHelperKt {
    public static final ReducerResult<ItemPreviewReducer.State, ItemPreviewReducer.Action> reduceItemPreviewAnalytics(ItemPreviewReducer itemPreviewReducer, ItemPreviewReducer.State state, ItemPreviewReducer.Action action) {
        Intrinsics.checkNotNullParameter(itemPreviewReducer, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(action, itemPreviewReducer, state, null)));
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewAnalyticsHelperKt$reduceItemPreviewAnalytics$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewAnalyticsHelper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewAnalyticsHelperKt$reduceItemPreviewAnalytics$1", f = "PreviewAnalyticsHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemPreviewReducer.Action $action;
        final /* synthetic */ ItemPreviewReducer.State $state;
        final /* synthetic */ ItemPreviewReducer $this_reduceItemPreviewAnalytics;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemPreviewReducer.Action action, ItemPreviewReducer itemPreviewReducer, ItemPreviewReducer.State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$action = action;
            this.$this_reduceItemPreviewAnalytics = itemPreviewReducer;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, this.$this_reduceItemPreviewAnalytics, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ItemPreviewReducer.Action action = this.$action;
            if (action instanceof ItemPreviewReducer.Action.Retry) {
                this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewInitiated(this.$state.getFileModel(), "retry");
            } else if (action instanceof ItemPreviewReducer.Action.Ready) {
                this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewScreenRenderingInitiated(this.$state.getFileModel());
            } else if (action instanceof ItemPreviewReducer.Action.Error) {
                this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewError(this.$state.getFileModel());
            } else if (action instanceof ItemPreviewReducer.Action.EnterAnnotationCreation) {
                this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().annotationsTriggered(this.$state.getFileModel());
            } else if (action instanceof ItemPreviewReducer.Action.DocumentPreview) {
                if (((ItemPreviewReducer.Action.DocumentPreview) action).getAction() instanceof DocumentPreviewReducer.Action.DocumentLoaded) {
                    this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewScreenLoaded(this.$state.getFileModel());
                }
            } else if (action instanceof ItemPreviewReducer.Action.ImagePreview) {
                if (((ItemPreviewReducer.Action.ImagePreview) action).getAction() instanceof ImagePreviewReducer.Action.ImageLoaded) {
                    this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewScreenLoaded(this.$state.getFileModel());
                }
            } else if (action instanceof ItemPreviewReducer.Action.GifPreview) {
                if (((ItemPreviewReducer.Action.GifPreview) action).getAction() instanceof GifPreviewReducer.Action.GifLoaded) {
                    this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewScreenLoaded(this.$state.getFileModel());
                }
            } else if (action instanceof ItemPreviewReducer.Action.VideoPreview) {
                if (((ItemPreviewReducer.Action.VideoPreview) action).getAction() instanceof VideoPreviewReducer.Action.VideoLoaded) {
                    this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewScreenLoaded(this.$state.getFileModel());
                }
            } else if (action instanceof ItemPreviewReducer.Action.CodePreview) {
                if (((ItemPreviewReducer.Action.CodePreview) action).getAction() instanceof CodePreviewReducer.Action.OnPreviewLoaded) {
                    this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewScreenLoaded(this.$state.getFileModel());
                }
            } else if (action instanceof ItemPreviewReducer.Action.AudioPreview) {
                if (((ItemPreviewReducer.Action.AudioPreview) action).getAction() instanceof AudioPreviewReducer.Action.Loaded) {
                    this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewScreenLoaded(this.$state.getFileModel());
                }
                if (((ItemPreviewReducer.Action.AudioPreview) this.$action).getAction() instanceof AudioPreviewReducer.Action.Error) {
                    this.$this_reduceItemPreviewAnalytics.getEnvironment().getAnalytics().previewError(this.$state.getFileModel());
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final ReducerResult<PreviewReducer.State, PreviewReducer.Action> reducePreviewAnalytics(PreviewReducer previewReducer, PreviewReducer.State state, PreviewReducer.Action action) {
        Intrinsics.checkNotNullParameter(previewReducer, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C16791(action, previewReducer, state, null)));
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.PreviewAnalyticsHelperKt$reducePreviewAnalytics$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PreviewAnalyticsHelper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.PreviewAnalyticsHelperKt$reducePreviewAnalytics$1", f = "PreviewAnalyticsHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16791 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ PreviewReducer.Action $action;
        final /* synthetic */ PreviewReducer.State $state;
        final /* synthetic */ PreviewReducer $this_reducePreviewAnalytics;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16791(PreviewReducer.Action action, PreviewReducer previewReducer, PreviewReducer.State state, Continuation<? super C16791> continuation) {
            super(1, continuation);
            this.$action = action;
            this.$this_reducePreviewAnalytics = previewReducer;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C16791(this.$action, this.$this_reducePreviewAnalytics, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C16791) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ItemState itemState;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PreviewReducer.Action action = this.$action;
            if (action instanceof PreviewReducer.Action.Initialize) {
                this.$this_reducePreviewAnalytics.getEnvironment().getAnalytics().previewInitiated(this.$state.getFileModel(), PreviewSourceKt.toMetricsName(this.$state.getPreviewSource()));
            } else if (action instanceof PreviewReducer.Action.BackClicked) {
                this.$this_reducePreviewAnalytics.getEnvironment().getAnalytics().closeTriggered(this.$state.getFileModel());
            } else if (action instanceof PreviewReducer.Action.Navigate) {
                this.$this_reducePreviewAnalytics.getEnvironment().getAnalytics().navigationTriggered(this.$state.getFileModel(), ((PreviewReducer.Action.Navigate) this.$action).getRoute());
            } else if (action instanceof PreviewReducer.Action.TopBarAction) {
                if (Intrinsics.areEqual(((PreviewReducer.Action.TopBarAction) action).getAction(), TopBarReducer.Action.ShowMoreActionsMenu.INSTANCE)) {
                    this.$this_reducePreviewAnalytics.getEnvironment().getAnalytics().moreActionsMenuTriggered(this.$state.getFileModel());
                }
            } else if (action instanceof PreviewReducer.Action.SetSelectedItem) {
                if (Intrinsics.areEqual(((PreviewReducer.Action.SetSelectedItem) action).getFileModel().getItemId(), this.$state.getSelectedItemId())) {
                    return Unit.INSTANCE;
                }
                ItemPreviewReducer.State state = (ItemPreviewReducer.State) this.$state.getPreviewItems().getById(((PreviewReducer.Action.SetSelectedItem) this.$action).getFileModel().getItemId());
                if (state == null || (itemState = state.getItemState()) == null) {
                    return Unit.INSTANCE;
                }
                this.$this_reducePreviewAnalytics.getEnvironment().getAnalytics().previewInitiated(itemState.getFileModel(), PreviewNavigationMethodKt.toMetricsName(((PreviewReducer.Action.SetSelectedItem) this.$action).getPreviewNavigationMethod()));
                if ((itemState instanceof ItemState.Document) || (itemState instanceof ItemState.Image) || (itemState instanceof ItemState.Gif) || (itemState instanceof ItemState.Video)) {
                    this.$this_reducePreviewAnalytics.getEnvironment().getAnalytics().previewScreenLoaded(itemState.getFileModel());
                } else if (itemState instanceof ItemState.Error) {
                    this.$this_reducePreviewAnalytics.getEnvironment().getAnalytics().previewError(((ItemState.Error) itemState).getFileModel());
                }
            }
            return Unit.INSTANCE;
        }
    }
}
