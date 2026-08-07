package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public interface IAccountCredentialCache {
    void clearAll();

    AccountRecord getAccount(String str);

    List<AccountRecord> getAccounts();

    List<AccountRecord> getAccountsFilteredBy(String str, String str2, String str3);

    Credential getCredential(String str);

    List<Credential> getCredentials();

    List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8);

    List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<Credential> list);

    List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, List<Credential> list);

    List<Credential> getCredentialsFilteredBy(String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, List<Credential> list);

    List<Credential> getCredentialsFilteredBy(String str, String str2, Set<CredentialType> set, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    List<Credential> getCredentialsFilteredBy(List<Credential> list, String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10);

    boolean removeAccount(AccountRecord accountRecord);

    boolean removeCredential(Credential credential);

    void saveAccount(AccountRecord accountRecord);

    void saveCredential(Credential credential);
}
