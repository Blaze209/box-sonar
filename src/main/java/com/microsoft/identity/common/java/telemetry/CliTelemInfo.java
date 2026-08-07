package com.microsoft.identity.common.java.telemetry;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class CliTelemInfo implements Serializable {
    private static final Pattern HEADER_FORMAT_REGULAR_EXPRESSION = Pattern.compile("^[1-9]+\\.?[0-9|\\.]*,[0-9|\\.]*,[0-9|\\.]*,[^,]*[0-9\\.]*,[^,]*$");
    private static final String TAG = "CliTelemInfo";
    private static final long serialVersionUID = -7200606162774338466L;
    private String mRefreshTokenAge;
    private String mServerErrorCode;
    private String mServerSubErrorCode;
    private String mSpeRing;
    private String mVersion;

    public CliTelemInfo() {
    }

    public CliTelemInfo(CliTelemInfo cliTelemInfo) {
        if (cliTelemInfo != null) {
            this.mVersion = cliTelemInfo.mVersion;
            this.mServerErrorCode = cliTelemInfo.mServerErrorCode;
            this.mServerSubErrorCode = cliTelemInfo.mServerSubErrorCode;
            this.mRefreshTokenAge = cliTelemInfo.mRefreshTokenAge;
            this.mSpeRing = cliTelemInfo.mSpeRing;
        }
    }

    public String getVersion() {
        return this.mVersion;
    }

    protected void setVersion(String str) {
        this.mVersion = str;
    }

    public String getServerErrorCode() {
        return this.mServerErrorCode;
    }

    protected void setServerErrorCode(String str) {
        this.mServerErrorCode = str;
    }

    public String getServerSubErrorCode() {
        return this.mServerSubErrorCode;
    }

    protected void setServerSubErrorCode(String str) {
        this.mServerSubErrorCode = str;
    }

    public String getRefreshTokenAge() {
        return this.mRefreshTokenAge;
    }

    public void setRefreshTokenAge(String str) {
        this.mRefreshTokenAge = str;
    }

    public String getSpeRing() {
        return this.mSpeRing;
    }

    public void setSpeRing(String str) {
        this.mSpeRing = str;
    }

    public static CliTelemInfo fromXMsCliTelemHeader(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length == 0) {
            Logger.warn(TAG, "SPE Ring header missing version field.");
            return null;
        }
        String str2 = strArrSplit[0];
        CliTelemInfo cliTelemInfo = new CliTelemInfo();
        cliTelemInfo.setVersion(str2);
        if (str2.equals("1")) {
            if (!HEADER_FORMAT_REGULAR_EXPRESSION.matcher(str).matches()) {
                Logger.warn(TAG, "Malformed x-ms-clitelem header");
                return null;
            }
            String[] strArrSplit2 = str.split(",", 5);
            cliTelemInfo.setServerErrorCode(strArrSplit2[1]);
            cliTelemInfo.setServerSubErrorCode(strArrSplit2[2]);
            cliTelemInfo.setRefreshTokenAge(strArrSplit2[3]);
            cliTelemInfo.setSpeRing(strArrSplit2[4]);
            return cliTelemInfo;
        }
        Logger.warn(TAG, "Unrecognized x-ms-clitelem header version");
        return null;
    }
}
