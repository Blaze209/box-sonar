package com.google.mlkit.vision.text.devanagari;

import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;
import com.google.mlkit.vision.text.internal.TextRecognizerOptionsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-devanagari@@16.0.1 */
/* JADX INFO: loaded from: classes14.dex */
public final class DevanagariTextRecognizerOptions implements TextRecognizerOptionsInterface {
    final AtomicReference zza = new AtomicReference();
    private final Executor zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-devanagari@@16.0.1 */
    public static class Builder {
        private Executor zza;

        public DevanagariTextRecognizerOptions build() {
            return new DevanagariTextRecognizerOptions(this.zza, null);
        }

        public Builder setExecutor(Executor executor) {
            this.zza = executor;
            return this;
        }
    }

    /* synthetic */ DevanagariTextRecognizerOptions(Executor executor, zza zzaVar) {
        this.zzb = executor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DevanagariTextRecognizerOptions) {
            return Objects.equal(this.zzb, ((DevanagariTextRecognizerOptions) obj).zzb);
        }
        return false;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getConfigLabel() {
        return "taser_tflite_gocrdevanagari_and_latin_mbv2_aksara_layout_gcn_mobile";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final Executor getExecutor() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final boolean getIsThickClient() {
        return TextRecognizerOptionsUtils.isThickClient(this.zza, "com.google.mlkit.dynamite.text.devanagari");
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLanguageHint() {
        return "hi";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingEventId() {
        return getIsThickClient() ? 24320 : 24331;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingLanguageOption() {
        return 3;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryName() {
        return true != getIsThickClient() ? "play-services-mlkit-text-recognition-devanagari" : "text-recognition-devanagari";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryNameForOptionalModule() {
        return "optional-module-text-devanagari";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getModuleId() {
        return true != getIsThickClient() ? OptionalModuleUtils.OCR_DEVANAGARI_MODULE_ID : "com.google.mlkit.dynamite.text.devanagari";
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb);
    }
}
