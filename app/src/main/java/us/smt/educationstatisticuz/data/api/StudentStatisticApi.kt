package us.smt.educationstatisticuz.data.api

import retrofit2.http.GET
import us.smt.educationstatisticuz.data.requestBody.student.eduTypeAndGender.EduTypeAndGenderResponseItem
import us.smt.educationstatisticuz.data.requestBody.student.ownership.OwnerShipResponseItem
import us.smt.educationstatisticuz.data.requestBody.student.ownershipAndCourse.OwnershipAndCourseResponseItem
import us.smt.educationstatisticuz.data.requestBody.student.ownershipAndEduForm.OwnershipAndEduFormResponseItem
import us.smt.educationstatisticuz.data.requestBody.student.ownershipAndEduType.OwnershipAndEduTypeResponseItem
import us.smt.educationstatisticuz.data.requestBody.student.ownershipAndGender.OwnershipAndGenderResponseItem
import us.smt.educationstatisticuz.data.requestBody.student.ownershipAndPaymentType.OwnershipAndPaymentTypeResponseItem
import us.smt.educationstatisticuz.data.requestBody.student.studentAddress.StudentAddressResponseItem
import us.smt.educationstatisticuz.data.requestBody.student.topFiveUniversity.TopFiveUniversityResponseItem
import us.smt.educationstatisticuz.data.requestBody.student.universityAddress.UniversityAddressResponseItem

interface StudentStatisticApi {
    @GET("statistic/common/student/ownershipAndGender")
    suspend fun ownershipAndGender(): List<OwnershipAndGenderResponseItem?>?

    @GET("statistic/common/student/ownershipAndEduType")
    suspend fun ownershipAndEduType(): List<OwnershipAndEduTypeResponseItem?>?

    @GET("statistic/common/student/ownershipAndCourse")
    suspend fun ownershipAndCourse(): List<OwnershipAndCourseResponseItem?>?

    @GET("statistic/common/student/ownershipAndPaymentType")
    suspend fun ownershipAndPaymentType(): List<OwnershipAndPaymentTypeResponseItem?>?

    @GET("statistic/common/student/ownershipAndEduForm")
    suspend fun ownershipAndEduForm(): List<OwnershipAndEduFormResponseItem?>?

    @GET("statistic/common/student/ownership")
    suspend fun ownership(): List<OwnerShipResponseItem?>?

    @GET("statistic/common/student/topFiveUniversity")
    suspend fun topFiveUniversity(): List<TopFiveUniversityResponseItem?>?

    @GET("statistic/common/student/studentAddress")
    suspend fun studentAddress(): List<StudentAddressResponseItem?>?

    @GET("statistic/common/student/universityAddress")
    suspend fun universityAddress(): List<UniversityAddressResponseItem?>?

    @GET("student/statistic/eduType/eduTypeAndGender")
    suspend fun eduTypeAndGender(): List<EduTypeAndGenderResponseItem?>?

}