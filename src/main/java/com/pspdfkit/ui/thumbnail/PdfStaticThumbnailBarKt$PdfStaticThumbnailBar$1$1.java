package com.pspdfkit.ui.thumbnail;

import android.util.Log;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import sdk.pendo.io.actions.configurations.GuideTransition;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1", f = "PdfStaticThumbnailBar.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, nl = {101}, s = {}, v = 2)
public final class PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $onPageChanged;
    final /* synthetic */ ThumbnailBarStateManager $stateManager;
    int label;

    /* JADX INFO: renamed from: com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", GuideTransition.GUIDE_TRANSITION_EFFECT_FIELD, "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1$1", f = "PdfStaticThumbnailBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ThumbnailBarEffect, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Integer, Unit> $onPageChanged;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Integer, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onPageChanged = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onPageChanged, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ThumbnailBarEffect thumbnailBarEffect, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(thumbnailBarEffect, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ThumbnailBarEffect thumbnailBarEffect = (ThumbnailBarEffect) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (thumbnailBarEffect instanceof ThumbnailBarEffect.NavigateToPage) {
                this.$onPageChanged.invoke(Boxing.boxInt(((ThumbnailBarEffect.NavigateToPage) thumbnailBarEffect).getPageIndex()));
            } else if (thumbnailBarEffect instanceof ThumbnailBarEffect.ShowError) {
                Boxing.boxInt(Log.e("ThumbnailBar", ((ThumbnailBarEffect.ShowError) thumbnailBarEffect).getMessage()));
            } else if (!(thumbnailBarEffect instanceof ThumbnailBarEffect.ScrollToPage) && !(thumbnailBarEffect instanceof ThumbnailBarEffect.RequestFocus)) {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1(ThumbnailBarStateManager thumbnailBarStateManager, Function1<? super Integer, Unit> function1, Continuation<? super PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1> continuation) {
        super(2, continuation);
        this.$stateManager = thumbnailBarStateManager;
        this.$onPageChanged = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1(this.$stateManager, this.$onPageChanged, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<ThumbnailBarEffect> effects = this.$stateManager.getEffects();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onPageChanged, null);
            this.label = 1;
            if (FlowKt.collectLatest(effects, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
