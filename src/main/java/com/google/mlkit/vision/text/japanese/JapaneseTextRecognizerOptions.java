package com.google.mlkit.vision.text.japanese;

import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;
import com.google.mlkit.vision.text.internal.TextRecognizerOptionsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-japanese@@16.0.1 */
/* JADX INFO: loaded from: classes14.dex */
public final class JapaneseTextRecognizerOptions implements TextRecognizerOptionsInterface {
    final AtomicReference zza = new AtomicReference();
    private final Executor zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-japanese@@16.0.1 */
    public static class Builder {
        private Executor zza;

        public JapaneseTextRecognizerOptions build() {
            return new JapaneseTextRecognizerOptions(this.zza, null);
        }

        public Builder setExecutor(Executor executor) {
            this.zza = executor;
            return this;
        }
    }

    /* synthetic */ JapaneseTextRecognizerOptions(Executor executor, zza zzaVar) {
        this.zzb = executor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof JapaneseTextRecognizerOptions) {
            return Objects.equal(this.zzb, ((JapaneseTextRecognizerOptions) obj).zzb);
        }
        return false;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getConfigLabel() {
        return "taser_tflite_gocrjapanese_and_latin_mbv2_aksara_layout_gcn_mobile";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final Executor getExecutor() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final boolean getIsThickClient() {
        return TextRecognizerOptionsUtils.isThickClient(this.zza, "com.google.mlkit.dynamite.text.japanese");
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLanguageHint() {
        return "ja";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingEventId() {
        return getIsThickClient() ? 24318 : 24332;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingLanguageOption() {
        return 4;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryName() {
        return true != getIsThickClient() ? "play-services-mlkit-text-recognition-japanese" : "text-recognition-japanese";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryNameForOptionalModule() {
        return "optional-module-text-japanese";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getModuleId() {
        return true != getIsThickClient() ? OptionalModuleUtils.OCR_JAPANESE_MODULE_ID : "com.google.mlkit.dynamite.text.japanese";
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb);
    }
}
