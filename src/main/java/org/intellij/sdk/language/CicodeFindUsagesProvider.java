// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.intellij.sdk.language.psi.CicodeProperty;
import org.intellij.sdk.language.psi.CicodeTokenSets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class CicodeFindUsagesProvider implements FindUsagesProvider {

  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return new DefaultWordsScanner(new CicodeLexerAdapter(),
        CicodeTokenSets.IDENTIFIERS,
        CicodeTokenSets.COMMENTS,
        TokenSet.EMPTY);
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof PsiNamedElement;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return null;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    if (element instanceof CicodeProperty) {
      return "cicode property";
    }
    return "";
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof CicodeProperty) {
      return ((CicodeProperty) element).getKey();
    }
    return "";
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    if (element instanceof CicodeProperty) {
      return ((CicodeProperty) element).getKey() +
          CicodeAnnotator.CICODE_SEPARATOR_STR +
          ((CicodeProperty) element).getValue();
    }
    return "";
  }

}
