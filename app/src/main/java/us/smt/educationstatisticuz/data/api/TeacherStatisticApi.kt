package us.smt.educationstatisticuz.data.api

import retrofit2.http.GET
import us.smt.educationstatisticuz.data.requestBody.teacher.ownershipAndAcademicDegree.OwnershipAndAcademicDegreeResponseItem
import us.smt.educationstatisticuz.data.requestBody.teacher.ownershipAndAcademicRank.OwnershipAndAcademicRankResponseItem
import us.smt.educationstatisticuz.data.requestBody.teacher.ownershipAndGender.OwnershipAndGenderResponseItem

interface TeacherStatisticApi {
    @GET("statistic/common/teacher/ownershipAndAcademicDegree")
    suspend fun ownershipAndAcademicDegree(): List<OwnershipAndAcademicDegreeResponseItem?>?

    @GET("statistic/common/teacher/ownershipAndAcademicRank")
    suspend fun ownershipAndAcademicRank(): List<OwnershipAndAcademicRankResponseItem?>?

    @GET("statistic/common/teacher/ownershipAndGender")
    suspend fun ownershipAndGender(): List<OwnershipAndGenderResponseItem?>?

    @GET("teacher/statistic/gender")
    suspend fun gender(): List<OwnershipAndGenderResponseItem?>?
}