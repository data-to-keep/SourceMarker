/*
 * Source++, the open-source live coding platform.
 * Copyright (C) 2022 CodeBrig, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spp.jetbrains.marker.jvm

import com.intellij.psi.*
import com.intellij.psi.scope.processor.VariablesProcessor
import com.intellij.psi.scope.util.PsiScopesUtil
import spp.jetbrains.marker.AbstractArtifactScopeService
import spp.jetbrains.marker.SourceMarkerUtils
import spp.jetbrains.marker.source.SourceFileMarker

/**
 * todo: description.
 *
 * @since 0.4.0
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
class JVMArtifactScopeService : AbstractArtifactScopeService {

    fun isMethodAtLine(psiFile: PsiFile, lineNumber: Int): Boolean {
        var el = SourceMarkerUtils.getElementAtLine(psiFile, lineNumber)
        while (el is PsiKeyword || el is PsiModifierList) {
            el = el.parent
        }
        return el is PsiMethod
    }

    override fun getScopeVariables(fileMarker: SourceFileMarker, lineNumber: Int): List<String> {
        //determine available vars
        var checkLine = lineNumber
        val scopeVars = mutableListOf<String>()
        var minScope: PsiElement? = null
        while (minScope == null) {
            minScope = SourceMarkerUtils.getElementAtLine(fileMarker.psiFile, --checkLine)
        }
        val variablesProcessor: VariablesProcessor = object : VariablesProcessor(false) {
            override fun check(`var`: PsiVariable, state: ResolveState): Boolean = true
        }
        PsiScopesUtil.treeWalkUp(variablesProcessor, minScope, null)
        for (i in 0 until variablesProcessor.size()) {
            scopeVars.add(variablesProcessor.getResult(i).name!!)
        }
        return scopeVars
    }
}
