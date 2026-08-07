package sdk.pendo.io.n7;

import android.content.Context;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.room.Room;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.db.PendoDatabase;
import sdk.pendo.io.e2.z;
import sdk.pendo.io.f6.e;
import sdk.pendo.io.h7.r;
import sdk.pendo.io.l4.s;
import sdk.pendo.io.r7.g;
import sdk.pendo.io.r7.h;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\"\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Landroid/content/Context;", "appContext", "Lsdk/pendo/io/b3/a;", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/b3/a;", "networkModule", "mainModule", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class c {
    private static final sdk.pendo.io.b3.a a = sdk.pendo.io.g3.b.a(false, b.a, 1, null);
    private static final sdk.pendo.io.b3.a b = sdk.pendo.io.g3.b.a(false, a.a, 1, null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/b3/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/b3/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function1<sdk.pendo.io.b3.a, Unit> {
        public static final a a = new a();

        /* JADX INFO: renamed from: sdk.pendo.io.n7.c$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/a7/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/a7/a;"}, k = 3, mv = {1, 9, 0})
        static final class C0431a extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.a7.a> {
            public static final C0431a a = new C0431a();

            C0431a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.a7.a invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new sdk.pendo.io.a7.a();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "<name for destructuring parameter 0>", "Lsdk/pendo/io/r7/h;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/r7/h;"}, k = 3, mv = {1, 9, 0})
        static final class b extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, h> {
            public static final b a = new b();

            b() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final h invoke(sdk.pendo.io.f3.a factory, sdk.pendo.io.c3.a aVar) {
                Intrinsics.checkNotNullParameter(factory, "$this$factory");
                Intrinsics.checkNotNullParameter(aVar, "<name for destructuring parameter 0>");
                return g.a.a((Pendo.PendoOptions.Framework) aVar.a(0, Reflection.getOrCreateKotlinClass(Pendo.PendoOptions.Framework.class)));
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.n7.c$a$c, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "<name for destructuring parameter 0>", "Lsdk/pendo/io/l7/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/l7/a;"}, k = 3, mv = {1, 9, 0})
        static final class C0432c extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.l7.a> {
            public static final C0432c a = new C0432c();

            /* JADX INFO: renamed from: sdk.pendo.io.n7.c$a$c$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/c3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/c3/a;"}, k = 3, mv = {1, 9, 0})
            static final class C0433a extends Lambda implements Function0<sdk.pendo.io.c3.a> {
                final /* synthetic */ String a;
                final /* synthetic */ String b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0433a(String str, String str2) {
                    super(0);
                    this.a = str;
                    this.b = str2;
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final sdk.pendo.io.c3.a invoke() {
                    return sdk.pendo.io.c3.b.a(this.a, this.b);
                }
            }

            C0432c() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.l7.a invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a aVar) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(aVar, "<name for destructuring parameter 0>");
                return new sdk.pendo.io.l7.b((sdk.pendo.io.p7.d) single.b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.p7.d.class), null, new C0433a((String) aVar.a(0, Reflection.getOrCreateKotlinClass(String.class)), (String) aVar.a(1, Reflection.getOrCreateKotlinClass(String.class)))), r.a);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "<name for destructuring parameter 0>", "Lsdk/pendo/io/q7/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/q7/a;"}, k = 3, mv = {1, 9, 0})
        static final class d extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.q7.a> {
            public static final d a = new d();

            /* JADX INFO: renamed from: sdk.pendo.io.n7.c$a$d$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/c3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/c3/a;"}, k = 3, mv = {1, 9, 0})
            static final class C0434a extends Lambda implements Function0<sdk.pendo.io.c3.a> {
                final /* synthetic */ String a;
                final /* synthetic */ String b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0434a(String str, String str2) {
                    super(0);
                    this.a = str;
                    this.b = str2;
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final sdk.pendo.io.c3.a invoke() {
                    return sdk.pendo.io.c3.b.a(this.a, this.b);
                }
            }

            d() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.q7.a invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a aVar) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(aVar, "<name for destructuring parameter 0>");
                return new sdk.pendo.io.q7.b((sdk.pendo.io.l7.a) single.b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.l7.a.class), null, new C0434a((String) aVar.a(0, Reflection.getOrCreateKotlinClass(String.class)), (String) aVar.a(1, Reflection.getOrCreateKotlinClass(String.class)))), (sdk.pendo.io.k7.a) single.b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.k7.a.class), null, null), (e) single.b(Reflection.getOrCreateKotlinClass(e.class), null, null), null, null, 24, null);
            }
        }

        a() {
            super(1);
        }

        public final void a(sdk.pendo.io.b3.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            C0431a c0431a = C0431a.a;
            sdk.pendo.io.e3.c.Companion companion = sdk.pendo.io.e3.c.INSTANCE;
            sdk.pendo.io.d3.c cVarA = companion.a();
            sdk.pendo.io.w2.d dVar = sdk.pendo.io.w2.d.Singleton;
            sdk.pendo.io.z2.d<?> dVar2 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(cVarA, Reflection.getOrCreateKotlinClass(sdk.pendo.io.a7.a.class), null, c0431a, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar2);
            if (module.get_createdAtStart()) {
                module.a(dVar2);
            }
            new sdk.pendo.io.w2.e(module, dVar2);
            b bVar = b.a;
            sdk.pendo.io.z2.c<?> aVar = new sdk.pendo.io.z2.a<>(new sdk.pendo.io.w2.a(companion.a(), Reflection.getOrCreateKotlinClass(h.class), null, bVar, sdk.pendo.io.w2.d.Factory, CollectionsKt.emptyList()));
            module.a(aVar);
            new sdk.pendo.io.w2.e(module, aVar);
            C0432c c0432c = C0432c.a;
            sdk.pendo.io.z2.d<?> dVar3 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(companion.a(), Reflection.getOrCreateKotlinClass(sdk.pendo.io.l7.a.class), null, c0432c, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar3);
            if (module.get_createdAtStart()) {
                module.a(dVar3);
            }
            new sdk.pendo.io.w2.e(module, dVar3);
            d dVar4 = d.a;
            sdk.pendo.io.z2.d<?> dVar5 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(companion.a(), Reflection.getOrCreateKotlinClass(sdk.pendo.io.q7.a.class), null, dVar4, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar5);
            if (module.get_createdAtStart()) {
                module.a(dVar5);
            }
            new sdk.pendo.io.w2.e(module, dVar5);
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

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "<name for destructuring parameter 0>", "Lsdk/pendo/io/p7/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/p7/e;"}, k = 3, mv = {1, 9, 0})
        static final class a extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.p7.e> {
            public static final a a = new a();

            a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.p7.e invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a aVar) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(aVar, "<name for destructuring parameter 0>");
                return new sdk.pendo.io.p7.e((String) aVar.a(0, Reflection.getOrCreateKotlinClass(String.class)));
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.n7.c$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "<name for destructuring parameter 0>", "Lsdk/pendo/io/e2/z;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/e2/z;"}, k = 3, mv = {1, 9, 0})
        static final class C0435b extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, z> {
            public static final C0435b a = new C0435b();

            /* JADX INFO: renamed from: sdk.pendo.io.n7.c$b$b$a */
            @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/c3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/c3/a;"}, k = 3, mv = {1, 9, 0})
            static final class a extends Lambda implements Function0<sdk.pendo.io.c3.a> {
                final /* synthetic */ String a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(String str) {
                    super(0);
                    this.a = str;
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final sdk.pendo.io.c3.a invoke() {
                    return sdk.pendo.io.c3.b.a(this.a);
                }
            }

            C0435b() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final z invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a aVar) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(aVar, "<name for destructuring parameter 0>");
                return new z.a().a((sdk.pendo.io.p7.e) single.b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.p7.e.class), null, new a((String) aVar.a(0, Reflection.getOrCreateKotlinClass(String.class))))).a();
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.n7.c$b$c, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "<name for destructuring parameter 0>", "Lsdk/pendo/io/l4/s;", "kotlin.jvm.PlatformType", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/l4/s;"}, k = 3, mv = {1, 9, 0})
        static final class C0436c extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, s> {
            public static final C0436c a = new C0436c();

            /* JADX INFO: renamed from: sdk.pendo.io.n7.c$b$c$a */
            @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/c3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/c3/a;"}, k = 3, mv = {1, 9, 0})
            static final class a extends Lambda implements Function0<sdk.pendo.io.c3.a> {
                final /* synthetic */ String a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(String str) {
                    super(0);
                    this.a = str;
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final sdk.pendo.io.c3.a invoke() {
                    return sdk.pendo.io.c3.b.a(this.a);
                }
            }

            C0436c() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final s invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a aVar) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(aVar, "<name for destructuring parameter 0>");
                String str = (String) aVar.a(0, Reflection.getOrCreateKotlinClass(String.class));
                return new s.b().a(str).a((z) single.b(Reflection.getOrCreateKotlinClass(z.class), null, new a((String) aVar.a(1, Reflection.getOrCreateKotlinClass(String.class))))).a(sdk.pendo.io.m4.a.a()).a();
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "<name for destructuring parameter 0>", "Lsdk/pendo/io/p7/d;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/p7/d;"}, k = 3, mv = {1, 9, 0})
        static final class d extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.p7.d> {
            public static final d a = new d();

            @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lsdk/pendo/io/c3/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "()Lsdk/pendo/io/c3/a;"}, k = 3, mv = {1, 9, 0})
            static final class a extends Lambda implements Function0<sdk.pendo.io.c3.a> {
                final /* synthetic */ String a;
                final /* synthetic */ String b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(String str, String str2) {
                    super(0);
                    this.a = str;
                    this.b = str2;
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final sdk.pendo.io.c3.a invoke() {
                    return sdk.pendo.io.c3.b.a(this.a, this.b);
                }
            }

            d() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.p7.d invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a aVar) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(aVar, "<name for destructuring parameter 0>");
                Object objA = ((s) single.b(Reflection.getOrCreateKotlinClass(s.class), null, new a((String) aVar.a(0, Reflection.getOrCreateKotlinClass(String.class)), (String) aVar.a(1, Reflection.getOrCreateKotlinClass(String.class))))).a((Class<Object>) sdk.pendo.io.p7.d.class);
                Intrinsics.checkNotNullExpressionValue(objA, "create(...)");
                return (sdk.pendo.io.p7.d) objA;
            }
        }

        b() {
            super(1);
        }

        public final void a(sdk.pendo.io.b3.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            a aVar = a.a;
            sdk.pendo.io.e3.c.Companion companion = sdk.pendo.io.e3.c.INSTANCE;
            sdk.pendo.io.d3.c cVarA = companion.a();
            sdk.pendo.io.w2.d dVar = sdk.pendo.io.w2.d.Singleton;
            sdk.pendo.io.z2.d<?> dVar2 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(cVarA, Reflection.getOrCreateKotlinClass(sdk.pendo.io.p7.e.class), null, aVar, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar2);
            if (module.get_createdAtStart()) {
                module.a(dVar2);
            }
            new sdk.pendo.io.w2.e(module, dVar2);
            C0435b c0435b = C0435b.a;
            sdk.pendo.io.z2.d<?> dVar3 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(companion.a(), Reflection.getOrCreateKotlinClass(z.class), null, c0435b, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar3);
            if (module.get_createdAtStart()) {
                module.a(dVar3);
            }
            new sdk.pendo.io.w2.e(module, dVar3);
            C0436c c0436c = C0436c.a;
            sdk.pendo.io.z2.d<?> dVar4 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(companion.a(), Reflection.getOrCreateKotlinClass(s.class), null, c0436c, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar4);
            if (module.get_createdAtStart()) {
                module.a(dVar4);
            }
            new sdk.pendo.io.w2.e(module, dVar4);
            d dVar5 = d.a;
            sdk.pendo.io.z2.d<?> dVar6 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(companion.a(), Reflection.getOrCreateKotlinClass(sdk.pendo.io.p7.d.class), null, dVar5, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar6);
            if (module.get_createdAtStart()) {
                module.a(dVar6);
            }
            new sdk.pendo.io.w2.e(module, dVar6);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.b3.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.n7.c$c, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lsdk/pendo/io/b3/a;", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/b3/a;)V"}, k = 3, mv = {1, 9, 0})
    static final class C0437c extends Lambda implements Function1<sdk.pendo.io.b3.a, Unit> {
        final /* synthetic */ Context a;

        /* JADX INFO: renamed from: sdk.pendo.io.n7.c$c$a */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/db/PendoDatabase;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/db/PendoDatabase;"}, k = 3, mv = {1, 9, 0})
        static final class a extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, PendoDatabase> {
            final /* synthetic */ Context a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context) {
                super(2);
                this.a = context;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final PendoDatabase invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return (PendoDatabase) Room.databaseBuilder(this.a, PendoDatabase.class, "pendo_database.db").fallbackToDestructiveMigration().build();
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.n7.c$c$b */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/m7/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/m7/a;"}, k = 3, mv = {1, 9, 0})
        static final class b extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.m7.a> {
            public static final b a = new b();

            b() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.m7.a invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return ((PendoDatabase) single.b(Reflection.getOrCreateKotlinClass(PendoDatabase.class), null, null)).a();
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.n7.c$c$c, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/k7/a;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/k7/a;"}, k = 3, mv = {1, 9, 0})
        static final class C0438c extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, sdk.pendo.io.k7.a> {
            public static final C0438c a = new C0438c();

            C0438c() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final sdk.pendo.io.k7.a invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new sdk.pendo.io.k7.b((sdk.pendo.io.m7.a) single.b(Reflection.getOrCreateKotlinClass(sdk.pendo.io.m7.a.class), null, null));
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.n7.c$c$d */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/f3/a;", "Lsdk/pendo/io/c3/a;", "it", "Lsdk/pendo/io/f6/e;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/f3/a;Lsdk/pendo/io/c3/a;)Lsdk/pendo/io/f6/e;"}, k = 3, mv = {1, 9, 0})
        static final class d extends Lambda implements Function2<sdk.pendo.io.f3.a, sdk.pendo.io.c3.a, e> {
            final /* synthetic */ Context a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(Context context) {
                super(2);
                this.a = context;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final e invoke(sdk.pendo.io.f3.a single, sdk.pendo.io.c3.a it) {
                Intrinsics.checkNotNullParameter(single, "$this$single");
                Intrinsics.checkNotNullParameter(it, "it");
                return new e(this.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0437c(Context context) {
            super(1);
            this.a = context;
        }

        public final void a(sdk.pendo.io.b3.a module) {
            Intrinsics.checkNotNullParameter(module, "$this$module");
            a aVar = new a(this.a);
            sdk.pendo.io.e3.c.Companion companion = sdk.pendo.io.e3.c.INSTANCE;
            sdk.pendo.io.d3.c cVarA = companion.a();
            sdk.pendo.io.w2.d dVar = sdk.pendo.io.w2.d.Singleton;
            sdk.pendo.io.z2.d<?> dVar2 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(cVarA, Reflection.getOrCreateKotlinClass(PendoDatabase.class), null, aVar, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar2);
            if (module.get_createdAtStart()) {
                module.a(dVar2);
            }
            new sdk.pendo.io.w2.e(module, dVar2);
            b bVar = b.a;
            sdk.pendo.io.z2.d<?> dVar3 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(companion.a(), Reflection.getOrCreateKotlinClass(sdk.pendo.io.m7.a.class), null, bVar, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar3);
            if (module.get_createdAtStart()) {
                module.a(dVar3);
            }
            new sdk.pendo.io.w2.e(module, dVar3);
            C0438c c0438c = C0438c.a;
            sdk.pendo.io.z2.d<?> dVar4 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(companion.a(), Reflection.getOrCreateKotlinClass(sdk.pendo.io.k7.a.class), null, c0438c, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar4);
            if (module.get_createdAtStart()) {
                module.a(dVar4);
            }
            new sdk.pendo.io.w2.e(module, dVar4);
            d dVar5 = new d(this.a);
            sdk.pendo.io.z2.d<?> dVar6 = new sdk.pendo.io.z2.d<>(new sdk.pendo.io.w2.a(companion.a(), Reflection.getOrCreateKotlinClass(e.class), null, dVar5, dVar, CollectionsKt.emptyList()));
            module.a((sdk.pendo.io.z2.c<?>) dVar6);
            if (module.get_createdAtStart()) {
                module.a(dVar6);
            }
            new sdk.pendo.io.w2.e(module, dVar6);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(sdk.pendo.io.b3.a aVar) {
            a(aVar);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sdk.pendo.io.b3.a b(Context context) {
        return sdk.pendo.io.g3.b.a(false, new C0437c(context), 1, null);
    }
}
