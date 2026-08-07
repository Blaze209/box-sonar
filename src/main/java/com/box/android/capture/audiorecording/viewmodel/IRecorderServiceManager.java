package com.box.android.capture.audiorecording.viewmodel;

import android.content.Context;
import android.content.ServiceConnection;
import androidx.media3.common.MimeTypes;
import com.box.android.capture.audiorecording.RecorderService;
import kotlin.Metadata;

/* JADX INFO: compiled from: IRecorderServiceManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/capture/audiorecording/viewmodel/IRecorderServiceManager;", "", "bindService", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "folderId", "", RecorderService.EXTRA_NOTIFICATION_TARGET_CLASS, "Ljava/lang/Class;", "serviceConnection", "Landroid/content/ServiceConnection;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IRecorderServiceManager {
    void bindService(Context application, String folderId, Class<?> notificationTargetClass, ServiceConnection serviceConnection);
}
