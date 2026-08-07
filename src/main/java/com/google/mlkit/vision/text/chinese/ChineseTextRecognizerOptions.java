package com.google.mlkit.vision.text.chinese;

import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.vision.text.TextRecognizerOptionsInterface;
import com.google.mlkit.vision.text.internal.TextRecognizerOptionsUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-chinese@@16.0.1 */
/* JADX INFO: loaded from: classes14.dex */
public final class ChineseTextRecognizerOptions implements TextRecognizerOptionsInterface {
    final AtomicReference zza = new AtomicReference();
    private final Executor zzb;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-chinese@@16.0.1 */
    public static class Builder {
        private Executor zza;

        public ChineseTextRecognizerOptions build() {
            return new ChineseTextRecognizerOptions(this.zza, null);
        }

        public Builder setExecutor(Executor executor) {
            this.zza = executor;
            return this;
        }
    }

    /* synthetic */ ChineseTextRecognizerOptions(Executor executor, zza zzaVar) {
        this.zzb = executor;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChineseTextRecognizerOptions) {
            return Objects.equal(this.zzb, ((ChineseTextRecognizerOptions) obj).zzb);
        }
        return false;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getConfigLabel() {
        return "taser_tflite_gocrchinese_and_latin_mbv2_aksara_layout_gcn_mobile";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final Executor getExecutor() {
        return this.zzb;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final boolean getIsThickClient() {
        return TextRecognizerOptionsUtils.isThickClient(this.zza, "com.google.mlkit.dynamite.text.chinese");
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLanguageHint() {
        return "zh";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingEventId() {
        return getIsThickClient() ? 24316 : 24330;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final int getLoggingLanguageOption() {
        return 2;
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryName() {
        return true != getIsThickClient() ? "play-services-mlkit-text-recognition-chinese" : "text-recognition-chinese";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getLoggingLibraryNameForOptionalModule() {
        return "optional-module-text-chinese";
    }

    @Override // com.google.mlkit.vision.text.TextRecognizerOptionsInterface
    public final String getModuleId() {
        return true != getIsThickClient() ? OptionalModuleUtils.OCR_CHINESE_MODULE_ID : "com.google.mlkit.dynamite.text.chinese";
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb);
    }
}
