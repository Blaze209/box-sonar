package com.box.android.capture.audiorecording;

import android.net.Uri;
import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.capture.CaptureMode;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RecordingFileManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/capture/audiorecording/RecordingFileManager;", "Lcom/box/android/capture/audiorecording/IRecordingFileManager;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "uploadManager", "Lcom/box/android/capture/CaptureUploadFileManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/capture/CaptureUploadFileManager;)V", "recordingFile", "Ljava/io/File;", "recordingFileMetadata", "getRecordingFile", "getRecordingFileUri", "Landroid/net/Uri;", "getMetadataFile", "deleteRecordingFiles", "", "saveMetadataSample", "sample", "", "hasRecordedFile", "", "prepareAudioRecording", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecordingFileManager implements IRecordingFileManager {
    private static final String PENDING_RECORDING_FILE = "PendingRecording.m4a";
    private static final String PENDING_RECORDING_FILE_METADATA = "PendingRecording.metadata";
    private File recordingFile;
    private File recordingFileMetadata;
    private final CaptureUploadFileManager uploadManager;
    private final IUserContextManager userContextManager;
    public static final int $stable = 8;

    @Inject
    public RecordingFileManager(IUserContextManager userContextManager, CaptureUploadFileManager uploadManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(uploadManager, "uploadManager");
        this.userContextManager = userContextManager;
        this.uploadManager = uploadManager;
    }

    @Override // com.box.android.capture.audiorecording.IRecordingFileManager
    public File getRecordingFile() {
        if (this.recordingFile == null) {
            this.recordingFile = new File(this.userContextManager.getPreviewStorage().getMediaProcessingDirectory().getAbsolutePath() + "/PendingRecording.m4a");
        }
        File file = this.recordingFile;
        if (file != null) {
            return file;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recordingFile");
        return null;
    }

    @Override // com.box.android.capture.audiorecording.IRecordingFileManager
    public Uri getRecordingFileUri() {
        Uri uri = Uri.parse(getRecordingFile().getAbsolutePath());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        return uri;
    }

    @Override // com.box.android.capture.audiorecording.IRecordingFileManager
    public File getMetadataFile() {
        if (this.recordingFileMetadata == null) {
            this.recordingFileMetadata = new File(this.userContextManager.getPreviewStorage().getMediaProcessingDirectory().getAbsolutePath() + "/PendingRecording.metadata");
        }
        File file = this.recordingFileMetadata;
        if (file != null) {
            return file;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recordingFileMetadata");
        return null;
    }

    @Override // com.box.android.capture.audiorecording.IRecordingFileManager
    public void deleteRecordingFiles() {
        File file = null;
        if (getRecordingFile().exists()) {
            File file2 = this.recordingFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordingFile");
                file2 = null;
            }
            file2.delete();
        }
        if (getMetadataFile().exists()) {
            File file3 = this.recordingFileMetadata;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordingFileMetadata");
            } else {
                file = file3;
            }
            file.delete();
        }
    }

    /* JADX INFO: renamed from: com.box.android.capture.audiorecording.RecordingFileManager$saveMetadataSample$1, reason: invalid class name */
    /* JADX INFO: compiled from: RecordingFileManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.audiorecording.RecordingFileManager$saveMetadataSample$1", f = "RecordingFileManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ double $sample;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(double d, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sample = d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecordingFileManager.this.new AnonymousClass1(this.$sample, continuation);
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
            try {
                File metadataFile = RecordingFileManager.this.getMetadataFile();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%.3f", Arrays.copyOf(new Object[]{Boxing.boxDouble(this.$sample)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FilesKt.appendText$default(metadataFile, str + " ", null, 2, null);
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.capture.audiorecording.IRecordingFileManager
    public void saveMetadataSample(double sample) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(sample, null), 3, null);
    }

    @Override // com.box.android.capture.audiorecording.IRecordingFileManager
    public boolean hasRecordedFile() {
        return getRecordingFile().length() > 0;
    }

    @Override // com.box.android.capture.audiorecording.IRecordingFileManager
    public File prepareAudioRecording() {
        File newFile = this.uploadManager.getNewFile(CaptureMode.AUDIO);
        if (!getRecordingFile().renameTo(newFile)) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "File rename failed");
        }
        return newFile;
    }
}
