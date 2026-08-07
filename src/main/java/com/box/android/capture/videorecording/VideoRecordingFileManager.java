package com.box.android.capture.videorecording;

import com.box.android.capture.CaptureUploadFileManager;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.capture.CaptureMode;
import java.io.File;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoRecordingFileManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/videorecording/VideoRecordingFileManager;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "uploadManager", "Lcom/box/android/capture/CaptureUploadFileManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/capture/CaptureUploadFileManager;)V", "recordingFile", "Ljava/io/File;", "getRecordingFile", "deleteRecordingFiles", "", "hasRecordedFile", "", "prepareVideoRecording", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VideoRecordingFileManager {
    private static final String PENDING_RECORDING_FILE = "PendingRecording.mp4";
    private final File recordingFile;
    private final CaptureUploadFileManager uploadManager;
    public static final int $stable = 8;

    @Inject
    public VideoRecordingFileManager(IUserContextManager userContextManager, CaptureUploadFileManager uploadManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(uploadManager, "uploadManager");
        this.uploadManager = uploadManager;
        this.recordingFile = new File(userContextManager.getPreviewStorage().getMediaProcessingDirectory().getAbsolutePath() + "/PendingRecording.mp4");
    }

    public final File getRecordingFile() {
        return this.recordingFile;
    }

    public final void deleteRecordingFiles() {
        if (this.recordingFile.exists()) {
            this.recordingFile.delete();
        }
    }

    public final boolean hasRecordedFile() {
        return this.recordingFile.length() > 0;
    }

    public final File prepareVideoRecording() {
        File newFile = this.uploadManager.getNewFile(CaptureMode.VIDEO);
        this.recordingFile.renameTo(newFile);
        return newFile;
    }
}
