package sdk.pendo.io.l4;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import sdk.pendo.io.e2.b0;

/* JADX INFO: loaded from: classes4.dex */
final class g extends c.a {

    @Nullable
    private final Executor a;

    class a implements c<Object, sdk.pendo.io.l4.b<?>> {
        final /* synthetic */ Type a;
        final /* synthetic */ Executor b;

        a(Type type, Executor executor) {
            this.a = type;
            this.b = executor;
        }

        @Override // sdk.pendo.io.l4.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.l4.b<Object> a(sdk.pendo.io.l4.b<Object> bVar) {
            Executor executor = this.b;
            return executor == null ? bVar : new b(executor, bVar);
        }

        @Override // sdk.pendo.io.l4.c
        public Type a() {
            return this.a;
        }
    }

    static final class b<T> implements sdk.pendo.io.l4.b<T> {
        final Executor a;
        final sdk.pendo.io.l4.b<T> b;

        class a implements d<T> {
            final /* synthetic */ d a;

            a(d dVar) {
                this.a = dVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(d dVar, Throwable th) {
                dVar.a(b.this, th);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(d dVar, r rVar) {
                boolean zIsCanceled = b.this.b.isCanceled();
                b bVar = b.this;
                if (zIsCanceled) {
                    dVar.a(bVar, new IOException("Canceled"));
                } else {
                    dVar.a(bVar, rVar);
                }
            }

            @Override // sdk.pendo.io.l4.d
            public void a(sdk.pendo.io.l4.b<T> bVar, final Throwable th) {
                Executor executor = b.this.a;
                final d dVar = this.a;
                executor.execute(new Runnable() { // from class: sdk.pendo.io.l4.g$b$a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(dVar, th);
                    }
                });
            }

            @Override // sdk.pendo.io.l4.d
            public void a(sdk.pendo.io.l4.b<T> bVar, final r<T> rVar) {
                Executor executor = b.this.a;
                final d dVar = this.a;
                executor.execute(new Runnable() { // from class: sdk.pendo.io.l4.g$b$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(dVar, rVar);
                    }
                });
            }
        }

        b(Executor executor, sdk.pendo.io.l4.b<T> bVar) {
            this.a = executor;
            this.b = bVar;
        }

        @Override // sdk.pendo.io.l4.b
        public void a(d<T> dVar) {
            Objects.requireNonNull(dVar, "callback == null");
            this.b.a(new a(dVar));
        }

        @Override // sdk.pendo.io.l4.b
        public void cancel() {
            this.b.cancel();
        }

        @Override // sdk.pendo.io.l4.b
        public r<T> execute() {
            return this.b.execute();
        }

        @Override // sdk.pendo.io.l4.b
        public boolean isCanceled() {
            return this.b.isCanceled();
        }

        @Override // sdk.pendo.io.l4.b
        public b0 request() {
            return this.b.request();
        }

        @Override // sdk.pendo.io.l4.b
        public sdk.pendo.io.l4.b<T> clone() {
            return new b(this.a, this.b.clone());
        }
    }

    g(@Nullable Executor executor) {
        this.a = executor;
    }

    @Override // sdk.pendo.io.l4.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (c.a.a(type) != sdk.pendo.io.l4.b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(w.b(0, (ParameterizedType) type), w.a(annotationArr, (Class<? extends Annotation>) u.class) ? null : this.a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
