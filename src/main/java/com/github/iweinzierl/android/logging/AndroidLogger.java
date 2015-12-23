package com.github.iweinzierl.android.logging;

import android.content.Context;
import android.util.Log;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

public class AndroidLogger implements org.slf4j.Logger {

    private static final String MESSAGE_TEMPLATE = "%s -> %s";

    protected Context context;
    protected String logTag;
    protected String name;

    protected AndroidLogger() {
    }

    protected AndroidLogger(Context context, final String logTag, final String name) {
        this.context = context;
        this.logTag = logTag;
        this.name = name;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setLogTag(String logTag) {
        this.logTag = logTag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isTraceEnabled() {
        return Log.isLoggable(logTag, Log.VERBOSE);
    }

    public void trace(final String msg) {
        Log.v(logTag, buildMessage(msg));
    }

    public void trace(final String format, final Object arg) {
        Log.v(logTag, buildMessage(format, arg));
    }

    public void trace(final String format, final Object arg1, final Object arg2) {
        Log.v(logTag, buildMessage(format, arg1, arg2));
    }

    public void trace(final String format, final Object... args) {
        Log.v(logTag, buildMessage(format, args));
    }

    public void trace(final String msg, final Throwable t) {
        Log.v(logTag, buildMessage(msg), t);
    }

    public boolean isTraceEnabled(final Marker marker) {
        return isTraceEnabled();
    }

    public void trace(final Marker marker, final String msg) {
        trace(msg);
    }

    public void trace(final Marker marker, final String format, final Object arg) {
        trace(format, arg);
    }

    public void trace(final Marker marker, final String format, final Object arg1, final Object arg2) {
        trace(format, arg1, arg2);
    }

    public void trace(final Marker marker, final String format, final Object... args) {
        trace(format, args);
    }

    public void trace(final Marker marker, final String msg, final Throwable t) {
        trace(msg, t);
    }

    public boolean isDebugEnabled() {
        return Log.isLoggable(logTag, Log.DEBUG);
    }

    public void debug(final String msg) {
        Log.d(logTag, buildMessage(msg));
    }

    public void debug(final String format, final Object arg) {
        Log.d(logTag, buildMessage(format, arg));
    }

    public void debug(final String format, final Object arg1, final Object arg2) {
        Log.d(logTag, buildMessage(format, arg1, arg2));
    }

    public void debug(final String format, final Object... args) {
        Log.d(logTag, buildMessage(format, args));
    }

    public void debug(final String msg, final Throwable t) {
        Log.d(logTag, buildMessage(msg), t);
    }

    public boolean isDebugEnabled(final Marker marker) {
        return isDebugEnabled();
    }

    public void debug(final Marker marker, final String msg) {
        debug(msg);
    }

    public void debug(final Marker marker, final String format, final Object arg) {
        debug(format, arg);
    }

    public void debug(final Marker marker, final String format, final Object arg1, final Object arg2) {
        debug(format, arg1, arg2);
    }

    public void debug(final Marker marker, final String format, final Object... args) {
        debug(format, args);
    }

    public void debug(final Marker marker, final String msg, final Throwable t) {
        debug(msg, t);
    }

    public boolean isInfoEnabled() {
        return Log.isLoggable(logTag, Log.INFO);
    }

    public void info(final String msg) {
        Log.i(logTag, buildMessage(msg));
    }

    public void info(final String format, final Object arg) {
        Log.i(logTag, buildMessage(format, arg));
    }

    public void info(final String format, final Object arg1, final Object arg2) {
        Log.i(logTag, buildMessage(format, arg1, arg2));
    }

    public void info(final String format, final Object... args) {
        Log.i(logTag, buildMessage(format, args));
    }

    public void info(final String msg, final Throwable t) {
        Log.i(logTag, buildMessage(msg), t);
    }

    public boolean isInfoEnabled(final Marker marker) {
        return isInfoEnabled();
    }

    public void info(final Marker marker, final String msg) {
        info(msg);
    }

    public void info(final Marker marker, final String format, final Object arg) {
        info(format, arg);
    }

    public void info(final Marker marker, final String format, final Object arg1, final Object arg2) {
        info(format, arg1, arg2);
    }

    public void info(final Marker marker, final String format, final Object... args) {
        info(format, args);
    }

    public void info(final Marker marker, final String msg, final Throwable t) {
        info(msg, t);
    }

    public boolean isWarnEnabled() {
        return Log.isLoggable(logTag, Log.WARN);
    }

    public void warn(final String msg) {
        Log.w(logTag, buildMessage(msg));
    }

    public void warn(final String format, final Object arg) {
        Log.w(logTag, buildMessage(format, arg));
    }

    public void warn(final String format, final Object... args) {
        Log.w(logTag, buildMessage(format, args));
    }

    public void warn(final String format, final Object arg1, final Object arg2) {
        Log.w(logTag, buildMessage(format, arg1, arg2));
    }

    public void warn(final String msg, final Throwable t) {
        Log.w(logTag, buildMessage(msg), t);
    }

    public boolean isWarnEnabled(final Marker marker) {
        return isWarnEnabled();
    }

    public void warn(final Marker marker, final String msg) {
        warn(msg);
    }

    public void warn(final Marker marker, final String format, final Object arg) {
        warn(format, arg);
    }

    public void warn(final Marker marker, final String format, final Object arg1, final Object arg2) {
        warn(format, arg1, arg2);
    }

    public void warn(final Marker marker, final String format, final Object... args) {
        warn(format, args);
    }

    public void warn(final Marker marker, final String msg, final Throwable t) {
        warn(msg, t);
    }

    public boolean isErrorEnabled() {
        return Log.isLoggable(logTag, Log.ERROR);
    }

    public void error(final String msg) {
        Log.e(logTag, buildMessage(msg));
    }

    public void error(final String format, final Object arg) {
        Log.e(logTag, buildMessage(format, arg));
    }

    public void error(final String format, final Object arg1, final Object arg2) {
        Log.e(logTag, buildMessage(format, arg1, arg2));
    }

    public void error(final String format, final Object... args) {
        Log.e(logTag, buildMessage(format, args));
    }

    public void error(final String msg, final Throwable t) {
        Log.e(logTag, buildMessage(msg), t);
    }

    public boolean isErrorEnabled(final Marker marker) {
        return isErrorEnabled();
    }

    public void error(final Marker marker, final String msg) {
        error(msg);
    }

    public void error(final Marker marker, final String format, final Object arg) {
        error(format, arg);
    }

    public void error(final Marker marker, final String format, final Object arg1, final Object arg2) {
        error(format, arg1, arg2);
    }

    public void error(final Marker marker, final String format, final Object... args) {
        error(format, args);
    }

    public void error(final Marker marker, final String msg, final Throwable t) {
        error(msg, t);
    }

    protected String buildMessage(final String message, final Object... args) {
        if (args != null && args.length > 0) {
            final String compoundMessage = MessageFormatter.arrayFormat(message, args).getMessage();
            return String.format(MESSAGE_TEMPLATE, name, compoundMessage);
        } else {
            return String.format(MESSAGE_TEMPLATE, name, message);
        }
    }
}
