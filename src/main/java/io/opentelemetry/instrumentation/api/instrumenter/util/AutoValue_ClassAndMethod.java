package io.opentelemetry.instrumentation.api.instrumenter.util;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ClassAndMethod extends ClassAndMethod {
    private final Class<?> declaringClass;
    private final String methodName;

    AutoValue_ClassAndMethod(Class<?> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("Null declaringClass");
        }
        this.declaringClass = cls;
        if (str == null) {
            throw new NullPointerException("Null methodName");
        }
        this.methodName = str;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.util.ClassAndMethod
    public Class<?> declaringClass() {
        return this.declaringClass;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.util.ClassAndMethod
    public String methodName() {
        return this.methodName;
    }

    public String toString() {
        return "ClassAndMethod{declaringClass=" + this.declaringClass + ", methodName=" + this.methodName + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClassAndMethod) {
            ClassAndMethod classAndMethod = (ClassAndMethod) obj;
            if (this.declaringClass.equals(classAndMethod.declaringClass()) && this.methodName.equals(classAndMethod.methodName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.methodName.hashCode() ^ ((this.declaringClass.hashCode() ^ 1000003) * 1000003);
    }
}
