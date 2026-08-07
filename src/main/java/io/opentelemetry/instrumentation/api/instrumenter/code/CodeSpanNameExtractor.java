package io.opentelemetry.instrumentation.api.instrumenter.code;

import androidx.camera.core.CameraInfo;
import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;
import io.opentelemetry.instrumentation.api.internal.ClassNames;

/* JADX INFO: loaded from: classes4.dex */
public final class CodeSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private final CodeAttributesGetter<REQUEST> getter;

    public static <REQUEST> SpanNameExtractor<REQUEST> create(CodeAttributesGetter<REQUEST> codeAttributesGetter) {
        return new CodeSpanNameExtractor(codeAttributesGetter);
    }

    private CodeSpanNameExtractor(CodeAttributesGetter<REQUEST> codeAttributesGetter) {
        this.getter = codeAttributesGetter;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
    public String extract(REQUEST request) {
        Class<?> clsCodeClass = this.getter.codeClass(request);
        String strSimpleName = clsCodeClass != null ? ClassNames.simpleName(clsCodeClass) : CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN;
        int iIndexOf = strSimpleName.indexOf("$$Lambda$");
        if (iIndexOf > -1) {
            strSimpleName = strSimpleName.substring(0, iIndexOf + "$$Lambda$".length());
        }
        String strMethodName = this.getter.methodName(request);
        return strMethodName == null ? strSimpleName : strSimpleName + "." + strMethodName;
    }
}
