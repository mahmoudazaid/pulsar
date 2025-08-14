package com.pulsar.selenium.locator.core;

import org.openqa.selenium.By;

public interface I18nLocator {

    String getKey();

    By by(Object... index);
}
