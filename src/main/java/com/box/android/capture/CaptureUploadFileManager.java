package com.box.android.capture;

import android.content.SharedPreferences;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.models.capture.CaptureMode;
import com.box.androidsdk.content.models.BoxRepresentation;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CaptureUploadFileManager.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/capture/CaptureUploadFileManager;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "captureSharedPrefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getNewFile", "Ljava/io/File;", "captureMode", "Lcom/box/android/domain/models/capture/CaptureMode;", "getAndIncrementCounter", "", "resetSuffixIfNeeded", "", "Companion", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureUploadFileManager {
    private static final String AUDIO_NUM_SUFFIX_KEY = "audioNumSuffixKey";
    private static final String DATE_KEY = "dateKey";
    private static final String PHOTO_NUM_SUFFIX_KEY = "photoNumSuffixKey";
    private static final String SCAN_NUM_SUFFIX_KEY = "scanNumSuffixKey";
    private static final String SHARED_PREF_DATE_FORMAT = "yyyyMMdd";
    private static final String VIDEO_NUM_SUFFIX_KEY = "videoNumSuffixKey";
    private final SharedPreferences captureSharedPrefs;
    private final IUserContextManager userContextManager;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CaptureUploadFileManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CaptureMode.values().length];
            try {
                iArr[CaptureMode.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CaptureMode.SCAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CaptureMode.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CaptureMode.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public CaptureUploadFileManager(IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.userContextManager = userContextManager;
        this.captureSharedPrefs = userContextManager.getUserSharedPrefs(ILocalSharedPreferences.PreferenceName.CAPTURE);
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final File getNewFile(CaptureMode captureMode) {
        String str;
        Intrinsics.checkNotNullParameter(captureMode, "captureMode");
        resetSuffixIfNeeded();
        int andIncrementCounter = getAndIncrementCounter(captureMode);
        int i = WhenMappings.$EnumSwitchMapping$0[captureMode.ordinal()];
        if (i == 1) {
            str = BoxRepresentation.TYPE_JPG;
        } else if (i == 2) {
            str = "pdf";
        } else if (i == 3) {
            str = "m4a";
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            str = BoxRepresentation.TYPE_MP4;
        }
        File file = new File(this.userContextManager.getPreviewStorage().getPendingUploadDirectory(), CommonBoxUtil.getTimestampedName$default(null, StringsKt.padStart(String.valueOf(andIncrementCounter), 3, '0'), str, null, 9, null));
        if (file.length() <= 0) {
            return file;
        }
        throw new IllegalStateException("File exists unexpectedly");
    }

    private final int getAndIncrementCounter(CaptureMode captureMode) {
        String str;
        int i = WhenMappings.$EnumSwitchMapping$0[captureMode.ordinal()];
        if (i == 1) {
            str = PHOTO_NUM_SUFFIX_KEY;
        } else if (i == 2) {
            str = SCAN_NUM_SUFFIX_KEY;
        } else if (i == 3) {
            str = AUDIO_NUM_SUFFIX_KEY;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            str = VIDEO_NUM_SUFFIX_KEY;
        }
        int i2 = this.captureSharedPrefs.getInt(str, 1);
        SharedPreferences.Editor editorEdit = this.captureSharedPrefs.edit();
        editorEdit.putInt(str, i2 + 1);
        editorEdit.apply();
        return i2;
    }

    public final void resetSuffixIfNeeded() {
        String string = this.captureSharedPrefs.getString(DATE_KEY, null);
        String string2 = new SimpleDateFormat(SHARED_PREF_DATE_FORMAT, Locale.US).format(new Date()).toString();
        if (Intrinsics.areEqual(string, string2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.captureSharedPrefs.edit();
        editorEdit.putString(DATE_KEY, string2);
        editorEdit.remove(PHOTO_NUM_SUFFIX_KEY);
        editorEdit.remove(VIDEO_NUM_SUFFIX_KEY);
        editorEdit.remove(AUDIO_NUM_SUFFIX_KEY);
        editorEdit.remove(SCAN_NUM_SUFFIX_KEY);
        editorEdit.apply();
    }
}
