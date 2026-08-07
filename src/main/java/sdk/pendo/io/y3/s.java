package sdk.pendo.io.y3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class s extends sdk.pendo.io.k3.j<Long> {
    final sdk.pendo.io.k3.p a;
    final long b;
    final long c;
    final TimeUnit d;

    static final class a extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.o3.b, Runnable {
        final sdk.pendo.io.k3.o<? super Long> a;
        long b;

        a(sdk.pendo.io.k3.o<? super Long> oVar) {
            this.a = oVar;
        }

        public void a(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this, bVar);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            sdk.pendo.io.r3.b.a((AtomicReference<sdk.pendo.io.o3.b>) this);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return get() == sdk.pendo.io.r3.b.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != sdk.pendo.io.r3.b.DISPOSED) {
                sdk.pendo.io.k3.o<? super Long> oVar = this.a;
                long j = this.b;
                this.b = 1 + j;
                oVar.onNext(Long.valueOf(j));
            }
        }
    }

    public s(long j, long j2, TimeUnit timeUnit, sdk.pendo.io.k3.p pVar) {
        this.b = j;
        this.c = j2;
        this.d = timeUnit;
        this.a = pVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super Long> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        sdk.pendo.io.k3.p pVar = this.a;
        if (!(pVar instanceof sdk.pendo.io.a4.n)) {
            aVar.a(pVar.a(aVar, this.b, this.c, this.d));
            return;
        }
        sdk.pendo.io.k3.p.c cVarA = pVar.a();
        aVar.a(cVarA);
        cVarA.a(aVar, this.b, this.c, this.d);
    }
}
