package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestBatch extends BoxRequest<BoxResponseBatch, BoxRequestBatch> {
    private static final long serialVersionUID = 8123965031279971500L;
    private ExecutorService mExecutor;
    public ArrayList<BoxRequest> mRequests;

    public BoxRequestBatch() {
        super(BoxResponseBatch.class, null, null);
        this.mRequests = new ArrayList<>();
        this.mExecutor = null;
    }

    public BoxRequestBatch setExecutor(ExecutorService executorService) {
        this.mExecutor = executorService;
        return this;
    }

    public BoxRequestBatch addRequest(BoxRequest boxRequest) {
        this.mRequests.add(boxRequest);
        return this;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxResponseBatch onSend() throws BoxException {
        BoxResponseBatch boxResponseBatch = new BoxResponseBatch();
        if (this.mExecutor != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<BoxRequest> it = this.mRequests.iterator();
            while (it.hasNext()) {
                BoxFutureTask task = it.next().toTask();
                this.mExecutor.submit(task);
                arrayList.add(task);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                try {
                    boxResponseBatch.addResponse((BoxResponse) ((BoxFutureTask) it2.next()).get());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new BoxException(e.getMessage(), e);
                } catch (ExecutionException e2) {
                    throw new BoxException(e2.getMessage(), e2);
                }
            }
        } else {
            for (BoxRequest boxRequest : this.mRequests) {
                BoxObject boxObjectSend = null;
                try {
                    e = null;
                    boxObjectSend = boxRequest.send();
                } catch (Exception e3) {
                    e = e3;
                }
                boxResponseBatch.addResponse(new BoxResponse(boxObjectSend, e, boxRequest));
            }
        }
        return boxResponseBatch;
    }
}
