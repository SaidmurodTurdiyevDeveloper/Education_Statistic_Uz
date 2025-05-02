package us.smt.educationstatisticuz.presintation.screens.oliy_talim.otm_tab

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import us.smt.educationstatisticuz.model.University
import javax.inject.Inject

@HiltViewModel
class OliyTalimOtmViewModel @Inject constructor() : ViewModel() {
    var universities = mutableStateListOf(
        University("Acharya University", "Nodavlat", "www.acharya.uz", "student.acharya.uz"),
        University(
            "Affraganus University",
            "Nodavlat",
            "affraganusuniversity.uz",
            "student.affraganusuniversity.uz"
        ),
        University("Amerika texnologiyalar universiteti", "Nodavlat", "", ""),
        University(
            "Andijon davlat chet tillari instituti",
            "Davlat",
            "adchti.uz",
            "student.adchti.uz"
        ),
        University("Andijon davlat pedagogika instituti", "Davlat", "adpi.uz", "student.adpi.uz"),
        University("Andijon davlat tibbiyot instituti", "Davlat", "adti.uz", "student.adti.uz"),
        University("Andijon davlat universiteti", "Davlat", "adu.uz", "student.adu.uz"),
        University(
            "Andijon iqtisodiyot va qurilish instituti",
            "Davlat",
            "edualqi.uz",
            "student.edualqi.uz"
        ),
        University(
            "Andijon qishloq xo‘jaligi va agrotexnologiyalar instituti",
            "Davlat",
            "andqxai.uz",
            "student.andqxai.uz"
        ),
        University("Angren universiteti", "Nodavlat", "auniver.uz", "student.auniver.uz")
    )
}