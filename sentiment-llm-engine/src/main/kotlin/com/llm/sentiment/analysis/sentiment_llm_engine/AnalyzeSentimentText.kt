package com.llm.sentiment.analysis.sentiment_llm_engine

import org.springframework.ai.chat.model.ChatResponse
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.openai.OpenAiChatModel
import org.springframework.ai.openai.OpenAiChatOptions
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux


@Component
class AnalyzeSentimentText {

    // This function will analyze the sentiment of the text using openai as neutral positive or negative

    fun analyzeSentiment(text: String): Flux<ChatResponse> {

        val openAiApi = OpenAiApi(System.getenv("OPENAI_API_KEY"));

        val openAiChatOptions = OpenAiChatOptions.builder()
            .withModel("gpt-3.5-turbo")
            .withTemperature(0.4)
            .withMaxTokens(5)
            .build();

        val chatModel = OpenAiChatModel(openAiApi, openAiChatOptions)

        val prompt = """
            Please analyze the sentiment of the following text and responde with one word: positive, negative or neutral.
            "Text: $text"
        """.trimIndent()


        val response: Flux<ChatResponse> = chatModel.stream(
            Prompt(prompt)
        )

        return response
    }
}