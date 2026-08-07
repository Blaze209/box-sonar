package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.utils.IStreamPosition;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

/* JADX INFO: loaded from: classes13.dex */
abstract class BoxRequestEvent<E extends BoxJsonObject, R extends BoxRequest<E, R>> extends BoxRequest<E, R> implements BoxCacheableRequest<E> {
    public static final String FIELD_LIMIT = "stream_limit";
    public static final String FIELD_STREAM_POSITION = "stream_position";
    public static final String FIELD_STREAM_TYPE = "stream_type";
    public static final String STREAM_TYPE_ALL = "all";
    public static final String STREAM_TYPE_CHANGES = "changes";
    public static final String STREAM_TYPE_SYNC = "sync";
    private E mListEvents;

    protected BoxRequestEvent(Class<E> cls, String str, BoxSession boxSession) {
        super(cls, str, boxSession);
        this.mRequestUrlString = str;
        this.mRequestMethod = BoxRequest.Methods.GET;
        setRequestHandler(createRequestHandler(this));
    }

    public static BoxRequest.BoxRequestHandler<BoxRequestEvent> createRequestHandler(BoxRequestEvent boxRequestEvent) {
        return new BoxRequest.BoxRequestHandler<BoxRequestEvent>(boxRequestEvent) { // from class: com.box.androidsdk.content.requests.BoxRequestEvent.1
            @Override // com.box.androidsdk.content.requests.BoxRequest.BoxRequestHandler
            public <T extends BoxObject> T onResponse(Class<T> cls, BoxHttpResponse boxHttpResponse) throws IllegalAccessException, BoxException, InstantiationException {
                if (Thread.currentThread().isInterrupted()) {
                    disconnectForInterrupt(boxHttpResponse);
                    throw new BoxException("Request cancelled ", new InterruptedException());
                }
                if (boxHttpResponse.getResponseCode() == 429) {
                    return (T) retryRateLimited(boxHttpResponse);
                }
                String contentType = boxHttpResponse.getContentType();
                T tNewInstance = cls.newInstance();
                if ((tNewInstance instanceof BoxJsonObject) && contentType.contains(BoxRequest.ContentTypes.JSON.toString())) {
                    String stringBody = boxHttpResponse.getStringBody();
                    stringBody.charAt(stringBody.indexOf("event") - 1);
                    stringBody.charAt(stringBody.indexOf("user") - 1);
                    ((BoxJsonObject) tNewInstance).createFromJson(stringBody);
                }
                return tNewInstance;
            }
        };
    }

    public R setStreamPosition(String str) {
        this.mQueryMap.put(FIELD_STREAM_POSITION, str);
        return this;
    }

    protected R setStreamType(String str) {
        this.mQueryMap.put(FIELD_STREAM_TYPE, str);
        return this;
    }

    public R setLimit(int i) {
        this.mQueryMap.put(FIELD_LIMIT, Integer.toString(i));
        return this;
    }

    public R setPreviousListEvents(E e) {
        this.mListEvents = e;
        setStreamPosition(((IStreamPosition) e).getNextStreamPosition().toString());
        return this;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    public E onSend() throws BoxException {
        E e = this.mListEvents;
        if (e != null) {
            ((Collection) e).addAll((Collection) super.onSend());
            return this.mListEvents;
        }
        return (E) super.onSend();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.mRequestHandler = createRequestHandler(this);
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public E sendForCachedResult() throws BoxException {
        return (E) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask<E> toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<E> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}
