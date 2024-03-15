// Copyright 2000-2023 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.intellij.sdk.language.psi.CicodeElementFactory;
import org.intellij.sdk.language.psi.CicodeProperty;
import org.intellij.sdk.language.psi.CicodeTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CicodePsiImplUtil {

  public static String getKey(CicodeProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(CicodeTypes.KEY);
    if (keyNode != null) {
      // IMPORTANT: Convert embedded escaped spaces to cicode spaces
      return keyNode.getText().replaceAll("\\\\ ", " ");
    } else {
      return null;
    }
  }

  public static String getValue(CicodeProperty element) {
    ASTNode valueNode = element.getNode().findChildByType(CicodeTypes.VALUE);
    if (valueNode != null) {
      return valueNode.getText();
    } else {
      return null;
    }
  }

  public static String getName(CicodeProperty element) {
    return getKey(element);
  }

  public static PsiElement setName(CicodeProperty element, String newName) {
    ASTNode keyNode = element.getNode().findChildByType(CicodeTypes.KEY);
    if (keyNode != null) {
      CicodeProperty property = CicodeElementFactory.createProperty(element.getProject(), newName);
      ASTNode newKeyNode = property.getFirstChild().getNode();
      element.getNode().replaceChild(keyNode, newKeyNode);
    }
    return element;
  }

  public static PsiElement getNameIdentifier(CicodeProperty element) {
    ASTNode keyNode = element.getNode().findChildByType(CicodeTypes.KEY);
    if (keyNode != null) {
      return keyNode.getPsi();
    } else {
      return null;
    }
  }

  public static ItemPresentation getPresentation(final CicodeProperty element) {
    return new ItemPresentation() {
      @Nullable
      @Override
      public String getPresentableText() {
        return element.getKey();
      }

      @Nullable
      @Override
      public String getLocationString() {
        PsiFile containingFile = element.getContainingFile();
        return containingFile == null ? null : containingFile.getName();
      }

      @Override
      public Icon getIcon(boolean unused) {
        return element.getIcon(0);
      }
    };
  }

}
