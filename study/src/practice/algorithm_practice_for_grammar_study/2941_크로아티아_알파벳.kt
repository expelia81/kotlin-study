package practice.algorithm_practice_for_grammar_study
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashSet

fun main() {
    val br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bw: BufferedWriter = BufferedWriter(OutputStreamWriter(System.out))

    var s = br.readLine()

    var set = HashSet<String>()

    set.add("c=")
    set.add("c-")
//    set.add("dz=")
    set.add("d-")
    set.add("lj")
    set.add("nj")
    set.add("s=")
    set.add("z=")


    while (s.contains("dz=")) {
        s = s.replace("dz=","#")
    }

    set.forEach {
        while (s.contains(it)) {
            s = s.replace(it,"#")
        }
    }

    bw.write(s.length.toString())


    /**
     * č	c=
     * ć	c-
     * dž	dz=
     * đ	d-
     * lj	lj
     * nj	nj
     * š	s=
     * ž	z=
     */

    bw.flush()
    br.close()
    bw.close()
}