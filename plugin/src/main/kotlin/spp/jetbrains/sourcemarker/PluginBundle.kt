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
package spp.jetbrains.sourcemarker

import com.intellij.AbstractBundle
import com.intellij.ide.plugins.PluginManager
import com.intellij.openapi.extensions.PluginId
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.PropertyKey
import java.util.*

@NonNls
private const val BUNDLE = "messages.PluginBundle"

/**
 * todo: description.
 *
 * @since 0.2.0
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object PluginBundle : AbstractBundle(BUNDLE) {

    val LOCALE: Locale by lazy {
        val chineseLanguagePlugin = "com.intellij.zh"
        if (PluginManager.isPluginInstalled(PluginId.getId(chineseLanguagePlugin))) {
            Locale.CHINA
        } else {
            Locale.ROOT
        }
    }

    //todo: shouldn't need to manually load bundle.
    val LOCALE_BUNDLE: ResourceBundle by lazy {
        ResourceBundle.getBundle(BUNDLE, LOCALE, PluginBundle::class.java.classLoader)
    }

    @Suppress("SpreadOperator")
    @JvmStatic
    fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any): String {
        return try {
            LOCALE_BUNDLE.getString(key) ?: getMessage(key, *params)
        } catch (ignore: MissingResourceException) {
            key // no translation found
        }
    }
}
