package us.smt.educationstatisticuz.data.requestBody.student.ownershipAndEduForm

data class OwnershipAndEduFormResponseItem(
    val daytimeCount: Int,
    val eveningCount: Int,
    val externalCount: Int,
    val jointCount: Int,
    val ownership: String,
    val remoteCount: Int,
    val secondDaytimeCount: Int,
    val secondEveningCount: Int,
    val secondExternalCount: Int,
    val specialExternalCount: Int
)