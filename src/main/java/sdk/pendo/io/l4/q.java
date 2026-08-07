package sdk.pendo.io.l4;

import cz.msebera.android.httpclient.entity.mime.MIME;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.x;
import sdk.pendo.io.n4.y;

/* JADX INFO: loaded from: classes4.dex */
final class q {
    private final Method a;
    private final sdk.pendo.io.e2.v b;
    final String c;

    @Nullable
    private final String d;

    @Nullable
    private final sdk.pendo.io.e2.u e;

    @Nullable
    private final x f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final n<?>[] j;
    final boolean k;

    static final class a {
        private static final Pattern x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        private static final Pattern y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        final s a;
        final Method b;
        final Annotation[] c;
        final Annotation[][] d;
        final Type[] e;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;

        @Nullable
        String n;
        boolean o;
        boolean p;
        boolean q;

        @Nullable
        String r;

        @Nullable
        sdk.pendo.io.e2.u s;

        @Nullable
        x t;

        @Nullable
        Set<String> u;

        @Nullable
        n<?>[] v;
        boolean w;

        a(s sVar, Method method) {
            this.a = sVar;
            this.b = method;
            this.c = method.getAnnotations();
            this.e = method.getGenericParameterTypes();
            this.d = method.getParameterAnnotations();
        }

        private static Class<?> a(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            return Short.TYPE == cls ? Short.class : cls;
        }

        q a() {
            for (Annotation annotation : this.c) {
                a(annotation);
            }
            if (this.n == null) {
                throw w.a(this.b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.o) {
                if (this.q) {
                    throw w.a(this.b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.p) {
                    throw w.a(this.b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.d.length;
            this.v = new n[length];
            int i = length - 1;
            int i2 = 0;
            while (i2 < length) {
                this.v[i2] = a(i2, this.e[i2], this.d[i2], i2 == i);
                i2++;
            }
            if (this.r == null && !this.m) {
                throw w.a(this.b, "Missing either @%s URL or @Url parameter.", this.n);
            }
            boolean z = this.p;
            if (!z && !this.q && !this.o && this.h) {
                throw w.a(this.b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z && !this.f) {
                throw w.a(this.b, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.q || this.g) {
                return new q(this);
            }
            throw w.a(this.b, "Multipart method must contain at least one @Part.", new Object[0]);
        }

        private sdk.pendo.io.e2.u a(String[] strArr) {
            sdk.pendo.io.e2.u.a aVar = new sdk.pendo.io.e2.u.a();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw w.a(this.b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    try {
                        this.t = x.a(strTrim);
                    } catch (IllegalArgumentException e) {
                        throw w.a(this.b, e, "Malformed content type: %s", strTrim);
                    }
                } else {
                    aVar.a(strSubstring, strTrim);
                }
            }
            return aVar.a();
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.n;
            if (str3 != null) {
                throw w.a(this.b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.n = str;
            this.o = z;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (x.matcher(strSubstring).find()) {
                    throw w.a(this.b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.r = str2;
            this.u = a(str2);
        }

        private void a(Annotation annotation) {
            if (annotation instanceof sdk.pendo.io.n4.b) {
                a("DELETE", ((sdk.pendo.io.n4.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof sdk.pendo.io.n4.f) {
                a("GET", ((sdk.pendo.io.n4.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof sdk.pendo.io.n4.g) {
                a("HEAD", ((sdk.pendo.io.n4.g) annotation).value(), false);
                return;
            }
            if (annotation instanceof sdk.pendo.io.n4.n) {
                a("PATCH", ((sdk.pendo.io.n4.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof sdk.pendo.io.n4.o) {
                a("POST", ((sdk.pendo.io.n4.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof sdk.pendo.io.n4.p) {
                a("PUT", ((sdk.pendo.io.n4.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof sdk.pendo.io.n4.m) {
                a("OPTIONS", ((sdk.pendo.io.n4.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof sdk.pendo.io.n4.h) {
                sdk.pendo.io.n4.h hVar = (sdk.pendo.io.n4.h) annotation;
                a(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof sdk.pendo.io.n4.k) {
                String[] strArrValue = ((sdk.pendo.io.n4.k) annotation).value();
                if (strArrValue.length == 0) {
                    throw w.a(this.b, "@Headers annotation is empty.", new Object[0]);
                }
                this.s = a(strArrValue);
                return;
            }
            if (annotation instanceof sdk.pendo.io.n4.l) {
                if (this.p) {
                    throw w.a(this.b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.q = true;
            } else if (annotation instanceof sdk.pendo.io.n4.e) {
                if (this.q) {
                    throw w.a(this.b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.p = true;
            }
        }

        @Nullable
        private n<?> a(int i, Type type, @Nullable Annotation[] annotationArr, boolean z) {
            n<?> nVar;
            if (annotationArr != null) {
                nVar = null;
                for (Annotation annotation : annotationArr) {
                    n<?> nVarA = a(i, type, annotationArr, annotation);
                    if (nVarA != null) {
                        if (nVar != null) {
                            throw w.a(this.b, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        nVar = nVarA;
                    }
                }
            } else {
                nVar = null;
            }
            if (nVar != null) {
                return nVar;
            }
            if (z) {
                try {
                    if (w.b(type) == Continuation.class) {
                        this.w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw w.a(this.b, i, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        private n<?> a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof y) {
                a(i, type);
                if (this.m) {
                    throw w.a(this.b, i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.i) {
                    throw w.a(this.b, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.j) {
                    throw w.a(this.b, i, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.k) {
                    throw w.a(this.b, i, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.l) {
                    throw w.a(this.b, i, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.r != null) {
                    throw w.a(this.b, i, "@Url cannot be used with @%s URL", this.n);
                }
                this.m = true;
                if (type == sdk.pendo.io.e2.v.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new n.p(this.b, i);
                }
                throw w.a(this.b, i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof sdk.pendo.io.n4.s) {
                a(i, type);
                if (this.j) {
                    throw w.a(this.b, i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.k) {
                    throw w.a(this.b, i, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.l) {
                    throw w.a(this.b, i, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.m) {
                    throw w.a(this.b, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.r == null) {
                    throw w.a(this.b, i, "@Path can only be used with relative url on @%s", this.n);
                }
                this.i = true;
                sdk.pendo.io.n4.s sVar = (sdk.pendo.io.n4.s) annotation;
                String strValue = sVar.value();
                a(i, strValue);
                return new n.k(this.b, i, strValue, this.a.c(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof sdk.pendo.io.n4.t) {
                a(i, type);
                sdk.pendo.io.n4.t tVar = (sdk.pendo.io.n4.t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsB = w.b(type);
                this.j = true;
                if (!Iterable.class.isAssignableFrom(clsB)) {
                    return clsB.isArray() ? new n.l(strValue2, this.a.c(a(clsB.getComponentType()), annotationArr), zEncoded).a() : new n.l(strValue2, this.a.c(type, annotationArr), zEncoded);
                }
                if (type instanceof ParameterizedType) {
                    return new n.l(strValue2, this.a.c(w.b(0, (ParameterizedType) type), annotationArr), zEncoded).b();
                }
                throw w.a(this.b, i, clsB.getSimpleName() + " must include generic type (e.g., " + clsB.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof sdk.pendo.io.n4.v) {
                a(i, type);
                boolean zEncoded2 = ((sdk.pendo.io.n4.v) annotation).encoded();
                Class<?> clsB2 = w.b(type);
                this.k = true;
                if (!Iterable.class.isAssignableFrom(clsB2)) {
                    return clsB2.isArray() ? new n.C0413n(this.a.c(a(clsB2.getComponentType()), annotationArr), zEncoded2).a() : new n.C0413n(this.a.c(type, annotationArr), zEncoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new n.C0413n(this.a.c(w.b(0, (ParameterizedType) type), annotationArr), zEncoded2).b();
                }
                throw w.a(this.b, i, clsB2.getSimpleName() + " must include generic type (e.g., " + clsB2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof sdk.pendo.io.n4.u) {
                a(i, type);
                Class<?> clsB3 = w.b(type);
                this.l = true;
                if (!Map.class.isAssignableFrom(clsB3)) {
                    throw w.a(this.b, i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeB = w.b(type, clsB3, Map.class);
                if (!(typeB instanceof ParameterizedType)) {
                    throw w.a(this.b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeB;
                Type typeB2 = w.b(0, parameterizedType);
                if (String.class == typeB2) {
                    return new n.m(this.b, i, this.a.c(w.b(1, parameterizedType), annotationArr), ((sdk.pendo.io.n4.u) annotation).encoded());
                }
                throw w.a(this.b, i, "@QueryMap keys must be of type String: " + typeB2, new Object[0]);
            }
            if (annotation instanceof sdk.pendo.io.n4.i) {
                a(i, type);
                String strValue3 = ((sdk.pendo.io.n4.i) annotation).value();
                Class<?> clsB4 = w.b(type);
                if (!Iterable.class.isAssignableFrom(clsB4)) {
                    return clsB4.isArray() ? new n.f(strValue3, this.a.c(a(clsB4.getComponentType()), annotationArr)).a() : new n.f(strValue3, this.a.c(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new n.f(strValue3, this.a.c(w.b(0, (ParameterizedType) type), annotationArr)).b();
                }
                throw w.a(this.b, i, clsB4.getSimpleName() + " must include generic type (e.g., " + clsB4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof sdk.pendo.io.n4.j) {
                if (type == sdk.pendo.io.e2.u.class) {
                    return new n.h(this.b, i);
                }
                a(i, type);
                Class<?> clsB5 = w.b(type);
                if (!Map.class.isAssignableFrom(clsB5)) {
                    throw w.a(this.b, i, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type typeB3 = w.b(type, clsB5, Map.class);
                if (!(typeB3 instanceof ParameterizedType)) {
                    throw w.a(this.b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeB3;
                Type typeB4 = w.b(0, parameterizedType2);
                if (String.class == typeB4) {
                    return new n.g(this.b, i, this.a.c(w.b(1, parameterizedType2), annotationArr));
                }
                throw w.a(this.b, i, "@HeaderMap keys must be of type String: " + typeB4, new Object[0]);
            }
            if (annotation instanceof sdk.pendo.io.n4.c) {
                a(i, type);
                if (!this.p) {
                    throw w.a(this.b, i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                sdk.pendo.io.n4.c cVar = (sdk.pendo.io.n4.c) annotation;
                String strValue4 = cVar.value();
                boolean zEncoded3 = cVar.encoded();
                this.f = true;
                Class<?> clsB6 = w.b(type);
                if (!Iterable.class.isAssignableFrom(clsB6)) {
                    return clsB6.isArray() ? new n.d(strValue4, this.a.c(a(clsB6.getComponentType()), annotationArr), zEncoded3).a() : new n.d(strValue4, this.a.c(type, annotationArr), zEncoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new n.d(strValue4, this.a.c(w.b(0, (ParameterizedType) type), annotationArr), zEncoded3).b();
                }
                throw w.a(this.b, i, clsB6.getSimpleName() + " must include generic type (e.g., " + clsB6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof sdk.pendo.io.n4.d) {
                a(i, type);
                if (!this.p) {
                    throw w.a(this.b, i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsB7 = w.b(type);
                if (!Map.class.isAssignableFrom(clsB7)) {
                    throw w.a(this.b, i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeB5 = w.b(type, clsB7, Map.class);
                if (!(typeB5 instanceof ParameterizedType)) {
                    throw w.a(this.b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeB5;
                Type typeB6 = w.b(0, parameterizedType3);
                if (String.class != typeB6) {
                    throw w.a(this.b, i, "@FieldMap keys must be of type String: " + typeB6, new Object[0]);
                }
                f fVarC = this.a.c(w.b(1, parameterizedType3), annotationArr);
                this.f = true;
                return new n.e(this.b, i, fVarC, ((sdk.pendo.io.n4.d) annotation).encoded());
            }
            if (annotation instanceof sdk.pendo.io.n4.q) {
                a(i, type);
                if (!this.q) {
                    throw w.a(this.b, i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                sdk.pendo.io.n4.q qVar = (sdk.pendo.io.n4.q) annotation;
                this.g = true;
                String strValue5 = qVar.value();
                Class<?> clsB8 = w.b(type);
                if (strValue5.isEmpty()) {
                    if (Iterable.class.isAssignableFrom(clsB8)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw w.a(this.b, i, clsB8.getSimpleName() + " must include generic type (e.g., " + clsB8.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (sdk.pendo.io.e2.y.c.class.isAssignableFrom(w.b(w.b(0, (ParameterizedType) type)))) {
                            return n.o.a.b();
                        }
                        throw w.a(this.b, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (clsB8.isArray()) {
                        if (sdk.pendo.io.e2.y.c.class.isAssignableFrom(clsB8.getComponentType())) {
                            return n.o.a.a();
                        }
                        throw w.a(this.b, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (sdk.pendo.io.e2.y.c.class.isAssignableFrom(clsB8)) {
                        return n.o.a;
                    }
                    throw w.a(this.b, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                sdk.pendo.io.e2.u uVarA = sdk.pendo.io.e2.u.a("Content-Disposition", "form-data; name=\"" + strValue5 + "\"", MIME.CONTENT_TRANSFER_ENC, qVar.encoding());
                if (Iterable.class.isAssignableFrom(clsB8)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw w.a(this.b, i, clsB8.getSimpleName() + " must include generic type (e.g., " + clsB8.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Type typeB7 = w.b(0, (ParameterizedType) type);
                    if (sdk.pendo.io.e2.y.c.class.isAssignableFrom(w.b(typeB7))) {
                        throw w.a(this.b, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new n.i(this.b, i, uVarA, this.a.a(typeB7, annotationArr, this.c)).b();
                }
                if (!clsB8.isArray()) {
                    if (sdk.pendo.io.e2.y.c.class.isAssignableFrom(clsB8)) {
                        throw w.a(this.b, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new n.i(this.b, i, uVarA, this.a.a(type, annotationArr, this.c));
                }
                Class<?> clsA = a(clsB8.getComponentType());
                if (sdk.pendo.io.e2.y.c.class.isAssignableFrom(clsA)) {
                    throw w.a(this.b, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new n.i(this.b, i, uVarA, this.a.a(clsA, annotationArr, this.c)).a();
            }
            if (annotation instanceof sdk.pendo.io.n4.r) {
                a(i, type);
                if (!this.q) {
                    throw w.a(this.b, i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.g = true;
                Class<?> clsB9 = w.b(type);
                if (!Map.class.isAssignableFrom(clsB9)) {
                    throw w.a(this.b, i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type typeB8 = w.b(type, clsB9, Map.class);
                if (!(typeB8 instanceof ParameterizedType)) {
                    throw w.a(this.b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) typeB8;
                Type typeB9 = w.b(0, parameterizedType4);
                if (String.class != typeB9) {
                    throw w.a(this.b, i, "@PartMap keys must be of type String: " + typeB9, new Object[0]);
                }
                Type typeB10 = w.b(1, parameterizedType4);
                if (sdk.pendo.io.e2.y.c.class.isAssignableFrom(w.b(typeB10))) {
                    throw w.a(this.b, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                return new n.j(this.b, i, this.a.a(typeB10, annotationArr, this.c), ((sdk.pendo.io.n4.r) annotation).encoding());
            }
            if (annotation instanceof sdk.pendo.io.n4.a) {
                a(i, type);
                if (this.p || this.q) {
                    throw w.a(this.b, i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.h) {
                    throw w.a(this.b, i, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    f fVarA = this.a.a(type, annotationArr, this.c);
                    this.h = true;
                    return new n.c(this.b, i, fVarA);
                } catch (RuntimeException e) {
                    throw w.a(this.b, e, i, "Unable to create @Body converter for %s", type);
                }
            }
            if (!(annotation instanceof sdk.pendo.io.n4.x)) {
                return null;
            }
            a(i, type);
            Class<?> clsB10 = w.b(type);
            for (int i2 = i - 1; i2 >= 0; i2--) {
                n<?> nVar = this.v[i2];
                if ((nVar instanceof n.q) && ((n.q) nVar).a.equals(clsB10)) {
                    throw w.a(this.b, i, "@Tag type " + clsB10.getName() + " is duplicate of parameter #" + (i2 + 1) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new n.q(clsB10);
        }

        static Set<String> a(String str) {
            Matcher matcher = x.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void a(int i, String str) {
            if (!y.matcher(str).matches()) {
                throw w.a(this.b, i, "@Path parameter name must match %s. Found: %s", x.pattern(), str);
            }
            if (!this.u.contains(str)) {
                throw w.a(this.b, i, "URL \"%s\" does not contain \"{%s}\".", this.r, str);
            }
        }

        private void a(int i, Type type) {
            if (w.c(type)) {
                throw w.a(this.b, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    q(a aVar) {
        this.a = aVar.b;
        this.b = aVar.a.c;
        this.c = aVar.n;
        this.d = aVar.r;
        this.e = aVar.s;
        this.f = aVar.t;
        this.g = aVar.o;
        this.h = aVar.p;
        this.i = aVar.q;
        this.j = aVar.v;
        this.k = aVar.w;
    }

    b0 a(Object[] objArr) {
        n<?>[] nVarArr = this.j;
        int length = objArr.length;
        if (length != nVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + nVarArr.length + ")");
        }
        p pVar = new p(this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i);
        if (this.k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            nVarArr[i].a(pVar, objArr[i]);
        }
        return pVar.a().a((Class<? super j>) j.class, new j(this.a, arrayList)).a();
    }

    static q a(s sVar, Method method) {
        return new a(sVar, method).a();
    }
}
