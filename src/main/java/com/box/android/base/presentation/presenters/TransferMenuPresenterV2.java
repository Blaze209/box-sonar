package com.box.android.base.presentation.presenters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.box.android.base.R;
import com.box.android.common.utilities.CommonBoxUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: TransferMenuPresenterV2.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/presentation/presenters/TransferMenuPresenterV2;", "", "transferProgressView", "Lcom/box/android/base/presentation/presenters/TransferMenuPresenterV2$TransferMenuProgressView;", "<init>", "(Lcom/box/android/base/presentation/presenters/TransferMenuPresenterV2$TransferMenuProgressView;)V", "getTransferProgressView", "()Lcom/box/android/base/presentation/presenters/TransferMenuPresenterV2$TransferMenuProgressView;", "setTransferProgressView", "updateProgress", "", "progress", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatus", "color", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TransferMenuProgressView", "TransferProgressView", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TransferMenuPresenterV2 {
    public static final int $stable = 8;
    private TransferMenuProgressView transferProgressView;

    /* JADX INFO: compiled from: TransferMenuPresenterV2.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/presenters/TransferMenuPresenterV2$TransferProgressView;", "", "setStatusIndicator", "", "color", "", "(Ljava/lang/Integer;)V", "setProgress", "progress", "toggleProgressAndStatusIndicator", "shouldShow", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface TransferProgressView {
        void setProgress(int progress);

        void setStatusIndicator(Integer color);

        void toggleProgressAndStatusIndicator(boolean shouldShow);
    }

    public TransferMenuPresenterV2(TransferMenuProgressView transferProgressView) {
        Intrinsics.checkNotNullParameter(transferProgressView, "transferProgressView");
        this.transferProgressView = transferProgressView;
    }

    public final TransferMenuProgressView getTransferProgressView() {
        return this.transferProgressView;
    }

    public final void setTransferProgressView(TransferMenuProgressView transferMenuProgressView) {
        Intrinsics.checkNotNullParameter(transferMenuProgressView, "<set-?>");
        this.transferProgressView = transferMenuProgressView;
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.presenters.TransferMenuPresenterV2$updateProgress$2, reason: invalid class name */
    /* JADX INFO: compiled from: TransferMenuPresenterV2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.presenters.TransferMenuPresenterV2$updateProgress$2", f = "TransferMenuPresenterV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $progress;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$progress = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransferMenuPresenterV2.this.new AnonymousClass2(this.$progress, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TransferMenuPresenterV2.this.getTransferProgressView().setProgress(this.$progress);
            return Unit.INSTANCE;
        }
    }

    public final Object updateProgress(int i, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(i, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.presenters.TransferMenuPresenterV2$updateStatus$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransferMenuPresenterV2.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.presenters.TransferMenuPresenterV2$updateStatus$2", f = "TransferMenuPresenterV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $color;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09332(Integer num, Continuation<? super C09332> continuation) {
            super(2, continuation);
            this.$color = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TransferMenuPresenterV2.this.new C09332(this.$color, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TransferMenuPresenterV2.this.getTransferProgressView().setStatusIndicator(this.$color);
            return Unit.INSTANCE;
        }
    }

    public final Object updateStatus(Integer num, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new C09332(num, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: TransferMenuPresenterV2.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/presenters/TransferMenuPresenterV2$TransferMenuProgressView;", "Lcom/box/android/base/presentation/presenters/TransferMenuPresenterV2$TransferProgressView;", "transferActionView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "progressBar", "Landroid/widget/ProgressBar;", "statusIndicator", "Landroid/widget/ImageView;", "progressContainer", "Landroid/widget/FrameLayout;", "setStatusIndicator", "", "color", "", "(Ljava/lang/Integer;)V", "setProgress", "progress", "toggleProgressAndStatusIndicator", "shouldShow", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TransferMenuProgressView implements TransferProgressView {
        public static final int $stable = 8;
        private final ProgressBar progressBar;
        private final FrameLayout progressContainer;
        private final ImageView statusIndicator;

        public TransferMenuProgressView(View transferActionView) {
            Intrinsics.checkNotNullParameter(transferActionView, "transferActionView");
            View viewFindViewById = transferActionView.findViewById(R.id.transfer_menu_progress);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ProgressBar");
            this.progressBar = (ProgressBar) viewFindViewById;
            View viewFindViewById2 = transferActionView.findViewById(R.id.transfer_menu_status_indicator);
            Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ImageView");
            this.statusIndicator = (ImageView) viewFindViewById2;
            View viewFindViewById3 = transferActionView.findViewById(R.id.transfer_menu_progress_container);
            Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.FrameLayout");
            this.progressContainer = (FrameLayout) viewFindViewById3;
            toggleProgressAndStatusIndicator(false);
        }

        @Override // com.box.android.base.presentation.presenters.TransferMenuPresenterV2.TransferProgressView
        public void setStatusIndicator(Integer color) {
            if (color != null) {
                Drawable background = this.statusIndicator.getBackground();
                if (background instanceof GradientDrawable) {
                    Context context = this.statusIndicator.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    ((GradientDrawable) background).setColor(CommonBoxUtil.getColorFromAttribute(context, color.intValue()));
                }
            }
            toggleProgressAndStatusIndicator(color != null);
        }

        @Override // com.box.android.base.presentation.presenters.TransferMenuPresenterV2.TransferProgressView
        public void setProgress(int progress) {
            this.progressBar.setProgress(progress);
        }

        @Override // com.box.android.base.presentation.presenters.TransferMenuPresenterV2.TransferProgressView
        public void toggleProgressAndStatusIndicator(boolean shouldShow) {
            if (shouldShow) {
                this.progressContainer.setVisibility(0);
            } else {
                this.progressContainer.setVisibility(8);
            }
        }
    }
}
