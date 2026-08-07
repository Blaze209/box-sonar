package com.box.android.domain.utils;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.box.android.domain.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes11.dex */
public class PromotedPartnerApp {
    private static final String TAG_APP = "app";
    private static final String TAG_APP_MIME_TYPES = "mime_types";
    private static final String TAG_APP_PACKAGE = "package";
    public final String mAppName;
    public final boolean mEnabled;
    public final boolean mHasInstallDialog;
    public final boolean mHasTooltip;
    private final int mInstallDialogImageRes;
    public final String mInstallDialogMessage;
    public final String mInstallDialogTitle;
    public final String mInstallUrl;
    public final List<String> mMimeTypes;
    public final String mPackage;
    private final int mTooltipImageRes;
    public final String mTooltipMessage;

    PromotedPartnerApp(String str, String str2, boolean z, boolean z2, int i, String str3, String str4, String str5, boolean z3, int i2, String str6, List<String> list) {
        this.mAppName = str;
        this.mPackage = str2;
        this.mEnabled = z;
        this.mHasTooltip = z3;
        this.mTooltipMessage = str6;
        this.mHasInstallDialog = z2;
        this.mInstallDialogMessage = str5;
        this.mInstallDialogTitle = str4;
        this.mMimeTypes = list;
        this.mInstallDialogImageRes = i;
        this.mTooltipImageRes = i2;
        this.mInstallUrl = str3;
    }

    public String getPackageName() {
        return this.mPackage;
    }

    public int getDialogImageResource() {
        return this.mInstallDialogImageRes;
    }

    public int getTooltipImageResource() {
        return this.mTooltipImageRes;
    }

    public String toString() {
        return this.mAppName + " " + this.mPackage + " " + this.mEnabled + " " + this.mHasInstallDialog + " " + this.mInstallDialogTitle + " " + this.mInstallDialogMessage + " " + this.mHasTooltip + " " + this.mTooltipMessage;
    }

    public static class Builder {
        private boolean mEnabled;
        private boolean mHasInstallDialog;
        private boolean mHasTooltip;
        private int mInstallDialogImageRes;
        private String mInstallDialogMessage;
        private String mInstallDialogTitle;
        private String mInstallUrl;
        private String[] mMimeTypes;
        private String mName;
        private String mPackage;
        private int mTooltipImageRes;
        private String mTooltipMessage;

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setPackage(String str) {
            this.mPackage = str;
            return this;
        }

        public PromotedPartnerApp build() {
            return new PromotedPartnerApp(this.mName, this.mPackage, this.mEnabled, this.mHasInstallDialog, this.mInstallDialogImageRes, this.mInstallUrl, this.mInstallDialogTitle, this.mInstallDialogMessage, this.mHasTooltip, this.mTooltipImageRes, this.mTooltipMessage, Arrays.asList(this.mMimeTypes));
        }

        public Builder setMimeTypes(String str) {
            if (TextUtils.isEmpty(str)) {
                this.mMimeTypes = new String[0];
                return this;
            }
            this.mMimeTypes = str.split(",");
            return this;
        }

        public Builder setEnabled(boolean z) {
            this.mEnabled = z;
            return this;
        }

        public Builder setDialogTitle(String str) {
            this.mInstallDialogTitle = str;
            return this;
        }

        public Builder setDialogMessage(String str) {
            this.mInstallDialogMessage = str;
            return this;
        }

        public Builder setDialogEnabled(boolean z) {
            this.mHasInstallDialog = z;
            return this;
        }

        public Builder setTooltipMessage(String str) {
            this.mTooltipMessage = str;
            return this;
        }

        public Builder setTooltipEnabled(boolean z) {
            this.mHasTooltip = z;
            return this;
        }

        public Builder setDialogImageRes(int i) {
            this.mInstallDialogImageRes = i;
            return this;
        }

        public Builder setDialogInstallUrl(String str) {
            this.mInstallUrl = str;
            return this;
        }

        public Builder setTooltipImageRes(int i) {
            this.mTooltipImageRes = i;
            return this;
        }
    }

    public static class PartnerAppsInfo {
        List<PromotedPartnerApp> mPartnerApps = new ArrayList();
        Map<String, List<Integer>> mimeTypeToPartnerAppPositionsMap = new HashMap();
        boolean loaded = false;

        public synchronized List<PromotedPartnerApp> getPartnerApps(Context context) {
            if (!this.loaded) {
                load(context);
            }
            return this.mPartnerApps;
        }

        public synchronized List<PromotedPartnerApp> getPartnerApps(Context context, String str) {
            ArrayList arrayList;
            if (!this.loaded) {
                load(context);
            }
            arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str) && this.mimeTypeToPartnerAppPositionsMap.containsKey(str)) {
                Iterator<Integer> it = this.mimeTypeToPartnerAppPositionsMap.get(str).iterator();
                while (it.hasNext()) {
                    arrayList.add(this.mPartnerApps.get(it.next().intValue()));
                }
            }
            return arrayList;
        }

        private void load(Context context) {
            XmlResourceParser xml = context.getResources().getXml(R.xml.partner_app);
            this.mPartnerApps.clear();
            Builder builder = null;
            while (xml.getEventType() != 1) {
                try {
                    int eventType = xml.getEventType();
                    if (eventType == 2) {
                        String name = xml.getName();
                        if (TextUtils.equals(name, PromotedPartnerApp.TAG_APP)) {
                            if (xml.getAttributeBooleanValue(null, "enabled", true)) {
                                builder = new Builder();
                                builder.setName(context.getString(xml.getAttributeResourceValue(null, "name", 0)));
                                boolean attributeBooleanValue = xml.getAttributeBooleanValue(null, "tooltip_enabled", false);
                                builder.setTooltipEnabled(attributeBooleanValue);
                                if (attributeBooleanValue) {
                                    builder.setTooltipMessage(context.getString(xml.getAttributeResourceValue(null, "tooltip_text", 0)));
                                    builder.setTooltipImageRes(xml.getAttributeResourceValue(null, "tooltip_image", 0));
                                }
                                boolean attributeBooleanValue2 = xml.getAttributeBooleanValue(null, "install_dialog_enabled", false);
                                builder.setDialogEnabled(attributeBooleanValue2);
                                if (attributeBooleanValue2) {
                                    builder.setDialogTitle(context.getString(xml.getAttributeResourceValue(null, "install_dialog_title", 0)));
                                    builder.setDialogMessage(context.getString(xml.getAttributeResourceValue(null, "install_dialog_message", 0)));
                                    builder.setDialogImageRes(xml.getAttributeResourceValue(null, "install_dialog_image", 0));
                                    builder.setDialogInstallUrl(xml.getAttributeValue(null, "install_dialog_url"));
                                }
                            }
                        } else if (TextUtils.equals(name, PromotedPartnerApp.TAG_APP_PACKAGE) && builder != null) {
                            xml.next();
                            builder.setPackage(xml.getText());
                        } else if (TextUtils.equals(name, PromotedPartnerApp.TAG_APP_MIME_TYPES) && builder != null) {
                            xml.next();
                            builder.setMimeTypes(xml.getText());
                        }
                    } else if (eventType == 3 && TextUtils.equals(xml.getName(), PromotedPartnerApp.TAG_APP) && builder != null) {
                        PromotedPartnerApp promotedPartnerAppBuild = builder.build();
                        this.mPartnerApps.add(promotedPartnerAppBuild);
                        for (String str : promotedPartnerAppBuild.mMimeTypes) {
                            List<Integer> arrayList = this.mimeTypeToPartnerAppPositionsMap.containsKey(str) ? this.mimeTypeToPartnerAppPositionsMap.get(str) : new ArrayList<>();
                            arrayList.add(Integer.valueOf(this.mPartnerApps.size() - 1));
                            this.mimeTypeToPartnerAppPositionsMap.put(str, arrayList);
                        }
                    }
                    xml.next();
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                } catch (XmlPullParserException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }
}
