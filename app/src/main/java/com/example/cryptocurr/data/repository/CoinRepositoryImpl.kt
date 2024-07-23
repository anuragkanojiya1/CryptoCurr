package com.example.cryptocurr.data.repository

import com.example.cryptocurr.data.remote.dto.CoinDetailDto
import com.example.cryptocurr.data.remote.dto.CoinDto
import com.example.cryptocurr.data.remote.dto.CoinPaprikaApi
import com.example.cryptocurr.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
            return api.getCoinById(coinId)
    }
}