package sdk.pendo.io.l4;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface c<R, T> {

    public static abstract class a {
        protected static Type a(int i, ParameterizedType parameterizedType) {
            return w.b(i, parameterizedType);
        }

        @Nullable
        public abstract c<?, ?> a(Type type, Annotation[] annotationArr, s sVar);

        protected static Class<?> a(Type type) {
            return w.b(type);
        }
    }

    T a(b<R> bVar);

    Type a();
}
