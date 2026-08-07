package org.tinylog.runtime;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractJavaRuntime implements RuntimeDialect {
    AbstractJavaRuntime() {
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public String getDefaultWriter() {
        return "console";
    }
}
