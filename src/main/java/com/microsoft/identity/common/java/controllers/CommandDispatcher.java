package com.microsoft.identity.common.java.controllers;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.commands.BaseCommand;
import com.microsoft.identity.common.java.commands.DeviceCodeFlowAuthResultCommand;
import com.microsoft.identity.common.java.commands.DeviceCodeFlowCommand;
import com.microsoft.identity.common.java.commands.DeviceCodeFlowTokenResultCommand;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.commands.InteractiveTokenCommand;
import com.microsoft.identity.common.java.commands.SilentTokenCommand;
import com.microsoft.identity.common.java.commands.parameters.BrokerInteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.UserCancelException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.logging.RequestContext;
import com.microsoft.identity.common.java.marker.CodeMarkerManager;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OtelContextExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.FinalizableResultFuture;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.result.VoidResult;
import com.microsoft.identity.common.java.telemetry.Telemetry;
import com.microsoft.identity.common.java.util.BiConsumer;
import com.microsoft.identity.common.java.util.IPlatformUtil;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.LocalBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes14.dex */
public class CommandDispatcher {
    private static final int DCF_REQUEST_THREAD_POOL_SIZE = 5;
    private static final int SILENT_REQUEST_THREAD_POOL_SIZE = 5;
    private static final String TAG = "CommandDispatcher";
    private static ExecutorService sInteractiveExecutor = Executors.newSingleThreadExecutor();
    private static ExecutorService sSilentExecutor = Executors.newFixedThreadPool(5);
    private static final ExecutorService sDCFExecutor = Executors.newFixedThreadPool(5);
    private static final Object sLock = new Object();
    private static InteractiveTokenCommand sCommand = null;
    private static final CommandResultCache sCommandResultCache = new CommandResultCache();
    private static final Object mapAccessLock = new Object();
    private static ConcurrentMap<BaseCommand, FinalizableResultFuture<CommandResult>> sExecutingCommandMap = new ConcurrentHashMap();

    public static int getSilentRequestActiveCount() {
        return ((ThreadPoolExecutor) sSilentExecutor).getActiveCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cleanMap(BaseCommand baseCommand) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<BaseCommand, FinalizableResultFuture<CommandResult>> entry : sExecutingCommandMap.entrySet()) {
            if (baseCommand != entry.getKey()) {
                concurrentHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        sExecutingCommandMap = concurrentHashMap;
    }

    public static int outstandingCommands() {
        int size;
        synchronized (mapAccessLock) {
            size = sExecutingCommandMap.size();
        }
        return size;
    }

    public static boolean isCommandOutstanding(BaseCommand baseCommand) {
        synchronized (mapAccessLock) {
            Iterator<Map.Entry<BaseCommand, FinalizableResultFuture<CommandResult>>> it = sExecutingCommandMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getKey() == baseCommand) {
                    System.out.println("Command out there " + baseCommand);
                    return true;
                }
            }
            return false;
        }
    }

    public static void clearState() throws Exception {
        synchronized (mapAccessLock) {
            sExecutingCommandMap.clear();
        }
        sSilentExecutor.shutdownNow();
        sInteractiveExecutor.shutdownNow();
        Field declaredField = CommandDispatcher.class.getDeclaredField("sSilentExecutor");
        declaredField.setAccessible(true);
        declaredField.set(null, Executors.newFixedThreadPool(5));
        declaredField.setAccessible(false);
        Field declaredField2 = CommandDispatcher.class.getDeclaredField("sInteractiveExecutor");
        declaredField2.setAccessible(true);
        declaredField2.set(null, Executors.newSingleThreadExecutor());
        declaredField2.setAccessible(false);
    }

    public static void submitSilent(BaseCommand baseCommand) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        submitSilentReturningFuture(baseCommand);
    }

    public static AuthorizationResult submitDcfAuthResultSilent(DeviceCodeFlowAuthResultCommand deviceCodeFlowAuthResultCommand) throws BaseException {
        if (deviceCodeFlowAuthResultCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        try {
            CommandResult commandResult = submitSilentReturningFuture(deviceCodeFlowAuthResultCommand).get();
            if (commandResult.getStatus() == ICommandResult.ResultStatus.COMPLETED) {
                return (AuthorizationResult) commandResult.getResult();
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
                throw ExceptionAdapter.baseExceptionFromException((Throwable) commandResult.getResult());
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
                throw new UserCancelException(ErrorStrings.USER_CANCELLED, "Request cancelled by user");
            }
            throw new ClientException("unknown_error", "Unexpected CommandResult status");
        } catch (InterruptedException | ExecutionException e) {
            throw ExceptionAdapter.baseExceptionFromException(e);
        }
    }

    public static ILocalAuthenticationResult submitDcfTokenResultSilent(DeviceCodeFlowTokenResultCommand deviceCodeFlowTokenResultCommand) throws BaseException {
        if (deviceCodeFlowTokenResultCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        try {
            CommandResult commandResult = submitSilentReturningFuture(deviceCodeFlowTokenResultCommand).get();
            if (commandResult.getStatus() == ICommandResult.ResultStatus.COMPLETED) {
                return (ILocalAuthenticationResult) commandResult.getResult();
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
                throw ExceptionAdapter.baseExceptionFromException((Throwable) commandResult.getResult());
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
                throw new UserCancelException(ErrorStrings.USER_CANCELLED, "Request cancelled by user");
            }
            throw new ClientException("unknown_error", "Unexpected CommandResult status");
        } catch (InterruptedException | ExecutionException e) {
            throw ExceptionAdapter.baseExceptionFromException(e);
        }
    }

    public static ILocalAuthenticationResult submitAcquireTokenSilentSync(SilentTokenCommand silentTokenCommand) throws BaseException {
        if (silentTokenCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        try {
            CommandResult commandResult = submitSilentReturningFuture(silentTokenCommand).get(CommonFlightsManager.INSTANCE.getFlightsProvider().getIntValue(CommonFlight.ACQUIRE_TOKEN_SILENT_TIMEOUT_MILLISECONDS), TimeUnit.MILLISECONDS);
            if (commandResult.getStatus() == ICommandResult.ResultStatus.COMPLETED) {
                return (ILocalAuthenticationResult) commandResult.getResult();
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
                throw ExceptionAdapter.baseExceptionFromException((Throwable) commandResult.getResult());
            }
            if (commandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
                throw new UserCancelException(ErrorStrings.USER_CANCELLED, "Request cancelled by user");
            }
            throw new ClientException("unknown_error", "Unexpected CommandResult status");
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw ExceptionAdapter.baseExceptionFromException(e);
        }
    }

    public static FinalizableResultFuture<CommandResult> submitSilentReturningFuture(final BaseCommand baseCommand) {
        ExecutorService executorService;
        String str;
        FinalizableResultFuture<CommandResult> finalizableResultFuture;
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        final CodeMarkerManager codeMarkerManager = CodeMarkerManager.getInstance();
        final CommandParameters parameters = baseCommand.getParameters();
        final String strInitializeDiagnosticContext = initializeDiagnosticContext(parameters.getCorrelationId(), parameters.getSdkType() == null ? SdkType.UNKNOWN.getProductName() : parameters.getSdkType().getProductName(), parameters.getSdkVersion());
        parameters.setCorrelationId(strInitializeDiagnosticContext);
        final boolean zIsDeviceCodeFlowRequest = isDeviceCodeFlowRequest(baseCommand);
        if (zIsDeviceCodeFlowRequest) {
            executorService = sDCFExecutor;
            codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_START);
            str = ":submitDCF";
        } else {
            executorService = sSilentExecutor;
            codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_START);
            str = ":submitSilent";
        }
        ExecutorService executorService2 = executorService;
        final String str2 = str;
        logParameters(TAG + str2, strInitializeDiagnosticContext, parameters, baseCommand.getPublicApiId());
        synchronized (mapAccessLock) {
            if (baseCommand.isEligibleForCaching()) {
                FinalizableResultFuture<CommandResult> finalizableResultFuture2 = sExecutingCommandMap.get(baseCommand);
                if (finalizableResultFuture2 == null) {
                    finalizableResultFuture = new FinalizableResultFuture<>();
                    FinalizableResultFuture<CommandResult> finalizableResultFuturePutIfAbsent = sExecutingCommandMap.putIfAbsent(baseCommand, finalizableResultFuture);
                    if (finalizableResultFuturePutIfAbsent == null) {
                        finalizableResultFuture.whenComplete(getCommandResultConsumer(baseCommand));
                    } else {
                        finalizableResultFuturePutIfAbsent.whenComplete(getCommandResultConsumer(baseCommand));
                        return finalizableResultFuturePutIfAbsent;
                    }
                } else {
                    finalizableResultFuture2.whenComplete(getCommandResultConsumer(baseCommand));
                    return finalizableResultFuture2;
                }
            } else {
                finalizableResultFuture = new FinalizableResultFuture<>();
                finalizableResultFuture.whenComplete(getCommandResultConsumer(baseCommand));
            }
            final FinalizableResultFuture<CommandResult> finalizableResultFuture3 = finalizableResultFuture;
            SpanExtension.current().setAttribute(AttributeName.num_concurrent_silent_requests.name(), sExecutingCommandMap.size());
            executorService2.execute(OtelContextExtension.wrap(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    codeMarkerManager.markCode(zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_EXECUTOR_START : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_EXECUTOR_START);
                    try {
                        CommandDispatcher.initializeDiagnosticContext(strInitializeDiagnosticContext, (parameters.getSdkType() == null ? SdkType.UNKNOWN : parameters.getSdkType()).getProductName(), parameters.getSdkVersion());
                        CommandDispatcher.initTelemetryForCommand(baseCommand);
                        EstsTelemetry.getInstance().emitApiId(baseCommand.getPublicApiId());
                        if (baseCommand.getParameters() instanceof SilentTokenCommandParameters) {
                            EstsTelemetry.getInstance().emitForceRefresh(((SilentTokenCommandParameters) baseCommand.getParameters()).isForceRefresh());
                        }
                        codeMarkerManager.markCode(zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_COMMAND_EXECUTION_START : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_COMMAND_EXECUTION_START);
                        try {
                            CommandResult commandResultExecuteCommand = CommandDispatcher.executeCommand(baseCommand);
                            codeMarkerManager.markCode(zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_COMMAND_EXECUTION_END : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_COMMAND_EXECUTION_END);
                            Logger.info(CommandDispatcher.TAG + str2, "Completed silent request as owner for correlation id : **" + strInitializeDiagnosticContext + ", with the status : " + commandResultExecuteCommand.getStatus().getLogStatus() + " is cacheable : " + baseCommand.isEligibleForCaching());
                            EstsTelemetry.getInstance().flush(baseCommand, commandResultExecuteCommand);
                            finalizableResultFuture3.setResult(commandResultExecuteCommand);
                            synchronized (CommandDispatcher.mapAccessLock) {
                                if (baseCommand.isEligibleForCaching() && ((FinalizableResultFuture) CommandDispatcher.sExecutingCommandMap.remove(baseCommand)) == null) {
                                    Logger.error(CommandDispatcher.TAG, "The command in the map has mutated " + baseCommand.getClass().getCanonicalName() + " the calling application was " + baseCommand.getParameters().getApplicationName(), null);
                                    CommandDispatcher.cleanMap(baseCommand);
                                }
                                finalizableResultFuture3.setCleanedUp();
                            }
                        } finally {
                            codeMarkerManager.markCode(zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_COMMAND_EXECUTION_END : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_COMMAND_EXECUTION_END);
                        }
                    } catch (Throwable th) {
                        try {
                            Logger.info(CommandDispatcher.TAG + str2, "Request encountered an exception with correlation id : **" + strInitializeDiagnosticContext);
                            finalizableResultFuture3.setException(new ExecutionException(th));
                            synchronized (CommandDispatcher.mapAccessLock) {
                                if (baseCommand.isEligibleForCaching() && ((FinalizableResultFuture) CommandDispatcher.sExecutingCommandMap.remove(baseCommand)) == null) {
                                    Logger.error(CommandDispatcher.TAG, "The command in the map has mutated " + baseCommand.getClass().getCanonicalName() + " the calling application was " + baseCommand.getParameters().getApplicationName(), null);
                                    CommandDispatcher.cleanMap(baseCommand);
                                }
                                finalizableResultFuture3.setCleanedUp();
                            }
                        } catch (Throwable th2) {
                            synchronized (CommandDispatcher.mapAccessLock) {
                                if (baseCommand.isEligibleForCaching() && ((FinalizableResultFuture) CommandDispatcher.sExecutingCommandMap.remove(baseCommand)) == null) {
                                    Logger.error(CommandDispatcher.TAG, "The command in the map has mutated " + baseCommand.getClass().getCanonicalName() + " the calling application was " + baseCommand.getParameters().getApplicationName(), null);
                                    CommandDispatcher.cleanMap(baseCommand);
                                }
                                finalizableResultFuture3.setCleanedUp();
                                DiagnosticContext.INSTANCE.clear();
                                throw th2;
                            }
                        }
                    }
                    DiagnosticContext.INSTANCE.clear();
                    CodeMarkerManager codeMarkerManager2 = codeMarkerManager;
                    String str3 = zIsDeviceCodeFlowRequest ? PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_DCF_FUTURE_OBJECT_CREATION_END : PerfConstants.CodeMarkerConstants.ACQUIRE_TOKEN_SILENT_FUTURE_OBJECT_CREATION_END;
                }
            }));
            return finalizableResultFuture3;
        }
    }

    public static void submitAndForget(BaseCommand baseCommand) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        submitAndForgetReturningFuture(baseCommand);
    }

    public static FinalizableResultFuture<CommandResult> submitAndForgetReturningFuture(final BaseCommand baseCommand) {
        final FinalizableResultFuture<CommandResult> finalizableResultFuture;
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        final CommandParameters parameters = baseCommand.getParameters();
        final String strInitializeDiagnosticContext = initializeDiagnosticContext(parameters.getCorrelationId(), parameters.getSdkType() == null ? SdkType.UNKNOWN.getProductName() : parameters.getSdkType().getProductName(), parameters.getSdkVersion());
        parameters.setCorrelationId(strInitializeDiagnosticContext);
        StringBuilder sb = new StringBuilder();
        String str = TAG;
        logParameters(sb.append(str).append(":submit").toString(), strInitializeDiagnosticContext, parameters, baseCommand.getPublicApiId());
        Logger.info(str, "RefreshOnCommand with CorrelationId: " + strInitializeDiagnosticContext);
        synchronized (mapAccessLock) {
            finalizableResultFuture = new FinalizableResultFuture<>();
            finalizableResultFuture.whenComplete(getCommandResultConsumer(baseCommand));
            sSilentExecutor.execute(OtelContextExtension.wrap(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CommandDispatcher.initializeDiagnosticContext(strInitializeDiagnosticContext, (parameters.getSdkType() == null ? SdkType.UNKNOWN : parameters.getSdkType()).getProductName(), parameters.getSdkVersion());
                        EstsTelemetry.getInstance().initTelemetryForCommand(baseCommand);
                        EstsTelemetry.getInstance().emitApiId(baseCommand.getPublicApiId());
                        CommandResult commandResultExecuteCommand = CommandDispatcher.executeCommand(baseCommand);
                        Logger.info(CommandDispatcher.TAG + ":submit", "Completed as owner for correlation id : **" + strInitializeDiagnosticContext + CommandDispatcher.statusMsg(commandResultExecuteCommand.getStatus().getLogStatus()) + " is cacheable : " + baseCommand.isEligibleForCaching());
                        EstsTelemetry.getInstance().flush(baseCommand, commandResultExecuteCommand);
                        finalizableResultFuture.setResult(commandResultExecuteCommand);
                    } catch (Throwable th) {
                        try {
                            Logger.info(CommandDispatcher.TAG + ":submit", "Request encountered an exception with correlation id : **" + strInitializeDiagnosticContext);
                            finalizableResultFuture.setException(new ExecutionException(th));
                        } finally {
                            DiagnosticContext.INSTANCE.clear();
                        }
                    }
                }
            }));
        }
        return finalizableResultFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initTelemetryForCommand(BaseCommand<?> baseCommand) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        EstsTelemetry.getInstance().setUp(baseCommand.getParameters().getPlatformComponents());
        EstsTelemetry.getInstance().initTelemetryForCommand(baseCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logParameters(String str, String str2, CommandParameters commandParameters, String str3) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (commandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        String str4 = str + ":" + commandParameters.getClass().getSimpleName();
        Logger.info(str4, "Starting request with request context: " + DiagnosticContext.INSTANCE.getRequestContext().toJsonString() + ", with PublicApiId: " + str3);
        commandParameters.logParameters(str4, str2);
    }

    private static BiConsumer<CommandResult, Throwable> getCommandResultConsumer(final BaseCommand baseCommand) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        return new BiConsumer<CommandResult, Throwable>() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.3
            @Override // com.microsoft.identity.common.java.util.BiConsumer
            public void accept(CommandResult commandResult, final Throwable th) {
                if (th != null) {
                    Logger.info(CommandDispatcher.TAG + ":getCommandResultConsumer", "Request encountered an exception (this maybe a duplicate request which caries the exception encountered by the original request)");
                    baseCommand.getParameters().getPlatformComponents().getPlatformUtil().postCommandResult(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CommandDispatcher.commandCallBackOnError(baseCommand, th);
                        }
                    });
                } else {
                    if (!StringUtil.isNullOrEmpty(commandResult.getCorrelationId()) && !baseCommand.getParameters().getCorrelationId().equals(commandResult.getCorrelationId())) {
                        Logger.info(CommandDispatcher.TAG + ":getCommandResultConsumer", "Completed duplicate request with correlation id : **" + baseCommand.getParameters().getCorrelationId() + ", having the same result as : " + commandResult.getCorrelationId() + ", with the status : " + commandResult.getStatus().getLogStatus());
                    }
                    CommandDispatcher.returnCommandResult(baseCommand, commandResult);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void commandCallBackOnError(BaseCommand baseCommand, Throwable th) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        baseCommand.getCallback().onError(ExceptionAdapter.baseExceptionFromException(th));
    }

    public static void clearCommandCache() {
        sCommandResultCache.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CommandResult executeCommand(BaseCommand baseCommand) {
        BaseException baseExceptionBaseExceptionFromException;
        Object objExecute;
        CommandResult<Void> commandResult;
        BaseException baseException = null;
        try {
            objExecute = baseCommand.execute();
        } catch (Exception e) {
            if (e instanceof BaseException) {
                baseExceptionBaseExceptionFromException = (BaseException) e;
            } else {
                baseExceptionBaseExceptionFromException = ExceptionAdapter.baseExceptionFromException(e);
            }
            BaseException baseException2 = baseExceptionBaseExceptionFromException;
            objExecute = null;
            baseException = baseException2;
        }
        String correlationId = baseCommand.getParameters().getCorrelationId();
        if (baseException != null) {
            if (baseException instanceof UserCancelException) {
                commandResult = CommandResult.ofNull(ICommandResult.ResultStatus.CANCEL, correlationId);
            } else {
                commandResult = CommandResult.of(ICommandResult.ResultStatus.ERROR, baseException, correlationId);
            }
        } else if (objExecute != null && (objExecute instanceof AcquireTokenResult)) {
            commandResult = getCommandResultFromTokenResult((AcquireTokenResult) objExecute, baseCommand.getParameters());
        } else if (objExecute instanceof VoidResult) {
            commandResult = new CommandResult<>(ICommandResult.ResultStatus.VOID, objExecute, baseCommand.getParameters().getCorrelationId());
        } else if (objExecute == null) {
            commandResult = CommandResult.ofNull(ICommandResult.ResultStatus.COMPLETED, correlationId);
        } else {
            commandResult = new CommandResult<>(ICommandResult.ResultStatus.COMPLETED, objExecute, correlationId);
        }
        setCorrelationIdOnResult(commandResult, correlationId);
        setTelemetryOnResultAndFlush(commandResult, correlationId);
        return commandResult;
    }

    private static void setTelemetryOnResultAndFlush(CommandResult commandResult, String str) {
        if (commandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        List<Map<String, String>> map = Telemetry.getInstance().getMap(str);
        commandResult.setTelemetryMap(map);
        if (commandResult.getResult() instanceof LocalAuthenticationResult) {
            ((LocalAuthenticationResult) commandResult.getResult()).setTelemetry(map);
        } else if (commandResult.getResult() instanceof BaseException) {
            ((BaseException) commandResult.getResult()).setTelemetry(map);
        } else if (commandResult.getResult() != null) {
            Logger.verbose(TAG + ":setTelemetryOnResult", "Not setting telemetry on result as result type is " + commandResult.getResult().getClass().getCanonicalName() + " and doesn't support telemetry at this time.");
        }
        Telemetry.getInstance().flush(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void returnCommandResult(final BaseCommand baseCommand, final CommandResult commandResult) {
        if (baseCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        if (commandResult == null) {
            throw new NullPointerException("result is marked non-null but is null");
        }
        IPlatformUtil platformUtil = baseCommand.getParameters().getPlatformComponents().getPlatformUtil();
        platformUtil.onReturnCommandResult(baseCommand);
        platformUtil.postCommandResult(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.4
            @Override // java.lang.Runnable
            public void run() {
                int i = AnonymousClass6.$SwitchMap$com$microsoft$identity$common$java$commands$ICommandResult$ResultStatus[commandResult.getStatus().ordinal()];
                if (i == 1) {
                    CommandDispatcher.commandCallbackOnError(baseCommand, commandResult);
                } else if (i == 2) {
                    CommandDispatcher.commandCallbackOnTaskCompleted(baseCommand, commandResult);
                } else {
                    if (i != 3) {
                        return;
                    }
                    baseCommand.getCallback().onCancel();
                }
            }
        });
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.java.controllers.CommandDispatcher$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$java$commands$ICommandResult$ResultStatus;

        static {
            int[] iArr = new int[ICommandResult.ResultStatus.values().length];
            $SwitchMap$com$microsoft$identity$common$java$commands$ICommandResult$ResultStatus = iArr;
            try {
                iArr[ICommandResult.ResultStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$commands$ICommandResult$ResultStatus[ICommandResult.ResultStatus.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$java$commands$ICommandResult$ResultStatus[ICommandResult.ResultStatus.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void commandCallbackOnError(BaseCommand baseCommand, CommandResult commandResult) {
        baseCommand.getCallback().onError(ExceptionAdapter.baseExceptionFromException((Throwable) commandResult.getResult()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void commandCallbackOnTaskCompleted(BaseCommand baseCommand, CommandResult commandResult) {
        baseCommand.getCallback().onTaskCompleted(commandResult.getResult());
    }

    private static void cacheCommandResult(BaseCommand baseCommand, CommandResult commandResult) {
        if (baseCommand.isEligibleForCaching() && eligibleToCache(commandResult)) {
            sCommandResultCache.put(baseCommand, commandResult);
        }
    }

    private static CommandResult getCommandResultFromTokenResult(AcquireTokenResult acquireTokenResult, CommandParameters commandParameters) {
        if (acquireTokenResult == null) {
            throw new NullPointerException("result is marked non-null but is null");
        }
        if (commandParameters == null) {
            throw new NullPointerException("commandParameters is marked non-null but is null");
        }
        if (acquireTokenResult.getSucceeded().booleanValue()) {
            return new CommandResult(ICommandResult.ResultStatus.COMPLETED, acquireTokenResult.getLocalAuthenticationResult(), commandParameters.getCorrelationId());
        }
        BaseException baseExceptionExceptionFromAcquireTokenResult = ExceptionAdapter.exceptionFromAcquireTokenResult(acquireTokenResult, commandParameters);
        if (baseExceptionExceptionFromAcquireTokenResult instanceof UserCancelException) {
            return CommandResult.ofNull(ICommandResult.ResultStatus.CANCEL, commandParameters.getCorrelationId());
        }
        return new CommandResult(ICommandResult.ResultStatus.ERROR, baseExceptionExceptionFromAcquireTokenResult, commandParameters.getCorrelationId());
    }

    private static boolean eligibleToCache(CommandResult commandResult) {
        if (commandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        int i = AnonymousClass6.$SwitchMap$com$microsoft$identity$common$java$commands$ICommandResult$ResultStatus[commandResult.getStatus().ordinal()];
        if (i != 1) {
            return i == 2;
        }
        if (commandResult.getResult() instanceof BaseException) {
            return ((BaseException) commandResult.getResult()).isCacheable();
        }
        Logger.warn(TAG + ":eligibleToCache", "Get status ERROR, but result is not a BaseException");
        return true;
    }

    public static void beginInteractive(final InteractiveTokenCommand interactiveTokenCommand) {
        synchronized (sLock) {
            if (LibraryConfiguration.getInstance().isAuthorizationInCurrentTask() || (interactiveTokenCommand.getParameters() instanceof BrokerInteractiveTokenCommandParameters)) {
                if (LocalBroadcaster.INSTANCE.hasReceivers(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST)) {
                    LocalBroadcaster.INSTANCE.broadcast(AuthenticationConstants.LocalBroadcasterAliases.CANCEL_AUTHORIZATION_REQUEST, new PropertyBag());
                } else if (LocalBroadcaster.INSTANCE.hasReceivers(AuthenticationConstants.LocalBroadcasterAliases.RETURN_AUTHORIZATION_REQUEST_RESULT)) {
                    StringBuilder sb = new StringBuilder();
                    String str = TAG;
                    Logger.info(sb.append(str).append(":beginInteractive").toString(), "The previous interactive request was queued but never got processed and is blocking the interactive thread. Restarting the interactive executor service to enable processing interactive requests again.");
                    List<Runnable> listShutdownNow = sInteractiveExecutor.shutdownNow();
                    sInteractiveExecutor = Executors.newSingleThreadExecutor();
                    Logger.info(str + ":beginInteractive", "Cancelled execution of " + listShutdownNow.size() + " interactive requests.");
                }
            }
            sInteractiveExecutor.execute(OtelContextExtension.wrap(new Runnable() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.5
                @Override // java.lang.Runnable
                public void run() {
                    CommandParameters parameters = interactiveTokenCommand.getParameters();
                    String strInitializeDiagnosticContext = CommandDispatcher.initializeDiagnosticContext(parameters.getCorrelationId(), (parameters.getSdkType() == null ? SdkType.UNKNOWN : parameters.getSdkType()).getProductName(), parameters.getSdkVersion());
                    try {
                        parameters.setCorrelationId(strInitializeDiagnosticContext);
                        CommandDispatcher.logParameters(CommandDispatcher.TAG + ":beginInteractive", strInitializeDiagnosticContext, parameters, interactiveTokenCommand.getPublicApiId());
                        CommandDispatcher.initTelemetryForCommand(interactiveTokenCommand);
                        EstsTelemetry.getInstance().emitApiId(interactiveTokenCommand.getPublicApiId());
                        final BaseException[] baseExceptionArr = new BaseException[1];
                        LocalBroadcaster.INSTANCE.registerCallback(AuthenticationConstants.LocalBroadcasterAliases.RETURN_AUTHORIZATION_REQUEST_RESULT, new LocalBroadcaster.IReceiverCallback() { // from class: com.microsoft.identity.common.java.controllers.CommandDispatcher.5.1
                            @Override // com.microsoft.identity.common.java.util.ported.LocalBroadcaster.IReceiverCallback
                            public void onReceive(PropertyBag propertyBag) {
                                if (propertyBag != null) {
                                    try {
                                        CommandDispatcher.completeInteractive(propertyBag);
                                        return;
                                    } catch (Exception e) {
                                        baseExceptionArr[0] = ExceptionAdapter.baseExceptionFromException(e);
                                        return;
                                    }
                                }
                                throw new NullPointerException("dataBag is marked non-null but is null");
                            }
                        });
                        InteractiveTokenCommand unused = CommandDispatcher.sCommand = interactiveTokenCommand;
                        CommandResult commandResultExecuteCommand = CommandDispatcher.executeCommand(interactiveTokenCommand);
                        InteractiveTokenCommand unused2 = CommandDispatcher.sCommand = null;
                        LocalBroadcaster.INSTANCE.unregisterCallback(AuthenticationConstants.LocalBroadcasterAliases.RETURN_AUTHORIZATION_REQUEST_RESULT);
                        if (baseExceptionArr[0] != null) {
                            commandResultExecuteCommand = CommandResult.of(ICommandResult.ResultStatus.ERROR, baseExceptionArr[0], strInitializeDiagnosticContext);
                        }
                        Logger.info(CommandDispatcher.TAG + ":beginInteractive", "Completed interactive request for correlation id : **" + strInitializeDiagnosticContext + CommandDispatcher.statusMsg(commandResultExecuteCommand.getStatus().getLogStatus()));
                        EstsTelemetry.getInstance().flush(interactiveTokenCommand, commandResultExecuteCommand);
                        CommandDispatcher.returnCommandResult(interactiveTokenCommand, commandResultExecuteCommand);
                    } finally {
                        DiagnosticContext.INSTANCE.clear();
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void completeInteractive(PropertyBag propertyBag) {
        int iIntValue = ((Integer) propertyBag.getOrDefault(AuthenticationConstants.LocalBroadcasterFields.REQUEST_CODE, -1)).intValue();
        int iIntValue2 = ((Integer) propertyBag.getOrDefault(AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE, -1)).intValue();
        InteractiveTokenCommand interactiveTokenCommand = sCommand;
        if (interactiveTokenCommand != null) {
            interactiveTokenCommand.onFinishAuthorizationSession(iIntValue, iIntValue2, propertyBag);
        } else {
            Logger.warn(TAG + ":completeInteractive", "sCommand is null, No interactive call in progress to complete.");
        }
    }

    public static String initializeDiagnosticContext(String str, String str2, String str3) {
        if (StringUtil.isNullOrEmpty(str)) {
            str = UUID.randomUUID().toString();
        }
        RequestContext requestContext = new RequestContext();
        requestContext.put("correlation_id", str);
        requestContext.put("x-client-SKU", str2);
        requestContext.put("x-client-Ver", str3);
        DiagnosticContext.INSTANCE.setRequestContext(requestContext);
        Logger.verbose(TAG + ":initializeDiagnosticContext", "Initialized new DiagnosticContext");
        return str;
    }

    public static int getCachedResultCount() {
        return sCommandResultCache.getSize();
    }

    private static void setCorrelationIdOnResult(CommandResult commandResult, String str) {
        if (commandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (commandResult.getResult() == null || !(commandResult.getResult() instanceof LocalAuthenticationResult)) {
            return;
        }
        ((LocalAuthenticationResult) commandResult.getResult()).setCorrelationId(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String statusMsg(String str) {
        return ", with the status : " + str;
    }

    private static boolean isDeviceCodeFlowRequest(BaseCommand baseCommand) {
        return (baseCommand instanceof DeviceCodeFlowCommand) || (baseCommand instanceof DeviceCodeFlowAuthResultCommand) || (baseCommand instanceof DeviceCodeFlowTokenResultCommand);
    }

    public static void stopSilentRequestExecutor() {
        String str = TAG + ":stopSilentRequestExecutor";
        Logger.info(str, "shutting down..");
        sSilentExecutor.shutdown();
        try {
            if (sSilentExecutor.awaitTermination(1000L, TimeUnit.MILLISECONDS)) {
                return;
            }
            Logger.warn(str, "terminating now");
            sSilentExecutor.shutdownNow();
        } catch (InterruptedException unused) {
            Logger.warn(str, "terminating again");
            sSilentExecutor.shutdownNow();
        }
    }

    public static void resetSilentRequestExecutor() {
        Logger.info(TAG + ":resetSilentRequestExecutor", "Resetting silent Executor");
        sSilentExecutor = Executors.newFixedThreadPool(5);
    }
}
