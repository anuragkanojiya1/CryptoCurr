package com.example.cryptocurr.domain.repository

import com.example.cryptocurr.data.remote.dto.CoinDetailDto
import com.example.cryptocurr.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}