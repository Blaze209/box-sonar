package com.box.android.preview.boxcanvas;

import com.box.android.coreservices.models.CustomBoxSession;
import com.box.androidsdk.content.models.BoxFile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxCanvasActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1", f = "BoxCanvasActivity.kt", i = {}, l = {49, 57}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxCanvasActivity$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CustomBoxSession $boxSession;
    final /* synthetic */ BoxFile $item;
    final /* synthetic */ String $sharedLinkParameter;
    int label;
    final /* synthetic */ BoxCanvasActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxCanvasActivity$onCreate$1(BoxCanvasActivity boxCanvasActivity, BoxFile boxFile, CustomBoxSession customBoxSession, String str, Continuation<? super BoxCanvasActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = boxCanvasActivity;
        this.$item = boxFile;
        this.$boxSession = customBoxSession;
        this.$sharedLinkParameter = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BoxCanvasActivity$onCreate$1(this.this$0, this.$item, this.$boxSession, this.$sharedLinkParameter, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BoxCanvasActivity$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxCanvasActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1$1", f = "BoxCanvasActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CustomBoxSession $boxSession;
        final /* synthetic */ BoxFile $item;
        final /* synthetic */ String $sharedLinkParameter;
        int label;
        final /* synthetic */ BoxCanvasActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BoxCanvasActivity boxCanvasActivity, BoxFile boxFile, CustomBoxSession customBoxSession, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = boxCanvasActivity;
            this.$item = boxFile;
            this.$boxSession = customBoxSession;
            this.$sharedLinkParameter = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$item, this.$boxSession, this.$sharedLinkParameter, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BoxCanvasActivity boxCanvasActivity = this.this$0;
            BoxCanvasIntentBuilder boxCanvasHelper = boxCanvasActivity.getBoxCanvasHelper();
            BoxCanvasActivity boxCanvasActivity2 = this.this$0;
            String id = this.$item.getUserId();
            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
            String strAccessToken = this.$boxSession.getAuthInfo().accessToken();
            Intrinsics.checkNotNullExpressionValue(strAccessToken, "accessToken(...)");
            boxCanvasActivity.setIntent(boxCanvasHelper.getBoxCanvasLaunchIntent(boxCanvasActivity2, id, strAccessToken, this.$sharedLinkParameter));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1.AnonymousClass2(r10.this$0, null), r10) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5f
        L12:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L1a:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L43
        L1e:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1$1 r4 = new com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1$1
            com.box.android.preview.boxcanvas.BoxCanvasActivity r5 = r10.this$0
            com.box.androidsdk.content.models.BoxFile r6 = r10.$item
            com.box.android.coreservices.models.CustomBoxSession r7 = r10.$boxSession
            java.lang.String r8 = r10.$sharedLinkParameter
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r1 = r10
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r4, r1)
            if (r11 != r0) goto L43
            goto L5e
        L43:
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1$2 r1 = new com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1$2
            com.box.android.preview.boxcanvas.BoxCanvasActivity r3 = r10.this$0
            r4 = 0
            r1.<init>(r3, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = r10
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r10.label = r2
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r11, r1, r3)
            if (r10 != r0) goto L5f
        L5e:
            return r0
        L5f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxCanvasActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.boxcanvas.BoxCanvasActivity$onCreate$1$2", f = "BoxCanvasActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BoxCanvasActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BoxCanvasActivity boxCanvasActivity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = boxCanvasActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
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
            this.this$0.broadcastDismissSpinner();
            BoxCanvasActivity boxCanvasActivity = this.this$0;
            boxCanvasActivity.startActivity(boxCanvasActivity.getIntent());
            return Unit.INSTANCE;
        }
    }
}
