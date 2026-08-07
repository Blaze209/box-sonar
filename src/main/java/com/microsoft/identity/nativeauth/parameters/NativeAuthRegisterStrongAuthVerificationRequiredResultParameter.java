package com.microsoft.identity.nativeauth.parameters;

import com.microsoft.identity.nativeauth.statemachine.states.RegisterStrongAuthVerificationRequiredState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthRegisterStrongAuthVerificationRequiredResultParameters.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0007R\u0014\u0010\b\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/nativeauth/parameters/NativeAuthRegisterStrongAuthVerificationRequiredResultParameter;", "", "nextState", "Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState;", "codeLength", "", "sentTo", "", "channel", "(Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState;ILjava/lang/String;Ljava/lang/String;)V", "getChannel$msal_distRelease", "()Ljava/lang/String;", "getCodeLength$msal_distRelease", "()I", "getNextState$msal_distRelease", "()Lcom/microsoft/identity/nativeauth/statemachine/states/RegisterStrongAuthVerificationRequiredState;", "getSentTo$msal_distRelease", "getChannel", "getCodeLength", "getNextState", "getSentTo", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthRegisterStrongAuthVerificationRequiredResultParameter {
    private final String channel;
    private final int codeLength;
    private final RegisterStrongAuthVerificationRequiredState nextState;
    private final String sentTo;

    public NativeAuthRegisterStrongAuthVerificationRequiredResultParameter(RegisterStrongAuthVerificationRequiredState nextState, int i, String sentTo, String channel) {
        Intrinsics.checkNotNullParameter(nextState, "nextState");
        Intrinsics.checkNotNullParameter(sentTo, "sentTo");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.nextState = nextState;
        this.codeLength = i;
        this.sentTo = sentTo;
        this.channel = channel;
    }

    public final RegisterStrongAuthVerificationRequiredState getNextState$msal_distRelease() {
        return this.nextState;
    }

    public final int getCodeLength$msal_distRelease() {
        return this.codeLength;
    }

    public final String getSentTo$msal_distRelease() {
        return this.sentTo;
    }

    public final String getChannel$msal_distRelease() {
        return this.channel;
    }

    public final RegisterStrongAuthVerificationRequiredState getNextState() {
        return this.nextState;
    }

    public final int getCodeLength() {
        return this.codeLength;
    }

    public final String getSentTo() {
        return this.sentTo;
    }

    public final String getChannel() {
        return this.channel;
    }
}
