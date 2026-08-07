package com.microsoft.identity.common.java.util;

import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TenantUtil.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/java/util/TenantUtil;", "", "()V", "EMAIL_REGEX", "Lkotlin/text/Regex;", "TAG", "", "UUID_REGEX", "getTenantFromIdentifier", "identifier", "getTenantIdFromLoginHint", "loginHint", "correlationId", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TenantUtil {
    private static final String TAG = "TenantUtil";
    public static final TenantUtil INSTANCE = new TenantUtil();
    private static final Regex EMAIL_REGEX = new Regex("^[^@]+@[^@]+\\.[^@]+$");
    private static final Regex UUID_REGEX = new Regex("^[0-9A-Fa-f\\-]{36}$");

    private TenantUtil() {
    }

    public final String getTenantFromIdentifier(String identifier) {
        String str = identifier;
        if (str != null && !StringsKt.isBlank(str)) {
            if (UUID_REGEX.matches(str)) {
                return identifier;
            }
            if (EMAIL_REGEX.matches(str)) {
                return StringsKt.trim((CharSequence) StringsKt.substringAfter$default(identifier, CommentEntityDomainMapper.MENTIONS_SYMBOL, (String) null, 2, (Object) null)).toString();
            }
            Logger.warn("TenantUtil:getTenantFromIdentifier", "Identifier is neither a valid email/UPN nor a GUID.");
        }
        return null;
    }

    public final String getTenantIdFromLoginHint(String loginHint, String correlationId) {
        String tenantFromIdentifier = getTenantFromIdentifier(loginHint);
        if (tenantFromIdentifier == null) {
            Logger.warn("TenantUtil:getTenantIdFromLoginHint", correlationId, "Login hint is invalid or empty.");
            return null;
        }
        try {
            String tenantIdFromOpenIdProviderConfiguration = AzureActiveDirectoryAudience.getTenantIdFromOpenIdProviderConfiguration(AzureActiveDirectory.loadOpenIdProviderConfigurationMetadataForTenant(tenantFromIdentifier));
            Logger.info("TenantUtil:getTenantIdFromLoginHint", correlationId, "Successfully got tenant ID from login hint.");
            return tenantIdFromOpenIdProviderConfiguration;
        } catch (Exception e) {
            Logger.error("TenantUtil:getTenantIdFromLoginHint", correlationId, "Failed to get tenant ID from login hint.", e);
            return null;
        }
    }
}
