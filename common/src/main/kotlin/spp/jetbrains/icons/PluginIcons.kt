/*
 * Source++, the continuous feedback platform for developers.
 * Copyright (C) 2022-2023 CodeBrig, Inc.
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
package spp.jetbrains.icons

import com.intellij.openapi.util.IconLoader

/**
 * Defines the various visual icons the plugin may display.
 *
 * @author [Brandon Fergerson](mailto:bfergerson@apache.org)
 */
object PluginIcons {

    object Nodes {
        @JvmField
        val variable = IconLoader.getIcon("/nodes/variable.png", PluginIcons::class.java)
    }

    object Command {
        @JvmField
        val logo = IconLoader.getIcon("/icons/command/logo.svg", PluginIcons::class.java)
    }

    object Instrument {
        val save = IconLoader.getIcon("/icons/instrument/live-log/save.svg", PluginIcons::class.java)
        val saveHovered = IconLoader.getIcon("/icons/instrument/live-log/saveHovered.svg", PluginIcons::class.java)
        val savePressed = IconLoader.getIcon("/icons/instrument/live-log/savePressed.svg", PluginIcons::class.java)

        object Overview {
            val active = IconLoader.getIcon(
                "/icons/instrument/overview/plug-circle-bolt.svg", PluginIcons::class.java
            )
            val complete = IconLoader.getIcon(
                "/icons/instrument/overview/plug-circle-check.svg", PluginIcons::class.java
            )
            val pending = IconLoader.getIcon(
                "/icons/instrument/overview/plug-circle-exclamation.svg", PluginIcons::class.java
            )
            val error = IconLoader.getIcon(
                "/icons/instrument/overview/plug-circle-xmark.svg", PluginIcons::class.java
            )
        }
    }

    object Log {
        val active = IconLoader.getIcon("/icons/instrument/live-log/live-log-active.svg", PluginIcons::class.java)
        val foreign = IconLoader.getIcon("/icons/instrument/live-log/live-log-foreign.svg", PluginIcons::class.java)
    }

    object Breakpoint {
        val active = IconLoader.getIcon("/icons/breakpoint/live-breakpoint-active.svg", PluginIcons::class.java)
        val complete = IconLoader.getIcon("/icons/breakpoint/live-breakpoint-complete.svg", PluginIcons::class.java)
        val error = IconLoader.getIcon("/icons/breakpoint/live-breakpoint-error.svg", PluginIcons::class.java)
        val foreign = IconLoader.getIcon("/icons/breakpoint/live-breakpoint-foreign.svg", PluginIcons::class.java)
    }

    object ToolWindow {
        val chartArea = IconLoader.getIcon("/icons/tool-window/chart-area.svg", PluginIcons::class.java)
        val listTree = IconLoader.getIcon("/icons/tool-window/list-tree.svg", PluginIcons::class.java)
        val memo = IconLoader.getIcon("/icons/tool-window/memo.svg", PluginIcons::class.java)
        val satelliteDish = IconLoader.getIcon("/icons/tool-window/satellite-dish.svg", PluginIcons::class.java)
    }

    val statusEnabled = IconLoader.getIcon("/icons/statusBar/status-enabled.svg", PluginIcons::class.java)
    val statusPending = IconLoader.getIcon("/icons/statusBar/status-pending.svg", PluginIcons::class.java)
    val statusDisabled = IconLoader.getIcon("/icons/statusBar/status-disabled.svg", PluginIcons::class.java)
    val statusFailed = IconLoader.getIcon("/icons/statusBar/status-failed.svg", PluginIcons::class.java)

    @JvmField
    val minimize = IconLoader.getIcon("/icons/minimize.svg", PluginIcons::class.java)

    @JvmField
    val minimizeHovered = IconLoader.getIcon("/icons/minimizeHovered.svg", PluginIcons::class.java)

    @JvmField
    val minimizePressed = IconLoader.getIcon("/icons/minimizePressed.svg", PluginIcons::class.java)

    @JvmField
    val close = IconLoader.getIcon("/icons/close.svg", PluginIcons::class.java)

    @JvmField
    val closeHovered = IconLoader.getIcon("/icons/closeHovered.svg", PluginIcons::class.java)

    @JvmField
    val closePressed = IconLoader.getIcon("/icons/closePressed.svg", PluginIcons::class.java)

    @JvmField
    val clock = IconLoader.getIcon("/icons/clock.svg", PluginIcons::class.java)

    @JvmField
    val logConfig = IconLoader.getIcon("/icons/log-config.svg", PluginIcons::class.java)

    @JvmField
    val angleDown = IconLoader.getIcon("/icons/angle-down.svg", PluginIcons::class.java)

    @JvmField
    val breakpointConfig = IconLoader.getIcon("/icons/breakpoint-config.svg", PluginIcons::class.java)

    @JvmField
    val eyeSlash = IconLoader.getIcon("/icons/eye-slash.svg", PluginIcons::class.java)

    @JvmField
    val meterConfig = IconLoader.getIcon("/icons/meter-config.svg", PluginIcons::class.java)

    @JvmField
    val spanConfig = IconLoader.getIcon("/icons/span-config.svg", PluginIcons::class.java)

    val count = IconLoader.getIcon("/icons/count.svg", PluginIcons::class.java)
    val gauge = IconLoader.getIcon("/icons/gauge.svg", PluginIcons::class.java)
    val histogram = IconLoader.getIcon("/icons/histogram.svg", PluginIcons::class.java)
    val squareCheck = IconLoader.getIcon("/icons/square-check.svg", PluginIcons::class.java)
    val squareDashed = IconLoader.getIcon("/icons/square-dashed.svg", PluginIcons::class.java)
    val chartMixed = IconLoader.getIcon("/icons/chart-mixed.svg", PluginIcons::class.java)
    val clockRotateLeft = IconLoader.getIcon("/icons/clock-rotate-left.svg", PluginIcons::class.java)
    val play = IconLoader.getIcon("/icons/play.svg", PluginIcons::class.java)
    val stop = IconLoader.getIcon("/icons/stop.svg", PluginIcons::class.java)
    val errorBug = IconLoader.getIcon("/icons/error-bug.svg", PluginIcons::class.java)
    val check = IconLoader.getIcon("/icons/check.svg", PluginIcons::class.java)
    val rotate = IconLoader.getIcon("/icons/rotate.svg", PluginIcons::class.java)
    val triangleExclamation = IconLoader.getIcon("/icons/triangle-exclamation.svg", PluginIcons::class.java)
    val trash = IconLoader.getIcon("/icons/trash.svg", PluginIcons::class.java)
    val trashList = IconLoader.getIcon("/icons/trash-list.svg", PluginIcons::class.java)
    val trashCan = IconLoader.getIcon("/icons/trash-can.svg", PluginIcons::class.java)
    val xmark = IconLoader.getIcon("/icons/xmark-large.svg", PluginIcons::class.java)
    val user = IconLoader.getIcon("/icons/user.svg", PluginIcons::class.java)
}
