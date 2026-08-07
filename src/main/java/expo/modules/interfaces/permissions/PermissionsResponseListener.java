package expo.modules.interfaces.permissions;

import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
@FunctionalInterface
public interface PermissionsResponseListener {
    void onResult(Map<String, PermissionsResponse> map);
}
