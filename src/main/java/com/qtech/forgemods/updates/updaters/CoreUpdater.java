package com.qtech.forgemods.updates.updaters;

import com.qtech.forgemods.core.QFMCore;
import com.qtech.forgemods.core.QFMVersion;
import com.qtech.forgemods.core.modules.updates.AbstractUpdater;

import java.net.MalformedURLException;
import java.net.URL;

public class CoreUpdater extends AbstractUpdater<QFMVersion> {
    private static final String UPDATE_URL = "https://raw.githubusercontent.com/Qboi123/QForgeMod/master/update.json";
    private static final CoreUpdater INSTANCE = new CoreUpdater();

    @SuppressWarnings({"unused", "SameParameterValue"})
    private static URL getUrl(String s) {
        try {
            return new URL(UPDATE_URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private CoreUpdater() {
        super(getUrl(UPDATE_URL), QFMCore.getInstance());
    }

    static CoreUpdater getInstance() {
        return INSTANCE;
    }

    @Override
    public QFMVersion parseVersion(String version) {
        return new QFMVersion(version);
    }

    @Override
    public QFMVersion getCurrentModVersion() {
        return QFMCore.version;
    }
}
