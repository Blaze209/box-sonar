package com.microsoft.identity.common.java.controllers;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: IControllerFactory.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/microsoft/identity/common/java/controllers/IControllerFactory;", "", "getAllControllers", "", "Lcom/microsoft/identity/common/java/controllers/BaseController;", "getDefaultController", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IControllerFactory {
    List<BaseController> getAllControllers();

    BaseController getDefaultController();
}
