package us.smt.educationstatisticuz.data.requestBody.teacher.ownershipAndGender

data class OwnershipAndGenderResponseItem(
    val femaleCount: Int,
    val maleCount: Int,
    val ownership: String
)