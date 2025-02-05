# Sentiment Analysis

A multi-module Kotlin-based sentiment analysis system that leverages modern techniques to analyze text sentiment. This repository includes separate modules for the main application, a large language model (LLM) engine, and a task orchestrator to coordinate sentiment analysis processes.

## Project Structure

- **sentiment-analysis-application**  
  Contains the user-facing application logic, handling input and displaying sentiment analysis results.

- **sentiment-llm-engine**  
  Implements the core logic for sentiment analysis using advanced LLM techniques. This module processes text and produces sentiment scores.

- **sentiment-task-orchestrator**  
  Coordinates the various tasks between the application and the LLM engine, ensuring a smooth workflow and efficient processing.

## Features

- **Modular Design:**  
  Each component is separated into its own module for clarity and maintainability.

- **Kotlin & Gradle:**  
  Built entirely with Kotlin and managed via Gradle, ensuring a modern, efficient development experience.

- **Scalable Sentiment Analysis:**  
  Designed to handle different workloads and text inputs, providing robust sentiment scoring.

## Prerequisites

- **JDK 11+** (or your preferred version compatible with Kotlin)
- **Gradle** (the project uses the Gradle Wrapper, so no additional installation is needed)

## Getting Started

1. **Clone the repository:**

   ```bash
   git clone https://github.com/naaaathan/sentiment-analysis.git
   cd sentiment-analysis
   ```

2. **Build the project:**

   Use the Gradle Wrapper to build all modules:

   ```bash
   ./gradlew build
   ```

   *(On Windows, run `gradlew.bat build`)*

3. **Run the Application:**

   Depending on the module you wish to run, you might execute a command like:

   ```bash
   ./gradlew :sentiment-analysis-application:run
   ```

   Adjust the task name if needed based on your specific module and entry point.

## Usage

Once running, the application will accept text input (from the command line or integrated UI, depending on your configuration) and output a sentiment analysis result. Detailed instructions for using each module can be found within the respective module directories.
