package us.smt.educationstatisticuz.data.requestBody.teacher.ownershipAndAcademicDegree

data class OwnershipAndAcademicDegreeResponseItem(
    val ownership: String,
    val scienceCandidateCount: Int,
    val scienceDoctorCount: Int,
    val withoutDegreeCount: Int
)