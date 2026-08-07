package sdk.pendo.io.w5;

import android.content.Context;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.s7.i;
import sdk.pendo.io.s7.k0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u000f\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\b\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\u0004\"\u0017\u0010\n\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0002\u001a\u0004\b\t\u0010\u0004\"\u0017\u0010\u000b\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0002\u001a\u0004\b\u0001\u0010\u0004\"\u0017\u0010\f\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\t\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u000e\u001a\u00020\u00008\u0006¢\u0006\f\n\u0004\b\r\u0010\u0002\u001a\u0004\b\r\u0010\u0004¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/b3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/b3/a;", "c", "()Lsdk/pendo/io/b3/a;", "contextModule", "b", "d", "guidesModule", "e", "screenManagerModule", "anchorViewUtilsModule", "composeUtilityHelper", "f", "sharedUtilsModule", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class d {
    private static final sdk.pendo.io.b3.a a = sdk.pendo.io.g3.b.a(false, c.a, 1, null);
    private static final sdk.pendo.io.b3.a b = sdk.pendo.io.g3.b.a(false, C0512d.a, 1, null);
    private static final sdk.pendo.io.b3.a c = sdk.pendo.io.g3.b.a(false, e.a, 1, null);
    private static final sdk.pendo.io.b3.a d = sdk.pendo.io.g3.b.a(false, a.a, 1, null);
    private static final sdk.pendo.io.b3.a e = sdk.pendo.io.g3.b.a(false, b.a, 1, null);
    private static final sdk.pendo.io.b3.a f = sdk.pendo.io.g3.b.a(false, f.a, 1, null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/b3/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/b3/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function1<sdk.pendo.io.b3.a, Unit> {
        public static final a a = new a();

        /* JADX INFO: renamed from: sdk.pendo.io.w5.d$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/s7/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/s7/e;"}, k = 3, mv = {1, 9, 0})
        static final class C0511a extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.s7.e> {
            public static final C0511a a = new C0511a();

            C0511a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.s7.e invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return sdk.pendo.io.s7.e.INSTANCE.a();
            }
        }

        a() {
            super(1);
        }

        public final void a(sdk.pendo.io.b3.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            C0511a c0511a = C0511a.a;
            sdk.pendo.io.z2.d<?> dVar = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(sdk.pendo.io.e3.c.INSTANCE.a(), Reflection.getOrCreateKotlinClass(sdk.pendo.io.s7.e.class), null, c0511a, sdk.pendo.io.w2.d.Singleton, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar);
            if (module.get_createdAtStart()) {
                module.a(dVar);
            }
            new sdk.pendo.io.w2.e(module, dVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.b3.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/b3/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/b3/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class b extends Lambda implements Function1<sdk.pendo.io.b3.a, Unit> {
        public static final b a = new b();

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/s7/i;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/s7/i;"}, k = 3, mv = {1, 9, 0})
        static final class a extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, i> {
            public static final a a = new a();

            a() {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final i invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new i(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }
        }

        b() {
            super(1);
        }

        public final void a(sdk.pendo.io.b3.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            a aVar = a.a;
            sdk.pendo.io.z2.d<?> dVar = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(sdk.pendo.io.e3.c.INSTANCE.a(), Reflection.getOrCreateKotlinClass(i.class), null, aVar, sdk.pendo.io.w2.d.Singleton, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar);
            if (module.get_createdAtStart()) {
                module.a(dVar);
            }
            new sdk.pendo.io.w2.e(module, dVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.b3.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/b3/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/b3/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class c extends Lambda implements Function1<sdk.pendo.io.b3.a, Unit> {
        public static final c a = new c();

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Landroid/content/Context;", "kotlin.jvm.PlatformType", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Landroid/content/Context;"}, k = 3, mv = {1, 9, 0})
        static final class a extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, Context> {
            public static final a a = new a();

            a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Context invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return PendoInternal.o();
            }
        }

        c() {
            super(1);
        }

        public final void a(sdk.pendo.io.b3.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            a aVar = a.a;
            sdk.pendo.io.z2.d<?> dVar = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(sdk.pendo.io.e3.c.INSTANCE.a(), Reflection.getOrCreateKotlinClass(Context.class), null, aVar, sdk.pendo.io.w2.d.Singleton, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar);
            if (module.get_createdAtStart()) {
                module.a(dVar);
            }
            new sdk.pendo.io.w2.e(module, dVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.b3.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.w5.d$d, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/b3/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/b3/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class C0512d extends Lambda implements Function1<sdk.pendo.io.b3.a, Unit> {
        public static final C0512d a = new C0512d();

        /* JADX INFO: renamed from: sdk.pendo.io.w5.d$d$a */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/g6/b;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/g6/b;"}, k = 3, mv = {1, 9, 0})
        static final class a extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.g6.b> {
            public static final a a = new a();

            a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.g6.b invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new sdk.pendo.io.g6.b((Context) single.b(Reflection.getOrCreateKotlinClass(Context.class), null, null));
            }
        }

        C0512d() {
            super(1);
        }

        public final void a(sdk.pendo.io.b3.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            a aVar = a.a;
            sdk.pendo.io.z2.d<?> dVar = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(sdk.pendo.io.e3.c.INSTANCE.a(), Reflection.getOrCreateKotlinClass(sdk.pendo.io.g6.b.class), null, aVar, sdk.pendo.io.w2.d.Singleton, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar);
            if (module.get_createdAtStart()) {
                module.a(dVar);
            }
            new sdk.pendo.io.w2.e(module, dVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.b3.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/b3/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/b3/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class e extends Lambda implements Function1<sdk.pendo.io.b3.a, Unit> {
        public static final e a = new e();

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/x6/d;", "kotlin.jvm.PlatformType", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/x6/d;"}, k = 3, mv = {1, 9, 0})
        static final class a extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.x6.d> {
            public static final a a = new a();

            a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.x6.d invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return PendoInternal.z();
            }
        }

        e() {
            super(1);
        }

        public final void a(sdk.pendo.io.b3.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            a aVar = a.a;
            sdk.pendo.io.z2.d<?> dVar = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(sdk.pendo.io.e3.c.INSTANCE.a(), Reflection.getOrCreateKotlinClass(sdk.pendo.io.x6.d.class), null, aVar, sdk.pendo.io.w2.d.Singleton, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar);
            if (module.get_createdAtStart()) {
                module.a(dVar);
            }
            new sdk.pendo.io.w2.e(module, dVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.b3.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/b3/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/b3/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class f extends Lambda implements Function1<sdk.pendo.io.b3.a, Unit> {
        public static final f a = new f();

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/s7/k0;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/s7/k0;"}, k = 3, mv = {1, 9, 0})
        static final class a extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, k0> {
            public static final a a = new a();

            a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final k0 invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new k0();
            }
        }

        f() {
            super(1);
        }

        public final void a(sdk.pendo.io.b3.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            a aVar = a.a;
            sdk.pendo.io.z2.d<?> dVar = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(sdk.pendo.io.e3.c.INSTANCE.a(), Reflection.getOrCreateKotlinClass(k0.class), null, aVar, sdk.pendo.io.w2.d.Singleton, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar);
            if (module.get_createdAtStart()) {
                module.a(dVar);
            }
            new sdk.pendo.io.w2.e(module, dVar);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.b3.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    public static final sdk.pendo.io.b3.a a() {
        return d;
    }

    public static final sdk.pendo.io.b3.a b() {
        return e;
    }

    public static final sdk.pendo.io.b3.a c() {
        return a;
    }

    public static final sdk.pendo.io.b3.a d() {
        return b;
    }

    public static final sdk.pendo.io.b3.a e() {
        return c;
    }

    public static final sdk.pendo.io.b3.a f() {
        return f;
    }
}
