// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.impl.source.tree.java.PsiJavaTokenImpl;
import org.intellij.sdk.language.psi.CicodeProperty;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

final class CicodeLineMarkerProvider extends RelatedItemLineMarkerProvider {

  @Override
  protected void collectNavigationMarkers(@NotNull PsiElement element,
                                          @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
    // This must be an element with a literal expression as a parent
    if (!(element instanceof PsiJavaTokenImpl) || !(element.getParent() instanceof PsiLiteralExpression)) {
      return;
    }

    // The literal expression must start with the Cicode language literal expression
    PsiLiteralExpression literalExpression = (PsiLiteralExpression) element.getParent();
    String value = literalExpression.getValue() instanceof String ? (String) literalExpression.getValue() : null;
    if ((value == null) ||
        !value.startsWith(CicodeAnnotator.CICODE_PREFIX_STR + CicodeAnnotator.CICODE_SEPARATOR_STR)) {
      return;
    }

    // Get the Cicode language property usage
    Project project = element.getProject();
    String possibleProperties = value.substring(
        CicodeAnnotator.CICODE_PREFIX_STR.length() + CicodeAnnotator.CICODE_SEPARATOR_STR.length()
    );
    final List<CicodeProperty> properties = CicodeUtil.findProperties(project, possibleProperties);
    if (properties.size() > 0) {
      // Add the property to a collection of line marker info
      NavigationGutterIconBuilder<PsiElement> builder =
          NavigationGutterIconBuilder.create(CicodeIcons.FILE)
              .setTargets(properties)
              .setTooltipText("Navigate to Cicode language property");
      result.add(builder.createLineMarkerInfo(element));
    }
  }

}
