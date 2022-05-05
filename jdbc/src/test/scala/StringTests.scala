import org.junit.Assert
import org.springframework.util.StringUtils

/**
 *
 * @Author wangjia
 * @Date 2022/5/5 
 */
object StringTests {
  def main(args: Array[String]): Unit = {
    var sink = new StringBuilder()
//    sink.append("test001test002test003")
   /* val source_array = Array[String]("test001","test002","test003")
    System.err.println("sink:" + sink)
    for (source <- source_array) {
      System.err.println("source:" + source)

      System.err.println(sink.toString().contains(source))
      System.err.println("[123]".contains("1"))

//      Assert.assertTrue(sink.contains(source))
    }*/

//    System.err.println(StringUtils.isEmpty(sink))
    System.err.println(isBlank(sink))






  }


  def isBlank(cs: CharSequence): Boolean = {
    var strLen = 0
    if (cs == null || (strLen = cs.length) == 0) return true
    for (i <- 0 until strLen) {
      if (!Character.isWhitespace(cs.charAt(i))) return false
    }
    true
  }


}
