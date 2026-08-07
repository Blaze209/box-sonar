package com.pspdfkit.annotations;

import android.graphics.RectF;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import com.pspdfkit.annotations.sound.AudioEncoding;
import com.pspdfkit.annotations.sound.EmbeddedAudioSource;
import com.pspdfkit.internal.b1;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.k4;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Supplier;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class SoundAnnotation extends Annotation {
    public static final String ICON_NAME_MIC = "Mic";
    public static final String ICON_NAME_SPEAKER = "Speaker";
    private final String LOG_TAG;
    private b1 audioResource;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconName {
    }

    public SoundAnnotation(int i, RectF rectF, EmbeddedAudioSource embeddedAudioSource) {
        this(i, rectF);
        uw.a(embeddedAudioSource, "audioSource", null);
        setContents(embeddedAudioSource.getDescription());
        b1 b1Var = new b1(this, embeddedAudioSource);
        this.audioResource = b1Var;
        this.propertyManager.a(b1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ MaybeSource lambda$getAudioDataAsync$0() throws Throwable {
        b1 b1Var = this.audioResource;
        byte[] bArrF = b1Var != null ? b1Var.f() : null;
        return bArrF != null ? Maybe.just(bArrF) : Maybe.empty();
    }

    public byte[] getAudioData() {
        if (!hasAudioData()) {
            return null;
        }
        try {
            return this.audioResource.f();
        } catch (IOException e) {
            PdfLog.e("Nutri.SoundAnnotation", e, "Can't retrieve audio data.", new Object[0]);
            return null;
        }
    }

    public Maybe<byte[]> getAudioDataAsync() {
        return Maybe.defer(new Supplier() { // from class: com.pspdfkit.annotations.SoundAnnotation$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.lambda$getAudioDataAsync$0();
            }
        });
    }

    public AudioEncoding getAudioEncoding() {
        return (AudioEncoding) this.propertyManager.a(10004, AudioEncoding.SIGNED);
    }

    public int getChannels() {
        return this.propertyManager.a(10003, 1);
    }

    public String getIconName() {
        String strG = this.propertyManager.g(4000);
        return strG == null ? ICON_NAME_SPEAKER : strG;
    }

    public int getSampleRate() {
        return this.propertyManager.a(CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR, 0);
    }

    public int getSampleSize() {
        return this.propertyManager.a(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB, 16);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.SOUND;
    }

    public boolean hasAudioData() {
        b1 b1Var = this.audioResource;
        return (b1Var == null || !b1Var.c.isAttached() || b1Var.e == null) ? false : true;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public boolean isLocked() {
        return false;
    }

    @Override // com.pspdfkit.annotations.Annotation
    /* JADX INFO: renamed from: isResizable */
    public boolean getIsResizable() {
        return false;
    }

    public void setAudioSource(EmbeddedAudioSource embeddedAudioSource) {
        synchronized (this) {
            try {
                if (embeddedAudioSource == null) {
                    this.audioResource = null;
                    this.propertyManager.a((k4) null);
                } else {
                    b1 b1Var = new b1(this, embeddedAudioSource);
                    this.audioResource = b1Var;
                    this.propertyManager.a(b1Var);
                    if (embeddedAudioSource.getDescription() != null) {
                        setContents(embeddedAudioSource.getDescription());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setIconName(String str) {
        uw.a(str, str, "Annotation icon name must not be null.");
        j3 j3Var = this.propertyManager;
        j3Var.f.a(4000, str, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
    }

    public SoundAnnotation(int i, RectF rectF) {
        super(i);
        this.LOG_TAG = "Nutri.SoundAnnotation";
        uw.a(rectF, "boundingBox", null);
        setBoundingBox(rectF);
        setIconName(ICON_NAME_SPEAKER);
    }

    public SoundAnnotation(j3 j3Var, boolean z, String str) {
        super(j3Var, z);
        this.LOG_TAG = "Nutri.SoundAnnotation";
        if (str != null) {
            b1 b1Var = new b1(this, str);
            this.audioResource = b1Var;
            this.propertyManager.a(b1Var);
        }
    }

    public SoundAnnotation(j3 j3Var, boolean z, EmbeddedAudioSource embeddedAudioSource) {
        super(j3Var, z);
        this.LOG_TAG = "Nutri.SoundAnnotation";
        if (embeddedAudioSource != null) {
            b1 b1Var = new b1(this, embeddedAudioSource);
            this.audioResource = b1Var;
            this.propertyManager.a(b1Var);
        }
    }
}
