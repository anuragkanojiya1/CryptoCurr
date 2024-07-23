package com.example.cryptocurr.domain.use_case.get_coin

import com.example.cryptocurr.common.Resource
import com.example.cryptocurr.data.remote.dto.CoinDetailDto
import com.example.cryptocurr.data.remote.dto.toCoin
import com.example.cryptocurr.data.remote.dto.toCoinDetail
import com.example.cryptocurr.domain.model.Coin
import com.example.cryptocurr.domain.model.CoinDetail
import com.example.cryptocurr.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e:IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}