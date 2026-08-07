package io.split.android.client.validators;

import io.split.android.client.dtos.Event;

/* JADX INFO: loaded from: classes4.dex */
public interface EventValidator {
    ValidationErrorInfo validate(Event event, boolean validateTrafficType);
}
