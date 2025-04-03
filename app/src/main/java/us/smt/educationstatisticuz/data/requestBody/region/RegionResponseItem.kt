package us.smt.educationstatisticuz.data.requestBody.region

data class RegionResponseItem(
    val code: String,
    val country_id: Int,
    val id: Int,
    val name_en: String,
    val name_uz: String
)