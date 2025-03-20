package us.smt.educationstatisticuz.data.api

import retrofit2.http.GET
import us.smt.educationstatisticuz.data.requestBody.region.RegionResponseItem
import us.smt.educationstatisticuz.data.requestBody.region_university.RegionUniversityResponseItem

interface RegionApi {
    @GET("api/v2/classifier/basic/region/")
    suspend fun region(): List<RegionResponseItem?>?

    @GET("api/v2/integration/stat/public/university?limit=10000")
    suspend fun university(): List<RegionUniversityResponseItem?>?
}