package com.example.nytimesarticle.business.utils.errorHandler

import retrofit2.Response

sealed class Results<out T: Any>{
    data class Success<out T : Any>(val data: T) : Results<T>()
    data class Error(val exception: String) : Results<Nothing>()

    suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Results<T> {
        return try {
            val myResp = call.invoke()
            if (myResp.isSuccessful) {
                Results.Success(myResp.body()!!)
            } else {

//
//                handle standard error codes
//                if (myResp.code() == 403){
//                    Log.i("responseCode","Authentication failed")
//                }
//                .
//                .
//                .
//                 */

                Results.Error(myResp.errorBody()?.string() ?: "Something goes wrong")
            }

        } catch (e: Exception) {
            Results.Error(e.message ?: "Internet error runs")
        }
    }
}
