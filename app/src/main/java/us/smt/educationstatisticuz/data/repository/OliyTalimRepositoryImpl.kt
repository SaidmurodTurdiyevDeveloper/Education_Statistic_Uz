package us.smt.educationstatisticuz.data.repository

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import us.smt.educationstatisticuz.data.api.StudentStatisticApi
import us.smt.educationstatisticuz.domen.repository.OliyTalimRepository
import us.smt.educationstatisticuz.model.CommonDiagramData
import us.smt.educationstatisticuz.model.DiagramDataWithColor
import us.smt.educationstatisticuz.model.DiagramType
import us.smt.educationstatisticuz.ui.getRandomComposeColor
import javax.inject.Inject
import javax.inject.Singleton


class OliyTalimRepositoryImpl @Inject constructor(
    private val api: StudentStatisticApi
) : OliyTalimRepository {
    private var ls = ArrayList<CommonDiagramData>()
    override fun loadHomeStudentStatistic(): Flow<List<CommonDiagramData>> = flow {
        ls = ArrayList()

        val resultOwnershipAndGender = api.ownershipAndGender()
        if (resultOwnershipAndGender != null) {
            var map = HashMap<String, List<DiagramDataWithColor>>()
            val allFemale = resultOwnershipAndGender.filterNotNull().sumOf {
                it.femaleCount
            }
            val allMale = resultOwnershipAndGender.filterNotNull().sumOf {
                it.maleCount
            }

            map["Jami"] = listOf(
                DiagramDataWithColor(
                    value = allMale,
                    name = "Erkaklar",
                    color = Color(0xFF4DA2F1)
                ),
                DiagramDataWithColor(
                    value = allFemale,
                    name = "Ayollar",
                    color = Color(0xFFFF6482)
                )
            )
            resultOwnershipAndGender.filterNotNull().forEach {
                map[it.ownership] = listOf(
                    DiagramDataWithColor(
                        value = it.maleCount,
                        name = "Erkaklar",
                        color = Color(0xFF4DA2F1)
                    ),
                    DiagramDataWithColor(
                        value = it.femaleCount,
                        name = "Ayollar",
                        color = Color(0xFFFF6482)
                    )
                )
            }
            ls.add(
                CommonDiagramData(
                    title = "Talabalar soni jins kesimida",
                    type = DiagramType.CIRCULAR,
                    color = getRandomComposeColor(),
                    paddingStart = 0,
                    count = 0,
                    types = map
                )
            )
        }

        val resultOwnershipAndEduType = api.ownershipAndEduType()
        if (resultOwnershipAndEduType != null) {
            var map = HashMap<String, List<DiagramDataWithColor>>()
            val allBachelor = resultOwnershipAndEduType.filterNotNull().sumOf {
                it.bachelorCount
            }
            val allMaster = resultOwnershipAndEduType.filterNotNull().sumOf {
                it.masterCount
            }
            val allOrdinatura = resultOwnershipAndEduType.filterNotNull().sumOf {
                it.ordinaturaCount
            }

            map["Jami"] = listOf(
                DiagramDataWithColor(
                    value = allBachelor,
                    name = "Bakalavr",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allMaster,
                    name = "Magistratura",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allOrdinatura,
                    name = "Ordinatura",
                    color = Color.Green
                )
            )
            resultOwnershipAndEduType.filterNotNull().forEach {
                map[it.ownership] = listOf(
                    DiagramDataWithColor(
                        value = it.bachelorCount,
                        name = "Bakalavr",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.masterCount,
                        name = "Magistratura",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.ordinaturaCount,
                        name = "Ordinatura",
                        color = Color.Green
                    )
                )
            }
            ls.add(
                CommonDiagramData(
                    title = "Talabalar soni ta'lim turi kesimida",
                    type = DiagramType.VERTICAL,
                    color = Color(0xFFA1DD75),
                    paddingStart = 64,
                    count = 5,
                    types = map
                )
            )
        }

        val resultOwnershipAndCourse = api.ownershipAndCourse()
        if (resultOwnershipAndCourse != null) {
            var map = HashMap<String, List<DiagramDataWithColor>>()
            val allCourse1Count = resultOwnershipAndCourse.filterNotNull().sumOf {
                it.course1Count
            }
            val allCourse2Count = resultOwnershipAndCourse.filterNotNull().sumOf {
                it.course2Count
            }
            val allCourse3Count = resultOwnershipAndCourse.filterNotNull().sumOf {
                it.course3Count
            }
            val allCourse4Count = resultOwnershipAndCourse.filterNotNull().sumOf {
                it.course4Count
            }
            val allCourse5Count = resultOwnershipAndCourse.filterNotNull().sumOf {
                it.course5Count
            }
            val allCourse6Count = resultOwnershipAndCourse.filterNotNull().sumOf {
                it.course6Count
            }

            map["Jami"] = listOf(
                DiagramDataWithColor(
                    value = allCourse1Count,
                    name = "1-Kurs",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allCourse2Count,
                    name = "2-Kurs",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allCourse3Count,
                    name = "3-Kurs",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allCourse4Count,
                    name = "4-Kurs",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allCourse5Count,
                    name = "5-Kurs",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allCourse6Count,
                    name = "6-Kurs",
                    color = Color.Green
                )
            )
            resultOwnershipAndCourse.filterNotNull().forEach {
                map[it.ownership] = listOf(
                    DiagramDataWithColor(
                        value = it.course1Count,
                        name = "1-Kurs",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.course2Count,
                        name = "2-Kurs",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.course3Count,
                        name = "3-Kurs",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.course4Count,
                        name = "4-Kurs",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.course5Count,
                        name = "5-Kurs",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.course6Count,
                        name = "6-Kurs",
                        color = Color.Green
                    )
                )
            }
            ls.add(
                CommonDiagramData(
                    title = "Talabalar soni kurslar kesimida",
                    type = DiagramType.VERTICAL,
                    color = Color(0xFFA1DD75),
                    paddingStart = 64,
                    count = 5,
                    types = map
                )
            )
        }

        val resultOwnershipAndPaymentType = api.ownershipAndPaymentType()
        if (resultOwnershipAndPaymentType != null) {
            var map = HashMap<String, List<DiagramDataWithColor>>()
            val allContractCount = resultOwnershipAndPaymentType.filterNotNull().sumOf {
                it.contractCount
            }
            val allGrandCount = resultOwnershipAndPaymentType.filterNotNull().sumOf {
                it.grandCount
            }


            map["Jami"] = listOf(
                DiagramDataWithColor(
                    value = allGrandCount,
                    name = "Davlat granti",
                    color = Color(0xFF4DA2F1)
                ),
                DiagramDataWithColor(
                    value = allContractCount,
                    name = "Tolov kantrakti",
                    color = Color(0xFFFF6482)
                )
            )
            resultOwnershipAndPaymentType.filterNotNull().forEach {
                map[it.ownership] = listOf(
                    DiagramDataWithColor(
                        value = it.grandCount,
                        name = "Davlat granti",
                        color = Color(0xFF4DA2F1)
                    ),
                    DiagramDataWithColor(
                        value = it.contractCount,
                        name = "Tolov kantrakti",
                        color = Color(0xFFFF6482)
                    )
                )
            }
            ls.add(
                CommonDiagramData(
                    title = "Talabalar soni to'lov shakli kesimida",
                    type = DiagramType.CIRCULAR,
                    color = Color(0xFFA1DD75),
                    paddingStart = 64,
                    count = 5,
                    types = map
                )
            )
        }


        val resultOwnershipAndEduForm = api.ownershipAndEduForm()
        if (resultOwnershipAndEduForm != null) {
            var map = HashMap<String, List<DiagramDataWithColor>>()
            val allExternalCount = resultOwnershipAndEduForm.filterNotNull().sumOf {
                it.externalCount
            }
            val allDaytimeCount = resultOwnershipAndEduForm.filterNotNull().sumOf {
                it.daytimeCount
            }
            val allEveningCount = resultOwnershipAndEduForm.filterNotNull().sumOf {
                it.eveningCount
            }
            val allJointCount = resultOwnershipAndEduForm.filterNotNull().sumOf {
                it.jointCount
            }

            val allRemoteCount = resultOwnershipAndEduForm.filterNotNull().sumOf {
                it.remoteCount
            }
            val allSecondDaytimeCount = resultOwnershipAndEduForm.filterNotNull().sumOf {
                it.secondDaytimeCount
            }
            val allSecondEveningCount = resultOwnershipAndEduForm.filterNotNull().sumOf {
                it.secondEveningCount
            }
            val allSecondExternalCount = resultOwnershipAndEduForm.filterNotNull().sumOf {
                it.secondExternalCount
            }
            val allSpecialExternalCount = resultOwnershipAndEduForm.filterNotNull().sumOf {
                it.specialExternalCount
            }

            map["Jami"] = listOf(
                DiagramDataWithColor(
                    value = allExternalCount,
                    name = "Sirtqi",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allJointCount,
                    name = "Qo'shma",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allSpecialExternalCount,
                    name = "Maxsus sirtqi",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allRemoteCount,
                    name = "Masofaviy",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allDaytimeCount,
                    name = "Kunduzgi",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allEveningCount,
                    name = "Kechki",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allSecondExternalCount,
                    name = "Ikkinchi oliy(Sirtqi)",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allSecondDaytimeCount,
                    name = "Ikkinchi oliy(Kunduzgi)",
                    color = Color.Green
                ),
                DiagramDataWithColor(
                    value = allSecondEveningCount,
                    name = "Ikkinchi oliy(Kechki)",
                    color = Color.Green
                )
            )
            resultOwnershipAndEduForm.filterNotNull().forEach {
                map[it.ownership] = listOf(
                    DiagramDataWithColor(
                        value = it.externalCount,
                        name = "Sirtqi",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.jointCount,
                        name = "Qo'shma",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.specialExternalCount,
                        name = "Maxsus sirtqi",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.remoteCount,
                        name = "Masofaviy",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.daytimeCount,
                        name = "Kunduzgi",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.eveningCount,
                        name = "Kechki",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.secondExternalCount,
                        name = "Ikkinchi oliy(Sirtqi)",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.secondDaytimeCount,
                        name = "Ikkinchi oliy(Kunduzgi)",
                        color = Color.Green
                    ),
                    DiagramDataWithColor(
                        value = it.secondEveningCount,
                        name = "Ikkinchi oliy(Kechki)",
                        color = Color.Green
                    )
                )
            }
            ls.add(
                CommonDiagramData(
                    title = "Talabalar soni kurslar kesimida",
                    type = DiagramType.VERTICAL,
                    color = Color(0xFFA1DD75),
                    paddingStart = 64,
                    count = 5,
                    types = map
                )
            )
        }

        emit(ls)
    }.catch {
        emit(ls)
    }

    override fun loadTeacherStatistic(): Flow<List<CommonDiagramData>> = flow {
    }

}