package sdk.pendo.io.g3;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002!\b\u0002\u0010\u0007\u001a\u001b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0004\u0018\u0001`\u0005¢\u0006\u0002\b\u0006H\u0007*,\u0010\t\"\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u00062\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0006¨\u0006\n"}, d2 = {"", "createEagerInstances", "Lkotlin/Function1;", "Lsdk/pendo/io/u2/b;", "", "Lexternal/sdk/pendo/io/org/koin/dsl/KoinAppDeclaration;", "Lkotlin/ExtensionFunctionType;", "appDeclaration", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "KoinAppDeclaration", "koin-core"}, k = 2, mv = {1, 9, 0})
public final class a {
    public static final sdk.pendo.io.u2.b a(boolean z, Function1<? super sdk.pendo.io.u2.b, Unit> function1) {
        sdk.pendo.io.u2.b bVarA = sdk.pendo.io.u2.b.INSTANCE.a();
        if (function1 != null) {
            function1.invoke(bVarA);
        }
        if (z) {
            bVarA.a();
        }
        return bVarA;
    }

    public static /* synthetic */ sdk.pendo.io.u2.b a(boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        return a(z, function1);
    }
}
