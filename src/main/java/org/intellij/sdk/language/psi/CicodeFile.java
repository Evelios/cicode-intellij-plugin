// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.intellij.sdk.language.CicodeFileType;
import org.intellij.sdk.language.CicodeLanguage;
import org.jetbrains.annotations.NotNull;

public class CicodeFile extends PsiFileBase {

  public CicodeFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, CicodeLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return CicodeFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "Cicode File";
  }

}
