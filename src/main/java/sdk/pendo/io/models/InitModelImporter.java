package sdk.pendo.io.models;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.i3.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.k0;
import sdk.pendo.io.w5.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/models/InitModelImporter;", "Lsdk/pendo/io/w5/a;", "Lsdk/pendo/io/models/InitModel;", "getInitModelFromJSONAssetFile", "", "applicationAssetFileName", "Ljava/lang/String;", "Lsdk/pendo/io/s7/k0;", "pendoGSON$delegate", "Lkotlin/Lazy;", "getPendoGSON", "()Lsdk/pendo/io/s7/k0;", "pendoGSON", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class InitModelImporter implements a {
    private final String applicationAssetFileName = "initModel.json";

    /* JADX INFO: renamed from: pendoGSON$delegate, reason: from kotlin metadata */
    private final Lazy pendoGSON;

    /* JADX WARN: Multi-variable type inference failed */
    public InitModelImporter() {
        LazyThreadSafetyMode lazyThreadSafetyModeA = b.a.a();
        final sdk.pendo.io.d3.a aVar = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.pendoGSON = LazyKt.lazy(lazyThreadSafetyModeA, (Function0) new Function0<k0>() { // from class: sdk.pendo.io.models.InitModelImporter$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, sdk.pendo.io.s7.k0] */
            @Override // kotlin.jvm.functions.Function0
            public final k0 invoke() {
                sdk.pendo.io.v2.a aVar2 = this;
                return (aVar2 instanceof sdk.pendo.io.v2.b ? ((sdk.pendo.io.v2.b) aVar2).getScope() : aVar2.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(k0.class), aVar, objArr);
            }
        });
    }

    private final k0 getPendoGSON() {
        return (k0) this.pendoGSON.getValue();
    }

    public final InitModel getInitModelFromJSONAssetFile() {
        try {
            InputStream inputStreamOpen = PendoInternal.o().getAssets().open(this.applicationAssetFileName);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            return (InitModel) getPendoGSON().a().a((Reader) new InputStreamReader(inputStreamOpen, Charsets.UTF_8), InitModel.class);
        } catch (Exception e) {
            PendoLogger.w(e, "InitModelImporter failed to transform the application asset file to Init Model instance", new Object[0]);
            return null;
        }
    }

    @Override // sdk.pendo.io.v2.a
    public sdk.pendo.io.u2.a getKoin() {
        return a.C0510a.a(this);
    }
}
