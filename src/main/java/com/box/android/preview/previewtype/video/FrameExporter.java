package com.box.android.preview.previewtype.video;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.content.FileProvider;
import com.box.android.domain.models.item.FileModel;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FrameExporter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/preview/previewtype/video/FrameExporter;", "", "videoPlayersProvider", "Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;", "videoMediaSourceFactory", "Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "<init>", "(Lcom/box/android/preview/previewtype/video/VideoPlayersProvider;Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;)V", "exportCurrentFrame", "Ljava/net/URI;", "file", "Lcom/box/android/domain/models/item/FileModel;", "(Lcom/box/android/domain/models/item/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrameExporter {
    public static final int $stable = 8;
    private final VideoMediaSourceFactory videoMediaSourceFactory;
    private final VideoPlayersProvider videoPlayersProvider;

    @Inject
    public FrameExporter(VideoPlayersProvider videoPlayersProvider, VideoMediaSourceFactory videoMediaSourceFactory) {
        Intrinsics.checkNotNullParameter(videoPlayersProvider, "videoPlayersProvider");
        Intrinsics.checkNotNullParameter(videoMediaSourceFactory, "videoMediaSourceFactory");
        this.videoPlayersProvider = videoPlayersProvider;
        this.videoMediaSourceFactory = videoMediaSourceFactory;
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.FrameExporter$exportCurrentFrame$2, reason: invalid class name */
    /* JADX INFO: compiled from: FrameExporter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/net/URI;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.video.FrameExporter$exportCurrentFrame$2", f = "FrameExporter.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {36, 41}, m = "invokeSuspend", n = {"$this$withContext", "playerView", "player", "mediaItem", "it", "$i$a$-use-FrameExporter$exportCurrentFrame$2$capturedBitmap$1", "$this$withContext", "playerView", "player", "mediaItem", "capturedBitmap", "context"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super URI>, Object> {
        final /* synthetic */ FileModel $file;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FileModel fileModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$file = fileModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = FrameExporter.this.new AnonymousClass2(this.$file, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super URI> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0136, code lost:
        
            if (r13 == r2) goto L35;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.AutoCloseable] */
        /* JADX WARN: Type inference failed for: r0v22 */
        /* JADX WARN: Type inference failed for: r0v23 */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.AutoCloseable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 348
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.previewtype.video.FrameExporter.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.box.android.preview.previewtype.video.FrameExporter$exportCurrentFrame$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FrameExporter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Ljava/net/URI;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.preview.previewtype.video.FrameExporter$exportCurrentFrame$2$1", f = "FrameExporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super URI>, Object> {
            final /* synthetic */ Bitmap $capturedBitmap;
            final /* synthetic */ Context $context;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Context context, Bitmap bitmap, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$context = context;
                this.$capturedBitmap = bitmap;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$context, this.$capturedBitmap, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super URI> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                File file = new File(this.$context.getCacheDir(), "video_frames");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "frame_" + System.currentTimeMillis() + ".jpeg");
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        this.$capturedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        CloseableKt.closeFinally(fileOutputStream, null);
                        Context context = this.$context;
                        URI uriCreate = URI.create(FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file2).toString());
                        this.$capturedBitmap.recycle();
                        return uriCreate;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileOutputStream, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    this.$capturedBitmap.recycle();
                    throw th3;
                }
            }
        }
    }

    public final Object exportCurrentFrame(FileModel fileModel, Continuation<? super URI> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(fileModel, null), continuation);
    }
}
