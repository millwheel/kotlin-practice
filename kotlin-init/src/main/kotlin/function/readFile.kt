package function

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun readFile() {
    // 코틀린은 checked exception이 없고 모두 unchecked exception으로 간주한다.
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}