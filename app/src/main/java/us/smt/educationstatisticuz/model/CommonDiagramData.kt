package us.smt.educationstatisticuz.model

data class CommonDiagramData<T>(
    val title: String,
    val types: Map<String, List<T>>
)
