    package practice.algorithm_practice_for_grammar_study

    import java.io.BufferedReader
    import java.io.BufferedWriter
    import java.io.InputStreamReader
    import java.io.OutputStreamWriter
    import java.util.StringTokenizer

    interface Student {
        val number:Int
        fun action(array: Array<Int>)
    }
    fun main() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        // 문제 입력부
        val n = br.readLine().toInt()
        var st = StringTokenizer(br.readLine(), " ")
        val array:Array<Int> = Array(n){0}

        for (i in 0..<n) array[i] = st.nextToken().toInt()

        val number = br.readLine().toInt()

        val students:Array<Student> = Array(number){i ->
            st = StringTokenizer(br.readLine(), " ")
            createStudent(st.nextToken().toInt(), st.nextToken().toInt())
        }

        for (stu in students) stu.action(array)

        val result = StringBuilder()
        var sb = StringBuilder()
        for (i in array) {
            sb.append("$i ")
            if (sb.length==40) {
                result.append(sb)
                    .appendLine()
                ;
                sb=StringBuilder()
            }
        }
        result.append(sb)
        bw.write(result.toString())

        br.close()
        bw.flush()
        bw.close()
    }



    class Girl(override val number: Int) : Student{
        override fun action(array: Array<Int>) {
            var index = 0
            val number = this.number-1
            while (true) {
                if (number-index > 0 && number+index < array.size -1) {
                    if (array[number-index-1]==array[number+index+1]){
                        index++;
                    } else {
                        break
                    }
                } else {
                    break
                }
            }
            for (i in number-index..number+index) {
                array[i] = if (array[i]==0) 1 else 0
            }
        }
    }
    class Boy(override val number: Int) : Student{
        override fun action(array: Array<Int>) {
            for (i in array.indices) {
                if ((i+1)%number==0){
                    array[i] = if (array[i]==0) 1 else 0
                }
            }
        }
    }

    fun createStudent(int: Int, number: Int) : Student {
        return when(int) {
            1 -> Boy(number)
            2 -> Girl(number)
            else -> throw RuntimeException("제 3의 성별은 정의되지 않은 문제이다")
        }
    }

