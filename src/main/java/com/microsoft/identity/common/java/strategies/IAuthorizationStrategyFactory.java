package com.microsoft.identity.common.java.strategies;

import com.microsoft.identity.common.java.providers.oauth2.IAuthorizationStrategy;
import com.microsoft.identity.common.java.ui.AuthorizationAgent;
import com.microsoft.identity.common.java.ui.BrowserDescriptor;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface IAuthorizationStrategyFactory<GenericAuthorizationStrategy extends IAuthorizationStrategy> {
    GenericAuthorizationStrategy getAuthorizationStrategy(AuthorizationAgent authorizationAgent, List<BrowserDescriptor> list, BrowserDescriptor browserDescriptor, boolean z);
}
