import arrays.getStudentName
import booleans.lampuLaluLintas
import ints.matematika
import strings.stringToChar
import strings.truncateString
import tutorial.testSoal
import kotlin.test.Test
import kotlin.test.assertEquals


class Main {

    @Test
    fun `Mengambil nama siswa`() {
        val resultExpected = "Joko"
        val studentList = arrayOf(
            "Mamang",
            "Sumanggimang",
            "Mafdhil",
            "Joko",
            "Sujoko",
            "Sumamang",
            "Sangmamang",
            "Siamang"
        )
        val resultActual =
            getStudentName(studentList)

        assertEquals(resultExpected, resultActual)
    }


    @Test
    fun `Mengambil 'r'`() {
        val resultExpected = "r"
        val word = "chargoggagoggmanchauggagoggchaubunagungamaugg"

        val resultActual = stringToChar(word)

        assertEquals(resultExpected, resultActual)

    }

    @Test
    fun `Hitung Matematika`() {

        val expectedAnswers = listOf(
            11,
            68,
            900,
            3,
            3000
        )

        val actualAnswers = mutableListOf<Int>()

        val mathQuestions = listOf(
            MathQuestion(1, 10, "tambah"),
            MathQuestion(78, 10, "kurang"),
            MathQuestion(90, 10, "kali"),
            MathQuestion(30, 10, "bagi"),
            MathQuestion(60, 50, "kali"),
        )

        mathQuestions.forEach { question ->
            actualAnswers.add(matematika(question.nilaiA, question.nilaiB, question.operasiMatematika))
        }

        assertEquals(expectedAnswers, actualAnswers)
    }

    @Test
    fun `Koreksi lampu lalu lintas`() {

        val lampState = listOf(
            "Merah", "Kuning", "Hijau", "Ungu"
        )

        val resultsExpected = listOf(
            "Berhenti", "Bersiap", "Jalan"
        )

        val actualResults = mutableListOf<String>()

        lampState.forEach { color ->
            try {
                actualResults.add(lampuLaluLintas(color))
            } catch (e: Exception) {
                println("Warna tidak dikenal terlewat")
            }
        }

        resultsExpected.map { it.lowercase() }
        actualResults.map { it.lowercase() }


        assertEquals(resultsExpected, actualResults)
    }

    @Test
    fun `Menyatukan String`() {
        val str1 = "Mamang"
        val str2 = "Sumamang"
        val expected = "Mamang Sumamang"
        val actual = truncateString(str1, str2)

        assertEquals(expected, actual)
    }

    @Test
    fun belanjaanBudi() {
        val budisMoney = 5000
        val expectedResult = 1000
        val actualResult = testSoal(budisMoney)

        assertEquals(expectedResult, actualResult)
    }

}

data class MathQuestion(
    val nilaiA: Int,
    val nilaiB: Int,
    val operasiMatematika: String
)