package com.github.iweinzierl.android.logging;

import android.content.Context;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class AndroidLoggerFactory implements ILoggerFactory {

    public static final String DEFAULT_LOG_TAG = "[unset]";
    public static final String PACKAGE_SEPARATOR = "\\.";

    private static AndroidLoggerFactory INSTANCE;

    private final Map<String, AndroidLogger> loggers;
    private Class loggerClass = AndroidLogger.class;
    private Context context;
    private String logTag;

    private AndroidLoggerFactory(final String logTag) {
        this.loggers = new HashMap<String, AndroidLogger>();
        this.logTag = logTag;
    }

    public Logger getLogger(final String name) {
        return getLogger(name, logTag);
    }

    public Logger getLogger(final String name, final String logTag) {
        AndroidLogger logger = loggers.get(name);
        if (logger == null) {
            String loggerName = stripName(name);
            logger = newLogger(context, logTag, loggerName);

            loggers.put(name, logger);
        }

        return logger;
    }

    public static AndroidLoggerFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AndroidLoggerFactory(DEFAULT_LOG_TAG);
        }

        return INSTANCE;
    }

    public static AndroidLoggerFactory getInstance(final String logTag) {
        if (INSTANCE == null) {
            INSTANCE = new AndroidLoggerFactory(logTag);
        }

        return INSTANCE;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setLogTag(final String logTag) {
        this.logTag = logTag;
    }

    public void setLoggerClass(Class loggerClass) {
        this.loggerClass = loggerClass;
    }

    private String stripName(final String className) {
        String[] classParts = className.split(PACKAGE_SEPARATOR);
        return classParts[classParts.length - 1];
    }

    private AndroidLogger newLogger(Context context, String logTag, String loggerName) {
        try {
            /*
            Constructor constructor = loggerClass.getConstructor(Context.class, String.class, String.class);
            return (AndroidLogger) constructor.newInstance(context, logTag, loggerName);
            */

            AndroidLogger logger = (AndroidLogger) loggerClass.newInstance();
            logger.setContext(context);
            logger.setLogTag(logTag);
            logger.setName(loggerName);

            return logger;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Constructor not accessible", e);
        } catch (InstantiationException e) {
            throw new RuntimeException("Unable to instantiate AndroidLogger", e);
        }
    }
}
