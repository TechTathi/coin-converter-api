package com.api.CoinConverter.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val erro = ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            errors = null

        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }
}