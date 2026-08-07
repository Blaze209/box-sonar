package com.box.android.utilities;

import android.media.MediaScannerConnection;
import android.os.Environment;
import com.box.android.application.BoxBaseApplication;
import com.box.android.domain.identity.Crypto;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public class BoxMediaCaptureUtils {
    private static final int CREATION_MONITOR_PERIOD = 3000;

    public static void deleteCameraCopyOf(final File file) {
        new Thread(new Runnable() { // from class: com.box.android.utilities.BoxMediaCaptureUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                File file2 = file;
                BoxMediaCaptureUtils.deleteCameraCopyOf(file2, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), System.currentTimeMillis() - 3000, Crypto.sha1(new FileInputStream(file2)));
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteCameraCopyOf(File file, File file2, long j, String str) {
        File[] fileArrListFiles;
        if (!file.isFile() || file.getName().length() <= 6 || (fileArrListFiles = file2.listFiles()) == null || fileArrListFiles.length <= 0) {
            return;
        }
        try {
            for (File file3 : fileArrListFiles) {
                if (file3.isFile() && file3.lastModified() > j) {
                    if (str.equals(Crypto.sha1(new FileInputStream(file3)))) {
                        deleteImageFromGallery(file3);
                    }
                } else if (file3.isDirectory() && file3.lastModified() > j) {
                    deleteCameraCopyOf(file, file3, j, str);
                }
            }
        } catch (IOException e) {
            BoxLogUtils.logException(e);
        }
    }

    private static void deleteImageFromGallery(File file) {
        String absolutePath = file.getAbsolutePath();
        if (file.delete()) {
            MediaScannerConnection.scanFile(BoxBaseApplication.getInstance(), new String[]{absolutePath}, null, null);
        }
    }
}
