// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language;

import com.intellij.icons.AllIcons;
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import org.intellij.sdk.language.psi.CicodeFile;
import org.intellij.sdk.language.psi.CicodeProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

final class CicodeStructureAwareNavbar extends StructureAwareNavBarModelExtension {

  @NotNull
  @Override
  protected Language getLanguage() {
    return CicodeLanguage.INSTANCE;
  }

  @Override
  public @Nullable String getPresentableText(Object object) {
    if (object instanceof CicodeFile) {
      return ((CicodeFile) object).getName();
    }
    if (object instanceof CicodeProperty) {
      return ((CicodeProperty) object).getName();
    }

    return null;
  }

  @Override
  @Nullable
  public Icon getIcon(Object object) {
    if (object instanceof CicodeProperty) {
      return AllIcons.Nodes.Property;
    }

    return null;
  }

}
