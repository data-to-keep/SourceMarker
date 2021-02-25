![](.github/media/SM.svg)

![Build](https://github.com/sourceplusplus/SourceMarker/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/15407-sourcemarker.svg)](https://plugins.jetbrains.com/plugin/15407-sourcemarker)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/15407-sourcemarker.svg)](https://plugins.jetbrains.com/plugin/15407-sourcemarker)

![](.github/media/misc/SM_IDE-APM.gif)

## Description

<!-- Plugin description -->
SourceMarker (alpha) is a JetBrains-powered plugin which provides continuous feedback capabilities via integration with [Apache SkyWalking](https://github.com/apache/skywalking). SourceMarker increases software development productivity via the Feedback-Driven Development (FDD) approach, a methodology of combining IDE and APM technology to create tighter feedback loops.
<!-- Plugin description end -->

## Features

- Source code contextual user interface
- Service, service instance, endpoint metrics
- Database access metrics
- Integrated distributed trace mapping
- Active exception correlation/tracking

## Demonstration

<table>
  <tr>
      <td width="33%" align="center"><b>Logging (Promo)</b></td>
      <td width="33%" align="center"><b>Tracing (Promo)</b></td>
      <td width="33%" align="center"><b>Alerting (Promo)</b></td>
  </tr>
  <tr>
     <td><a href="https://youtu.be/Un_d3nlOGRA"><img src=".github/media/misc/SM_Logging.gif"/></a></td>
     <td><a href="https://youtu.be/Un_d3nlOGRA"><img src=".github/media/misc/SM_Tracing.gif"/></a></td>
     <td><a href="https://youtu.be/Un_d3nlOGRA"><img src=".github/media/misc/SM_Alerting.gif"/></a></td>
  </tr>
</table>

<table>
  <tr>
      <td width="50%" align="center"><b>Talk</b></td>
      <td width="50%" align="center"><b>Screencast</b></td>
  </tr>
  <tr>
     <td><a href="https://youtu.be/l8H9ckk_0NY"><img src=".github/media/misc/SM-CFD_Software.jpg"/></a></td>
     <td><a href="https://youtu.be/ALDCtz4BJ9g"><img src=".github/media/misc/SM-v0.2.1-Screencast.gif"/></a></td>
  </tr>
</table>

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "SourceMarker"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/sourceplusplus/SourceMarker/releases/latest) and install it manually using
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙</kbd> > <kbd>Install plugin from disk...</kbd>

## Usage

- [Getting Started](docs/getting-started.md)
- [Quick Start](docs/quick-start.md)

# Development

## Project Structure

### Framework

| Module                        | Description                                                          | Version |
| ----------------------------- | -------------------------------------------------------------------- | ------- |
| :mapper                       | Tracks source code artifact refactoring                              | 0.2.0   |
| :marker                       | Used to tie visual marks & popups to source code artifacts           | 0.2.0   |
| :portal                       | Used to visually display contextualized artifact data/advice         | 0.2.0   |
| :protocol                     | Common communication data models                                     | 0.2.0   |

### Implementation

| Module                        | Description                                                          | Version |
| ----------------------------- | -------------------------------------------------------------------- | ------- |
| :monitor:skywalking           | Apache SkyWalking monitor implementation                             | 0.2.0   |
| :plugin:jetbrains             | JetBrains plugin implementation                                      | 0.2.0   |

## Attribution

This project was highly influenced by [PerformanceHat](https://github.com/sealuzh/PerformanceHat). Thanks for the insights
that made this possible.

## License

[Apache License 2.0](LICENSE)
