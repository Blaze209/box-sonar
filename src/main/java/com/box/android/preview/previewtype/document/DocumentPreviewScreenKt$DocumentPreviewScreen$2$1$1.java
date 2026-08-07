package com.box.android.preview.previewtype.document;

import androidx.compose.runtime.State;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DocumentPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.document.DocumentPreviewScreenKt$DocumentPreviewScreen$2$1$1", f = "DocumentPreviewScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class DocumentPreviewScreenKt$DocumentPreviewScreen$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ State<DocumentPreviewReducer.State> $state$delegate;
    int label;

    /* JADX INFO: compiled from: DocumentPreviewScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DisplayMode.values().length];
            try {
                iArr[DisplayMode.Outline.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayMode.Thumbnails.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayMode.FullItem.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocumentPreviewScreenKt$DocumentPreviewScreen$2$1$1(FragmentActivity fragmentActivity, State<DocumentPreviewReducer.State> state, Continuation<? super DocumentPreviewScreenKt$DocumentPreviewScreen$2$1$1> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocumentPreviewScreenKt$DocumentPreviewScreen$2$1$1(this.$activity, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocumentPreviewScreenKt$DocumentPreviewScreen$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$activity == null) {
            return Unit.INSTANCE;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[DocumentPreviewScreenKt.DocumentPreviewScreen$lambda$0(this.$state$delegate).getDisplayMode().ordinal()];
        if (i == 1) {
            DocumentPreviewScreenKt.showOutline(this.$activity);
        } else if (i == 2) {
            DocumentPreviewScreenKt.showThumbnails(this.$activity);
        } else if (i == 3) {
            DocumentPreviewScreenKt.showPageView(this.$activity);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
