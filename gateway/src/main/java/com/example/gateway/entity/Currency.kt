package com.example.gateway.entity

data class Currency(
    val available_supply: String,
    val id: String,
    val last_updated: String,
    val market_cap_usd: String,
    val max_supply: String,
    val name: String,
    val percent_change_1h: String,
    val percent_change_24h: String,
    val percent_change_7d: String,
    val price_btc: String,
    val price_usd: String,
    val rank: String,
    val symbol: String,
    val total_supply: String
)