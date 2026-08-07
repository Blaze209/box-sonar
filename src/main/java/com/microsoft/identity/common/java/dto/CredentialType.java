package com.microsoft.identity.common.java.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v2 com.microsoft.identity.common.java.dto.CredentialType, still in use, count: 1, list:
  (r0v2 com.microsoft.identity.common.java.dto.CredentialType) from 0x0061: FILLED_NEW_ARRAY 
  (r0v2 com.microsoft.identity.common.java.dto.CredentialType)
  (r1v3 com.microsoft.identity.common.java.dto.CredentialType)
 A[WRAPPED] (LINE:79) elemType: com.microsoft.identity.common.java.dto.CredentialType
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes14.dex */
public final class CredentialType {
    RefreshToken,
    AccessToken,
    IdToken,
    V1IdToken,
    Password,
    Cookie,
    Certificate,
    AccessToken_With_AuthScheme,
    PrimaryRefreshToken;

    public static final Collection<CredentialType> ID_TOKEN_TYPES = Collections.unmodifiableList(Arrays.asList(new CredentialType(), new CredentialType()));

    private CredentialType() {
        super(str, i);
    }

    public static CredentialType valueOf(String str) {
        return (CredentialType) Enum.valueOf(CredentialType.class, str);
    }

    public static CredentialType[] values() {
        return (CredentialType[]) $VALUES.clone();
    }

    static {
    }

    public static Set<String> valueSet() {
        HashSet hashSet = new HashSet();
        for (CredentialType credentialType : values()) {
            hashSet.add(credentialType.name());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static CredentialType fromString(String str) {
        for (CredentialType credentialType : values()) {
            if (credentialType.name().equalsIgnoreCase(str)) {
                return credentialType;
            }
        }
        return null;
    }
}
