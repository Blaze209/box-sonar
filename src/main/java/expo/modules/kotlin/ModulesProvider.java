package expo.modules.kotlin;

import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.services.Service;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: ModulesProvider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H&J\u0016\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\u00040\bH\u0016¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/ModulesProvider;", "", "getModulesMap", "", "Ljava/lang/Class;", "Lexpo/modules/kotlin/modules/Module;", "", "getServices", "", "Lexpo/modules/kotlin/services/Service;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ModulesProvider {
    Map<Class<? extends Module>, String> getModulesMap();

    List<Class<? extends Service>> getServices();

    /* JADX INFO: compiled from: ModulesProvider.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static List<Class<? extends Service>> getServices(ModulesProvider modulesProvider) {
            return CollectionsKt.emptyList();
        }
    }
}
