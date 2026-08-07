package com.microsoft.intune.mam.client.identity;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class NotProtectedDataException extends IOException {
    private static final long serialVersionUID = 3536041425008940616L;

    NotProtectedDataException() {
        super("Data does not have MAM protection info");
    }
}
