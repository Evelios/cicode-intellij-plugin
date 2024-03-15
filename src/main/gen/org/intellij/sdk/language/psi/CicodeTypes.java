// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface CicodeTypes {

  IElementType PROPERTY = new CicodeElementType("PROPERTY");

  IElementType COMMENT = new CicodeTokenType("COMMENT");
  IElementType CRLF = new CicodeTokenType("CRLF");
  IElementType KEY = new CicodeTokenType("KEY");
  IElementType SEPARATOR = new CicodeTokenType("SEPARATOR");
  IElementType VALUE = new CicodeTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new CicodePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
