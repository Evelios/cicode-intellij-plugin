// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import org.intellij.sdk.language.CicodeFileType;

public class CicodeElementFactory {

  public static CicodeProperty createProperty(Project project, String name) {
    final CicodeFile file = createFile(project, name);
    return (CicodeProperty) file.getFirstChild();
  }

  public static CicodeFile createFile(Project project, String text) {
    String name = "dummy.cicode";
    return (CicodeFile) PsiFileFactory.getInstance(project).createFileFromText(name, CicodeFileType.INSTANCE, text);
  }

  public static CicodeProperty createProperty(Project project, String name, String value) {
    final CicodeFile file = createFile(project, name + " = " + value);
    return (CicodeProperty) file.getFirstChild();
  }

  public static PsiElement createCRLF(Project project) {
    final CicodeFile file = createFile(project, "\n");
    return file.getFirstChild();
  }

}
