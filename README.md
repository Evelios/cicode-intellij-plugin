# Cicode Language Sample [![JetBrains IntelliJ Platform SDK Docs](https://jb.gg/badges/docs.svg)][docs]
*Reference: [Custom Language Support Tutorial in IntelliJ SDK Docs][docs:custom_language_support_tutorial]*

## Quickstart

Defines a new language, _Cicode language_ with support for syntax highlighting, annotations, code completion, and other features.

### Extension Points

| Name                                          | Implementation                                                                          | Extension Point Class               |
|-----------------------------------------------|-----------------------------------------------------------------------------------------|-------------------------------------|
| `com.intellij.fileType`                       | [CicodeFileType][file:CicodeFileType]                                                   | `LanguageFileType`                  |
| `com.intellij.lang.parserDefinition`          | [CicodeParserDefinition][file:CicodeParserDefinition]                                   | `ParserDefinition`                  |
| `com.intellij.lang.syntaxHighlighterFactory`  | [CicodeSyntaxHighlighterFactory][file:CicodeSyntaxHighlighterFactory]                   | `SyntaxHighlighterFactory`          |
| `com.intellij.colorSettingsPage`              | [CicodeColorSettingsPage][file:CicodeColorSettingsPage]                                 | `ColorSettingsPage`                 |
| `com.intellij.annotator`                      | [CicodeAnnotator][file:CicodeAnnotator]                                                 | `Annotator`                         |
| `com.intellij.codeInsight.lineMarkerProvider` | [CicodeLineMarkerProvider][file:CicodeLineMarkerProvider]                               | `RelatedItemLineMarkerProvider`     |
| `com.intellij.completion.contributor`         | [CicodeCompletionContributor][file:CicodeCompletionContributor]                         | `CompletionContributor`             |
| `com.intellij.psi.referenceContributor`       | [CicodeReferenceContributor][file:CicodeReferenceContributor]                           | `PsiReferenceContributor`           |
| `com.intellij.lang.refactoringSupport`        | [CicodeRefactoringSupportProvider][file:CicodeRefactoringSupportProvider]               | `RefactoringSupportProvider`        |
| `com.intellij.lang.findUsagesProvider`        | [CicodeFindUsagesProvider][file:CicodeFindUsagesProvider]                               | `FindUsagesProvider`                |
| `com.intellij.lang.foldingBuilder`            | [CicodeFoldingBuilder][file:CicodeFoldingBuilder]                                       | `FoldingBuilderEx`                  |
| `com.intellij.gotoSymbolContributor`          | [CicodeChooseByNameContributor][file:CicodeChooseByNameContributor]                     | `ChooseByNameContributor`           |
| `com.intellij.lang.psiStructureViewFactory`   | [CicodeStructureViewFactory][file:CicodeStructureViewFactory]                           | `PsiStructureViewFactory`           |
| `com.intellij.lang.formatter`                 | [CicodeFormattingModelBuilder][file:CicodeFormattingModelBuilder]                       | `FormattingModelBuilder`            |
| `com.intellij.codeStyleSettingsProvider`      | [CicodeCodeStyleSettingsProvider][file:CicodeCodeStyleSettingsProvider]                 | `CodeStyleSettingsProvider`         |
| `com.intellij.langCodeStyleSettingsProvider`  | [CicodeLanguageCodeStyleSettingsProvider][file:CicodeLanguageCodeStyleSettingsProvider] | `LanguageCodeStyleSettingsProvider` |
| `com.intellij.lang.commenter`                 | [CicodeCommenter][file:CicodeCommenter]                                                 | `Commenter`                         |

*Reference: [Plugin Extension Points in IntelliJ SDK Docs][docs:ep]*


[docs]: https://plugins.jetbrains.com/docs/intellij/
[docs:custom_language_support_tutorial]: https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html
[docs:ep]: https://plugins.jetbrains.com/docs/intellij/plugin-extensions.html

[file:CicodeFileType]: ./src/main/java/org/intellij/sdk/language/CicodeFileType.java
[file:CicodeParserDefinition]: ./src/main/java/org/intellij/sdk/language/CicodeParserDefinition.java
[file:CicodeSyntaxHighlighterFactory]: ./src/main/java/org/intellij/sdk/language/CicodeSyntaxHighlighterFactory.java
[file:CicodeColorSettingsPage]: ./src/main/java/org/intellij/sdk/language/CicodeColorSettingsPage.java
[file:CicodeAnnotator]: ./src/main/java/org/intellij/sdk/language/CicodeAnnotator.java
[file:CicodeLineMarkerProvider]: ./src/main/java/org/intellij/sdk/language/CicodeLineMarkerProvider.java
[file:CicodeCompletionContributor]: ./src/main/java/org/intellij/sdk/language/CicodeCompletionContributor.java
[file:CicodeReferenceContributor]: ./src/main/java/org/intellij/sdk/language/CicodeReferenceContributor.java
[file:CicodeRefactoringSupportProvider]: ./src/main/java/org/intellij/sdk/language/CicodeRefactoringSupportProvider.java
[file:CicodeFindUsagesProvider]: ./src/main/java/org/intellij/sdk/language/CicodeFindUsagesProvider.java
[file:CicodeFoldingBuilder]: ./src/main/java/org/intellij/sdk/language/CicodeFoldingBuilder.java
[file:CicodeChooseByNameContributor]: ./src/main/java/org/intellij/sdk/language/CicodeChooseByNameContributor.java
[file:CicodeStructureViewFactory]: ./src/main/java/org/intellij/sdk/language/CicodeStructureViewFactory.java
[file:CicodeFormattingModelBuilder]: ./src/main/java/org/intellij/sdk/language/CicodeFormattingModelBuilder.java
[file:CicodeCodeStyleSettingsProvider]: ./src/main/java/org/intellij/sdk/language/CicodeCodeStyleSettingsProvider.java
[file:CicodeLanguageCodeStyleSettingsProvider]: ./src/main/java/org/intellij/sdk/language/CicodeLanguageCodeStyleSettingsProvider.java
[file:CicodeCommenter]: ./src/main/java/org/intellij/sdk/language/CicodeCommenter.java

## Cicode References

* [mgnslndh/NCicode .NET parser library ](https://github.com/mgnslndh/NCicode)