package com.nleachdev.noveildi.framework.service;

import com.nleachdev.noveildi.framework.exception.ClassScanningException;

import java.util.Set;

public interface ClassScanner {
    Set<Class<?>> getClasses(final String rootDirectory, final Set<String> availablePackages) throws ClassScanningException;
}
