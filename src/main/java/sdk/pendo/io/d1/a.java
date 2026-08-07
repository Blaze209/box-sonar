package sdk.pendo.io.d1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static b e;
    private final sdk.pendo.io.n1.b a;
    private final sdk.pendo.io.o1.c b;
    private final Set<i> c;
    private final Collection<c> d;

    /* JADX INFO: renamed from: sdk.pendo.io.d1.a$a, reason: collision with other inner class name */
    public static class C0371a {
        private sdk.pendo.io.n1.b a;
        private sdk.pendo.io.o1.c b;
        private EnumSet<i> c = EnumSet.noneOf(i.class);
        private Collection<c> d = new ArrayList();

        public a a() {
            if (this.a == null || this.b == null) {
                b bVarC = a.c();
                if (this.a == null) {
                    this.a = bVarC.c();
                }
                if (this.b == null) {
                    this.b = bVarC.a();
                }
            }
            return new a(this.a, this.b, this.c, this.d);
        }

        public C0371a a(Collection<c> collection) {
            if (collection == null) {
                collection = Collections.emptyList();
            }
            this.d = collection;
            return this;
        }

        public C0371a a(sdk.pendo.io.n1.b bVar) {
            this.a = bVar;
            return this;
        }

        public C0371a a(sdk.pendo.io.o1.c cVar) {
            this.b = cVar;
            return this;
        }

        public C0371a a(Set<i> set) {
            this.c.addAll(set);
            return this;
        }

        public C0371a a(i... iVarArr) {
            if (iVarArr.length > 0) {
                this.c.addAll(Arrays.asList(iVarArr));
            }
            return this;
        }
    }

    public interface b {
        sdk.pendo.io.o1.c a();

        Set<i> b();

        sdk.pendo.io.n1.b c();
    }

    private a(sdk.pendo.io.n1.b bVar, sdk.pendo.io.o1.c cVar, EnumSet<i> enumSet, Collection<c> collection) {
        sdk.pendo.io.e1.i.a(bVar, "jsonProvider can not be null", new Object[0]);
        sdk.pendo.io.e1.i.a(cVar, "mappingProvider can not be null", new Object[0]);
        sdk.pendo.io.e1.i.a(enumSet, "setOptions can not be null", new Object[0]);
        sdk.pendo.io.e1.i.a(collection, "evaluationListeners can not be null", new Object[0]);
        this.a = bVar;
        this.b = cVar;
        this.c = Collections.unmodifiableSet(enumSet);
        this.d = Collections.unmodifiableCollection(collection);
    }

    public static a b() {
        b bVarC = c();
        return a().a(bVarC.c()).a(bVarC.b()).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b c() {
        b bVar = e;
        return bVar == null ? sdk.pendo.io.e1.b.b : bVar;
    }

    public a a(i... iVarArr) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(i.class);
        enumSetNoneOf.addAll(this.c);
        enumSetNoneOf.addAll(Arrays.asList(iVarArr));
        return a().a(this.a).a(this.b).a((Set<i>) enumSetNoneOf).a(this.d).a();
    }

    public Collection<c> d() {
        return this.d;
    }

    public Set<i> e() {
        return this.c;
    }

    public sdk.pendo.io.n1.b f() {
        return this.a;
    }

    public sdk.pendo.io.o1.c g() {
        return this.b;
    }

    public static C0371a a() {
        return new C0371a();
    }

    public boolean a(i iVar) {
        return this.c.contains(iVar);
    }
}
