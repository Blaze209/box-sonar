package com.box.android.coreservices.exceptions;

import com.box.android.coreservices.jobmanager.JobItem;
import com.box.androidsdk.content.BoxException;

/* JADX INFO: loaded from: classes9.dex */
public class FileTransferException extends BoxException {
    private static final long serialVersionUID = 1;
    private final JobItem.ErrorType mErrorType;

    public FileTransferException(JobItem.ErrorType errorType) {
        super(errorType.getMessage());
        this.mErrorType = errorType;
    }

    public JobItem.ErrorType getJobItemErrorType() {
        return this.mErrorType;
    }
}
