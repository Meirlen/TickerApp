package com.example.domain.exception

/**
 * Exception for app server errors
 */
open class ServerException(message: String) : RuntimeException(message)