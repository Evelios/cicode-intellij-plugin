// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class CicodeFileType extends LanguageFileType {

    public static final CicodeFileType INSTANCE = new CicodeFileType();

    private CicodeFileType() {
        super(CicodeLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Cicode File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Cicode language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "ci";
    }

    @NotNull
    @Override
    public Icon getIcon() {
        return CicodeIcons.FILE;
    }

}
