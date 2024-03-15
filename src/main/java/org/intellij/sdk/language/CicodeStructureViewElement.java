// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.CicodeFile;
import org.intellij.sdk.language.psi.CicodeProperty;
import org.intellij.sdk.language.psi.impl.CicodePropertyImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CicodeStructureViewElement implements StructureViewTreeElement, SortableTreeElement {

  private final NavigatablePsiElement myElement;

  public CicodeStructureViewElement(NavigatablePsiElement element) {
    this.myElement = element;
  }

  @Override
  public Object getValue() {
    return myElement;
  }

  @Override
  public void navigate(boolean requestFocus) {
    myElement.navigate(requestFocus);
  }

  @Override
  public boolean canNavigate() {
    return myElement.canNavigate();
  }

  @Override
  public boolean canNavigateToSource() {
    return myElement.canNavigateToSource();
  }

  @NotNull
  @Override
  public String getAlphaSortKey() {
    String name = myElement.getName();
    return name != null ? name : "";
  }

  @NotNull
  @Override
  public ItemPresentation getPresentation() {
    ItemPresentation presentation = myElement.getPresentation();
    return presentation != null ? presentation : new PresentationData();
  }

  @Override
  public TreeElement @NotNull [] getChildren() {
    if (myElement instanceof CicodeFile) {
      List<CicodeProperty> properties = PsiTreeUtil.getChildrenOfTypeAsList(myElement, CicodeProperty.class);
      List<TreeElement> treeElements = new ArrayList<>(properties.size());
      for (CicodeProperty property : properties) {
        treeElements.add(new CicodeStructureViewElement((CicodePropertyImpl) property));
      }
      return treeElements.toArray(new TreeElement[0]);
    }
    return EMPTY_ARRAY;
  }

}
