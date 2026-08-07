package com.google.mlkit.vision.text.korean;

import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;
import com.google.mlkit.vision.text.internal.TextRecognizerOptionsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-korean@@16.0.1 */
/* JADX INFO: loaded from: classes14.dex */
public final class KoreanTextRecognizerOptions implements TextRecognizerOptionsInterface {
    final AtomicReference zza = new AtomicReference();
    private final Executor zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-korean@@16.0.1 */
    public static class Builder {
        private Executor zza;

        public KoreanTextRecognizerOptions build() {
            return new KoreanTextRecognizerOptions(this.zza, null);
        }

        public Builder setExecutor(Executor executor) {
            this.zza = executor;
            return this;
        }
    }

    /* synthetic */ KoreanTextRecognizerOptions(Executor executor, zza zzaVar) {
        this.zzb = executor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof KoreanTextRecognizerOptions) {
            return Objects.equal(this.zzb, ((KoreanTextRecognizerOptions) obj).zzb);
        }
        return false;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getConfigLabel() {
        return "taser_tflite_gocrkorean_and_latin_mbv2_aksara_layout_gcn_mobile";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final Executor getExecutor() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final boolean getIsThickClient() {
        return TextRecognizerOptionsUtils.isThickClient(this.zza, "com.google.mlkit.dynamite.text.korean");
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLanguageHint() {
        return "ko";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingEventId() {
        return getIsThickClient() ? 24319 : 24333;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingLanguageOption() {
        return 5;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryName() {
        return true != getIsThickClient() ? "play-services-mlkit-text-recognition-korean" : "text-recognition-korean";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryNameForOptionalModule() {
        return "optional-module-text-korean";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getModuleId() {
        return true != getIsThickClient() ? OptionalModuleUtils.OCR_KOREAN_MODULE_ID : "com.google.mlkit.dynamite.text.korean";
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb);
    }
}
