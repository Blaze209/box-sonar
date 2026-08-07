package com.pspdfkit.internal;

import android.text.TextUtils;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.sound.EmbeddedAudioSource;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeResourceManager;
import com.pspdfkit.internal.jni.NativeResult;
import com.pspdfkit.utils.PdfLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends k4 {
    public final SoundAnnotation c;
    public EmbeddedAudioSource d;
    public String e;

    public b1(SoundAnnotation soundAnnotation, EmbeddedAudioSource embeddedAudioSource) {
        this.c = soundAnnotation;
        this.d = embeddedAudioSource;
        this.a = true;
        this.b = true;
    }

    @Override // com.pspdfkit.internal.k4
    public final boolean d() {
        EmbeddedAudioSource embeddedAudioSource;
        NativeAnnotation nativeAnnotation;
        lm internalDocument;
        if (!this.c.isAttached() || !this.a || (embeddedAudioSource = this.d) == null || (nativeAnnotation = this.c.getInternal().getNativeAnnotation()) == null || (internalDocument = this.c.getInternal().getInternalDocument()) == null) {
            return false;
        }
        DataProviderShim dataProviderShim = new DataProviderShim(embeddedAudioSource.getDataProvider());
        NativeResourceManager nativeResourceManager = internalDocument.getAnnotationProvider().a.q;
        String strFindResource = nativeResourceManager.findResource(nativeAnnotation);
        if (strFindResource != null) {
            NativeResult resource = nativeResourceManager.setResource(nativeAnnotation, strFindResource, dataProviderShim);
            resource.getClass();
            if (resource.getHasError()) {
                PdfLog.e("Nutri.AnnotationAudRes", "Couldn't attach audio data to sound annotation: %s", resource.getErrorString());
                return false;
            }
            this.e = strFindResource;
        } else {
            String strCreateSoundResource = nativeResourceManager.createSoundResource(nativeAnnotation, dataProviderShim);
            this.e = strCreateSoundResource;
            if (TextUtils.isEmpty(strCreateSoundResource)) {
                PdfLog.e("Nutri.AnnotationAudRes", "Couldn't attach audio data to sound annotation.", new Object[0]);
                return false;
            }
        }
        this.d = null;
        this.a = false;
        return true;
    }

    @Override // com.pspdfkit.internal.k4
    public final boolean e() {
        if (!this.c.isAttached()) {
            return false;
        }
        NativeAnnotation nativeAnnotationRequireNativeAnnotation = this.c.getInternal().requireNativeAnnotation();
        EmbeddedAudioSource embeddedAudioSource = this.d;
        if (embeddedAudioSource != null) {
            lm internalDocument = this.c.getInternal().getInternalDocument();
            if (internalDocument == null) {
                throw new IllegalStateException("Calling this method for a detached annotation is not supported.");
            }
            if (this.a) {
                NativeResourceManager nativeResourceManager = internalDocument.getAnnotationProvider().a.q;
                if (nativeResourceManager.findResource(nativeAnnotationRequireNativeAnnotation) == null) {
                    nativeResourceManager.createSoundResource(nativeAnnotationRequireNativeAnnotation, new DataProviderShim(new rq(new byte[0])));
                }
                j3 properties = this.c.getInternal().getProperties();
                properties.f.a(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB, Integer.valueOf(embeddedAudioSource.getSampleSize()), true);
                properties.l();
                properties.f.a(CameraAccessExceptionCompat.CAMERA_CHARACTERISTICS_CREATION_ERROR, Integer.valueOf(embeddedAudioSource.getSampleRate()), true);
                properties.l();
                properties.f.a(10003, Integer.valueOf(embeddedAudioSource.getChannels()), true);
                properties.l();
                properties.f.a(10004, embeddedAudioSource.getAudioEncoding(), true);
                properties.l();
                return true;
            }
        }
        return false;
    }

    public final byte[] f() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        NativeAnnotation nativeAnnotation = this.c.getInternal().getNativeAnnotation();
        if (nativeAnnotation == null) {
            throw new IllegalStateException("Annotation must be attached to document.");
        }
        lm internalDocument = this.c.getInternal().getInternalDocument();
        if (internalDocument == null) {
            throw new IllegalStateException("Document must not be null.");
        }
        String str = this.e;
        if (str == null) {
            throw new IllegalStateException("Audio resource must be attached to the document.");
        }
        NativeResult resource = internalDocument.getAnnotationProvider().a.q.getResource(internalDocument.y, nativeAnnotation, str, new pt(byteArrayOutputStream));
        resource.getClass();
        if (resource.getHasError()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            throw new IOException(String.format("Couldn't retrieve embedded audio data: %s", Arrays.copyOf(new Object[]{resource.getErrorString()}, 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray.getClass();
        return byteArray;
    }

    public b1(SoundAnnotation soundAnnotation, String str) {
        this.c = soundAnnotation;
        this.e = str;
    }
}
