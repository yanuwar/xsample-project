package com.skyshi.story.storypage.networking

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.skyshi.story.storypage.exception.AuthenticationException
import com.skyshi.story.storypage.exception.BadRequestException
import com.skyshi.story.storypage.exception.ErrorConnectionException
import com.skyshi.story.storypage.exception.ErrorMaintenanceException
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorInterceptor(private val netManager: NetManager) : Interceptor {
    private var response: Response? = null
    private var responseBody: String? = null
    private var responseJson: JsonObject? = null

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!netManager.isConnectedToInternet) throw ErrorConnectionException()

        try {
            response = chain.proceed(chain.request())

            val isMaintenance: Boolean? = response?.header("maintenance-status")?.toBoolean()
            val isMaintenance2: Boolean? = response?.header("Maintenance-Status")?.toBoolean()
            if (isMaintenance == true || isMaintenance2 == true) throw ErrorMaintenanceException()

            responseBody = response!!.body()!!.string()
            responseJson = JsonParser().parse(responseBody).asJsonObject

        } catch (e: Exception) {
            if (e is ErrorMaintenanceException) throw e
            if (e is UnknownHostException) throw ErrorConnectionException()
            if (e is SocketTimeoutException) throw ErrorConnectionException("Connection Timeout")
        }

        if (!response!!.isSuccessful) {
            val errorMessage = parseErrorMessage(responseJson)

            if (response!!.code() >= HttpURLConnection.HTTP_INTERNAL_ERROR)
                throw ErrorConnectionException("Oops, Internal Server Error")

            if (response!!.code() >= HttpURLConnection.HTTP_BAD_REQUEST)
                throw BadRequestException(responseJson?:JsonObject(), errorMessage)

            if (response!!.code() == HttpURLConnection.HTTP_FORBIDDEN || response!!.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
//                EventBus.getDefault().post(AuthenticationException(errorMessage))
                throw AuthenticationException(errorMessage.toString())
            }
            throw RuntimeException(errorMessage)
        }
        return response!!
                .newBuilder()
                .body(ResponseBody.create(response!!.body()!!.contentType(), responseBody!!))
                .build()
    }

    //Parsing For Error Message
    private fun parseErrorMessage(jsonObject: JsonObject?): String? {
        return jsonObject?.get("message")?.asString
    }
}