package com.llm.sentiment.analysis.sentiment_llm_engine

import org.springframework.stereotype.Component

@Component
class SummarizeTextPrompt : AbstractPromptModelCall() {
    override fun getPrompt(inputText: String): String {
        return """
            Please analyze the following text and answer with this text summarized as concise as you can and answer just the summary.
            "Text: $inputText"
        """.trimIndent()
    }
}