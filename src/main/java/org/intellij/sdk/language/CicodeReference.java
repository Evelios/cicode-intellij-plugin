// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.intellij.sdk.language.psi.CicodeProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

final class CicodeReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

  private final String key;

  CicodeReference(@NotNull PsiElement element, TextRange textRange) {
    super(element, textRange);
    key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
  }

  @Override
  public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
    Project project = myElement.getProject();
    final List<CicodeProperty> properties = CicodeUtil.findProperties(project, key);
    List<ResolveResult> results = new ArrayList<>();
    for (CicodeProperty property : properties) {
      results.add(new PsiElementResolveResult(property));
    }
    return results.toArray(new ResolveResult[0]);
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    ResolveResult[] resolveResults = multiResolve(false);
    return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
  }

  @Override
  public Object @NotNull [] getVariants() {
    Project project = myElement.getProject();
    List<CicodeProperty> properties = CicodeUtil.findProperties(project);
    List<LookupElement> variants = new ArrayList<>();
    for (final CicodeProperty property : properties) {
      if (property.getKey() != null && property.getKey().length() > 0) {
        variants.add(LookupElementBuilder
            .create(property).withIcon(CicodeIcons.FILE)
            .withTypeText(property.getContainingFile().getName())
        );
      }
    }
    return variants.toArray();
  }

}
