package com.box.android.capture.imagecapture.logic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ImageCaptureHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/capture/imagecapture/logic/ImageCaptureHelper;", "Lcom/box/android/capture/imagecapture/logic/IImageCaptureHelper;", "<init>", "()V", "compressImage", "Ljava/io/File;", "file", "compressionRate", "", "(Ljava/io/File;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageCaptureHelper implements IImageCaptureHelper {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: com.box.android.capture.imagecapture.logic.ImageCaptureHelper$compressImage$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImageCaptureHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.imagecapture.logic.ImageCaptureHelper", f = "ImageCaptureHelper.kt", i = {0, 0, 0}, l = {23}, m = "compressImage", n = {"file", "options", "compressionRate"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ImageCaptureHelper.this.compressImage(null, 0, this);
        }
    }

    @Inject
    public ImageCaptureHelper() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.capture.imagecapture.logic.IImageCaptureHelper
    public Object compressImage(File file, int i, Continuation<? super File> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = anonymousClass1.I$0;
            File file2 = (File) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            return file2;
        }
        ResultKt.throwOnFailure(obj);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        CoroutineDispatcher io2 = Dispatchers.getIO();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(file, options, i, null);
        anonymousClass1.L$0 = file;
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(options);
        anonymousClass1.I$0 = i;
        anonymousClass1.label = 1;
        return BuildersKt.withContext(io2, anonymousClass2, anonymousClass1) == coroutine_suspended ? coroutine_suspended : file;
    }

    /* JADX INFO: renamed from: com.box.android.capture.imagecapture.logic.ImageCaptureHelper$compressImage$2, reason: invalid class name */
    /* JADX INFO: compiled from: ImageCaptureHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.imagecapture.logic.ImageCaptureHelper$compressImage$2", f = "ImageCaptureHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $compressionRate;
        final /* synthetic */ File $file;
        final /* synthetic */ BitmapFactory.Options $options;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(File file, BitmapFactory.Options options, int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$file = file;
            this.$options = options;
            this.$compressionRate = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$file, this.$options, this.$compressionRate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ExifInterface exifInterface = new ExifInterface(this.$file.getAbsolutePath());
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.$file.getAbsolutePath(), this.$options);
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.$file, false);
                    try {
                        bitmapDecodeFile.compress(Bitmap.CompressFormat.JPEG, this.$compressionRate, fileOutputStream2);
                        fileOutputStream2.close();
                        bitmapDecodeFile.recycle();
                        exifInterface.saveAttributes();
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                        fileOutputStream = fileOutputStream2;
                        BoxLogUtils.w("Failed to compress bitmap, uncompressed image will be reviewed.");
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException unused2) {
                }
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}
