package com.microsoft.intune.mam.policy;

import android.content.Context;
import android.content.SharedPreferences;
import com.microsoft.intune.mam.client.app.DirectBootUtils;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
class MAMWEAccountRegistry {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMWEAccountRegistry.class);
    private static final String SHARED_PREFS_NAME = "com.microsoft.intune.mam.accountRegistry";
    private final Context mContext;
    private final MAMLogPIIFactory mMAMLogPIIFactory;

    public static class AccountInfo {
        private static final int INFO_ITEMS_COUNT_MIN = 4;
        private static final int ITEM_AUTHORITY = 5;
        private static final int ITEM_LAST_ERROR = 4;
        private static final int ITEM_NEEDS_TOKEN = 2;
        private static final int ITEM_STATUS = 1;
        private static final int ITEM_TENANTID = 6;
        private static final int ITEM_TIMESTAMP = 3;
        private static final String SEPARATOR = ";";
        private static final String TOSTRING_FORMAT = "%s;%d;%d;%d;%s;%s;%s";
        public final String mAadId;
        public final String mAuthority;
        public final MAMWEError mError;
        public final MAMEnrollmentManager.Result mStatus;
        public final String mTenantId;
        public final long mTimestamp;
        public final TokenNeededReason mTokenReason;
        public final String mUpn;

        public AccountInfo(String str, String str2, MAMEnrollmentManager.Result result, TokenNeededReason tokenNeededReason, MAMWEError mAMWEError, String str3, String str4) {
            this(str, str2, result, tokenNeededReason, mAMWEError, str3, str4, System.currentTimeMillis());
        }

        public AccountInfo(String str, String str2, MAMEnrollmentManager.Result result, TokenNeededReason tokenNeededReason, MAMWEError mAMWEError, String str3, String str4, long j) {
            this.mUpn = str;
            this.mAadId = str2;
            this.mTenantId = str4;
            this.mStatus = result;
            this.mTokenReason = tokenNeededReason;
            this.mTimestamp = j;
            this.mError = mAMWEError;
            this.mAuthority = str3;
        }

        public String toString() {
            MAMEnrollmentManager.Result result = this.mStatus;
            int code = result == null ? -1 : result.getCode();
            TokenNeededReason tokenNeededReason = this.mTokenReason;
            return String.format(Locale.US, TOSTRING_FORMAT, this.mUpn, Integer.valueOf(code), Integer.valueOf(tokenNeededReason != null ? tokenNeededReason.getCode() : -1), Long.valueOf(this.mTimestamp), Integer.valueOf(this.mError.getCode()), this.mAuthority, this.mTenantId);
        }

        static AccountInfo parse(String str, String str2) {
            String str3;
            String str4;
            if (str == null) {
                return null;
            }
            String[] strArrSplit = str.split(";");
            if (strArrSplit.length < 4) {
                return null;
            }
            try {
                int iIntValue = Integer.valueOf(strArrSplit[1]).intValue();
                int iIntValue2 = Integer.valueOf(strArrSplit[2]).intValue();
                long jLongValue = Long.valueOf(strArrSplit[3]).longValue();
                MAMWEError mAMWEErrorFromCode = MAMWEError.NONE_KNOWN;
                if (strArrSplit.length > 4 && (mAMWEErrorFromCode = MAMWEError.fromCode(Integer.valueOf(strArrSplit[4]).intValue())) == null) {
                    MAMWEAccountRegistry.LOGGER.error(MAMInterfaceError.ACCOUNT_REGISTRY_FAILED_TO_PARSE_LAST_ERROR, "Unable to parse last error in account info", new Object[0]);
                    mAMWEErrorFromCode = MAMWEError.NONE_KNOWN;
                }
                MAMWEError mAMWEError = mAMWEErrorFromCode;
                if (strArrSplit.length > 5) {
                    String strValueOf = String.valueOf(strArrSplit[5]);
                    str3 = strValueOf.equals(AbstractJsonLexerKt.NULL) ? null : strValueOf;
                }
                if (strArrSplit.length > 6) {
                    String strValueOf2 = String.valueOf(strArrSplit[6]);
                    str4 = strValueOf2.equals(AbstractJsonLexerKt.NULL) ? null : strValueOf2;
                }
                return new AccountInfo(strArrSplit[0], str2, MAMEnrollmentManager.Result.fromCode(iIntValue), TokenNeededReason.fromCode(iIntValue2), mAMWEError, str3, str4, jLongValue);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
    }

    public MAMWEAccountRegistry(Context context, MAMLogPIIFactory mAMLogPIIFactory) {
        this.mContext = context;
        this.mMAMLogPIIFactory = mAMLogPIIFactory;
    }

    public boolean registerAccount(MAMIdentity mAMIdentity) {
        if (mAMIdentity == null) {
            LOGGER.warning("registerAccount() called with null identity.", new Object[0]);
            return false;
        }
        if (mAMIdentity.aadId() == null || mAMIdentity.aadId().isEmpty()) {
            LOGGER.warning("registerAccount() called without providing AAD ID for {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
            return false;
        }
        AccountInfo accountInfoInternal = getAccountInfoInternal(mAMIdentity);
        if (accountInfoInternal != null) {
            LOGGER.info("registerAccount() called for already registered account: {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
            updateAccount(accountInfoInternal, mAMIdentity, accountInfoInternal.mStatus, accountInfoInternal.mError, accountInfoInternal.mTokenReason, Long.valueOf(accountInfoInternal.mTimestamp));
            return false;
        }
        LOGGER.info("registering account {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
        storeAccount(mAMIdentity.rawUPN(), mAMIdentity.aadId(), MAMEnrollmentManager.Result.PENDING, TokenNeededReason.NOT_NEEDED, MAMWEError.NONE_KNOWN, mAMIdentity.authority(), mAMIdentity.tenantId());
        return true;
    }

    public AccountInfo updateAccount(MAMIdentity mAMIdentity, MAMEnrollmentManager.Result result, MAMWEError mAMWEError, TokenNeededReason tokenNeededReason) {
        if (mAMIdentity == null) {
            LOGGER.warning("updateAccount() called with null identity.", new Object[0]);
            return null;
        }
        AccountInfo accountInfoInternal = getAccountInfoInternal(mAMIdentity);
        if (accountInfoInternal == null) {
            return null;
        }
        LOGGER.info("updating account {0} with status {1}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity), result.toString());
        return updateAccount(accountInfoInternal, mAMIdentity, result, mAMWEError, tokenNeededReason, null);
    }

    private AccountInfo updateAccount(AccountInfo accountInfo, MAMIdentity mAMIdentity, MAMEnrollmentManager.Result result, MAMWEError mAMWEError, TokenNeededReason tokenNeededReason, Long l) {
        String strRawUPN = accountInfo.mUpn;
        if (!mAMIdentity.hasUPN(strRawUPN)) {
            strRawUPN = mAMIdentity.rawUPN();
        }
        String str = strRawUPN;
        String strAuthority = accountInfo.mAuthority;
        if (mAMIdentity.validated() || strAuthority == null) {
            strAuthority = mAMIdentity.authority();
        }
        String str2 = strAuthority;
        String strTenantId = accountInfo.mTenantId;
        if (mAMIdentity.validated() || strTenantId == null) {
            strTenantId = mAMIdentity.tenantId();
        }
        AccountInfo accountInfo2 = new AccountInfo(str, accountInfo.mAadId, result, tokenNeededReason, mAMWEError, str2, strTenantId, l == null ? System.currentTimeMillis() : l.longValue());
        if (!accountInfo2.toString().equals(accountInfo.toString())) {
            storeAccount(accountInfo2);
        }
        return accountInfo2;
    }

    public void setAccountNeedsToken(MAMIdentity mAMIdentity, TokenNeededReason tokenNeededReason) {
        if (mAMIdentity == null) {
            LOGGER.warning("setAccountNeedsToken() called with null identity.", new Object[0]);
            return;
        }
        AccountInfo accountInfoInternal = getAccountInfoInternal(mAMIdentity);
        if (accountInfoInternal == null) {
            return;
        }
        LOGGER.info("updating account {0} with TokenNeededReason: {1}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity), String.valueOf(tokenNeededReason));
        updateAccount(accountInfoInternal, mAMIdentity, accountInfoInternal.mStatus, accountInfoInternal.mError, tokenNeededReason, Long.valueOf(accountInfoInternal.mTimestamp));
    }

    public boolean removeAccount(MAMIdentity mAMIdentity) {
        if (mAMIdentity == null) {
            LOGGER.warning("removeAccount() called with null identity.", new Object[0]);
            return false;
        }
        AccountInfo accountInfoInternal = getAccountInfoInternal(mAMIdentity);
        if (accountInfoInternal == null) {
            LOGGER.info("removeAccount() called for account that is not registered: {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
            return false;
        }
        LOGGER.info("removing account {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
        SharedPreferences.Editor editor = getEditor();
        editor.remove(accountInfoInternal.mAadId);
        editor.commit();
        return true;
    }

    public AccountInfo getAccountInfo(MAMIdentity mAMIdentity) {
        return getAccountInfoInternal(mAMIdentity);
    }

    private AccountInfo getAccountInfoInternal(MAMIdentity mAMIdentity) {
        if (mAMIdentity == null) {
            return null;
        }
        String strAadId = mAMIdentity.aadId();
        if (strAadId == null || strAadId.isEmpty()) {
            for (AccountInfo accountInfo : getAllAccountsInternal()) {
                if (mAMIdentity.hasUPN(accountInfo.mUpn)) {
                    return accountInfo;
                }
            }
        } else {
            String string = getPrefs().getString(strAadId, null);
            if (string != null) {
                return parseAccountInfo(string, strAadId, "getAccountInfo()");
            }
        }
        LOGGER.info("getAccountInfo() called for account that is not registered: {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
        return null;
    }

    public List<AccountInfo> getAllAccounts() {
        return getAllAccountsInternal();
    }

    private List<AccountInfo> getAllAccountsInternal() {
        ArrayList arrayList = new ArrayList();
        Map<String, ?> all = getPrefs().getAll();
        if (all != null) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                AccountInfo accountInfo = parseAccountInfo(entry.getValue().toString(), entry.getKey(), "getAllAccounts()");
                if (accountInfo != null) {
                    arrayList.add(accountInfo);
                }
            }
        }
        return arrayList;
    }

    private AccountInfo parseAccountInfo(String str, String str2, String str3) {
        AccountInfo accountInfo = AccountInfo.parse(str, str2);
        if (accountInfo == null) {
            LOGGER.warning(str3 + " found invalid data in account registry", new Object[0]);
        }
        return accountInfo;
    }

    private AccountInfo storeAccount(String str, String str2, MAMEnrollmentManager.Result result, TokenNeededReason tokenNeededReason, MAMWEError mAMWEError, String str3, String str4) {
        AccountInfo accountInfo = new AccountInfo(str, str2, result, tokenNeededReason, mAMWEError, str3, str4);
        storeAccount(accountInfo);
        return accountInfo;
    }

    private void storeAccount(AccountInfo accountInfo) {
        SharedPreferences.Editor editor = getEditor();
        editor.putString(accountInfo.mAadId, accountInfo.toString());
        editor.commit();
    }

    private SharedPreferences getPrefs() {
        return DirectBootUtils.getDirectBootAwareContext(this.mContext).getSharedPreferences("com.microsoft.intune.mam.accountRegistry", 0);
    }

    private SharedPreferences.Editor getEditor() {
        return getPrefs().edit();
    }
}
