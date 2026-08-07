package com.box.android.capture.di;

import android.media.MediaActionSound;
import com.box.android.capture.CaptureShutterSoundHelper;
import com.box.android.capture.ICaptureShutterSoundHelper;
import com.box.android.capture.audiorecording.IRecordingFileManager;
import com.box.android.capture.audiorecording.RecordingFileManager;
import com.box.android.capture.audiorecording.logic.AudioRecordingHelper;
import com.box.android.capture.audiorecording.logic.IAudioRecordingHelper;
import com.box.android.capture.audiorecording.viewmodel.IRecorderServiceManager;
import com.box.android.capture.audiorecording.viewmodel.RecorderServiceManager;
import com.box.android.capture.documentscanning.logic.DocumentScanPageProcessor;
import com.box.android.capture.documentscanning.logic.DocumentScanningHelper;
import com.box.android.capture.documentscanning.logic.IDocumentScanningHelper;
import com.box.android.capture.imagecapture.logic.IImageCaptureHelper;
import com.box.android.capture.imagecapture.logic.ImageCaptureHelper;
import com.box.android.domain.services.IDocumentScanPageProcessor;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CaptureModule.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH'J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH'¨\u0006!"}, d2 = {"Lcom/box/android/capture/di/CaptureModule;", "", "<init>", "()V", "provideRecorderServiceManager", "Lcom/box/android/capture/audiorecording/viewmodel/IRecorderServiceManager;", "recorderServiceManager", "Lcom/box/android/capture/audiorecording/viewmodel/RecorderServiceManager;", "provideRecordingFileManager", "Lcom/box/android/capture/audiorecording/IRecordingFileManager;", "recordingFileManager", "Lcom/box/android/capture/audiorecording/RecordingFileManager;", "provideAudioRecordingHelper", "Lcom/box/android/capture/audiorecording/logic/IAudioRecordingHelper;", "audioRecordingHelper", "Lcom/box/android/capture/audiorecording/logic/AudioRecordingHelper;", "provideScannedPageProcessor", "Lcom/box/android/domain/services/IDocumentScanPageProcessor;", "documentScanPageProcessor", "Lcom/box/android/capture/documentscanning/logic/DocumentScanPageProcessor;", "provideDocumentScanningHelper", "Lcom/box/android/capture/documentscanning/logic/IDocumentScanningHelper;", "documentScanningHelper", "Lcom/box/android/capture/documentscanning/logic/DocumentScanningHelper;", "provideImageCaptureHelper", "Lcom/box/android/capture/imagecapture/logic/IImageCaptureHelper;", "imageCaptureHelper", "Lcom/box/android/capture/imagecapture/logic/ImageCaptureHelper;", "provideCaptureHelper", "Lcom/box/android/capture/ICaptureShutterSoundHelper;", "captureShutterSoundHelper", "Lcom/box/android/capture/CaptureShutterSoundHelper;", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class CaptureModule {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Binds
    public abstract IAudioRecordingHelper provideAudioRecordingHelper(AudioRecordingHelper audioRecordingHelper);

    @Binds
    public abstract ICaptureShutterSoundHelper provideCaptureHelper(CaptureShutterSoundHelper captureShutterSoundHelper);

    @Binds
    public abstract IDocumentScanningHelper provideDocumentScanningHelper(DocumentScanningHelper documentScanningHelper);

    @Binds
    public abstract IImageCaptureHelper provideImageCaptureHelper(ImageCaptureHelper imageCaptureHelper);

    @Binds
    public abstract IRecorderServiceManager provideRecorderServiceManager(RecorderServiceManager recorderServiceManager);

    @Binds
    public abstract IRecordingFileManager provideRecordingFileManager(RecordingFileManager recordingFileManager);

    @Binds
    public abstract IDocumentScanPageProcessor provideScannedPageProcessor(DocumentScanPageProcessor documentScanPageProcessor);

    /* JADX INFO: compiled from: CaptureModule.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/box/android/capture/di/CaptureModule$Companion;", "", "<init>", "()V", "provideMediaActionSound", "Landroid/media/MediaActionSound;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        public final MediaActionSound provideMediaActionSound() {
            return new MediaActionSound();
        }
    }
}
