package com.microsoft.identity.common.exception;

import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.java.exception.BaseException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: BrokerCommunicationException.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/microsoft/identity/common/exception/BrokerCommunicationException;", "Lcom/microsoft/identity/common/java/exception/BaseException;", "category", "Lcom/microsoft/identity/common/exception/BrokerCommunicationException$Category;", "strategyType", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy$Type;", "errorMessage", "", "throwable", "", "(Lcom/microsoft/identity/common/exception/BrokerCommunicationException$Category;Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy$Type;Ljava/lang/String;Ljava/lang/Throwable;)V", "getCategory", "()Lcom/microsoft/identity/common/exception/BrokerCommunicationException$Category;", "message", "getMessage", "()Ljava/lang/String;", "getStrategyType", "()Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy$Type;", "isCacheable", "", "Category", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BrokerCommunicationException extends BaseException {
    private static final long serialVersionUID = 4959278068787428329L;
    private final Category category;
    private final IIpcStrategy.Type strategyType;

    public final Category getCategory() {
        return this.category;
    }

    public final IIpcStrategy.Type getStrategyType() {
        return this.strategyType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrokerCommunicationException(Category category, IIpcStrategy.Type strategyType, String str, Throwable th) {
        super(category.toString(), str, th);
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(strategyType, "strategyType");
        this.category = category;
        this.strategyType = strategyType;
    }

    /* JADX INFO: compiled from: BrokerCommunicationException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/microsoft/identity/common/exception/BrokerCommunicationException$Category;", "", "categoryName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE", "OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE", "CONNECTION_ERROR", "VALIDATION_ERROR", "NULL_CURSOR", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Category {
        OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE("ipc_operation_not_supported_on_client_side"),
        OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE("ipc_operation_not_supported_on_server_side"),
        CONNECTION_ERROR("ipc_connection_error"),
        VALIDATION_ERROR("ipc_validation_error"),
        NULL_CURSOR("ipc_return_null_cursor");

        private final String categoryName;

        Category(String str) {
            this.categoryName = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.categoryName;
        }
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException, java.lang.Throwable
    public String getMessage() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Category category = this.category;
        String string = category != null ? category.toString() : null;
        IIpcStrategy.Type type = this.strategyType;
        String str = String.format("[%s] [%s] :%s", Arrays.copyOf(new Object[]{string, type != null ? type.toString() : null, super.getMessage()}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    @Override // com.microsoft.identity.common.java.exception.BaseException
    public boolean isCacheable() {
        return this.category != Category.CONNECTION_ERROR;
    }
}
