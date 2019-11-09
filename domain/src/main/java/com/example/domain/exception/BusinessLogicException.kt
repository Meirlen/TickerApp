package com.example.domain.exception

/**
 * Exception for app business logic errors
 */
open class BusinessLogicException(val title:String,message: String) : RuntimeException(message)