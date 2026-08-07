package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

/* JADX INFO: loaded from: classes14.dex */
public interface IChallengeHandler<GenericChallenge, GenericResponse> {
    GenericResponse processChallenge(GenericChallenge genericchallenge);
}
