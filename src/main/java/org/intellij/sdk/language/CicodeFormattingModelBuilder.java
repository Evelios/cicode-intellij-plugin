// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import org.intellij.sdk.language.psi.CicodeTypes;
import org.jetbrains.annotations.NotNull;

final class CicodeFormattingModelBuilder implements FormattingModelBuilder {

  private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
    return new SpacingBuilder(settings, CicodeLanguage.INSTANCE)
        .around(CicodeTypes.SEPARATOR)
        .spaceIf(settings.getCommonSettings(CicodeLanguage.INSTANCE.getID()).SPACE_AROUND_ASSIGNMENT_OPERATORS)
        .before(CicodeTypes.PROPERTY)
        .none();
  }

  @Override
  public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
    final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
    return FormattingModelProvider
        .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
            new CicodeBlock(formattingContext.getNode(),
                Wrap.createWrap(WrapType.NONE, false),
                Alignment.createAlignment(),
                createSpaceBuilder(codeStyleSettings)),
            codeStyleSettings);
  }

}
