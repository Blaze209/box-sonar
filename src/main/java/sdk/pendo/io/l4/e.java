package sdk.pendo.io.l4;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class e extends sdk.pendo.io.l4.c.a {
    static final sdk.pendo.io.l4.c.a a = new e();

    private static final class a<R> implements sdk.pendo.io.l4.c<R, CompletableFuture<R>> {
        private final Type a;

        /* JADX INFO: renamed from: sdk.pendo.io.l4.e$a$a, reason: collision with other inner class name */
        private class C0412a implements d<R> {
            private final CompletableFuture<R> a;

            public C0412a(CompletableFuture<R> completableFuture) {
                this.a = completableFuture;
            }

            @Override // sdk.pendo.io.l4.d
            public void a(sdk.pendo.io.l4.b<R> bVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // sdk.pendo.io.l4.d
            public void a(sdk.pendo.io.l4.b<R> bVar, r<R> rVar) {
                boolean zD = rVar.d();
                CompletableFuture<R> completableFuture = this.a;
                if (zD) {
                    completableFuture.complete(rVar.a());
                } else {
                    completableFuture.completeExceptionally(new h(rVar));
                }
            }
        }

        a(Type type) {
            this.a = type;
        }

        @Override // sdk.pendo.io.l4.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> a(sdk.pendo.io.l4.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.a(new C0412a(bVar2));
            return bVar2;
        }

        @Override // sdk.pendo.io.l4.c
        public Type a() {
            return this.a;
        }
    }

    private static final class b<T> extends CompletableFuture<T> {
        private final sdk.pendo.io.l4.b<?> a;

        b(sdk.pendo.io.l4.b<?> bVar) {
            this.a = bVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (z) {
                this.a.cancel();
            }
            return super.cancel(z);
        }
    }

    private static final class c<R> implements sdk.pendo.io.l4.c<R, CompletableFuture<r<R>>> {
        private final Type a;

        private class a implements d<R> {
            private final CompletableFuture<r<R>> a;

            public a(CompletableFuture<r<R>> completableFuture) {
                this.a = completableFuture;
            }

            @Override // sdk.pendo.io.l4.d
            public void a(sdk.pendo.io.l4.b<R> bVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // sdk.pendo.io.l4.d
            public void a(sdk.pendo.io.l4.b<R> bVar, r<R> rVar) {
                this.a.complete(rVar);
            }
        }

        c(Type type) {
            this.a = type;
        }

        @Override // sdk.pendo.io.l4.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<r<R>> a(sdk.pendo.io.l4.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.a(new a(bVar2));
            return bVar2;
        }

        @Override // sdk.pendo.io.l4.c
        public Type a() {
            return this.a;
        }
    }

    e() {
    }

    @Override // sdk.pendo.io.l4.c.a
    @Nullable
    public sdk.pendo.io.l4.c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (sdk.pendo.io.l4.c.a.a(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeA = sdk.pendo.io.l4.c.a.a(0, (ParameterizedType) type);
        if (sdk.pendo.io.l4.c.a.a(typeA) != r.class) {
            return new a(typeA);
        }
        if (typeA instanceof ParameterizedType) {
            return new c(sdk.pendo.io.l4.c.a.a(0, (ParameterizedType) typeA));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
