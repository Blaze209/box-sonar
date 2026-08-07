package com.geniusscansdk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Insets;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BitmapLoader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\n \u0012*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0007¨\u0006\u001a"}, d2 = {"Lcom/geniusscansdk/BitmapLoader;", "", "<init>", "()V", "loadFullScreenBitmap", "Landroid/graphics/Bitmap;", "file", "Ljava/io/File;", "windowManager", "Landroid/view/WindowManager;", "(Ljava/io/File;Landroid/view/WindowManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readBitmapSize", "Lcom/geniusscansdk/Size;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBitmap", "requestedSize", "(Ljava/io/File;Lcom/geniusscansdk/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeBitmapFile", "kotlin.jvm.PlatformType", "options", "Landroid/graphics/BitmapFactory$Options;", "(Ljava/io/File;Landroid/graphics/BitmapFactory$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenSize", "calculateInSampleSize", "", "originalSize", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitmapLoader {

    /* JADX INFO: renamed from: com.geniusscansdk.BitmapLoader$loadBitmap$1, reason: invalid class name */
    /* JADX INFO: compiled from: BitmapLoader.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.BitmapLoader", f = "BitmapLoader.kt", i = {0, 0, 0}, l = {28, 31}, m = "loadBitmap", n = {"this", "file", "requestedSize"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BitmapLoader.this.loadBitmap(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.BitmapLoader$readBitmapSize$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BitmapLoader.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.BitmapLoader", f = "BitmapLoader.kt", i = {0}, l = {23}, m = "readBitmapSize", n = {"options"}, s = {"L$0"})
    static final class C17711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C17711(Continuation<? super C17711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BitmapLoader.this.readBitmapSize(null, this);
        }
    }

    public final Object loadFullScreenBitmap(File file, WindowManager windowManager, Continuation<? super Bitmap> continuation) {
        return loadBitmap(file, getScreenSize(windowManager), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object readBitmapSize(File file, Continuation<? super Size> continuation) {
        C17711 c17711;
        BitmapFactory.Options options;
        if (continuation instanceof C17711) {
            c17711 = (C17711) continuation;
            if ((c17711.label & Integer.MIN_VALUE) != 0) {
                c17711.label -= Integer.MIN_VALUE;
            } else {
                c17711 = new C17711(continuation);
            }
        } else {
            c17711 = new C17711(continuation);
        }
        Object obj = c17711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c17711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            c17711.L$0 = options2;
            c17711.label = 1;
            if (decodeBitmapFile(file, options2, c17711) == coroutine_suspended) {
                return coroutine_suspended;
            }
            options = options2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            options = (BitmapFactory.Options) c17711.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return new Size(options.outWidth, options.outHeight);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if (r8 == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadBitmap(java.io.File r6, com.geniusscansdk.Size r7, kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.geniusscansdk.BitmapLoader.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            com.geniusscansdk.BitmapLoader$loadBitmap$1 r0 = (com.geniusscansdk.BitmapLoader.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.geniusscansdk.BitmapLoader$loadBitmap$1 r0 = new com.geniusscansdk.BitmapLoader$loadBitmap$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L76
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            java.lang.Object r5 = r0.L$2
            r7 = r5
            com.geniusscansdk.Size r7 = (com.geniusscansdk.Size) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.io.File r6 = (java.io.File) r6
            java.lang.Object r5 = r0.L$0
            com.geniusscansdk.BitmapLoader r5 = (com.geniusscansdk.BitmapLoader) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L47:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r5.readBitmapSize(r6, r0)
            if (r8 != r1) goto L59
            goto L75
        L59:
            com.geniusscansdk.Size r8 = (com.geniusscansdk.Size) r8
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            int r7 = r5.calculateInSampleSize(r8, r7)
            r2.inSampleSize = r7
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r5.decodeBitmapFile(r6, r2, r0)
            if (r8 != r1) goto L76
        L75:
            return r1
        L76:
            java.lang.String r5 = "decodeBitmapFile(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geniusscansdk.BitmapLoader.loadBitmap(java.io.File, com.geniusscansdk.Size, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.geniusscansdk.BitmapLoader$decodeBitmapFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: BitmapLoader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.BitmapLoader$decodeBitmapFile$2", f = "BitmapLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ File $file;
        final /* synthetic */ BitmapFactory.Options $options;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(File file, BitmapFactory.Options options, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$file = file;
            this.$options = options;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$file, this.$options, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return BitmapFactory.decodeFile(this.$file.getPath(), this.$options);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object decodeBitmapFile(File file, BitmapFactory.Options options, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(file, options, null), continuation);
    }

    private final Size getScreenSize(WindowManager windowManager) {
        WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
        Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "getInsetsIgnoringVisibility(...)");
        return new Size((currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right, (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom);
    }

    public final int calculateInSampleSize(Size originalSize, Size requestedSize) {
        Intrinsics.checkNotNullParameter(originalSize, "originalSize");
        Intrinsics.checkNotNullParameter(requestedSize, "requestedSize");
        int i = 1;
        if (originalSize.getHeight() <= requestedSize.getHeight() && originalSize.getWidth() <= requestedSize.getWidth()) {
            return 1;
        }
        int height = originalSize.getHeight() / 2;
        int width = originalSize.getWidth() / 2;
        while (height / i >= requestedSize.getHeight() && width / i >= requestedSize.getWidth()) {
            i *= 2;
        }
        return i;
    }
}
