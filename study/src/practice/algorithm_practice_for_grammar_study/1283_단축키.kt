package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    var alphabets = Array(26){false}

    for (turn in 0..<n) {
        var str = br.readLine()
        var index : Int? = null
        out@do {
            for (lan in str.split(" ")){
                var lanIndex = lan[0].code - 'a'.code
                if (lanIndex < 0) lanIndex += 32
                if (!alphabets[lanIndex]) {
                    index = lanIndex
                    str = str.replaceFirst(lan, lan.replaceFirst(lan.get(0).toString(), "[${lan.get(0)}]"))
                    break@out
                }
            }
            for (char in str) {
              if (char == ' ') continue
              var charIndex = char.code - 'a'.code
                if (charIndex <0) charIndex += 32
              if (!alphabets[charIndex]) {
                  index = charIndex
                  str = str.replaceFirst(char.toString(), "[$char]")
                  break@out
              }
            }
        } while (false)
        if(index != null) alphabets[index] = true
        bw.write("$str\n")
    }





    bw.flush()
    br.close()
    bw.close()
}

fun calc(start:Long, end: Long) = (end*(end+1))/2 - (start*(start+1))/2
fun calc(end:Long) = (end*(end+1))/2