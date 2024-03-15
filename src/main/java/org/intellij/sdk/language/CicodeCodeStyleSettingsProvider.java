// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class CicodeCodeStyleSettingsProvider extends CodeStyleSettingsProvider {

  @Override
  public CustomCodeStyleSettings createCustomSettings(@NotNull CodeStyleSettings settings) {
    return new CicodeCodeStyleSettings(settings);
  }

  @Nullable
  @Override
  public String getConfigurableDisplayName() {
    return "Cicode";
  }

  @NotNull
  public CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings,
                                                  @NotNull CodeStyleSettings modelSettings) {
    return new CodeStyleAbstractConfigurable(settings, modelSettings, this.getConfigurableDisplayName()) {
      @Override
      protected @NotNull CodeStyleAbstractPanel createPanel(@NotNull CodeStyleSettings settings) {
        return new CicodeCodeStyleMainPanel(getCurrentSettings(), settings);
      }
    };
  }

  private static class CicodeCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {

    public CicodeCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
      super(CicodeLanguage.INSTANCE, currentSettings, settings);
    }

  }

}
