package com.microsoft.identity.common.java.util;

/* JADX INFO: loaded from: classes14.dex */
public class ClientExtraSku {
    private String mBrowserCoreVer;
    private String mBrowserExtSku;
    private String mBrowserExtVer;
    private String mMsalCppCoreVer;
    private String mMsalRuntimeVer;
    private String mSrcSku;
    private String mSrcSkuVer;

    public static class ClientExtraSkuBuilder {
        private boolean browserCoreVer$set;
        private String browserCoreVer$value;
        private boolean browserExtSku$set;
        private String browserExtSku$value;
        private boolean browserExtVer$set;
        private String browserExtVer$value;
        private boolean msalCppCoreVer$set;
        private String msalCppCoreVer$value;
        private boolean msalRuntimeVer$set;
        private String msalRuntimeVer$value;
        private boolean srcSku$set;
        private String srcSku$value;
        private boolean srcSkuVer$set;
        private String srcSkuVer$value;

        ClientExtraSkuBuilder() {
        }

        public ClientExtraSkuBuilder browserCoreVer(String str) {
            this.browserCoreVer$value = str;
            this.browserCoreVer$set = true;
            return this;
        }

        public ClientExtraSkuBuilder browserExtSku(String str) {
            this.browserExtSku$value = str;
            this.browserExtSku$set = true;
            return this;
        }

        public ClientExtraSkuBuilder browserExtVer(String str) {
            this.browserExtVer$value = str;
            this.browserExtVer$set = true;
            return this;
        }

        public ClientExtraSku build() {
            String str$default$srcSku = this.srcSku$value;
            if (!this.srcSku$set) {
                str$default$srcSku = ClientExtraSku.$default$srcSku();
            }
            String str = str$default$srcSku;
            String str$default$srcSkuVer = this.srcSkuVer$value;
            if (!this.srcSkuVer$set) {
                str$default$srcSkuVer = ClientExtraSku.$default$srcSkuVer();
            }
            String str2 = str$default$srcSkuVer;
            String str$default$msalRuntimeVer = this.msalRuntimeVer$value;
            if (!this.msalRuntimeVer$set) {
                str$default$msalRuntimeVer = ClientExtraSku.$default$msalRuntimeVer();
            }
            String str3 = str$default$msalRuntimeVer;
            String str$default$browserExtSku = this.browserExtSku$value;
            if (!this.browserExtSku$set) {
                str$default$browserExtSku = ClientExtraSku.$default$browserExtSku();
            }
            String str4 = str$default$browserExtSku;
            String str$default$browserExtVer = this.browserExtVer$value;
            if (!this.browserExtVer$set) {
                str$default$browserExtVer = ClientExtraSku.$default$browserExtVer();
            }
            String str5 = str$default$browserExtVer;
            String str$default$browserCoreVer = this.browserCoreVer$value;
            if (!this.browserCoreVer$set) {
                str$default$browserCoreVer = ClientExtraSku.$default$browserCoreVer();
            }
            String str6 = str$default$browserCoreVer;
            String str$default$msalCppCoreVer = this.msalCppCoreVer$value;
            if (!this.msalCppCoreVer$set) {
                str$default$msalCppCoreVer = ClientExtraSku.$default$msalCppCoreVer();
            }
            return new ClientExtraSku(str, str2, str3, str4, str5, str6, str$default$msalCppCoreVer);
        }

        public ClientExtraSkuBuilder msalCppCoreVer(String str) {
            this.msalCppCoreVer$value = str;
            this.msalCppCoreVer$set = true;
            return this;
        }

        public ClientExtraSkuBuilder msalRuntimeVer(String str) {
            this.msalRuntimeVer$value = str;
            this.msalRuntimeVer$set = true;
            return this;
        }

        public ClientExtraSkuBuilder srcSku(String str) {
            this.srcSku$value = str;
            this.srcSku$set = true;
            return this;
        }

        public ClientExtraSkuBuilder srcSkuVer(String str) {
            this.srcSkuVer$value = str;
            this.srcSkuVer$set = true;
            return this;
        }

        public String toString() {
            return "ClientExtraSku.ClientExtraSkuBuilder(srcSku$value=" + this.srcSku$value + ", srcSkuVer$value=" + this.srcSkuVer$value + ", msalRuntimeVer$value=" + this.msalRuntimeVer$value + ", browserExtSku$value=" + this.browserExtSku$value + ", browserExtVer$value=" + this.browserExtVer$value + ", browserCoreVer$value=" + this.browserCoreVer$value + ", msalCppCoreVer$value=" + this.msalCppCoreVer$value + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String $default$browserCoreVer() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String $default$browserExtSku() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String $default$browserExtVer() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String $default$msalCppCoreVer() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String $default$msalRuntimeVer() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String $default$srcSku() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String $default$srcSkuVer() {
        return "";
    }

    ClientExtraSku(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.mSrcSku = str;
        this.mSrcSkuVer = str2;
        this.mMsalRuntimeVer = str3;
        this.mBrowserExtSku = str4;
        this.mBrowserExtVer = str5;
        this.mBrowserCoreVer = str6;
        this.mMsalCppCoreVer = str7;
    }

    public static ClientExtraSkuBuilder builder() {
        return new ClientExtraSkuBuilder();
    }

    public String toString() {
        return this.mSrcSku + "|" + this.mSrcSkuVer + ",|" + this.mMsalRuntimeVer + "," + this.mBrowserExtSku + "|" + this.mBrowserExtVer + ",|" + this.mBrowserCoreVer + ",|" + this.mMsalCppCoreVer;
    }
}
