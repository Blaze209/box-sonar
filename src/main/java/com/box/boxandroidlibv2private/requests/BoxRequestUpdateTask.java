package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxTask;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUpdateTask extends BoxRequestItem<BoxTask, BoxRequestUpdateTask> implements BoxCacheableRequest<BoxTask> {
    public static final String URI = "undoc/tasks/%s";

    public BoxRequestUpdateTask(String str, String str2, BoxSession boxSession) {
        super(BoxTask.class, str2, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.PUT;
    }

    public static String getUri(String str) {
        return String.format("undoc/tasks/%s", str);
    }

    public BoxRequestUpdateTask setDescription(String str) {
        this.mBodyMap.put("description", str);
        return this;
    }

    public BoxRequestUpdateTask setDueAt(Date date) {
        this.mBodyMap.put(BoxTask.FIELD_DUE_AT, BoxDateFormat.format(date));
        return this;
    }

    public String getDescription() {
        return (String) this.mBodyMap.get("description");
    }

    public Date getDueAt() {
        String str = (String) this.mBodyMap.get(BoxTask.FIELD_DUE_AT);
        if (str == null) {
            return null;
        }
        try {
            return BoxDateFormat.parse(str);
        } catch (ParseException e) {
            BoxLogUtils.e("invalid date", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxTask onSend() throws BoxException {
        return (BoxTask) super.onSend();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxTask sendForCachedResult() throws BoxException {
        return (BoxTask) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask<BoxTask> toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }
}
