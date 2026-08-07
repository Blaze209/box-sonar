package sdk.pendo.io.l4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.e2.d0;
import sdk.pendo.io.e2.e0;

/* JADX INFO: loaded from: classes4.dex */
abstract class i<ResponseT, ReturnT> extends t<ReturnT> {
    private final q a;
    private final sdk.pendo.io.e2.e.a b;
    private final f<e0, ResponseT> c;

    static final class a<ResponseT, ReturnT> extends i<ResponseT, ReturnT> {
        private final sdk.pendo.io.l4.c<ResponseT, ReturnT> d;

        a(q qVar, sdk.pendo.io.e2.e.a aVar, f<e0, ResponseT> fVar, sdk.pendo.io.l4.c<ResponseT, ReturnT> cVar) {
            super(qVar, aVar, fVar);
            this.d = cVar;
        }

        @Override // sdk.pendo.io.l4.i
        protected ReturnT a(sdk.pendo.io.l4.b<ResponseT> bVar, Object[] objArr) {
            return this.d.a(bVar);
        }
    }

    static final class b<ResponseT> extends i<ResponseT, Object> {
        private final sdk.pendo.io.l4.c<ResponseT, sdk.pendo.io.l4.b<ResponseT>> d;
        private final boolean e;

        b(q qVar, sdk.pendo.io.e2.e.a aVar, f<e0, ResponseT> fVar, sdk.pendo.io.l4.c<ResponseT, sdk.pendo.io.l4.b<ResponseT>> cVar, boolean z) {
            super(qVar, aVar, fVar);
            this.d = cVar;
            this.e = z;
        }

        @Override // sdk.pendo.io.l4.i
        protected Object a(sdk.pendo.io.l4.b<ResponseT> bVar, Object[] objArr) {
            sdk.pendo.io.l4.b<ResponseT> bVarA = this.d.a(bVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return this.e ? k.b(bVarA, continuation) : k.a(bVarA, continuation);
            } catch (Exception e) {
                return k.a(e, (Continuation<?>) continuation);
            }
        }
    }

    static final class c<ResponseT> extends i<ResponseT, Object> {
        private final sdk.pendo.io.l4.c<ResponseT, sdk.pendo.io.l4.b<ResponseT>> d;

        c(q qVar, sdk.pendo.io.e2.e.a aVar, f<e0, ResponseT> fVar, sdk.pendo.io.l4.c<ResponseT, sdk.pendo.io.l4.b<ResponseT>> cVar) {
            super(qVar, aVar, fVar);
            this.d = cVar;
        }

        @Override // sdk.pendo.io.l4.i
        protected Object a(sdk.pendo.io.l4.b<ResponseT> bVar, Object[] objArr) {
            sdk.pendo.io.l4.b<ResponseT> bVarA = this.d.a(bVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return k.c(bVarA, continuation);
            } catch (Exception e) {
                return k.a(e, (Continuation<?>) continuation);
            }
        }
    }

    i(q qVar, sdk.pendo.io.e2.e.a aVar, f<e0, ResponseT> fVar) {
        this.a = qVar;
        this.b = aVar;
        this.c = fVar;
    }

    private static <ResponseT, ReturnT> sdk.pendo.io.l4.c<ResponseT, ReturnT> a(s sVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (sdk.pendo.io.l4.c<ResponseT, ReturnT>) sVar.a(type, annotationArr);
        } catch (RuntimeException e) {
            throw w.a(method, e, "Unable to create call adapter for %s", type);
        }
    }

    @Nullable
    protected abstract ReturnT a(sdk.pendo.io.l4.b<ResponseT> bVar, Object[] objArr);

    private static <ResponseT> f<e0, ResponseT> a(s sVar, Method method, Type type) {
        try {
            return sVar.b(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw w.a(method, e, "Unable to create converter for %s", type);
        }
    }

    @Override // sdk.pendo.io.l4.t
    @Nullable
    final ReturnT a(Object[] objArr) {
        return a(new l(this.a, objArr, this.b, this.c), objArr);
    }

    static <ResponseT, ReturnT> i<ResponseT, ReturnT> a(s sVar, Method method, q qVar) {
        Type genericReturnType;
        boolean z;
        boolean z2 = qVar.k;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeA = w.a(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (w.b(typeA) == r.class && (typeA instanceof ParameterizedType)) {
                typeA = w.b(0, (ParameterizedType) typeA);
                z = true;
            } else {
                z = false;
            }
            genericReturnType = new w.b(null, sdk.pendo.io.l4.b.class, typeA);
            annotations = v.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z = false;
        }
        sdk.pendo.io.l4.c cVarA = a(sVar, method, genericReturnType, annotations);
        Type typeA2 = cVarA.a();
        if (typeA2 == d0.class) {
            throw w.a(method, "'" + w.b(typeA2).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (typeA2 == r.class) {
            throw w.a(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (qVar.c.equals("HEAD") && !Void.class.equals(typeA2)) {
            throw w.a(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        f fVarA = a(sVar, method, typeA2);
        sdk.pendo.io.e2.e.a aVar = sVar.b;
        if (z2) {
            return z ? new c(qVar, aVar, fVarA, cVarA) : new b(qVar, aVar, fVarA, cVarA, false);
        }
        return new a(qVar, aVar, fVarA, cVarA);
    }
}
