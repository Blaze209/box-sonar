package com.pspdfkit.annotations;

import androidx.media3.common.PlaybackException;
import com.pspdfkit.annotations.actions.MediaOptions;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.uw;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MediaAnnotation extends AssetAnnotation {
    private static final MediaWindowType DEFAULT_MEDIA_WINDOW_TYPE = MediaWindowType.USE_ANNOTATION_RECTANGLE;

    public MediaAnnotation(j3 j3Var, boolean z, String str) {
        super(j3Var, z, str);
    }

    public EnumSet<MediaOptions> getMediaOptions() {
        EnumSet<?> enumSetD = this.propertyManager.d(PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED);
        return enumSetD == null ? EnumSet.noneOf(MediaOptions.class) : EnumSet.copyOf((EnumSet) enumSetD);
    }

    public MediaWindowType getWindowMediaType() {
        return MediaWindowType.values()[this.propertyManager.a(7000, DEFAULT_MEDIA_WINDOW_TYPE.ordinal())];
    }

    public void setMediaOptions(EnumSet<MediaOptions> enumSet) {
        uw.a(enumSet, "mediaOptions", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED, enumSet, true);
        j3Var.l();
    }

    public void setWindowMediaType(MediaWindowType mediaWindowType) {
        uw.a(mediaWindowType, "mediaWindowType", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(7000, Integer.valueOf(mediaWindowType.ordinal()), true);
        j3Var.l();
    }
}
