import scala.io.Source

/**
 *
 * @Author wangjia
 * @Date 2022/4/22 
 */
object Sour {
  def main(args: Array[String]): Unit = {

    val source1 = Source.fromFile("/Users/haizhi/IdeaProjects/springBoot/src/main/resources/person.txt")
    val response = try source1.mkString finally source1.close()
//    response.
    println(response)


  }

}
