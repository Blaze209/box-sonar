package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.commands.ICommand;
import com.microsoft.identity.common.java.exception.ClientException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.net.ssl.KeyManagerFactory;

/* JADX INFO: loaded from: classes14.dex */
public interface IPlatformUtil {
    String getEnrollmentId(String str, String str2);

    String getInstalledCompanyPortalVersion();

    long getNanosecondTime();

    String getPackageNameFromUid(int i);

    KeyManagerFactory getSslContextKeyManagerFactory() throws NoSuchAlgorithmException;

    boolean isValidCallingApp(String str, String str2);

    void onReturnCommandResult(ICommand<?> iCommand);

    void postCommandResult(Runnable runnable);

    void removeCookiesFromWebView();

    void throwIfNetworkNotAvailable(boolean z) throws ClientException;

    List<Map.Entry<String, String>> updateWithAndGetPlatformSpecificExtraQueryParameters(List<Map.Entry<String, String>> list);
}
