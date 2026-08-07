package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.utilities.APIErrorStringProvider;
import com.box.android.domain.R;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.requests.BoxResponsePartial;
import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class BoxResponseMessage<E extends BoxObject> extends BoxMessage<E> {
    public static final String EXCEPTION_EXTRA = "box_message_exception";
    public static final String IS_PARTIAL_RESPONSE_EXTRA = "box_message_is_partial_response";
    public static final String PAYLOAD_EXTRA = "box_message_payload";
    public static final String REQUEST_EXTRA = "box_message_request";
    public static final String REQUEST_ID_EXTRA = "box_message_request_id";
    public static final String REQUEST_IS_REMOTE = "box_message_remote";

    public BoxResponseMessage(BoxResponse<E> boxResponse, boolean z) {
        setPayload(boxResponse.getResult());
        setException(boxResponse.getException());
        setRequest(boxResponse.getRequest());
        setAction(boxResponse.getRequest().getClass().getName());
        setIsPartialResponse(boxResponse instanceof BoxResponsePartial);
        setIsRemote(z);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setRequestId(long j) {
        putExtra("box_message_request_id", j);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public long getRequestId() {
        return getLongExtra("box_message_request_id", 0L);
    }

    public void setIsPartialResponse(boolean z) {
        putExtra(IS_PARTIAL_RESPONSE_EXTRA, z);
    }

    public boolean isPartialResponse() {
        return getBooleanExtra(IS_PARTIAL_RESPONSE_EXTRA, false);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(E e) {
        if (e instanceof Serializable) {
            putExtra("box_message_payload", e);
        }
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setException(Exception exc) {
        if (exc instanceof Serializable) {
            putExtra("box_message_exception", exc);
        }
    }

    public void setRequest(BoxRequest boxRequest) {
        if (boxRequest instanceof Serializable) {
            putExtra(REQUEST_EXTRA, boxRequest);
        }
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public Exception getException() {
        return (Exception) getSerializableExtra("box_message_exception");
    }

    public BoxRequest getRequest() {
        return (BoxRequest) getSerializableExtra(REQUEST_EXTRA);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public E getPayload() {
        return (E) getSerializableExtra("box_message_payload");
    }

    public BoxResponse<E> getResponse() {
        if (isPartialResponse()) {
            return new BoxResponsePartial(getPayload(), getException(), getRequest());
        }
        return new BoxResponse<>(getPayload(), getException(), getRequest());
    }

    public boolean isRemote() {
        return getBooleanExtra(REQUEST_IS_REMOTE, true);
    }

    public void setIsRemote(boolean z) {
        putExtra(REQUEST_IS_REMOTE, z);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public boolean wasSuccessful() {
        BoxResponse<E> response = getResponse();
        return response != null && response.isSuccess();
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public int getErrorStringRId(BoxMessage.Scenario scenario, int i, int i2) {
        Exception exception = getException();
        if (!(exception instanceof BoxException)) {
            return i2;
        }
        BoxException boxException = (BoxException) exception;
        int i3 = AnonymousClass1.$SwitchMap$com$box$androidsdk$content$BoxException$ErrorType[boxException.getErrorType().ordinal()];
        if (i3 == 1) {
            return i;
        }
        if (i3 == 2) {
            return R.string.permission_denied_general;
        }
        return APIErrorStringProvider.getInstance().getErrorStringRId(scenario, boxException);
    }

    /* JADX INFO: renamed from: com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$androidsdk$content$BoxException$ErrorType;

        static {
            int[] iArr = new int[BoxException.ErrorType.values().length];
            $SwitchMap$com$box$androidsdk$content$BoxException$ErrorType = iArr;
            try {
                iArr[BoxException.ErrorType.NETWORK_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$BoxException$ErrorType[BoxException.ErrorType.ACCESS_DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
