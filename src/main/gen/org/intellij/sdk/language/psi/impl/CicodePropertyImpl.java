// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.intellij.sdk.language.psi.CicodeProperty;
import org.intellij.sdk.language.psi.CicodeVisitor;
import org.jetbrains.annotations.NotNull;

public class CicodePropertyImpl extends CicodeNamedElementImpl implements CicodeProperty {

  public CicodePropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CicodeVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CicodeVisitor) accept((CicodeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return CicodePsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return CicodePsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return CicodePsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(@NotNull String newName) {
    return CicodePsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return CicodePsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return CicodePsiImplUtil.getPresentation(this);
  }

}
