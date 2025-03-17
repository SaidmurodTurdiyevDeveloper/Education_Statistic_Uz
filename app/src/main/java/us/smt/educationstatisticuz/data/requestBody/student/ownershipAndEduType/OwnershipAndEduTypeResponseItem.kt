package us.smt.educationstatisticuz.data.requestBody.student.ownershipAndEduType

data class OwnershipAndEduTypeResponseItem(
    val bachelorCount: Int,
    val masterCount: Int,
    val ordinaturaCount: Int,
    val ownership: String
)