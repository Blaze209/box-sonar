package expo.modules.interfaces.constants;

import expo.modules.kotlin.services.Service;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConstantsInterface.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R \u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lexpo/modules/interfaces/constants/ConstantsInterface;", "Lexpo/modules/kotlin/services/Service;", "constants", "", "", "", "getConstants", "()Ljava/util/Map;", "appScopeKey", "getAppScopeKey", "()Ljava/lang/String;", "deviceName", "getDeviceName", "statusBarHeight", "", "getStatusBarHeight", "()I", "systemVersion", "getSystemVersion", "systemFonts", "", "getSystemFonts", "()Ljava/util/List;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ConstantsInterface extends Service {
    String getAppScopeKey();

    Map<String, Object> getConstants();

    String getDeviceName();

    int getStatusBarHeight();

    List<String> getSystemFonts();

    String getSystemVersion();
}
