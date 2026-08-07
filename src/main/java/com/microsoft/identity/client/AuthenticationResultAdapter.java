package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalDeclinedScopeException;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public class AuthenticationResultAdapter {
    private static final String TAG = "com.microsoft.identity.client.AuthenticationResultAdapter";

    public static IAuthenticationResult adapt(ILocalAuthenticationResult iLocalAuthenticationResult) {
        return new AuthenticationResult(iLocalAuthenticationResult.getCacheRecordWithTenantProfileData(), iLocalAuthenticationResult.getCorrelationId());
    }

    static MsalDeclinedScopeException declinedScopeExceptionFromResult(ILocalAuthenticationResult iLocalAuthenticationResult, List<String> list, TokenParameters tokenParameters) {
        AcquireTokenSilentParameters acquireTokenSilentParametersSilentParametersFromInteractive;
        String str = TAG + ":declinedScopeExceptionFromResult";
        List<String> listAsList = Arrays.asList(iLocalAuthenticationResult.getScope());
        com.microsoft.identity.common.logging.Logger.warn(str, "Returning DeclinedScopeException as not all requested scopes are granted, Requested scopes: " + tokenParameters.getScopes().toString() + " Granted scopes:" + listAsList.toString());
        if (tokenParameters instanceof AcquireTokenSilentParameters) {
            acquireTokenSilentParametersSilentParametersFromInteractive = (AcquireTokenSilentParameters) tokenParameters;
        } else {
            acquireTokenSilentParametersSilentParametersFromInteractive = TokenParametersAdapter.silentParametersFromInteractive((AcquireTokenParameters) tokenParameters, iLocalAuthenticationResult);
        }
        acquireTokenSilentParametersSilentParametersFromInteractive.setScopes(listAsList);
        return new MsalDeclinedScopeException(listAsList, list, acquireTokenSilentParametersSilentParametersFromInteractive);
    }

    static List<String> getDeclinedScopes(List<String> list, List<String> list2) {
        HashSet hashSet = new HashSet();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toLowerCase(Locale.ROOT));
        }
        HashSet<String> hashSet2 = new HashSet();
        Iterator<String> it2 = list2.iterator();
        while (it2.hasNext()) {
            hashSet2.add(it2.next().toLowerCase(Locale.ROOT));
        }
        ArrayList arrayList = new ArrayList();
        for (String str : hashSet2) {
            if (!hashSet.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
