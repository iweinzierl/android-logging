package org.slf4j.impl;

import org.slf4j.ILoggerFactory;

import org.slf4j.spi.LoggerFactoryBinder;

import com.github.iweinzierl.android.logging.AndroidLoggerFactory;

public class StaticLoggerBinder implements LoggerFactoryBinder {

    private static StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    public static StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    public ILoggerFactory getLoggerFactory() {
        return AndroidLoggerFactory.getInstance();
    }

    public String getLoggerFactoryClassStr() {
        return AndroidLoggerFactory.class.getName();
    }
}
