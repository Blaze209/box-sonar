package sdk.pendo.io.l4;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import sdk.pendo.io.e2.e0;

/* JADX INFO: loaded from: classes4.dex */
final class m extends f.a {
    static final f.a a = new m();

    static final class a<T> implements f<e0, Optional<T>> {
        final f<e0, T> a;

        a(f<e0, T> fVar) {
            this.a = fVar;
        }

        @Override // sdk.pendo.io.l4.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Optional<T> convert(e0 e0Var) {
            return Optional.ofNullable(this.a.convert(e0Var));
        }
    }

    m() {
    }

    @Override // sdk.pendo.io.l4.f.a
    @Nullable
    public f<e0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, s sVar) {
        if (f.a.getRawType(type) != Optional.class) {
            return null;
        }
        return new a(sVar.b(f.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
