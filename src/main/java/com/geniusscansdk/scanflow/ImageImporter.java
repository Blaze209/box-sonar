package com.geniusscansdk.scanflow;

import android.content.Context;
import android.net.Uri;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ImageImporter.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/geniusscansdk/scanflow/ImageImporter;", "", "<init>", "()V", "copyImageToFile", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Landroid/net/Uri;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageImporter {
    public static final ImageImporter INSTANCE = new ImageImporter();

    private ImageImporter() {
    }

    /* JADX INFO: renamed from: com.geniusscansdk.scanflow.ImageImporter$copyImageToFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: ImageImporter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.scanflow.ImageImporter$copyImageToFile$2", f = "ImageImporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Uri uri, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$uri = uri;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, this.$uri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            File fileGenerateImageFile = new ImageStore(this.$context).generateImageFile("jpeg");
            FileOutputStream fileOutputStream = new FileOutputStream(fileGenerateImageFile);
            Context context = this.$context;
            try {
                FileOutputStream fileOutputStream2 = fileOutputStream;
                InputStream inputStreamOpenInputStream = MAMContentResolverManagement.openInputStream(context.getContentResolver(), this.$uri);
                try {
                    InputStream inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        Boxing.boxLong(ByteStreamsKt.copyTo$default(inputStream, fileOutputStream2, 0, 2, null));
                    }
                    CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return fileGenerateImageFile;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(inputStreamOpenInputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(fileOutputStream, th3);
                    throw th4;
                }
            }
        }
    }

    public final Object copyImageToFile(Uri uri, Context context, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, uri, null), continuation);
    }
}
