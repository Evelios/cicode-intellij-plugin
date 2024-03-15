// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.CicodeLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CicodeTokenType extends IElementType {

  public CicodeTokenType(@NotNull @NonNls String debugName) {
    super(debugName, CicodeLanguage.INSTANCE);
  }

  @Override
  public String toString() {
    return "CicodeTokenType." + super.toString();
  }

}
