package sdk.pendo.io.l4;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.e0;

/* JADX INFO: loaded from: classes4.dex */
public interface f<F, T> {

    public static abstract class a {
        protected static Type getParameterUpperBound(int i, ParameterizedType parameterizedType) {
            return w.b(i, parameterizedType);
        }

        protected static Class<?> getRawType(Type type) {
            return w.b(type);
        }

        @Nullable
        public f<?, c0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
            return null;
        }

        @Nullable
        public f<e0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }

        @Nullable
        public f<?, String> stringConverter(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }
    }

    @Nullable
    T convert(F f);
}
