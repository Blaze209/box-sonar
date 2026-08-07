package com.box.android.capture.audiorecording;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: IRecordingFileManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/capture/audiorecording/IRecordingFileManager;", "", "getRecordingFile", "Ljava/io/File;", "getRecordingFileUri", "Landroid/net/Uri;", "getMetadataFile", "deleteRecordingFiles", "", "saveMetadataSample", "sample", "", "hasRecordedFile", "", "prepareAudioRecording", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IRecordingFileManager {
    void deleteRecordingFiles();

    File getMetadataFile();

    File getRecordingFile();

    Uri getRecordingFileUri();

    boolean hasRecordedFile();

    File prepareAudioRecording();

    void saveMetadataSample(double sample);
}
