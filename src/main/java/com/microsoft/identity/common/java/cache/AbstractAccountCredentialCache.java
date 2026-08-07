package com.microsoft.identity.common.java.cache;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.dto.CredentialType;
import com.microsoft.identity.common.java.dto.IdTokenRecord;
import com.microsoft.identity.common.java.dto.PrimaryRefreshTokenRecord;
import com.microsoft.identity.common.java.dto.RefreshTokenRecord;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public abstract class AbstractAccountCredentialCache implements IAccountCredentialCache {
    private static final String NEW_LINE = "\n";
    private static final String TAG = "AbstractAccountCredentialCache";
    protected final INameValueStorage<String> mSharedPreferencesFileManager;

    protected AbstractAccountCredentialCache(INameValueStorage<String> iNameValueStorage) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("sharedPreferencesFileManager is marked non-null but is null");
        }
        this.mSharedPreferencesFileManager = iNameValueStorage;
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.cache.AbstractAccountCredentialCache$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType;

        static {
            int[] iArr = new int[CredentialType.values().length];
            $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType = iArr;
            try {
                iArr[CredentialType.AccessToken.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.AccessToken_With_AuthScheme.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.RefreshToken.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.IdToken.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.V1IdToken.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[CredentialType.PrimaryRefreshToken.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    protected Class<? extends Credential> getTargetClassForCredentialType(String str, CredentialType credentialType) {
        if (credentialType == null) {
            throw new NullPointerException("targetType is marked non-null but is null");
        }
        switch (AnonymousClass1.$SwitchMap$com$microsoft$identity$common$java$dto$CredentialType[credentialType.ordinal()]) {
            case 1:
            case 2:
                return AccessTokenRecord.class;
            case 3:
                return RefreshTokenRecord.class;
            case 4:
            case 5:
                return IdTokenRecord.class;
            case 6:
                return PrimaryRefreshTokenRecord.class;
            default:
                String str2 = TAG;
                Logger.warn(str2, "Could not match CredentialType to class. Did you forget to update this method with a new type?");
                if (str == null) {
                    return null;
                }
                Logger.warnPII(str2, "Sought key was: [" + str + "]");
                return null;
        }
    }

    protected List<AccountRecord> getAccountsFilteredByInternal(String str, String str2, String str3, List<AccountRecord> list) {
        if (list == null) {
            throw new NullPointerException("allAccounts is marked non-null but is null");
        }
        boolean zIsNullOrEmpty = StringUtil.isNullOrEmpty(str);
        boolean zIsNullOrEmpty2 = StringUtil.isNullOrEmpty(str2);
        boolean zIsNullOrEmpty3 = StringUtil.isNullOrEmpty(str3);
        Logger.verbose(TAG, "Account lookup filtered by home_account_id? [" + (!zIsNullOrEmpty) + "]\nAccount lookup filtered by realm? [" + (!zIsNullOrEmpty3) + "]");
        ArrayList arrayList = new ArrayList();
        for (AccountRecord accountRecord : list) {
            if (zIsNullOrEmpty || StringUtil.equalsIgnoreCaseTrimBoth(str, accountRecord.getHomeAccountId())) {
                if (zIsNullOrEmpty2 || StringUtil.equalsIgnoreCaseTrimBoth(str2, accountRecord.getEnvironment())) {
                    if (zIsNullOrEmpty3 || StringUtil.equalsIgnoreCaseTrimBoth(str3, accountRecord.getRealm())) {
                        arrayList.add(accountRecord);
                    }
                }
            }
        }
        Logger.verbose(TAG, "Found [" + arrayList.size() + "] matching accounts");
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0213 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:103:0x0215  */
    /* JADX WARN: Code duplicated, block: B:105:0x0219  */
    /* JADX WARN: Code duplicated, block: B:107:0x021e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0232  */
    /* JADX WARN: Code duplicated, block: B:116:0x023f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x013b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x0147 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x0168 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x016a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0192 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0192 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x01a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x0198 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x01c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:19:0x00db  */
    /* JADX WARN: Code duplicated, block: B:40:0x0127  */
    /* JADX WARN: Code duplicated, block: B:42:0x012b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0149  */
    /* JADX WARN: Code duplicated, block: B:50:0x014d  */
    /* JADX WARN: Code duplicated, block: B:56:0x016c  */
    /* JADX WARN: Code duplicated, block: B:67:0x0194  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ad  */
    protected List<Credential> getCredentialsFilteredByInternal(List<Credential> list, String str, String str2, CredentialType credentialType, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z) {
        boolean z2;
        boolean z3;
        boolean zIsNullOrEmpty;
        boolean zIsNullOrEmpty2;
        ArrayList arrayList;
        String str11 = str6;
        if (list == null) {
            throw new NullPointerException("allCredentials is marked non-null but is null");
        }
        boolean zIsNullOrEmpty3 = StringUtil.isNullOrEmpty(str2);
        boolean zIsNullOrEmpty4 = StringUtil.isNullOrEmpty(str);
        boolean z4 = !zIsNullOrEmpty4;
        boolean zIsNullOrEmpty5 = StringUtil.isNullOrEmpty(str11);
        boolean z5 = !zIsNullOrEmpty5;
        boolean zIsNullOrEmpty6 = StringUtil.isNullOrEmpty(str7);
        boolean z6 = !zIsNullOrEmpty6;
        boolean zIsNullOrEmpty7 = StringUtil.isNullOrEmpty(str3);
        boolean z7 = !zIsNullOrEmpty7;
        boolean zIsNullOrEmpty8 = StringUtil.isNullOrEmpty(str4);
        boolean z8 = !zIsNullOrEmpty8;
        boolean zIsNullOrEmpty9 = StringUtil.isNullOrEmpty(str5);
        boolean z9 = !zIsNullOrEmpty9;
        boolean z10 = credentialType != null;
        if (z10 && !StringUtil.isNullOrEmpty(str8)) {
            z2 = zIsNullOrEmpty5;
            z3 = credentialType == CredentialType.AccessToken_With_AuthScheme;
            zIsNullOrEmpty = StringUtil.isNullOrEmpty(str10);
            zIsNullOrEmpty2 = StringUtil.isNullOrEmpty(str9);
            Logger.verbose(TAG, "Credential lookup filtered by home_account_id? [" + z4 + "]\nCredential lookup filtered by realm? [" + z5 + "]\nCredential lookup filtered by target? [" + z6 + "]\nCredential lookup filtered by clientId? [" + z7 + "]\nCredential lookup filtered by applicationIdentifier? [" + z8 + "]\nCredential lookup filtered by mamEnrollmentIdentifier? [" + z9 + "]\nCredential lookup filtered by credential type? [" + z10 + "]\nCredential lookup filtered by auth scheme? [" + z3 + "]\nCredential lookup filtered by requested claims? [" + (!zIsNullOrEmpty2) + "]");
            arrayList = new ArrayList();
            for (Credential credential : list) {
                if (!zIsNullOrEmpty4 || StringUtil.equalsIgnoreCaseTrimBoth(str, credential.getHomeAccountId())) {
                    if (!zIsNullOrEmpty3 || StringUtil.equalsIgnoreCaseTrimBoth(str2, credential.getEnvironment())) {
                        if (z10 || StringUtil.equalsIgnoreCaseTrimBoth(credentialType.name(), credential.getCredentialType())) {
                            if (!zIsNullOrEmpty7 || StringUtil.equalsIgnoreCaseTrimBoth(str3, credential.getClientId())) {
                                if (zIsNullOrEmpty8) {
                                    if (credential instanceof AccessTokenRecord) {
                                        if (!StringUtil.equalsIgnoreCaseTrimBoth(str4, ((AccessTokenRecord) credential).getApplicationIdentifier())) {
                                        }
                                    } else {
                                        Logger.verbose(TAG, "Query specified applicationIdentifier match, but credential type does not have application identifier");
                                    }
                                }
                                if (zIsNullOrEmpty9) {
                                    if (credential instanceof AccessTokenRecord) {
                                        if (!StringUtil.equalsIgnoreCaseTrimBoth(str5, ((AccessTokenRecord) credential).getMamEnrollmentIdentifier())) {
                                        }
                                    } else {
                                        Logger.verbose(TAG, "Query specified mamEnrollmentIdentifier match, but credential type does not have MAM enrollment identifier");
                                    }
                                }
                                if (z2) {
                                    if (credential instanceof AccessTokenRecord) {
                                        if (!StringUtil.equalsIgnoreCaseTrimBoth(str11, ((AccessTokenRecord) credential).getRealm())) {
                                        }
                                    } else if ((credential instanceof IdTokenRecord) || StringUtil.equalsIgnoreCaseTrimBoth(str11, ((IdTokenRecord) credential).getRealm())) {
                                    }
                                }
                                if (zIsNullOrEmpty6) {
                                    if (credential instanceof AccessTokenRecord) {
                                        if (!targetsIntersect(str7, ((AccessTokenRecord) credential).getTarget(), true)) {
                                        }
                                    } else if (credential instanceof RefreshTokenRecord) {
                                        if (!targetsIntersect(str7, ((RefreshTokenRecord) credential).getTarget(), true)) {
                                        }
                                    } else {
                                        Logger.verbose(TAG, "Query specified target-match, but no target to match.");
                                    }
                                }
                                if (!z3 && (credential instanceof AccessTokenRecord)) {
                                    String accessTokenType = ((AccessTokenRecord) credential).getAccessTokenType();
                                    if (accessTokenType != null) {
                                        accessTokenType = accessTokenType.trim();
                                    }
                                    if (TokenRequest.TokenType.POP.equalsIgnoreCase(accessTokenType)) {
                                        if (str8.equalsIgnoreCase(PopAuthenticationSchemeWithClientKeyInternal.SCHEME_POP_WITH_CLIENT_KEY) || str8.equalsIgnoreCase(PopAuthenticationSchemeInternal.SCHEME_POP)) {
                                        }
                                    } else if (!str8.equalsIgnoreCase(accessTokenType)) {
                                    }
                                }
                                if (!zIsNullOrEmpty || !(credential instanceof AccessTokenRecord)) {
                                    if (zIsNullOrEmpty2 || z) {
                                        if (credential instanceof AccessTokenRecord) {
                                            AccessTokenRecord accessTokenRecord = (AccessTokenRecord) credential;
                                            if ((!z && StringUtil.isNullOrEmpty(str9) && StringUtil.isNullOrEmpty(accessTokenRecord.getRequestedClaims())) || StringUtil.equalsIgnoreCaseTrimBoth(str9, accessTokenRecord.getRequestedClaims())) {
                                            }
                                        } else {
                                            Logger.verbose(TAG, "Query specified requested_claims-match, but attempted to match with non-AT credential type.");
                                        }
                                        arrayList.add(credential);
                                    } else {
                                        arrayList.add(credential);
                                    }
                                    str11 = str6;
                                } else if (str10.equalsIgnoreCase(((AccessTokenRecord) credential).getKid())) {
                                    if (zIsNullOrEmpty2) {
                                        if (credential instanceof AccessTokenRecord) {
                                            AccessTokenRecord accessTokenRecord2 = (AccessTokenRecord) credential;
                                            if (!z) {
                                            }
                                        } else {
                                            Logger.verbose(TAG, "Query specified requested_claims-match, but attempted to match with non-AT credential type.");
                                        }
                                        arrayList.add(credential);
                                    } else {
                                        if (credential instanceof AccessTokenRecord) {
                                            AccessTokenRecord accessTokenRecord3 = (AccessTokenRecord) credential;
                                            if (!z) {
                                            }
                                        } else {
                                            Logger.verbose(TAG, "Query specified requested_claims-match, but attempted to match with non-AT credential type.");
                                        }
                                        arrayList.add(credential);
                                    }
                                    str11 = str6;
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        z2 = zIsNullOrEmpty5;
        zIsNullOrEmpty = StringUtil.isNullOrEmpty(str10);
        zIsNullOrEmpty2 = StringUtil.isNullOrEmpty(str9);
        Logger.verbose(TAG, "Credential lookup filtered by home_account_id? [" + z4 + "]\nCredential lookup filtered by realm? [" + z5 + "]\nCredential lookup filtered by target? [" + z6 + "]\nCredential lookup filtered by clientId? [" + z7 + "]\nCredential lookup filtered by applicationIdentifier? [" + z8 + "]\nCredential lookup filtered by mamEnrollmentIdentifier? [" + z9 + "]\nCredential lookup filtered by credential type? [" + z10 + "]\nCredential lookup filtered by auth scheme? [" + z3 + "]\nCredential lookup filtered by requested claims? [" + (!zIsNullOrEmpty2) + "]");
        arrayList = new ArrayList();
        while (r4.hasNext()) {
            if (!zIsNullOrEmpty4) {
            }
            if (!zIsNullOrEmpty3) {
            }
            if (z10) {
            }
            if (!zIsNullOrEmpty7) {
            }
            if (zIsNullOrEmpty8) {
                if (credential instanceof AccessTokenRecord) {
                    if (!StringUtil.equalsIgnoreCaseTrimBoth(str4, ((AccessTokenRecord) credential).getApplicationIdentifier())) {
                    }
                } else {
                    Logger.verbose(TAG, "Query specified applicationIdentifier match, but credential type does not have application identifier");
                }
            }
            if (zIsNullOrEmpty9) {
                if (credential instanceof AccessTokenRecord) {
                    if (!StringUtil.equalsIgnoreCaseTrimBoth(str5, ((AccessTokenRecord) credential).getMamEnrollmentIdentifier())) {
                    }
                } else {
                    Logger.verbose(TAG, "Query specified mamEnrollmentIdentifier match, but credential type does not have MAM enrollment identifier");
                }
            }
            if (z2) {
                if (credential instanceof AccessTokenRecord) {
                    if (!StringUtil.equalsIgnoreCaseTrimBoth(str11, ((AccessTokenRecord) credential).getRealm())) {
                    }
                } else if (credential instanceof IdTokenRecord) {
                }
            }
            if (zIsNullOrEmpty6) {
                if (credential instanceof AccessTokenRecord) {
                    if (!targetsIntersect(str7, ((AccessTokenRecord) credential).getTarget(), true)) {
                    }
                } else if (credential instanceof RefreshTokenRecord) {
                    if (!targetsIntersect(str7, ((RefreshTokenRecord) credential).getTarget(), true)) {
                    }
                } else {
                    Logger.verbose(TAG, "Query specified target-match, but no target to match.");
                }
            }
            if (!z3) {
            }
            if (!zIsNullOrEmpty) {
            }
            if (zIsNullOrEmpty2) {
                if (credential instanceof AccessTokenRecord) {
                    AccessTokenRecord accessTokenRecord4 = (AccessTokenRecord) credential;
                    if (!z) {
                    }
                } else {
                    Logger.verbose(TAG, "Query specified requested_claims-match, but attempted to match with non-AT credential type.");
                }
                arrayList.add(credential);
            } else {
                if (credential instanceof AccessTokenRecord) {
                    AccessTokenRecord accessTokenRecord5 = (AccessTokenRecord) credential;
                    if (!z) {
                    }
                } else {
                    Logger.verbose(TAG, "Query specified requested_claims-match, but attempted to match with non-AT credential type.");
                }
                arrayList.add(credential);
            }
            str11 = str6;
        }
        return arrayList;
    }

    static boolean targetsIntersect(String str, String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("targetToMatch is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("credentialTarget is marked non-null but is null");
        }
        String[] strArrSplit = str.trim().split("\\s+");
        String[] strArrSplit2 = str2.trim().split("\\s+");
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (String str3 : strArrSplit) {
            hashSet.add(str3.toLowerCase(Locale.ROOT));
        }
        for (String str4 : strArrSplit2) {
            hashSet2.add(str4.toLowerCase(Locale.ROOT));
        }
        if (z) {
            hashSet.removeAll(AuthenticationConstants.DEFAULT_SCOPES);
            hashSet2.removeAll(AuthenticationConstants.DEFAULT_SCOPES);
        }
        return hashSet2.containsAll(hashSet);
    }
}
