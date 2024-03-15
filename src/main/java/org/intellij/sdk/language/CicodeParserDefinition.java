// Copyright 2000-2023 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.intellij.sdk.language.parser.CicodeParser;
import org.intellij.sdk.language.psi.CicodeFile;
import org.intellij.sdk.language.psi.CicodeTokenSets;
import org.intellij.sdk.language.psi.CicodeTypes;
import org.jetbrains.annotations.NotNull;

final class CicodeParserDefinition implements ParserDefinition {

  public static final IFileElementType FILE = new IFileElementType(CicodeLanguage.INSTANCE);

  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new CicodeLexerAdapter();
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return CicodeTokenSets.COMMENTS;
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }

  @NotNull
  @Override
  public PsiParser createParser(final Project project) {
    return new CicodeParser();
  }

  @NotNull
  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @NotNull
  @Override
  public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
    return new CicodeFile(viewProvider);
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return CicodeTypes.Factory.createElement(node);
  }

}
