package us.smt.educationstatisticuz.data.api

import retrofit2.http.GET
import us.smt.educationstatisticuz.data.requestBody.unviversity.UniversityTypeResponseItem

interface UniversityStatisticApi {
    @GET("statistic/common/university/universityType")
    suspend fun universityType(): List<UniversityTypeResponseItem?>?
}