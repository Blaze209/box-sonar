package sdk.pendo.io.u2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import sdk.pendo.io.e3.c;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u0010\u0019JC\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\u000b\u001a\u00020\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u000b\u001a\u00020\u0013R \u0010\u001a\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R \u0010 \u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001c\u0010\u001eR \u0010'\u001a\u00020!8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\"\u0010#\u0012\u0004\b&\u0010\u0019\u001a\u0004\b$\u0010%R \u0010-\u001a\u00020(8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010)\u0012\u0004\b,\u0010\u0019\u001a\u0004\b*\u0010+R*\u00104\u001a\u00020.2\u0006\u0010/\u001a\u00020.8\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u0012\u0004\b3\u0010\u0019\u001a\u0004\b\"\u00102¨\u00066"}, d2 = {"Lsdk/pendo/io/u2/a;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "clazz", "Lsdk/pendo/io/d3/a;", "qualifier", "Lkotlin/Function0;", "Lsdk/pendo/io/c3/a;", "Lexternal/sdk/pendo/io/org/koin/core/parameter/ParametersDefinition;", "parameters", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/reflect/KClass;Lsdk/pendo/io/d3/a;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "Lsdk/pendo/io/b3/a;", "modules", "", "allowOverride", "createEagerInstances", "", "Lsdk/pendo/io/e3/c;", "Lsdk/pendo/io/e3/c;", "d", "()Lsdk/pendo/io/e3/c;", "getScopeRegistry$annotations", "()V", "scopeRegistry", "Lsdk/pendo/io/e3/a;", "b", "Lsdk/pendo/io/e3/a;", "()Lsdk/pendo/io/e3/a;", "getInstanceRegistry$annotations", "instanceRegistry", "Lsdk/pendo/io/e3/b;", "c", "Lsdk/pendo/io/e3/b;", "getPropertyRegistry", "()Lsdk/pendo/io/e3/b;", "getPropertyRegistry$annotations", "propertyRegistry", "Lsdk/pendo/io/y2/a;", "Lsdk/pendo/io/y2/a;", "getExtensionManager", "()Lsdk/pendo/io/y2/a;", "getExtensionManager$annotations", "extensionManager", "Lsdk/pendo/io/a3/c;", "<set-?>", "e", "Lsdk/pendo/io/a3/c;", "()Lsdk/pendo/io/a3/c;", "getLogger$annotations", "logger", "<init>", "koin-core"}, k = 1, mv = {1, 9, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final c scopeRegistry = new c(this);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.e3.a instanceRegistry = new sdk.pendo.io.e3.a(this);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.e3.b propertyRegistry = new sdk.pendo.io.e3.b(this);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.y2.a extensionManager = new sdk.pendo.io.y2.a(this);

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private sdk.pendo.io.a3.c logger = new sdk.pendo.io.a3.a();

    public final void a() {
        this.logger.a("Create eager instances ...");
        sdk.pendo.io.i3.a aVar = sdk.pendo.io.i3.a.a;
        long jA = aVar.a();
        this.instanceRegistry.a();
        this.logger.a("Created eager instances in " + ((Number) new Pair(Unit.INSTANCE, Double.valueOf((aVar.a() - jA) / 1000000.0d)).getSecond()).doubleValue() + " ms");
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final sdk.pendo.io.e3.a getInstanceRegistry() {
        return this.instanceRegistry;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final sdk.pendo.io.a3.c getLogger() {
        return this.logger;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final c getScopeRegistry() {
        return this.scopeRegistry;
    }

    public final <T> T a(KClass<?> clazz, sdk.pendo.io.d3.a qualifier, Function0<? extends sdk.pendo.io.c3.a> parameters) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.scopeRegistry.getRootScope().b(clazz, qualifier, parameters);
    }

    public final void a(List<sdk.pendo.io.b3.a> modules, boolean allowOverride, boolean createEagerInstances) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        Set<sdk.pendo.io.b3.a> setA = sdk.pendo.io.b3.b.a(modules);
        this.instanceRegistry.a(setA, allowOverride);
        this.scopeRegistry.a(setA);
        if (createEagerInstances) {
            a();
        }
    }

    public static /* synthetic */ void a(a aVar, List list, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        aVar.a((List<sdk.pendo.io.b3.a>) list, z, z2);
    }
}
