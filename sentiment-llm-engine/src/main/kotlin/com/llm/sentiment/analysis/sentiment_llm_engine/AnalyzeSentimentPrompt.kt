package com.llm.sentiment.analysis.sentiment_llm_engine

import org.springframework.stereotype.Component


@Component
class AnalyzeSentimentPrompt : AbstractPromptModelCall() {

    override fun getPrompt(inputText: String): String {
        return """
            Please analyze the sentiment of the following text and responde with one word: positive, negative or neutral.
            "Text: $inputText"
        """.trimIndent()
    }
}