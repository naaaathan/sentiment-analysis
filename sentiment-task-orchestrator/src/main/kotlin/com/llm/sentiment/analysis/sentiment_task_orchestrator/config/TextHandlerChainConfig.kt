package com.llm.sentiment.analysis.sentiment_task_orchestrator.config

import com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers.TextHandlerChain
import com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers.TextProcessorHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TextHandlerChainConfig {

    @Bean
    fun textHandlerChain(textHandlerList: List<TextProcessorHandler>): TextHandlerChain {

        if(textHandlerList.isEmpty()) {
            throw IllegalStateException("No TextProcessorHandler beans found in the application context")
        }

        for(i in 0 until textHandlerList.size - 1) {
            textHandlerList[i].setNextHandler(textHandlerList[i + 1])
        }

        return TextHandlerChain(textHandlerList[0])

    }

}