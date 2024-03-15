// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class CicodeVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull CicodeProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull CicodeNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
