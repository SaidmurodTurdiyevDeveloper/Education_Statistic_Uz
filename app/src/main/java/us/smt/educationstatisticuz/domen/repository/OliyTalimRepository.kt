package us.smt.educationstatisticuz.domen.repository

import kotlinx.coroutines.flow.Flow
import us.smt.educationstatisticuz.model.CommonDiagramData

interface OliyTalimRepository {
    fun loadHomeStudentStatistic(): Flow<List<CommonDiagramData>>

    fun loadTeacherStatistic(): Flow<List<CommonDiagramData>>
}