package us.smt.educationstatisticuz.data.requestBody.teacher.ownershipAndAcademicRank

data class OwnershipAndAcademicRankResponseItem(
    val dotsentCount: Int,
    val ownership: String,
    val professorCount: Int,
    val seniorResearcherCount: Int,
    val withoutRankCount: Int
)