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
import spp.jetbrains.marker.AbstractInstrumentConditionParser

/**
 * todo: description.
 *
 * @since 0.3.0
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object InstrumentConditionParser : AbstractInstrumentConditionParser {

    private val LOCAL_VAR_REGEX: Regex = Regex("localVariables\\[(.+)\\]")
    private val FIELD_VAR_REGEX: Regex = Regex("fields\\[(.+)\\]")
    private val STATIC_FIELD_VAR_REGEX: Regex = Regex("staticFields\\[(.+)\\]")

    @JvmStatic
    fun fromLiveConditional(conditional: String): String {
        var rtnConditional = conditional
        LOCAL_VAR_REGEX.findAll(rtnConditional).forEach {
            rtnConditional = rtnConditional.replace(it.groupValues[0], it.groupValues[1])
        }
        FIELD_VAR_REGEX.findAll(rtnConditional).forEach {
            rtnConditional = rtnConditional.replace(it.groupValues[0], it.groupValues[1])
        }
        STATIC_FIELD_VAR_REGEX.findAll(rtnConditional).forEach {
            rtnConditional = rtnConditional.replace(it.groupValues[0], it.groupValues[1])
        }
        return rtnConditional
    }

    private val services = mutableMapOf<String, AbstractInstrumentConditionParser>()

    fun addService(conditionParser: AbstractInstrumentConditionParser, language: String, vararg languages: String) {
        services[language] = conditionParser
        languages.forEach { services[it] = conditionParser }
    }

    private fun getService(language: String): AbstractInstrumentConditionParser {
        return services[language] ?: throw IllegalArgumentException("No service for language $language")
    }

    override fun getCondition(condition: String, context: PsiElement): String {
        return getService(context.language.id).getCondition(condition, context)
    }
}
