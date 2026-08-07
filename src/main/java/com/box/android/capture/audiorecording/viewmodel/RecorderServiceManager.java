package com.box.android.capture.audiorecording.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.media3.common.MimeTypes;
import com.box.android.capture.audiorecording.RecorderService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecorderServiceManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/box/android/capture/audiorecording/viewmodel/RecorderServiceManager;", "Lcom/box/android/capture/audiorecording/viewmodel/IRecorderServiceManager;", "<init>", "()V", "bindService", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/content/Context;", "folderId", "", RecorderService.EXTRA_NOTIFICATION_TARGET_CLASS, "Ljava/lang/Class;", "serviceConnection", "Landroid/content/ServiceConnection;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecorderServiceManager implements IRecorderServiceManager {
    public static final int $stable = 0;

    @Inject
    public RecorderServiceManager() {
    }

    @Override // com.box.android.capture.audiorecording.viewmodel.IRecorderServiceManager
    public void bindService(Context application, String folderId, Class<?> notificationTargetClass, ServiceConnection serviceConnection) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(notificationTargetClass, "notificationTargetClass");
        Intrinsics.checkNotNullParameter(serviceConnection, "serviceConnection");
        Intent intent = new Intent(application, (Class<?>) RecorderService.class);
        intent.putExtra("folderId", folderId);
        intent.putExtra(RecorderService.EXTRA_NOTIFICATION_TARGET_CLASS, notificationTargetClass);
        application.bindService(intent, serviceConnection, 1);
    }
}
