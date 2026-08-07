package com.box.androidsdk.content.requests;

import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes13.dex */
public class BoxFilePreviewRequest extends BoxRequestsFile.FilePreviewed {
    private String mInteractionSharedLink;
    private Date mPreviewTime;
    private boolean mUsingConstructionTime;

    public BoxFilePreviewRequest(String str, String str2, BoxSession boxSession) {
        super(str, str2, boxSession);
        this.mPreviewTime = new Date();
        if (boxSession instanceof BoxSharedLinkSession) {
            this.mInteractionSharedLink = ((BoxSharedLinkSession) boxSession).getSharedLink();
        }
        this.mUsingConstructionTime = true;
    }

    public void setPreviewTime(Date date) {
        this.mUsingConstructionTime = false;
        this.mPreviewTime = date;
    }

    public Date getPreviewTime() {
        return this.mPreviewTime;
    }

    public boolean isUsingConstructionTime() {
        return this.mUsingConstructionTime;
    }

    public String getInteractionSharedLink() {
        return this.mInteractionSharedLink;
    }

    public void setInteractionSharedLink(String str) {
        this.mInteractionSharedLink = str;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void createHeaderMap() {
        super.createHeaderMap();
        if (StringUtils.isBlank(this.mInteractionSharedLink)) {
            this.mHeaderMap.remove(SharedLinkAuthInterceptor.HEADER_AUTH_SHARED_LINK);
        } else {
            this.mHeaderMap.put(SharedLinkAuthInterceptor.HEADER_AUTH_SHARED_LINK, String.format(Locale.ENGLISH, "shared_link=%s", this.mInteractionSharedLink));
        }
    }
}
