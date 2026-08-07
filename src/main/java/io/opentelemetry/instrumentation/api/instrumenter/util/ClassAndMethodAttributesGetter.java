package io.opentelemetry.instrumentation.api.instrumenter.util;

import io.opentelemetry.instrumentation.api.instrumenter.code.CodeAttributesGetter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
enum ClassAndMethodAttributesGetter implements CodeAttributesGetter<ClassAndMethod> {
    INSTANCE;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.code.CodeAttributesGetter
    @Nullable
    public Class<?> codeClass(ClassAndMethod classAndMethod) {
        return classAndMethod.declaringClass();
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.code.CodeAttributesGetter
    @Nullable
    public String methodName(ClassAndMethod classAndMethod) {
        return classAndMethod.methodName();
    }
}
