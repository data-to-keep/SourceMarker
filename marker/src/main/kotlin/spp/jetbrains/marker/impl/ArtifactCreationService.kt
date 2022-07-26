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
package spp.jetbrains.marker.impl

import com.intellij.psi.PsiElement
import spp.jetbrains.marker.AbstractArtifactCreationService
import spp.jetbrains.marker.source.SourceFileMarker
import spp.jetbrains.marker.source.mark.gutter.ExpressionGutterMark
import spp.jetbrains.marker.source.mark.gutter.MethodGutterMark
import spp.jetbrains.marker.source.mark.inlay.ExpressionInlayMark
import spp.jetbrains.marker.source.mark.inlay.MethodInlayMark
import java.util.*

/**
 * todo: description.
 *
 * @since 0.4.0
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object ArtifactCreationService : AbstractArtifactCreationService {

    private val services = mutableMapOf<String, AbstractArtifactCreationService>()

    fun addService(creationService: AbstractArtifactCreationService, language: String, vararg languages: String) {
        services[language] = creationService
        languages.forEach { services[it] = creationService }
    }

    private fun getService(language: String): AbstractArtifactCreationService {
        return services[language] ?: throw IllegalArgumentException("No service for language $language")
    }

    override fun getOrCreateExpressionGutterMark(
        fileMarker: SourceFileMarker,
        lineNumber: Int,
        autoApply: Boolean
    ): Optional<ExpressionGutterMark> {
        return getService(fileMarker.psiFile.language.id)
            .getOrCreateExpressionGutterMark(fileMarker, lineNumber, autoApply)
    }

    override fun getOrCreateMethodGutterMark(
        fileMarker: SourceFileMarker,
        element: PsiElement,
        autoApply: Boolean
    ): MethodGutterMark? {
        return getService(fileMarker.psiFile.language.id)
            .getOrCreateMethodGutterMark(fileMarker, element, autoApply)
    }

    override fun getOrCreateExpressionInlayMark(
        fileMarker: SourceFileMarker,
        lineNumber: Int,
        autoApply: Boolean
    ): Optional<ExpressionInlayMark> {
        return getService(fileMarker.psiFile.language.id)
            .getOrCreateExpressionInlayMark(fileMarker, lineNumber, autoApply)
    }

    override fun createMethodGutterMark(
        fileMarker: SourceFileMarker,
        element: PsiElement,
        autoApply: Boolean
    ): MethodGutterMark {
        return getService(fileMarker.psiFile.language.id)
            .createMethodGutterMark(fileMarker, element, autoApply)
    }

    override fun createMethodInlayMark(
        fileMarker: SourceFileMarker,
        element: PsiElement,
        autoApply: Boolean
    ): MethodInlayMark {
        return getService(fileMarker.psiFile.language.id)
            .createMethodInlayMark(fileMarker, element, autoApply)
    }

    override fun createExpressionInlayMark(
        fileMarker: SourceFileMarker,
        lineNumber: Int,
        autoApply: Boolean
    ): ExpressionInlayMark {
        return getService(fileMarker.psiFile.language.id)
            .createExpressionInlayMark(fileMarker, lineNumber, autoApply)
    }
}
