package com.geniusscansdk.scanflow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EditFilterFragment.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.geniusscansdk.scanflow.EditFilterFragment$FilterViewHolder$bindData$3", f = "EditFilterFragment.kt", i = {}, l = {103, 104}, m = "invokeSuspend", n = {}, s = {})
final class EditFilterFragment$FilterViewHolder$bindData$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Page $page;
    int label;
    final /* synthetic */ EditFilterFragment this$0;
    final /* synthetic */ EditFilterFragment.FilterViewHolder this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditFilterFragment$FilterViewHolder$bindData$3(EditFilterFragment editFilterFragment, Page page, EditFilterFragment.FilterViewHolder filterViewHolder, Continuation<? super EditFilterFragment$FilterViewHolder$bindData$3> continuation) {
        super(2, continuation);
        this.this$0 = editFilterFragment;
        this.$page = page;
        this.this$1 = filterViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditFilterFragment$FilterViewHolder$bindData$3(this.this$0, this.$page, this.this$1, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditFilterFragment$FilterViewHolder$bindData$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
    
        if (r8 == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6f
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4b
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            com.geniusscansdk.scanflow.EditFilterFragment r8 = r7.this$0
            android.content.res.Resources r8 = r8.getResources()
            int r1 = com.geniusscansdk.R.dimen.filter_preview_size
            int r8 = r8.getDimensionPixelSize(r1)
            int r8 = r8 * 3
            com.geniusscansdk.BitmapLoader r1 = new com.geniusscansdk.BitmapLoader
            r1.<init>()
            com.geniusscansdk.scanflow.Page r4 = r7.$page
            java.io.File r4 = r4.getOriginalImage()
            com.geniusscansdk.Size r5 = new com.geniusscansdk.Size
            r5.<init>(r8, r8)
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.label = r3
            java.lang.Object r8 = r1.loadBitmap(r4, r5, r8)
            if (r8 != r0) goto L4b
            goto L6e
        L4b:
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            com.geniusscansdk.scanflow.EditFilterFragment r1 = r7.this$0
            com.geniusscansdk.scanflow.PageProcessor r1 = com.geniusscansdk.scanflow.EditFilterFragment.access$getPageProcessor$p(r1)
            if (r1 != 0) goto L5b
            java.lang.String r1 = "pageProcessor"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = 0
        L5b:
            com.geniusscansdk.scanflow.Page r4 = r7.$page
            com.geniusscansdk.scanflow.EditFilterFragment$FilterViewHolder r5 = r7.this$1
            com.geniusscansdk.scanflow.ScanConfiguration$Filter r5 = com.geniusscansdk.scanflow.EditFilterFragment.FilterViewHolder.access$getFilter$p(r5)
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.label = r2
            java.lang.Object r8 = r1.processImageWithFilter(r4, r5, r8, r6)
            if (r8 != r0) goto L6f
        L6e:
            return r0
        L6f:
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            com.geniusscansdk.scanflow.EditFilterFragment$FilterViewHolder r0 = r7.this$1
            android.widget.ImageView r0 = com.geniusscansdk.scanflow.EditFilterFragment.FilterViewHolder.access$getImageView$p(r0)
            r0.setImageBitmap(r8)
            com.geniusscansdk.scanflow.EditFilterFragment$FilterViewHolder r8 = r7.this$1
            android.widget.ImageView r8 = com.geniusscansdk.scanflow.EditFilterFragment.FilterViewHolder.access$getImageView$p(r8)
            r8.setClipToOutline(r3)
            com.geniusscansdk.scanflow.EditFilterFragment$FilterViewHolder r8 = r7.this$1
            android.widget.ImageView r8 = com.geniusscansdk.scanflow.EditFilterFragment.FilterViewHolder.access$getImageView$p(r8)
            com.geniusscansdk.scanflow.EditFilterFragment r7 = r7.this$0
            android.content.Context r7 = r7.requireContext()
            int r0 = com.geniusscansdk.R.drawable.filter_view_background
            android.graphics.drawable.Drawable r7 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r7, r0)
            r8.setForeground(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.scanflow.EditFilterFragment$FilterViewHolder$bindData$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
