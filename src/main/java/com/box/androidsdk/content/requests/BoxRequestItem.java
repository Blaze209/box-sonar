package com.box.androidsdk.content.requests;

import android.text.TextUtils;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxRequestItem<E extends BoxJsonObject, R extends BoxRequest<E, R>> extends BoxRequest<E, R> {
    protected static String QUERY_FIELDS = "fields";
    protected StringBuffer mHintHeader;
    protected String mId;

    protected BoxRequestItem(Class<E> cls, String str, String str2, BoxSession boxSession) {
        super(cls, str2, boxSession);
        this.mId = null;
        this.mHintHeader = new StringBuffer();
        this.mContentType = BoxRequest.ContentTypes.JSON;
        this.mId = str;
    }

    protected BoxRequestItem(BoxRequestItem boxRequestItem) {
        super(boxRequestItem);
        this.mId = null;
        this.mHintHeader = new StringBuffer();
        this.mId = boxRequestItem.getId();
        this.mHintHeader = new StringBuffer(boxRequestItem.mHintHeader.toString());
    }

    public R setFields(String... strArr) {
        if (strArr.length == 1 && strArr[0] == null) {
            this.mQueryMap.remove(QUERY_FIELDS);
            return this;
        }
        if (strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(strArr[0]);
            for (int i = 1; i < strArr.length; i++) {
                sb.append(String.format(Locale.ENGLISH, ",%s", strArr[i]));
            }
            this.mQueryMap.put(QUERY_FIELDS, sb.toString());
        }
        return this;
    }

    public R addRepresentationHintGroup(String... strArr) {
        if (strArr != null) {
            this.mHintHeader.append("[");
            this.mHintHeader.append(TextUtils.join(",", strArr));
            this.mHintHeader.append("]");
        }
        return this;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void createHeaderMap() {
        super.createHeaderMap();
        if (TextUtils.isEmpty(this.mHintHeader)) {
            return;
        }
        this.mHeaderMap.put(BoxRepresentation.REP_HINTS_HEADER, this.mHintHeader.toString());
    }

    public String getId() {
        return this.mId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<E> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}
