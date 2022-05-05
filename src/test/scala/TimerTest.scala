import java.util.{Date, Timer, TimerTask}

/**
 *
 * @Author wangjia
 * @Date 2022/4/29 
 */
object TimerTest {


  def main(args: Array[String]): Unit = {

    val timer = new Timer
    timer.scheduleAtFixedRate(new TimerTask() {
      override def run(): Unit = {
        System.out.println("wsssssss")
      }
    }, new Date, 1000 * 10l)


  }

}
