package com.llm.sentiment.analysis.sentiment_llm_engine

import org.springframework.ai.chat.model.ChatResponse
import org.springframework.ai.chat.prompt.Prompt
import org.springframework.ai.openai.OpenAiChatModel
import org.springframework.ai.openai.OpenAiChatOptions
import org.springframework.ai.openai.api.OpenAiApi
import reactor.core.publisher.Flux

abstract class AbstractPromptModelCall {

    fun callModel(inputText: String): Flux<ChatResponse> {

        val openAiApi = OpenAiApi(System.getenv("OPENAI_API_KEY"));

        val openAiChatOptions = OpenAiChatOptions.builder()
            .withModel("gpt-3.5-turbo")
            .withTemperature(0.4)
            .withMaxTokens(5)
            .build();

        val chatModel = OpenAiChatModel(openAiApi, openAiChatOptions)

        val prompt = getPrompt(inputText)

        val response: Flux<ChatResponse> = chatModel.stream(
            Prompt(prompt)
        )
        return response

    }

    abstract fun getPrompt(inputText: String): String

}