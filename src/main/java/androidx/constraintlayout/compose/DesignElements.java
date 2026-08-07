package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000529\u0010\u0010\u001a5\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\u0010\u0011R\u009d\u0001\u0010\u0003\u001a\u0084\u0001\u0012\u0004\u0012\u00020\u0005\u00127\u00125\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t0\u0004jA\u0012\u0004\u0012\u00020\u0005\u00127\u00125\u0012\u0004\u0012\u00020\u0005\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/constraintlayout/compose/DesignElements;", "", "()V", "map", "Ljava/util/HashMap;", "", "Lkotlin/Function2;", "Lkotlin/collections/HashMap;", "", "Landroidx/compose/runtime/Composable;", "getMap", "()Ljava/util/HashMap;", "setMap", "(Ljava/util/HashMap;)V", "define", "name", "function", "(Ljava/lang/String;Lkotlin/jvm/functions/Function4;)V", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DesignElements {
    public static final DesignElements INSTANCE = new DesignElements();
    private static HashMap<String, Function4<String, HashMap<String, String>, Composer, Integer, Unit>> map = new HashMap<>();
    public static final int $stable = 8;

    private DesignElements() {
    }

    public final HashMap<String, Function4<String, HashMap<String, String>, Composer, Integer, Unit>> getMap() {
        return map;
    }

    public final void setMap(HashMap<String, Function4<String, HashMap<String, String>, Composer, Integer, Unit>> map2) {
        map = map2;
    }

    public final void define(String name, Function4<? super String, ? super HashMap<String, String>, ? super Composer, ? super Integer, Unit> function) {
        map.put(name, function);
    }
}
