plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "sentiment-analysis"
include("sentiment-analysis-application")
include("sentiment-task-orchestrator")
include("sentiment-llm-engine")
include("sentiment-llm-engine")
